package bankmanagementsystem;



import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
//import Calender from Jcalender(Jar file)
import com.toedter.calendar.JDateChooser;  

public class Signup1 extends JFrame implements ActionListener{
    
    long random; 

    JLabel formno, PersonalDetails, name, fname, dob, gender, email, marital, Address, City, State, pincode;
    JTextField nameTextField, fnameTextfield, emailTextField, cityTextField, stateTextField, pinTextField, AddressTextField;
    //Date of Birth Picker
    JDateChooser dateChooser;  
    //Radio Button
    JRadioButton male, female, married, unmarried;
    JButton next, back ;
    
    Signup1(){
        // Frame settings
        getContentPane().setBackground(Color.white);
        setSize(800, 800);
        setLocation(350, 10);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
        setTitle("Applicant Details ");
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        // Application Form Number Label
        formno = new JLabel("Application Form No. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(200, 20, 600, 40);  
        add(formno);
        
        // Personal Details Label
        PersonalDetails = new JLabel("Page 1 : Personal Details");
        PersonalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        PersonalDetails.setBounds(250, 80, 400, 30);  
        add(PersonalDetails);
        
        // Name Label and TextField
        name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 200, 30);  
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setBounds(300, 140, 350, 30);
        add(nameTextField);
        
        // Father's Name Label and TextField
        fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);  
        add(fname);

        fnameTextfield = new JTextField();
        fnameTextfield.setBounds(300, 190, 350, 30);
        add(fnameTextfield);
        
        // Date of Birth Label
        dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);  
        add(dob);

        // Date of Birth Date Picker (JDateChooser)
        dateChooser = new JDateChooser();  // Using JDateChooser from JCalendar
        dateChooser.setBounds(300, 240, 350, 30);  // Set position and size
        dateChooser.setDateFormatString("dd/MM/yyyy");  // Format of the date
        add(dateChooser);
        
        // Gender Label
        gender = new JLabel("Gender : ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);  
        add(gender);
        
        //Radio button
        male = new JRadioButton("Male");
        female =new JRadioButton("Female");
        male.setBounds(300,290, 60, 30);
        female.setBounds(450, 290, 120, 30);
        male.setBackground(Color.white);
        female.setBackground(Color.white);
        add(male);
        add(female);
        
        //Button Group
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        
        // Email Label and TextField
        email = new JLabel("Email : ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);  
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setBounds(300, 340, 350, 30);
        add(emailTextField);

        // Marital Status Label
        marital = new JLabel("Marital Status : ");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);  
        add(marital);
        
        //Marital Status Radio Buttons
        married = new JRadioButton("Married");
        unmarried = new JRadioButton("UnMarried");
        married.setBackground(Color.white);
        unmarried.setBackground(Color.white);
        married.setBounds(300, 390,100,30);
        unmarried.setBounds(450,390, 100, 30);
        add(married);
        add(unmarried);
        
        //Grouping Marital buttons
        ButtonGroup maritalButton = new ButtonGroup();
        maritalButton.add(married);
        maritalButton.add(unmarried);
        
        // Address Label and TextField
        Address = new JLabel("Address : ");
        Address.setFont(new Font("Raleway", Font.BOLD, 20));
        Address.setBounds(100, 440, 200, 30);
        add(Address);
        
        AddressTextField = new JTextField();
        AddressTextField.setBounds(300, 440, 350, 30);
        add(AddressTextField);

        
        // City Label
        City = new JLabel("City : ");
        City.setFont(new Font("Raleway", Font.BOLD, 20));
        City.setBounds(100, 490, 200, 30);
        add(City);

        // City TextField
        cityTextField = new JTextField();
        cityTextField.setBounds(300, 490, 350, 30);
        add(cityTextField);

        // State Label
        State = new JLabel("State : ");
        State.setFont(new Font("Raleway", Font.BOLD, 20));
        State.setBounds(100, 540, 200, 30);
        add(State);

        // State TextField
        stateTextField = new JTextField();
        stateTextField.setBounds(300, 540, 350, 30);
        add(stateTextField);

        // Pincode Label
        pincode = new JLabel("Pincode : ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);

        // Pincode TextField
        pinTextField = new JTextField();
        pinTextField.setBounds(300, 590, 350, 30);
        add(pinTextField);
        
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

        // Form number
    String formno = "" + random;
    
    // User's name
    String name = nameTextField.getText();
    
    // Father's name
    String fname = fnameTextfield.getText();
    
    // Birth date
    String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
    
    // Gender 
    String gender = null;
    if (male.isSelected()) {
        gender = "Male";
    } else if (female.isSelected()) {
        gender = "Female";
    } else {
        gender = "null";
    }
    
    // Email
    String email = emailTextField.getText();
    
    // Marital Status
    String marital = null;
    if (married.isSelected()) {
        marital = "Married";
    } else if (unmarried.isSelected()) {
        marital = "Unmarried";
    } else {
        marital = "null";
    }
    
    // Address, city, state, pin
    String address = AddressTextField.getText();
    String city = cityTextField.getText();
    String state = stateTextField.getText();
    String pin = pinTextField.getText();
    
    // Validation checks for empty fields
    if (name.equals("")) {
        JOptionPane.showMessageDialog(null, "Name is Required.");
    } else if (fname.equals("")) {
        JOptionPane.showMessageDialog(null, "Father's Name is Required.");
    } else if (dob.equals("")) {
        JOptionPane.showMessageDialog(null, "Date of Birth is Required.");
    } else if (gender.equals("null")) {
        JOptionPane.showMessageDialog(null, "Gender is Required.");
    } else if (marital.equals("null")) {
        JOptionPane.showMessageDialog(null, "Marital Status is Required.");
    } else if (address.equals("")) {
        JOptionPane.showMessageDialog(null, "Address is Required.");
    } else if (city.equals("")) {
        JOptionPane.showMessageDialog(null, "City is Required.");
    } else if (state.equals("")) {
        JOptionPane.showMessageDialog(null, "State is Required.");
    } else if (pin.equals("")) {
        JOptionPane.showMessageDialog(null, "PinCode is Required.");
    } else if (email.equals("")) {
        JOptionPane.showMessageDialog(null, "Email is Required.");
    } else {
        // Establish connection and insert the values into the database
        try {
            con c = new con(); // Assuming 'con' is a class that handles your database connection
            
            // SQL insert query
            String query = "INSERT INTO signup VALUES('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+state+"', '"+pin+"')";
            
            // Execute the query
            c.s.executeUpdate(query);
            
            // Show success message
            JOptionPane.showMessageDialog(null, "Form Submitted Successfully!");
            
            // Close the frame or proceed to next step
            setVisible(false);
            new Signup2(formno).setVisible(true);
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
        
    }else if(e.getSource() == back){
        setVisible(false);
        new Login().setVisible(true);
    }
}


    public static void main(String[] args){
        new Signup1();
    }
}
