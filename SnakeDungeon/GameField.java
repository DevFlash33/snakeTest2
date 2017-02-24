package De.SnailCode.SnakeDungeon;

import De.SnailCode.SnakeDungeon.Events.GameEventComponent;
import De.SnailCode.SnakeDungeon.Events.IGameEventListener;
import De.SnailCode.SnakeDungeon.FieldRenderer.BasicConsoleRenderer;
import De.SnailCode.SnakeDungeon.GameObjects.Coin;
import De.SnailCode.SnakeDungeon.GameObjects.Door;
import De.SnailCode.SnakeDungeon.GameObjects.GameObject;
import De.SnailCode.SnakeDungeon.GameObjects.Player;
import De.SnailCode.SnakeDungeon.GameObjects.Snake.MoveRandom;
import De.SnailCode.SnakeDungeon.GameObjects.Snake.Snake;
import De.SnailCode.SnakeDungeon.GameObjects.Traps.*;
import De.SnailCode.SnakeDungeon.FieldRenderer.ConsoleDotRenderer;
import De.SnailCode.SnakeDungeon.Movements.MoveMapper;
import De.SnailCode.SnakeDungeon.Movements.MoveValidation.MoveValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GameField implements IGameEventListener {
    public static final int Rows = 10;
    public static final int Columns = 40;

    private GameEventComponent eventComponent = new GameEventComponent();

    private BasicConsoleRenderer gameRenderer = new ConsoleDotRenderer();
    private List<GameObject> gameObjects = new ArrayList<>();

    private Player player = new Player(GameField.Rows, GameField.Columns);
    private PlayerCollision playerCollision = new PlayerCollision(this.player);
    private Door door = new Door(GameField.Rows, GameField.Columns);

    private List<Trap> traps = new ArrayList<>(Arrays.asList(new Trap(new StunTrapEffect(), GameField.Rows, GameField.Columns),
            new Trap(new FireTrapEffect(), GameField.Rows, GameField.Columns)));

    private List<Snake> snakes = new ArrayList<>(Arrays.asList(new Snake(GameField.Rows, GameField.Columns, new MoveRandom()),
            new Snake(GameField.Rows, GameField.Columns, new MoveRandom()), new Snake(GameField.Rows, GameField.Columns, new MoveRandom())));

    private List<Coin> coins = new ArrayList<>(Arrays.asList(new Coin(GameField.Rows, GameField.Columns),
            new Coin(GameField.Rows, GameField.Columns), new Coin(GameField.Rows, GameField.Columns)));

    public GameField(IGameEventListener gameEventListener) {
        this.updateRenderableObjects();
        this.eventComponent.addListener(gameEventListener);
        this.eventComponent.addListener(this);
    }

    public void update(char direction) {
        MoveValidator.instance().move(this.player, MoveMapper.instance().movement(direction));
        this.snakes.forEach(snake -> snake.move(this.player));
        this.handleEvents();
        this.updateRenderableObjects();
    }

    public void render() {
        for (int iRow = 0; iRow < GameField.Rows; iRow++) {
            for (int iColumn = 0; iColumn < GameField.Columns; iColumn++) {
                this.gameRenderer = this.gameRenderer.draw(new Vector2(iColumn, iRow), this.gameObjects);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
    }

    private void handleEvents() {
        this.playerCollision.onCollisionWithObjects(this.traps, trap -> eventComponent.notifyAll(trap, GameEvent.Trap_Activated));
        this.playerCollision.onCollisionWithObjects(this.coins, coin -> eventComponent.notifyAll(coin, GameEvent.Coin_Collected));
        this.playerCollision.onCollisionWithObjects(this.coins, coin -> eventComponent.notifyAll(coin, GameEvent.Coin_Collected));
        this.playerCollision.onCollisionWithObjects(this.snakes, snake -> this.eventComponent.notifyAll(snake, GameEvent.Snake_Killed_Player));

        // TODO(Mike) 24.02.2017: Ueberarbeiten
        this.playerCollision.onCollisionWithObject(this.door, door -> {
            if (this.player.collectedCoins() == 3) this.eventComponent.notifyAll(this.door, GameEvent.Player_All_Coins_Hit_Door);
            else this.eventComponent.notifyAll(this.door, GameEvent.Player_Not_All_Coins_Hit_Door);
        });
    }

    private void updateRenderableObjects() {
        this.gameObjects = new ArrayList<>();
        this.gameObjects.addAll(Arrays.asList(this.door, this.player));
        this.gameObjects.addAll(this.coins);
        this.traps.forEach(trap ->this.gameObjects.add(trap));
        this.snakes.forEach(snake -> this.gameObjects.add(snake));
    }

    @Override
    public void onNotify(GameObject objectThatTriggeredTheEvent, GameEvent event) {
        if (event == GameEvent.Player_Not_All_Coins_Hit_Door) {
            System.out.println("You shall not pass! You need to collect all coins first.");
            System.out.println();
        } else if (event == GameEvent.Coin_Collected) {
            this.player.collectCoin((Coin)objectThatTriggeredTheEvent);
            this.coins.remove(objectThatTriggeredTheEvent);
        } else if (event == GameEvent.Trap_Activated) {
            ((Trap)objectThatTriggeredTheEvent).activateTrap(this.snakes);
            this.traps.remove(objectThatTriggeredTheEvent);
        }
    }

    public List<Vector2> getCoinPositions() {
        return GameObjectUtil.getGameObjectPositions(this.coins);
    }

    public List<Vector2> getSnakePositions() {
        return GameObjectUtil.getGameObjectPositions(this.snakes);
    }

    public List<Vector2> getTrapPositions() {
        return GameObjectUtil.getGameObjectPositions(this.traps);
    }

    public Vector2 getDoorPosition() {
        return new Vector2(this.door.getPosition());
    }

}
