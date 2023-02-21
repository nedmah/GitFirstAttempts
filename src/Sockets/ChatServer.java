package Sockets;

import java.io.*;
import java.net.*;

public class ChatServer {

    private static final int PORT = 34522;

    public static void main(String[] args) {
        System.out.println("Сервер запущен и готов работать.");
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                try (
                        Socket socket = server.accept(); // accept a new client
                        DataInputStream input = new DataInputStream(socket.getInputStream());
                        DataOutputStream output = new DataOutputStream(socket.getOutputStream())
                ) {
                    String username = input.readUTF(); // read a message from the client
                    System.out.println("К нам пришёл " + username);
                    output.writeUTF("Hello, " + username); // resend it to the client
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
