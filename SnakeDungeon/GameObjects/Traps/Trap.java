package De.SnailCode.SnakeDungeon.GameObjects.Traps;

import De.SnailCode.SnakeDungeon.GameObjects.GameObject;
import De.SnailCode.SnakeDungeon.GameObjects.Snake.Snake;

import java.util.List;

public class Trap extends GameObject {
    private ITrapEffect trapEffect;

    public Trap(ITrapEffect effect, int rows, int columns) {
        super(' ', rows, columns);
        this.trapEffect = effect;
    }

    public void activateTrap(List<Snake> snakes) {
        this.trapEffect.activate(snakes);
    }

    @Override
    public void render() {
        System.out.print(this.trapEffect.getSymbol());
    }
}
