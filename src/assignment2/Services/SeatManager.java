/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.Services;

import assignment2.Classes.Customer;
import assignment2.Classes.Seat;
import java.util.Collections;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author J378925
 */
public class SeatManager {
    
    private static char[] alphaConvert = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    private Seat[][] Seats;
    private int rows = 0;
    private int cols = 0;
    private long offset = 0;

    public Seat[][] getSeats() {
        return Seats;
    }
    
    public Seat getSeat(int ID){
        for (int i = 0; i < Seats.length; i++) {
            for (int j = 0; j < Seats[i].length; j++) {
                if (Seats[i][j].getID() == ID) {
                    return Seats[i][j];
                }
            }
 
        }
        return null;
    }
    
        public Seat getSeat(String loc){
        for (int i = 0; i < Seats.length; i++) {
            for (int j = 0; j < Seats[i].length; j++) {
                if (Seats[i][j].getLocation() == loc) {
                    return Seats[i][j];
                }
            }
 
        }
        return null;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
    
    public SeatManager(){
        
        initialiseSeats(12,6);
        updateManifest();
        //initialiseRA();
        
    }
    
    private void initialiseRA(){
        try{
            RandomAccessFile file = new RandomAccessFile("flightManifest.txt","rw");
            file.seek(0);
            file.write("*".getBytes());
            file.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    public void assignSeat(String loc, Customer c){
        this.getSeat(loc).setCustomerObject(c);
        //print file using customer data
        //updateManifest();
        updateManifest(this.getSeat(loc).getfilePos(), c.getType());
    }
    
    public void clearSeat(String loc){
        this.getSeat(loc).setCustomerObject(null);
        //updateManifest();
        updateManifest(this.getSeat(loc).getfilePos(),'*');
    }
    
    private void initialiseSeats(int _rows, int _col){
        
        rows = _rows;
        cols = _col;
        Seats = new Seat[_rows][_col];
        int idCounter = 0;
        for (int i = 0; i < _rows; i++) {
            
            for (int j = 0; j < _col; j++) {
                
                String loc = Integer.toString(i+1) + alphaConvert[j];
                Seats[i][j] = new Seat(idCounter,loc);
                if (i < 2) {
                    Seats[i][j].setSeatClass("First");
                }else{
                    if (i < 4) {
                        Seats[i][j].setSeatClass("Business");
                    }else{
                        Seats[i][j].setSeatClass("Economy");
                    }
                }
                
                System.out.println(idCounter + " - Initialised Seat " + loc + " Class: " + Seats[i][j].getSeatClass() );
                idCounter++;
            }
        }
        System.out.println("All " + (idCounter-1) + " Seats Initialised Successfully...");
    }
    
    public static char getIntConvert(int integer){
        return alphaConvert[integer];
    }
    
    public static int getAlphaConvert(char ch){
        
        for (int i = 0; i < alphaConvert.length; i++) {
            if (alphaConvert[i] == ch) {
                return i;
            }
        }
        
        return -1;
    }
    
    //Function to update a random access file to show the manifest for the plane using the adult or child reference.
    private boolean updateManifest(){
        offset = 0;
        try{
            RandomAccessFile file = new RandomAccessFile("flightManifest.txt","rw");
            file.seek(0);
            file.write(" ".getBytes());
        for (int i = 0; i < Seats.length; i++) {
            long row = i+offset;
            for (int j = 0; j < Seats[i].length; j++) {
                file.seek(row+j);
                if (Seats[i][j].getCustomerObject() != null) {
                     file.write(Seats[i][j].getCustomerObject().getType());
                }else{
                   file.write('*'); 
                }
                
                System.out.println("i: " + i + " j: " + j + " offset: " + offset + " row: " + row + " pos: " + (row+j));
            }
            file.seek(row+Seats[i].length);
            file.writeBytes("\r\n");
            offset += (Seats[i].length + 2);
        }
            
            
            file.close();
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }finally{
            return true;
        }
    }
    
    private boolean updateManifest(int loc, char type){
        try{
            RandomAccessFile file = new RandomAccessFile("flightManifest.txt","rw");
            
            file.seek(loc);
            file.write(type);
            file.close();
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }finally{
            return true;
        }
    }
}
