package Sockets;

import java.io.*;
import java.net.*;

public class ChatServer {

    private static final int PORT = 34522;

    public static void main(String[] args) {
        System.out.println("Сервер запущен и готов работать.");
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                Session session = new Session(server.accept());
                session.start();


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



class Session extends Thread {
    private final Socket socket;

    public Session(Socket socketForClient) {
        this.socket = socketForClient;
    }
    public void run() {

        try(DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream())
        ) {
            String username = input.readUTF(); // read a message from the client
            System.out.println("К нам пришёл " + username);
            output.writeUTF("Hello, " + username); // resend it to the client
            String msg;
            int n = 1;
            do {
                msg = input.readUTF();
                System.out.println("Получено сообщение № " + n + " - " + msg);
                output.writeUTF("Ответ сервера: " + n + " - " + msg);
                n++;
                if(username.equals("admin") && msg.equals("exit")){
                    socket.shutdownInput();
                    socket.shutdownOutput();
                    socket.close();
                }
            } while (!msg.equals("bye"));
        socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
