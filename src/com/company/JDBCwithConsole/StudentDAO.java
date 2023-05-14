// DAO stands for Database Access Object. It interacts with database. It is a design pattern.

package com.company.JDBCwithConsole;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private Connection connection;

    // Constructor
    public StudentDAO() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/student_db";
        String username = "root";
        String password = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url, username, password);
    }

    // CREATE operation
    public int addStudent(Student student) throws SQLException {
        String query = "INSERT INTO student(name, email, phone) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getEmail());
        preparedStatement.setString(3, student.getPhone());
        preparedStatement.executeUpdate();
        ResultSet rs = preparedStatement.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            student.setId(id);
            return id;
        } else {
            return -1; // return -1 if no ID was generated
        }
    }


    // READ operation
    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM student";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String phone = resultSet.getString("phone");
            Student student = new Student(id,name, email, phone);
            students.add(student);
        }
        return students;
    }

    // UPDATE operation
    public boolean updateStudent(Student student) throws SQLException {
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE student SET name=?, email=?, phone=? WHERE id=?");
            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setString(3, student.getPhone());
            statement.setInt(4, student.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                result = true;
            }
            //connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;

    }

    public Student getStudentById(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student WHERE id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String phone = resultSet.getString("phone");
            Student student = new Student(id, name, email, phone);
            return student;
        } else {
            return null;
        }
    }

    public boolean deleteStudent(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM student WHERE id=?");
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}

