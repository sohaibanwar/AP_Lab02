import org.junit.Test;


import static org.junit.Assert.*;


/**
 * @Author: Sohaib Anwar.
 */


public class RestaurantTest {
    
@Test
    public void reserve() 
throws Exception {                    //testing that reserves or not
        
Restaurant R= new Restaurant();
assertTrue(R.reserve(12,"abdul khan",14,5));

    
}
    

@Test
    public void reserveAfter_time() 
throws Exception {          //trying to reserve after restaurant has closed
        
Restaurant R= new Restaurant();

        
assertFalse(R.reserve(12,"mm alam",23,5));


    }

    

@Test
    public void reservebefore_time() 
throws Exception {         //trying to reserve before opening time
        
Restaurant R= new Restaurant();

        assertFalse(R.reserve(12,"mm alamgir",9,5));

    }

}