import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class test {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Hello, " + args[0]);

//        System.out.println("Введите пожалуйста два вещественных числа х и у: ");
//        double x = scan.nextDouble();
//        double y = scan.nextDouble();
//        double result = (3 * Math.pow(Math.cos(x - (Math.PI/6)),2)) / (0.5 + Math.sin(Math.pow(y,2)));
//        System.out.println("Ваш результат " + result);

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
        double result;
try {
    switch (parseInt(args[1])) {
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
} catch (NumberFormatException e) {
    e.printStackTrace();
}

    }
}
