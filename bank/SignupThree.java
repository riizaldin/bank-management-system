package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.Locale;


public class SignupThree extends JFrame implements ActionListener{

    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JRadioButton saving, current, fixed, recurring;
    ButtonGroup typeGroup;
    JButton submit, cancel;
    JLabel label, usuBanking, additionalDetails, type, cardLabel, cardlabel2, digitNo, pinLabel, pinLabel2, pinNo, serviceLabel;
    String formno;

    SignupThree(String formno) {
        this.formno = formno;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/usu.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        label = new JLabel(i3);
        label.setBounds(100, 20, 100, 100);
        add(label);

        usuBanking = new JLabel("USU BANKING SYSTEM");
        usuBanking.setFont(new Font("Raleway", Font.BOLD, 35    ));
        usuBanking.setForeground(new Color (0, 102, 0));
        usuBanking.setBounds(230,36,600,40);
        add(usuBanking);

        additionalDetails = new JLabel("Page 3 : Account Details");
        additionalDetails.setFont(new Font("Raleway", Font.ITALIC | Font.BOLD, 22));
        additionalDetails.setForeground(new Color (0, 102, 0));
        additionalDetails.setBounds(230,80,600,40);
        add(additionalDetails);


        //account type form
        type = new JLabel("Account Type :");
        type.setFont(new Font("Raleway", Font.BOLD, 20));
        type.setBounds(80,160,200,30);
        add(type);

        saving = new JRadioButton("Saving Account");
        saving.setFont(new Font("Raleway", Font.BOLD, 16));
        saving.setBackground(Color.WHITE);
        saving.setBounds(300,160,170,30);
        add(saving);

        current = new JRadioButton("Current Account");
        current.setFont(new Font("Raleway", Font.BOLD, 16));
        current.setBackground(Color.WHITE);
        current.setBounds(300,210,170,30);
        add (current);

        fixed = new JRadioButton("Fixed Deposit Account");
        fixed.setFont(new Font("Raleway", Font.BOLD, 16));
        fixed.setBackground(Color.WHITE);
        fixed.setBounds(500,160,230,30);
        add(fixed);

        recurring = new JRadioButton("Recurring Deposit Account");
        recurring.setFont(new Font("Raleway", Font.BOLD, 16));
        recurring.setBackground(Color.WHITE);
        recurring.setBounds(500,210,230,30);
        add (recurring);

        typeGroup = new ButtonGroup();
        typeGroup.add(saving);
        typeGroup.add(current);
        typeGroup.add(fixed);
        typeGroup.add(recurring);
        
        //Card Number form
        cardLabel = new JLabel("Card Number");
        cardLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        cardLabel.setBounds(80,260,200,30);
        add(cardLabel);

        cardlabel2 = new JLabel("Your 16-digit Card Number");
        cardlabel2.setFont(new Font("Raleway", Font.ITALIC, 15));
        cardlabel2.setBounds(80,285,200,30);
        add(cardlabel2);

        digitNo = new JLabel("XXXX-XXXX-XXXX-XXXX");
        digitNo.setFont(new Font("Raleway", Font.BOLD, 25));
        digitNo.setBounds(300,270,300,30);
        add(digitNo);

        pinLabel = new JLabel("PIN Number");
        pinLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        pinLabel.setBounds(80,340,200,30);
        add(pinLabel);

        pinLabel2 = new JLabel("Your 4-digit Password");
        pinLabel2.setFont(new Font("Raleway", Font.ITALIC, 15));
        pinLabel2.setBounds(80,365,200,30);
        add(pinLabel2);

        pinNo = new JLabel("XXXX");
        pinNo.setFont(new Font("Raleway", Font.BOLD, 25));
        pinNo.setBounds(300,350,300,30);
        add(pinNo);

        serviceLabel = new JLabel("Service Required");
        serviceLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        serviceLabel.setBounds(80,420,200,30);
        add(serviceLabel);

        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBackground(Color.WHITE);
        c1.setBounds(300,420,200,30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBackground(Color.WHITE);
        c2.setBounds(300,460,200,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBackground(Color.WHITE);
        c3.setBounds(300,500,200,30);
        add(c3);

        c4 = new JCheckBox("Email Alerts");
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBackground(Color.WHITE);
        c4.setBounds(550,500,200,30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBackground(Color.WHITE);
        c5.setBounds(550,420,200,30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBackground(Color.WHITE);
        c6.setBounds(550,460,200,30);
        add(c6);

        c7 = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.", true);
        c7.setFont(new Font("Raleway", Font.BOLD, 14));
        c7.setBackground(Color.WHITE);
        c7.setBounds(80,580,650,20);
        add(c7);

        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 20));
        submit.setBackground(new Color (0, 102, 0));
        submit.setForeground(Color.WHITE);
        submit.setBounds(250,620,150,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 20));
        cancel.setBackground(new Color (0, 102, 0));
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(450,620,150,30);
        cancel.addActionListener(this);
        add(cancel);

        
    
        setSize(820, 750);
        setLocation (350,30);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed (ActionEvent ae){
        String accountType = null;
            if (saving.isSelected()){
                accountType = "Saving Account";
            }
            else if (current.isSelected()){
                accountType = "Current Account";
            }
            else if (fixed.isSelected()){
                accountType = "Fixed Deposit Account";
            }
            else if (recurring.isSelected()){
                accountType = "Recurring Deposit Account";
            }

            Random random = new Random();  
            long cardNumber = Math.abs((random.nextLong() % 90000000L)) + 5040936000000000L;
            Long pinnumber = Math.abs((random.nextLong() % 9000L)) + 1000L;
            String balance = "0";       
            String facility = "";
            Date date = new Date();
        if (c1.isSelected()){
            facility += " ATM Card";
        }
        if (c2.isSelected()){
            facility += " Internet Banking";
        }
        if (c3.isSelected()){
            facility += " Mobile Banking";
        }
        if (c4.isSelected()){
            facility += " Email Alerts";
        }
        if (c5.isSelected()){
            facility += " Cheque Book";
        }
        if (c6.isSelected()){
            facility += " E-Statement";
        }

        try {
            if (ae.getSource() == submit){
            if (accountType.equals("") || facility.equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            } else {
                Conn conn = new Conn();
                    String query = "update signup2 set accountType = '"+accountType+"', facility = '"+facility+"' where formno ='"+formno+"'";                      
                    String query2 = "insert into account values ('"+formno+"', '"+pinnumber+"', '"+cardNumber+"', '"+balance+"', '"+date+"' )";
                    conn.s.executeUpdate(query);
                    conn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\n Pin:"+ pinnumber);

                    setVisible(false);
                    new Login().setVisible(true);
                    
                    // new Deposit(pin).setVisible(true);
                    // setVisible(false);
            }
        } else if (ae.getSource() == cancel){
            System.exit(0);
        }

        }catch (Exception e) {
            e.printStackTrace();
        }    
    }
}

