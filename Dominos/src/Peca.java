public class Peca {

    private int up;
    private int down;
    private int dif;

    public Peca(int up, int down, int dif) {
        this.up = up;
        this.down = down;
        this.dif = dif;
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

    public int getDif() {
        return dif;
    }

    @Override
    public String toString() {
        return "Peça{" + "up=" + up +
                ", down=" + down + '}' + "Diferença: " + dif;
    }

    public void reverse(){
        int temp = up;
        up = down;
        down = temp;
    }


}
