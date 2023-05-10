package com.company.javaJDBC;
import java.sql.*;

public class CreateOperationJDBC {
    public static void main(String args[]) throws SQLException{
        try{
            // Create a new connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");

            // creating a user defined function for create operation
            int roll_no = 4;
            String first_name = "Pablo";
            String last_name = "Escobar";
            int age = 23;
            createNewStudent(con,roll_no,first_name,last_name,age);

            // close the connection
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    // method definition
    public static void createNewStudent(Connection con, int roll_no, String first_name, String last_name, int age) throws SQLException{
        String sql_query = "INSERT INTO students(roll_no,first_name,last_name,age) values (?,?,?,?)";
        PreparedStatement statement = con.prepareStatement(sql_query);
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
