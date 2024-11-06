package ATM_Simulator_System;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit, withdrawal, fastCash, miniStatement, pinChange, balanceEnquiry, exit;
    String pinNumber;
    Transactions(String pinNumber){
        this.pinNumber = pinNumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900 ,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Plese select your Transaction");
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(210,300,700,35);
        text.setForeground(Color.white);
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal = new JButton("Cash Withdrawal");
        withdrawal.setBounds(335,415,150,30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(170,450,150,30);
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(335,450,150,30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(170,485,150,30);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(335,485,150,30);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit = new JButton("Exit");
        exit.setBounds(335,520,150,30);
        exit.addActionListener(this);
        image.add(exit);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        } else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        } else if(ae.getSource() == withdrawal){
            setVisible(false);
            new Withdrawl(pinNumber).setVisible(true);
        } else if (ae.getSource() == fastCash) {
            setVisible(false);
            new fastCash(pinNumber).setVisible(true);
        } else if (ae.getSource() == pinChange) {
            setVisible(false);
            new pinNumber(pinNumber).setVisible(true);
        } else if (ae.getSource() == balanceEnquiry) {
            setVisible(false);
            new balanceEnquiry(pinNumber).setVisible(true);
        } else if (ae.getSource() == miniStatement) {
            new miniStatement(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Transactions("");
    }
}