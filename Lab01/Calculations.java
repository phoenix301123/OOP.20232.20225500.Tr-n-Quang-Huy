import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        // Input first double number using Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first double number: ");
        double num1 = scanner.nextDouble();

        // Input second double number using Scanner
        System.out.print("Enter the second double number: ");
        double num2 = scanner.nextDouble();

        // Calculate the results
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;

        // Check if the second number is zero to avoid division by zero
        double quotient;
        if (num2 != 0) {
            quotient = num1 / num2;
        } else {
            quotient = Double.NaN; // Set quotient to Not a Number (NaN) for undefined result
        }

        // Display the results
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + ((Double.isNaN(quotient)) ? "Undefined" : quotient));

        // Close the Scanner
        scanner.close();
    }
}




