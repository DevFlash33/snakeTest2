package De.SnailCode.SnakeDungeon.Movements.MoveValidation;

import De.SnailCode.SnakeDungeon.GameObjects.GameObject;
import De.SnailCode.SnakeDungeon.Movements.IDirectionMovement;
import De.SnailCode.SnakeDungeon.Movements.MoveWest;

public final class MoveWestValidator extends ChainingMoveValidator {
    public MoveWestValidator(IMoveValidator parent) {
        super(parent);
    }
    public boolean isValid(GameObject gameObjectThatWantsToMove, IDirectionMovement desiredDirection) {
        final boolean cannotMove = gameObjectThatWantsToMove.getX() == 0 && desiredDirection instanceof MoveWest;
        return super.parent == null ?
                !cannotMove :
                !cannotMove && super.parent.isValid(gameObjectThatWantsToMove, desiredDirection);
    }
}
