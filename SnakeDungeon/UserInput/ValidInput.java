package De.SnailCode.SnakeDungeon.UserInput;

public final class ValidInput implements IUserInput {
    private char validInput;

    @Override
    public IUserInput handleInput(String input) {
        if (input.length() <= 0) return new InvalidInput().handleInput(input);
        this.validInput = input.charAt(0);
        return this;
    }

    @Override
    public char getInput() {
       return this.validInput;
    }
}
