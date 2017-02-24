package De.SnailCode.SnakeDungeon.UserInput;

public final class InvalidInput implements IUserInput {
    @Override
    public IUserInput handleInput(String input) {
        return input.length() >= 1 ?
                new ValidInput().handleInput(input) :
                this;
    }

    @Override
    public char getInput() {
        return ' ';
    }
}
