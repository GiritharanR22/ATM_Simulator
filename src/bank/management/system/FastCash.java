package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.cert.TrustAnchor;
import java.sql.*;//also have date class.
//NOTE : import java.util.*; this will provide error that date class is unambiguous, so provide specific date class import in util .
import java.util.Date;
//to use date class

//Taking details from sql in detail here.

public class FastCash extends JFrame implements ActionListener {

    JButton deposit,fastcash,withdrawal,ministatement,pinchange,balanceenquiry,exit;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        getContentPane().setBackground(Color.WHITE);
        setSize(900,900);
        setLocation(400,100);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(215,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);// add to image inorder to be visible in image itself

        deposit= new JButton("Rs 100");
        deposit.setFont(new Font("System",Font.BOLD,12));
        deposit.setBounds(150,400,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        withdrawal= new JButton("Rs 500");
        withdrawal.setFont(new Font("System",Font.BOLD,12));
        withdrawal.setBounds(350,400,150,30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        fastcash= new JButton("Rs 1000");
        fastcash.setFont(new Font("System",Font.BOLD,12));
        fastcash.setBounds(150,430,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        ministatement= new JButton("Rs 2000");
        ministatement.setFont(new Font("System",Font.BOLD,12));
        ministatement.setBounds(350,430,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        pinchange= new JButton("Rs 5000");
        pinchange.setFont(new Font("System",Font.BOLD,12));
        pinchange.setBounds(150,460,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        balanceenquiry= new JButton("Rs 10000");
        balanceenquiry.setFont(new Font("System",Font.BOLD,12));
        balanceenquiry.setBounds(350,460,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        exit= new JButton("BACK");
        exit.setFont(new Font("System",Font.BOLD,12));
        exit.setBounds(350,490,150,30);
        exit.addActionListener(this);
        image.add(exit);
        setUndecorated(true);//to make the border box invisible.ALso can't able to close the output since close button will be invisible
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
            //ae.getSource()....provide object so we  need to typecast as Jbutton to get what button is getting preessed
            //String amount=((JButton)ae.getSource()).getText();//this will provide Rs 5000
            String amount=((JButton)ae.getSource()).getText().substring(3);//takes string after first 3 characters(Rs ) so we get only the amount.
            Conn c=new Conn();
            try{
                ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");//import java.sql library
                int balance =0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        //Integer.parseInt----TO convert string to its integer form
                        //rs.getString("amount")----result set current row value in a amount column.
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }

                    if(ae.getSource()!=exit && balance<Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null,"Insufficient Balance");
                        return;
                    }
                    Date date = new Date();
                    String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited successfully");

                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
            }catch(Exception e){
                System.out.println(e);
            }

        }

    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
