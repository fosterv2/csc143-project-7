import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;

/**
 * The class Simulation runs a simulation of a given number of calls to a call center on a given day. It uses ArrayLists to store all
 * of the Customers and Techs, and Queues are used for printing the paired customers and tech to the console. It also uses an inner class
 * that extends TimerTask to print the pairings to the console at the given interval.
 *
 * @author  Valerie Foster
 * @version 3/15/2018
 */
public class Simulation {
    private static int simulCount = 0;
    private static final int CUST_COUNT = 1000;
    private static final int TECH_COUNT = 50;
    
    // instance variables
    private int initialCust;
    private double interval;
    private int iteration;
    private Timer timer;
    private ArrayList<Customer> custArr;
    private ArrayList<Tech> techArr;
    private Queue<Customer> custQ;
    private Queue<Tech> techQ;
    private int schedule;

    /**
     * Constructor for objects of class Simulation
     * 
     * @param   initialCust  the number of customers to put into the initial queue, an Integer
     * @param   interval     the number of seconds between each call interval, a Double
     * @param   iteration    the number of calls to simulate, an Integer
     */
    public Simulation(int initialCust, double interval, int iteration) {
        this.initialCust = initialCust;
        this.interval = interval;
        this.iteration = iteration;
        custArr = new ArrayList<Customer>();
        techArr = new ArrayList<Tech>();
        custQ = new Queue<Customer>();
        techQ = new Queue<Tech>();
        schedule = (int)(Math.random() * 5) + 1;
        readFiles();
        fillQueues();
        String day = "";
        switch (schedule) {
            case 1:
                day += "Monday";
                break;
            case 2:
                day += "Tuesday";
                break;
            case 3:
                day += "Wednesday";
                break;
            case 4:
                day += "Thursday";
                break;
            case 5:
                day += "Friday";
                break;
        }
        System.out.println("Simulation run on a " + day + " with " + initialCust + " customers in the initial queue, ");
        System.out.println("a " + interval + " second interval between each call, and " + iteration + " iterations simulated.");
        System.out.println();
        timer = new Timer();
        timer.schedule(new SimulTimer(), 0, (int)(interval * 1000));
    }

    /**
     * This method reads the information from the CustomerData and TechData files into their respective ArrayLists
     */
    private void readFiles() {
        try {
            Scanner custFile = new Scanner(new File("CustomerData.txt"));
            custFile.nextLine();
            for (int ind = 0; ind < CUST_COUNT; ind++) {
                String line = custFile.nextLine();
                String[] parts = line.split(",");
                custArr.add(new Customer(parts[0], parts[1], parts[2], parts[3], parts[4]));
            }
            Scanner techFile = new Scanner(new File("TechData.txt"));
            techFile.nextLine();
            for (int ind = 0; ind < TECH_COUNT; ind++) {
                String line = techFile.nextLine();
                String[] parts = line.split(",");
                techArr.add(new Tech(parts[0], parts[1], parts[2], parts[3], Integer.parseInt(parts[4])));
            }
        } catch (FileNotFoundException e) {
        }
    }
    
    /**
     * This method uses a HashSet to get a list of the given number of customers that is guaranteed to have no repeats, then puts that list
     * into the customer queue. It also puts all of the techs working on the chosen day into the tech queue.
     */
    private void fillQueues() {
        HashSet<Customer> custHash = new HashSet<Customer>();
        while (custHash.size() < initialCust) {
            int idx = (int)(Math.random() * CUST_COUNT);
            custHash.add(custArr.get(idx));
        }
        for (Customer cust : custHash) {
            custQ.add(cust);
        }
        for (Tech tech : techArr) {
            if (tech.getSchedule() != schedule) {
                techQ.add(tech);
            }
        }
    }

    class SimulTimer extends TimerTask {
        public void run() {
            Customer cust = custQ.remove();
            System.out.println(cust.toString());
            System.out.println("|--------- paired with ---------|");
            Tech tech = techQ.remove();
            System.out.println(tech.toString());
            int idx = (int)(Math.random() * CUST_COUNT);
            custQ.add(custArr.get(idx));
            techQ.add(tech);
            System.out.println();
            simulCount++;
            if (simulCount == iteration) {
                System.out.println("Simulation ended.");
                timer.cancel();
            }
        }
    }
    
}
