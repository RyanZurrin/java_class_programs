/**
*@filename ZurrinRyanRN.java
*@author Ryan Zurrin
*@assignment Chapter 8 Program "Rational Numbers"
*@due_date Thursday, November 5, 2020, 3:00 PM
*@description  this is a class for performing arithmetic with fraction numbers.
*///===========================================================================
import static java.lang.Math.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;


public class ZurrinRyanRN {
//private instance variables for Rational number class _________________________
    /**
     * Integer variable used to store the numerator of a rational number
     */
    private int numerator;

    /**
     * Integer variable used to store the denominator of a rational number
     * @warning If a 0 is passed to the denominator a warning will prompt
     * telling user they entered a 0 and it changes from a 0 to a 1.
     */
    private int denominator;

    /**
     * Double variable for holding the decimal form of the Rational number
     */
    private double decimal;

    /**
     * String used to hold a representation of the original numerator
     */
    private String nu;

    /**
     * String used to hold a representation of the original denominator
     */
    private String de;

//constructors for ZurrinRyanRN class___________________________________________
    /**
     * no argument constructor sets defaults to 1 and 1 for a value of 1
     */
    ZurrinRyanRN(){
        numerator = 1;
        nu = Integer.toString(1);
        denominator = 1;
        de = Integer.toString(1);
        decimal = (double) numerator/denominator;
    }

    /**
     * overloaded constructor to set a rational number
     * @param n int value for the numerator
     * @param d int value for the denominator which will throw an error if 0
     */
    ZurrinRyanRN(final int n, final int d){
      if(d == 0)
      {
          System.out.println("Zero division error, setting denominator to 1");
          denominator = 1;
          numerator = n;
          de = Integer.toString(0) + "originally a divide by zero error";
      }
      else if(d < 0)
      {
          numerator = n * -1;
          denominator = d * -1;
      }
      else if(d < 0 && n < 0)
      {
          numerator = n * -1;
          denominator = d * -1;
      }
      else
      {
          numerator = n;
          denominator = d;
      }

      nu = Integer.toString(n);
      de = Integer.toString(d);
      decimal = (double)numerator/denominator;

      reduce();
    }

//public setter methods_________________________________________________________
    /**
     * sets the numerator instance variable
     * @param n int value represents value of numerator
     */
    public void set_numerator(final int n){
        this.numerator = n;
        System.out.println("con n:" + this.get_numerator());
        System.out.println("con d:" + this.get_denominator());
        this.reduce();
    }

    /**
     * sets the denominator instance variable
     * @param d int value represents value of denominator
     */
    public void set_denominator(int d){
        if(d == 0)
        {
         System.out.println("Zero division error, setting divisor to [1]");
          denominator = 1;
          de = Integer.toString(0) + "originally a divide by zero error";
        }
        if(d < 0)
        {
          denominator = d * -1;
        }
        else
        {
           denominator = d;
        }
        denominator = d;
        decimal = (double)numerator/denominator;
        reduce();
    }

    /**
     * sets the rational number's numerator and denominator
     */
    public void set_rational(final int n, int d){
      if(d == 0)
      {
          System.out.println("Zero division error, setting divisor to [1]");
          this.denominator = 1;
      }
      if(d < 0)
      {
          numerator = n * -1;
          denominator = d * -1;
      }
      else if(d < 0 && n < 0)
      {
          numerator = n * -1;
          denominator = d * -1;
      }
      else
      {
          numerator = n;
          denominator = d;
      }

       decimal = (double)numerator/denominator;
       reduce();
    }

//public getter methods_________________________________________________________
    /**
     * returns the value stored in the numerator variable
     */
    public int get_numerator(){
        return numerator;
    }

    /**
     * returns the value stored in the denominator variable
     */
    public int get_denominator(){
        return denominator;
    }

    /**
     * returns the value of the fraction as a decimal
     */
    public double get_decimal(){
        return decimal;
    }

    /**
    * returns a char sign bit of '+' or '-'.
    * @return sign ( -  or  + )
    */
    public char get_sign(){
        if((this.numerator < 0 && this.denominator < 0)||
            (this.numerator > 0 && this.denominator > 0))
        {
            return '+';
        }
        else
        {
            return '-';
        }
    }

//display methods for printing class data to screen_____________________________
    /**
     * prints out the rational number in decimal form
     * @param pp is the point precision modifier which allows you to set where
     * the rounding begins using the HALF_UP RoundingMode
     * @see #RoundingMode.HALF_UP
     * this is the rounding format used in this method that is a .5 and up
     * gets rounded up at the specified point precision  value
     */
    public void print_decimal(final int pp) {
      BigDecimal value = new BigDecimal(decimal);

      System.out.println("decimal: "  +
              value.setScale(pp, RoundingMode.HALF_UP) +
              " with " + pp +
              " points of precision");
    }
    /**
     * Similar to the print_decimal method above but with no argument for the
     * points of precision. Instead it is defaulted at 2 points if you use this
     * way
     */
    public void print_decimal(){
      BigDecimal value = new BigDecimal(decimal);

      System.out.println("decimal: "  +
              value.setScale(2, RoundingMode.HALF_UP) +
              " with " + 2 +
              " points of precision");
    }

