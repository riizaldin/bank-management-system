package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;


public class Transfer extends JFrame implements ActionListener{
    JButton transfer, back;
    JTextField cardTextField, amountTextField;
    String cardNumber;
    
    Transfer(String cardNumber){
        this.cardNumber = cardNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        
        JLabel text = new JLabel("Enter the card number destination :");
        text.setBounds(170, 290, 700, 40);
        text.setFont(new Font("Raleway", Font.BOLD, 15));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(170, 330, 338, 30);
        cardTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        cardTextField.setForeground(Color.BLACK);
        image.add(cardTextField);

        JLabel text2 = new JLabel("Enter the amount money you want to transfer :");
        text2.setBounds(170, 360, 700, 40);
        text2.setFont(new Font("Raleway", Font.BOLD, 15));
        text2.setForeground(Color.WHITE);
        image.add(text2);
        
        amountTextField = new JTextField();
        amountTextField.setBounds(170, 400, 338, 30);
        amountTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        amountTextField.setForeground(Color.BLACK);
        image.add(amountTextField);
        
        transfer = new JButton("TRANSFER");
        transfer.setBounds(170, 450, 338, 30);
        transfer.setFont(new Font("Raleway", Font.BOLD, 15));
        transfer.setForeground(Color.BLACK);
        image.add(transfer);
        transfer.addActionListener(this);
        
        back = new JButton("BACK");
        back.setBounds(170, 490, 338, 30);
        back.setFont(new Font("Raleway", Font.BOLD, 15));
        back.setForeground(Color.BLACK);
        image.add(back);
        back.addActionListener(this);

        
        setSize(900, 900);
        setLocation(330, 0);
        setVisible(true);
    }
    
        public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == transfer) {
        int transferAmount = Integer.parseInt(amountTextField.getText());
        String cardDestination = cardTextField.getText();
        Date date = new Date();
        int balance = 0;
        ResultSet rs = null;

        try {
            Conn c = new Conn();
            rs = c.s.executeQuery("select * from account where cardNumber = '" + cardNumber + "'");
            while (rs.next()) {
                if (rs.getString("cardNumber").equals(cardNumber)) {
                    balance = Integer.parseInt(rs.getString("balance"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (amountTextField.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the amount to be deposited");
        } else if (transferAmount < 50000) {
            JOptionPane.showMessageDialog(null, "Minimum transfer limit is Rp. 50.000");
        } else if (transferAmount > 5000000) {
            JOptionPane.showMessageDialog(null, "Maximum transfer limit is Rp. 5.000.000");
        } else if (cardDestination.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the destination card number");
        } else if (cardDestination.equals(cardNumber)) {
            JOptionPane.showMessageDialog(null, "You can't transfer to your own account");
        } else if (balance < transferAmount) {
            JOptionPane.showMessageDialog(null, "Your balance is not enough");
        } else if (cardDestination.length() != 16) {
            JOptionPane.showMessageDialog(null, "Card number must be 16 digits");
        } else {
            try {
                Conn c = new Conn();
                rs = c.s.executeQuery("SELECT cardNumber FROM account WHERE cardNumber = '" + cardDestination + "'");
                if (!rs.next()) {
                    JOptionPane.showMessageDialog(null, "Card number is not registered");
                } else {
                    String query = ("insert into bank values('" + cardNumber + "', '" + date + "', 'TRANSFER TO ' '" + cardDestination + "', '" + transferAmount + "')");
                    String query2 = ("update account set balance = balance + '" + transferAmount + "' where cardNumber ='" + cardDestination + "'");
                    String query3 = ("update account set balance = balance - '" + transferAmount + "' where cardNumber ='" + cardNumber + "'");
                    String query4 = ("insert into bank values('" + cardDestination + "', '" + date + "', 'TRANSFER FROM ' '" + cardNumber + "', '" + transferAmount + "')");
                   
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query2);
                    c.s.executeUpdate(query3);
                    c.s.executeUpdate(query4);

                    JOptionPane.showMessageDialog(null, "Rp. " + transferAmount + " Transfered to " + cardDestination + " Successfully");
                    setVisible(false);
                    new Transactions(cardNumber).setVisible(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    } else if (ae.getSource() == back) {
        new Transactions(cardNumber).setVisible(true);
        setVisible(false);
    }
}
}