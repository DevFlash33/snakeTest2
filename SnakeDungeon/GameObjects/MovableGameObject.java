package De.SnailCode.SnakeDungeon.GameObjects;

import De.SnailCode.SnakeDungeon.Movements.IDirectionMovement;
import De.SnailCode.SnakeDungeon.Movements.MoveValidation.MoveValidator;
import De.SnailCode.SnakeDungeon.Vector2;

public class MovableGameObject extends GameObject {
    public MovableGameObject(char symbol, int maxRandomX, int maxRandomY) {
        super(symbol, maxRandomX, maxRandomY);
    }

    public MovableGameObject(char symbol, Vector2 position) {
        super(symbol, position);
    }

    public void move(IDirectionMovement direction) {
        MoveValidator.instance().move(this, direction);
    }
}
