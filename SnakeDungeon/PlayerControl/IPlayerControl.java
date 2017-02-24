package De.SnailCode.SnakeDungeon.PlayerControl;

import De.SnailCode.SnakeDungeon.GameField;

public interface IPlayerControl {
    char generateDirection(GameField gameState);
}
