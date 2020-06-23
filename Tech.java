
/**
 * The class Tech has information about a tech and accessor methods to retrieve the information.
 *
 * @author  Valerie Foster
 * @version 3/15/2018
 */
public class Tech {
    
    // instance variables
    private String id;
    private String fName;
    private String lName;
    private String userName;
    private int schedule;

    /**
     * Constructor for objects of class Tech
     * 
     * @param   id          an id for identifying this Tech
     * @param   fName       a first name for the Tech
     * @param   lName       a last name for the Tech
     * @param   userName    a userName for the Tech
     * @param   schedule    a number for the schedule for the Tech
     */
    public Tech(String id, String fName, String lName, String userName, int schedule) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.userName = userName;
        this.schedule = schedule;
    }

    /**
     * An accessor method - returns an id for the tech
     *
     * @return    the id of this Tech, a String
     */
    public String getId() {
        return this.id;
    }
    
    /**
     * An accessor method - returns a first name for the tech
     *
     * @return    the fName of this Tech, a String
     */
    public String getFName() {
        return this.fName;
    }
    
    /**
     * An accessor method - returns a last name for the tech
     *
     * @return    the lName of this Tech, a String
     */
    public String getLName() {
        return this.lName;
    }
    
    /**
     * An accessor method - returns a username for the tech
     *
     * @return    the userName of this Tech, a String
     */
    public String getUserName() {
        return this.userName;
    }
    
    /**
     * An accessor method - returns a number representation of a scedule for the tech
     *
     * @return    the schedule of this Tech, an Integer
     */
    public int getSchedule() {
        return this.schedule;
    }
    
    /** 
     * Creates and returns a string representation of this tech
     * 
     * @return  a String showing basic information about the Tech
     */
    @Override
    public String toString() {
        String str = "";
        str += id + ", " + fName + " " + lName + ", " + userName + ", off ";
        switch (schedule) {
            case 1:
                str += "Monday";
                break;
            case 2:
                str += "Tuesday";
                break;
            case 3:
                str += "Wednesday";
                break;
            case 4:
                str += "Thursday";
                break;
            case 5:
                str += "Friday";
                break;
        }
        return str;
    }
    
}
