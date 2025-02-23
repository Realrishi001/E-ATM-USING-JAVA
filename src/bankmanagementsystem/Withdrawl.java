package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Date;


public class Withdrawl extends JFrame implements ActionListener {
    
    JTextField amount;
    JButton withdraw, back;
    String pinnumber;
    String formno;
    
    Withdrawl(String pinnumber, String formno) {
        this.pinnumber = pinnumber;
        this.formno = formno;
        
        // Adding Frame
        setSize(900, 900);
        setLocation(300, 0);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(190, 300, 400, 20);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355, 485, 150, 30);
        image.add(withdraw);
        
        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        image.add(back);
        
        withdraw.addActionListener(this);
        back.addActionListener(this);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == withdraw) {
            String number = amount.getText();
            Date date = new Date();
            
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw.");
            } else {
                try {
                    con c = new con();
                    ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pinnumber = '" + pinnumber + "'");
                    
                    int balance = 0;
                    
                    // Calculate current balance
                    while (rs.next()) {
                        String type = rs.getString("type");
                        int transactionAmount = Integer.parseInt(rs.getString("amount"));
                        
                        if (type.equalsIgnoreCase("Deposit")) {
                            balance += transactionAmount;
                        } else if (type.equalsIgnoreCase("Withdraw")) {
                            balance -= transactionAmount;
                        }
                    }
                    
                    int withdrawAmount = Integer.parseInt(number);
                    
                    if (withdrawAmount > balance) {
                        JOptionPane.showMessageDialog(null, "Insufficient balance.");
                    } else {
                        // Perform the withdrawal
                        String query = "INSERT INTO bank VALUES('" + pinnumber + "','" + date + "','Withdraw','" + number + "')";
                        c.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Rs " + number + " withdrawn successfully.");
                        
                        setVisible(false);
                        new Transactions(pinnumber, formno).setVisible(true);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber, formno).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Withdrawl("", "");
    }
}
