public class Spieler {
    private String name;
    private boolean istverbunden;
    private String ip;
    private int port;

    /**
     *
     * @param name
     * @param ip
     * @param port
     */
    public Spieler(String name, String ip, int port) {
        this.name = name;
        this.istverbunden = false;
        this.ip = ip;
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIstverbunden() {
        return istverbunden;
    }

    public void setIstverbunden(boolean istverbunden) {
        this.istverbunden = istverbunden;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
