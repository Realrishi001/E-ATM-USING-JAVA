package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class practice extends JFrame implements ActionListener {

    String pinnumber;
    String formno;
    JLabel namelbl, fatherlbl, cardlbl, doblbl, genderlbl, emaillbl, mstatuslbl, addresslbl, citylbl, statelbl, pincodelbl;
    JButton Back;

    practice(String formno) {
        this.formno = formno;
        setLayout(null);

        getContentPane().setBackground(Color.white);

        // Fetch details
        String name = "Not Available";
        String fatherName = "Not Available";
        String cardNumber = "Not Available";
        String dob = "Not Available";
        String gender = "Not Available";
        String email = "Not Available";
        String mstatus = "Not Available";
        String address = "Not Available";
        String city = "Not Available";
        String state = "Not Available";
        String pincode = "Not Available";

        try {
            con c = new con();

            // Fetch details from login table
            ResultSet rs1 = c.s.executeQuery("SELECT * FROM login WHERE formno = '" + formno + "'");
            if (rs1.next()) {
                cardNumber = rs1.getString("cardnumber");
                pinnumber = rs1.getString("pinnumber");
            }

            // Fetch details from signup table
            ResultSet rs = c.s.executeQuery("SELECT * FROM signup WHERE formno = '" + formno + "'");
            if (rs.next()) {
                name = rs.getString("name");
                fatherName = rs.getString("father_name");
                dob = rs.getString("dob");
                gender = rs.getString("gender");
                email = rs.getString("email");
                mstatus = rs.getString("marital_status");
                address = rs.getString("address");
                city = rs.getString("city");
                state = rs.getString("state");
                pincode = rs.getString("pin");
            } else {
                System.out.println("No user information found for Form No: " + formno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Header
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(300, 10, 100, 100);
        add(label);

        JLabel header = new JLabel("Welcome to ATM");
        header.setBounds(250, 120, 300, 50);
        header.setFont(new Font("Raleway", Font.BOLD, 24));
        add(header);

        // Display Card Number
        cardlbl = new JLabel("Card Number: " + cardNumber);
        cardlbl.setBounds(100, 200, 500, 30);
        cardlbl.setForeground(Color.black);
        cardlbl.setFont(new Font("Raleway", Font.BOLD, 20));
        add(cardlbl);

        // Display Name
        namelbl = new JLabel("Name: " + name);
        namelbl.setBounds(100, 250, 500, 30);
        namelbl.setForeground(Color.black);
        namelbl.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(namelbl);

        // Display Father's Name
        fatherlbl = new JLabel("Father's Name: " + fatherName);
        fatherlbl.setBounds(100, 300, 500, 30);
        fatherlbl.setForeground(Color.black);
        fatherlbl.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(fatherlbl);

        // Date of Birth
        doblbl = new JLabel("Date of Birth: " + dob);
        doblbl.setBounds(100, 350, 500, 30);
        doblbl.setForeground(Color.black);
        doblbl.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(doblbl);

        // Gender
        genderlbl = new JLabel("Gender: " + gender);
        genderlbl.setBounds(100, 400, 500, 30);
        genderlbl.setForeground(Color.black);
        genderlbl.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(genderlbl);

        // Email
        emaillbl = new JLabel("Email: " + email);
        emaillbl.setBounds(100, 450, 500, 30);
        emaillbl.setForeground(Color.black);
        emaillbl.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(emaillbl);

        // Marital Status
        mstatuslbl = new JLabel("Marital Status: " + mstatus);
        mstatuslbl.setBounds(100, 500, 500, 30);
        mstatuslbl.setForeground(Color.black);
        mstatuslbl.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(mstatuslbl);

        // Address
        addresslbl = new JLabel("Address: " + address);
        addresslbl.setBounds(100, 550, 500, 30);
        addresslbl.setForeground(Color.black);
        addresslbl.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(addresslbl);

        // City
        citylbl = new JLabel("City: " + city);
        citylbl.setBounds(100, 600, 500, 30);
        citylbl.setForeground(Color.black);
        citylbl.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(citylbl);

        // State
        statelbl = new JLabel("State: " + state);
        statelbl.setBounds(100, 650, 500, 30);
        statelbl.setForeground(Color.black);
        statelbl.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(statelbl);

        // Pincode
        pincodelbl = new JLabel("Pincode: " + pincode);
        pincodelbl.setBounds(100, 700, 500, 30);
        pincodelbl.setForeground(Color.black);
        pincodelbl.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(pincodelbl);

        // Back Button
        Back = new JButton("Back");
        Back.setBounds(280, 750, 120, 30);
        Back.setForeground(Color.WHITE);
        Back.setBackground(Color.BLACK);
        Back.setFont(new Font("Raleway", Font.BOLD, 22));
        Back.addActionListener(this);
        add(Back);

        // Frame Settings
        setSize(700, 850);
        setLocation(300, 50);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Back) {
            setVisible(false);
            new Transactions(pinnumber, formno).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new practice("");
    }
}