    /**
    * prints out the rational number in fraction form
    */
    public void print_reduced_fraction(){
         if (this.denominator == 1)
        {
            System.out.printf("reduced whole number: %d%n",this.numerator);
        }
        else
        {
            System.out.printf("reduced fraction: %d/%d%n",
                    numerator, denominator);
        }

    }

    /**
     * prints out the signBit
     */
    public void print_sign_bit(){
        System.out.printf("sign: %c%n", this.get_sign());
    }

    /**
     * prints the least common multiple of the Rational expression
     */
    public void print_lcm(){
        System.out.println("lcm: " + lcm());
    }

    /**
     * prints out the original Rational number argument as a string
     */
    public void print_original_values_as_string(){
        System.out.printf("original arguments: %s/%s%n", nu,de);
    }

    /**
     * prints out a all data pertaining to the rational number
     */
    public void print_all(){
        System.out.println("\ndata:");
        print_sign_bit();
        print_original_values_as_string();
        print_reduced_fraction();
        print_lcm();
        print_decimal();
    }

     /**
     * prints out a all data pertaining to the rational number
     */
    public void print_all(final int pp){
        print_all();
        print_decimal(pp);
    }

//public instance methods for doing math on rational numbers____________________
   /**
   * calculates a new Rational object that is the reciprocal of the rational
   * number, which is to say it has been flipped
   */
   public Rational reciprocal(){
      return new Rational(denominator, numerator);
   }

   /**
   * calculates a new Rational object that is the sum of itself added with
   * another rational number
   * @param r Rational number object
   * @return new Rational number that is the sum of this and argument
   */
   public Rational add(Rational r){
     return new Rational((numerator * r.get_denominator())+
             (r.get_numerator() * denominator),
             denominator * r.get_denominator());
   }

   /**
   * calculates a new Rational object that is the difference of itself
   * subtracted with from another rational number
   * @param r Rational number object
   * @return new Rational number  that is the difference of this and argument
   */
   public Rational subtract(Rational r){
      return new Rational ((numerator * r.get_denominator())-
              (r.get_numerator() * denominator),
              denominator * r.get_denominator());
   }

   /**
   * calculates a new Rational object that is the product of itself
   * multiplied with another rational number
   * @param r Rational number object
   * @return new Rational number that is the product of this and it's argument
   */
   public Rational multiply(Rational r){
     return new Rational (numerator * r.get_numerator(),
              denominator * r.get_denominator());
   }

   /**
   * calculates a new Rational object that is the division of itself
   * divided with another rational number
   * @param r Rational number object
   * @return new Rational number that is the division of this and it's argument
   */
   public Rational divide(Rational r){
      return multiply(r.reciprocal());
   }

//Static methods for doing math with rational___________________________________
   /**
   * Static method  to calculate the sum of two Rational numbers
   * @param l Rational number object left side
   * @param r Rational number object right side
   * @returns new Rational number that is the sum of the two passed arguments
   */
   public static Rational add(Rational l, Rational r){
     return new Rational((l.get_numerator() * r.get_denominator())+
             (r.get_numerator() * l.get_denominator()),
             l.get_denominator() * r.get_denominator());
   }

   /**
   * Static method that calculates a new Rational number that is the difference
   * of left - right
   * @param l Rational number object left side
   * @param r Rational number object right side
   * @return new Rational number  that is the difference of this and argument
   */
   public static Rational subtract(Rational l, Rational r){
      return new Rational ((l.get_numerator() * r.get_denominator())-
              (r.get_numerator() * l.get_denominator()),
              l.get_denominator() * r.get_denominator());
   }

   /**
   * Static method a new Rational number that is the product of l and r
   * @param l Rational number object left side
   * @param r Rational number object right side
   * @return new Rational number that is the product of this and it's argument
   */
   public static Rational multiply(Rational l, Rational r){
     return new Rational(l.get_numerator() * r.get_numerator(),
              l.get_denominator() * r.get_denominator());
   }

