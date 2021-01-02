/**
*@filename ZurrinRyanPS.java
*@author Ryan Zurrin
*@assignment Chapter 11 program
*@due_date  Thursday, November 26, 2020, 3:00 PM
*@description  to make a program that allows a user to either take or not take a
* survey based on how they reply. This program is to use proper exception
* handling techniques to prevent from crashing or stopping mid run. It should
* allow for recovery and the continuation of operations no matter what.
*/
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ZurrinRyanEH {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        CustomerSurvey forGreg = new CustomerSurvey();
        forGreg.runSurvey();
        /*
        CustomerSurvey[] results = new CustomerSurvey[]{
			new CustomerSurvey(34, "states.dat", "ma","01201"),
			new CustomerSurvey(515, "states.dat", "ma", "12345" ),
			new CustomerSurvey(87, "stfates.dat", "ndY", "03375" ),
			new CustomerSurvey(55, "staftes.dat", "ca", "jtyde" ),
			new CustomerSurvey(17, "states.dat", "RI", "12345" ),
		};
		for (CustomerSurvey result : results) {
		            result.printData();
		 }
		 */


    }//end method main

}//end of class ZurrinRyanEH

 class CustomerSurvey {
     private Path path;
     private String[][] stateInfo;
     private int age;
     private String zipCode;
     private String state;

     /**
      * no argument constructor
      */
     CustomerSurvey() {
         age = 16;
         zipCode = "55555";
         state = "US";
         stateInfo  = new String[52][2];
         for(int i = 0; i < stateInfo.length; i++){
                 for(int j = 0; j < stateInfo[i].length; j++){
                     stateInfo[i][j] = "";
                 }//end inner for loop
             }//end for loop

     }//end no argument constructor

     /**
      * overloaded constructor
      * @param _age is the age of customer taking survey
      * @param fullFilePath is the path to file to search
      * @param _state should be the state abbreviation
      * @param _zip is the zip-code of customer
      */
     CustomerSurvey(int _age, String fullFilePath, String _state, String _zip){
         stateInfo  = new String[52][2];

         for(int i = 0; i < stateInfo.length; i++){
             for(int j = 0; j < stateInfo[i].length; j++){
                 stateInfo[i][j] = "";
             }//end inner for loop
         }//end for loop
         try {

             age = age(_age);
             Path path = file(fullFilePath);
             state = state(_state);
             zipCode = zip(_zip);

         } catch (FileNotFoundException ex) {
             Logger.getLogger(CustomerSurvey.class.getName())
                     .log(Level.SEVERE, null, ex);
         }
      }//end overloaded constructor

     /**
      * Method to display the survey greeting and rules
      */
     private void greeting(){
         System.out.println("\nWelcome to AQUAS, the Annual Quality User"
                 + " Assurance Survey.\nPlease enter your age if you wish to"
                 + " participate.\nEntering anything but an age will"
                 + " be regarded\nas your choice to opt out of this survey\n");
     }
     /**
      * method to give thanks and encourage support
      */
     private void giveThanks(){
         System.out.println("Your participation in AQUAS is immensly"
                 + " appreciated.\nThis annual surveys allows us to better "
                 + "serve you.\n");
     }//end method giveThanks

     /**
      * method to set the age variable
      */
     private void setAge(final int _age) throws IllegalArgumentException{
         if(age >= 0){
             age = _age;
         }
         else
             throw new IllegalArgumentException("age cannot be below 0");
     }//end method setAge
     /**
      * method to set the zip code variable
      */
     private void setZipCode(final String _zip ){
         zipCode = _zip;
     }//end nmethod setZipCode

     /**
      * method to set the state variable
      */
     private void setState(String _state){
         state = _state;
     }//end method setState

     /**
      * returns the value stored in age
      */
     public int getAge() {return age;}//end method getAge

     /**
      * returns the value stored in zipCode
      */
     public String getZipCode(){return zipCode;}//end of method getZipCode

     /**
      * returns the value stored in state
      */
     public String getState(){return state;}//end of method getState

     /**
      * returns the stateInfo array data
      */
     public String[][] getStateArray(){return stateInfo;}

     @Override
     public String toString(){
         return String.format("%s: %d%n%s: %s%n%s: %s%n",
                 "age     ", this.getAge(),
                 "state   ", this.getState(),
                 "zip-code", this.getZipCode());
     }//end method toString

     /**
      * display method for printing out the customer data
      */
     public void printData(){
         System.out.println("\n"+this.toString());
     }

     /**
      * method for displaying the state Info array
      */
     public void printStateInfoArray(){
         for (int row = 0; row < stateInfo.length; row++){
             for (int col = 0; col < stateInfo[row].length; col++){
                 System.out.printf("%s ", stateInfo[row][col]);
              }//end inner for loop

          }//end outer for loop
     }//end method printStateInfoArray

     /**
      * method to print out arrays
      */
     public void printArray(String[] arr){
         for(int i = 0; i < arr.length; i++){
             System.out.printf("%s ", arr[i]);
            }
     }//end method printArray

     /**
      * method to get the users age and determine if they want to
      * participate in the survey or not
      * @throws InputMismatchException
      */
     public void agePrompt() throws InputMismatchException{
         Scanner input = new Scanner(System.in);
         int sampleAge = 0;
         boolean flag = false;
         try{
             do{
                 flag = false;
                 System.out.print("\nPlease enter your age to continue\n>> ");
                 sampleAge = input.nextInt();
                 if(sampleAge <= 15 || sampleAge > 130){
                     System.out.println("You entered a invalid age" +
                             " please try re-typing a age between 16 and 130");
                     flag = true;
                 }//end if
             }while(flag == true);
          }//end try
         catch(InputMismatchException e){
             System.out.println("\nYou have opted out of the survey. If you"+
                     " change\nyour mind and wish to participate, you can do\n"+
                     "so any time. Simply run this program and enter your" +
                     " age.\nThank you and goodbye\n");
            System.exit(0);
            }//end catch
            this.setAge(sampleAge);

      }//end method agePrompt

      /**
      * method to validate a user age that is entered through the overloaded
      * constructor
      * @throws InputMismatchException
      */
     private int age(int val) throws InputMismatchException{
         Scanner input = new Scanner(System.in);
         boolean flag = false;
         try{
             while(val <= 15 || val > 130){
                 System.out.println("The age entered was invalid please\n"
                         + "please try re-typing a age between 16 and 130\n"
                         + "if you wish to participate in survey");
                     val = input.nextInt();
                 }//end while
         }//end try
         catch(InputMismatchException e){
             System.out.println("\nYou have opted out of the survey. If you"+
                     " change\nyour mind and wish to participate, you can do\n"+
                     "so any time. Simply run this program and enter your" +
                     " age.\nThank you and goodbye\n");
         }//end catch
         return val;
        }//end method age

     /**
      * method to prompt the survey take to enter a valid file name
      * @throws IOException
      */
     public void filePrompt() throws IOException{
         Scanner input = new Scanner(System.in);
        // String pick = "";
         boolean flag;
         do{
            flag = false;
            try{
               System.out.print("Enter a full file or directory name\n>> ");
               Path path = Paths.get(input.nextLine());

               File fileReader = new File(path.toString());

               Scanner sc = new Scanner(fileReader);
               int row, col;

               for(row = 0; row < stateInfo.length; row++){
                   String line = sc.nextLine();
                   String[] temp = line.split(":");

                   for(col = 0; col < stateInfo[row].length;col++){
                       stateInfo[row][col] = temp[col];
                   }//end inner for loop
               }//end outer for loop
            }//end try
            catch(FileNotFoundException e){
                flag = true;
                System.out.println(e.getLocalizedMessage());
            }//end catch
         }while(flag == true);

     }//end method filePrompt

     /**
      * method to prompt the survey take to enter a valid file name
      * @param p is the Path object being tested
      * @throws IOException
      */
     private Path file(String p) throws FileNotFoundException{
         Scanner input = new Scanner(System.in);
         Path test = Paths.get(p);
         boolean flag;
         int count = 0;
         do{
            flag = false;
            try{
               if(count > 0){
                   System.out.print("Enter a full file or directory name\n>> ");
                   test = Paths.get(input.nextLine());
               }//end if statement

               File fileReader = new File(test.toString());

               Scanner sc = new Scanner(fileReader);
               int row, col;

               for(row = 0; row < stateInfo.length; row++){
                   String line = sc.nextLine();
                   String[] temp = line.split(":");

                   for(col = 0; col < stateInfo[row].length;col++){
                       stateInfo[row][col] = temp[col];
                   }//end inner for loop
               }//end outer for loop

            }catch(FileNotFoundException e){
                flag = true;
                count = count + 1;
                System.out.println(e.getLocalizedMessage());
            }//end catch FileNotFoundException
         }while(flag == true);
         return test;
     }//end method filePrompt


     /**
      * method for prompting the survey taker for the state abbreviation
      * @throws InputMismatchException,IllegalArgumentException
      */
     public void statePrompt()
             throws InputMismatchException,IllegalArgumentException{

         Scanner input = new Scanner(System.in);
         boolean flag;
         String response = "";
         do{
            flag = false;
            try{
               System.out.print(
                  "What is the two letter abbrieviation of your state?\n>>" );
               response = input.nextLine().toLowerCase();

               if(findStateName(response) != "error"){
                 setState(findStateName(response));
               }else{
                 throw new IllegalArgumentException("State abreveation "
                         + "not found");
               }
            }catch(InputMismatchException e){
                flag = true;
                System.out.println(e.getLocalizedMessage());
            }//end InputMismatchException
            catch(IllegalArgumentException e){
                flag = true;
                 System.out.println(e.getLocalizedMessage());
            }//end catch IllegalArgumentException
        }while(flag == true);
      }//end method statePrompt


     /**
      * method for prompting the survey taker for the state abbreviation
      * @throws InputMismatchException,IllegalArgumentException
      */
     public String state(String stateAbr)
             throws InputMismatchException,IllegalArgumentException{
         Scanner input = new Scanner(System.in);
         boolean flag;
         int count = 0;
         String temp = "";
         do{
            flag = false;
            try{
                if(count>0){
                    System.out.print(
                            "What is the two letter abbrieviation "
                                    + "of your state?\n>>" );
                    stateAbr = input.nextLine().toLowerCase();
                }

                if(findStateName(stateAbr) != "error"){
                  temp = findStateName(stateAbr);
                }//end if
                else{
                  throw new IllegalArgumentException("State abreveation "
                          + "not found");
                }//end else
            }catch(InputMismatchException e){
                flag = true;
                count += 1;
                System.out.println(e.getLocalizedMessage());
            }//end InputMismatchException
            catch(IllegalArgumentException e){
                flag = true;
                count +=1;
                 System.out.println(e.getLocalizedMessage());
            }//end catch IllegalArgumentException


        }while(flag == true);
        return temp;
      }//end method statePrompt



     /**
      * method that prompts the user to enter a zip code
      * @throws IllegalArgumentException
      */
     public void zipPrompt()
             throws IllegalArgumentException {
          Scanner input = new Scanner(System.in);
          String response = "";
          boolean flag;

          do{
              flag = false;
              try{
                  System.out.print(
                  "Please add your five digit zip code now\n>>" );
                  response = input.nextLine().trim();
                  if(response.length() == 5 && response.matches("[0-9]{5}")){
                      this.setZipCode(response);
                      break;
                   }// end if
                  else{
                      throw new IllegalArgumentException("You entered an "
                              + "invalid zip code please");
                  }//end else statement
              }//end try
              catch(IllegalArgumentException e){
                  flag = true;
                  System.out.println(e.getLocalizedMessage());
              }//end InputMismatchException
          }while(flag == true);
     }//end method zipPrompt

      /**
      * method that prompts the user to enter a zip code
      * @param z is the zip code as a string of integral values if it is not a
      * integral an exception is thrown and the survey taker is given the
      * chance to recover with a correct 5 digit integer which is excepted as a
      * string and verified
      * @throws IllegalArgumentException
      */
     public String zip(String z)
             throws IllegalArgumentException {
          Scanner input = new Scanner(System.in);
          boolean flag;
          int count = 0;
          do{
              flag = false;
              try{
                  if(count>0){
                      System.out.print("Please add your five digit zip code"
                              + " now\n>>" );
                  z = input.nextLine().trim();
                  }

                  if(z.length() == 5 && z.matches("[0-9]{5}")){
                      return z;
                   }// end if
                  else{
                      throw new IllegalArgumentException("You entered an "
                              + "invalid zip code please");
                  }
              }
              catch(IllegalArgumentException e){
                  flag = true;
                  count += 1;
                  System.out.println(e.getLocalizedMessage());
              }//end InputMismatchException
          }while(flag == true);
          return z;
     }//end method zipPrompt

     /**
      * method to search the stateInfo array for a matching state
      * @param stateAbrv is the two letter abbreviation of a survey takers state
      * @return "state name" or "error" as strings
      */
     private String findStateName(final String stateAbrv){
         String fullState = "";
         String error = "error";
         for(int row = 0; row < stateInfo.length; row++){
                for(int col = 0; col < stateInfo[row].length;col++){
                   if(stateInfo[row][col].equalsIgnoreCase(stateAbrv)){
                       fullState = stateInfo[row][col+1];
                       return fullState;
                   }
                }//end inner for loop
            }//end outer for loop
         return error;
     }//end method findStateName

    /**
     * Method to run the survey sequence automatically
     */
     public void runSurvey(){
         try {
             this.greeting();
             this.agePrompt();
             this.filePrompt();
             this.statePrompt();
             this.zipPrompt();
             this.printData();
             this.giveThanks();
         }//end try
         catch (Exception ex) {
             System.out.print(ex.getLocalizedMessage());
         }//end catch
         finally{
			 //I know it is not directly related to the first catch like it
			 //was specified but that block has closed already, this was the
			 //best i could figure out
             System.out.println("Thank You for participating in our survey");
         }
     }//end method runSurvey

 }// end class Customers