package bank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class fastCash extends JFrame implements ActionListener {

    JLabel l1, l2;
    JButton b1, b2, b3, b4, b5, b6, b7, b8;
    JTextField t1;
    String cardNumber;

    fastCash(String cardNumber) {
        this.cardNumber = cardNumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);

        l1 = new JLabel("SELECT WITHDRAW AMOUNT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 25));

        b1 = new JButton("Rp. 100.000");
        b2 = new JButton("Rp. 500.000");
        b3 = new JButton("Rp. 1.000.000");
        b4 = new JButton("Rp. 2.000.000");
        b5 = new JButton("Rp. 5.000.000");
        b6 = new JButton("Rp. 10.000.000");
        b7 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(175, 400, 700, 35);
        l3.add(l1);

        b1.setBounds(170, 499, 150, 35);
        l3.add(b1);

        b2.setBounds(390, 499, 150, 35);
        l3.add(b2);

        b3.setBounds(170, 543, 150, 35);
        l3.add(b3);

        b4.setBounds(390, 543, 150, 35);
        l3.add(b4);

        b5.setBounds(170, 588, 150, 35);
        l3.add(b5);

        b6.setBounds(390, 588, 150, 35);
        l3.add(b6);

        b7.setBounds(390, 633, 150, 35);
        l3.add(b7);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed (ActionEvent ae){
    try{
        if(ae.getSource() == b7){
            setVisible(false);
            new Transactions(cardNumber).setVisible(true);
            return;
        }
        
        String amountString = ((JButton)ae.getSource()).getText().substring(4);
        int amount = Integer.parseInt(amountString.replace(".", ""));
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select * from account where cardNumber = '"+cardNumber+"'");
        int balance = 0;
        while(rs.next()){
            if(rs.getString("cardNumber").equals(cardNumber)){
                balance = Integer.parseInt(rs.getString("balance"));
            }
        }
        if(balance < amount){
            JOptionPane.showMessageDialog(null, "Insufficient Balance");
            return;
        } else {
            balance -= amount;
            c.s.executeUpdate("UPDATE account SET balance = '" + balance + "' WHERE cardNumber = '"+cardNumber+"'");
            
            Date date = new Date();
            c.s.executeUpdate("insert into bank values('"+cardNumber+"', '"+date+"', 'WITHDRAW', '"+amount+"')");
            JOptionPane.showMessageDialog(null, "Rp. "+amount+" Debited Successfully");
            
            setVisible(false);
            new Transactions(cardNumber).setVisible(true);
        }
    }catch(Exception e){
        e.printStackTrace();
    }
} 
} 
