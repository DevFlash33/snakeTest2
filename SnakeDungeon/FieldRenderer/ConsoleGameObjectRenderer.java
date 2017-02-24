package De.SnailCode.SnakeDungeon.FieldRenderer;

import De.SnailCode.SnakeDungeon.GameObjects.GameObject;
import De.SnailCode.SnakeDungeon.Vector2;

import java.util.List;
import java.util.Optional;

public final class ConsoleGameObjectRenderer extends BasicConsoleRenderer {
    @Override
    public BasicConsoleRenderer draw(Vector2 currentPosition, List<GameObject> gameObjects) {
        final Optional<GameObject> gameObject = findObjectOnPosition(currentPosition, gameObjects);
        if (gameObject.isPresent()) {
            gameObject.get().render();
            return this;
        }
        return new ConsoleDotRenderer().draw(currentPosition, gameObjects);
    }
}
