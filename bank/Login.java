package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
    JButton login, clear, signUp;
    JLabel label, cardno, pin, text, text2, text3;
    JPasswordField pinTextField;
    JTextField cardTextField;
    
    
    Login(){
        setTitle("USU BANKING SYSTEM");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/usu.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        label = new JLabel(i3);
        label.setBounds(70, 20, 100, 100);
        add(label);

        text = new JLabel("Welcome to USU Banking System");
        text.setFont(new Font("Osward", Font.BOLD, 25));
        text.setForeground(new Color (0, 102, 0));
        text.setBounds(190, 35, 400, 40);
        add(text);

        text3 = new JLabel("Bank on Us, Bank with Us");
        text3.setFont(new Font("Osward", Font.ITALIC, 22));
        text3.setForeground(new Color (0, 102, 0));
        text3.setBounds(190, 70, 400, 40);
        add(text3);

        cardno = new JLabel("Card Number ");
        cardno.setFont(new Font("Osward", Font.BOLD, 25));
        cardno.setBounds(100, 160, 400, 40);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 170, 250, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 15));
        add(cardTextField);

        pin = new JLabel("PIN ");
        pin.setFont(new Font("Osward", Font.BOLD, 25));
        pin.setBounds(100, 210, 400, 40);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 250, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 15));
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(300, 270, 115, 30); 
        login.addActionListener(this);
        login.setBackground(new Color (0,102,0));
        login.setForeground(Color.WHITE);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(437, 270, 115, 30); 
        clear.addActionListener(this);
        clear.setBackground(new Color (0,102,0));
        clear.setForeground(Color.WHITE);
        add(clear);

        text2 = new JLabel("Don't have an account?");
        text2.setFont(new Font("Osward", Font.BOLD, 13));
        text2.setForeground(new Color(204,0,0));
        text2.setBounds(355, 300, 400, 40);
        add(text2);

        signUp = new JButton("SIGN UP");
        signUp.setBounds(300, 340, 252, 30); 
        signUp.addActionListener(this);
        signUp.setBackground(new Color(0,102,0));
        signUp.setForeground(Color.WHITE);
        add(signUp);

        getContentPane().setBackground(Color.WHITE);

        setSize(750,480);
        setVisible(true);
        setLocation(400,200);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
                Conn conn = new Conn();
                String cardNumber = cardTextField.getText();
                String pinnumber = pinTextField.getText();
                String query = "select * from account where cardNumber = '"+cardNumber+"' and pinnumber = '"+pinnumber+"'";
                
                try {
                    ResultSet rs = conn.s.executeQuery(query);
                    if (rs.next()) {
                        new Transactions(cardNumber).setVisible(true);
                    } else if (cardNumber.equals("") || pinnumber.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please enter Card Number and PIN");
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                    }
                }
             catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource() == signUp) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
    
}
