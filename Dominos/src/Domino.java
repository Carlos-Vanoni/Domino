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

        ArrayList<Solution> solucoes = new ArrayList<Solution>();



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

        /*

        List<Peca> resultado = new ArrayList<>();

        int dif = 0;
        for (Peca peca : tabuleiro) {
            if (peca.getDif() < 0) {
                peca.reverse();
            }
            dif += peca.getDif();
        }

        boolean oddArray = false;
        if (dif % 2 != 0) {
            oddArray = true;
            dif --;
        }
        int middle = dif / 2;


        boolean changed = true;
        while (dif > middle && tabuleiro.size() > 0 && changed) {
            Peca maiorDif = new Peca(0, 0);
            changed = false;
            //se ordenar por diferenca n precisa desse loop
            for (Peca peca : tabuleiro) {
                if (peca.getDif() > maiorDif.getDif() && dif - peca.getDif() >= middle){
                    maiorDif = peca;
                    changed = true;
                }
            }
            if (changed){
                maiorDif.reverse();
                dif += maiorDif.getDif();
                resultado.add(maiorDif);
                tabuleiro.remove(maiorDif);
            }
        }

        if (oddArray) {
            dif ++;
        }


        int remove = dif - middle;

        Peca removed = null;

        if (remove != 0) {
            for (int i = 0; i < tabuleiro.size() && (removed == null); i ++) {
                if (tabuleiro.get(i).getDif() == remove){
                    removed = tabuleiro.get(i);
                    tabuleiro.remove(tabuleiro.get(i));
                    dif -= removed.getDif();
                    i --;
                }
            }
        }

        for (Peca peca : tabuleiro){
            resultado.add(peca);
        }

        int sum = 0;
        for (Peca p : resultado) {
            sum += p.getUp();
        }

        remove = dif - middle;

        if (remove == 0) {
            System.out.print(sum);
            if (removed != null){
                System.out.println(" descartado o dominó " + removed.getUp() + " " + removed.getDown());
            } else {
                System.out.println(" nenhum dominó descartado");
            }
        } else {
            System.out.println("impossível");
        }
        */
    }

    public Solution resolver(Solution solucao, Solution melhorSolucao){
        if (solucao.getDif() < 0){
            if (!solucao.remove()){
                return melhorSolucao;
            }
        }
        if (solucao.getIterator() == solucao.getPecas().size() && solucao.getDif() != 0) {
            solucao.remove();
            return melhorSolucao;
        }
        if (solucao.getDif() == 0) {
            if (solucao.getSum() > melhorSolucao.getSum()) {
                melhorSolucao = solucao.clone();
            }
            return melhorSolucao;
        }
        if (melhorSolucao.getSum() != 0 && solucao.getSum(solucao.getIterator()) <= melhorSolucao.getSum(solucao.getIterator())){
            return melhorSolucao;
        }

        //tentar fazer os caminhos como variaveis na classe solution, depois pra voltar é só chamar a referencia anterior
        //ai fazer pesquisa por amplitude
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
