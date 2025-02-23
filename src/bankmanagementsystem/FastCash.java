package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton deposit, withdrawl, ministatement, pinchange, fastcash, balanceenquiry, exit, back;
    String pinnumber;
    String formno;

    FastCash(String pinnumber, String formno) {
        this.pinnumber = pinnumber;
        this.formno = formno;
        setLayout(null);

        // Fetching the form number from the database
        try {
            con c = new con();
            ResultSet rs = c.s.executeQuery("SELECT * FROM signup WHERE formno = '" + formno + "'");
            if (rs.next()) {
                formno = rs.getString("formno");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Loading the image and scaling it
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        // Heading text
        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(215, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(text);

        // Buttons for fast cash options
        deposit = new JButton("Rs 100");
        deposit.setBounds(170, 415, 150, 30);
        image.add(deposit);

        withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(355, 415, 150, 30);
        image.add(withdrawl);

        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(170, 450, 150, 30);
        image.add(fastcash);

        ministatement = new JButton("Rs 2000");
        ministatement.setBounds(355, 450, 150, 30);
        image.add(ministatement);

        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(170, 485, 150, 30);
        image.add(pinchange);

        balanceenquiry = new JButton("Rs 10000");
        balanceenquiry.setBounds(355, 485, 150, 30);
        image.add(balanceenquiry);

        exit = new JButton("Exit");
        exit.setBounds(355, 520, 150, 30);
        image.add(exit);

        back = new JButton("Back");
        back.setBounds(170, 520, 150, 30);
        image.add(back);

        // Adding action listeners
        deposit.addActionListener(this);
        withdrawl.addActionListener(this);
        fastcash.addActionListener(this);
        ministatement.addActionListener(this);
        pinchange.addActionListener(this);
        balanceenquiry.addActionListener(this);
        exit.addActionListener(this);
        back.addActionListener(this);

        // Frame settings
        setSize(900, 830);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        getContentPane().setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked: " + e.getActionCommand());

        if (e.getSource() == exit) {
            System.exit(0);
        } else if (e.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber, formno).setVisible(true);
        } else {
            try {
                String amount = ((JButton) e.getSource()).getText().substring(3);
                con c = new con();

                ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pinnumber = '" + pinnumber + "'");
                int balance = 0;

                // Calculating current balance
                while (rs.next()) {
                    String transactionType = rs.getString("type").trim();
                    int transactionAmount = Integer.parseInt(rs.getString("amount").trim());

                    if (transactionType.equalsIgnoreCase("Deposit")) {
                        balance += transactionAmount;
                    } else if (transactionType.equalsIgnoreCase("Withdraw")) {
                        balance -= transactionAmount;
                    }
                }

                if (balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                // Updating the database with the withdrawal
                Date date = new Date();
                String query = "INSERT INTO bank VALUES('" + pinnumber + "', '" + date + "', 'Withdraw', '" + amount + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");

                setVisible(false);
                new Transactions(pinnumber, formno).setVisible(true);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("", "");
    }
}
