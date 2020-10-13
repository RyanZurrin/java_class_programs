/**
*PROGRAM NAME: ZurrinRyanPT.java
*@AUTHOR:      Ryan Zurrin
*ASSIGNMENT #: Chapter 4 Program
*DUE DATE:     Thursday, October 1, 2020, 3:00 PM
*DESCRIPTION:  'Pythagorean Triples', program to print out to the screen the
*  triangle componants sideA, sideB, and the hypotenuse. All must be integer
*  whole numbers and pass the condition of side1^2 + side2^2 = hypotenuse^2.
*  Example: a:3 b:4 c:5 triangle. 3^2 + 4^2 = 5^2  is 9 + 16 = 25 = 5^2.
*  Print out all componants such that the total of any one of them does not
*  exceed 500 by default
*///===========================================================================
import java.util.Vector;

public class ZurrinRyanPT
{
	// setting the maximum value for the triangle components defaulted to 500
	static int maxSearch = 500;

	// counter of unique non repeat Pythagorean Triples found
    static int uniqueCount = 0;

    // counter of total number of Pythagorean Triples found
    static int totalCount = 0;

    // main java method
    public static void main(final String args[])
    {
        final Vector<Integer> bin = new Vector<Integer>();

        printTriples(bin, maxSearch);
        printCounts();

    }

    /**
     * method: printPythagoreanTriples(int max)
     * arguments: Vector for storing found values, max value for search size
     * purpose: print values of side1, side2 and the hypotenuse that make up a
     *  Pythagorean triple.
     */
    public static void printTriples(final Vector<Integer> v, final int max)
    {
        System.out.printf("\nThis method prints the triangle components that\n"
                + "form proper Pythagorean triples a^2 + b^2 = c^2 \nWith no"
                + " more then a max of %d for each component\n", max);
        System.out.println("\n side a        side b        hypotenuse\n" +
                                "-----------------------------------------");

        for (int a = 1; a <= max; a++)
        {

            for (int b = 1; b <= max; b++)
            {

                for (int c = 1; c <= max; c++)
                {

                    if ((a * a) + (b * b) == (c * c))
                    {

                        if (isRepeat(v,a+b) == false)
                        {
                            v.add(a+b);
                            uniqueCount++;
                            System.out.printf("a: %-10d b: %-10d c: %d%n"
                            									, a, b, c);
                        }
                        totalCount++;
                    }
                }
            }
        }
        System.out.println("\nEnd of Search...\n");
    }

    /**
     * method: checkForRepeats(Vector<Integer> v, int n)
     * arguments: Vector of integers, int n as test value
     * purpose: stores hypotenuse values in vector to use as check
     * return: true if there is a repeat and false if there is no repeat
     */
    public static boolean isRepeat(final Vector<Integer> v, final int n)
    {
        for (int i = 0; i < v.size(); i++)
        {
            if (n == v.get(i))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * method: printCounts()
     * purpose: print unique and total count to screen
     */
    public static void printCounts()
    {
        System.out.printf("\nUnique triples found: %d%n%n", uniqueCount);
        System.out.printf("\nTotal found in all:   %d%n%n", totalCount);
    }

    /**
     * method: setMaxComponantSize(int val)
     * arguments: integer val
     * purpose: sets the max componanat size used in search
     */
    public static void setMaxSearchSize(final int val)
	{
		maxSearch = val;
    }
}