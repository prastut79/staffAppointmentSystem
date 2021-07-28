/**
 * A class created to store details of part time hired staff.
 *
 * @author Prastut
 * @version 12/27/2019
 */

//creating a Child class named PartTimeStaffHire of the Parent class StaffHire
public class PartTimeStaffHire  extends StaffHire{

    /*
     *creating 9 instance variables for this class 
     *the Access Modifier is set to Private
     */
    private int workingHour;                //total working hour per day
    private int wagesPerHour;               //wage per hour
    private String staffName;               //the staff's name
    private String joiningDate;             //joining date
    private String qualification;           //qualification of the staff
    private String appointedBy;             //appointed by
    private String shifts;                  //working shift
    private boolean joined;                 //joining status
    private boolean terminated;             //termination status

    //Constructor for objects of class PartTimeStaffHire that takes 6 parameters
    public PartTimeStaffHire(int vacancyNumber, String designation, String jobType, int workingHour, int wagesPerHour, String shifts){
        super(vacancyNumber, designation, jobType);                           //making a call to super class with three parameters        

        //assigning the value of local variables to the instance variables
        this.workingHour = workingHour;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        staffName = "";
        joiningDate = "";
        qualification = "";
        appointedBy = "";
        joined = false;
        terminated = false;
        //the "this" keyword is used so that the program doesnot confuse the instance and the local variable
    }

    //creating 9 different accessor method that returns the values of the instance variables initilized in the constructor

    //getter method for workingHour
    public int getWorkingHour(){
        return this.workingHour;
    }

    //getter method for wagesPerHour
    public int getWagesPerHour(){
        return this.wagesPerHour;
    }

    //getter method for staffName
    public String getStaffName(){
        return this.staffName;
    }

    //getter method for joiningDate
    public String getJoiningDate(){
        return this.joiningDate;
    }

    //getter method for qualification
    public String getQualification(){
        return this.qualification;
    }

    //getter method for appointedBy
    public String getAppointedBy(){
        return this.appointedBy;
    }

    //getter method for shifts
    public String getShifts(){
        return this.shifts;
    }

    //getter method for joined
    public boolean getJoined(){
        return this.joined;
    }

    //getter method for terminated
    public boolean getTerminated(){
        return this.terminated;
    }

    //Method to set working shift(setter method)
    public void setShifts(String shifts){
        if (joined){
            System.out.println("Staff has already been hired so the shifts cannot be changed now.");    
            System.out.println("---------------------------------------\n");
        }else{
            this.shifts = shifts;
            System.out.println("The shift has been set to "+this.shifts+".");    
            System.out.println("---------------------------------------\n");
        }
    }

    //Method to store the details of the hired part time staff
    public void hirePartTime(String staffName, String joiningDate, String qualification, String appointedBy){
        //if the staff has joined
        if (joined){
            System.out.println("The staff "+this.staffName+" has already been appointed on "+this.joiningDate+".");
            System.out.println("---------------------------------------\n");

            //if the staff hasn't joined
        }else{
            this.staffName = staffName;
            this.joiningDate = joiningDate;
            this.qualification = qualification;
            this.appointedBy = appointedBy;
            joined = true;
            terminated = false;
            System.out.println("The staff "+staffName+" has sucessfully been hired by "+appointedBy+".");
            System.out.println("---------------------------------------\n");
        }
    }

    //Method to terminate the part time staff
    public void terminate(){
        //if the staff is already terminated
        if (terminated){
            System.out.println("The staff has already been terminated.");
            System.out.println("---------------------------------------\n");
            //if the staff isnt terminated
        }else{
            System.out.println(staffName+" has been terminated sucessfully."); 
            staffName = "";
            joiningDate = "";
            qualification = "";
            appointedBy = "";
            joined = false;
            terminated = true;
            System.out.println("---------------------------------------\n");
        }
    }

    //Method to display the details of the hired part time staff 
    public void display(){
        super.display();
        
        if (joined){
            System.out.println("\tPart Time Staff's Deatils");
            System.out.println("---------------------------------------");
            System.out.println("Staff's Full Name: "+staffName);
            System.out.println("Wages per hour:Rs "+wagesPerHour);
            System.out.println("Working Hour(PerDay): "+workingHour+"hrs");
            System.out.println("Joined date: "+joiningDate);
            System.out.println("Qualification: "+qualification);
            System.out.println("The staff was appointed by: "+appointedBy);
            System.out.println("Income per day:Rs "+(wagesPerHour*workingHour));
            System.out.println("---------------------------------------\n");
        }else{
            System.out.println("No staff has been appointed.");
            System.out.println("---------------------------------------\n");
        }
    }
}