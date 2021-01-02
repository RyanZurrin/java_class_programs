/**
*@filename ZurrinRyanEH.java
*@author Ryan Zurrin
*@assignment Chapter  Program "Rational Numbers"
*@due_date Thursday, November 5, 2020, 3:00 PM
*@description  this is a class for performing arithmetic with fraction numbers.
*/
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZurrinRyanEH {   
    Employee employee;
    CommissionEmployee commEmployee;
      
    ZurrinRyanEH(){
        employee = new Employee();
        commEmployee = new CommissionEmployee();       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {       
        char repeat = 'y';
        int pick = 0;
        //String picked ="y";
        ZurrinRyanEH employeeFactory = new ZurrinRyanEH();
       do{
           pick = getChoice();
           if(pick == 1){
              Employee.employeeList.
                      add(employeeFactory.employee.getUserInputForEmployee());
           }else if(pick == 2){
               CommissionEmployee.commissionEmployeeList.
                       add(employeeFactory.
                               commEmployee.getUserInputForEmployee());
           }
          System.out.print("to add another employee press Y or y now\n"+
                  "anything else will print data to screen and exit: ");
          repeat = employeeFactory.employee.input.next().charAt(0);
           
       }while(repeat == 'y' || repeat == 'Y');
       Employee.printEmployeeList(Employee.employeeList);
       CommissionEmployee.printCommissionList(
               CommissionEmployee.commissionEmployeeList);
    }
    
        /**
     * Method for checking that a user is entering a number and not a letter
     * @@param input is the user input
     */
    public static int getChoice(){   
        int temp = 1;
        boolean eFlag = false;
        do{
            try{
                System.out.print("What kind of employee do you wish to add?\n"+
                   "1 for regular employee, 2 for commission employee: ");
                temp = Employee.input.nextInt();
                while(temp < 1 || temp > 2)
                {
                    System.out.print("Enter integer 1 or 2 ");
                    temp = Employee.input.nextInt();
                }                    
                }catch(InputMismatchException e)
                {
                    System.out.println("Invalid Input..Pls 1 or 2.");
                    while(!Employee.input.hasNextInt())
                    {
			String in = Employee.input.next();
			System.out.print("That was not a number, try again\n>>");
                        eFlag = true;
                        continue;
                    }
                    temp = Employee.input.nextInt();
                    eFlag=false;                
                }
            }while(eFlag);
        return temp;
  
    }
}//end class ZurrinRyanEH
class Employee {
    /**
     *  Scanner for taking user input
     */
    public static Scanner input = new Scanner(System.in);
    
    /**
     * instance variable for the first name of a employee
     */
    private String firstName;
    
    /**
     * instance variable for the last name of an employee
     */
    private String lastName;
    
    /**
     * instance variable for the social security number of an employee 
     * format as follows: "AAA-GG-SSSS", if not entered in this format you will 
     * be prompted to reenter
     */
    private String socialSecurityNumber;
    
    /**
     * an array list for storing employees
     */
    public static ArrayList<Employee> employeeList = new ArrayList<Employee>();
    
    /**
     * no argument constructor to set default values when non are given. ensures
     * object creation.
     */
    Employee(){
        firstName = "John";
        lastName = "doe";
        socialSecurityNumber = "001-01-0001";
        //employeeList = new ArrayList<Employee>();
    }
    
    /**
     * 3 argument constructor for setting employee information when creating the 
     * object. 
     * @param fn is the first name of the employee
     * @param ln is the last name of the employee
     * @param ssn is the social security number of the employee
     */
    Employee(String fn, String ln, String ssn){
        //employeeList = new ArrayList<Employee>();
        firstName = fn;
        lastName = ln;
        while(validateSocialSecurityNumber(ssn)== false){            
            ssn = fixSSN(ssn);
        }        
        socialSecurityNumber = ssn;
    }
    
    /**
     * method for changing the first name
     * @param fn is a string or string literal of the first name
     */
    public void setFirstName(final String fn){
        this.firstName = fn;
    }
    
    /**
     * method for changing the last name
     * @param ln is a string or string literal of the last name
     */
    public void setLastName(final String ln){
        this.lastName = ln;
    } 
    
     /**
     * method for setting the social security number of an employee
     * @param ssn is a 9 digit integer value
     * must be entered as a string or string literal in the following format:
     * "AAA-GG-SSS" example "555-55-5555"
     */
    public void setSocialSecurityNumber(String ssn){    
        while(validateSocialSecurityNumber(ssn) == false) {
          ssn = this.fixSSN(ssn);
        }
        this.socialSecurityNumber = ssn;

    }// end method setSocialSecurityNumber()
    
   
    
    public String getFirstName(){return firstName;}
    public String getLastName() {return lastName;}
    public String getSocialSecurityNumber(){return socialSecurityNumber;}
    
    public void printEmployeeInfo(){
        System.out.printf(toString());
    }// end method printEmployeeInfo
    
    /**
     * Method to print out the employees stored in a list
     * @param list is the Array list you want to print
     */
    public static void printEmployeeList(ArrayList<Employee> list){
    for(Employee elem : list){
        System.out.println(elem+"\n");
    }//end method printList
}
    @Override
    public String toString(){
         return String.format("%n%s: %s %s%n%s: %s%n",     
         "employee", getFirstName(), getLastName(),                    
         "social security number", getSocialSecurityNumber());
    }
    
    /**
     * method for validating the social security number of an employee
     * @param ssn is a 9 digit integer value
     * @throws IllegalArgumentException
     * @returns true or false
     */
    private boolean validateSocialSecurityNumber(final String ssn){       
        String regex =
                "^(?!666|000|9\\d{2})\\d{3}-(?!00)\\d{2}-(?!0{4})\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        if (ssn == null) {
            return false;
        }
        Matcher m = pattern.matcher(ssn);

        return m.matches();
    }
    
    /**
     * Fixer method that is called to allow a user the chance to fix any bad 
     * data that was not being validated.
     * @param ssn is the 9 digit social security that is entered as a string
     * Return the new string with fixed social security number
     */
    private String fixSSN(String ssn){
        System.out.print("You entered a bad SSN, Please re-enter: ");
        ssn = input.next();
        return ssn;
    }
    

    
    
    /**
     * A static method for setting employee objects at program run time
     * @return a reference to an employee object. it needs to be saved to
     * a object or it will be lost.
     */
    public Employee getUserInputForEmployee(){
        Employee result = new Employee();
        
        System.out.println("\nplease Enter the First and Last name of the new "+
                "employee you wish to add: ");
        result.setFirstName(input.next());
        result.setLastName(input.next());
        System.out.println();
        System.out.println("please Enter the social security number in the"+
                " following format: AAA-GG-SSS");
        result.setSocialSecurityNumber(input.next());
        
        return result;       
    }
    
}// end class employee

