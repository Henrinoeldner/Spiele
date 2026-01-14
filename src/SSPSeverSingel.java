import jutils.Server;

/**
 * Protokoll
 * SCHERE
 * STEIN
 * PAPIER
 */
public class SSPSeverSingel extends Server {
    public SSPSeverSingel(int pPort) {
        super(pPort);
    }

    @Override
    public void processNewConnection(String pClientIP, int pClientPort) {

    }

    @Override
    public void processMessage(String pClientIP, int pClientPort, String pMessage) {
        String[] Ergenisse ={"SCHERE","STEIN","PAPIER"};
        String[] Antworten= {".Es ist ein Unentschieden ",".Du hast gewonnen",".Du hast verloren"};
        int com= (int)(Math.random()*3);
        int sieger =siegerberechen(pMessage,Ergenisse[com]);
        send(pClientIP,pClientPort,"Du spielst " +pMessage+". Der Server spielt " + Ergenisse[com]+ Antworten[sieger]);

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
