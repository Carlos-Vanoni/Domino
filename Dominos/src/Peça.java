public class Peça {

    private int up;
    private int down;

    public Peça(int up, int down) {
        this.up = up;
        this.down = down;
    }

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }

    @Override
    public String toString() {
        return "Peça{" +
                "up=" + up +
                ", down=" + down +
                '}';
    }
}
