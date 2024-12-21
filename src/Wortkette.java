import java.util.Scanner;
public class Wortkette {
    private Scanner scanner;
    private String wortkette;
    public void play(){
        scanner = new Scanner(System.in);
        System.out.println("==Wilkommen bei TicTacTo==");
        System.out.println("Wie viele spieler spielen mit?");
        int anzahlspieler=scanner.nextInt();
        wortkette=""+(char)(65+(Math.random()*24));
        char letzterbuchstabe=wortkette.charAt(wortkette.length()-1);
        boolean playing=true;
        while (playing)
        for (int i=0;i<anzahlspieler;i++){
            System.out.println("Spieler "+(i+1)+" du bist dran nenne ein wort das mit "+letzterbuchstabe+" beginnt");
            String newwort =scanner.next();
            while (newwort.charAt(0)!=letzterbuchstabe||wortkette.contains(newwort)){
                System.out.println("Dein wort war ungueltig. Nenne bitte ein anderes Wort, dass mit " +letzterbuchstabe+" begint");
                newwort =scanner.next();
            }
            wortkette+=newwort;
            letzterbuchstabe=wortkette.charAt(wortkette.length()-1);

        }

    }
}
