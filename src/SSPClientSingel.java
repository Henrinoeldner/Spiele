import jutils.Client;

/**
 * Protokoll
 * SCHERE
 * STEIN
 * PAPIER
 */
public class SSPClientSingel extends Client {
    public SSPClientSingel(String pServerIP, int pServerPort) {
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
}
