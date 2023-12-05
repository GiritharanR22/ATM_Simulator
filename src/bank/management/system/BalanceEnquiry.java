package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;//important while using resultset

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton back;

    String pinnumber;
    BalanceEnquiry(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        setSize(900,900);
        setLocation(300,100);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        Conn c=new Conn();
        int balance = 0;
        try {//try statement is must
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");//import java.sql library
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    //Integer.parseInt----TO convert string to its integer form
                    //rs.getString("amount")----result set current row value in a amount column.
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }

        JLabel text =new JLabel("Your current account Balance is Rs"+balance);
        text.setForeground(Color.WHITE);
        text.setBounds(170,300,400,30);
        image.add(text);

        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==back){//if statement is optional if only one button is present.
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    }
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
