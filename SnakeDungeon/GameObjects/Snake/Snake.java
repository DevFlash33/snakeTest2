package De.SnailCode.SnakeDungeon.GameObjects.Snake;

import De.SnailCode.SnakeDungeon.GameObjects.Player;
import De.SnailCode.SnakeDungeon.GameObjects.GameObject;
import De.SnailCode.SnakeDungeon.Vector2;

public class Snake extends GameObject {
    private ISnakeMovement movement;

    public Snake(int rows, int columns, ISnakeMovement movement) {
        super('S', rows, columns);
        this.movement = movement;
    }

    protected Snake(Vector2 oldPosition) {
        super('S', oldPosition);
    }

    public void move(Player player) {
        this.movement.move(player, this);
    }
}
