import jutils.List;
import jutils.Server;

/**
 * Protokoll
 * VERBINDEN:<name>   -> VERBUNDEN: <gegenspieler>
 * SCHERE:<name>:<gegenspieler>
 * STEIN:<name>:<gegenspieler>
 * PAPIER:<name>:<gegenspieler>
 */
public class SSPSeverMulti extends Server {

    private List<Spieler> spielerList = new List<>();
    private List<Spielzug> spielzugList= new List<>();
    public SSPSeverMulti(int pPort) {
        super(pPort);
    }

    @Override
    public void processNewConnection(String pClientIP, int pClientPort) {

    }

    @Override
    public void processMessage(String pClientIP, int pClientPort, String pMessage) {
        String[] nachrichtTeil =pMessage.split(":");
        switch (nachrichtTeil[0]){
            case "VERBINDEN" ->{
                spielerList.append(new Spieler(nachrichtTeil[2],pClientIP,pClientPort));
            }
        }

    }

    /**
     *
     * @param spiler1
     * @param spieler2
     * @return 0 Unentscieden, 1 Spieler 1 hat gewonnen, 2 Spieler 2 hat gewonnen
     */
    private int siegerberechen (String spiler1,String spieler2){
        switch (spiler1) {
            case "SCHERE" -> {
                switch (spieler2){
                    case "SCHERE"-> {
                        return 0;
                    }
                    case "STEIN" -> {
                        return 2;
                    }
                    case "PAPIER" -> {
                        return 1;
                    }
                }
            }
            case "STEIN" -> {
                switch (spieler2) {
                    case "SCHERE" -> {
                        return 1;
                    }
                    case "STEIN" -> {
                        return 0;
                    }
                    case "PAPIER" -> {
                        return 2;
                    }
                }
            }
            case "PAPIER" -> {
                switch (spieler2) {
                    case "SCHERE" -> {
                        return 2;
                    }
                    case "STEIN" -> {
                        return 1;
                    }
                    case "PAPIER" -> {
                        return 0;
                    }
                }
            }
        }
        return 0;
    }
    @Override
    public void processClosingConnection(String pClientIP, int pClientPort) {

    }
}
