package De.SnailCode.SnakeDungeon.FieldRenderer;

import De.SnailCode.SnakeDungeon.GameObjects.GameObject;
import De.SnailCode.SnakeDungeon.Vector2;

import java.util.List;
import java.util.Optional;

public abstract class BasicConsoleRenderer {
    protected Optional<GameObject> findObjectOnPosition(Vector2 position, List<GameObject> gameObjects) {
        return gameObjects.stream()
                .filter(gameObject -> gameObject.isOnPosition(position))
                .findFirst();
    }

    public abstract BasicConsoleRenderer draw(Vector2 currentPosition, List<GameObject> gameObjects);
}
