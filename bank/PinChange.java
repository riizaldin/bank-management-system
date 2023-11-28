package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class PinChange extends JFrame implements ActionListener{
    JPasswordField pin, repin;
    JButton change, back;
    String cardNumber;
    
    PinChange (String cardNumber){
        this.cardNumber = cardNumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("CHANGE PIN NUMBER");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 18));
        text.setBounds(250, 280, 500, 35);
        image.add(text);
               
        JLabel pintext = new JLabel("ENTER YOUR NEW PIN");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 14));
        pintext.setBounds(165, 350, 180, 25);
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330, 350, 180, 25);
        image.add(pin);
                
        
        JLabel repintext = new JLabel("RE-ENTER NEW PIN");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 14));
        repintext.setBounds(165, 390, 180, 25);
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(330, 390, 180, 25);
        image.add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
                  
        setSize(900, 900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed (ActionEvent ae){
        try {
           String npin = pin.getText();
           String rpin = repin.getText();

           Conn c = new Conn();
           ResultSet rs = c.s.executeQuery("select pinnumber from account where cardNumber = '"+cardNumber+"'");
      
           if (rs.next()) {
            String currentPin = rs.getString("pinnumber");
        
            if (ae.getSource() == change){
                if (!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN doesn't match");
                    return;
                } else if (npin.length() != 4){
                    JOptionPane.showMessageDialog(null, "PIN must be 4 digits");
                    return;
                } else if (npin.equals(currentPin)){
                    JOptionPane.showMessageDialog(null, "PIN cannot be the same as the previous PIN");
                    return;
                } else  {
                   Conn conn = new Conn();
                   String query1 = "update account set pinnumber = '"+rpin+"' where cardNumber ='"+cardNumber+"'";          
                   conn.s.executeUpdate(query1);
                 
                    JOptionPane.showMessageDialog(null, "PIN changed successfully");
                    setVisible(false);
                    new Transactions(cardNumber).setVisible(true);
               }
            }
               

            } else if (ae.getSource() == back){
                   setVisible(false);
                   new Transactions(cardNumber).setVisible(true);     
           }           
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
