/**
 * A class created to store details of full time hired staff.
 *
 * @author Prastut
 * @version 12/27/2019
 */

//creating a Child class named FullTimeStaffHire of the Parent class StaffHire
public class FullTimeStaffHire extends StaffHire{

    /*
     *creating 7 instance variables for this class 
     *the Access Modifier is set to Private
     */
    private int salary;                         //Salary
    private int workingHour;                    //Total working hour per day
    private String staffName;                   //Staff's name
    private String joiningDate;                 //Joined date
    private String qualification;               //Qualification
    private String appointedBy;                 //Appointed by
    private boolean joined;                     //Joining status

    //Constructor for objects of class FullTimeStaffHire that takes 5 parameters
    public FullTimeStaffHire(int vacancyNumber, String designation, String jobType, int salary, int workingHour){
        super(vacancyNumber, designation, jobType);                      //making a call to super class with three parameters       
        //we dont need to declare these instance variables in the sub class

        //assigning the value of local variables to the instance variables
        this.salary = salary;
        this.workingHour = workingHour;
        staffName = "";
        joiningDate = "";
        qualification = "";        
        appointedBy = "";
        joined = false;
        //the "this" keyword is used so that the program doesnot confuse the instance and the local variable
    }

    //creating 7 different accessor method that returns the values of the instance variables initilized in the constructor

    //getter method for salary
    public int getSalary(){
        return this.salary;
    }

    //getter method for workingHour
    public int getWorkingHour(){
        return this.workingHour;
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

    ///getter method for joined
    public boolean getJoined(){
        return this.joined;
    }

    //method to assign new salary(setter method)
    public void setSalary(int salary){
        if (joined){
            System.out.println("The staff has already joined so changing the salary isnt possible.");  
            System.out.println("---------------------------------------\n");
        }else{
            this.salary = salary;
            System.out.println("The salary has been set to Rs."+this.salary);
            System.out.println("---------------------------------------\n");
        }
    }

    //method to assign working hour(setter method)
    public void setWorkingHour(int workingHour){
        this.workingHour = workingHour;
        System.out.println("The working hour has been set to "+this.workingHour+" hrs.");
        System.out.println("---------------------------------------\n");
    }

    //method to store details of full time hired staff
    public void hireFullTime(String staffName, String joiningDate, String qualification, String appointedBy){
        if (joined){
            //displaying staff name and joined date if the staff has already joined 
            System.out.println("The staff "+this.staffName+" has already been appointed on "+this.joiningDate+".");
            System.out.println("---------------------------------------\n");
        }else{
            //hiring the staff if the staff has not joined
            this.staffName = staffName;
            this.joiningDate = joiningDate;
            this.qualification = qualification;
            this.appointedBy = appointedBy;
            joined = true;
            System.out.println("The staff "+staffName+" has sucessfully been hired by "+appointedBy+".");
            System.out.println("---------------------------------------\n");
        }
    }

    //method overriding to display the all the details of full time hired staff
    public void display(){
        super.display();
        //displaying staff details if the staff has already joined 
        if (joined){
            System.out.println("\tFull time Staff's Deatils");
            System.out.println("---------------------------------------");
            System.out.println("Staff's Full Name: "+staffName);
            System.out.println("Staff's Total Salary:Rs."+salary);
            System.out.println("Working Hour(per day): "+workingHour+" hrs");
            System.out.println("Joined date: "+joiningDate);
            System.out.println("Staff's Qualification: "+qualification);
            System.out.println("The staff was appointed by: "+appointedBy);
            System.out.println("---------------------------------------\n");
            //displaying that the staff hasnt been appointed
        }else{
            System.out.println("No staff has been appointed.");
            System.out.println("---------------------------------------\n");
        }
    }
}