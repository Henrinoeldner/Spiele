public class Spielzug {
    private Spieler gegen;
    private Spieler von;
    private String SSP;

    public Spielzug(Spieler gegen,Spieler pvon, String SSP) {
        this.gegen = gegen;
        this.SSP = SSP;
        this.von = pvon;
    }

    public Spieler getVon() {
        return von;
    }

    public Spieler getGegen() {
        return gegen;
    }

    public String getSSP() {
        return SSP;
    }
}
