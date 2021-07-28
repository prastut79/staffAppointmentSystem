 

/**
 * A class to hire staff using Java GUI
 * @author (Prastut)
 * @version (4/01/2020)
 */ 

//importing predefined classes
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.ArrayList;
import java.awt.Font;

public class INGNepal implements ActionListener{
    //initiliazing Different variables used for the chooseStaffGUI
    private JFrame frameChooseStaff;
    private JButton btnChooseFullTime, btnChoosePartTime, btnAllDisplay;
    private JLabel lblHeader, lblText;
    private Font fontHeading, fontSubHeading, fontBtn, fontLblText;

    private ArrayList <StaffHire> list = new ArrayList<StaffHire>();
   

    //initiliazing Different variables used in the fullTimeStaffHireGUI
    private JFrame frameFullTime;
    private JTextField tfFVacNum, tfFDesignation, tfFSalary, tfFWorkingHour;
    private JComboBox<String> jcFJobType, jcFullDateYear, jcFullDateMonth, jcFullDateDay;
    private JTextField tfFullVacancyNumber, tfFullStaffName, tfFullQualification, tfFullAppointedBy;
    private JButton btnFullAdd, btnFullAppoint, btnFullDisplay, btnFullClear;

    

    //------------------------------------------------------------------------------------------------//

    //initiliazing Different variables used in the partTimeStaffHireGUI
    private JFrame framePartTime;
    private JTextField tfPVacNum, tfPDesignation, tfPWagesPerHour, tfPWorkingHour;
    private JTextField tfPartVacancyNumber, tfPartStaffName, tfPartQualification, tfPartAppointedBy;
    private JComboBox <String> jcPJobType, jcPShift, jcPartDateYear, jcPartDateMonth, jcPartDateDay;
    private JButton btnPartAdd, btnPartAppoint, btnPartTerminate, btnPartDisplay, btnPartClear;


    //------------------------------------------------------------------------------------------------//
    
    

    public static void main(String args[]){
        INGNepal obj = new INGNepal();
        obj.chooseStaffGUI();
    }

    //method for changing the font
    public void font(){
        //creating object of the font class
        fontHeading = new Font("Helvetica",Font.BOLD,35);
        fontSubHeading = new Font("Helvetica",Font.PLAIN,30);
        fontBtn = new Font("Helvetica",Font.PLAIN,20);
        fontLblText = new Font("Helvetica",Font.PLAIN,16);
    
    }

