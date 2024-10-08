import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.ServerSocket;

public class Node {
    private Socket client;
    private ServerSocket server;
    private InetAddress clientIPAddr;
    private InetAddress serverIPAddr;
    private int clientPortNumber;
    private int serverPortNumber;

    // Construtcor for instances that act as both clients and servers
    public Node(String clientIPAddr, int clientPortNumber,
    String serverIPAddr, int serverPortNumber) {
        try {
            this.clientIPAddr = InetAddress.getByName(clientIPAddr);
            this.clientPortNumber = clientPortNumber;
            
            this.serverIPAddr = InetAddress.getByName(serverIPAddr);
            this.serverPortNumber = serverPortNumber;
            
            this.createClientSocket();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getClientIPAddr() {
        return this.clientIPAddr.toString();
    }

    public String getServerIPAddr() {
        return this.serverIPAddr.toString();
    }

    public int getClientPortNumber() {
        return this.clientPortNumber;
    }

    public int getServerPortNumber() {
        return this.serverPortNumber;
    }

    private void createClientSocket() {
        try {
            this.client = new Socket(this.serverIPAddr, this.serverPortNumber, this.clientIPAddr, this.clientPortNumber);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void sendNumber() {
        try (InputStreamReader ir = new InputStreamReader(this.client.getInputStream())) {
            BufferedReader br = new BufferedReader(ir);

            StringBuilder sb = new StringBuilder();
            String response = "";
            while ((response = br.readLine()) != null) {
                sb.append(response + "\n");
            }

            System.out.println(sb.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}