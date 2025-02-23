
package bankmanagementsystem;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener{
    
        JLabel l1, type;
        JRadioButton r1, r2, r3, r4;
        JCheckBox c1, c2, c3, c4, c5,c6, c7;
        JButton submit, back;
        String formno;
    
        Signup3(String formno){
            this.formno = formno;
            setTitle("Account Details(page-3)");
            getContentPane().setBackground(Color.white);
            
            //Heading label
            l1 = new JLabel("Page 3 : Account Details");
            l1.setFont(new Font("Raleway", Font.BOLD, 22));
            l1.setBounds(280, 40, 400, 40);
            add(l1);
            
            //Type label
            type = new JLabel("Account Type: ");
            type.setFont(new Font("Raleway", Font.BOLD, 22));
            type.setBounds(100, 140, 200, 30);
            
            //Saving radio button
            r1 = new JRadioButton("Saving Account");
            r1.setFont(new Font("Raleway", Font.BOLD, 16));
            r1.setBackground(Color.white);
            r1.setBounds(100,180,150,20);
            add(r1);
            
            //Fixed Account
            r2 = new JRadioButton("Fixed Account");
            r2.setFont(new Font("Raleway", Font.BOLD, 16));
            r2.setBackground(Color.white);
            r2.setBounds(350,180,150,20);
            add(r2);
            
            //Current Account
            r3 = new JRadioButton("Current Account");
            r3.setFont(new Font("Raleway", Font.BOLD, 16));
            r3.setBackground(Color.white);
            r3.setBounds(100,220,200,20);
            add(r3);
            
            //Recurring Account
            r4 = new JRadioButton("Recurring Account");
            r4.setFont(new Font("Raleway", Font.BOLD, 16));
            r4.setBackground(Color.white);
            r4.setBounds(350,220,200,20);
            add(r4);
            
            //Button Group
            ButtonGroup types = new ButtonGroup();
            types.add(r1);
            types.add(r2);
            types.add(r3);
            types.add(r4);
            
            //Card No 
            JLabel card = new JLabel("Card No. : ");
            card.setFont(new Font("Raleway", Font.BOLD, 16));
            card.setBounds(100, 300, 200, 30);
            add(card);
            
            JLabel number = new JLabel("XXXX-XXXX-XXXX-1069");
            number.setFont(new Font("Raleway", Font.BOLD, 16));
            number.setBounds(330, 300, 300, 30);
            add(number);
            
            //card no info label
            JLabel carddetail = new JLabel("Your 16 Digit Card Number");
            carddetail.setFont(new Font("Raleway", Font.ITALIC, 12));
            carddetail.setBounds(100, 330, 300, 30);
            add(carddetail);
            
            //Pin No
            JLabel pin = new JLabel("Pin : ");
            pin.setFont(new Font("Raleway", Font.BOLD, 16));
            pin.setBounds(100, 370, 200, 30);
            add(pin);
            
            JLabel pnumber = new JLabel("XXXX");
            pnumber.setFont(new Font("Raleway", Font.BOLD, 16));
            pnumber.setBounds(330, 370, 300, 30);
            add(pnumber);
            
            //Pin info label
            JLabel pindetail = new JLabel("Your 4 Digit Card Number");
            pindetail.setFont(new Font("Raleway", Font.ITALIC, 12));
            pindetail.setBounds(100, 400, 300, 30);
            add(pindetail);
            
            //Services Required
            JLabel services = new JLabel("Services Required : ");
            services.setFont(new Font("Raleway", Font.BOLD, 22));
            services.setBounds(100, 450 , 220, 30);
            add(services);
            
            c1 = new JCheckBox("ATM CARD");
            c1.setBackground(Color.white);
            c1.setFont(new Font("Raleway", Font.BOLD, 16));
            c1.setBounds(100, 500, 200, 30);
            add(c1);
            
            c2 = new JCheckBox("INTERNET BANKING");
            c2.setBackground(Color.white);
            c2.setFont(new Font("Raleway", Font.BOLD, 16));
            c2.setBounds(350, 500, 200, 30);
            add(c2);
            
            c3 = new JCheckBox("MOBILE BANKING");
            c3.setBackground(Color.white);
            c3.setFont(new Font("Raleway", Font.BOLD, 16));
            c3.setBounds(100, 550, 200, 30);
            add(c3);
            
            c4 = new JCheckBox("EMAIL/SMS ALERT");
            c4.setBackground(Color.white);
            c4.setFont(new Font("Raleway", Font.BOLD, 16));
            c4.setBounds(350, 550, 200, 30);
            add(c4);
            
            c5 = new JCheckBox("CHEQUE BOOK");
            c5.setBackground(Color.white);
            c5.setFont(new Font("Raleway", Font.BOLD, 16));
            c5.setBounds(100, 600, 200, 30);
            add(c5);
            
            c6 = new JCheckBox("E-STATEMENT");
            c6.setBackground(Color.white);
            c6.setFont(new Font("Raleway", Font.BOLD, 16));
            c6.setBounds(350, 600, 200, 30);
            add(c6);
            
            c7= new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge.");
            c7.setBackground(Color.white);
            c7.setFont(new Font("Raleway", Font.BOLD, 12));
            c7.setBounds(100, 650, 800, 30);
            add(c7);
            
            //Buttons
            
            submit = new JButton("Submit");
            submit.setBackground(Color.black);
            submit.setForeground(Color.white);
            submit.setFont(new Font("Raleway", Font.BOLD, 14));
            submit.setBounds(320, 720, 100, 30);
            add(submit);
            
            back = new JButton("Back");
            back.setBackground(Color.black);
            back.setForeground(Color.white);
            back.setFont(new Font("Raleway", Font.BOLD, 14));
            back.setBounds(200, 720, 100, 30);
            add(back);
            
            
            submit.addActionListener(this);
            back.addActionListener(this);
            
            
            setSize(850,820);
            setLayout(null);
            setLocation(350,0);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);
        }
        
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==submit){
                con c = new con();
                    
                String accountType = null;
                if(r1.isSelected()){
                    accountType = "Saving Account";
                }else if(r2.isSelected()){
                    accountType = "Fixed Account";
                }else if(r3.isSelected()){
                    accountType = "Current Account";
                }else if(r4.isSelected()){
                    accountType = "Recurring Account";
                }else {
                    accountType = "null";
                }
                
                Random random = new Random();
                String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 504093600000000L);
                String pinnumber = "" + Math.abs((random.nextLong()%9000L)+ 1000L);
                
                
                
                String facility = "";
                if(c1.isSelected()){
                    facility += "ATM CARD";
                }else if(c2.isSelected()){
                    facility += " interent Banking";
                }else if(c3.isSelected()){
                    facility += " Mobile Banking";
                }else if(c4.isSelected()){
                    facility += " Email/sms alerts";
                }else if(c5.isSelected()){
                    facility += " Cheque book";
                }else if(c6.isSelected()){
                    facility += " E-Statement";
                }
                
                String Term = "false";
                if(c7.isSelected()){
                    Term = "true";
                }
                
                try {
                    if(accountType.equals("null")){
                        JOptionPane.showMessageDialog(null, "Account type is required");
                    }else if(Term.equals("false")){
                        JOptionPane.showMessageDialog(null, "Check the Term CheckBox.");
                    }else {
                        String query1 = "insert into signup3 values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                        c.s.executeUpdate(query1);
                        String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                        c.s.executeUpdate(query2);
                        
                        JOptionPane.showMessageDialog(null, "Card No : "+ cardnumber +"\n Password : "+ pinnumber);
                        setVisible(false);
                        new Deposit(pinnumber, formno).setVisible(true);
                        
                    }
                } catch (Exception ae) {
                    System.out.println(ae);
                }
                
                
                
                
            }else if(e.getSource() == back){
                setVisible(false);
                new Signup2(formno).setVisible(true);
            }
        }
    
        public static void main(String [] args){
            new Signup3("");
        }
}