 	//-----------------------GUI for choosing staff----------------------------//
    public void chooseStaffGUI(){
    	font();
    	
    	int BTN_CHOOSE_STAFF_WIDTH = 250;
        int BTN_CHOOSE_STAFF_HEIGHT = 80;
        int BTN_Y_DISTANCE = 240;
        int BTN_X_DISTANCE = 80;
        
                
        
        //creating a frame
        frameChooseStaff = new JFrame("Staff Appointment");
        
        //formatting the header
        lblHeader = new JLabel("Staff Appointment");
        lblHeader.setFont(fontHeading);
        frameChooseStaff.add(lblHeader);
        lblHeader.setBounds(260,10,500,70);

        //formatting the header
        lblHeader = new JLabel("Please choose staff:");
        lblHeader.setFont(fontSubHeading);
        frameChooseStaff.add(lblHeader);
        lblHeader.setBounds(BTN_X_DISTANCE,(BTN_Y_DISTANCE-120),500,70);

        //button for choosing full time staff  hire
        btnChooseFullTime = new JButton("Full-Time Staff");
        frameChooseStaff.add(btnChooseFullTime);
        btnChooseFullTime.setBounds(BTN_X_DISTANCE, BTN_Y_DISTANCE, BTN_CHOOSE_STAFF_WIDTH, BTN_CHOOSE_STAFF_HEIGHT);
        btnChooseFullTime.setFont(fontBtn);
        btnChooseFullTime.addActionListener(this);
        
        //btn for displaying
        btnAllDisplay = new JButton("Display");
        frameChooseStaff.add(btnAllDisplay);
        btnAllDisplay.setBounds(BTN_X_DISTANCE + 220, BTN_Y_DISTANCE +120, BTN_CHOOSE_STAFF_WIDTH-70, BTN_CHOOSE_STAFF_HEIGHT-20);
        btnAllDisplay.setFont(fontBtn);
        btnAllDisplay.addActionListener(this);

        BTN_X_DISTANCE += (BTN_CHOOSE_STAFF_WIDTH*1.5);
        //button for choosing part time staff  hire
        btnChoosePartTime = new JButton("Part-Time Staff");
        frameChooseStaff.add(btnChoosePartTime);
        btnChoosePartTime.setBounds(BTN_X_DISTANCE, BTN_Y_DISTANCE, BTN_CHOOSE_STAFF_WIDTH, BTN_CHOOSE_STAFF_HEIGHT);
        btnChoosePartTime.setFont(fontBtn);
        btnChoosePartTime.addActionListener(this);
        
        
        
        //formatting the frame
        frameChooseStaff.setLayout(null);
        frameChooseStaff.setSize((BTN_X_DISTANCE + BTN_CHOOSE_STAFF_WIDTH + 100),(BTN_Y_DISTANCE + BTN_CHOOSE_STAFF_HEIGHT*2)+100);
        frameChooseStaff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameChooseStaff.setVisible(true);
        frameChooseStaff.setLocationRelativeTo(null);
    }

    
    //-----------------------GUI for fulltime Staff----------------------------//
    public void fullTimeStaffHireGUI(){

        //-----------------------Declaring variables for formatting the GUI for full time----------------------------//

        //declaring the width and height of the text fields
        final  int TF_WIDTH = 160;
        final  int TF_HEIGHT = 27;

        //declaring the width and height of Label
        final  int LBL_WIDTH = 130;
        final  int LBL_HEIGHT = TF_HEIGHT;

        //declaring the width and height of buttons
        final  int BTN_WIDTH = 160;
        final  int BTN_HEIGHT = (TF_HEIGHT*2);
        
        //declaring the width and height of jcombo box
        int JC_WIDTH = 55;
        int JC_HEIGHT = 27;

        //initilizing the x and y axis values to be used in setting the bounds
        int x = 30;
        int y = 80;

        //initilizing the x axis value to be used in setting the bounds of text fields only
        int TEXTFIELD_X = x;

        //distance between the label and textfields
        int DIFF_LBL_AND_TF = LBL_WIDTH + 10;

        //the vertical distance between two labels
        final int Y_DIFF_LBL = LBL_HEIGHT + 30;

        //the horizontal distance between two labels
        final int X_DIFF_LBL = DIFF_LBL_AND_TF + (TF_WIDTH) + 50;

        //creating the frameFullTime for the GUI
        frameFullTime = new JFrame("Staff Appointment- Full Time Staff");
        font();

        //formatting the header
        lblHeader = new JLabel("Full Time Staff");
        frameFullTime.add(lblHeader);
        lblHeader.setBounds (230,25,320,50);
        lblHeader.setFont(fontHeading);

        //for vacancy number
        y += Y_DIFF_LBL;
        lblText = new JLabel("Vacancy Number:");
        frameFullTime.add(lblText);
        lblText.setBounds(x,y,LBL_WIDTH,LBL_HEIGHT);
        lblText.setFont(fontLblText);

        TEXTFIELD_X = x + DIFF_LBL_AND_TF;
        tfFVacNum = new JTextField();
        frameFullTime.add(tfFVacNum);
        tfFVacNum.setBounds(TEXTFIELD_X,y,TF_WIDTH,TF_HEIGHT);

        //for designation
        x += X_DIFF_LBL;
        lblText = new JLabel("Designation:");
        frameFullTime.add(lblText);
        lblText.setBounds(x,y,LBL_WIDTH,LBL_HEIGHT);
        lblText.setFont(fontLblText);

        TEXTFIELD_X = x + DIFF_LBL_AND_TF;
        tfFDesignation = new JTextField();
        frameFullTime.add(tfFDesignation);
        tfFDesignation.setBounds(TEXTFIELD_X,y,TF_WIDTH,TF_HEIGHT);

        //for Salary
        y += Y_DIFF_LBL;
        x -= X_DIFF_LBL;
        lblText = new JLabel("Salary:");
        frameFullTime.add(lblText);
        lblText.setBounds(x,y,LBL_WIDTH,LBL_HEIGHT);
        lblText.setFont(fontLblText);

        TEXTFIELD_X = x + DIFF_LBL_AND_TF;
        tfFSalary = new JTextField();
        frameFullTime.add(tfFSalary);
        tfFSalary.setBounds(TEXTFIELD_X,y,TF_WIDTH,TF_HEIGHT);

        //for Job Type
        x += X_DIFF_LBL;
        lblText = new JLabel("Job Type:");
        frameFullTime.add(lblText);
        lblText.setBounds(x,y,LBL_WIDTH,LBL_HEIGHT);
        lblText.setFont(fontLblText);

        TEXTFIELD_X = x + DIFF_LBL_AND_TF;
        jcFJobType = new JComboBox<String>(new String[] {"SELECT","Full Time","PartTime"});
        frameFullTime.add(jcFJobType);
        jcFJobType.setBounds(TEXTFIELD_X,y,TF_WIDTH,TF_HEIGHT);

        //for working hour
        y += Y_DIFF_LBL;
        x -= X_DIFF_LBL;
        lblText = new JLabel("Working Hour:");
        frameFullTime.add(lblText);
        lblText.setBounds(x,y,LBL_WIDTH,LBL_HEIGHT);
        lblText.setFont(fontLblText);

        TEXTFIELD_X = x + DIFF_LBL_AND_TF;
        tfFWorkingHour = new JTextField();
        frameFullTime.add(tfFWorkingHour);
        tfFWorkingHour.setBounds(TEXTFIELD_X,y,TF_WIDTH,TF_HEIGHT);

        //for Add Button
        x += X_DIFF_LBL;
        TEXTFIELD_X = x + DIFF_LBL_AND_TF;
        btnFullAdd = new JButton("Add");
        frameFullTime.add(btnFullAdd);
        btnFullAdd.setFont(fontBtn);
        btnFullAdd.setBounds(TEXTFIELD_X,y,BTN_WIDTH,BTN_HEIGHT);
        btnFullAdd.addActionListener(this);

        ////////////////////////////////////Section to appoint Staff/////////////////////////////////////////////////////////////////////////////
        //for vacancy number
        y += Y_DIFF_LBL;
        y += Y_DIFF_LBL;
        x -= X_DIFF_LBL;
        lblText = new JLabel("Vacancy Number:");
        frameFullTime.add(lblText);
        lblText.setBounds(x,y,LBL_WIDTH,LBL_HEIGHT);
        lblText.setFont(fontLblText);

        TEXTFIELD_X = x + DIFF_LBL_AND_TF;
        tfFullVacancyNumber = new JTextField();
        frameFullTime.add(tfFullVacancyNumber);
        tfFullVacancyNumber.setBounds(TEXTFIELD_X,y,TF_WIDTH,TF_HEIGHT);

        //for Staff Name
        x += X_DIFF_LBL;
        lblText = new JLabel("Staff Name:");
        frameFullTime.add(lblText);
        lblText.setBounds(x,y,LBL_WIDTH,LBL_HEIGHT);
        lblText.setFont(fontLblText);

        TEXTFIELD_X = x + DIFF_LBL_AND_TF;
        tfFullStaffName= new JTextField();
        frameFullTime.add(tfFullStaffName);
        tfFullStaffName.setBounds(TEXTFIELD_X,y,TF_WIDTH,TF_HEIGHT);

        //for Joining Date
        y += Y_DIFF_LBL;
        x -= X_DIFF_LBL;
        lblText = new JLabel("Joining Date:");
        frameFullTime.add(lblText);
        lblText.setBounds(x,y,LBL_WIDTH,LBL_HEIGHT);
        lblText.setFont(fontLblText);

        String [] year = new String[42];
        String [] month = new String[13];
        String [] day = new String[33];
        
        //for Year
        year[0] = "YYYY";       
        for(int i = 1980;i<=2020; i++) {
        	
        	year[i-1979] = Integer.toString(i);
        }
        TEXTFIELD_X = x + DIFF_LBL_AND_TF;
        jcFullDateYear= new JComboBox<String>(year);
        frameFullTime.add(jcFullDateYear);
        jcFullDateYear.setBounds(TEXTFIELD_X,y,JC_WIDTH+4,JC_HEIGHT);
        
        //for Month
        month[0] = "M";
        for (int i = 1; i <= 12; i++) {
        	if (i>=1 && i<=9){
        		month[i] = "0" + (Integer.toString(i));
        	}else {
        	month [i] = Integer.toString(i);
        	}
        }
        jcFullDateMonth = new JComboBox<String>(month);
        frameFullTime.add(jcFullDateMonth);
        jcFullDateMonth.setBounds(TEXTFIELD_X + 68,y,JC_WIDTH - 13,JC_HEIGHT);
        
        //for day
        day[0] = "D";
        for (int i = 1; i<=32; i++) {
        	if (i>=1 && i<=9){
        		day[i] = "0" + (Integer.toString(i));
        	}else {
        	day [i] = Integer.toString(i);
        	}
        }
        jcFullDateDay = new JComboBox<String>(day);
        frameFullTime.add(jcFullDateDay);
        jcFullDateDay.setBounds(TEXTFIELD_X + 118,y,JC_WIDTH-13,JC_HEIGHT);
        
        //for qualification
        x += X_DIFF_LBL;
        lblText = new JLabel("Qualification:");
        frameFullTime.add(lblText);
        lblText.setBounds(x,y,LBL_WIDTH,LBL_HEIGHT);
        lblText.setFont(fontLblText);

        TEXTFIELD_X = x + DIFF_LBL_AND_TF;
        tfFullQualification= new JTextField();
        frameFullTime.add(tfFullQualification);
        tfFullQualification.setBounds(TEXTFIELD_X,y,TF_WIDTH,TF_HEIGHT);

        //for Appointed By
        y += Y_DIFF_LBL;
        x -= X_DIFF_LBL;
        lblText = new JLabel("Appointed By:");
        frameFullTime.add(lblText);
        lblText.setBounds(x,y,LBL_WIDTH,LBL_HEIGHT);
        lblText.setFont(fontLblText);

        TEXTFIELD_X = x + DIFF_LBL_AND_TF;
        tfFullAppointedBy= new JTextField();
        frameFullTime.add(tfFullAppointedBy);
        tfFullAppointedBy.setBounds(TEXTFIELD_X,y,TF_WIDTH,TF_HEIGHT);

        //for Appoint Button
        x += X_DIFF_LBL;
        TEXTFIELD_X = x + DIFF_LBL_AND_TF;
        btnFullAppoint = new JButton("Appoint");
        frameFullTime.add(btnFullAppoint);
        btnFullAppoint.setFont(fontBtn);
        btnFullAppoint.setBounds(TEXTFIELD_X,y,BTN_WIDTH,BTN_HEIGHT);
        btnFullAppoint.addActionListener(this);

        //for Display Button
        y += Y_DIFF_LBL;
        y += Y_DIFF_LBL;
        x -= X_DIFF_LBL;
        btnFullDisplay = new JButton("Display");
        frameFullTime.add(btnFullDisplay);
        btnFullDisplay.setFont(fontBtn);
        btnFullDisplay.setBounds(x,y,BTN_WIDTH,BTN_HEIGHT);
        btnFullDisplay.addActionListener(this);

        //for Clear Button
        x += X_DIFF_LBL;
        TEXTFIELD_X = x + DIFF_LBL_AND_TF;
        btnFullClear = new JButton("Clear");
        frameFullTime.add(btnFullClear);
        btnFullClear.setFont(fontBtn);
        btnFullClear.setBounds(TEXTFIELD_X,y,BTN_WIDTH,BTN_HEIGHT);
        btnFullClear.addActionListener(this);

        //setting the frameFullTime layout
        frameFullTime.setLayout(null);
        frameFullTime.setSize(TEXTFIELD_X + TF_WIDTH + 30, y + BTN_HEIGHT + 80);
        frameFullTime.setVisible(true);
        frameFullTime.setLocationRelativeTo(null);

    }

       
    //-----------------------GUI for partime Staff----------------------------//
    public void partTimeStaffHireGUI(){
    	font();

        //-----------------------Declaring variables for formatting the GUI for partime----------------------------//

        //declaring the width and height of the text fields
        final  int TF_WIDTH = 160;
        final  int TF_HEIGHT = 27;

        //declaring the width and height of Label
        final  int LBL_WIDTH = 130;
        final  int LBL_HEIGHT = TF_HEIGHT;

        //declaring the width and height of buttons
        final  int BTN_WIDTH = 160;
        final  int BTN_HEIGHT = (TF_HEIGHT*2);
        
      //declaring the width and height of jcombo box
        int JC_WIDTH = 55;
        int JC_HEIGHT = 27;

        //initilizing the x and y axis values to be used in setting the bounds
        int x = 30;
        int y = 40;

        //initilizing the x axis value to be used in setting the bounds of text fields only
        int TEXTFIELD_X = x;

        //distance between the label and textfields
        int DIFF_LBL_AND_TF = LBL_WIDTH + 10;

        //the vertical distance between two labels
        final int Y_DIFF_LBL = LBL_HEIGHT + 30;

        //the horizontal distance between two labels
        final int X_DIFF_LBL = DIFF_LBL_AND_TF + (TF_WIDTH) + 50;
        //creating the framePartTime for the GUI
        framePartTime = new JFrame("Staff Appointment- Part Time Staff");
        

        //formatting the header
        lblHeader = new JLabel("Part Time Staff");
        framePartTime.add(lblHeader);
        lblHeader.setBounds (230,10,320,50);
        lblHeader.setFont(fontHeading);

        //for vacancy number
        y += Y_DIFF_LBL;
        lblText = new JLabel("Vacancy Number:");
        framePartTime.add(lblText);
        lblText.setBounds(x,y,LBL_WIDTH,LBL_HEIGHT);
        lblText.setFont(fontLblText);

        TEXTFIELD_X = x + DIFF_LBL_AND_TF;
        tfPVacNum = new JTextField();
        framePartTime.add(tfPVacNum);
        tfPVacNum.setBounds(TEXTFIELD_X,y,TF_WIDTH,TF_HEIGHT);

        //for designation
        x += X_DIFF_LBL;
        lblText = new JLabel("Designation:");
        framePartTime.add(lblText);
        lblText.setBounds(x,y,LBL_WIDTH,LBL_HEIGHT);
        lblText.setFont(fontLblText);

        TEXTFIELD_X = x + DIFF_LBL_AND_TF;
        tfPDesignation = new JTextField();
        framePartTime.add(tfPDesignation);
        tfPDesignation.setBounds(TEXTFIELD_X,y,TF_WIDTH,TF_HEIGHT);

        //for wages per hour
        y += Y_DIFF_LBL;
        x -= X_DIFF_LBL;
        lblText = new JLabel("Wages per Hour:");
        framePartTime.add(lblText);
        lblText.setBounds(x,y,LBL_WIDTH,LBL_HEIGHT);
        lblText.setFont(fontLblText);

        TEXTFIELD_X = x + DIFF_LBL_AND_TF;
        tfPWagesPerHour = new JTextField();
        framePartTime.add(tfPWagesPerHour);
        tfPWagesPerHour.setBounds(TEXTFIELD_X,y,TF_WIDTH,TF_HEIGHT);

        //for Job Type
        x += X_DIFF_LBL;
        lblText = new JLabel("Job Type:");
        framePartTime.add(lblText);
        lblText.setBounds(x,y,LBL_WIDTH,LBL_HEIGHT);
        lblText.setFont(fontLblText);

        TEXTFIELD_X = x + DIFF_LBL_AND_TF;
        jcPJobType = new JComboBox<String>(new String[] {"SELECT","Part Time", "Full Time"});
        framePartTime.add(jcPJobType);
        jcPJobType.setBounds(TEXTFIELD_X,y,TF_WIDTH,TF_HEIGHT);

        //for working hour per day
        y += Y_DIFF_LBL;
        x -= X_DIFF_LBL;
        lblText = new JLabel("Working Hour");
        framePartTime.add(lblText);
        lblText.setBounds(x,y,LBL_WIDTH,LBL_HEIGHT);
        lblText.setFont(fontLblText);

        TEXTFIELD_X = x + DIFF_LBL_AND_TF;
        tfPWorkingHour = new JTextField();
        framePartTime.add(tfPWorkingHour);
        tfPWorkingHour.setBounds(TEXTFIELD_X,y,TF_WIDTH,TF_HEIGHT);
        
        //for shift
        x += X_DIFF_LBL;        
        lblText = new JLabel("Shift:");
        framePartTime.add(lblText);
        lblText.setBounds(x,y,LBL_WIDTH,LBL_HEIGHT);
        lblText.setFont(fontLblText);
        
        TEXTFIELD_X = x + DIFF_LBL_AND_TF;     
        jcPShift = new JComboBox<String>(new String[] {"SELECT","Morning", "Day", "Evening", "Night"});
        framePartTime.add(jcPShift);
        jcPShift.setBounds(TEXTFIELD_X,y,TF_WIDTH,TF_HEIGHT);
        
        //for Add Button        
        y += Y_DIFF_LBL;
        TEXTFIELD_X = x + DIFF_LBL_AND_TF;
        btnPartAdd = new JButton("Add");
        framePartTime.add(btnPartAdd);
        btnPartAdd.setFont(fontBtn);
        btnPartAdd.setBounds(TEXTFIELD_X,y,BTN_WIDTH,BTN_HEIGHT);
        btnPartAdd.addActionListener(this);

        ////////////////////////////////////Section to appoint Staff/////////////////////////////////////////////////////////////////////////////
        //for vacancy number
        y += Y_DIFF_LBL;
        y += Y_DIFF_LBL;
        x -= X_DIFF_LBL;
        lblText = new JLabel("Vacancy Number:");
        framePartTime.add(lblText);
        lblText.setBounds(x,y,LBL_WIDTH,LBL_HEIGHT);
        lblText.setFont(fontLblText);

        TEXTFIELD_X = x + DIFF_LBL_AND_TF;
        tfPartVacancyNumber = new JTextField();
        framePartTime.add(tfPartVacancyNumber);
        tfPartVacancyNumber.setBounds(TEXTFIELD_X,y,TF_WIDTH,TF_HEIGHT);

        //for Staff Name
        x += X_DIFF_LBL;
        lblText = new JLabel("Staff Name:");
        framePartTime.add(lblText);
        lblText.setBounds(x,y,LBL_WIDTH,LBL_HEIGHT);
        lblText.setFont(fontLblText);

        TEXTFIELD_X = x + DIFF_LBL_AND_TF;
        tfPartStaffName= new JTextField();
        framePartTime.add(tfPartStaffName);
        tfPartStaffName.setBounds(TEXTFIELD_X,y,TF_WIDTH,TF_HEIGHT);

        //for Joining Date
        y += Y_DIFF_LBL;
        x -= X_DIFF_LBL;
        lblText = new JLabel("Joining Date:");
        framePartTime.add(lblText);
        lblText.setBounds(x,y,LBL_WIDTH,LBL_HEIGHT);
        lblText.setFont(fontLblText);

        String [] year = new String[42];
        String [] month = new String[13];
        String [] day = new String[33];
        
        //for Year
        year[0] = "YYYY";
        for(int i = 1980;i<=2020; i++) {      	
        	year[i-1979] = Integer.toString(i);
        }       
        TEXTFIELD_X = x + DIFF_LBL_AND_TF;
        jcPartDateYear= new JComboBox<String>(year);
        framePartTime.add(jcPartDateYear);
        jcPartDateYear.setBounds(TEXTFIELD_X,y,JC_WIDTH+4,JC_HEIGHT);
        
        //for Month
        month[0] = "M";
        for (int i = 1; i <= 12; i++) {
        	if (i>=1 && i<=9){
        		month[i] = "0" + (Integer.toString(i));
        	}else {
        	month [i] = Integer.toString(i);
        	}        	
        }
        jcPartDateMonth = new JComboBox<String>(month);
        framePartTime.add(jcPartDateMonth);
        jcPartDateMonth.setBounds(TEXTFIELD_X + 68,y,JC_WIDTH - 13,JC_HEIGHT);
        
        //for day
        day[0] = "D";
        for (int i = 1; i<=32; i++) {
        	if (i>=1 && i<=9){
        		day[i] = "0" + (Integer.toString(i));
        	}else {
        	day [i] = Integer.toString(i);
        	} 
        }
        jcPartDateDay = new JComboBox<String>(day);
        framePartTime.add(jcPartDateDay);
        jcPartDateDay.setBounds(TEXTFIELD_X + 118,y,JC_WIDTH-13,JC_HEIGHT);
        
        //for qualification
        x += X_DIFF_LBL;
        lblText = new JLabel("Qualification:");
        framePartTime.add(lblText);
        lblText.setBounds(x,y,LBL_WIDTH,LBL_HEIGHT);
        lblText.setFont(fontLblText);

        TEXTFIELD_X = x + DIFF_LBL_AND_TF;
        tfPartQualification= new JTextField();
        framePartTime.add(tfPartQualification);
        tfPartQualification.setBounds(TEXTFIELD_X,y,TF_WIDTH,TF_HEIGHT);

        //for Appointed By
        y += Y_DIFF_LBL;
        x -= X_DIFF_LBL;
        lblText = new JLabel("Appointed By:");
        framePartTime.add(lblText);
        lblText.setBounds(x,y,LBL_WIDTH,LBL_HEIGHT);
        lblText.setFont(fontLblText);

        TEXTFIELD_X = x + DIFF_LBL_AND_TF;
        tfPartAppointedBy= new JTextField();
        framePartTime.add(tfPartAppointedBy);
        tfPartAppointedBy.setBounds(TEXTFIELD_X,y,TF_WIDTH,TF_HEIGHT);
        
        
        

        //for Appoint Button
        x += X_DIFF_LBL;
        TEXTFIELD_X = x + DIFF_LBL_AND_TF;
        btnPartAppoint = new JButton("Appoint");
        framePartTime.add(btnPartAppoint);
        btnPartAppoint.setFont(fontLblText);
        btnPartAppoint.setBounds(TEXTFIELD_X,y,BTN_WIDTH,BTN_HEIGHT);
        btnPartAppoint.setFont(fontBtn);
        btnPartAppoint.addActionListener(this);
        
        
        
        
        //for terminate button
        y += Y_DIFF_LBL;
        x -= X_DIFF_LBL;
        btnPartTerminate = new JButton("Terminate");
        framePartTime.add(btnPartTerminate);
        btnPartTerminate.setBounds(x,y,BTN_WIDTH,BTN_HEIGHT);
        btnPartTerminate.addActionListener(this);
        btnPartTerminate.setFont(fontBtn);
        
        
        

        //for Display Button
        y += Y_DIFF_LBL;
        y += Y_DIFF_LBL;
        btnPartDisplay = new JButton("Display");
        framePartTime.add(btnPartDisplay);
        btnPartDisplay.setFont(fontBtn);
        btnPartDisplay.setBounds(x,y,BTN_WIDTH,BTN_HEIGHT);
        btnPartDisplay.addActionListener(this);

        //for Clear Button
        x += X_DIFF_LBL;
        TEXTFIELD_X = x + DIFF_LBL_AND_TF;
        btnPartClear = new JButton("Clear");
        framePartTime.add(btnPartClear);
        btnPartClear.setFont(fontBtn);
        btnPartClear.setBounds(TEXTFIELD_X,y,BTN_WIDTH,BTN_HEIGHT);
        btnPartClear.addActionListener(this);

        //setting the framePartTime layout
        framePartTime.setLayout(null);
        framePartTime.setSize(TEXTFIELD_X + TF_WIDTH + 30, y + BTN_HEIGHT + 80);
        framePartTime.setVisible(true);
        framePartTime.setLocationRelativeTo(null);

    }
    
