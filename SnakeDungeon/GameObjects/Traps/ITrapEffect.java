package De.SnailCode.SnakeDungeon.GameObjects.Traps;

import De.SnailCode.SnakeDungeon.GameObjects.Snake.Snake;

import java.util.List;

public interface ITrapEffect {
    void activate(List<Snake> snakes);
    char getSymbol();
}
