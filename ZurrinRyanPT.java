/*
*PROGRAM NAME: ZurrinRyanPT.java
*@AUTHOR:      Ryan Zurrin
*ASSIGNMENT #: Chapter 4 Program
*DUE DATE:     Thursday, October 1, 2020, 3:00 PM
*DESCRIPTION:  'Pythagorean Triples', program to print out to the screen the 
*  triangle componants side1, side2, and hypotenuse. All must be integer whole
*  numbers and the condition of side1^2 + side2^2 = hypotenuse^2. example is a 
*  3 4 5 triangle. 3^2 + 4^2 = 5^2  is 9 + 16 = 25 = 5^2. Print out all 
*  componants such that the total of them all does not exceed a max value.
*/
//=============================================================================
public class ZurrinRyanPT {

    int side1 = 0;
    int side2 = 0;
    int hypotenuse = 0;
    
    public static void main(String args[]) {
        ZurrinRyanPT triangle = new ZurrinRyanPT();
        triangle.printPythagoreanTriples(100);
    }
    
    private void printPythagoreanTriples(int max)
    {
        double sum = 0;
        
        while(sum < max){
            for(;side1 < max; side1++) {
                for(;side2 < max; side2++) {
                    for(;hypotenuse < max; hypotenuse++) {
                        if((side1*side1)+(side2*side2)==
                           (hypotenuse * hypotenuse)){
                             System.out.printf("side1: %d%n"
                                     + "side2: %d%nhypotenuse: %d%n"
                                     ,side1, side2, hypotenuse);
                        }
                       
                    }
                }
            }
        }
        
    }
}