    //method to add full time staff
    public void fullTimeStaffAdd() {
    	int fullVacNum, fullSalary, fullWorkingHour;
    	
    	String fullDesignation, fullJobType;
    	//using try catch to handle exception
    	try{
    		//getting the value from text fields
    		fullVacNum = Integer.parseInt(tfFVacNum.getText());
    		fullDesignation = tfFDesignation.getText();
    		fullJobType = jcFJobType.getSelectedItem().toString();
    		fullSalary = Integer.parseInt(tfFSalary.getText());
    		fullWorkingHour = Integer.parseInt(tfFWorkingHour.getText());
    		   		
    		//checking all the text fields are filled up
    		if(fullDesignation.isEmpty()){
    			JOptionPane.showMessageDialog(frameFullTime, "Please enter Designation.", "Error", JOptionPane.ERROR_MESSAGE);
    		}else if(fullJobType == "SELECT") {
    			JOptionPane.showMessageDialog(frameFullTime, "Please select Job Type.", "Error", JOptionPane.ERROR_MESSAGE);
    		}
	    	else{
	    		boolean isDuplicateVacNum = false;
	    		//looping through all the objects in the arrayList
	    		for(StaffHire obj:list){
	                if(obj.getVacancyNumber() == fullVacNum){
	                    isDuplicateVacNum = true;
	                    break;
	                }
	    		}
	                
	            if(isDuplicateVacNum == false){
	            	FullTimeStaffHire fullTimeAdd = new FullTimeStaffHire(fullVacNum, fullDesignation, fullJobType, fullSalary, fullWorkingHour);
	            	list.add(fullTimeAdd);
	                JOptionPane.showMessageDialog(frameFullTime,"Vacancy Number " +fullVacNum+" sucessfully added.","Message",JOptionPane.INFORMATION_MESSAGE);
	            }
	            else{
	                JOptionPane.showMessageDialog(frameFullTime,"Vacancy Number "+ fullVacNum+" has already been added.","Error", JOptionPane.ERROR_MESSAGE); 
	            }
	    	}
    	}
    	//catching number format exception
    	catch(NumberFormatException e){
    		if (!tfFVacNum.getText().matches("\\d+")){
    			JOptionPane.showMessageDialog(frameFullTime, "Please enter only numbers for the Vacancy Number.","Error", JOptionPane.ERROR_MESSAGE);   			
    		}else if(!tfFSalary.getText().matches("\\d+")){
    			JOptionPane.showMessageDialog(frameFullTime, "Please enter only numbers for the Salary.","Error", JOptionPane.ERROR_MESSAGE);
    		}else if(!tfFWorkingHour.getText().matches("\\d+")) {
    			JOptionPane.showMessageDialog(frameFullTime, "Please enter only numbers for the Working Hour.","Error", JOptionPane.ERROR_MESSAGE);  
    		}
    	}
    }
    
