package De.SnailCode.SnakeDungeon.Movements.MoveValidation;

import De.SnailCode.SnakeDungeon.GameObjects.GameObject;
import De.SnailCode.SnakeDungeon.Movements.*;

public final class MoveValidator {
    private IMoveValidator moveValidator = DefaultMoveValidator.instance().validator();

    private static MoveValidator factory;

    private MoveValidator() {}

    public static MoveValidator instance() {
        return MoveValidator.factory == null ?
                (MoveValidator.factory = new MoveValidator()) :
                MoveValidator.factory;
    }

    public void move(GameObject objectThatWantsToMove, IDirectionMovement desiredDirection) {
        if (moveValidator.isValid(objectThatWantsToMove, desiredDirection)) {
            desiredDirection.move(objectThatWantsToMove);
        }
    }
}
