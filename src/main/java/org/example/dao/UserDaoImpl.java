package org.example.dao;

import org.example.Util.Util;
import org.example.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{

    @Override
    public void createUsersTable() {
        String query = " CREATE TABLE if NOT EXISTS users (id int, first_name VARCHAR(20) NOT NULL,last_name VARCHAR(20) NOT NULL,age int )";
        try {
            Statement statement = Util.connection().createStatement();
            statement.execute(query);
            System.out.println("Successfully Created");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dropUsersTable() {
     String drop = "drop table users";
     try {
         Statement statement = Util.connection().createStatement();
         statement.execute(drop);
         System.out.println("Successfully drop");
     }catch (SQLException e){
         System.out.println(e.getMessage());
     }
    }

    @Override
    public void saveUser(long id,String name, String lasName ,byte age) {
        String sql = "INSERT INTO users(id, name, lastName, age) VALUES (?, ?, ?, ?)";
        try (Connection connect = Util.connection();
             PreparedStatement preparedStatement = connect.prepareStatement(sql)) {
            preparedStatement.setInt(1, (int) id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, lasName);
            preparedStatement.setInt(4, age);
            preparedStatement.executeUpdate();
            System.out.println("Table saved successfully...");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeUserById(long id) {
    String delete = "delete from users where id = ?";
    try (Connection connection = Util.connection()){
        PreparedStatement statement = (PreparedStatement) connection.createStatement();
        statement.execute(delete);
        System.out.println("Successfully delete");
    }catch (SQLException e){
        System.out.println(e.getMessage());
    }
    }

    @Override
    public List<User> getAllUsers() {
        String SQL = "SELECT * FROM users";
        ArrayList<User> user = new ArrayList<>();
        try {Connection connection = Util.connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            user.add((User) resultSet);
            while (resultSet.next()){
                System.out.println(resultSet.getInt("fistName") + ""+ resultSet.getString("lastName")+
                        resultSet.getInt("age"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    @Override
    public void cleanUsersTable() {
        String drop = "truncate table users ";
        try {
            Statement statement = Util.connection().createStatement();
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
              try (Connection connection = Util.connection()){
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
