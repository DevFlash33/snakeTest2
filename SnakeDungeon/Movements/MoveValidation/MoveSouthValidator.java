package De.SnailCode.SnakeDungeon.Movements.MoveValidation;

import De.SnailCode.SnakeDungeon.GameField;
import De.SnailCode.SnakeDungeon.GameObjects.GameObject;
import De.SnailCode.SnakeDungeon.Movements.IDirectionMovement;
import De.SnailCode.SnakeDungeon.Movements.MoveSouth;

public final class MoveSouthValidator extends ChainingMoveValidator {
    public MoveSouthValidator(IMoveValidator parent) {
        super(parent);
    }

    @Override
    public boolean isValid(GameObject gameObjectThatWantsToMove, IDirectionMovement desiredDirection) {
        final boolean cannotMove = gameObjectThatWantsToMove.getY() == GameField.Rows - 1 && desiredDirection instanceof MoveSouth;
        return super.parent == null ?
                !cannotMove :
                !cannotMove && super.parent.isValid(gameObjectThatWantsToMove, desiredDirection);
    }
}
