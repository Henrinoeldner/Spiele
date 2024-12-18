import java.util.Scanner;
public class Wortkette {
    private Scanner scanner;
    private String wortkette;
    public void spielen(){
        scanner = new Scanner(System.in);
        System.out.println("==Wilkommen bei TicTacTo==");
        System.out.println("Wie viele spieler spielen mit?");
        int anzahlspieler=scanner.nextInt();
        wortkette=""+(char)(65+(Math.random()*24));
        for (int i=0;i<anzahlspieler;i++){
            System.out.println("Spieler "+i+" du bist dran nenne ein wort das mit "+wortkette.charAt(wortkette.length()-1)+" beginnt");

        }
    }
}
