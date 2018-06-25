/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.Services;

import assignment2.Classes.Customer;
import java.util.Collections;

/**
 *
 * @author J378925
 */
public class CustomerManager {
    
    private Customer[] CustomerList;
    
    public CustomerManager(){
        
        generateCustomerList();
        
    }
    
    public Customer[] getCustomerList(){
        return CustomerList;
    }
    
    public Customer getCustomerByID(int id){
        Customer c = null;
        for (int i = 0; i < CustomerList.length; i++) {
            if(CustomerList[i].getID() == id){
                c = CustomerList[i];
            }
        }
        return c;
    }
    
    public void addCustomer(Customer _customer){
        
        Customer[] templist;
        templist = new Customer[CustomerList.length + 1];
        templist[CustomerList.length] = _customer;
    }
   
    
    /**
     * Customer Generation as an assumption is made that customers exist in a database and have an account that their information would be retrieved from.
     */
    private void generateCustomerList(){
        
        CustomerList = new Customer[20];
        
        CustomerList[0] = new Customer(0,"Jane","Doe",88765873,'A');
        CustomerList[1] = new Customer(1,"John","Doe",88765873,'A');
        CustomerList[2] = new Customer(2,"Peter","Piper",88765873,'A');
        CustomerList[3] = new Customer(3,"Mila","Jovich",88765873,'A');
        CustomerList[4] = new Customer(4,"Oliver","Allan",88765873,'A');
        CustomerList[5] = new Customer(5,"Piere","Allan",88765873,'A');
        CustomerList[6] = new Customer(6,"Lana","Allan",88765873,'C');
        CustomerList[7] = new Customer(7,"Julie","McTaggart",88765873,'A');
        CustomerList[8] = new Customer(8,"Robert","McTaggart",88765873,'C');
        CustomerList[9] = new Customer(9,"Arthur","Cavendish",88765873,'A');
        CustomerList[10] = new Customer(10,"Kealan","Flanigan",88765873,'A');
        CustomerList[11] = new Customer(11,"Kelly","McCrystal",88765873,'C');
        CustomerList[12] = new Customer(12,"Trevor","Thompson",88765873,'A');
        CustomerList[13] = new Customer(13,"Troina","O'Neill",88765873,'C');
        CustomerList[14] = new Customer(14,"Kevin","McCallister",88765873,'C');
        CustomerList[15] = new Customer(15,"Peter","Kelly",88765873,'A');
        CustomerList[16] = new Customer(16,"Blake","Johnson",88765873,'A');
        CustomerList[17] = new Customer(17,"William","Rivera",88765873,'A');
        CustomerList[18] = new Customer(18,"Steven","Johnson",88765873,'A');
        CustomerList[19] = new Customer(19,"Stephen","Allison",88765873,'A');
        
        System.out.println("Initalising Customer Data...");
        for(Customer customer : CustomerList){
            System.out.println(customer.toString());
        }
    }
    
}
