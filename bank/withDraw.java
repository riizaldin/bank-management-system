package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class withDraw extends JFrame implements ActionListener{
    JButton withDraw, back;
    JTextField amountTextField;
    String cardNumber;
    
    withDraw(String cardNumber){
        this.cardNumber = cardNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        
        JLabel text = new JLabel("Enter the amount you want to withdraw :");
        text.setBounds(170, 307, 700, 40);
        text.setFont(new Font("Raleway", Font.BOLD, 15));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        amountTextField = new JTextField();
        amountTextField.setBounds(170, 345, 330, 30);
        amountTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        amountTextField.setForeground(Color.BLACK);
        image.add(amountTextField);

        JLabel text2 = new JLabel("The amount must be in multiples of 50.000 and below 5.000.000");
        text2.setBounds(170, 370, 700, 40);
        text2.setFont(new Font("Raleway", Font.BOLD | Font.ITALIC, 11));
        text2.setForeground(Color.WHITE);
        image.add(text2);
        
        withDraw = new JButton("WITHDRAW");
        withDraw.setBounds(355, 452, 150, 30);
        withDraw.addActionListener(this);
        image.add(withDraw);
        
        back = new JButton("BACK");
        back.setBounds(355, 487, 150, 30);
        back.addActionListener(this);
        image.add(back);

        
        setSize(900, 900);
        setLocation(330, 0);
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent ae){
        if (ae.getSource() == withDraw){
            String amount = amountTextField.getText();
            Date date = new Date();
            int balance = 0;
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

            if (amountTextField.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Please enter the amount to be withdrawed"); 
                
            }  else if (Integer.parseInt(amount) % 50000 != 0){
                JOptionPane.showMessageDialog(null, "Please enter the amount in multiples of 50.000"); 
                
            } else if (Integer.parseInt(amount) > 5000000){
                JOptionPane.showMessageDialog(null, "Please enter the amount below 5.000.000"); 
                
            } else if (Integer.parseInt(amount) < 50000){
                JOptionPane.showMessageDialog(null, "Please enter the amount above 50.000"); 
                
            } else if (Integer.parseInt(amount) > balance){
                JOptionPane.showMessageDialog(null, "Insufficient Balance");              
            } else {
                    try {
                    Conn c = new Conn();
                    String query = ("insert into bank values('"+cardNumber+"', '"+date+"', 'WITHDRAW', '"+amount+"')");
                    String query2 = ("update account set balance = balance - '"+amount+"' where cardNumber ='"+cardNumber+"'");
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Rp. "+amount+" Withdrawed Successfully");
                    setVisible(false);
                    new Transactions(cardNumber).setVisible(true);
                } catch (Exception e){
                    e.printStackTrace();
                }

            }
            
        }

        else if (ae.getSource() == back){
            new Transactions(cardNumber).setVisible(true);
            setVisible(false);
        }    
        
        
    }
   
}
