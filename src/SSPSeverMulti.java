import jutils.List;
import jutils.Queue;
import jutils.Server;

/**
 * Protokoll
 * VERBINDEN:<name>   -> VERBUNDEN: <gegenspieler>
 * SPIEL:<spielzug>:<name>:<gegenspieler>
 *<spielzug>=STEIN/SCHERE/PAPIER
 */
public class SSPSeverMulti extends Server {
    private Queue<Spieler> wartenaufVerbindung = new Queue<>();
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
                if (wartenaufVerbindung.isEmpty()){
                    wartenaufVerbindung.enqueue(new Spieler(nachrichtTeil[1],pClientIP,pClientPort));
                } else{
                    Spieler spieler1 = new Spieler(nachrichtTeil[1],pClientIP,pClientPort);
                    Spieler spieler2 = wartenaufVerbindung.front();
                    wartenaufVerbindung.dequeue();
                    spielerList.append(spieler1);
                    spielerList.append(spieler2);
                    send(pClientIP,pClientPort,"VERBUNDEN:"+spieler2.getName());
                    send(spieler2.getIp(),spieler2.getPort(),"VERBUNDEN:"+spieler1.getName());
                }

            }
            case "SPIEL"->{
                boolean vorhandenerspielzug=false;
                spielzugList.toFirst();
                Spielzug spielzug=null;
                while (spielzugList.hasAccess()){
                    if (spielzugList.getContent().getGegen().getName().equals(nachrichtTeil[2])){
                        spielzug=spielzugList.getContent();
                        vorhandenerspielzug=true;
                    }
                    spielzugList.next();
                }
                String naricht1 = "Du hast "+nachrichtTeil[1]+" gespielt. Dein gegner hat "+spielzug.getSSP()+" gespielt.";
                String naricht2 = "Du hast "+spielzug.getSSP()+" gespielt. Dein gegner hat "+nachrichtTeil[1]+" gespielt.";
                if (vorhandenerspielzug){
                    int sieger = siegerberechen(nachrichtTeil[1],spielzug.getSSP());
                        switch (sieger){
                            case 1 ->{
                                send(pClientIP,pClientPort,naricht1+ "\n Du hast gewonnen. ");
                                send(spielzug.getGegen().getIp(),spielzug.getGegen().getPort(),naricht2+ "\n Du hast verloren. " );
                            }
                            case 2->{
                                send(pClientIP,pClientPort,naricht1+ "\n Du hast verloren. ");
                                send(spielzug.getGegen().getIp(),spielzug.getGegen().getPort(),naricht2+ "\n Du hast gewonnen. " );
                            }
                            case 0-> {
                                send(pClientIP,pClientPort,naricht1+ "\n Es ist ein Unentschieden. ");
                                send(spielzug.getGegen().getIp(),spielzug.getGegen().getPort(),naricht2+ "\n Es ist ein Unentschieden. " );

                            }
                        }

                }else{
                    Spieler gegner=null;
                    spielerList.toFirst();
                    while (spielerList.hasAccess()){
                        if (spielerList.getContent().getName().equals(nachrichtTeil[3])){
                            gegner=spielerList.getContent();
                        }
                        spielerList.next();
                    }
                    spielzugList.append(new Spielzug(gegner,nachrichtTeil[1]));
                }
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
