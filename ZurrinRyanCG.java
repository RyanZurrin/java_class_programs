/**
*PROGRAM NAME: ZurrinRyanCG.java
*AUTHOR: Ryan Zurrin
*ASSIGNMENT #: Chapter 6 Program, Card memory Game
*DUE DATE:     Thursday, October 15, 2020
*DESCRIPTION:  Design a memory card game simulator. This is a game of guessing.
*  Shuffled card are placed faced down in a grid and turns are then taken to
*  try to guess matching pairs. If a pair is guessed they should remain up.
*///============================================================================
import java.security.SecureRandom; // for random number generation
import java.util.*;  // for getting user input and Exception Handling


public class ZurrinRyanCG {


	// flag used for checking for matches at proper times
	private static boolean flag = true;

	//Secure Random object for shuffling the cards
    private static final SecureRandom random = new SecureRandom();

    //Scanner object for taking in the user input
    private static Scanner input = new Scanner(System.in);

    //variable for keeping track of the flipped card
    private static int cardsUp = 0;

    //variable for keeping track of total turns
	public static int totalTurns = 0;

	// array to store the user choices
	public static int[] flipCardArray = new int[4];

	// 2d array of the initial gameboard is declared and filled with values
    public static int[][] game_board = {
        {1, 1, 2, 2},
        {3, 3, 4, 4},
        {5, 5, 6, 6},
        {7, 7, 8, 8}
    };

    // 2d boolean array to tell method what cards to show
    private static boolean[][] card_showing = {
        {false, false, false, false},
        {false, false, false, false},
        {false, false, false, false},
        {false, false, false, false},
    };
    /**
     * method: getCoordinates()
     * arguments: none
     * purpose: get the coordinates from user for cards to flip
     * return: void
     */
    public static void get_cordinates() throws Exception
    {
		do{
			System.out.print("\nPlease enter the co-ordinates of the first card"+
                    " you want to turn over, row then column\n>>");


				try{
					flipCardArray[0] = input.nextInt() - 1;
					flipCardArray[1] = input.nextInt() - 1;
				}
				catch(Exception e)
				{
					reset_game();
				}

      	}while(flipCardArray[0] < 0 ||
         	   flipCardArray[1] < 0 ||
          	   flipCardArray[0] >= 4 ||
           	   flipCardArray[1] >= 4 ||
           	   card_showing[flipCardArray[0]][flipCardArray[1]] == true);


      	card_showing[flipCardArray[0]][flipCardArray[1]] = true;
     	show_deck();

		do{
			System.out.print("\nPlease enter the co-ordinates of the second card"+
		                    " you want to turn over, row then column\n>>");

				try
				{
					flipCardArray[2] = input.nextInt() - 1;
					flipCardArray[3] = input.nextInt() - 1;
				}
				catch(Exception e)
				{
					reset_game();
				}

		}while(flipCardArray[2] < 0 ||
			   flipCardArray[3] < 0 ||
			   flipCardArray[2] >= 4 ||
			   flipCardArray[3] >= 4 ||
			   card_showing[flipCardArray[2]][flipCardArray[3]] == true);

		card_showing[flipCardArray[2]][flipCardArray[3]] = true;
        show_deck();
        totalTurns += 1;
        check_match();
        clear_screen();

    }//end method getCoordinates

	/**
	* method: shuffle_deck()
	* arguments: none
	* purpose: shuffles the cards to make random
	* return: void
    */
    public static void shuffle_deck(){
        int a = 0, b = 0, temp = 0;
            for (int i = 0; i < game_board.length; i++){
               for (int j = 0; j < game_board.length; j++){
                   a = random.nextInt(i + 1);
                   b = random.nextInt(j + 1);

                   temp = game_board[i][j];
                   game_board[i][j] = game_board[a][b];
                   game_board[a][b] = temp;
               }
            }
    }// end shuffle_deck method

