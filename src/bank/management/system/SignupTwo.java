package bank.management.system;

import javax.swing.*;
import java.awt.*;//color is within this
import java.awt.event.*;
import java.util.*; //random number
import com.toedter.calendar.JDateChooser;
//JDBC connectivity is more important......

public class SignupTwo extends JFrame implements ActionListener {
    //make every variable global inorder to connect to mysql
    long random;
    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category,education,income,occupation;
    String formno;
    SignupTwo(String formno){
        this.formno=formno;
        getContentPane().setBackground(Color.WHITE);
        setSize(1000,900);
        setLocation(350,200);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        setLayout(null);
        Random ran=new Random();
        random=Math.abs(ran.nextLong() % 9000L)+1000L;

        JLabel additionaldetils=new JLabel("Page 2: Additional Details");
        additionaldetils.setFont(new Font("Raleway",Font.BOLD,23));
        additionaldetils.setBounds(300,80,400,40);
        add( additionaldetils);

        JLabel name=new JLabel("Religion:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(120,200,100,30);
        add(name);

        String valReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(350,200,250,30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel fathername=new JLabel("Category:");
        fathername.setFont(new Font("Raleway",Font.BOLD,20));
        fathername.setBounds(120,250,200,30);
        add(fathername);

        String ValCategory[]={"General","OBC","SC","ST","Other"};
        category = new JComboBox(ValCategory);
        category.setBounds(350,250,250,30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel dob=new JLabel("Income:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(120,300,200,30);
        add(dob);

        String IncomeCategory[]={"Null","<2 Lakhs","< 3 Lakhs","< 5 Lakhs"," Upto 10 Lakhs"," More than 10 Lakhs"};
        income = new JComboBox(IncomeCategory);
        income.setBounds(350,300,250,30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel gender=new JLabel("Educational");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(120,350,200,30);
        add(gender);
        JLabel email=new JLabel("Qualification:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(120,380,200,30);
        add(email);

        String educationValues[]={"Higher Secondary","Bachelor","Master","Doctorate"," Others"};
        education = new JComboBox(educationValues);
        education.setBounds(350,365,250,30);
        education.setBackground(Color.WHITE);
        add(education);


        JLabel martial=new JLabel("Occupation:");
        martial.setFont(new Font("Raleway",Font.BOLD,20));
        martial.setBounds(120,450,200,30);
        add(martial);


        String ocupationValues[]={"Salaried","Self","Business","Student","Retired"};
        occupation= new JComboBox(ocupationValues);
        occupation.setBounds(350,450,250,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);


        JLabel address=new JLabel("PAN Number:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(120,500,200,30);
        add(address);
        pan=new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,15));
        pan.setBounds(350,500,250,30);
        add(pan);

        JLabel city=new JLabel("Aadhar Number:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(120,550,200,30);
        add(city);
        aadhar=new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,15));
        aadhar.setBounds(350,550,250,30);
        add(aadhar);

        JLabel state=new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(120,600,200,30);
        add(state);

        syes=new JRadioButton("Yes");
        syes.setBounds(350,600,100,30);
        syes.setFont(new Font("Raleway",Font.TRUETYPE_FONT,18));
        syes.setBackground(Color.WHITE);
        add(syes);
        sno=new JRadioButton("N0");
        sno.setBounds(450,600,150,30);
        sno.setFont(new Font("Raleway",Font.TRUETYPE_FONT,18));
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup senior= new ButtonGroup();//group the buttons so only one will be selected.
        senior.add(syes);senior.add(sno);


        JLabel pincode=new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(120,650,200,30);
        add(pincode);


        eyes=new JRadioButton("Yes");
        eyes.setBounds(350,650,100,30);
        eyes.setFont(new Font("Raleway",Font.TRUETYPE_FONT,18));
        eyes.setBackground(Color.WHITE);
        add(eyes);
        eno=new JRadioButton("N0");
        eno.setBounds(450,650,150,30);
        eno.setFont(new Font("Raleway",Font.TRUETYPE_FONT,18));
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup existing= new ButtonGroup();//group the buttons so only one will be selected.
        existing.add(eyes);existing.add(eno);

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
        String sreligion = (String)religion.getSelectedItem();//return a object
        String scategory= (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();//t get the selected item from combo box.
        String soccupation =(String)occupation.getSelectedItem();
        String seniorcitizen=null;
        if(syes.isSelected()){
            seniorcitizen="Yes";
        }
        else if(sno.isSelected()){
            seniorcitizen="No";
        }
        String existingaccount=null;
        if(eyes.isSelected()){
            existingaccount="Yes";
        }
        else if(eno.isSelected()){
            existingaccount="No";
        }
        String span=pan.getText();
        String saadhar=aadhar.getText();

        try{//validation
                Conn c = new Conn();
                //4.sql querry
                //should match with number of coloumns of table created in the name.
                String query = "insert into signuptwo values('"+formno+"','"+sreligion+"', '"+scategory+"', '"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
                c.s.executeUpdate(query);//5.Execute query
                //SignUp3 object if we have 3rd page of details.
                setVisible(false);
                new SignupThree(formno).setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        new SignupTwo("");//empty argument for a constructor.
    }

}
