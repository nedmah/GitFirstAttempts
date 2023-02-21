package Sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
public class ChatClient2 {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 34522;

    public static void main(String[] args) {
        try (
                Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output  = new DataOutputStream(socket.getOutputStream())
        ) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите username");
            String msg = scan.nextLine();
            output.writeUTF(msg); // send a message to the server
            String receivedMsg = input.readUTF(); // read the reply from the server
            System.out.println("Ответ сервера: " + receivedMsg);

            String msg1;
            do {
                msg1 = scan.nextLine();
                output.writeUTF(msg1);
                receivedMsg = input.readUTF(); // read the reply from the server
                System.out.println(receivedMsg);
            } while (!msg1.equals("bye"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
