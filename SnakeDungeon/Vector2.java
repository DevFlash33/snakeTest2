package De.SnailCode.SnakeDungeon;

public final class Vector2 {
    private int x = 0;
    private int y = 0;

    public Vector2(int x, int y) {
        set(x, y);
    }

    public Vector2(Vector2 vector) {
        this.x = vector.x;
        this.y = vector.y;
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void translateY(int y) {
        this.y += y;
    }

    public void translateX(int x) {
        this.x += x;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
