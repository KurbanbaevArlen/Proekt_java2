package org.example;

import org.example.Service.UserServiceImpl;
import org.example.Util.Util;
import org.example.dao.UserDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
 UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.dropUsersTable();
        userService.saveUser(1,"Arlen","Kurbanbaev", (byte) 21);
        userService.getAllUsers();
        userService.removeUserById(1);
        userService.cleanUsersTable();
        userService.existsByFirstName("Arlen");
    }
}
