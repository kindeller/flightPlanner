/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.util.Collections;
import assignment2.Services.CustomerManager;
import assignment2.Services.SeatManager;
import assignment2.GUI.Main;
/**
 *
 * @author J378925
 */
public class Assignment2 {

    /**
     * @param args the command line arguments
     */
    
    static private CustomerManager CM;
    static private SeatManager SM;
    
    public static void main(String[] args) {
        // TODO code application logic here
       
        CM = new CustomerManager();
        SM = new SeatManager();
        Main m = new Main();
        m.Initialise(CM,SM);
        m.setVisible(true);
    }
    
    
        /**
     * 
     * @param array "Dictates the array to be searched
     * @param value "The value being searched for"
     * @param low "The lower index searching from" 
     * @param high "the higher index to search from (array.length)."
     * @param isAsc "is the array sorted ascending?"
     * @return "returns an int: the indexd of the position of in the array it was found"
     */
    static int binarySearch(int[] array, int value, int low, int high, boolean isAsc){
        //get middle
        int middle = (low + high) / 2;
        
        // ***** Ascending Binary Search ******
        if(isAsc){
            print("High: "+high+"Low: "+low+" Middle: "+middle);
            //break if not found
            if (high < low) {
              return -1;
            }

            //return if found in middle
            if (value == array[middle]) {
              print("found!");
              return middle;
            //else if lower use lower half
            }else if (value < array[middle]) {
              return binarySearch(array,value,low,middle-1, true);
            //if higher use higher half
            }else{
              return binarySearch(array,value,middle+1,high, true);
            }
        // ***** Decending Binary Search ******
        }else  {
            print("High: "+high+"Low: "+low+" Middle: "+middle);
            //break if not found
            if (high < low) {
                return -1;
            }

            //return if found in middle
            if (value == array[middle]) {
                print("found!");
                return middle;
            //else if lower use lower half
            }else if (value > array[middle]) {
                return binarySearch(array,value,low,middle-1, false);
            //if higher use higher half
            }else{
                return binarySearch(array,value,middle+1,high, false);
            } 
        } 
    }
    
    static void print(){
        System.out.println();
    }
    
    static void print(String s){
        System.out.println(s);   
    }
    
    static void print(String s, boolean isSameLine){
        if(isSameLine){
            System.out.print(s); 
        }else{
         System.out.println(s);   
        }  
    }
    
}
