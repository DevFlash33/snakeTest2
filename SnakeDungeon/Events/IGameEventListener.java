package De.SnailCode.SnakeDungeon.Events;

import De.SnailCode.SnakeDungeon.GameObjects.GameObject;

public interface IGameEventListener {
    enum GameEvent {
        Snake_Killed_Player,
        Player_Not_All_Coins_Hit_Door,
        Player_All_Coins_Hit_Door,
        Coin_Collected,
        Trap_Activated
    }

    void onNotify(GameObject objectThatTriggeredTheEvent, GameEvent event);
}
