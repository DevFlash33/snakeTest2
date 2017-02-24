package De.SnailCode.SnakeDungeon.Movements.MoveValidation;

import De.SnailCode.SnakeDungeon.GameField;
import De.SnailCode.SnakeDungeon.GameObjects.GameObject;
import De.SnailCode.SnakeDungeon.Movements.IDirectionMovement;
import De.SnailCode.SnakeDungeon.Movements.MoveEast;

public final class MoveEastValidator extends ChainingMoveValidator {
    public MoveEastValidator(IMoveValidator parent) {
        super(parent);
    }

    @Override
    public boolean isValid(GameObject gameObjectThatWantsToMove, IDirectionMovement desiredDirection) {
        final boolean cannotMove = gameObjectThatWantsToMove.getX() == GameField.Columns - 1 && desiredDirection instanceof MoveEast;
        return super.parent == null ?
                !cannotMove :
                !cannotMove && super.parent.isValid(gameObjectThatWantsToMove, desiredDirection);
    }
}
