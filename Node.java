import java.net.InetAddress;
import java.net.UnknownHostException;

public class Node {
    private InetAddress clientIPAddr;
    private InetAddress serverIPAddr;
    private String clientPortNumber;
    private String serverPortNumber;

    // Constructor for instances that act as either a client or a server
    public Node(String ipAddr, String portNumber, boolean isClient) {
        if (isClient) {
            try {
                this.clientIPAddr = InetAddress.getByName(ipAddr);
                this.clientPortNumber = portNumber;
            } catch (UnknownHostException e) {
                System.out.println(e);
            }
        } else {
            try {
                this.serverIPAddr = InetAddress.getByName(ipAddr);
                this.serverPortNumber = portNumber;
            } catch (UnknownHostException e) {
                System.out.println(e);
            }
        }
    }

    // Construtcor for instances that act as both clients and servers
    public Node(String clientIPAddr, String clientPortNumber,
    String serverIPAddr, String serverPortNumber) {
        try {
            this.clientIPAddr = InetAddress.getByName(clientIPAddr);
            this.clientPortNumber = clientPortNumber;
            
            this.serverIPAddr = InetAddress.getByName(serverPortNumber);
            this.serverPortNumber = serverPortNumber;
        } catch (UnknownHostException e) {
            System.out.println(e);
        }
    }

    public String getClientIPAddr() {
        return this.clientIPAddr.toString();
    }

    public String getServerIPAddr() {
        return this.serverIPAddr.toString();
    }

    public String getClientPortNumber() {
        return this.clientPortNumber;
    }

    public String getServerPortNumber() {
        return this.serverPortNumber;
    }
}