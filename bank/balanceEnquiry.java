package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;
import java.text.NumberFormat;


public class balanceEnquiry extends JFrame implements ActionListener{
    JButton deposit, back;
    JTextField amountTextField;
    String cardNumber;
    Date date = new Date();
    int balance;
     
    balanceEnquiry(String cardNumber){
        this.cardNumber = cardNumber;
        try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from account where cardNumber = '"+cardNumber+"'");
                while (rs.next()){
                    if (rs.getString("cardNumber").equals(cardNumber)){
                        balance = Integer.parseInt(rs.getString("balance"));
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        
        JLabel text = new JLabel("Your current balance at " +date+ " is:");
        text.setBounds(170, 290, 700, 40);
        text.setFont(new Font("Raleway", Font.BOLD, 12));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        NumberFormat nf = NumberFormat.getInstance(Locale.forLanguageTag("id-ID"));
        String formattedBalance = nf.format(balance);

        JLabel text2 = new JLabel("Rp. " + formattedBalance);
        text2.setBounds(170, 330, 700, 40);
        text2.setFont(new Font("Raleway", Font.BOLD, 25));
        text2.setForeground(Color.WHITE);
        image.add(text2);
        
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
    
    public void actionPerformed (ActionEvent ae){
        if (ae.getSource() == back){
            new Transactions(cardNumber).setVisible(true);
            setVisible(false);
        }     
    }
}
