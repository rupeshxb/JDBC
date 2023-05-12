package com.company.javaJDBC;
import java.sql.*;

public class UpdateOperation {
    public static void main(String args[]) throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
            
        }
        catch(Exception e){

        }
    }

    public static void UpdateOperation(){

    }
}
