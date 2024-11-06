package ATM_Simulator_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {
    JButton withdraw,back;
    String pinNumber;
    JTextField amount;
    Withdrawl(String pinNumber){

        this.pinNumber = pinNumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900 ,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Enter the Amount you want to Withdraw");
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(190,300,700,35);
        text.setForeground(Color.white);
        image.add(text);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355,485,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        amount = new JTextField();
        amount.setBounds(190,350,290,25);
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        image.add(amount);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == withdraw){
            String number = amount.getText();
            Date date = new Date();
            if(number.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please enter the Amount you want to Withdraw");
            } else {
                try {

                    Conn conn = new Conn();
                    ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
                    int balance = 0;
                    while(rs.next()){
                        if(rs.getString("type").equals("Deposit")){
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else{
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if(ae.getSource()!=back && balance<Integer.parseInt(number)){
                        JOptionPane.showMessageDialog(null,"Insufficient Balance");
                        return;
                    }
                    String query = "insert into bank values ('"+pinNumber+"','"+date+"','Withdrawl','"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+number+" Withdraw Successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                } catch (Exception e){
                    System.out.println(e);
                }
            }

        } else if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdrawl("");
    }
}

