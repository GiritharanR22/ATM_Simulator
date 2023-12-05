package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit,fastcash,withdrawal,ministatement,pinchange,balanceenquiry,exit;
    String pinnumber;
    Transactions(String pinnumber){
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

        JLabel text=new JLabel("Please select your Transaction");
        text.setBounds(215,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);// add to image inorder to be visible in image itself

        deposit= new JButton("Deposit");
        deposit.setFont(new Font("System",Font.BOLD,12));
        deposit.setBounds(150,400,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        withdrawal= new JButton("Cash Withdrawal");
        withdrawal.setFont(new Font("System",Font.BOLD,12));
        withdrawal.setBounds(350,400,150,30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        fastcash= new JButton("Fast Cash");
        fastcash.setFont(new Font("System",Font.BOLD,12));
        fastcash.setBounds(150,430,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        ministatement= new JButton("Mini Statement");
        ministatement.setFont(new Font("System",Font.BOLD,12));
        ministatement.setBounds(350,430,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        pinchange= new JButton("Pin change");
        pinchange.setFont(new Font("System",Font.BOLD,12));
        pinchange.setBounds(150,460,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        balanceenquiry= new JButton("Balance Enquiry");
        balanceenquiry.setFont(new Font("System",Font.BOLD,12));
        balanceenquiry.setBounds(350,460,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        exit= new JButton("Exit");
        exit.setFont(new Font("System",Font.BOLD,12));
        exit.setBounds(350,490,150,30);
        exit.addActionListener(this);
        image.add(exit);
        setUndecorated(true);//to make the border box invisible.ALso can't able to close the output since close button will be invisible
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==exit){
        System.exit(0);
    }else if(ae.getSource()==deposit){
        setVisible(false);
        new Deposit(pinnumber).setVisible(true);
    }else if(ae.getSource()==withdrawal){
        setVisible(false);
        new Withdrawl(pinnumber).setVisible(true);
    }else if(ae.getSource()==fastcash){
        setVisible(false);
        new FastCash(pinnumber).setVisible(true);
    }else if(ae.getSource()==pinchange){
        setVisible(false);
        new PinChange(pinnumber).setVisible(true);
    }else if(ae.getSource()==balanceenquiry){
        setVisible(false);
        new BalanceEnquiry(pinnumber).setVisible(true);
    }else if(ae.getSource()==ministatement){
        new MiniStatement(pinnumber).setVisible(true);
    }
    }

    public static void main(String[] args) {
        new Transactions("");
    }
}
