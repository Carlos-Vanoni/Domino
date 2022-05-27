import java.io.*;
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

    public void lendo(String user,String nome) {
        try {
            FileReader fis = new FileReader(nome);
            BufferedReader ler = new BufferedReader(fis);
            String linha = "";
            linha = ler.readLine();
            List<Peca> tabuleiro = new ArrayList<>();
            List<Peca> tabuleiroAux = new ArrayList<>();


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
                Peca p = new Peca(up,down,dif);
                if (dif < 0){
                    p.reverse();
                }
                boolean added = false;
                tabuleiro.add(p);
//                if (tabuleiro.size() == 0){
//                    tabuleiro.add(new Peca(up, down, dif));
//                }
//                else {
//                    for (int i = 0; i < tabuleiro.size(); i++){
//                        if (tabuleiro.get(i).getDif() < dif){
//                            tabuleiro.add(i + 1, new Peca(up, down, dif));
//                            break;
//                        }
//                    }
//                }
            }

            ler.close();
        }catch (FileNotFoundException ex) {
            System.out.println("Arquivo Nao Encontrado");
        }catch (IOException ex) {
            System.out.println("IOE funcionando");
        }

    }

    public void grava(String usuario, String nomeArq, String result) {
        File f = new File("c:\\users\\" + usuario + "\\" + nomeArq + ".txt");

        try {
            FileOutputStream fos = new FileOutputStream(f);
            PrintWriter pw = new PrintWriter(fos);

            pw.println(result);

            System.out.println("Salvo!");
            pw.close();
        } catch (IOException ex) {
            System.out.println("Erro ao salvar");
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
}
