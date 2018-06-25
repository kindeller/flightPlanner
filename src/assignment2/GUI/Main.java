/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.GUI;
import assignment2.Services.CustomerManager;
import assignment2.Services.SeatManager;
import assignment2.Classes.Customer;
import assignment2.Classes.Seat;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author J378925
 */


public class Main extends javax.swing.JFrame {

    CustomerManager CM;
    SeatManager SM;
  
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
    }

    public void Initialise(CustomerManager cm, SeatManager sm){
        CM = cm;
        SM = sm;
        Customer[] _customerList = CM.getCustomerList();
        Seat[][] _seats = SM.getSeats();
        String[] customerList = new String[_customerList.length];
        
        for (int i = 0; i < _customerList.length; i++) {
            Customer c = _customerList[i];
            customerList[i] = c.getID() + " " + c.getFirstName() + " " + c.getLastName();
        }
        
        
        /*UI updating - old
        jList1.setModel(new javax.swing.DefaultListModel<String>() {
            String[] strings = customerList;
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i];
        }
        });*/
        
        
        DefaultListModel<String> model = new DefaultListModel();
        for (int i = 0; i < customerList.length; i++) {
            String s = _customerList[i].getID() + " " + _customerList[i].getFirstName() + " " + _customerList[i].getLastName();
            model.add(i, s);
        }
        
        jList1.setModel(model);
        
        /*
        jComboRow.removeAllItems();
        for (int i = 1; i < _seats.length+1; i++) {
            jComboRow.addItem(Integer.toString(i));
        }
        jComboSeat.removeAllItems();
        for (int i = 0; i < _seats[0].length; i++) {
            jComboSeat.addItem(Character.toString(SeatManager.getIntConvert(i)));
        }
        */
        
        updateUI(_seats);
        
    }

    
    
    public void updateUI(Seat[][] _seats){
        
        //Set Panel as box Layout
        jScrollSeatPlan.setLayout(new BoxLayout(jScrollSeatPlan, BoxLayout.Y_AXIS));
        
        //Loop through the seats to display the buttons.
        for (int i = 0; i < _seats.length; i++) {
            
            //create inner panel to group buttons
            javax.swing.JPanel inner = new javax.swing.JPanel();
            inner.setName("jPanelSeatInner" + 1);
            inner.setLayout(new FlowLayout());
            //inner.setBorder(BorderFactory.createLineBorder(Color.black));
            
            for (int j = 0; j < _seats[i].length; j++) {
                
                //instantiate Button 
                seatButton jSeatButton = new seatButton(_seats[i][j]);
                jSeatButton.setText(_seats[i][j].getLocation());
                if(_seats[i][j].getCustomerObject()!=null){
                    jSeatButton.setBackground(Color.red);
                }else{
                    jSeatButton.setBackground(Color.green);
                }
                //add button listener + action
                jSeatButton.addActionListener(new ActionListener()
                {
                   /* @Override
                  public void actionPerformed(ActionEvent e)
                  {
                      
                      //TODO: Move this functionalisty into the button itself passing references as its complex and messy to understand  whats going on.
                      seatButton seatBtn = (seatButton) e.getSource();
                      if (seatBtn != null) {
                          //System.out.println("Pressed seat :" + seatBtn.getText());
                          //add logic to change seat here / add remove customer
                          Customer c = seatBtn._seat.getCustomerObject();
                          if(c!=null){
                              int dialogButton = JOptionPane.YES_NO_OPTION;
                              int dialogResult = JOptionPane.showConfirmDialog (null, "Seat Occupied. Are you sure you want to clear this seat?","Warning",dialogButton);
                                if(dialogResult == JOptionPane.YES_OPTION){
                                    DefaultListModel model = (DefaultListModel) jList1.getModel();
                                        String s = c.getID() + " " + c.getFirstName() + " " + c.getLastName();
                                        model.add(c.getID(), s);
                                  seatBtn._seat.setCustomerObject(null);
                                  seatBtn.setBackground(Color.green);
                                }
                          }else{
                              if(jList1.getSelectedValue() == null){
                                  System.out.println("Failed to retrieve customer!");
                                  JOptionPane.showConfirmDialog (null, "Please Select a Customer!" ,"Warning",JOptionPane.PLAIN_MESSAGE);
                              }else{
                                String s = (String)jList1.getSelectedValue();
                                //System.out.println(s);
                                String[] split = s.split(" ");
                                //System.out.println(split[0]);
                                int id = Integer.parseInt(split[0]);
                                c = CM.getCustomerByID(id);
                                if (c!=null) {
                                    //System.out.println(c.getFirstName());
                                    String warnString = "Are you sure you want to add " + c.getFirstName() + " to seat " + seatBtn._seat.getLocation() + "?";
                                    int dialogButton = JOptionPane.YES_NO_OPTION;
                                    int dialogResult = JOptionPane.showConfirmDialog (null, warnString ,"Warning",dialogButton);
                                    if(dialogResult == JOptionPane.YES_OPTION){
                                        seatBtn._seat.setCustomerObject(c);
                                        seatBtn.setBackground(Color.red);
                                        DefaultListModel model = (DefaultListModel) jList1.getModel();
                                        int selectedIndex = jList1.getSelectedIndex();
                                        if (selectedIndex != -1) {
                                            //System.out.println(selectedIndex);
                                            model.remove(selectedIndex);
                                        }
                                        JOptionPane.showConfirmDialog (null, "Succesfully Added Customer!" ,"Success",JOptionPane.PLAIN_MESSAGE);
                                    }
                                }else{
                                    System.out.println("Failed to retrieve customer!");
                                    JOptionPane.showConfirmDialog (null, "Failed to add customer as no customer can be found?" ,"Failed!",JOptionPane.PLAIN_MESSAGE);
                                }
                               }
                          }
                      }
                  }*/
                    
                                        @Override
                  public void actionPerformed(ActionEvent e)
                  {
                      
                      //TODO: Move this functionalisty into the button itself passing references as its complex and messy to understand  whats going on.
                      seatButton seatBtn = (seatButton) e.getSource();
                      if (seatBtn != null) {
                          Customer c = SM.getSeat(seatBtn._seat.getLocation()).getCustomerObject();
                          //add logic to change seat here / add remove customer
                          if(c!=null){
                              int dialogButton = JOptionPane.YES_NO_OPTION;
                              int dialogResult = JOptionPane.showConfirmDialog (null, "Seat Occupied. Are you sure you want to clear this seat?","Warning",dialogButton);
                                if(dialogResult == JOptionPane.YES_OPTION){
                                        DefaultListModel model = (DefaultListModel) jList1.getModel();
                                        String s = c.getID() + " " + c.getFirstName() + " " + c.getLastName();
                                        model.add(c.getID(), s);
                                  SM.clearSeat(seatBtn._seat.getLocation());
                                  //SM.getSeat(seatBtn._seat.getID()).setCustomerObject(null);
                                  seatBtn.setBackground(Color.green);
                                }
                          }else{
                              if(jList1.getSelectedValue() == null){
                                  JOptionPane.showConfirmDialog (null, "Please Select a Customer!" ,"Warning",JOptionPane.PLAIN_MESSAGE);
                              }else{
                                String s = (String)jList1.getSelectedValue();
                                String[] split = s.split(" ");
                                int id = Integer.parseInt(split[0]);
                                c = CM.getCustomerByID(id);
                                if (c!=null) {
                                    String warnString = "Are you sure you want to add " + c.getFirstName() + " to seat " + seatBtn._seat.getLocation() + "?";
                                    int dialogButton = JOptionPane.YES_NO_OPTION;
                                    int dialogResult = JOptionPane.showConfirmDialog (null, warnString ,"Warning",dialogButton);
                                    if(dialogResult == JOptionPane.YES_OPTION){
                                        //add Customer to seat
                                        SM.assignSeat(seatBtn._seat.getLocation(), c); //use function to also print to file every update of manifest
                                        //SM.getSeat(seatBtn._seat.getID()).setCustomerObject(c);
                                        seatBtn.setBackground(Color.red);
                                        //update UI
                                        DefaultListModel model = (DefaultListModel) jList1.getModel();
                                        int selectedIndex = jList1.getSelectedIndex();
                                        if (selectedIndex != -1) {
                                            //System.out.println(selectedIndex);
                                            model.remove(selectedIndex);
                                        }
                                        JOptionPane.showConfirmDialog (null, "Succesfully Added Customer!" ,"Success",JOptionPane.PLAIN_MESSAGE);
                                    }
                                }else{
                                    JOptionPane.showConfirmDialog (null, "Failed to add customer as no customer can be found?" ,"Failed!",JOptionPane.PLAIN_MESSAGE);
                                }
                               }
                          }
                      }
                  }
                });
                //Add button to inner + log
                inner.add(jSeatButton);
                System.out.println("added button!" + _seats[i][j].getLocation());
            }
            //Once complete row, add inner to panel
            jScrollSeatPlan.add(inner);
        }
        //when complete update panel with new inner panels
        jScrollSeatPlan.revalidate();
        jScrollSeatPlan.repaint();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollSeatPlan = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setToolTipText("");
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jScrollSeatPlanLayout = new javax.swing.GroupLayout(jScrollSeatPlan);
        jScrollSeatPlan.setLayout(jScrollSeatPlanLayout);
        jScrollSeatPlanLayout.setHorizontalGroup(
            jScrollSeatPlanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        jScrollSeatPlanLayout.setVerticalGroup(
            jScrollSeatPlanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollSeatPlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(181, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollSeatPlan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(383, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(301, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jScrollSeatPlan;
    // End of variables declaration//GEN-END:variables
}
