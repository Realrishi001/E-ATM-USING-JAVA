package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener{
    
    JLabel additionalDetails, name, fname, dob, gender, email, marital, Address, City, State, pincode;
    JTextField panTextField, AddharTextField;  
    //Radio Button
    JRadioButton Yes, No, yes, no;
    JButton next, back ;
    JComboBox religion, income, educational, occupation, category;
    
    String formno;
    
    Signup2(String formno){
        this.formno = formno;
        // Frame settings
        getContentPane().setBackground(Color.white);
        setSize(800, 800);
        setLocation(350, 10);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
        setTitle("New Account Application Form - Page2");
        
        
             
        // Additional Details Label
        additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(250, 80, 400, 30);  
        add(additionalDetails);
        
        // Religion Label and TextField
        name = new JLabel("Religion : ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 200, 30);  
        add(name);
        
        //Religion Combo Box
        String[] valreligion = {"None","Hindu", "Muslim", "Sikh", "Christan", "Other"};
         religion = new JComboBox(valreligion);
        religion.setBounds(300, 140,350, 30);
        religion.setBackground(Color.white);
        add(religion);
        

        // Category Label and TextField
        fname = new JLabel("Category: ");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);  
        add(fname);
        
        //Category Combo Box
        String valcategory[] = {"None","General", "OBC", "SC", "ST", "Other"};
         category = new JComboBox(valcategory);
        category.setBounds(300, 190, 350, 30);
        category.setBackground(Color.white);
        add(category);
        
        // Income Label
        dob = new JLabel("Income : ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);  
        add(dob);

        // Date of Birth Date Picker (JDateChooser)
        String incomecategory[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "upto 10,00,000" };
         income = new JComboBox(incomecategory);
        income.setBounds(300, 240, 350, 30);  // Set position and size
        income.setBackground(Color.white);
        add(income);
        
        // Educational Label
        gender = new JLabel("Educational ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);  
        add(gender);
        
        // Email Label and TextField
        email = new JLabel("Qualification : ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 330, 200, 30);  
        add(email);
        
        
        String educationalValues[] = {"None","Post Graduate", "Graduate", "Diploma", "12th pass", "10th pass", "Others", "None"};
         educational = new JComboBox(educationalValues);
        educational.setBounds(300, 310, 350, 30);
        educational.setBackground(Color.white);
        add(educational);
        
  
        // Occupation Label
        marital = new JLabel("Occupation : ");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);  
        add(marital);
        
        //Occupation Combo Box
        String occupationValues[] = {"None","Service", "Bussiness","Student","Self-Employed", "Retired", "Others" };
         occupation = new JComboBox(occupationValues);
        occupation.setBounds(300, 390, 350, 30);
        occupation.setBackground(Color.white);
        add(occupation);
        
        
        
        // Pan number Label and TextField
        Address = new JLabel("Pan Number: ");
        Address.setFont(new Font("Raleway", Font.BOLD, 20));
        Address.setBounds(100, 440, 200, 30);
        add(Address);
        
        panTextField = new JTextField();
        panTextField.setBounds(300, 440, 350, 30);
        add(panTextField);

        
        // Addhar Label
        City = new JLabel("Addhar No: ");
        City.setFont(new Font("Raleway", Font.BOLD, 20));
        City.setBounds(100, 490, 200, 30);
        add(City);

        // Addhar TextField
        AddharTextField = new JTextField();
        AddharTextField.setBounds(300, 490, 350, 30);
        add(AddharTextField);

        // Senior Label
        State = new JLabel("Senior Citizen : ");
        State.setFont(new Font("Raleway", Font.BOLD, 20));
        State.setBounds(100, 540, 200, 30);
        add(State);

        //Senior Citizen Radio button
         Yes = new JRadioButton("Yes");
         No = new JRadioButton("No");
        Yes.setBounds(300, 540, 100, 30);
        No.setBounds(400, 540, 100, 30);
        add(Yes);
        add(No);
        Yes.setBackground(Color.white);
        No.setBackground(Color.white);
        
        //Button Grouping
        ButtonGroup scitizen = new ButtonGroup();
        scitizen.add(Yes);
        scitizen.add(No);
        
        
        // Existing Account Label
        pincode = new JLabel("Exisiting Account : ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);

        //Existing Account Radio Button
         yes= new JRadioButton("Yes");
         no = new JRadioButton("No");
        yes.setBounds(300, 590, 100, 30);
        no.setBounds(400, 590, 100, 30);
        add(yes);
        add(no);
        yes.setBackground(Color.white);
        no.setBackground(Color.white);
        
        //Button Grouping
        ButtonGroup exists = new ButtonGroup();
        exists.add(yes);
        exists.add(no);
        
        //Next Button
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(570, 660, 80, 30);
        add(next);
        
        //Back Button
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setFont(new Font("Raleway", Font.BOLD, 14));
        back.setBounds(480,660,80,30);
        add(back);
        
        //action listener to next button
        next.addActionListener(this);
        back.addActionListener(this);
        
        
        
    }
    
    public void actionPerformed(ActionEvent e){
    if(e.getSource() == next){    
    
    String sreligion = (String) religion.getSelectedItem();
    String scategory = (String) category.getSelectedItem();
    String sincome = (String) income.getSelectedItem();
    String sEducation = (String) educational.getSelectedItem();
    String soccupation = (String) occupation.getSelectedItem();
  
    //Pancard Number and Addhar Number;
    String pan = panTextField.getText();
    String addhar = AddharTextField.getText();
    
    
    
    //Senior Citizen Radio Button
    String seniorcitizen = null;
    if (Yes.isSelected()) {
        seniorcitizen = "Senior Citizen";
    } else if (No.isSelected()) {
        seniorcitizen = "Non-Senior Citizen";
    } else {
        seniorcitizen = "null";
    }
        
    //Existing Account
    String ExistingAccount = null;
    if (yes.isSelected()) {
        ExistingAccount = "Yes";
    } else if (no.isSelected()) {
        ExistingAccount = "No";
    } else {
        ExistingAccount = "null";
    }
    
    
    // Validation checks for empty fields
    if (sreligion.equals("None")) {
        JOptionPane.showMessageDialog(null, "Religion is Required.");
    } else if (scategory.equals("None")) {
        JOptionPane.showMessageDialog(null, "Category is Required.");
    } else if (sincome.equals("Null")) {
        JOptionPane.showMessageDialog(null, "Income is Required.");
    } else if (sEducation.equals("None")) {
        JOptionPane.showMessageDialog(null, "Educaiton is Required.");
    } else if (soccupation.equals("None")) {
        JOptionPane.showMessageDialog(null, "Occupation is Required.");
    } else if (ExistingAccount.equals("null")) {
        JOptionPane.showMessageDialog(null, "Existing Account?");
    } else if (pan.equals("")){
        JOptionPane.showMessageDialog(null, "Pancard Number is Required");
    } else if (addhar.equals("")){
        JOptionPane.showMessageDialog(null, "Addhar Number is Required");
    } else if(pan.length() > 10){
        JOptionPane.showMessageDialog(null, "Pan Card is not valid");
    }else if(pan.length() < 10){
        JOptionPane.showMessageDialog(null, "Pan Card is not valid");
    }else if(addhar.length()> 10){
        JOptionPane.showMessageDialog(null, "Addhar Card is not valid");
    }else if(addhar.length()<10){
        JOptionPane.showMessageDialog(null, "Addhar Card is not valid");
    }else {
        // Establish connection and insert the values into the database
        try {
            //Created connection with mysql database
            con c = new con(); 
            
            // SQL insert query
            String query = "INSERT into userDetails VALUES('"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+sEducation+"', '"+soccupation+"', '"+seniorcitizen+"', '"+pan+"', '"+addhar+"', '"+ExistingAccount+"', '"+formno+"')";
            
            // Execute the query
            c.s.executeUpdate(query);
            
            // Show success message
            JOptionPane.showMessageDialog(null, "Form Submitted Successfully!");
            
            // Close the frame or proceed to next step
            setVisible(false);
            new Signup3(formno).setVisible(true);
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
        
    }else if(e.getSource() == back){
        setVisible(false);
        new Signup1().setVisible(true);
    }
}


    public static void main(String[] args){
        new Signup2("");
    }
}
