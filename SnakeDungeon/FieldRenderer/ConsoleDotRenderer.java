package De.SnailCode.SnakeDungeon.FieldRenderer;

import De.SnailCode.SnakeDungeon.Vector2;
import De.SnailCode.SnakeDungeon.GameObjects.GameObject;

import java.util.List;
import java.util.Optional;

public final class ConsoleDotRenderer extends BasicConsoleRenderer {
    @Override
    public BasicConsoleRenderer draw(Vector2 currentPosition, List<GameObject> gameObjects) {
        final Optional<GameObject> gameObject = findObjectOnPosition(currentPosition, gameObjects);
        if (!gameObject.isPresent()) {
            System.out.print(".");
            return this;
        }
        return new ConsoleGameObjectRenderer().draw(currentPosition, gameObjects);
    }
}
