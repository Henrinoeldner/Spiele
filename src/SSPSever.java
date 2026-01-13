import jutils.Server;

import java.util.Map;
import java.util.Random;

public class SSPSever extends Server {
    public SSPSever(int pPort) {
        super(pPort);
    }

    @Override
    public void processNewConnection(String pClientIP, int pClientPort) {

    }

    @Override
    public void processMessage(String pClientIP, int pClientPort, String pMessage) {
        String[] Ergenisse ={"Stein","Schere","Papir"};
        int com= (int)Math.random()*4;
        switch (pMessage) {
            case "SCHERE" ->




                    send(pClientIP, pClientPort, "Stein");
            case "STEIN" -> send(pClientIP, pClientPort, "Stein");
            case "PAPIR" ->
                    }
    }

    @Override
    public void processClosingConnection(String pClientIP, int pClientPort) {

    }
}
