package De.SnailCode.SnakeDungeon.GameObjects.Snake;

import De.SnailCode.SnakeDungeon.GameObjects.Player;
import De.SnailCode.SnakeDungeon.Movements.IDirectionMovement;
import De.SnailCode.SnakeDungeon.Movements.MoveEast;
import De.SnailCode.SnakeDungeon.Movements.MoveValidation.MoveValidator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Florian on 24.02.2017.
 */
public final class TrapMoveLeftSnake implements ISnakeMovement{

    private final Map<Integer, IDirectionMovement> snakeMovements = new HashMap<>();

    public TrapMoveLeftSnake(){

        this.snakeMovements.put(0, new MoveEast());
    }

    @Override
    public void move(Player player, Snake snake) {
        MoveValidator.instance().move(snake, this.snakeMovements.get(0));
    }
}