class CommissionEmployee extends Employee{
    private double grossSales; // gross weekly sales       
    private double commissionRate; // commission percentage
    public static ArrayList<CommissionEmployee> commissionEmployeeList = 
            new ArrayList<CommissionEmployee>();
    
    /**
     * no argument constructor to set object defaults and guarantees the object
     * will still get created even with no arguments passed in
     */
    CommissionEmployee(){
        super();
        this.grossSales = 0.0;
        this.commissionRate = 0.0;        
    }// end no argument constructor
    
    /**
     * Overloaded constructor that calls the superclass constructor to set the 
     * name and social security numbers of the employee
     * @param f is the first name as a string or literal
     * @param l is the last name as a string or literal
     * @param ssn is a string representation of a social security number
     * @param commisionRate is the commission rate of the employee as decimal
     * @param grossSales this is the total sales an employee has produced
     * 
     */
    CommissionEmployee(final String f, final String l, final String ssn,
            double  _commissionRate,  double _grossSales){
        super(f, l, ssn);
             
        // if the gross sales is negitive catch and let user re-enter
        while(validateGrossSales(_grossSales)==false){
            _grossSales = fixGrossSale(_grossSales);    
        }
        // if commision rate is out of bounds catch and let user re-enter
        while(validateCommissionRate(_commissionRate)==false) {
            _commissionRate = fixCommissionRate(_commissionRate);
        }  
        this.commissionRate = _commissionRate;
        this.grossSales = _grossSales;

    }// end overloaded constructor
    
    /**
     * sets the grossSales instance variable of the employee
     * @param _grossSales is the amount the employee has made before taxes
     */
    public void setGrossSales(double _grossSales) {
      while(validateGrossSales(_grossSales) == false) {
          _grossSales = fixGrossSale(_grossSales);
      }
      this.grossSales = _grossSales;
    }// end setGrossSales method
    
