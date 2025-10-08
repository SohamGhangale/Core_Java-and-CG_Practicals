import java.util.Scanner;

public class CalculatorTryCatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("*** Simple Calculator ***");
        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        System.out.println("\nChoose an operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Enter your choice (1-4): ");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Result: " + (a + b));
                break;

            case 2:
                System.out.println("Result: " + (a - b));
                break;

            case 3:
                System.out.println("Result: " + (a * b));
                break;

            case 4:
                try {
                    int result = a / b;
                    System.out.println("Result: " + result);
                } catch (ArithmeticException e) {
                    System.out.println("Error: Cannot divide by zero!");
                }
                break;

            default:
                System.out.println("Invalid choice! Please choose between 1 to 4.");
        }

        sc.close();
        System.out.println("\nCalculation completed. Thank you!");
    }
}
