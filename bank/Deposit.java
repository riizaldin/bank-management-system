package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    JButton deposit, back;
    JTextField amountTextField;
    String cardNumber;
    
    Deposit(String cardNumber){
        this.cardNumber = cardNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        
        JLabel text = new JLabel("Enter the amount you want to deposit :");
        text.setBounds(170, 290, 700, 40);
        text.setFont(new Font("Raleway", Font.BOLD, 15));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        amountTextField = new JTextField();
        amountTextField.setBounds(170, 330, 330, 30);
        amountTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        amountTextField.setForeground(Color.BLACK);
        image.add(amountTextField);
        
        JLabel text2 = new JLabel("The amount must be in multiples of 50.000 and below 5.000.000");
        text2.setBounds(170, 350, 700, 40);
        text2.setFont(new Font("Raleway", Font.BOLD | Font.ITALIC, 10));
        text2.setForeground(Color.WHITE);
        image.add(text2);
        
        
        deposit = new JButton("DEPOSIT");
        deposit.setBounds(170, 400, 330, 30);
        deposit.setFont(new Font("Raleway", Font.BOLD, 15));
        deposit.setForeground(Color.BLACK);
        image.add(deposit);
        deposit.addActionListener(this);
        
        back = new JButton("BACK");
        back.setBounds(170, 440, 330, 30);
        back.setFont(new Font("Raleway", Font.BOLD, 15));
        back.setForeground(Color.BLACK);
        image.add(back);
        back.addActionListener(this);

        
        setSize(900, 900);
        setLocation(330, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent ae){
        if (ae.getSource() == deposit){
            String amount = amountTextField.getText();
            Date date = new Date();
            if (amountTextField.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount to be deposited");          
            } else if (Integer.parseInt(amount) > 5000000){
                JOptionPane.showMessageDialog(null, "The amount must be below 5.000.000");
            } else if (Integer.parseInt(amount) < 50000 && Integer.parseInt(amount) % 50 == 0){
                JOptionPane.showMessageDialog(null, "The amount must be in multiples of 50.000");
            } else {
                    try {
                    Conn c = new Conn();
                    
                    String query = ("insert into bank values('"+cardNumber+"', '"+date+"', 'DEPOSIT', '"+amount+"')");
                    String query2 = ("update account set balance = balance + '"+amount+"' where cardNumber ='"+cardNumber+"'");
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Rp. "+amount+" Deposited Successfully");
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
     public static void main(String[] args) {
        new Deposit("").setVisible(true);
    }

}
