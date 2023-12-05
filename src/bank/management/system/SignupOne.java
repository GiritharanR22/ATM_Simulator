package bank.management.system;

import javax.swing.*;
import java.awt.*;//color is within this
import java.awt.event.*;
import java.util.*; //random number
import com.toedter.calendar.JDateChooser;
//JDBC connectivity is more important......

public class SignupOne extends JFrame implements ActionListener {
//make every variable global inorder to connect to mysql
    long random;
    JTextField nameTF,fnameTF,femail,dobTextField,fstate,faddress,fpincode,fcity;
    JButton next;
    JRadioButton male,female,other,married,unmarried;
    JDateChooser datechooser;
    SignupOne(){
        getContentPane().setBackground(Color.WHITE);
        setSize(1000,900);
        setLocation(350,200);
        setLayout(null);
        Random ran=new Random();
        random=Math.abs(ran.nextLong() % 9000L)+1000L;

        JLabel formno=new JLabel("APPLICATION FORM NO. "+ random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(200,20,600,40);
        add(formno);

        JLabel persondetils=new JLabel("Page 1: Personal Details");
        persondetils.setFont(new Font("Raleway",Font.BOLD,23));
        persondetils.setBounds(300,80,400,40);
        add( persondetils);

        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(120,200,100,30);
        add(name);
        nameTF=new JTextField();
        nameTF.setFont(new Font("Raleway",Font.BOLD,15));
        nameTF.setBounds(350,200,250,30);
        add(nameTF);

        JLabel fathername=new JLabel("Father's Name:");
        fathername.setFont(new Font("Raleway",Font.BOLD,20));
        fathername.setBounds(120,250,200,30);
        add(fathername);
        fnameTF=new JTextField();
        fnameTF.setFont(new Font("Raleway",Font.BOLD,15));
        fnameTF.setBounds(350,250,250,30);
        add(fnameTF);

        JLabel dob=new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(120,300,200,30);
        add(dob);

        datechooser=new JDateChooser();
        datechooser.setBounds(350,300,250,30);
        datechooser.setForeground(new Color(105,105,105));
        add(datechooser);

        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(120,350,200,30);
        add(gender);

        male=new JRadioButton("Male");
        male.setBounds(350,350,70,30);
        male.setFont(new Font("Raleway",Font.TRUETYPE_FONT,14));
        male.setBackground(Color.WHITE);
        add(male);
        female=new JRadioButton("Female");
        female.setBounds(420,350,80,30);
        female.setFont(new Font("Raleway",Font.TRUETYPE_FONT,14));
        female.setBackground(Color.WHITE);
        add(female);
        other=new JRadioButton("Other");
        other.setBounds(500,350,80,30);
        other.setFont(new Font("Raleway",Font.TRUETYPE_FONT,14));
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup gendergroup= new ButtonGroup();//group the buttons so only one will be selected.
        gendergroup.add(male);gendergroup.add(female);gendergroup.add(other);

        JLabel email=new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(120,400,200,30);
        add(email);
        femail=new JTextField();
        femail.setFont(new Font("Raleway",Font.BOLD,15));
        femail.setBounds(350,400,250,30);
        add(femail);

        JLabel martial=new JLabel("Martial Status:");
        martial.setFont(new Font("Raleway",Font.BOLD,20));
        martial.setBounds(120,450,200,30);
        add(martial);
        married=new JRadioButton("Married");
        married.setBounds(350,450,100,30);
        married.setFont(new Font("Raleway",Font.TRUETYPE_FONT,18));
        married.setBackground(Color.WHITE);
        add(married);
        unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(450,450,150,30);
        unmarried.setFont(new Font("Raleway",Font.TRUETYPE_FONT,18));
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        ButtonGroup maritalgroup= new ButtonGroup();//group the buttons so only one will be selected.
        maritalgroup.add(married);maritalgroup.add(unmarried);

        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(120,500,200,30);
        add(address);
        faddress=new JTextField();
        faddress.setFont(new Font("Raleway",Font.BOLD,15));
        faddress.setBounds(350,500,250,30);
        add(faddress);

        JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(120,550,200,30);
        add(city);
        fcity=new JTextField();
        fcity.setFont(new Font("Raleway",Font.BOLD,15));
        fcity.setBounds(350,550,250,30);
        add(fcity);

        JLabel state=new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(120,600,200,30);
        add(state);
        fstate=new JTextField();
        fstate.setFont(new Font("Raleway",Font.BOLD,15));
        fstate.setBounds(350,600,250,30);
        add(fstate);

        JLabel pincode=new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(120,650,200,30);
        add(pincode);
        fpincode=new JTextField();
        fpincode.setFont(new Font("Raleway",Font.BOLD,15));
        fpincode.setBounds(350,650,250,30);
        add(fpincode);

        next=new JButton("Next");
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.setFont(new Font("Raleway",Font.BOLD,15));
        next.setBounds(500,720,100,40);
        next.addActionListener(this);//to add action when button is clicked
        add(next);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        String formno="" +random;//to connvert long to string put String name = ""+long;
        String  name = nameTF.getText();
        String  fname= fnameTF.getText();
        String dob = ((JTextField)datechooser.getDateEditor().getUiComponent()).getText();
        String gender= null;
        if(male.isSelected()){
            gender="Male";
        }
        else if(female.isSelected()){
            gender="Female";
        }
        else if(other.isSelected()){
            gender="Other";
        }
        String email= femail.getText();
        String marital=null;
        if(married.isSelected()){
            marital="Married";
        }
        else if(unmarried.isSelected()){
            marital="Unmarried";
        }
        String city=fcity.getText();
        String address=faddress.getText();
        String state=fstate.getText();
        String pin= fpincode.getText();

        try{//validation
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name field should not be empty");
            }
            else{
                Conn c = new Conn();
                //4.sql querry
                //should match with number of coloumns of table created in the name.
                String query = "insert into signup values('"+formno+"','"+name+"', '"+fname+"', '"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);//5.Execute query

                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }

        }catch(Exception e){
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        new SignupOne();
    }

}