   /**
   * calculates a new Rational object that is the division of itself
   * divided with another rational number
   * @param r Rational number object
   * @return new Rational number that is the division of this and it's argument
   */
   public static Rational divide(Rational l, Rational r){
      return multiply(l.reciprocal(), r.reciprocal());
   }

//Predecesor Methods____________________________________________________________
   /**
    * tests if two Rational numbers are equal
    * @param r Rational number object
    * @returns true if equal, false if not
    */
   public boolean is_equal(Rational r){
      return numerator == r.get_numerator() &&
             denominator == r.get_denominator()?
             true : false;
   }

//Conversion methods____________________________________________________________
   /**
    * class method to convert fraction to string
    */
   public String toString_fromFraction(){
      String rationalString;
      System.out.println();

      if (numerator == 0)
      {
          rationalString = "0\n";
      }
      else{
           if (denominator == 1)
           {
              rationalString =  Integer.toString(numerator) + "";
           }
           else{
               rationalString = Integer.toString(numerator)  + "/" +
                       Integer.toString(denominator)  + "";
           }
      }
      return rationalString;
   }

   /**
    * class method to convert decimal to string
    * @param pointsToRight is the precision to the right of the decimal point
    * one wishes to achieve
    * @return value of rational number as a decimal string
    */
   public String toString_fromDecimal(final int pointsToRight){
      BigDecimal value = new BigDecimal(decimal);
      System.out.println();

      String rationalString = value.setScale(pointsToRight,
              RoundingMode.HALF_UP).toString();

      return rationalString;
   }

   /**
    * copy the values of a ZurrinRyanRN object to this number object
    * @param toRational is the ZurrinRyanRN class object that is being copied
    */
   public void copy(ZurrinRyanRN toRational){
       this.numerator = toRational.get_numerator();
       this.denominator = toRational.get_denominator();
       this.decimal = toRational.get_decimal();
       this.reduce();
   }

   /**
   * copy's the values of a Rational number object to this object
   * @param toZurrinRyanRN is the ZurrinRyanRN class object that is being copied
   */
   public void copy(Rational toZurrinRyanRN){

       this.numerator = toZurrinRyanRN.get_numerator();
       this.denominator = toZurrinRyanRN.get_denominator();
       this.decimal = toZurrinRyanRN.get_decimal();
       this.reduce();
   }

   /**
   * copies the values of a ZurrinRyanRN object to a Rational number object and
   * return a new  Rational number with the values of the ZurrinRyanRN object
   * @param toRational is the ZurrinRyanRN class object that is being copied
   */
   public Rational convert(ZurrinRyanRN toRational){
       int num, denom;
       num = toRational.get_numerator();
       denom = toRational.get_denominator();
       Rational result = new Rational(num, denom);
      return result;
   }

   /**
   * copies the values of a Rational object to a ZurrinRyanRN number object and
   * it returns the new ZurrinRyanRN object with the values from
   * @param toZurrinRyanRN is the Rational class object that is being copied
   */
   public ZurrinRyanRN convert(Rational toZurrinRyanRN){
       int num, denom;
       num = toZurrinRyanRN.get_numerator();
       denom = toZurrinRyanRN.get_denominator();
       ZurrinRyanRN result = new ZurrinRyanRN(num, denom);
      return result;
   }

// Private methods______________________________________________________________
    /**
     * method used to reduce the fraction to its lowest possible form
     */
    private void reduce(){
        if(numerator != 0){
           int commonFactor = gcd(abs(numerator), denominator);

           numerator /= commonFactor;
           denominator /= commonFactor;
        }
    }

    /**
     * sets the  value of the least common multiple
     */
    private int lcm(){
       if(numerator != 0)
       {
          int commonDenominator = gcd(abs(numerator), denominator);
          return (abs(this.get_numerator()) * this.get_denominator())
               /commonDenominator;
       }
       else
       {
           return 0;
       }
    }

    /**
    * Returns the value of the greatest common denominator using
    */
    private int gcd(int n, int d){
        int gcd = 0;

        for(int i = 1; i <= n && i <= d; i++)
        {
            if(n % i == 0 && d % i == 0)
            {
                gcd = i;
            }
        }
        return gcd;
    }
    /**
     * method for doing calculations
     */
    public static Rational calculate(Rational l, char op, Rational r){
        Rational result = new Rational();
        switch(op)
        {
            case '+':
                result = Rational.add(l, r);
                break;
            case '-':
                result = Rational.subtract(l, r);
                break;
            case '*':
                result = Rational.multiply(l, r);
                break;
            case '/':
                result = Rational.divide(l, r);
                break;
            default:
                System.out.println("you performed an unsupported opperation");         
        }        
        return result;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        char choice = 'y';
        char opperation = ' ';
        int ln, ld, rn, rd;
        do{
            System.out.println("enter the first rational number by putting\n"+
                    "in the numerator then a space followed by the denominator"+
                    "\nthen ");

	}while(choice == 'y' && choice == 'Y');


    }
}// end class ZurrinRyanRN



class  Rational extends ZurrinRyanRN {
    Rational(){
       super();
    }
    Rational(final int n, final int d){
        super(n,  d);
    }

    }//end class Rational