//Sureshkumar Packiyarajah //

package Driver;


import Exception.MismatchException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) throws MismatchException {
        String greeting ="-------------\n"+" 1: Print Customer Details "+"\n"+
                " 2: Modify Customer Details "+"\n" +
                " 3: Generate Customer Bill "+"\n"+
                " 4: Display Transaction between Dates "+"\n"+
                " 5: Print Transactions by ZipCode "+"\n"+
                " 6: Print Number and Total Transactions by Type "+"\n"+
                " 7: Print Number and Total Transactions by State "+"\n"+
                " 8: EXIT"+"\n"+
                "-------------\n";

        System.out.println("***************Starting Credit Card System Application***************");
       

        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        try{
        while(!exit){
            System.out.println(greeting);
            System.out.println("Please Enter Number for Option:");
            int input =scan.nextInt();
            if(input<1|| input>8)throw new InputMismatchException("NOT VALID INPUT");
            switch (input) {
                case 1:
                    CustomerDriver.getCustDetails();
                    break;
                case 2:
                    CustomerDriver.modifyCustDetails();
                    break;
                case 3:
                    CustomerDriver.generateBill();
                    break;
                case 4:
                    CustomerDriver.displayTransBetweenDates();
                    break;
                case 5:
                    TransactionDriver.getTransbyZipcode();
                    break;
                case 6:
                    TransactionDriver.getNumAndTotalByType();
                    break;
                case 7:
                    TransactionDriver.getNumAndTotalByState();
                    break;
                case 8:
                    System.out.println("EXITING PROGRAM");
                    exit=true;
                    break;

            }
        }
        }catch(InputMismatchException e){
                e.printStackTrace();
            }
      
        System.out.println("***************Ending Credit Card System Application***************");
    }
}
