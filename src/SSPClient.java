import jutils.Client;

/**
 * Protokol
 * SCHERE
 * STEIN
 * PAPIR
 */
public class SSPClient extends Client {
    public SSPClient(String pServerIP, int pServerPort) {
        super(pServerIP, pServerPort);
    }

    @Override
    public void processMessage(String pMessage) {

    }
    public void schere(){
        send("SCHERE");
    }
    public void stein(){
        send("STEIN");
    }
    public void papir(){
        send("PAPIR");
    }
}
