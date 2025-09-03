import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(9876);
        byte[] receiveData = new byte[1024];
        byte[] sendData;

        System.out.println("Server is running... waiting for client...");

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);

            String clientMsg = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Client says: " + clientMsg);

            String response = "Message received: " + clientMsg;
            sendData = response.getBytes();

            InetAddress clientIP = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientIP, clientPort);
            socket.send(sendPacket);
        }
    }
}
