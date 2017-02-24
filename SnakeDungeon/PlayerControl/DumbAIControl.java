package De.SnailCode.SnakeDungeon.PlayerControl;

import De.SnailCode.SnakeDungeon.GameField;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class DumbAIControl implements IPlayerControl {
    private static final Random Random = new Random();
    private List<Character> possibleChoices = Arrays.asList('w', 'a', 's', 'd');

    @Override
    public char generateDirection(GameField gameState) {
        return this.possibleChoices.get(DumbAIControl.Random.nextInt(this.possibleChoices.size()));
    }
}
