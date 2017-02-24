package De.SnailCode.SnakeDungeon.Movements;

import De.SnailCode.SnakeDungeon.GameObjects.GameObject;

public class MoveWest implements IDirectionMovement {
    @Override
    public void move(GameObject gameObject) {
        gameObject.moveWest();
    }
}
