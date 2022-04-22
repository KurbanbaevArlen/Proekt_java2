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
        UserDaoImpl userDao = new UserDaoImpl();
//        userDao.createUsersTable();
//        userDao.dropUsersTable();
        userDao.saveUser(1,"Arlen","Kurbanbaev", (byte) 21);
//        userDao.getAllUsers();
//        userDao.removeUserById(1);
//        userDao.cleanUsersTable();
//        userDao.existsByFirstName("Arlen");

    }
}