import jutils.Client;

/**
 * Protokoll
 * VERBINDEN:<name>   -> VERBUNDEN: <gegenspieler>
 * SCHERE:<name>:<gegenspieler>
 * STEIN:<name>:<gegenspieler>
 * PAPIER:<name>:<gegenspieler>
 */
public class SSPClientMulti extends Client {
    private String Name;
    private String gegespieler;
    public SSPClientMulti(String pServerIP, int pServerPort) {
        super(pServerIP, pServerPort);
    }

    @Override
    public void processMessage(String pMessage) {
        System.out.println(pMessage);
    }
    public void schere(){
        send("SCHERE");
    }
    public void stein(){
        send("STEIN");
    }
    public void papir(){
        send("PAPIER");
    }
    public void verbinden(String pName){
        send("VERBINDEN:" + pName);
    }
}
