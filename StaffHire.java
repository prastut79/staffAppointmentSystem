
/**
 * A class created to store job details.
 *
 * @author Prastut
 * @version 12/27/2019
 */
//creating a Parent class named "StaffHire"
public class StaffHire{
    /*
     *creating 3 instance variables for this class 
     *the Access Modifier is set to Private
     */
    private int vacancyNumber;                           //VacancyNumber
    private String designation;                          //Designation  
    private String jobType;                              //JobType

    //Constructor for objects of class StaffHire that takes three parameters 
    public StaffHire(int vacancyNumber, String designation, String jobType){
        //assigning the value of local variables to the instance variables
        this.vacancyNumber = vacancyNumber;
        this.designation = designation;
        this.jobType = jobType;
        //the "this" keyword is used so that the program doesnot confuse the instance and the local variable
    }

    //creating accessor and mutator for each of the attributes  

    //getter method for vacancyNumber
    public int getVacancyNumber(){
        return this.vacancyNumber;
    }
    //setter method for vacancyNumber
    public void setVacancyNumber(int vacancyNumber){
        this.vacancyNumber = vacancyNumber;
    }

    //getter method for designation
    public String getDesignation(){
        return this.designation;
    }
    //setter method for designation
    public void setDesignation(String designation){
        this.designation = designation;
    }

    //getter method for jobType
    public String getJobType(){
        return this.jobType;
    }
    //setter method for jobType
    public void setJobType(String jobType){
        this.jobType = jobType;
    }

    //creating method named display for generating output
    public void display(){
        System.out.println("---------------------------------------"); 
        System.out.println("\t\tJob Details");
        System.out.println("---------------------------------------");                                                                               
        System.out.println("Vacancy Number: "+vacancyNumber);
        System.out.println("Desigantion: "+designation);
        System.out.println("Job Type: "+jobType);
        System.out.println("---------------------------------------");
    }
}


