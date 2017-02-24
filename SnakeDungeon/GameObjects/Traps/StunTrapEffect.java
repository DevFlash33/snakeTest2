package De.SnailCode.SnakeDungeon.GameObjects.Traps;

import De.SnailCode.SnakeDungeon.GameObjects.Snake.Snake;
import De.SnailCode.SnakeDungeon.GameObjects.Snake.StunnedSnake;

import java.util.List;

public final class StunTrapEffect implements ITrapEffect {
    @Override
    public void activate(List<Snake> snakes) {
        for (int iSnake = 0; iSnake < snakes.size(); iSnake++) {
            snakes.set(iSnake, new StunnedSnake(snakes.get(iSnake).getPosition()));
        }
    }

    @Override
    public char getSymbol() {
        return '!';
    }
}
