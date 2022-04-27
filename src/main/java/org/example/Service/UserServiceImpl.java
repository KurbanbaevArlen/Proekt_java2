package org.example.Service;

import org.example.Util.Util;
import org.example.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserServiceImpl implements UserService{
    @Override
    public void createUsersTable() {
String create = " CREATE TABLE User(first_name VARCHAR(20),last_name VARCHAR(20),age int )";
        try {
            Statement statement = Util.getConnection().createStatement();
            statement.execute(create);
            System.out.println("Successfully Created");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dropUsersTable() {
String drop = "DROP TABLE User";
        try {
            Statement statement = Util.getConnection().createStatement();
            statement.execute(drop);
            System.out.println("Successfully Droping");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
String sql = "insert into users(name,lastName,age) values(?,?,?)";
        try (Connection conn = Util.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setInt(3, age);
            statement.executeUpdate();
            System.out.println("Successfully added : " + name);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void removeUserById(long id) {
String dropId = "delete from student where id = id";
        try {
            Statement statement = Util.getConnection().createStatement();
            statement.execute(dropId);
            System.out.println("Successfully delete id");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {
        String print = "select * from user";
        try{
            Statement statement = Util.getConnection().createStatement();
            statement.execute(print);
            System.out.println("Successfully info users");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void cleanUsersTable() {
String drop = "truncate table users ";
        try {
            Statement statement = Util.getConnection().createStatement();
            statement.execute(drop);
            System.out.println("Successfully drop");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean existsByFirstName(String firstName) {
String sql = "select * from users where first_name = Arlen";
        if (firstName.equals(sql)){
            try (Connection connection = Util.getConnection()){
                PreparedStatement statement = (PreparedStatement) connection.createStatement();
                statement.execute(sql);
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
            return true;
        }else
        return false;
    }
}
