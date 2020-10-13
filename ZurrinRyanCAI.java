/**
*PROGRAM NAME: ZurrinRyaCAI.java
*AUTHOR: Ryan Zurrin
*ASSIGNMENT #: Chapter 5 5.35 & 5.36 combined together as one program
*DUE DATE: Thursday, October 8, 2020, 3:00 PM
*DESCRIPTION: write a program to help an elementary school kid practice thier
* multiplication problems. Only single digit was required in the problem but I
* have included a way to chage that in case the user needs more of a challenge.
*///============================================================================
import java.security.SecureRandom; // for random number generation
import java.util.Scanner;  // for getting user input

public class ZurrinRyanCAI
{
    private static final SecureRandom numMaker = new SecureRandom();
    static Scanner guess = new Scanner(System.in);
    public static int answer = -1;
    private static int maxDigitValue = 9;
    private static int correct = 0;
    private static int wrong = 0;

    public static void main(String args[])
    {
        while(answer != -99)
        {
			if (answer == -66){
				changeDifficulity();
			}
            getNewMultiplication();
        }
        System.out.println("Thank You for practicing, Good Bye!");
    } //end java main method(String args[])

    /**
    * method: getMultiplication()
    * arguments: none
    * purpose: randomly builds a multiplication problem to solve
    * return: void
    */
    public static void getNewMultiplication()
    {
        int num1 = getNumber();
        int num2 = getNumber();
        int product = num1 * num2;

        System.out.printf("Use -99 to quit program or" +
        			" -66 to change difficulity\n"+
        			"stats -> correct: %d, wrong: %d, accuracy: %.2f%%%n%n",
        			correct, wrong,
        			correct + wrong == 0 ? 0 :((double) correct / (correct + wrong))*100);

        do{
           	System.out.printf("How much is %d times %d?%n>>",num1, num2);

            while(!guess.hasNextInt())
			{
				String in = guess.next();
				System.out.print("That was not a number, try again\n>>");
	      	}
            answer = guess.nextInt();

            if(answer == -99 || answer == -66)
            {
				break;
			}

	    	if(checkAnswer(product, answer) == true)
	    	{
				correct += 1;
				System.out.println(correct());
	   		}
	   		else
	   		{
				wrong += 1;
				System.out.println(incorrect());
            }
            //updateAccuracy();
        }while(checkAnswer(product, answer) == false);
    }// end of method getMultiplication()


	/**
	* method: getNumber()
	* arguments: none
	* purpose: randomly generates a number from 0 to 9
	* return: int, from 0 to 9
	*/
	public static int getNumber()
	{
	    return numMaker.nextInt(maxDigitValue);
   	}// end of method getNumber()


    /**
    * method: checckAnswer(int correct, int guessed)
    * arguments: correct answer, guessed answer
    * purpose: returns true if correct and guessed match and false if not
    * return: true or false
    */
    public static boolean checkAnswer(int correct, int guessed)
    {
        if (guessed == correct)
        {
			return true;
        }
        return false;
    }// end of method checkAnswer(int, int)

    /**
    * method: correct()
    * arguments: none
    * purpose: randomly picks a phrase of encouragement on a correct answer
    * return: String, random sentence
    */
    public static String correct()
    {
        int randomPick = numMaker.nextInt(4);
        String pick = "";
        switch(randomPick)
        {
            case 0:
                pick = "You are correct, steller!\n";
                break;
            case 1:
                pick = "Keep up the great work!\n";
                break;
            case 2:
                pick = "Correct, very good job!\n";
                break;
            case 3:
                pick = "Excellent, that is right!\n";
                break;
            default:
                pick = "Nice work!"; // just in case!
        }
        return pick;
    }// end of method correct()

    /**
    * method: incorrect()
    * arguments: none
    * purpose: randomly picks a phrase of encouragement on a incorrect answer
    * return: String, random sentence
    */
    public static String incorrect()
    {
		int randomPick = numMaker.nextInt(4);
		String pick = "";
		switch(randomPick)
        {
			case 0:
				pick = "No. Please try again.";
				break;
			case 1:
				pick = "Wrong. But you can go again.";
				break;
			case 2:
				pick = "Not this time, but don't quit now.";
				break;
			case 3:
				pick = "Oops not the right answer, try again";
				break;
			default:
				pick = "Wrong choice"; // just in case!
		}
		return pick;
    }//end of method incorrect()

	/**
	* method: changeDifficulity()
	* arguments: none
	* purpose: lets user make it more challenging if they want
	* return: void
    */
    private static void changeDifficulity()
    {
		do{
			System.out.print("Please enter the max number for"+
												" each multiplier\n>>");
			while(!guess.hasNextInt())
			{
				String in = guess.next();
				System.out.print("Please enter a max number for"+
												" each multiplier\n>>");
			}
			maxDigitValue = guess.nextInt();
		}while(maxDigitValue < 0);
	}// end of method changeDifficulity

} //end of class ZurrinRyanCAI
