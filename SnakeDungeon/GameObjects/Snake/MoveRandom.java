package De.SnailCode.SnakeDungeon.GameObjects.Snake;

import De.SnailCode.SnakeDungeon.GameObjects.Player;
import De.SnailCode.SnakeDungeon.Movements.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public final class MoveRandom implements ISnakeMovement {
    private final static Random Random = new Random();

    private final Map<Integer, IDirectionMovement> snakeMovements = new HashMap<>();

    public MoveRandom() {
        this.snakeMovements.put(0, new MoveNorth());
        this.snakeMovements.put(1, new MoveSouth());
        this.snakeMovements.put(2, new MoveWest());
        this.snakeMovements.put(3, new MoveEast());
    }

    @Override
    public void move(Player player, Snake snake) {
        snake.move(this.snakeMovements.get(MoveRandom.Random.nextInt(4)));
    }
}
