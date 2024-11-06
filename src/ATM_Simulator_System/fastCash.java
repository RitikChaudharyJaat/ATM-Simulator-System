package ATM_Simulator_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class fastCash extends JFrame implements ActionListener {

    JButton cashOut1, cashOut2, cashOut3, cashOut4, cashOut5, cashOut6, back;
    String pinNumber;
    fastCash(String pinNumber){
        this.pinNumber = pinNumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900 ,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("select Withdrawal amount");
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(210,300,700,35);
        text.setForeground(Color.white);
        image.add(text);

        cashOut1 = new JButton("Rs 100");
        cashOut1.setBounds(170,415,150,30);
        cashOut1.addActionListener(this);
        image.add(cashOut1);

        cashOut2 = new JButton("Rs 500");
        cashOut2.setBounds(335,415,150,30);
        cashOut2.addActionListener(this);
        image.add(cashOut2);

        cashOut3 = new JButton("Rs 1000");
        cashOut3.setBounds(170,450,150,30);
        cashOut3.addActionListener(this);
        image.add(cashOut3);

        cashOut4 = new JButton("Rs 2000");
        cashOut4.setBounds(335,450,150,30);
        cashOut4.addActionListener(this);
        image.add(cashOut4);

        cashOut5 = new JButton("Rs 5000");
        cashOut5.setBounds(170,485,150,30);
        cashOut5.addActionListener(this);
        image.add(cashOut5);

        cashOut6 = new JButton("Rs 10000");
        cashOut6.setBounds(335,485,150,30);
        cashOut6.addActionListener(this);
        image.add(cashOut6);

        back = new JButton("Back");
        back.setBounds(335,520,150,30);
        back.addActionListener(this);
        image.add(back);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource()!=back && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values ('"+pinNumber+"','"+date+"','Withdrawal','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully");

                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        new fastCash("");
    }
}

