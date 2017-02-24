package De.SnailCode.SnakeDungeon.Movements.MoveValidation;

import De.SnailCode.SnakeDungeon.GameObjects.GameObject;
import De.SnailCode.SnakeDungeon.Movements.IDirectionMovement;
import De.SnailCode.SnakeDungeon.Movements.MoveNorth;

public final class MoveNorthValidator extends ChainingMoveValidator {
    public MoveNorthValidator(IMoveValidator parent) {
        super(parent);
    }

    @Override
    public boolean isValid(GameObject gameObjectThatWantsToMove, IDirectionMovement desiredDirection) {
        final boolean cannotMove = gameObjectThatWantsToMove.getY() == 0 && desiredDirection instanceof MoveNorth;
        return super.parent == null ?
                !cannotMove :
                !cannotMove && super.parent.isValid(gameObjectThatWantsToMove, desiredDirection);
    }
}
