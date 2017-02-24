package De.SnailCode.SnakeDungeon.UserInput;

public interface IUserInput {
    IUserInput handleInput(String input);
    char getInput();
}
