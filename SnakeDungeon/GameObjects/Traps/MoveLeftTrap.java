package De.SnailCode.SnakeDungeon.GameObjects.Traps;

import De.SnailCode.SnakeDungeon.GameObjects.Player;
import De.SnailCode.SnakeDungeon.GameObjects.Snake.ISnakeMovement;
import De.SnailCode.SnakeDungeon.GameObjects.Snake.Snake;
import De.SnailCode.SnakeDungeon.GameObjects.Snake.TrapMoveLeftSnake;
import De.SnailCode.SnakeDungeon.Movements.*;

import java.util.List;

/**
 * Created by Florian on 24.02.2017.
 */
public class MoveLeftTrap implements ITrapEffect {

    @Override
    public void activate(List<Snake> snakes) {
        snakes.forEach(snake -> snake.setMovement(new TrapMoveLeftSnake()));
        }

    @Override
    public char getSymbol() {
        return 'L';
    }


}
