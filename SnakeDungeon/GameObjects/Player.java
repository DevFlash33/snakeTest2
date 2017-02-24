package De.SnailCode.SnakeDungeon.GameObjects;

import java.util.ArrayList;
import java.util.List;

public class Player extends MovableGameObject {
    private List<Coin> collectedCoins = new ArrayList<>();

    public Player(int rows, int columns) {
        super('P', rows, columns);
    }

    public void collectCoin(Coin coin) {
        this.collectedCoins.add(coin);
    }

    public int collectedCoins() {
        return this.collectedCoins.size();
    }
}
