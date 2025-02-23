package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit, withdrawl, ministatement, pinchange, fastcash, exit, back;
    String pinnumber;
    String formno;
    
    Transactions(String pinnumber, String formno){
        this.pinnumber = pinnumber;
        this.formno = formno;
        setLayout(null);
        
        // ATM Background Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        // Header Text
        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(215, 300, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(text);

        // Buttons Initialization
        deposit = new JButton("Deposit");
        deposit.setBounds(170, 415, 150, 30);
        image.add(deposit);

        withdrawl = new JButton("Cash Withdrawal");
        withdrawl.setBounds(355, 415, 150, 30);
        image.add(withdrawl);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170, 450, 150, 30);
        image.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355, 450, 150, 30);
        image.add(ministatement);

        pinchange = new JButton("Change Pin");
        pinchange.setBounds(170, 485, 150, 30);
        image.add(pinchange);

        exit = new JButton("Exit");
        exit.setBounds(355, 485, 150, 30);
        image.add(exit);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        image.add(back);

        // Adding Action Listeners
        deposit.addActionListener(this);
        withdrawl.addActionListener(this);
        fastcash.addActionListener(this);
        ministatement.addActionListener(this);
        pinchange.addActionListener(this);
        exit.addActionListener(this);
        back.addActionListener(this);

        // Frame Settings
        setSize(900, 830);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        getContentPane().setBackground(Color.black);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            System.exit(0);
        } else if (e.getSource() == back) {
            setVisible(false);
            new Login().setVisible(true);
        } else if (e.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (e.getSource() == withdrawl) {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if (e.getSource() == fastcash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if (e.getSource() == pinchange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if (e.getSource() == ministatement) {
            setVisible(false);
            new practice(formno).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Transactions("", "");  // Example usage
    }
}