    /**
     * sets the commissionRate instance variable of the employee as a decimal so
     * a commission rate of 7.5% in decimal form is .075
     * @param _commissionRate is the decimal representation of the employees 
     * commission percentage
     * @throws IllegalArgumentException must be between 0 and 1 inclusively 
     */
    public void setCommissionRate(double _commissionRate) {
      while(validateCommissionRate(_commissionRate) == false) {
          _commissionRate = fixCommissionRate(_commissionRate);
      }
      this.commissionRate = _commissionRate;
    }//end method setCommissionRate
    
    /**
     * @return the gross sales amount
     */
    public double getGrossSales() {return grossSales;}
    
    /**
     * @return the commissionRate
     */
    public double getCommissionRate() {return commissionRate;} 
    
    /**
     * @return the calculated earnings for employee
     */
    public double earnigs(){return commissionRate * grossSales;}
    
    /**
     * @returns String representation of the commissionEmployee object
     */
    @Override
    public String toString(){
        return String.format(
                "%n%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f%n%s: %.2f%n",
                "commission employee",super.getFirstName(),super.getLastName(),
                "social security number", super.getSocialSecurityNumber(),
                "gross sales", grossSales,
                "commission rate", commissionRate,
                "total earnings", this.earnigs());
    }
    
    /**
     * prints out the employee info
     */
    @Override // this method overrides a superclass method
    public void printEmployeeInfo(){
        System.out.println(this.toString());
    }//end method printEmployeeInfo
    
    /**
     * Method to print out the employees stored in a list
     * @param list is the Array list you want to print
     */
    public static void printCommissionList(ArrayList<CommissionEmployee> list){
        for(CommissionEmployee elem : list){
            System.out.println(elem+"\n");
        }
    }//end method printList
    
    /**
     * A static method for letting the user set a commission employee object
     * @return a reference to an employee object. it needs to be saved to
     * a new location or it will be lost.
     */
    public CommissionEmployee getUserInputForEmployee(){
        CommissionEmployee result = new CommissionEmployee();
        
        System.out.println("\nplease Enter the First and Last name of the new "+
                "employee you wish to add: ");
        result.setFirstName(input.next());
        result.setLastName(input.next());
        
        System.out.print("please Enter the social security number in the"+
                " following format: AAA-GG-SSS: ");
        result.setSocialSecurityNumber(input.next());
        
        System.out.print("please Enter the commission rate as a decimal: ");
        result.setCommissionRate(input.nextDouble());
        
        System.out.print("please Enter the gross sales: ");
        result.setGrossSales(input.nextDouble());
        
        return result;       
    }
    
    /**
     * method for checking if the gross sales input is valid
     * @param gs is a double representing the total gross sales of an employee
     * and must be a non negative value
     * @return true or false
     */
    private boolean validateGrossSales(double gs){
        if (gs < 0.0) {
            return false;
        }
        return true;
    }//end method validateGrossSales
    
    /**
     * Fixer method that is called when a bad gross sales value is entered 
     * giving the user another chance to enter a valid gross sale rate
     * @param gs is the gross sales total
     * @return the new gross sale 
     */
    private double fixGrossSale(double gs){
        System.out.print("gross sales must be a positive value,"+
                    " try again: ");
        gs = input.nextDouble();
        return gs;
    }//end method fixGrossSales
    
    /**
     * method for checking if the commission rate is within a valid range
     * @param ccr is a double decimal value between 0.01 and 1.
     * @return true or false
     */
    private boolean validateCommissionRate( double ccr){
        if (ccr < 0.0 || ccr >= 1.0) {
            return false;
      }
        return true;
    }//end method validateCommissionRate
    
    /**
     * Fixer method that is called when bad input values are entered for a
     * commission rate that will allow the user the chance to enter valid rate
     * @param ccr commission rate of employee
     * @return the new commission rate
     */
    private double fixCommissionRate(double ccr){
        System.out.print("Enter a value between .01 and 1.0 for the"+
                    " commision rate: ");
        ccr = input.nextDouble();
        return ccr;
    }//end method fixCommissionRate
    

    
}//end class ComissionEmployee