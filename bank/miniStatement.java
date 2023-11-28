package bank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.text.NumberFormat;
import java.util.Locale;

public class miniStatement extends JFrame implements ActionListener {
    JButton b1, b2;
    JLabel l1, l4, label, text, text3;
    String cardNumber;
    
    

    miniStatement(String cardNumber) {
        this.cardNumber = cardNumber;

        setTitle("Mini Statement");
        setSize(600, 600);
        setLocation(450, 200);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        l1 = new JLabel();
        JScrollPane scrollPane = new JScrollPane(l1);
        scrollPane.setBounds(60, 140, 600, 200);
        scrollPane.setBorder(null);
        add(scrollPane);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/usu.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        label = new JLabel(i3);
        label.setBounds(70, 20, 100, 100);
        add(label);

        text = new JLabel("USU Banking System");
        text.setFont(new Font("Osward", Font.BOLD, 20));
        text.setForeground(new Color (0, 102, 0));
        text.setBounds(190, 35, 400, 40);
        add(text);

        text3 = new JLabel("Bank on Us, Bank with Us");
        text3.setFont(new Font("Osward", Font.ITALIC, 17));
        text3.setForeground(new Color (0, 102, 0));
        text3.setBounds(190, 70, 400, 40);
        add(text3);

        l4 = new JLabel();
        l4.setBounds(60, 380, 300, 20);
        add(l4);

        b1 = new JButton("BACK");
        b1.setBounds(60, 500, 100, 25);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Delete");
        b2.setBounds(180, 500, 100, 25);
        add(b2);
        b2.addActionListener(this);

      


l1.setOpaque(true);
l1.setBackground(Color.WHITE);
l4.setOpaque(true);
l4.setBackground(Color.WHITE);
scrollPane.getViewport().setBackground(Color.WHITE);

        try {
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where cardNumber = '" + cardNumber + "'");

            StringBuilder sb = new StringBuilder("<html><style>table, th, td {border: 1px solid black; border-collapse: collapse;}</style><table><tr><th>Date</th><th>Type</th><th>Amount</th></tr>");
            while (rs.next()) {
                NumberFormat nf = NumberFormat.getInstance(Locale.forLanguageTag("id-ID"));
                String formattedAmount = nf.format(rs.getInt("amount"));
                sb.append("<tr><td>" + rs.getString("date") + "</td><td>" + rs.getString("type") + "</td><td> Rp. " + formattedAmount + "</td></tr>");
            }
            sb.append("</table></html>");
            l1.setText(sb.toString());

            ResultSet rs2 = c1.s.executeQuery("SELECT * FROM account where cardNumber = '" + cardNumber + "'");
            while (rs2.next()) {
                NumberFormat nf = NumberFormat.getInstance(Locale.forLanguageTag("id-ID"));
                String formattedBalance = nf.format(rs2.getInt("balance"));
                l4.setText("Your current balance is Rp. " + formattedBalance);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            setVisible(false);
            new Transactions(cardNumber).setVisible(true);
        }

        try {
            if (ae.getSource() == b2) {
                Conn c = new Conn();
                c.s.executeUpdate("DELETE FROM bank WHERE cardNumber = '"+cardNumber+"'");
                JOptionPane.showMessageDialog(null, "Mini statements deleted successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new miniStatement("").setVisible(true);
    }
}