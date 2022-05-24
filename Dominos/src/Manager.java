import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Manager {

    private List<Domino> boardList;

    public Manager() {
        this.boardList = new ArrayList<Domino>();
    }

    public List<Domino> getBoardList() {
        return boardList;
    }

    public void setBoardList(List<Domino> boardList) {
        this.boardList = boardList;
    }

    public void lendo(String nome) {
        try {
            FileReader fis = new FileReader("c:\\users\\carlo\\" + nome);
            BufferedReader ler = new BufferedReader(fis);

            String linha = "";
            linha = ler.readLine();
            List<Peça> tabuleiro = new ArrayList<>();
            List<Peça> tabuleiroAux = new ArrayList<>();


            while (!Objects.equals(linha, "0")) {
                linha = ler.readLine();


                if (linha.split(" ").length == 1) {
                    tabuleiro.addAll(tabuleiroAux);
                    Domino domino = new Domino();
                    domino.saveTabuleiro(tabuleiro);
                    boardList.add(domino);
                    tabuleiro.clear();
                    continue;
                }

                String[] values = linha.split(" ");
                int up = Integer.parseInt(values[0]);
                int down = Integer.parseInt(values[1]);
                tabuleiro.add(new Peça(up, down));
            }

            ler.close();
        }catch (FileNotFoundException ex) {
            System.out.println("Arquivo N�o Encontrado");
        }catch (IOException ex) {
            System.out.println("IOE funcionando");
        }

    }
}
