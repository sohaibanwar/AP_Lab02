/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablereservation;

/**
 *
 * @author Sohaib
 */
import javafx.scene.control.Tab;
import java.lang.System.*;
import java.util.*;                            
import static java.lang.System.out;

public class Restaurant 
{
    public ArrayList<Table> six = new ArrayList<Table>();
    public  ArrayList<Table> four = new ArrayList<Table>();
    public ArrayList<Table> two = new ArrayList<Table>();               // array of 4 types of tables with 									//different numbers
    public ArrayList<Table> twelve = new ArrayList<Table>();

    Waiter waiters[]= new Waiter[6];   
    NavigableMap<Integer, ArrayList<Table>> tables = new TreeMap<Integer, ArrayList<Table>>();  //map to check 												//which table is 										//best for number of people

Restaurant()
{      		 //default constructor
    for(int i=0;i<3;i++)
        six.add(new Table(6, "Six_"+i ));
    for(int i =0;i<8;i++)
        four.add(new Table (4, "Four "+i));
    for(int i=0;i<4;i++){
        two.add(new Table(2, "Two"+i));
        twelve.add(new Table(12, "Twelve"+i));}
    for(int i =0;i<waiters.length;i++)
        waiters[i]=new Waiter();
    tables.put(12,twelve);
    tables.put(6,six);
    tables.put(4,four);
    tables.put(2,two);
    set_waiters();          //initializing waiter's names
}


public boolean reserve(int number , String name ,float time,float end_time){  //returns true on success else false
        Table T=null;
        boolean reserved=false;
        if(time <=11 || time > 20)
        {   System.out.print("Restaurant is Opens from 11 to 22\n");           //check if time entered is in limit of restaurant opened
            return false; }
        ArrayList<Table> found=null;                                    //initiaizing a list of tables to reserve the required number
         if(number>12)                                    //If there are more people than capacity of largest table then divide them in small tables
         {found=four; end_time+=time; }
         else {found= tables.get(tables.ceilingKey(number));    //find the smallest table that has capacity to fill all people
               if(number!=12)end_time= time+2;                  //allocate for 2 hours
               else end_time+=time;                                //For Parties allocate as long as the user wants
                }
            while(number>0) {                                      //To make sitting available for all people
                for (int i = 0; i < found.size(); i++) {
                    T = found.get(i);                               // Get the table that fits best
                    String server_name= get_waiter(T.capacity);
                    List<Float> timings = T.res_time;                 //reservation time
                    if (timings.size() == 0) {                          //if initially all lists are empty then make reservation
                        reserved = false;
                        T.reserve_table(name, time,end_time,server_name);
                        number-=T.capacity;                                // Decrease number by people left un seated
                        break;  }
                    for (int j = 0; j < timings.size(); j++) {
                        if (time >= timings.get(j) && time <= timings.get(j) + 1) {
                            reserved = true;                                                //find if reserve timings already reserved? for all availble tables
                            continue;
                        } else {
                            reserved = false;
                            T.reserve_table(name, time,end_time,server_name);           // If yes then allocate
                            number-=T.capacity;
                            break; }
                    } if (!reserved) break;                       //break if reservation is done                }
                if(number==12 && reserved)found=four;           //allocate next party of 12 to smaller tables
                else if(reserved){
                    System.out.println("Sorry all tables with your requirments are reserved.");            // if all slots are reserved then print a sorry msg
                    break;
                } } }
    return true;    
}
private void set_waiters(){
    waiters[0].name="Ghanan";
    waiters[1].name="Hanan";
    waiters[2].name="Salman";
    waiters[3].name="Afnan";
    waiters[4].name="Usman";
    waiters[5].name="Farhan";
}
private String get_waiter(int num){
    String name = null;
    for (Waiter w : waiters){
        if(w.capacity>=num){
            w.capacity-=num;
            name=w.name;
            break;
        }}
    return name;
}}