public class Peca {

    private int up;
    private int down;

    public Peca(int up, int down) {
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

    public int getDif() {
        return up - down;
    }

    @Override
    public String toString() {
        return "Peça{" + "up=" + up +
                ", down=" + down + '}' + "Diferença: " + (up - down);
    }

    public void reverse(){
        int temp = up;
        up = down;
        down = temp;
    }

    public void add(Peca p){
        up += p.getUp();
        down += p.getDown();
    }

    @Override
    public Peca clone(){
        return new Peca(up, down);
    }

    public int getMean(){
        return (up + down) / 2;
    }

    public int getTotal(){
        return up + down;
    }
}
