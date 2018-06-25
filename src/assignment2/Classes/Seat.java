/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment2.Classes;
import assignment2.Services.SeatManager;
import java.util.*;

/**
 *
 * @author J378925
 */
public class Seat {
    
   private int ID = 0;
   private String Location = "";
   private String SeatClass = "";
   private Customer CustomerObject = null;

    public int getID() {
        return ID;
    }
   

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSeatClass() {
        return SeatClass;
    }

    public void setSeatClass(String SeatClass) {
        this.SeatClass = SeatClass;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public Customer getCustomerObject() {
        return CustomerObject;
    }

    public void setCustomerObject(Customer customerObject) {
        this.CustomerObject = customerObject;
    }
   

    public Seat() {
        
    }
    
    public Seat(int _id, String _location){
        ID = _id;
        Location = _location;
    }
    
    public Seat(int _id, String _location, Customer _customer, String _seatClass){
        ID = _id;
        Location = _location;
        CustomerObject = _customer;
        SeatClass = _seatClass;
    }

    @Override
    public String toString() {
        return "Seat : " + this.Location; //To change body of generated methods, choose Tools | Templates.
    }
    
    
   public int getfilePos(){
       int pos = 0;
       String s = "";
       if (this.getLocation().getBytes().length > 2) {
           s = "" + this.getLocation().charAt(0) + this.getLocation().charAt(1);
           pos = (Integer.parseInt(s)-1)*9;
           pos += SeatManager.getAlphaConvert(this.getLocation().charAt(2));
           System.out.println(pos);
           
       }else{
           s = "" + this.getLocation().charAt(0);
           pos = (Integer.parseInt(s)-1)*9;
           pos += SeatManager.getAlphaConvert(this.getLocation().charAt(1));
           System.out.println(pos);
       }
       
       return pos;
   }
   
   
   
   
}
