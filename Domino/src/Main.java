public class Main {

    public static void main(String[] args) {

        Manager manager = new Manager();

        InterfaceUser userCommands = new InterfaceUser();

        while (true) {

            String user = userCommands.leString("\n\nDigite o seu usuário logado na máquina (para poder acesar o diretório dos arquivos de dominó): ");
            String file = userCommands.leString("\n\nDigite o nome do arquivo (não esqueça de colocar a extensão no nome caso possua): ");

            System.out.println("\n");
            manager.lendo(user, file);
            manager.somar();
            System.out.println("\n");

            String exit = userCommands.leString("digite qualquer botão para ler outro arquivo, ou digite 0 para finalizar a aplicação: ");
            if (exit.equalsIgnoreCase("0")) {
                System.out.println("saindo...");
                break;
            }
            manager.clear();
        }

    }
}