    //method to add part time staf
    public void partTimeStaffAdd() {
    	int partVacNum, partWagesPerHour, partWorkingHour;
    	
    	String partDesignation, partJobType, partShift;
    	//using try catch to handle exception
    	try{
    		//getting the value from text fields
    		partVacNum = Integer.parseInt(tfPVacNum.getText());
            partDesignation = tfPDesignation.getText();
            partJobType = jcPJobType.getSelectedItem().toString();
            partWagesPerHour = Integer.parseInt(tfPWagesPerHour.getText());
            partWorkingHour = Integer.parseInt(tfPWorkingHour.getText());
    		partShift = jcPShift.getSelectedItem().toString();
    		
    		//checking all the text fields are filled up
    		if(partDesignation.isEmpty()){
    			JOptionPane.showMessageDialog(framePartTime, "Please enter Designation.", "Message", JOptionPane.INFORMATION_MESSAGE);
    		}else if(partJobType == "SELECT") {
    			 JOptionPane.showMessageDialog(framePartTime,"Please select Job Type.","Message",JOptionPane.INFORMATION_MESSAGE);
    		}else if(partShift == "SELECT"){
    			 JOptionPane.showMessageDialog(framePartTime,"Please select Shift.","Message",JOptionPane.INFORMATION_MESSAGE);
    		}
	    	else{
	    		boolean isDuplicateVno = false;
	    		//looping through all the objects in the arrayList
	    		for(StaffHire obj:list){
	                if(obj.getVacancyNumber() == partVacNum){
	                    isDuplicateVno = true;
	                    break;
	                }
	    		}                
	            if(isDuplicateVno == false){
	            	PartTimeStaffHire partTimeAdd = new PartTimeStaffHire(partVacNum, partDesignation, partJobType, partWagesPerHour, partWorkingHour, partShift);
	            	list.add(partTimeAdd);
	                JOptionPane.showMessageDialog(framePartTime,"Vacancy Number " +partVacNum+" sucessfully added.","Message",JOptionPane.INFORMATION_MESSAGE);	                
	            }
	            else{
	                JOptionPane.showMessageDialog(framePartTime,"Vacancy Number "+ partVacNum+" has already been added.","Error", JOptionPane.ERROR_MESSAGE); 
	            }	       
	    	}
    	}
    	catch(NumberFormatException e){
    		if (!tfPVacNum.getText().matches("\\d+")){
    			JOptionPane.showMessageDialog(framePartTime, "Please enter only numbers for the Vacancy Number.","Error", JOptionPane.ERROR_MESSAGE);   			
    		}else if(!tfPWagesPerHour.getText().matches("\\d+")){
    			JOptionPane.showMessageDialog(framePartTime, "Please enter only numbers for the Wage.","Error", JOptionPane.ERROR_MESSAGE);
    		}else if(!tfPWorkingHour.getText().matches("\\d+")) {
    		JOptionPane.showMessageDialog(framePartTime, "Please enter only numbers for the Working Hour.","Error", JOptionPane.ERROR_MESSAGE);  
    		}
    	}
    }
    
