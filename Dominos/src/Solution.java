import java.util.ArrayList;

public class Solution {
    private ArrayList<Peca> pecas;
    private Peca removed;
    private int iterator;

    public Solution() {
        this.pecas = new ArrayList<Peca>();
        this.removed = null;
    }

    public Solution(ArrayList<Peca> pecas) {
        this.pecas = pecas;
        this.removed = null;
    }

    public Solution(ArrayList<Peca> pecas, Peca removed, int iterator) {
        this.pecas = (ArrayList<Peca>) pecas.clone();
        this.removed = removed;
        this.iterator = iterator;
    }

    public void add(Peca peca){
        pecas.add(peca);
    }

    public boolean remove(){
        ArrayList<Peca> candidatos = new ArrayList<Peca>();
        for (int i = 0; i < pecas.size() && removed == null; i ++){
            if (pecas.get(i).getDif() == getDif()){
                candidatos.add(pecas.get(i));
            }
        }
        if (candidatos.size() > 0) {
            candidatos = sort(candidatos);
            removed = candidatos.get(0).clone();
            pecas.remove(candidatos.get(0));

            int position = pecas.indexOf(candidatos.get(0));
            if (position >= iterator) {
                iterator--;
            }
            return true;
        }
        return false;
    }

    public ArrayList<Peca> sort(ArrayList<Peca> pecas){
        ArrayList<Peca> sorted = new ArrayList<Peca>();

        while (pecas.size() > 0){
            Peca menor = pecas.get(0);
            for (Peca p: pecas){
                if (p.getDif() < menor.getDif()){
                    menor = p;
                }
            }
            sorted.add(menor);
            pecas.remove(menor);
        }
        return sorted;
    }

    public void reverse(){
        pecas.get(iterator).reverse();
    }

    public int getIterator(){
        return iterator;
    }

    public void addIterator(){
        iterator ++;
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

    public Peca getRemoved() {
        return removed;
    }

    public int getSum() {
        int sum = 0;
        for (Peca peca : pecas) {
            sum += peca.getUp();
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

    public int getDif(int iterator) {
        int dif = 0;
        for (int i = iterator; i < getPecas().size(); i++) {
            dif += pecas.get(i).getDif();
        }
        return dif;
    }

    public String toString(){
        String rmv = "NULL";
        if (removed != null) {
            rmv = removed.toString();
        }

        return "Dif: " + getDif() + " " + "Sum: " + getSum()
                + " Iterator: " + iterator + " "
                + " Removed: " + rmv + " "
                + " " + pecas.toString();
    }
}
