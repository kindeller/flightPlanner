/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.GUI;
import javax.swing.JButton;
import assignment2.Services.CustomerManager;
import assignment2.Services.SeatManager;
import assignment2.Classes.Customer;
import assignment2.Classes.Seat;

/**
 *
 * @author J378925
 */
public class seatButton extends JButton{
    
    Seat _seat;
    
    public seatButton (Seat s) {
        super();
        this._seat = s; 
    }
    
}
