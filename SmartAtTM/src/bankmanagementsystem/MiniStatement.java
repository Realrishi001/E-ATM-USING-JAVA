package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {

    String pinnumber; 

    JLabel formnoLabel, nameLabel, fnameLabel, dobLabel, genderLabel, emailLabel, maritalLabel, addressLabel, cityLabel, stateLabel, pincodeLabel;

    MiniStatement(String pinnumber) {
        this.pinnumber = pinnumber;

        // Set up frame
        setSize(900, 900);
        setLocation(300, 0);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE); // Set white background

        // Title
        JLabel title = new JLabel("Mini Statement");
        title.setForeground(Color.black);
        title.setFont(new Font("System", Font.BOLD, 20));
        title.setBounds(350, 50, 200, 30);
        add(title);

        // Initialize labels
        formnoLabel = new JLabel("Form No: ");
        formnoLabel.setFont(new Font("Raleway", Font.BOLD, 16));
        formnoLabel.setBounds(50, 150, 500, 30);
        add(formnoLabel);

        nameLabel = new JLabel("Name: ");
        nameLabel.setFont(new Font("Raleway", Font.BOLD, 16));
        nameLabel.setBounds(50, 200, 500, 30);
        add(nameLabel);

        fnameLabel = new JLabel("Father's Name: ");
        fnameLabel.setFont(new Font("Raleway", Font.BOLD, 16));
        fnameLabel.setBounds(50, 250, 500, 30);
        add(fnameLabel);

        dobLabel = new JLabel("Date of Birth: ");
        dobLabel.setFont(new Font("Raleway", Font.BOLD, 16));
        dobLabel.setBounds(50, 300, 500, 30);
        add(dobLabel);

        genderLabel = new JLabel("Gender: ");
        genderLabel.setFont(new Font("Raleway", Font.BOLD, 16));
        genderLabel.setBounds(50, 350, 500, 30);
        add(genderLabel);

        emailLabel = new JLabel("Email: ");
        emailLabel.setFont(new Font("Raleway", Font.BOLD, 16));
        emailLabel.setBounds(50, 400, 500, 30);
        add(emailLabel);

        maritalLabel = new JLabel("Marital Status: ");
        maritalLabel.setFont(new Font("Raleway", Font.BOLD, 16));
        maritalLabel.setBounds(50, 450, 500, 30);
        add(maritalLabel);

        addressLabel = new JLabel("Address: ");
        addressLabel.setFont(new Font("Raleway", Font.BOLD, 16));
        addressLabel.setBounds(50, 500, 500, 30);
        add(addressLabel);

        cityLabel = new JLabel("City: ");
        cityLabel.setFont(new Font("Raleway", Font.BOLD, 16));
        cityLabel.setBounds(50, 550, 500, 30);
        add(cityLabel);

        stateLabel = new JLabel("State: ");
        stateLabel.setFont(new Font("Raleway", Font.BOLD, 16));
        stateLabel.setBounds(50, 600, 500, 30);
        add(stateLabel);

        pincodeLabel = new JLabel("Pincode: ");
        pincodeLabel.setFont(new Font("Raleway", Font.BOLD, 16));
        pincodeLabel.setBounds(50, 650, 500, 30);
        add(pincodeLabel);

        // Fetch user details from the database
        fetchUserDetails();

        // Back Button
        JButton back = new JButton("Back");
        back.setBounds(400, 750, 100, 30);
        back.addActionListener(e -> {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        });
        add(back);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void fetchUserDetails() {
        try {
            // Database connection
            con c = new con();
            String query = "SELECT * FROM signup WHERE pin = '"+pinnumber.trim()+"'";  // Assuming you store pin in the signup table
            ResultSet rs = c.s.executeQuery(query);

            if (rs.next()) {
    System.out.println("Data fetched successfully.");
    System.out.println("Name: " + rs.getString("name")); // Check if data is available
    
} else {
    System.out.println("No data found for the provided pin.");
}
            
            if (rs.next()) {
                // Directly set text in labels
                formnoLabel.setText("Form No: " + rs.getString("formno"));
                nameLabel.setText("Name: " + rs.getString("name"));
                fnameLabel.setText("Father's Name: " + rs.getString("father_name"));
                dobLabel.setText("Date of Birth: " + rs.getString("dob"));
                genderLabel.setText("Gender: " + rs.getString("gender"));
                emailLabel.setText("Email: " + rs.getString("email"));
                maritalLabel.setText("Marital Status: " + rs.getString("marital_status"));
                addressLabel.setText("Address: " + rs.getString("address"));
                cityLabel.setText("City: " + rs.getString("city"));
                stateLabel.setText("State: " + rs.getString("state"));
                pincodeLabel.setText("Pincode: " + rs.getString("pincode"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MiniStatement("6285");
    }
}
