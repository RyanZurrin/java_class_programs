/*
*PROGRAM NAME: ZurrinRyanHO.java
*@AUTHOR:      Ryan Zurrin
*ASSIGNMENT #: Chapter 3 Program
*DUE DATE:     Thursday, September 24, 2020, 3:00 PM
*DESCRIPTION:  Write a program that asks the user for the number of floors in a
hotel and for each floor it then asks for the number of rooms and how many of
them rooms are occupied. When finished it displays how many total rooms there
are and the number of occupied rooms and unoccupied rooms as well as % of rooms
that are occupied
*/
//=============================================================================
import java.util.Scanner;

public class ZurrinRyanHO {

    // variables to hold number of floors
        int floors = 0;
        // variables to hold temp and total floor data
        int rooms_total = 0;
        // variables to hold total number of occupied rooms
        int occupied = 0;

        // creating new Scanner object to get user input
        Scanner input = new Scanner(System.in);

    public static void main(String args[]) {

       ZurrinRyanHO ryanTowers = new ZurrinRyanHO();
       ryanTowers.getFloors();
       ryanTowers.setOccupancy();
       ryanTowers.printData();
    }

    /**
    * method: getFloors()
    * arguments: none
    * purpose:
    * return: void
    */
    private void getFloors()
    {
        System.out.println("This Program calculates the occupancy percentage"
                + " of your Hotel or Establishment\n");
        System.out.println("How many floors is your Establishment?");
        do{
	    System.out.print("must be a positive number: ");
            while(!input.hasNextInt())
            {
		String in = input.next();
		System.out.print("This is not a valid number, try again: ");
	    }
            floors = input.nextInt();
        }while(floors < 1);
    }

    /**
    * method: setOccupancy()
    * arguments: none
    * purpose: method to cycle through asking user to input room data for each
    * floor of the establishment
    * return: void
    */
    private void setOccupancy()
    {
        int rooms_floor = 0;
        int occupied_floor = 0;

        while(floors > 0)
        {
            System.out.printf("\n\nHow many rooms are on floor %d%n", floors);
            do{
		System.out.print("There must be 10 or more per floor: ");
		while(!input.hasNextInt())
		{
                    String in = input.next();
                    System.out.print("This is not a valid number, try again: ");
		}
                rooms_floor = input.nextInt();
            }while(rooms_floor < 10);

            rooms_total += rooms_floor;

            System.out.printf("\nHow many rooms on floor %d "
                    + "are occupied?\n", floors);
            do {
                System.out.print("Must be more then 0 and less then the total "
                        + "number of rooms: ");
                while(!input.hasNextInt())
                {
                    String in = input.next();
                    System.out.print("This is not a valid number, try again: ");
                }
                occupied_floor = input.nextInt();
            }while(occupied_floor < 0 || occupied_floor > rooms_floor);

            occupied += occupied_floor;

            System.out.printf("\nFininshing data entry for floor %d%n", floors);
            floors--;
        }
    }

    /**
    * method: printData()
    * arguments: none
    * purpose: To print data on occupancy rate for Establishment
    * return: void
    */
    private void printData()
    {
		double rate = ((double) this.occupied / this.rooms_total)*100;
        System.out.printf("\nTotal Rooms:    %d%n"
                + "Total Occupied: %d%n"
                + "Vacant Rooms:   %d%n"
                + "Occupancy rate: %.1f%%%n%n "
             , rooms_total, occupied, rooms_total - occupied ,rate);
    }
}
