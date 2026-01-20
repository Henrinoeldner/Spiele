public class match {
    private Spieler spieler1;
    private Spieler spieler2;

    public match(Spieler spieler1, Spieler spieler2) {
        this.spieler1 = spieler1;
        this.spieler2 = spieler2;
    }

    public Spieler findegegenspieler(String pName){
        if (spieler1.getName().equals(pName)){
            return spieler2;
        }
        if (spieler2.getName().equals(pName)){
            return spieler1;
        }
        return null;
    }
}
