package bank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// import javax.swing.border.BevelBorder;

public class SignUpTwo extends JFrame implements ActionListener{
    JButton next;
    JLabel label, nik, income, usuBanking, packageBank, additionalDetails, education, occupation, phoneNum, citizen;
    JTextField fNametTextField, emailTextField, nikTextField, cityTextField, stateTextField, phoneNumTextField;
    JComboBox packageComboBox, incomeComboBox, educationComboBox, occupationComboBox;
    JRadioButton local, foreign;
    JPasswordField pinTextField;
    ButtonGroup country, citizenGroup;
    String formno, accountType, facility;


    SignUpTwo(String formno) {

        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/usu.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        label = new JLabel(i3);
        label.setBounds(100, 20, 100, 100);
        add(label);

        this.formno = formno;

        usuBanking = new JLabel("USU BANKING SYSTEM");
        usuBanking.setFont(new Font("Raleway", Font.BOLD, 35    ));
        usuBanking.setForeground(new Color (0, 102, 0));
        usuBanking.setBounds(230,36,600,40);
        add(usuBanking);

        additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.ITALIC | Font.BOLD, 22));
        additionalDetails.setForeground(new Color (0, 102, 0));
        additionalDetails.setBounds(230,80,600,40);
        add(additionalDetails);

        //religion form
        packageBank = new JLabel("Package :");
        packageBank.setFont(new Font("Raleway", Font.BOLD, 20));
        packageBank.setBounds(100,140,100,30);
        add(packageBank);

        String valReligion[]={"Choose your banking package", "Basic Package", "Premium Package", "Gold Package", "Platinum Package"};
        packageComboBox = new JComboBox(valReligion);
        packageComboBox.setFont(new Font("Raleway", Font.PLAIN, 16));
        packageComboBox.setBackground(Color.WHITE);
        packageComboBox.setBounds(300,140,435,30);
        add(packageComboBox);

        //occupation form
        occupation = new JLabel("Occupation :");    
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100,190,150,30);
        add(occupation);

        String valOccupation[] = {"Choose your occupation", "Student", "Employee", "Self-employed", "Unemployed", "Retired"};
        occupationComboBox = new JComboBox(valOccupation);
        occupationComboBox.setFont(new Font("Raleway", Font.PLAIN, 16));
        occupationComboBox.setBackground(Color.WHITE);
        occupationComboBox.setBounds(300,190,435,30);
        add(occupationComboBox);

        //income form
        income = new JLabel("Income :");    
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100,240,100,30);
        add(income);

        String valIncome[] = {"Choose your income", "< Rp. 1.500.000", "Rp. 1.500.000 - Rp. 2.500.000", "Rp. 2.500.000 - Rp. 5.000.000", "Rp. 5.000.000 - Rp. 10.000.000", "> Rp. 10.000.000"};
        incomeComboBox = new JComboBox(valIncome);
        incomeComboBox.setFont(new Font("Raleway", Font.PLAIN, 16));
        incomeComboBox.setBackground(Color.WHITE);
        incomeComboBox.setBounds(300,240,435,30);
        add(incomeComboBox);

        //education form
        education = new JLabel("Education :");    
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        education.setBounds(100,290,150,30);
        add(education);

        String valEducation[] = {"Choose your last education", "foreign formal education", "Elementary school", "Junior high school", "Senior high school", "Diploma", "Bachelor's degree", "Master's degree", "Doctoral degree"};
        educationComboBox = new JComboBox(valEducation);
        educationComboBox.setFont(new Font("Raleway", Font.PLAIN, 16));
        educationComboBox.setBackground(Color.WHITE);
        educationComboBox.setBounds(300,290,435,30);
        add(educationComboBox);

        //nik form
        nik = new JLabel("NIK :");
        nik.setFont(new Font("Raleway", Font.BOLD, 20));
        nik.setBounds(100,340,200,30);
        add(nik);

        nikTextField = new JTextField();
        nikTextField.setFont(new Font("Raleway", Font.PLAIN, 16));
        // nikTextField.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISE)); set border
        nikTextField.setBounds(300,340,435,30);
        add(nikTextField);


        //phoneNumber form
        phoneNum = new JLabel("Phone Number :");
        phoneNum.setFont(new Font("Raleway", Font.BOLD, 20));
        phoneNum.setBounds(100,390,200,30);
        add(phoneNum);

        phoneNumTextField = new JTextField();
        phoneNumTextField.setFont(new Font("Raleway", Font.PLAIN, 16));
        // phoneNumTextField.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISE)); set border
        phoneNumTextField.setBounds(300,390,435,30);
        add(phoneNumTextField);

        //citizen form
        citizen = new JLabel("Citizen :");
        citizen.setFont(new Font("Raleway", Font.BOLD, 20));
        citizen.setBounds(100,440,200,30);
        add(citizen);

        local = new JRadioButton("Local Citizen");
        local.setBounds(300, 440, 150, 30);
        local.setBackground(Color.WHITE);
        add (local);

        foreign = new JRadioButton("Foreign Citizen");
        foreign.setBounds(460, 440, 150, 30);
        foreign.setBackground(Color.WHITE);
        add (foreign);

        citizenGroup = new ButtonGroup();
        citizenGroup.add(local);
        citizenGroup.add(foreign);


        //next button
        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 20));
        next.setBounds(635,490,100,30);
        next.setBackground(new Color (0, 102, 0));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        setSize(850,620);
        setLocation(350,80);
        setVisible(true);

        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed (ActionEvent ae){
        String spackage = (String) packageComboBox.getSelectedItem();
        String soccupation = (String) occupationComboBox.getSelectedItem();
        String sincome = (String) incomeComboBox.getSelectedItem();
        String seducation = (String) educationComboBox.getSelectedItem();
        String nik = nikTextField.getText();
        String phoneNum = phoneNumTextField.getText();
        String citizen = null;
        String accountType = null;
        String facility = null;
        if (local.isSelected()){
            citizen = "Local Citizen";
        } else if (foreign.isSelected()){
            citizen = "Foreign Citizen";
        }
        try{
            if (spackage.equals("Choose your banking package") ||soccupation.equals("Choose your occupation")|| sincome.equals("Choose your income")||seducation.equals("Choose your last education")||nik.equals("")||phoneNum.equals("")||citizen.equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            } else if (nik.length() != 16){
                JOptionPane.showMessageDialog(null, "NIK must be 16 digits");
            } else {
                Conn c = new Conn();
                String query = "insert into signup2 values('"+formno+"', '"+spackage+"', '"+soccupation+"', '"+sincome+"','"+seducation+"', '"+nik+"','"+phoneNum+"','"+citizen+"', '"+accountType+"', '"+facility+"')";
                c.s.executeUpdate(query);

                // new SignupThree() objek.
                setVisible(false);
                new SignupThree(formno).setVisible(true);              
            }
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
