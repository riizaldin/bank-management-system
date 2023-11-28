package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    JButton deposit, withDraw, fastCash, miniStatement, pinChange, balanceEnquiry, transfer, exit;
    String cardNumber, pinnumber;
    Transactions(String cardNumber){
    this.cardNumber = cardNumber;
    setLayout(null);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0, 0, 900, 900);
    add(image);

    JLabel text = new JLabel("Please Select Your Transaction");
    text.setBounds(190, 320, 700, 40);
    text.setFont(new Font("Raleway", Font.BOLD, 20));
    text.setForeground(Color.WHITE);
    image.add(text);

    deposit = new JButton("DEPOSIT");
    deposit.setBounds(160, 417, 170, 28);
    deposit.setFont(new Font("Raleway", Font.BOLD, 18));
    image.add(deposit);
    deposit.addActionListener(this);

    withDraw = new JButton("WITHDRAW");
    withDraw.setBounds(340, 417, 170, 28);
    withDraw.setFont(new Font("Raleway", Font.BOLD, 18));
    image.add(withDraw);
    withDraw.addActionListener(this);
    
    fastCash = new JButton("FAST CASH");
    fastCash.setBounds(160, 452, 170, 28);
    fastCash.setFont(new Font("Raleway", Font.BOLD, 18));
    image.add(fastCash);
    fastCash.addActionListener(this);
    
    miniStatement = new JButton("MINI STATEMENT");
    miniStatement.setBounds(340, 452, 170, 28);
    miniStatement.setFont(new Font("Raleway", Font.BOLD, 16));
    image.add(miniStatement);
    miniStatement.addActionListener(this);

    pinChange = new JButton("PIN CHANGE");
    pinChange.setBounds(160, 487, 170, 28);
    pinChange.setFont(new Font("Raleway", Font.BOLD, 18));
    image.add(pinChange);
    pinChange.addActionListener(this);
    
    balanceEnquiry = new JButton("BALANCE ENQUIRY");
    balanceEnquiry.setBounds(340, 487, 170, 28);
    balanceEnquiry.setFont(new Font("Raleway", Font.BOLD, 13));
    image.add(balanceEnquiry);
    balanceEnquiry.addActionListener(this);

    transfer = new JButton("TRANSFER");
    transfer.setBounds(160, 520, 170, 28);
    transfer.setFont(new Font("Raleway", Font.BOLD, 18));
    image.add(transfer);
    transfer.addActionListener(this);

    exit = new JButton("EXIT");
    exit.setBounds(340, 520, 170, 28);
    exit.setFont(new Font("Raleway", Font.BOLD, 18));
    image.add(exit);
    exit.addActionListener(this);


    setSize(900, 900);
    setLocation(330, 0);
    setUndecorated(true);
    setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit){
            setVisible(false);
            new Login().setVisible(true);;
        } else if(ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(cardNumber).setVisible(true);
        } else if (ae.getSource() == pinChange){
            setVisible(false);
            new PinChange(cardNumber).setVisible(true);
        } else if (ae.getSource() == transfer){
            setVisible(false);
            new Transfer(cardNumber).setVisible(true);
        } else if (ae.getSource() == withDraw){
            setVisible(false);
            new withDraw(cardNumber).setVisible(true);
        } else if (ae.getSource() == balanceEnquiry){
            setVisible(false);
            new balanceEnquiry(cardNumber).setVisible(true);
        }
        else if (ae.getSource() == fastCash){
            setVisible(false);
            new fastCash(cardNumber).setVisible(true);
        }
        else if (ae.getSource() == miniStatement){
            setVisible(false);
            new miniStatement(cardNumber).setVisible(true);
        }
    }

}
