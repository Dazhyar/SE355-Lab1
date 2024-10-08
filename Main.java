import java.net.InetAddress;

public class Main {
    public static void main(String[] args) {
        String addr;
        try{
            addr = InetAddress.getLocalHost().getHostAddress();
            Node client = new Node(addr, 6000, "time.nist.gov", 13);
            client.sendNumber();
            
                    System.out.println(client.getClientIPAddr());
                    System.out.println(client.getClientPortNumber());

        } catch (Exception e) {

        }
    }
}