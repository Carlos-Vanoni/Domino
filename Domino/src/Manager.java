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

    public void lendo(String user, String nome) {
        try {
            FileReader fis = new FileReader("C:\\Users\\" + user + "\\" + nome);
            BufferedReader ler = new BufferedReader(fis);

            String linha = "";
            linha = ler.readLine();
            ArrayList<Peca> tabuleiro = new ArrayList<>();
            ArrayList<Peca> tabuleiroAux = new ArrayList<>();


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
                int dif = up - down;
                Peca p = new Peca(up,down);
                tabuleiro.add(p);
            }

            ler.close();
        }catch (FileNotFoundException ex) {
            System.out.println("Arquivo Nao Encontrado");
        }catch (IOException ex) {
            System.out.println("IOE funcionando");
        }

    }

    public void print(){
        for (Domino d: boardList){
            for (Peca p: d.getTabuleiro()){
                System.out.println(p.toString());
            }
        }
    }

    public void sort(){
        for (Domino d: boardList){
            d.sort();
        }
    }

    public void somar(){
        for (Domino d: boardList){
            d.somar();
        }
    }

    public void clear() {
        this.boardList.clear();
    }
}
