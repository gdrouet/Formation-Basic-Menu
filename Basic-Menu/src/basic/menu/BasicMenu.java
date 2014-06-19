/*
 * Formation: basic menu sample.
 */

package basic.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p>
 * Main class that launches the basic menu.
 * </p>
 *
 * @author Guillaume DROUET
 */
public class BasicMenu {

    /**
     * Reader for standard input.
     */
    private static final BufferedReader INPUT = new BufferedReader(new InputStreamReader(System.in));
    
    /**
     * <p>
     * Main method.
     * </p>
     * 
     * @param args the command line arguments
     * @throws IOException if any I/O error occurs
     */
    public static void main(String[] args) throws IOException {
        
        // Loop while the user doesn't leave (choice 4)
        choiceLoop:
        for (;;) {
            // Display menu
            System.out.println("1. Plus");
            System.out.println("2. Multiply");
            System.out.println("3. Factorial");
            System.out.println("4. Exit");
            System.out.println("Choice:");
            
            // Read choice
            final String choice = INPUT.readLine();
            
            // Will contain the result of any computation selected by user
            Integer res = null;
            
            // Evaluate the choice
            switch (choice) {
                case "1":
                    res = plus();
                    break;
                case "2":
                    res = multiply();
                    break;
                case "3":
                    res = factorial();
                    break;
                case "4":
                    System.out.println("Bye.");
                    
                    // We break the for loop the program will stop
                    break choiceLoop;
                default:
                    System.out.println("Bad choice");
            }
            
            // Something to print
            if (res != null) {
                printEnterContinue("Result: " + res, true);
            }
        }
    }
    
    /**
     * <p>
     * Helper that prints the given message and optionally prints "Please press enter to continue"
     * message. Always wait the user enters something.
     * </p>
     * 
     * @param msg the message to always prints
     * @param enter optionnally prints "please enter..."
     * @return the value entered by user
     * @throws IOException if I/O error occurs 
     */
    public static String printEnterContinue(final String msg, final boolean enter) throws IOException {
        System.out.println(msg);
        
        if (enter) {
            System.out.println("Please press enter to continue");
        }
        
        return INPUT.readLine();
    }
    
    /**
     * <p>
     * Reads the values entered by the user. The values are parsed into integers
     * and bad values won't be managed (exception will occur).
     * </p>
     * 
     * <p>
     * A minimum and/or maximum number of values to be entered could specified 
     * in parameter. If a rule is broken, the method will return a {@code null} array.
     * </p>
     * 
     * <p>
     * Otherwise, an array of 4000 elements will be return. User has to check
     * when the value becomes {@code null} which means this is the end of what
     * the user entered.
     * <p>
     * 
     * @param minVal the minimal value (-1 if no min)
     * @param maxVal the maximal value (-1 if no max)
     * @return the array of entered values
     * @throws IOException if I/O error occurs 
     */
    public static Integer[] readValues(final int minVal, final int maxVal)  throws IOException {
        int nbValues = 0;
        Integer[] values = new Integer[4000];

        String val;

        // Apply max if necessary and reads until the user enters an empty string
        while ((maxVal == -1 || nbValues < maxVal)
                && !"".equals(val = printEnterContinue("Please enter an integer and then press enter (empty to finish)", false))) {
            values[nbValues++] = Integer.parseInt(val);
        }
        
        String error = "";
        
        // Min rule broken
        if (minVal > -1 && nbValues < minVal) {
            error += "You must enter at least "
                    + minVal
                    + " values.\n";
        }
        
        // At least one rule is broken
        if (!error.isEmpty()) {
            printEnterContinue(error, true);
            return null;
        }
        
        return values;
    }
    
    /**
     * <p>
     * Computes plus.
     * </p>
     * 
     * @return the result, {@code null} if user did'nt enter correct valyues
     * @throws IOException if I/O error occurs
     */
    public static Integer plus() throws IOException {
        final Integer[] values = readValues(2, -1);
        
        // Rule broken
        if (values == null) {
            return null;
        }
        
        int res = 0;
        
        for (Integer v : values) {
            
            // Read the end of what the user entered
            if (v == null) {
                break;
            }
            
            res += v;
        }
        
        return res;
    }
    
    /**
     * <p>
     * Computes multiplication.
     * </p>
     * 
     * @return the result, {@code null} if user did'nt enter correct valyues
     * @throws IOException if I/O error occurs
     */
    public static Integer multiply() throws IOException {
        final Integer[] values = readValues(2, -1);

        // Rule broken
        if (values == null) {
            return null;
        }
        
        int res = 1;
        
        for (Integer v : values) {
            // Read the end of what the user entered
            if (v == null) {
                break;
            }
            
            res *= v;
        }
        
        return res;
    }
    
    /**
     * <p>
     * Computes factorial.
     * </p>
     * 
     * @return the result, {@code null} if user did'nt enter correct values
     * @throws IOException if I/O error occurs
     */
    public static Integer factorial() throws IOException {
        final Integer[] values = readValues(1, 1);
        
        // Rule broken
        if (values == null) {
            return null;
        }
        
        int res = values[0];
        
        for (int v = res - 1; v > 1; v--) {
            res *= v;
        }
        
        return res;
    }
}
