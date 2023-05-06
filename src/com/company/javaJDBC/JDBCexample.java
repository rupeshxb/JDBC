// import packages
package com.company.javaJDBC;
import java.sql.*;

public class JDBCexample {
    public static void main(Strings args[]) throws SQLException{
        try{
            // load or register drivers
            Class.forName("com.mysql.jdbc.Driver");
            // connecting to a database
            // here demo is database name, root is username and root is password
            Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
            // creating a statement object
            // statement object will be used to run queries
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from students");
            while (rs.next()) {

            }

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}


