package De.SnailCode.SnakeDungeon.Movements.MoveValidation;

public class DefaultMoveValidator {
    private static DefaultMoveValidator instance;
    private IMoveValidator moveValidator;

    private DefaultMoveValidator() {
        this.moveValidator =    new MoveEastValidator(
                                new MoveNorthValidator(
                                new MoveSouthValidator(
                                new MoveWestValidator(null))));
    }

    public IMoveValidator validator() {
        return this.moveValidator;
    }

    public static DefaultMoveValidator instance() {
        return  DefaultMoveValidator.instance == null ?
                (DefaultMoveValidator.instance = new DefaultMoveValidator()) :
                DefaultMoveValidator.instance;
    }
}
