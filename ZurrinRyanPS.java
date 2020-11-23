/**
*@filename ZurrinRyanPS.java
*@author Ryan Zurrin
*@assignment Chapter 10 Program 10.16 "Accounts Payable System Modification"
*@due_date  Thursday, November 19, 2020, 3:00 PM
*@description  to modify the accounts payable application of fig 10.11 - 10.14
* to include the complete functionality of the payroll application of fig 10.4 -
* 10-9.
*/

public class ZurrinRyanPS {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        double raise = 0.1;
         // create four Payable objects

         Invoice s01234 = new Invoice("01234", "seat", 2, 375.00);
         Invoice t56789 = new Invoice("56789", "tire", 4, 79.95);
         SalariedEmployee lisaBarnes =
                 new SalariedEmployee("Lisa", "Barnes", "888-88-8888", 1200.00);
         HourlyEmployee gregPanzner =
                 new HourlyEmployee("Greg", "Panzner", "111-33-4444",
                         90.50, 55);
         CommissionEmployee ryanZurrin =
                 new CommissionEmployee("Ryan", "Zurrin", "888-55-5544",
                         400890.88, .188);
         BasePlusCommissionEmployee bobClint =
                 new BasePlusCommissionEmployee("Bob", "Clint", "123-96-9696",
                         250750.60, .034, 600.00);
         Payable[] payableObjects = new Payable[] {
             s01234, t56789, lisaBarnes, gregPanzner, ryanZurrin, bobClint
         };


      System.out.println(
         "Invoices and Employees processed polymorphically:");

      	// generically process each element in array payableObjects
      	for (Payable currentPayable : payableObjects) {
         // output currentPayable and its appropriate payment amount
         System.out.printf("%n%s %n",
            currentPayable.toString() // could invoke implicitly
            );}



        for(int i = 0; i < payableObjects.length; i++){
             if(payableObjects[i] instanceof BasePlusCommissionEmployee){
                 payableObjects[i].raise(raise);
             }
         }
        for (Payable currentPayable : payableObjects) {
         // output currentPayable and its appropriate payment amount
         System.out.printf("%n%s %npayment due: $%,.2f%n",
            currentPayable.toString(),
            currentPayable.getPaymentAmount());
        }//end enhanced for loop

    }// method main

  public static void raise(Payable obj) {

    if (obj instanceof BasePlusCommissionEmployee) {
        System.out.print("where I need to be now i need to access things\n");
    }

  }

}//end class ZurrinRyanPS

