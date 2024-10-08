import java.net.Socket;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class ClientHandler implements Runnable {
    private Node node;
    public ClientHandler(Node node) {
        this.node = node;
    }

    public void run() {
        while (true) {
            try (Socket connection = this.node.getServer().accept()) {
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String response = br.readLine();

                this.node.setReceivedNumberMessage(Integer.parseInt(response));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}