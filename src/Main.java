
package tablereservation;

/**
 *
 * @author Sohaib
 */

import java.util.*;
import static java.lang.System.*; // Main method is used to test the reservation system
public class TableReservation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Restaurant R = new Restaurant();


        R.reserve(12, "Iftikhar", 11, 4);

        R.reserve(7,"Moooalal",9,12);             //Testing different cases

        R.reserve(2, "Alezah", 15, 4);

        R.reserve(5, "Emma", 14, 0);
    }
    
}