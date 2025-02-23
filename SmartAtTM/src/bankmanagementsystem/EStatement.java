package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class EStatement extends JFrame implements ActionListener {
    
    JTextField accountField;
    JButton showBalance, showTransactions, back;
    JLabel balanceLabel;
    String pinnumber;

    EStatement(String pinnumber) {
        this.pinnumber = pinnumber;
        
        // Frame setup
        setSize(900, 900);
        setLocation(300, 0);
        setLayout(null);

        // Background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        // Title
        JLabel text = new JLabel("E-Statement");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(355, 200, 400, 20);
        image.add(text);

        // Account number field
        JLabel accountLabel = new JLabel("Enter Account Number:");
        accountLabel.setForeground(Color.WHITE);
        accountLabel.setFont(new Font("System", Font.BOLD, 14));
        accountLabel.setBounds(170, 250, 200, 20);
        image.add(accountLabel);

        accountField = new JTextField();
        accountField.setFont(new Font("Raleway", Font.BOLD, 14));
        accountField.setBounds(370, 250, 250, 25);
        image.add(accountField);

        // Show balance button
        showBalance = new JButton("Show Balance");
        showBalance.setBounds(170, 300, 150, 30);
        image.add(showBalance);

        // Show transactions button
        showTransactions = new JButton("Show Transactions");
        showTransactions.setBounds(370, 300, 180, 30);
        image.add(showTransactions);

        // Back button
        back = new JButton("Back");
        back.setBounds(370, 350, 150, 30);
        image.add(back);

        // Balance display
        balanceLabel = new JLabel();
        balanceLabel.setForeground(Color.WHITE);
        balanceLabel.setFont(new Font("System", Font.BOLD, 14));
        balanceLabel.setBounds(170, 400, 400, 20);
        image.add(balanceLabel);

        // Add action listeners
        showBalance.addActionListener(this);
        showTransactions.addActionListener(this);
        back.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == showBalance) {
            String accountNumber = accountField.getText();
            if (accountNumber.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your account number.");
                return;
            }

            try {
                con c = new con();
                String query = "SELECT SUM(CASE WHEN type = 'Deposit' THEN amount ELSE -amount END) AS balance FROM bank WHERE pinnumber = '" + accountNumber + "'";
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    double balance = rs.getDouble("balance");
                    balanceLabel.setText("Current Balance: Rs " + balance);
                } else {
                    balanceLabel.setText("No transactions found for this account.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error fetching balance.");
            }
        } else if (e.getSource() == showTransactions) {
            String accountNumber = accountField.getText();
            if (accountNumber.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your account number.");
                return;
            }

            JFrame transactionFrame = new JFrame("Transaction History");
            transactionFrame.setSize(800, 400);
            transactionFrame.setLayout(new BorderLayout());

            String[] columns = {"Date", "Type", "Amount"};
            String[][] data = new String[0][];
            try {
                con c = new con();
                String query = "SELECT date, type, amount FROM bank WHERE pinnumber = '" + accountNumber + "'";
                ResultSet rs = c.s.executeQuery(query);

                // Count rows
                rs.last();
                int rowCount = rs.getRow();
                rs.beforeFirst();

                data = new String[rowCount][3];
                int i = 0;
                while (rs.next()) {
                    data[i][0] = rs.getString("date");
                    data[i][1] = rs.getString("type");
                    data[i][2] = rs.getString("amount");
                    i++;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error fetching transactions.");
            }

            JTable transactionTable = new JTable(data, columns);
            JScrollPane sp = new JScrollPane(transactionTable);
            transactionFrame.add(sp, BorderLayout.CENTER);
            transactionFrame.setVisible(true);
        } else if (e.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new EStatement("");
    }
}
