import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MathClient {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 34522;

    public static void main(String[] args) {
        try (
                Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output  = new DataOutputStream(socket.getOutputStream())
        ) {
            String msg;
            msg = input.readUTF();
            System.out.println(msg);
            Scanner scanner = new Scanner(System.in);
            String v = scanner.nextLine();
            output.writeUTF(v); // send a message to the server
            String receivedMsg = input.readUTF(); // read the reply from the server

            System.out.println("Received from the server: " + receivedMsg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
