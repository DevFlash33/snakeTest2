package De.SnailCode.SnakeDungeon.Events;

import De.SnailCode.SnakeDungeon.GameObjects.GameObject;

import java.util.ArrayList;
import java.util.List;
import static De.SnailCode.SnakeDungeon.Events.IGameEventListener.GameEvent;

public final class GameEventComponent {
    private List<IGameEventListener> gameObjects = new ArrayList<>();

    public void addListener(IGameEventListener listener) {
        this.gameObjects.add(listener);
    }

    public void notifyAll(GameObject objectThatTriggeredTheEvent, GameEvent event) {
        this.gameObjects.forEach(gameObject -> gameObject.onNotify(objectThatTriggeredTheEvent, event));
    }
}
