import java.util.Scanner;

/**
 * The class Main uses a main method to gather data to pass to Simulation by interacting with the user. It also has helper methods to do this. 
 *
 * @author  Valerie Foster
 * @version 3/15/2018
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.print("\u000c");
        
        Scanner console = new Scanner(System.in);
        
        System.out.println("Input an integer number of customers to put into the initial queue, between 1 and 100.");
        while (!console.hasNextInt()) {
            console.next();
            System.out.println("Invalid input. Please input an integer.");
        }
        int initialCust = console.nextInt();
        initialCust = getInRangeInt(console, initialCust, 1, 100);
        
        System.out.println("Input a number for the iteration interval in seconds, between 0.25 and 5.0.");
        while (!console.hasNextDouble()) {
            console.next();
            System.out.println("Invalid input. Please input a number.");
        }
        double interval = console.nextDouble();
        interval = getInRangeDouble(console, interval, 0.25, 5.0);
        
        System.out.println("Input an integer number for iterations to simulate, between 10 and 100.");
        while (!console.hasNextInt()) {
            console.next();
            System.out.println("Invalid input. Please input an integer.");
        }
        int iteration = console.nextInt();
        iteration = getInRangeInt(console, iteration, 10, 100);
        
        System.out.println();
        Simulation simul = new Simulation(initialCust, interval, iteration);
        
    }
    
    private static int getInRangeInt(Scanner console, int value, int min, int max) {
        while (value < min || value > max) {
            System.out.println("Invalid input. Please input an integer between " + min + " and " + max + ".");
            while (!console.hasNextInt()) {
                console.next();
                System.out.println("Invalid input. Please input an integer.");
            }
            value = console.nextInt();
        }
        return value;
    }
    
    private static double getInRangeDouble(Scanner console, double value, double min, double max) {
        while (value < min || value > max) {
            System.out.println("Invalid input. Please input a number between " + min + " and " + max + ".");
            while (!console.hasNextDouble()) {
                console.next();
                System.out.println("Invalid input. Please input a number.");
            }
            value = console.nextDouble();
        }
        return value;
    }
    
}
