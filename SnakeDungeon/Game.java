package De.SnailCode.SnakeDungeon;

import De.SnailCode.SnakeDungeon.Events.IGameEventListener;
import De.SnailCode.SnakeDungeon.GameObjects.GameObject;
import De.SnailCode.SnakeDungeon.PlayerControl.IPlayerControl;
import De.SnailCode.SnakeDungeon.PlayerControl.UserControl;

public final class Game implements IGameEventListener {
    private boolean running = true;
    public void run() {
        final GameField gameField = new GameField(this);
        IPlayerControl playerControl = new UserControl();
        while (running) {
            gameField.render();
            gameField.update(playerControl.generateDirection(gameField));
        }
    }

    @Override
    public void onNotify(GameObject objectThatTriggeredTheEvent, GameEvent event) {
        if (event == GameEvent.Snake_Killed_Player) {
            System.out.println("The Snake killed you. Git gud scrub.");
            this.running = false;
        } else if (event == GameEvent.Player_All_Coins_Hit_Door) {
            System.out.println("Congratulations. You did it!");
            this.running = false;
        }
    }
}
