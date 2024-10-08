import java.net.InetAddress;

public class Main {
    public static void main(String[] args) {
        String addr;
        try{
            addr = "127.0.0.1";
            Node A = new Node(addr, 6000);
            Node B = new Node(addr, 7000);
            Node C = new Node(addr, 8000);
            Node D = new Node(addr, 9000);

            A.receiveNumber();
            B.receiveNumber();
            C.receiveNumber();
            D.receiveNumber();



            A.sendNumber(B.getIPAddr(), B.getPortNumber()); // A --> B
            Thread.sleep(150);
            System.out.println("A TO B: " + B.getReceivedNumberMessage());
            

            B.sendNumber(C.getIPAddr(), C.getPortNumber()); // B --> C
            Thread.sleep(150);
            System.out.println("B TO C: " + C.getReceivedNumberMessage());

            C.sendNumber(D.getIPAddr(), D.getPortNumber()); // C --> D
            Thread.sleep(150);
            System.out.println("C TO D: " + D.getReceivedNumberMessage());

            D.sendNumber(A.getIPAddr(), A.getPortNumber()); // D -- > A
            Thread.sleep(150);
            System.out.println("D TO A: " + A.getReceivedNumberMessage());

            System.exit(0);
        } catch (Exception e) {
        }
    }
}