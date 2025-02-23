package bankmanagementsystem;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class PinChange extends JFrame implements ActionListener {

    // Declare variables for text fields to access them globally
    JTextField pinField, cpinField;
    JButton submit, back;
    String pinnumber;
    String formno;

    // Constructor
    PinChange(String pinnumber, String formno){
        this.pinnumber = pinnumber; // Store the pin number if passed for use
        this.formno = formno;
        // Set title and layout for the window
        setTitle("PIN Change");
        setLayout(null);

        try{
            con c = new con();
            ResultSet rs = c.s.executeQuery("SELECT * FROM signup WHERE formno = '" + formno + "'");
            if(rs.next()){
                formno = rs.getString("formno");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        // Adding an ATM background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 900, 900);
        add(label);

        // Adding labels and text fields
        JLabel text = new JLabel("Enter New PIN: ");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(300, 300, 200, 35);
        label.add(text);
        
        JLabel text2 = new JLabel("Confirm New PIN: ");
        text2.setForeground(Color.WHITE);
        text2.setFont(new Font("System", Font.BOLD, 16));
        text2.setBounds(300, 380, 200, 35);
        label.add(text2);

        // Text field for new PIN input
        pinField = new JTextField();
        pinField.setBounds(250, 350, 200, 25);
        label.add(pinField);

        // Text field for confirming the new PIN
        cpinField = new JTextField();
        cpinField.setBounds(250, 420, 200, 25);
        label.add(cpinField);

        // Adding a button to submit the new PIN
        submit = new JButton("Submit");
        submit.setBounds(360, 480, 100, 30);
        submit.addActionListener(this);  // Attaching ActionListener
        label.add(submit);

        // Adding a button to go back
        back = new JButton("Back");
        back.setBounds(250, 480, 100, 30);  // Different position for back button
        back.addActionListener(this);  // Attaching ActionListener
        label.add(back);

        // Setting the size and visibility of the window
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Action event handling
    public void actionPerformed(ActionEvent e) {
        try{

        if(e.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber, formno).setVisible(true);  // Go back to login screen
        } else if(e.getSource() == submit) {
            String newPin = pinField.getText();
            String confirmPin = cpinField.getText();
            
            if(newPin.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a new PIN.");
                return;
            }
            
            if(!newPin.equals(confirmPin)) {
                JOptionPane.showMessageDialog(null, "PINs do not match. Please try again.");
                return;
            }
            
            con c = new con();
            
            String query1 = "update bank set pinnumber='"+newPin+"' where pinnumber='"+pinnumber+"' ";
            String query2 = "update login set pinnumber='"+newPin+"' where pinnumber='"+pinnumber+"' ";
            String query3 = "update signup3 set pinnumber='"+newPin+"' where pinnumber='"+pinnumber+"' ";
            
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            c.s.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null, "PIN changed successfully!");

            // After changing PIN, you can redirect the user
            setVisible(false);
            new Transactions(pinnumber,formno).setVisible(true);  // Assuming you have a Transactions screen

        }
        } catch(Exception ex){
            System.out.println(ex);
        
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        new PinChange("","");  // Calling constructor
    }
}
