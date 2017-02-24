package De.SnailCode.SnakeDungeon.Movements;

import java.util.HashMap;
import java.util.Map;

public final class MoveMapper {
    private Map<Character, IDirectionMovement> keyMovements = new HashMap<>();

    private static MoveMapper factory;

    private MoveMapper() {
        this.keyMovements.put('w', new MoveNorth());
        this.keyMovements.put('a', new MoveWest());
        this.keyMovements.put('s', new MoveSouth());
        this.keyMovements.put('d', new MoveEast());
    }

    public static MoveMapper instance() {
        return factory == null ?
                (factory = new MoveMapper()) :
                factory;
    }

    public IDirectionMovement movement(char direction) {
        if (this.keyMovements.containsKey(direction)) return this.keyMovements.get(direction);
        return new NoMovement();
    }
}
