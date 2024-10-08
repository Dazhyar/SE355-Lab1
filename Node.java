import java.net.InetAddress;

public class Node {
    private InetAddress clientIPAddr;
    private InetAddress serverIPAddr;
    private String clientPortAddr;
    private String serverPortAddr;

    public Node(InetAddress clientIPAddr, String clientPortAddr) {
        this.clientIPAddr = clientIPAddr;
        this.clientPortAddr = clientPortAddr;
    }
}