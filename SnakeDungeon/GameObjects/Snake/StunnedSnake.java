package De.SnailCode.SnakeDungeon.GameObjects.Snake;

import De.SnailCode.SnakeDungeon.GameObjects.Player;
import De.SnailCode.SnakeDungeon.Vector2;

public final class StunnedSnake extends Snake {
    public StunnedSnake(Vector2 oldPosition) {
        super(oldPosition);
    }

    @Override
    public void move(Player player) {}
}
