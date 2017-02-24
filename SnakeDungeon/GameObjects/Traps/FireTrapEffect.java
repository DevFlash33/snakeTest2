package De.SnailCode.SnakeDungeon.GameObjects.Traps;

import De.SnailCode.SnakeDungeon.GameObjects.Snake.Snake;

import java.util.List;
import java.util.Random;

public final class FireTrapEffect implements ITrapEffect {
    @Override
    public void activate(List<Snake> snakes) {
        snakes.remove(new Random().nextInt(snakes.size()));
    }

    @Override
    public char getSymbol() {
        return 'F';
    }
}
