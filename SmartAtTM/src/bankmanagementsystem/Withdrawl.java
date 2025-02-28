
package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton withdraw, back;
    String pinnumber;
    String formno;
    
    Withdrawl(String pinnumber){
        
        this.pinnumber = pinnumber;
        
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
        
        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(190, 300, 400, 20);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);
        
        withdraw = new JButton("withdraw");
        withdraw.setBounds(355,485,150,30);
        image.add(withdraw);
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        image.add(back);
        
        withdraw.addActionListener(this);
        back.addActionListener(this);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()== withdraw){
            String number = amount.getText();
            Date date = new Date();
            
            if(number.equals("")){
                 JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw.");
            }else{
                try{
                    
                con c = new con();
                
                String query = "insert into bank values('"+pinnumber+"','"+date+"','withdraw','"+number+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+number+" withdraw Successfully.");
                
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
        new Withdrawl("");
    }
}
