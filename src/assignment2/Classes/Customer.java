/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.Classes;

/**
 *
 * @author J378925
 */
public class Customer {
    
    private int ID = 0;
    private String FirstName = "";
    private String LastName = "";
    private long ContactNumber = 0;
    private char Type = 'A';

    public int getID() {
        return ID;
    }

    public char getType() {
        return Type;
    }

    public void setType(char Type) {
        this.Type = Type;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public long getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(long ContactNumber) {
        this.ContactNumber = ContactNumber;
    }
    
    public Customer(){
        
    }
    
    public Customer(int _id, String _firstName, String _lastName, long _contactNumber, char _type){
        ID = _id;
        FirstName = _firstName;
        LastName = _lastName;
        ContactNumber = _contactNumber;
        Type = _type;
        
    }
    
    @Override
    public String toString(){
        return "ID: " + this.ID + " Name: " + FirstName + " " + LastName;
    }
    
    
    
}
