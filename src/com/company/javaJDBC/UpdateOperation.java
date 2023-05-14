package com.company.javaJDBC;
import java.sql.*;

public class UpdateOperation {
    public static void main(String args[]) throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection newConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo",
                    "root","root");
            int updated_roll_no = 7;
            String first_name = "Che";
            String updated_last_name = "BinLaden";
            int updated_age = 22;
            updateStudent(newConnection,updated_roll_no, first_name, updated_last_name, updated_age);
            newConnection.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static void updateStudent(Connection newConnection,int roll_no,
                                     String first_name, String last_name,int age) throws SQLException {
        String sql_query = "Update students SET roll_no=?, last_name=?,age=? where first_name= ?";
        PreparedStatement Statement = newConnection.prepareStatement(sql_query);
        // Parameter Index must match to parameters of query not to database
        Statement.setInt(1, roll_no);
        Statement.setString(2, last_name);
        Statement.setInt(3,age);
        Statement.setString(4, first_name);
        int rowsUpdated = Statement.executeUpdate();
        if(rowsUpdated>0){
            System.out.println("The student was updated.");
        }
        else{
            System.out.println("The student was not updated.");
        }
        Statement.close();
    }
}
