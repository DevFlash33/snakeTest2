package De.SnailCode.SnakeDungeon.Movements;


import De.SnailCode.SnakeDungeon.GameObjects.GameObject;

public final class MoveEast implements IDirectionMovement {
    @Override
    public void move(GameObject gameObject) {
        gameObject.moveEast();
    }
}
