import jutils.Client;

/**
 * Protokoll
 * VERBINDEN:<name>   -> VERBUNDEN: <gegenspieler>
 * SPIEL:<spielzug>:<name>:<gegenspieler>
 *<spielzug>=STEIN/SCHERE/PAPIER
 */
public class SSPClientMulti extends Client {
    private String Name;
    private String gegespieler;
    private boolean verbunden;
    private boolean verabeitet;
    public SSPClientMulti(String pServerIP, int pServerPort, String pname) {
        super(pServerIP, pServerPort);
        Name=pname;
        verbunden = false;
    }

    @Override
    public void processMessage(String pMessage) {
        String[] nachrichtTeil =pMessage.split(":");
        switch (nachrichtTeil[0]){
            case "VERBUNDEN"->{
                verbunden=true;
                gegespieler= nachrichtTeil[1];
                System.out.println("Du spielst nun gegen "+ nachrichtTeil[1]);
            }
            default -> {System.out.println(pMessage);
            verabeitet=true;}

        }
    }
    public void schere(){
        verabeitet=false;
        send("SPIEL:SCHERE:"+Name+":"+ gegespieler);
    }
    public void stein(){
        verabeitet=false;
        send("SPIEL:STEIN:"+Name+":"+ gegespieler);
    }
    public void papir(){
        verabeitet=false;
        send("SPIEL:PAPIER:"+Name+":"+ gegespieler);
    }
    public void verbinden(){
        send("VERBINDEN:" + Name);
    }

    public boolean isVerabeitet() {
        return verabeitet;
    }

    public boolean isVerbunden() {
        return verbunden;
    }
}
