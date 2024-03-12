
import java.util.Scanner;
import java.lang.math;
public class Equation {
    public static void linearEquation(double a, double b) {
        if (a == 0 && b == 0) 
            System.out.println("The equation has infinite solutions\n");
        else if (a == 0 && b != 0) 
            System.out.println("The equation has no solution\n");
        else {
            double x = -b / a;
            System.out.println("The solution is x = " + x);
        }
    }

    public static void linearSystem(double a1, double a2, double b1, double b2, double c1, double c2) {
        double D = a1 * b2 - a2 * b1;
        double Dx = c1 * b2 - c2 * b1;
        double Dy = a1 * c2 - a2 * c1;
        if (D == 0 && Dx == 0 && Dy == 0) 
            System.out.println("The system has infinite solutions\n");
        else if ((D == 0 && Dx != 0) || (D == 0 && Dy != 0))  
            System.out.println("The system has no real solution\n");
        else 
            System.out.println("x = " + (Dx / D) + " y = " + (Dy / D));
    }

    public static void quadraticEquation(double a, double b, double c) {
        if (a == 0 && b != 0) 
            System.out.println("The equation has a solution x = " + (-c / b));
        else if (a == 0 && b == 0 && c == 0) 
            System.out.println("The equation has infinite solutions");
        else if (a == 0 && b == 0 && c != 0) 
            System.out.println("The equation has no solution");
        else {
            double delta = b * b - 4 * a * c;
            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("\n x1 = " + x1 + "\n x2 = " + x2);
            } else if (delta == 0) {
                double xx = -b / (2 * a);
                System.out.println("The equation has one solution x = " + xx);
            } else if (delta < 0) 
                System.out.println("The equation has no solution");
        }
    }

    public static void menu() {
        System.out.println("\n1) Linear equation \n2) Linear system \n3) Quadratic equation");
    }

    public static void main(String[] args) {
        double a, b, c;
        menu();
        try (Scanner sc = new Scanner(System.in)) {
            int function = sc.nextInt();
            if (function == 1) {
                System.out.println("Enter the coefficients (ax + b = 0): ");
                System.out.print("Input a: "); a = sc.nextDouble();
                System.out.print("Input b: "); b = sc.nextDouble();
                linearEquation(a, b);
            }
            if (function == 2) {
                double a1, a2, b1, b2, c1, c2;
                System.out.println("Enter the coefficients(a1x + b1y = c1; a2x + b2y = c2): ");
                System.out.print("Input a1: "); a1 = sc.nextDouble();
                System.out.print("Input a2: "); a2 = sc.nextDouble();
                System.out.print("Input b1: "); b1 = sc.nextDouble();
                System.out.print("Input b2: "); b2 = sc.nextDouble();
                System.out.print("Input c1: "); c1 = sc.nextDouble();
                System.out.print("Input c2: "); c2 = sc.nextDouble();
                linearSystem(a1, a2, b1, b2, c1, c2);
            }
            if (function == 3) {
                System.out.println("Enter the coefficients(ax**2 + b*x + c = 0): ");
                System.out.print("Input a: "); a = sc.nextDouble();
                System.out.print("Input b: "); b = sc.nextDouble();
                System.out.print("Input c: "); c = sc.nextDouble();
                quadraticEquation(a, b, c);
            }
        }
    }
}
