
package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton deposit, back;
    String pinnumber;
    String formno;
    
    
    
    Deposit(String pinnumber, String formno){
        
        try{
            con c = new con();
            ResultSet rs = c.s.executeQuery("SELECT * FROM signup WHERE formno = '" + formno + "'");
            if(rs.next()){
                formno = rs.getString("formno");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        this.pinnumber = pinnumber;
        this.formno = formno;
        
        //adding Frame
        setSize(900, 900);
        setLocation(300,0);
       
        setLayout(null);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(190, 300, 400, 20);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(355,485,150,30);
        image.add(deposit);
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        image.add(back);
        
        deposit.addActionListener(this);
        back.addActionListener(this);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()== deposit){
            String number = amount.getText();
            Date date = new Date();
            
            if(number.equals("")){
                 JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit.");
            }else{
                try{
                    
                con c = new con();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+number+" Deposited Successfully.");
                
                setVisible(false);
                new Transactions(pinnumber, formno).setVisible(true);
                
                }catch(Exception ex){
                    System.out.println(e);
                }                
            }
            
        }else if(e.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber, formno).setVisible(true);
        }
        
    }
    
    public static void main(String [] args){
        new Deposit("","");
    }
}
