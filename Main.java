public class Main {
    public static void main(String[] args) {
        Node client = new Node("localhost", "6000", true);

        System.out.println(client.getClientIPAddr());
        System.out.println(client.getClientPortNumber());

        Node server = new Node("localhost", "7000", false);

        System.out.println(server.getServerIPAddr());
        System.out.println(server.getServerPortNumber());
    }
}