import java.util.Scanner;

public class QuadraticEquationSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input coefficients
        System.out.println("Quadratic Equation: ax² + bx + c = 0");
        System.out.print("Enter coefficient a: ");
        double a = scanner.nextDouble();
        
        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();
        
        System.out.print("Enter coefficient c: ");
        double c = scanner.nextDouble();
        
        // Check if it's a quadratic equation
        if (a == 0) {
            System.out.println("This is not a quadratic equation (a cannot be zero)");
            return;
        }
        
        // Calculate discriminant
        double discriminant = b * b - 4 * a * c;
        
        // Find roots based on discriminant value
        if (discriminant > 0) {
            // Two real and distinct roots
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            
            System.out.println("Two distinct real roots:");
            System.out.printf("Root 1 = %.2f%n", root1);
            System.out.printf("Root 2 = %.2f%n", root2);
            
        } else if (discriminant == 0) {
            // One real root (repeated)
            double root = -b / (2 * a);
            
            System.out.println("One real root (repeated):");
            System.out.printf("Root = %.2f%n", root);
            
        } else {
            // Complex roots
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
            
            System.out.println("Two complex roots:");
            System.out.printf("Root 1 = %.2f + %.2fi%n", realPart, imaginaryPart);
            System.out.printf("Root 2 = %.2f - %.2fi%n", realPart, imaginaryPart);
        }
        
        scanner.close();
    }
}
