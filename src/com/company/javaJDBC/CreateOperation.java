package com.company.javaJDBC;
import java.sql.*;

public class CreateOperation {
    public static void main(String args[]) throws SQLException{
        try{
            // load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Create a new connection
            Connection newConnection=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");

            // creating a user defined function for create operation
            int roll_no = 6;
            String first_name = "Che";
            String last_name = "Guevara";
            int age = 23;
            createNewStudent(newConnection,roll_no,first_name,last_name,age);

            // close the connection
            newConnection.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    // method definition
    public static void createNewStudent(Connection newConnection, int roll_no, String first_name, String last_name, int age) throws SQLException{
        String sql_query = "INSERT INTO students(roll_no,first_name,last_name,age) values (?,?,?,?)";
        PreparedStatement statement = newConnection.prepareStatement(sql_query);
        statement.setInt(1,roll_no);
        statement.setString(2,first_name);
        statement.setString(3,last_name);
        statement.setInt(4,age);

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0){
            System.out.println("A new student was added.");
        }
        statement.close();
    }
}