    //method to appoint a full time staff
    public void fullTimeStaffAppoint() {
    	String dateYear, dateMonth, dateDay;
    	int fullVacancyNumber;
    	String fullStaffName, fullQualification,  fullAppointedBy, fullJoiningDate;
    	//using try catch to handle exception
    	try {
	    	//getting the text from each of the text field of the Full time staff
	    	fullVacancyNumber = Integer.parseInt(tfFullVacancyNumber.getText());
	        fullStaffName = tfFullStaffName.getText();
	        dateYear = jcFullDateYear.getSelectedItem().toString();
	        dateMonth = jcFullDateMonth.getSelectedItem().toString();
	        dateDay = jcFullDateDay.getSelectedItem().toString();
	        fullJoiningDate = dateYear +"/"+ dateMonth +"/"+ dateDay;
	        fullQualification = tfFullQualification.getText();
	        fullAppointedBy = tfFullAppointedBy.getText();
	        
	      //checking all the text fields are filled up
	        if(fullStaffName.isEmpty() ||  fullQualification.isEmpty() ||   fullAppointedBy.isEmpty()){
	        	JOptionPane.showMessageDialog(frameFullTime,"Please fill up every fields.","Message",JOptionPane.INFORMATION_MESSAGE);
	        }else if(dateYear == "YYYY" || dateMonth == "M" || dateDay == "D"){
	        	JOptionPane.showMessageDialog(frameFullTime,"Please select Joining Date.","Message",JOptionPane.INFORMATION_MESSAGE);
	        }
	        else {
	        	boolean vacNotFound = true;
	        	//looping through all the objects in the arrayList
		        for(StaffHire obj:list){
		        	if(fullVacancyNumber == obj.getVacancyNumber()){
		        		vacNotFound = false;
		        		if(obj instanceof FullTimeStaffHire){
		        			//object casting
		        			FullTimeStaffHire fObj = (FullTimeStaffHire)obj;
		        			if(fObj.getJoined() == true) {
		        				JOptionPane.showMessageDialog(frameFullTime,"Staff has already been hired \nStaff Name: " + fObj.getStaffName()+".","Message",JOptionPane.INFORMATION_MESSAGE);
		        				break;
		        			}
		        			else {
		        				fObj.hireFullTime(fullStaffName, fullJoiningDate, fullQualification, fullAppointedBy);
		        				JOptionPane.showMessageDialog(frameFullTime,fObj.getStaffName()+" has sucessfully been hired by "+fObj.getAppointedBy()+".","Message",JOptionPane.INFORMATION_MESSAGE);
		        				fullTimeStaffClear();
		        				break;
		        			}
		        		}
		        		else {
		        			JOptionPane.showMessageDialog(frameFullTime,"You have entered Vacancy number for Part time staff.","Message",JOptionPane.INFORMATION_MESSAGE);
		        			
		        			break;
		        		}
		        	}		        	
		        }
		        if (vacNotFound == true){
		        	JOptionPane.showMessageDialog(frameFullTime," Vacancy Number not found!!!","Error",JOptionPane.ERROR_MESSAGE);
		        }
	        }
	    }
    	catch(NumberFormatException e){
    		JOptionPane.showMessageDialog(frameFullTime, "Please enter only numbers for the Vacancy Number.","Error", JOptionPane.ERROR_MESSAGE);  
    	}
        
    }
       
