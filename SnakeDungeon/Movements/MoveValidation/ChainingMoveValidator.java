package De.SnailCode.SnakeDungeon.Movements.MoveValidation;

public abstract class ChainingMoveValidator implements IMoveValidator {
    protected IMoveValidator parent;

    public ChainingMoveValidator(IMoveValidator parent) {
        this.parent = parent;
    }
}
