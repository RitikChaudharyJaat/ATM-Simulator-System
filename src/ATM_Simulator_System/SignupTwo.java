package ATM_Simulator_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SignupTwo extends JFrame implements ActionListener {


    JTextField pan,aadhar;
    JRadioButton syes,sno,eyes,eno,other;
    JButton next;
    JComboBox religion,category,income,education,occupation;
    String formno;
    SignupTwo(String formno){

        this.formno = formno;

        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);

        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        String[] valReligion = {"Hindu","Muslim","Sikh","Christen","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.white);
        add(religion);

        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        String[] valcategory = {"OBC","General","SC","ST","Other"};
        category = new JComboBox(valcategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.white);
        add(category);

        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        String[] incomecategory = {"null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
        income = new JComboBox(incomecategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.white);
        add(income);

        JLabel gender = new JLabel("Educational:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,315,200,30);
        add(email);

        String[] educationalvalues = {"Non-Graduation","Graduate","Post-Graduation","Doctorate","Others"};
        education = new JComboBox(educationalvalues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.white);
        add(education);

        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);

        String[] occupationalValues = {"Salaried","Self-Employed","Business","Student","Retired","Other"};
        occupation = new JComboBox(occupationalValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.white);
        add(occupation);

        JLabel address = new JLabel("PAN Number:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);

        JLabel city = new JLabel("Aadhar Number:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);

        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.white);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(500,540,400,30);
        sno.setBackground(Color.white);
        add(sno);

        ButtonGroup maritilgroup = new ButtonGroup();
        maritilgroup.add(sno);
        maritilgroup.add(syes);

        JLabel pincode = new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.white);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(500,590,100,30);
        eno.setBackground(Color.white);
        add(eno);

        ButtonGroup epincode = new ButtonGroup();
        epincode.add(eno);
        epincode.add(eyes);

        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        String sreligion = (String) religion.getSelectedItem();
        String  scategory = (String) category.getSelectedItem();
        String sincome  = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorCitizen = null;
        if (syes.isSelected()){
            seniorCitizen = "Yes";
        }else if(sno.isSelected()){
            seniorCitizen = "No";
        }

        String existingAccount = null;
        if (eyes.isSelected()){
            existingAccount = "Yes";
        }else if(eno.isSelected()){
            existingAccount = "No";
        }
        String sPan = pan.getText();
        String sAadhar = aadhar.getText();

        //database is external entity use of that we use this feature;
        try {
            //connection established with mysql by using conn class;
            Conn c = new Conn(); // use conn class as object;
            //mysql proper query;
            String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+sPan+"', '"+sAadhar+"', '"+seniorCitizen+"', '"+existingAccount+"')";
            c.s.executeUpdate(query);// used to execute the query in the mysql;

            setVisible(false);
            new SignupThree(formno).setVisible(true);

        }catch (Exception e){
            System.out.println(e);
        }

    }
    public static void main(String[] args) {
        new SignupTwo("");
    }
}