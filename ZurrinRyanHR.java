/**
*@filename ZurrinRyanHR.java
*@author Ryan Zurrin
*@assignment Chapter 7 Program Target-Heart-Rate Calculator
*@due_date Thursday, October 29, 2020, 3:00 PM
*@description  a class for calculating the maximum heart rate as well as the
* range for the target heart rates of an individual based of the users birth-
* day.
*///===========================================================================
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class ZurrinRyanHR
{
    /**
     * instance variables for the HeartRate Class
     */
     //
    private String firstName;
    private String lastName;
    private int day;
    private int month;
    private int year;
    private int age;
    private int maxHeartRate;
    private int[] targetHeartRate;
    public boolean errorFlag;

    /**
     * constructor: sets the instance variables to defaults
     */
    ZurrinRyanHR()
    {
        this.targetHeartRate = new int[2];
        this.firstName = "g";
        this.lastName = "g";
        this.day = 1;
        this.month = 1;
        this.year = 1901;
        this.age = 0;
        this.maxHeartRate = 0;
        this.targetHeartRate[0] = 0;
        this.targetHeartRate[1] = 0;
        this.errorFlag = false;

    }

    /**
     * overloaded constructor
     * @param fn is the first name, must be in "quotes" or string variable
     * @param ln is the last name, must be in "quotes" or string variable
     * @param day of the month 1 - 31
     * @param month of the year 1 - 12
     * @param year of birth from 1600 - current
     */
    ZurrinRyanHR(final String fn,final String ln,
        						final int day, final int month, final int year)
    {
        this.targetHeartRate = new int[2];
        this.firstName = fn;
        this.lastName = ln;
        this.day = day;
        this.month = month;
        this.year = year;
        this.set_attributes();
    }

    /*__________________________________________________________________________
    * Setters methods to set data
    */
    /**
     * Sets the first name instance variable
     * @param fName is the first name
     */
    public void set_firstName(final String fName)
    {
        this.firstName = fName;
    }

    /**
    * Sets the last name of the instance variable
    * @param lName is the last name
    */
    public void set_lastName(final String lName)
    {
        this.lastName = lName;
    }

    /**
    * Sets the day of the instance variable
    * @param day of birthday
    */
    public void set_day(final int _day)
    {
        this.day = _day;
        this.set_attributes();
    }

    /**
    * Sets the month instance variable
    * @param month of birthday
    */
    public void set_month(final int _month)
    {
        this.month = _month;
        this.set_attributes();
    }

    /**
    * Sets the year instance variable
    * @param year is the birth year
    */
    public void set_year(final int year)
    {
        this.year = year;
        this.set_attributes();
    }

    /**
    * Sets the birthday of the user
    * @param day of birthday
    * @param month of birthday
    * @param year of birthday
    */
    public void set_birth_date(final int day, final int month, final int year) //throws Exception
    {
        try{
            this.day = day;
            this.month = month;
            this.year = year;
            this.set_attributes();
        }catch(Exception e){
               errorFlag = true;
               System.out.print(e);
               System.out.println("\nTry again");
        }

    }

    /**
    * Sets the birthday of the user at run-time using a prompt and user input
    */
    public void set_birth_date() //throws Exception
    {
       Scanner input = new Scanner(System.in);
       boolean errorFlag;

       do{
           errorFlag = false;
           try{
               do{
                    System.out.print("Please enter your birth day in the"+
					" following format: dd mm yyyy\n>> ");
                    this.month = input.nextInt();
                    this.day = input.nextInt();
                    this.year = input.nextInt();
                    this.set_attributes();

               	   if(year < 1900){
                        System.out.println("Please enter a year past 1900");
                        continue;
                    }

               }while(year < 1900);

           }catch(Exception e){
               errorFlag = true;
               System.out.print(e);
               System.out.println("\nTry again");
               input.nextLine();
           }

        }while(errorFlag == true);
        /*
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your birth day in the following"+
                " format: mm dd yyyy\n>> ");
        this.day = input.nextInt();
        this.month = input.nextInt();
        this.year = input.nextInt();
        this.set_attributes();
        */
    }

    /**`
     * prompts the user for the name and birth date
     */
    public static void get_user_input()
    {
       Scanner input = new Scanner(System.in);
       ZurrinRyanHR testcase;
       int d,m,y;
       String fn, ln;
       boolean errorFlag;

        do{
           errorFlag = false;
           try{

               System.out.print("To find your target heart rate please" +
                " enter your\n first and last names, example: John Smith," +
                "\n press enter when done\n >>");
               fn = input.next();
               ln = input.next();

               do{
				   System.out.print("Please enter your birth day in the"+
				   					" following format: mm dd yyyy\n >> ");
				   d = input.nextInt();
				   m = input.nextInt();
				   y = input.nextInt();

               	   if(y<1900){
                   		System.out.println("Please enter a year past 1900");
                   		continue;
               		}

               }while(y < 1900);

               testcase = new ZurrinRyanHR(fn, ln, d, m, y);
               testcase.show_user_data();

           }catch(Exception e){
               errorFlag = true;
               System.out.print(e);
               System.out.println("\nTry again");
               input.nextLine();
           }

        }while(errorFlag == true);

    }
    /*__________________________________________________________________________
    * Getters methods to return the variable data (not display it)
    */

    /**
     * returns the name in the firstName variable
     */
    public String return_firstName()
    {
        return firstName;
    }

    /**
     * returns the lastName variable
     */
    public String return_lastName()
    {
        return lastName;
    }

    /**
     * returns the day variable
     */
    public int return_day()
    {
        return day;
    }

    /**
     * returns the month variable
     */
    public int return_month()
    {
        return month;
    }

    /**
     * returns the year
     */
    public int return_year()
    {
        return year;
    }

    /**
    * Returns the target heart rate as upper and lower bounds in an array
    * @param maxHeartRate is used to calculate the target HR which is 50% to
    * 80% of the maximum heart rate
    */
    public int[] return_target_heart_rate_range(int maxHeartRate)
    {
        int[] thr = new int[2];
        thr[0] = (int) Math.round(.5 * maxHeartRate);
        thr[1] = (int) Math.round(.85 * maxHeartRate);
        return thr;
    }

    /*__________________________________________________________________________
    * display methods to print out the data to the screen
    */

    /**
    * Prints out the max heart rate
    */
    public void show_max_heart_rate()
    {
        System.out.printf("Max HR: %d%n", this.maxHeartRate);
    }

    /**
     * Prints out the target heart rate range
     */
    public void show_target_heart_rates(){
                            System.out.println("Target Heart Rate Range");
                            System.out.printf("lower: %d, upper: %d%n",
                            this.targetHeartRate[0],
                            this.targetHeartRate[1] );
    }

    /**
     * Prints out the users date of birth
     */
    public void show_DOB()
    {
        System.out.printf("DOB: %d/%d/%d%n", day, month, year);
    }

    /**
     * Prints out the users age
     */
    public void show_age()
    {
        System.out.printf("age: %d%n", age);
    }

    /**
     * Prints out the users name
     */
    public void show_name()
    {
        System.out.printf("Name: %s %s%n", this.firstName, this.lastName);
    }

    /**
     * Prints out all the user data
     */
    public void show_user_data()
    {
        System.out.println();
        this.show_name();
        this.show_DOB();
        this.show_age();
        this.show_max_heart_rate();
        this.show_target_heart_rates();
    }

    /*__________________________________________________________________________
    * private methods for updating data
    */

    /**
     * sets the age, and the max, and target heart rates
     */
    private void set_attributes()
    {
        this.age = this.return_age(this.day, this.month, this.year);
        this.maxHeartRate = this.return_max_heart_rate(age);
        this.targetHeartRate =
                this.return_target_heart_rate_range(this.maxHeartRate);
    }

    /**
     * Returns the age of a person using the birth date provided and the
     * day variable which contains a LocalTime object
     * @param d is the day
     * @param m is the month
     * @param y is the year
     * @return age
     */
    private int return_age(int d, int m, int y)
    {
         LocalDate now = LocalDate.now();
         LocalDate bday = LocalDate.of(y, d, m);
         return Period.between(bday, now).getYears();
    }

    /**
     * Returns the maximum heart rate
     * @param _age_
     * @return the maximum heart rate based on age
     */
    private int return_max_heart_rate(int _age_)
    {
        final int temp = 220;
        return temp - _age_;
    }


    /**________________________________________________________________________
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
		Scanner input = new Scanner(System.in);
		char replay;
		do{
			 get_user_input();
			 System.out.print("\nPress 'Y' or 'y' to keep running\n >>");
			 replay = input.next().trim().charAt(0);

		}while(replay == 'Y' || replay =='y');

    }
}
