package bank.management.system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class MiniStatement extends JFrame  implements ActionListener {

    String pinnumber;
    MiniStatement(String pinnumber){
        this.pinnumber=pinnumber;
        setTitle("Mini Statement");
        setSize(400,600);
        setLocation(200,200);
        setLayout(null);

        JLabel mini=new JLabel();
        add(mini);

        JLabel bank=new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        try{
            Conn c=new Conn();
            ResultSet rs= c.s.executeQuery("Select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number : "+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));//To get respective card number of pin produced
            }

        }catch(Exception e){
            System.out.println(e);
        }

        try{
            Conn conn=new Conn();
            int bal = 0;
            ResultSet rs=conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
                if (rs.getString("type").equals("Deposit")) {
                    //Integer.parseInt----TO convert string to its integer form
                    //rs.getString("amount")----result set current row value in a amount column.
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current ccount balance is Rs."+bal);
        }catch(Exception e){
            System.out.println(e);
        }
        mini.setBounds(20,140,400,200);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
