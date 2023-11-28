package bank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import com.toedter.calendar.JDateChooser;
import java.util.*;

// import javax.swing.border.BevelBorder;

public class SignupOne extends JFrame implements ActionListener{
    long random;
    JButton next;
    JLabel label, formno, personDetails, name, fName, dob, gender, email, marital, address, city, state;
    JTextField nameTextField, fNametTextField, emailTextField, addressTextField, cityTextField, stateTextField;
    JRadioButton male, female, other, married, unmarried;
    JPasswordField pinTextField;
    JDateChooser dateChooser;
    ButtonGroup genderGroup, maritalGroup;


    SignupOne() {

        setLayout(null);

        // int applicationNumber = counter.incrementAndGet();
        // JLabel formno = new JLabel("APPLICATION FORM NO. " + applicationNumber); ini supaya berurut form applicationnya

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/usu.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        label = new JLabel(i3);
        label.setBounds(100, 20, 100, 100);
        add(label);

        

        
        formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 35    ));
        formno.setForeground(new Color (0, 102, 0));
        formno.setBounds(230,36,600,40);
        add(formno);

        personDetails = new JLabel("Page 1 : Personal Details");
        personDetails.setFont(new Font("Raleway", Font.ITALIC, 22));
        personDetails.setForeground(new Color (0, 102, 0));
        personDetails.setBounds(230,80,600,40);
        add(personDetails);

        //name form
        name = new JLabel("Name");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,100,30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.PLAIN, 16));
        // nameTextField.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISE)); set border
        nameTextField.setBounds(300,140,435,30);
        add(nameTextField);

        //father's name form
        fName = new JLabel("Father's Name");
        fName.setFont(new Font("Raleway", Font.BOLD, 20));
        fName.setBounds(100,190,200,30);
        add(fName);

        fNametTextField = new JTextField();
        fNametTextField.setFont(new Font("Raleway", Font.PLAIN, 16));
        // fNametTextField.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISE)); set border
        fNametTextField.setBounds(300,190,435,30);
        add(fNametTextField);

        //date of birth form
        dob = new JLabel("Date of Birth");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,240,200,30);
        add(dob);

        //ini kalender
         dateChooser = new JDateChooser();
         dateChooser.setBounds(300,240,435,28);
         dateChooser.setForeground(new Color(105,105,105));
         dateChooser.setFont (new Font("Raleway", Font.PLAIN, 16));
         add(dateChooser);

        //gender form
        gender = new JLabel("Gender");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,290,200,30);
        add(gender);


        male = new JRadioButton("Male");
        male.setBounds(300, 290, 80, 30);
        male.setBackground(Color.WHITE);
        add (male);

        female = new JRadioButton("Female");
        female.setBounds(450, 290, 80, 30);
        female.setBackground(Color.WHITE);
        add (female);

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        //email form
        email = new JLabel("Email Address");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,340,200,30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.PLAIN, 16));
        // emailTextField.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISE)); set border
        emailTextField.setBounds(300,340,435,30);
        add(emailTextField);

        //marital status form
        marital = new JLabel("Marital Status");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100,390,200,30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300, 390, 80, 30);
        married.setBackground(Color.WHITE);
        add (married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 90, 30);
        unmarried.setBackground(Color.WHITE);
        add (unmarried);

        other = new JRadioButton("Other");
        other.setBounds(600, 390, 80, 30);
        other.setBackground(Color.WHITE);
        add (other);

        maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);

        //address form
        address = new JLabel("Address");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100,440,200,30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.PLAIN, 16));
        // addressTextField.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISE)); set border
        addressTextField.setBounds(300,440,435,30);
        add(addressTextField);

        //city form
        city = new JLabel("City ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,490,200,30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.PLAIN, 16));
        // cityTextField.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISE)); set border
        cityTextField.setBounds(300,490,435,30);
        add(cityTextField);

        //state form
        state = new JLabel("State ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,540,200,30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.PLAIN, 16));
        // stateTextField.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISE)); set border
        stateTextField.setBounds(300,540,435,30);
        add(stateTextField);

        //next button
        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 20));
        next.setBounds(635,610,100,30);
        next.setBackground(new Color (0, 128, 0));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed (ActionEvent ae){
        String formno = "" + random; //ini buat ngambil random number dari form no
        String name = nameTextField.getText();
        String fName = fNametTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()){
            gender = "Male";
        } else if (female.isSelected()){
            gender = "Female";
        }
        String email = emailTextField.getText();
        String marital = null;
        if (married.isSelected()){
            marital = "Married";
        } else if (unmarried.isSelected()){
            marital = "Unmarried";
        } else if (other.isSelected()){
            marital = "Other";
        }
       String address = addressTextField.getText();
       String city = cityTextField.getText();
       String state = stateTextField.getText();

        String accountType = "";
        long cardNumber;
        int pinnumber = 0;
        String facility = null;

        try{
            if (name.equals("") || fName.equals("")||gender.equals("")||email.equals("")||marital.equals("")||address.equals("")||city.equals("")||state.equals("") ){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            } else {
                Conn conn = new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fName+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"')";
                conn.s.executeUpdate(query);
                       
                setVisible(false);
                new SignUpTwo(formno).setVisible(true);
            }
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }        
    } 
}
