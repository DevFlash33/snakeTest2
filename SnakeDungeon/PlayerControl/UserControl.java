package De.SnailCode.SnakeDungeon.PlayerControl;

import De.SnailCode.SnakeDungeon.GameField;
import De.SnailCode.SnakeDungeon.UserInput.IUserInput;
import De.SnailCode.SnakeDungeon.UserInput.InvalidInput;

import java.util.Scanner;

public final class UserControl implements IPlayerControl {
    private Scanner scanner = new Scanner(System.in);
    private IUserInput userInput = new InvalidInput();

    @Override
    public char generateDirection(GameField gameState) {
        this.userInput = this.userInput.handleInput(this.scanner.nextLine());
        return this.userInput.getInput();
    }
}
