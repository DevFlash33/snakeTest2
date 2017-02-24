package De.SnailCode.SnakeDungeon.GameObjects;

import De.SnailCode.SnakeDungeon.Vector2;

import java.util.Random;

public abstract class GameObject {
    private static Random random = new Random();
    protected Vector2 position;
    private char symbol;

    public GameObject(char symbol, int maxRandomX, int maxRandomY) {
        this.position = new Vector2(random.nextInt(maxRandomY), random.nextInt(maxRandomX));
        this.symbol = symbol;
    }

    public GameObject(char symbol, Vector2 position) {
        this.position = position;
        this.symbol = symbol;
    }

    public boolean isOnPosition(Vector2 positionToCheck) {
        return this.position.getX() == positionToCheck.getX() &&
                this.position.getY() == positionToCheck.getY();
    }

    public boolean isOnPosition(GameObject objectToCheck) {
        return this.isOnPosition(objectToCheck.getPosition());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameObject)) return false;

        GameObject that = (GameObject) o;

        return symbol == that.symbol && (position != null ? position.equals(that.position) : that.position == null);
    }

    @Override
    public int hashCode() {
        int result = position != null ? position.hashCode() : 0;
        result = 31 * result + (int) symbol;
        return result;
    }

    public void moveNorth() {
        this.position.translateY(-1);
    }

    public void moveSouth() {
        this.position.translateY(1);
    }

    public void moveEast() {
        this.position.translateX(1);
    }

    public void moveWest() {
        this.position.translateX(-1);
    }

    public void render() {
        System.out.print(symbol);
    }

    public Vector2 getPosition() {
        return this.position;
    }

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }
}
