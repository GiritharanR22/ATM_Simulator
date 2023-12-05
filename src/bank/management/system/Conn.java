package bank.management.system;
/*JDBC CONNECTION STEPS
1. Register the driver.
2. Create Connection
3. Create Statement
4. Execute Query
5. Close Connection.
 */

import java.sql.*;//Importing necessary packages : SQL
public class Conn {
    //create connection
    Connection c;
    //create statement
    Statement s;
    public Conn() {
        try{
            //add jar file for connectormysql to work in mysql
            //Class.forName(com.mysql.cj.jdbc.Driver);
            c= DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Win@2024");//c= DriverManager.getConnection(url)
            s = c.createStatement();

        }catch(Exception e){
            System.out.println(e);
        }
    }

}

