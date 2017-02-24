package De.SnailCode.SnakeDungeon.Movements.MoveValidation;

import De.SnailCode.SnakeDungeon.GameObjects.GameObject;
import De.SnailCode.SnakeDungeon.Movements.IDirectionMovement;

public interface IMoveValidator {
    boolean isValid(GameObject gameObjectThatWantsToMove, IDirectionMovement desiredDirection);
}
