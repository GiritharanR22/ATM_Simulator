package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//extends Jframe only used for textfields and buttons and frame creation and setting bounds and colours.

public class Login extends JFrame implements ActionListener{

    JButton Signin ,Clear, Signup;//declare globally inorder to use in actionlistener within the same class.
    JTextField card;
    JPasswordField pass;//to make the password in passwordfield not in textfield so that entered values will not be visible
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setSize(900,600);//Size of the frame , length 800 and breadth 480.
        setLayout(null);
        setLocation(350,200);//set the frame in position from left x and top y or set it in center using x and y coordinates from left and top.
        ImageIcon l1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image l2=l1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);//to change image scale convert icon to image which is awt property.
        ImageIcon l3=new ImageIcon(l2);//once again convert to image icon to add as label
        JLabel label=new JLabel(l3);
        label.setBounds(20,10,100,100);//to make the adjustments on where to lie
        getContentPane().setBackground(Color.WHITE);//background of icon setting way
        add(label);

        JLabel text=new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward",Font.BOLD,35));
        text.setBounds(150,30,400,50);
        add(text);
        JLabel cardno=new JLabel("CARD NO     :");
        cardno.setFont(new Font("Raleway",Font.BOLD,20));
        cardno.setBounds(150,100,200,30);
        add(cardno);

        JLabel password=new JLabel("PASSWORD :");
        password.setFont(new Font("Raleway",Font.BOLD,20));
        password.setBounds(150,150,200,30);
        add(password);
        pass=new JPasswordField();
        pass.setBounds(300,150,200,30);
        pass.setFont(new Font("Arial",Font.BOLD,12));
        add(pass);

        card=new JTextField();
        card.setBounds(300,100,200,30);
        card.setFont(new Font("Arial",Font.BOLD,12));
        add(card);

        Signin=new JButton("LOG IN");
        Signin.setBackground(Color.black);
        Signin.setForeground(Color.WHITE);
        Signin.addActionListener(this);
        Signin.setBounds(300,200,90,50);
        add(Signin);

        Clear=new JButton("CLEAR");
        Clear.setBackground(Color.black);
        Clear.setForeground(Color.WHITE);
        Clear.setBounds(410,200,90,50);
        Clear.addActionListener(this);
        add(Clear);

        Signup=new JButton("SIGN UP");
        Signup.setBackground(Color.black);
        Signup.setForeground(Color.WHITE);
        Signup.setBounds(300,260,200,50);
        Signup.addActionListener(this);
        add(Signup);

        setVisible(true);//If we put this line in starting of code then all the textfields should be clicked and buttons should be hovered by mouse to be visible.
    }
    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {//ae actionevent object
        if(ae.getSource()==Clear){//define textfields also globally
            //card.setText("Code for interview"); used to set text in textfields.
            card.setText("");
            pass.setText("");

        }
        else if(ae.getSource()==Signin){
            Conn conn= new Conn();
            String cardnumber=card.getText();
            String pinnumber= pass.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"'and pin ='"+pinnumber+"'";
            try{
                ResultSet rs= conn.s.executeQuery(query);//RESULTSET
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or pin");
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==Signup){
            setVisible(false);//to close login frame
            new SignupOne().setVisible(true);//to open signup frame

        }
    }
}
