/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rentalcars.dal;

import java.sql.*;

/**
 *
 * @author alefsilva
 */
public class ModuleConnection {

    public static Connection connect() {
        java.sql.Connection connection = null;

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/rental_cars?useSSL=false";
        String user = "root";
        String password = "root";

        try {

            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            return connection;

        } catch (Exception e) {
            System.out.println(e);
            return null;

        }

    }

}
