//Sureshkumar Packiyarajah //

package Driver;


import DAO.TransactionDAO;
import Exception.MismatchException;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransactionDriver {
    private static Scanner scanner = new Scanner(System.in);
    private static TransactionDAO transactionDAO = new TransactionDAO();
    static void getTransbyZipcode() throws MismatchException {
        System.out.println("ENTER ZIP");
        int zip = scanner.nextInt();
        System.out.println("ENTER MONTH");
        int month = scanner.nextInt();
        System.out.println("ENTER YEAR");
        int year = scanner.nextInt();
        if(!isValidZip(zip)||!isValidMonth(month)||!isValidYear(year))
            throw new MismatchException("INVALID INPUT");
        transactionDAO.getTransbyZipcode(zip,month,year);
    }


    static void getNumAndTotalByType(){
        System.out.println("ENTER TYPE");
        String type = scanner.next();
        transactionDAO.getNumAndTotalByType(type);
    }
    static void getNumAndTotalByState() throws MismatchException {
        System.out.println("ENTER STATE");
        String state = scanner.next();
        if(!isValidState(state))
            throw new MismatchException("INVALID");
        transactionDAO.getNumAndTotalByState(state);
    }
    private static boolean isValidState(String state){
        Pattern p = Pattern.compile("[A-Z]{2}");
        Matcher m = p.matcher(state);
        return m.matches();

    }
    private static boolean isValidMonth(int month){
        return month<0 || month>12;
    }
    private static boolean isValidZip(int zip){
        Pattern p = Pattern.compile("[0-9]{5}");
        Matcher m = p.matcher(String.valueOf(zip));
        return m.matches();
    }
    private static boolean isValidYear(int year) {
        Pattern p = Pattern.compile("[0-9]{4}");
        Matcher m = p.matcher(String.valueOf(year));
        return m.matches();
    }
}
