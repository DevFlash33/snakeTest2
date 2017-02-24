package De.SnailCode.SnakeDungeon;

import De.SnailCode.SnakeDungeon.GameObjects.GameObject;
import De.SnailCode.SnakeDungeon.GameObjects.Snake.Snake;

import java.util.List;
import java.util.stream.Collectors;

public final class GameObjectUtil {
    private GameObjectUtil() {}

    public static List<Vector2> getGameObjectPositions(List<? extends GameObject> gameObjects) {
        return gameObjects
                .stream()
                .map(gameObject -> new Vector2(gameObject.getPosition()))
                .collect(Collectors.toList());
    }
}
