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

                    switch (Integer.parseInt(v)) {
                        case (1) -> {
                            output.writeUTF( "Введите a, n, x, b, c : ");
                            double a = Double.parseDouble(input.readUTF());
                            double n = Double.parseDouble(input.readUTF());
                            double x = Double.parseDouble(input.readUTF());
                            double b = Double.parseDouble(input.readUTF());
                            double c = Double.parseDouble(input.readUTF());
                            result = ((5 * Math.pow(a, n * x)) / (b + c)) - (Math.sqrt(Math.abs(Math.cos(Math.pow(x, 3)))));
                            System.out.println(result);
                        }
                        case (2) -> {
                            output.writeUTF( "Введите x, y, a, w : ");
                            double x = Double.parseDouble(input.readUTF());
                            double y = Double.parseDouble(input.readUTF());
                            double a = Double.parseDouble(input.readUTF());
                            double w = Double.parseDouble(input.readUTF());
                            result = (Math.abs(x - y) / Math.pow((1 + 2 * x), a)) - Math.exp(Math.sqrt(1 + w));
                            System.out.println(result);
                        }
                        case (3) -> {
                            output.writeUTF( "Введите a, a1, x, a2 : ");
                            double a = Double.parseDouble(input.readUTF());
                            double a1 = Double.parseDouble(input.readUTF());
                            double x = Double.parseDouble(input.readUTF());
                            double a2 = Double.parseDouble(input.readUTF());
                            result = Math.sqrt(a + a1 * x + a2 * Math.pow(Math.sqrt(Math.abs(Math.sin(x))), 0.33));
                            System.out.println(result);
                        }
                        case (4) -> {
                            output.writeUTF( "Введите a, x : ");
                            double a = Double.parseDouble(input.readUTF());
                            double x = Double.parseDouble(input.readUTF());
                            result = Math.log(Math.abs(Math.pow(a, 7))) + Math.atan(x * x) + (Math.PI / (Math.sqrt(Math.abs(a + x))));
                            System.out.println(result);
                        }
                        case (5) -> {
                            output.writeUTF( "Введите a, b, c, d, x : ");
                            double a = Double.parseDouble(input.readUTF());
                            double b = Double.parseDouble(input.readUTF());
                            double c = Double.parseDouble(input.readUTF());
                            double d = Double.parseDouble(input.readUTF());
                            double x = Double.parseDouble(input.readUTF());
                            result = Math.pow(Math.sqrt(Math.pow(a + b, 2) / c + d) + Math.exp(Math.sqrt(x + 1)), 1.0 / 5.0);
                            System.out.println(result);
                        }
                        case (6) -> {
                            output.writeUTF( "Введите x : ");
                            double x = Double.parseDouble(input.readUTF());
                            result = Math.exp((2.0 * Math.sin(4.0 * x) + Math.pow(Math.cos(Math.pow(x, 2.0)), 2.0))) / (3.0 * x);
                            System.out.println(result);
                        }
                        case (7) -> {
                            output.writeUTF( "Введите x : ");
                            double x = Double.parseDouble(input.readUTF());
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
