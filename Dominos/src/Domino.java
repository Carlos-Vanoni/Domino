import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Domino {

    private List<Peca> tabuleiro;

    public Domino() {
    }

    public List<Peca> getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(List<Peca> tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public void saveTabuleiro(List<Peca> tabuleiro) {
        List<Peca> tabuleiroSaved = new ArrayList<>();
        tabuleiroSaved.addAll(tabuleiro);
        this.tabuleiro = tabuleiroSaved;
    }

    public void ler(String nome) {
        try {
            FileReader arq = new FileReader(nome);
            BufferedReader ler = new BufferedReader(arq);

            String conteudo = "";
            String linha = "";
            linha = ler.readLine();

            while (linha != null) {
                String[] values = linha.split("");
                int up = Integer.parseInt(values[0]);
                int down = Integer.parseInt(values[1]);
                Peca peca = new Peca(up, down, up - down);
                tabuleiro.add(peca);
                peca.toString();
            }

            ler.close();
        } catch (IOException e) {
            System.out.println("erro");
        }
    }

    public void somar(){
        List<Peca> match = new ArrayList<Peca>();
        //agrupa em 2 a 2 dominos com a mesma diferenca, invertendo se necessario
        for (int i = 0; i < tabuleiro.size() - 1; i++){
            if (tabuleiro.get(i).getDif() == tabuleiro.get(i + 1).getDif()){
                match.add(tabuleiro.get(i));
                tabuleiro.get(i + 1).reverse();
                match.add(tabuleiro.get(i + 1));
                tabuleiro.remove(i);
                tabuleiro.remove(i);
                i --;
            } else if (tabuleiro.get(i).getDif() == - tabuleiro.get(i + 1).getDif()){
                match.add(tabuleiro.get(i));
                match.add(tabuleiro.get(i + 1));
                tabuleiro.remove(i);
                tabuleiro.remove(i);
                i --;
            }
        }

        int soma = 0;
        for (int i = 0; i < match.size(); i++){
            soma += match.get(i).getUp();
        }
        System.out.println(soma);
    }

    public void sort(){
        List<Peca> sorted = new ArrayList<Peca>();

        while (tabuleiro.size() > 0){
            Peca menor = tabuleiro.get(0);
            for (Peca p: tabuleiro){
                if (p.getDif() < menor.getDif()){
                    menor = p;
                }
            }

            sorted.add(menor);
            tabuleiro.remove(menor);
        }
        tabuleiro = sorted;
    }
}
