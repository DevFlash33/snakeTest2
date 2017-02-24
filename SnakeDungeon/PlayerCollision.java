package De.SnailCode.SnakeDungeon;

import De.SnailCode.SnakeDungeon.GameObjects.GameObject;
import De.SnailCode.SnakeDungeon.GameObjects.Player;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public final class PlayerCollision {
    private Player player;

    public PlayerCollision(Player player) {
        this.player = player;
    }

    public<T extends GameObject> void onCollisionWithObject(T gameObjectToCheckCollisionWith, Consumer<T> consumer) {
        Stream.of(gameObjectToCheckCollisionWith)
                .filter(this.player::isOnPosition)
                .findFirst()
                .ifPresent(consumer);
    }

    public<T extends GameObject> void onCollisionWithObjects(List<T> gameObjectsToCheckCollisionsWith, Consumer<T> consumer) {
        gameObjectsToCheckCollisionsWith
                .stream()
                .filter(this.player::isOnPosition)
                .findFirst()
                .ifPresent(consumer);
    }
}
