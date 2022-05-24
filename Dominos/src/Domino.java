import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Domino {

    private List<Peça> tabuleiro;

    public Domino() {
    }

    public List<Peça> getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(List<Peça> tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public void saveTabuleiro(List<Peça> tabuleiro) {
        List<Peça> tabuleiroSaved = new ArrayList<>();
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
                Peça peça = new Peça(up, down);
                tabuleiro.add(peça);
                peça.toString();
            }

            ler.close();
        } catch (IOException e) {
            System.out.println("erro");
        }
    }


}
