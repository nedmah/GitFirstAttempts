import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MathServer {

    private static final int PORT = 34522;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Сервер запущен и готов работать.");

        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                try (
                        Socket socket = server.accept(); // accept a new client
                        DataInputStream input = new DataInputStream(socket.getInputStream());
                        DataOutputStream output = new DataOutputStream(socket.getOutputStream())
                ) {
                    String username = args[0];
                    System.out.println("К нам пришёл " + username);
                    output.writeUTF("Hello, " + args[0] +". Введите вариант: ");

                    String v = input.readUTF();
                    double result = 0;
                    double a = Double.parseDouble(args[2]);
                    double a1 = Double.parseDouble(args[3]);
                    double a2 = Double.parseDouble(args[4]);
                    double b = Double.parseDouble(args[5]);
                    double c = Double.parseDouble(args[6]);
                    double x = Double.parseDouble(args[7]);
                    double y = Double.parseDouble(args[8]);
                    double w = Double.parseDouble(args[9]);
                    double n = Double.parseDouble(args[10]);
                    double d = Double.parseDouble(args[11]);

                    switch (Integer.parseInt(v)) {
                        case (1) -> {
                            result = ((5 * Math.pow(a, n * x)) / (b + c)) - (Math.sqrt(Math.abs(Math.cos(Math.pow(x, 3)))));
                            System.out.println(result);
                        }
                        case (2) -> {
                            result = (Math.abs(x - y) / Math.pow((1 + 2 * x), a)) - Math.exp(Math.sqrt(1 + w));
                            System.out.println(result);
                        }
                        case (3) -> {
                            result = Math.sqrt(a + a1 * x + a2 * Math.pow(Math.sqrt(Math.abs(Math.sin(x))), 0.33));
                            System.out.println(result);
                        }
                        case (4) -> {
                            result = Math.log(Math.abs(Math.pow(a, 7))) + Math.atan(x * x) + (Math.PI / (Math.sqrt(Math.abs(a + x))));
                            System.out.println(result);
                        }
                        case (5) -> {
                            result = Math.pow(Math.sqrt(Math.pow(a + b, 2) / c + d) + Math.exp(Math.sqrt(x + 1)), 1.0 / 5.0);
                            System.out.println(result);
                        }
                        case (6) -> {
                            result = Math.exp((2.0 * Math.sin(4.0 * x) + Math.pow(Math.cos(Math.pow(x, 2.0)), 2.0))) / (3.0 * x);
                            System.out.println(result);
                        }
                        case (7) -> {
                            result = 0.25 * (((1.0 + Math.pow(x, 2.0)) / (1.0 - x)) + 0.5 * Math.tan(x));
                            System.out.println(result);
                        }
                    }





                        System.out.println("Получено сообщение: " + v);
                        output.writeUTF("Ваш результат: " + result);


                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
