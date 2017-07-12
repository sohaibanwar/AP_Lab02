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
import java.util.*;
import static java.lang.System.out;
public class Table {
    public String res_name;
    public int capacity;
    public String table_name;
    public List<Float> res_time = new ArrayList<Float>();    
    Table(int capacity, String x){
        this.capacity = capacity;       //default constructor
        this.table_name= x;
    }
    public void reserve_table(String person, float start, float end,String name){
        this.res_time.add(start);       //adding time to list
        this.res_name= person;          //name of person who reserved it
        if(name==null)name="ahmed";
        System.out.println("Table:" + this.table_name+ "has been reserved for "+ person+ "from : "+start+"to "+end);
    }    
}