    //method to appoint part time staff  
    public void partTimeStaffAppoint(){
    	String dateYear, dateMonth, dateDay;
    	int partVacancyNumber;
    	String partStaffName, partQualification,  partAppointedBy, partJoiningDate;
    	//using try catch to handle exception
    	try {
	    	//getting the text from each of the text field of the Full time staff
    		partVacancyNumber = Integer.parseInt(tfPartVacancyNumber.getText());
    		partStaffName = tfPartStaffName.getText();
    		dateYear = jcPartDateYear.getSelectedItem().toString();
	        dateMonth = jcPartDateMonth.getSelectedItem().toString();
	        dateDay = jcPartDateDay.getSelectedItem().toString();
	        partJoiningDate = dateYear +"/"+ dateMonth +"/"+ dateDay;
	        partQualification = tfPartQualification.getText();
	        partAppointedBy = tfPartAppointedBy.getText();
	        
	      //checking all the text fields are filled up
	        if(partStaffName.isEmpty() ||  partQualification.isEmpty() ||   partAppointedBy.isEmpty()) {
	        	JOptionPane.showMessageDialog(framePartTime,"Please fill up every fields","Message",JOptionPane.INFORMATION_MESSAGE);
	        }else if(dateYear == "YYYY" || dateMonth == "M" || dateDay == "D") {
	        	JOptionPane.showMessageDialog(framePartTime,"Please select Joining Date","Message",JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	boolean vacNotFound = true;
	        	//looping through all the objects in the arrayList
		        for(StaffHire obj:list){
		        	if(partVacancyNumber == obj.getVacancyNumber()){
		        		vacNotFound = false;
		        		if(obj instanceof PartTimeStaffHire){
		        			//object casting
		        			PartTimeStaffHire pObj = (PartTimeStaffHire)obj;
		        			if(pObj.getJoined() == true){
		        				JOptionPane.showMessageDialog(framePartTime,"Staff has already been hired \nStaff Name: " + pObj.getStaffName()+".","Message",JOptionPane.INFORMATION_MESSAGE);		        				
		        				break;
		        			}
		        			else {
		        				pObj.hirePartTime(partStaffName, partJoiningDate, partQualification, partAppointedBy);
		        				JOptionPane.showMessageDialog(framePartTime,pObj.getStaffName()+" has sucessfully been hired by " + pObj.getAppointedBy()+".","Sucess",JOptionPane.INFORMATION_MESSAGE);		        				
		        				partTimeStaffClear();
		        				break;
		        			}
		        		}
		        		else{
		        			JOptionPane.showMessageDialog(framePartTime,"You have entered Vacancy number for full time staff.","Message",JOptionPane.INFORMATION_MESSAGE);		        			
		        			break;
		        		}
		        	}		        	
		        }
		        if (vacNotFound == true) {
		        	JOptionPane.showMessageDialog(framePartTime,"Vacancy Number not found!!!","Error",JOptionPane.ERROR_MESSAGE);
		        }
	        }
	    }
    	catch(NumberFormatException e){
    		JOptionPane.showMessageDialog(framePartTime, "Please enter only numbers for the Vacancy Number.","Error", JOptionPane.ERROR_MESSAGE);  
    	}
        
    }
    
    //method to terminate part time staff
    public void partTimeStaffTerminate() {
    	//using try catch to handle exception
    	try {
	    	int terVacNum;
	    	terVacNum = Integer.parseInt(tfPartVacancyNumber.getText());
	    	boolean vacNotFound = true;	
	    	//looping through all the objects in the arrayList
	    	for(StaffHire obj:list){
	    		if(terVacNum == obj.getVacancyNumber()) {
	    			vacNotFound = false;
	    			if(obj instanceof PartTimeStaffHire) {
	    				//object casting
		    			PartTimeStaffHire terObj = (PartTimeStaffHire)obj;		    			
			    		if(terObj.getTerminated() == false){
			    			int x = JOptionPane.showConfirmDialog(framePartTime, "Are you sure you want to terminate staff "+terObj.getStaffName()+"?", "Confirm", JOptionPane.YES_NO_OPTION);
				    		if (x == 1) {
				    			break;
				    		}
				    		else {
				    			String terStaffName = terObj.getStaffName();
				    			//calling terminate method from PartTimeStaffHire class to terminate the staff
				    			terObj.terminate();
			    				JOptionPane.showMessageDialog(framePartTime,terStaffName+" has sucessfully been terminated.","Sucess!!",JOptionPane.INFORMATION_MESSAGE);
			    				partTimeStaffClear();
			    			}
			    		}
			    		else {
			    			JOptionPane.showMessageDialog(framePartTime,"The staff has already been terminated.","Message",JOptionPane.INFORMATION_MESSAGE);
			    			break;
			    		}
		    		}
	    			else{
	    				JOptionPane.showMessageDialog(framePartTime,"You have entered the Vacancy number for full time staff.","Message",JOptionPane.INFORMATION_MESSAGE);
	    				break;	    		
	    			}
	    		}
	    	}
	    	
	    	if (vacNotFound == true) {
	    		JOptionPane.showMessageDialog(framePartTime,"Vacancy number not found!!!","Error",JOptionPane.ERROR_MESSAGE);
	    	}
    	}
    	catch(NumberFormatException e) {
    		JOptionPane.showMessageDialog(framePartTime,"Please enter only numbers for the Vacancy Number.","Error",JOptionPane.ERROR_MESSAGE);
    	}
    }
    
    //method to display part time staff
    public void fullTimeStaffDisplay(){
    	for(StaffHire obj:list) {
    		if (obj instanceof FullTimeStaffHire) {
    			FullTimeStaffHire fObj= (FullTimeStaffHire)obj;
    			fObj.display();
    		}
    	}
    }
    	
    //method to display part time staff
    public void partTimeStaffDisplay(){
    	for(StaffHire obj:list) {
    		if (obj instanceof PartTimeStaffHire) {
    			PartTimeStaffHire pObj = (PartTimeStaffHire)obj;
    			pObj.display();
    		}
    	}
    }
    
    //method to display all details
    public void chooseStaffDisplay() {
    	for(StaffHire obj:list) {
    		if (obj instanceof PartTimeStaffHire) {
    			PartTimeStaffHire pObj = (PartTimeStaffHire)obj;
    			pObj.display();
    		}else if (obj instanceof FullTimeStaffHire) {
    			FullTimeStaffHire fObj= (FullTimeStaffHire)obj;
    			fObj.display();
    		}
    	}
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btnChooseFullTime) {
            fullTimeStaffHireGUI();
        }
        else if (e.getSource() == btnChoosePartTime){
            partTimeStaffHireGUI();
        }
        else if (e.getSource() == btnFullClear){
            //calling method to clear the values from the textfields
            fullTimeStaffClear();
        }else if (e.getSource() == btnPartClear){
            //calling method to clear the values from the textfields
            partTimeStaffClear();
        }else if (e.getSource() == btnFullAdd){
        	//calling method to add a full time staff
            fullTimeStaffAdd();
        }else if (e.getSource() == btnPartAdd){
        	//calling method to add part time staff
            partTimeStaffAdd();
        }else if (e.getSource() == btnFullAppoint){
        	//calling method that appoints a full time staff
            fullTimeStaffAppoint();
        }else if (e.getSource() == btnPartAppoint){
        	//calling method that appoints a part time staff
            partTimeStaffAppoint();
        }else if (e.getSource() == btnPartTerminate){
        	//calling method that terminates a staff
            partTimeStaffTerminate();
        }else if (e.getSource() == btnFullDisplay){
            fullTimeStaffDisplay();
        }else if (e.getSource() == btnPartDisplay){
            partTimeStaffDisplay();
        }else if (e.getSource() == btnAllDisplay) {
        	chooseStaffDisplay();
        }
    }
           
