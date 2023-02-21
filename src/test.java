import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Hello, " + args[0]);

        System.out.println("Введите пожалуйста два вещественных числа х и у: ");
        double x = scan.nextDouble();
        double y = scan.nextDouble();
        double result = (3 * Math.pow(Math.cos(x - (Math.PI/6)),2)) / (0.5 + Math.sin(Math.pow(y,2)));
        System.out.println("Ваш результат " + result);
    }
}
