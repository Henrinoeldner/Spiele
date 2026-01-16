public class Spielzug {
    private Spieler gegen;
    private String SSP;

    public Spielzug(Spieler gegen, String SSP) {
        this.gegen = gegen;
        this.SSP = SSP;
    }

    public Spieler getGegen() {
        return gegen;
    }

    public String getSSP() {
        return SSP;
    }
}
