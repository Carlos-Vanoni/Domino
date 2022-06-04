import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.time.Instant;

public class Domino {

    private ArrayList<Peca> tabuleiro;

    public Domino() {
    }

    public ArrayList<Peca> getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(ArrayList<Peca> tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public void saveTabuleiro(ArrayList<Peca> tabuleiro) {
        ArrayList<Peca> tabuleiroSaved = new ArrayList<>();
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
                Peca peca = new Peca(up, down);
                tabuleiro.add(peca);
                peca.toString();
            }

            ler.close();
        } catch (IOException e) {
            System.out.println("erro");
        }
    }

    public void somar(){
        for (Peca peca : tabuleiro) {
            if (peca.getDif() < 0) {
                peca.reverse();
            }
        }

        sort();

        ArrayList<Peca> novoTabuleiro = new ArrayList<Peca>();
        for (Peca peca : tabuleiro) {
            novoTabuleiro.add(peca.clone());
        }

        Solution melhorSolucao = new Solution();

        melhorSolucao = resolver(new Solution(novoTabuleiro), melhorSolucao);

        if (melhorSolucao.getSum() > 0 && melhorSolucao.getDif() == 0) {
            Peca removed = melhorSolucao.getRemoved();
            System.out.print(melhorSolucao.getSum());
            if (removed != null){
                System.out.println(" descartado o dominó " + removed.getUp() + " " + removed.getDown());
            } else {
                System.out.println(" nenhum dominó descartado");
            }
        } else {
            System.out.println("impossível");
        }
    }

    public Solution resolver(Solution solucao, Solution melhorSolucao){
        if (solucao.getIterator() == solucao.getPecas().size() && solucao.getDif() != 0) {
            if (!solucao.remove()){
                return melhorSolucao;
            }
        }
        if (solucao.getDif() < 0){
            if (!solucao.remove()){
                return melhorSolucao;
            }
        }
        if (solucao.getDif() == 0) {
            if (solucao.getSum() > melhorSolucao.getSum()) {
                melhorSolucao = solucao.clone();
            }
            return melhorSolucao;
        }
        if (solucao.getDif() / 2 > solucao.getDif(solucao.getIterator())){
            return melhorSolucao;
        }
        if (melhorSolucao.getSum() > 0) {
            if (solucao.getDif(solucao.getIterator()) > melhorSolucao.getDif(solucao.getIterator())){
                return melhorSolucao;
            }
        }

        Solution novaSolucao1 = solucao.clone();
        novaSolucao1.addIterator();
        melhorSolucao = resolver(novaSolucao1, melhorSolucao);

        Solution novaSolucao2 = solucao.clone();
        novaSolucao2.reverse();
        novaSolucao2.addIterator();
        melhorSolucao = resolver(novaSolucao2, melhorSolucao);

        return melhorSolucao;
    }

    public void sort(){
        ArrayList<Peca> sorted = new ArrayList<Peca>();

        while (tabuleiro.size() > 0){
            Peca menor = tabuleiro.get(0);
            for (Peca p: tabuleiro){
                if (p.getDif() > menor.getDif()){
                    menor = p;
                }
            }
            sorted.add(menor);
            tabuleiro.remove(menor);
        }
        tabuleiro = sorted;
    }
}
