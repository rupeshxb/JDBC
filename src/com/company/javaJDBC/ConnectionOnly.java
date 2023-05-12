package com.company.javaJDBC;
import java.sql.*;

public class ConnectionOnly {
    public static void main(String[] args) throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection newConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306",
                    "root","root");
            if(newConnection!=null)
            {
                System.out.println("Connection Successful.");
            }
            else{
                System.out.println("Connection Unsuccessful.");
            }
            newConnection.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
