import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Random;
import java.net.ServerSocket;

public class Node {
    private ServerSocket server;
    private InetAddress ipAddr;
    private int portNumber;
    private int receivedNumberMessage;

    // Construtcor for instances that act as both clients and servers
    public Node(String ipAddr, int portNumber) {
        try {
            this.ipAddr = InetAddress.getByName(ipAddr);
            this.portNumber = portNumber;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getIPAddr() {
        return this.ipAddr.getHostAddress();
    }

    public int getPortNumber() {
        return this.portNumber;
    }

    public ServerSocket getServer() {
        return this.server;
    }

    public int getReceivedNumberMessage() {
        return this.receivedNumberMessage;
    }

    public void setReceivedNumberMessage(int receivedNumberMessage) {
        this.receivedNumberMessage = receivedNumberMessage;
    }

    private void createServerSocket() {
        try {
            this.server = new ServerSocket(this.portNumber);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void sendNumber(String serverIPAddr, int serverPortNumber) {
        try (Socket client = new Socket(serverIPAddr, serverPortNumber)) {
            OutputStreamWriter osw = new OutputStreamWriter(client.getOutputStream());
            Random random = new Random();
            int randomInt = random.nextInt(100) + 1;

            osw.write(randomInt + "\n");
            osw.flush();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void receiveNumber() {
        createServerSocket();
        try {            
            ClientHandler ch = new ClientHandler(this);
            Thread t1 = new Thread(ch);
            t1.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}