    /**
    * method:  check_match()
    * arguments: none
    * purpose: checks if the face up pairs are a match
    * return: void
    */
    public static void check_match(){
		if(game_board[flipCardArray[0]][flipCardArray[1]]
			== 	game_board[flipCardArray[2]][flipCardArray[3]]&&
			flag == true){
				System.out.println("A Match Was Found");
				calculate_cards();
			}
			else{
				card_showing[flipCardArray[0]][flipCardArray[1]] = false;
				card_showing[flipCardArray[2]][flipCardArray[3]] = false;
			}
    }//end check_match method

   /**
    * method:   reset_game()
    * arguments: none
    * purpose: resets the game when an exception is thrown
    * return: void
    */
    public static void reset_game() throws Exception
    {
		try{
			System.out.println("Error, Try again");
			System.out.println("");
			input.nextLine();
			input.reset();
			flag = false;
			play_game();
		}
		catch(Exception e){
		reset_game();
		}

	}

    /**
	* method: show_deck()
	* arguments: none
	* purpose: shows the cards face down or face up on the board
	* return: void
    */
    public static void show_deck(){
		System.out.println("\n     1 2 3 4");
		System.out.println("    ________");

        for(int row = 0; row < game_board.length; row++){
			System.out.printf(" %d | ", row+1);
            for(int column = 0; column < game_board[row].length; column++){
				if (card_showing[row][column]) {
				    System.out.printf("%d ",game_board[row][column]);
				 }
				 else{
					 System.out.print("* ");
				 }
            }
            System.out.println();
        }
    }// end method show_deck

	/**
	* method: gameHeading()
	* arguments: none
	* purpose: prints the game title and heading
	* return: void
    */
    public static void game_heading(){
        System.out.println("                  The 4x4 Memory Card Game\n");
        System.out.println("\n     Use the number grid as the coordinates for"+
		    " your picks\nexample: the first card would be 1 1, and" +
		    " the last card would ba at 4 4\n" +
            "            seperate by a space and  4 is the maximum\n");
    }// end method gameHeading

    /**
	* method: calculateCards()
	* arguments: none
	* purpose: calculates the cards up count
	* return: void
    */
    public static void calculate_cards()
    {
		cardsUp = 0;

		for(int row = 0; row < card_showing.length; row++){
		   	for(int column = 0; column < card_showing[row].length; column++){
					if (card_showing[row][column]== true) {
						   cardsUp += 1;
					}

			 }
          }
	}

	/**
	* method: clear_screen()
	* arguments: none
	* purpose: clears the screen, giving a pause for player to see last move
	* return: void
	   */
	public static void clear_screen() {
		for(int i = 0; i < 10; i++) {
				System.out.println("\n");
		}
		try {

				Thread.sleep(1500);
		}
		catch (InterruptedException e) {
			    	 System.out.println("Error...exiting now");

	     }
	     for(int i = 0; i < 3; i++) {
				System.out.println("\n");
		 }
		 calculate_cards();
	}//end clear_screen method

	/**
	* method: playGame()
	* arguments: none
	* purpose: main game method to run the game
	* return: void
    */
    public static void play_game() throws Exception
    {
		input.reset();
		if(flag == false){
			check_match();
		}

	try{
		while(cardsUp < 16){
			flag = true;
            show_deck();
			get_cordinates();
			check_match();
			calculate_cards();
			System.out.printf("cards over: %d -- total plays: %d%n"
			,cardsUp, totalTurns);
        }

	}catch(InputMismatchException e){
		reset_game();
	}
	catch(ArrayIndexOutOfBoundsException e)
	{
		reset_game();
	}


    System.out.printf("Winner!!! It took %d Plays to Win.\n"
                                , totalTurns);
    }// end method play_game




	// main java method
	public static void main(String args[]) throws Exception
	{
		shuffle_deck();
	    game_heading();

		try
		{
			play_game();
		}
		catch(InputMismatchException e)
		{
	    	reset_game();
	    }
	    catch(ArrayIndexOutOfBoundsException e)
		{
			reset_game();
		}


    }// end java main method

}// end Class
