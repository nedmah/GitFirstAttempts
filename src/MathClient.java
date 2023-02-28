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


            switch (Integer.parseInt(v)){
                case (1), (5) -> {
                    System.out.println(input.readUTF());
                    String a = scanner.nextLine();
                    String n = scanner.nextLine();
                    String x = scanner.nextLine();
                    String b = scanner.nextLine();
                    String c = scanner.nextLine();
                    output.writeUTF(a);
                    output.writeUTF(n);
                    output.writeUTF(x);
                    output.writeUTF(b);
                    output.writeUTF(c);
                }
                case(2), (3) -> {
                    System.out.println(input.readUTF());
                    String x = scanner.nextLine();
                    String y = scanner.nextLine();
                    String a = scanner.nextLine();
                    String w = scanner.nextLine();
                    output.writeUTF(x);
                    output.writeUTF(y);
                    output.writeUTF(a);
                    output.writeUTF(w);
                }
                case(4) -> {
                    System.out.println(input.readUTF());
                    String a = scanner.nextLine();
                    String x = scanner.nextLine();
                    output.writeUTF(a);
                    output.writeUTF(x);
                }
                case(6), (7) -> {
                    System.out.println(input.readUTF());
                    String x = scanner.nextLine();
                    output.writeUTF(x);
                }
            }

            String receivedMsg = input.readUTF(); // read the reply from the server
            System.out.println("Received from the server: " + receivedMsg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
