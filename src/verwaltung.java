import java.util.Scanner;


public class verwaltung {
    private Scanner scanner;



    public static void main(String[] args) throws InterruptedException {

        new verwaltung();
        System.out.println("Herzlich willkommen zu Zeichenketten verschluesselerer!");

    }
    public verwaltung() throws InterruptedException {
        SSPSeverMulti sever = new SSPSeverMulti(12);
        SSPClientMulti client = new SSPClientMulti("localhost", 12);
        client.verbinden("HENRI");

        scanner = new Scanner(System.in);
        while (true) {

            System.out.println("== HAUPTMENÜ ==");
            System.out.println("[1]TicTacTo\n[2]Wortkette\n[3]Schere Stein Papir ");

            int verschluesselungprinzip = scanner.nextInt();
            if(verschluesselungprinzip==1) {
                TicTacTo tictacto=new TicTacTo();
                tictacto.play();
            }else if (verschluesselungprinzip==2){
                Wortkette wortkette=new Wortkette();
                wortkette.play();

            }else if (verschluesselungprinzip==3){
                boolean stop =false;
                System.out.println("\n == Schere Stein Papier==\n Wilkommen bei Schere Stein Papier. Die Regeln sind simpel." +
                        " Schere schlägt Papier. Papier schlägt Stein. Stein schlägt Schere\n\n Möchtest du alleine Spielen oder gegen andere?\n [1] Alleine \n [2] Mit Anderen");





                SSPSeverSingel severSingel = new SSPSeverSingel(12);
                SSPClientSingel clientSingel = new SSPClientSingel("localhost", 12);
                while (!stop) {

                    System.out.println("Was möchtest du spielen ?\n [1] Stein \n [2] Schere \n [3] Papier \n [4] Zurück");
                    int option = scanner.nextInt();
                    switch (option){
                        case 1 -> clientSingel.stein();
                        case 2 -> clientSingel.schere();
                        case 3 -> clientSingel.papir();
                        case 4 -> {
                            stop=true;
                        }
                        default -> System.out.println("Keine gültige eingabe");
                    }
                    Thread.sleep(35);
                }
            }
            Thread.sleep(35);
        }
    }
}
