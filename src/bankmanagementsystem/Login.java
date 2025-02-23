package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    
    JButton login, signup, clear;
    JTextField text1;
    JPasswordField text2;
    
    Login(){
        setSize(800,480);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(350, 200);
        setLayout(null);
        setTitle("Automated Tailer Machine");
        setResizable(false);
        
        //Creating ImageIcon to insert icon in the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        JLabel header = new JLabel("Welcome to ATM");
        label.setBounds(70, 10, 100, 100);
        add(label);
        add(header);
        
        JLabel cardno = new JLabel("Card No : ");
        JLabel pin = new JLabel("PIN : ");
        text1 = new JTextField();
        text2 = new JPasswordField();
        login = new JButton("SIGN IN");
        clear = new JButton("Clear");
        signup = new JButton("SIGN UP");
        
        
        //Adding elements to the frame
        add(cardno);
        add(pin);
        add(text1);
        add(text2);
        add(login);
        add(clear);
        add(signup);
        
        //Changing the color of the card
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
                
        //Bounds for fields
        cardno.setBounds(200, 150,150,40);
        pin.setBounds(200, 200, 150, 40);
        text1.setBounds(350, 160,250, 30);
        text2.setBounds(350, 210, 250, 30);
        login.setBounds(300, 300, 100, 30);
        clear.setBounds(430, 300, 100, 30);
        signup.setBounds(300, 350, 230, 30);

        //color of buttons
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        
        //set the font
        header.setFont(new Font("osward", Font.BOLD, 38));
        header.setBounds(200, 40, 400, 40);
        
        //Setting white color to the whole pane(frame)
        getContentPane().setBackground(Color.WHITE);
        
        //adding actionlistener to the buttons
         login.addActionListener(this);
         clear.addActionListener(this);
         signup.addActionListener(this);
        
    }
    
    @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == login) {
        con c = new con();
        String cardnumber = text1.getText();
        String pinnumber = text2.getText();
        String formno = "";
        String query = "select * from login where cardnumber='"+cardnumber+"' and pinnumber='"+pinnumber+"' ";
        
        if(cardnumber.equals("")){
            
            JOptionPane.showMessageDialog(null, "Enter Card Number.");
        }else if(pinnumber.equals("")){
            JOptionPane.showMessageDialog(null, "Enter Pin number.");
        }
        
        try {
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                formno = rs.getString("formno");
                setVisible(false);
                new Transactions(pinnumber, formno).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    } else if (e.getSource() == clear) {
        text1.setText("");
        text2.setText("");
    } else if (e.getSource() == signup) {
        setVisible(false);
        new Signup1().setVisible(true);
    } else {
        System.out.println("Button is not registered.");
    }
}

    
     public static void main(String [] args){
        new Login();
     }
}
