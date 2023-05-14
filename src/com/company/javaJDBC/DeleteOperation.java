package com.company.javaJDBC;
import java.rmi.server.ExportException;
import java.sql.*;

public class DeleteOperation {
    public static void main(String[] args) throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection newConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
            int roll_no=4;
            deleteStudent(newConnection, roll_no);
            newConnection.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static void deleteStudent(Connection connection,int roll_no) throws SQLException{
        String sql_query = "delete from students where roll_no=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql_query);
        preparedStatement.setInt(1,roll_no);
        int isResult = preparedStatement.executeUpdate();
        if(isResult>0){
            System.out.println("User deleted");
        }
        else{
            System.out.println("User not deleted");
        }
        preparedStatement.close();
    }
}
