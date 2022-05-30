import java.util.ArrayList;

public class Solution {
    private ArrayList<Peca> pecas;
    private Peca removed;
    private int iterator;
    private int dif  = 0;
    private int sum = 0;

    public Solution() {
        this.pecas = new ArrayList<Peca>();
        this.removed = null;
    }

    public Solution(ArrayList<Peca> pecas) {
        this.pecas = pecas;
        this.removed = null;
        for (Peca peca : pecas) {
            this.dif += peca.getDif();
            this.sum += peca.getUp();
        }
    }

    public Solution(ArrayList<Peca> pecas, Peca removed, int iterator) {
        this.pecas = (ArrayList<Peca>) pecas.clone();
        this.removed = removed;
        this.iterator = iterator;
        for (Peca peca : pecas) {
            this.dif += peca.getDif();
            this.sum += peca.getUp();
        }
    }

    public void add(Peca peca){
        pecas.add(peca);
        this.dif += peca.getDif();
        this.sum += peca.getUp();
    }

    public boolean remove(){
        for (int i = 0; i < pecas.size() && removed == null; i ++){
            if (pecas.get(i).getDif() == getDif()){
                removed = pecas.get(i).clone();
                if (i >= iterator) {
                    iterator --;
                }
                pecas.remove(pecas.get(i));
                this.dif -= removed.getDif();
                this.sum -= removed.getUp();
                return true;
            }
        }
        return false;
    }

    public void reverse(){
        this.sum += pecas.get(iterator).getDown() - pecas.get(iterator).getUp();
        this.dif -= pecas.get(iterator).getDif();
        pecas.get(iterator).reverse();
    }

    public int getIterator(){
        return iterator;
    }

    public void addIterator(){
        iterator ++;
    }

    public void setIterator(int iterator) {
        this.iterator = iterator;
    }

    public Solution clone(){
        ArrayList<Peca> novasPecas = new ArrayList<Peca>();

        for (Peca peca : pecas) {
            novasPecas.add(peca.clone());
        }

        return new Solution(novasPecas, removed, iterator);
    }

    public ArrayList<Peca> getPecas() {
        return pecas;
    }

    public void setPecas(ArrayList<Peca> pecas) {
        this.pecas = pecas;
    }

    public Peca getRemoved() {
        return removed;
    }

    public void setRemoved(Peca removed) {
        this.removed = removed;
    }

    public int getSum() {
        int sum = 0;
        for (Peca peca : pecas) {
            sum += peca.getUp();
        }
        return sum;
    }

    public int getSumTotal() {
        int sum = 0;
        for (Peca peca : pecas) {
            sum += peca.getTotal();
        }
        return sum;
    }

    public int getDif() {
        int dif = 0;
        for (Peca peca : pecas) {
            dif += peca.getDif();
        }
        return dif;
    }

    public String toString(){
        return "Dif: " + getDif() + " " + "Sum: " + getSum() + " " + pecas.toString();
    }

    public int getSum(int iterator) {
        if (removed != null) {
            iterator--;
        }
        int sum = 0;
        for (int i = 0; i < iterator; i++){
            sum += pecas.get(iterator).getUp();
        }
        return sum;
    }


}
