
/**
 * The class Customer has information about a customer and accessor methods to retrieve the information.
 *
 * @author  Valerie Foster
 * @version 3/15/2018
 */
public class Customer {
    
    // instance variables
    private String number;
    private String fName;
    private String lName;
    private String email;
    private String phone;

    /**
     * Constructor for objects of class Customer
     * 
     * @param   number  a number for identifying this Customer
     * @param   fName   a first name for the Customer
     * @param   lName   a last name for the Customer
     * @param   email   an email for the Customer
     * @param   phone   a phone number for the Customer
     */
    public Customer(String number, String fName, String lName, String email, String phone) {
        this.number = number;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phone = phone;
    }

    /**
     * An accessor method - returns a number for identifying this customer
     *
     * @return    the number of this Customer, a String
     */
    public String getNumber() {
        return this.number;
    }
    
    /**
     * An accessor method - returns a first name for the customer
     *
     * @return    the fName of this Customer, a String
     */
    public String getFName() {
        return this.fName;
    }
    
    /**
     * An accessor method - returns a last name for the customer
     *
     * @return    the lName of this Customer, a String
     */
    public String getLName() {
        return this.lName;
    }
    
    /**
     * An accessor method - returns an email for the customer
     *
     * @return    the email of this Customer, a String
     */
    public String getEmail() {
        return this.email;
    }
    
    /**
     * An accessor method - returns a phone number for the customer
     *
     * @return    the phone of this Customer, a String
     */
    public String getPhone() {
        return this.phone;
    }
    
    /** 
     * Creates and returns a string representation of this customer
     * 
     * @return  a String showing basic information about the Customer
     */
    @Override
    public String toString() {
        String str = "";
        str += number + ", " + fName + " " + lName + ", " + email + ", " + phone;
        return str;
    }
    
}