    //creating a method that clears the values from all of the textfields of parttime staffhire gui
     public void partTimeStaffClear(){
        //getting text from every textfields and setting null values
        tfPVacNum.setText(null);
        tfPDesignation.setText(null);
        jcPJobType.setSelectedIndex(0);
        tfPWagesPerHour.setText(null);
        tfPWorkingHour.setText(null);
        jcPShift.setSelectedIndex(0);
        tfPartVacancyNumber.setText(null);
        tfPartStaffName.setText(null);
        jcPartDateYear.setSelectedIndex(0);
        jcPartDateMonth.setSelectedIndex(0);
        jcPartDateDay.setSelectedIndex(0);
        tfPartQualification.setText(null);
        tfPartAppointedBy.setText(null);
    }
    
    //creating a method that clears the values from all of the textfields of fulltime staffhire gui
     public void fullTimeStaffClear(){
        //getting text from every textfields and setting null values
        tfFVacNum.setText(null);
        tfFDesignation.setText(null);
        jcFJobType.setSelectedIndex(0);
        tfFSalary.setText(null);
        tfFWorkingHour.setText(null);
        tfFullVacancyNumber.setText(null);
        tfFullStaffName.setText(null);
        jcFullDateYear.setSelectedIndex(0);
        jcFullDateMonth.setSelectedIndex(0);
        jcFullDateDay.setSelectedIndex(0);
        tfFullQualification.setText(null);
        tfFullAppointedBy.setText(null);
    }
}
