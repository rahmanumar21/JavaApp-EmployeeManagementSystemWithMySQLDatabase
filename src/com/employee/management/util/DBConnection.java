package com.employee.management.util;

import java.sql.*;

public class DBConnection {

    static Connection con;

    public static Connection dbConnection() {

        DBConnection db = new DBConnection();

        try {

            // jdbc driver
            Class.forName("com.mysql.jdbc.Driver");

            // driver manager
            con = DriverManager.getConnection(Config.url + Config.database, Config.name, Config.password);

            // create table
            if (con != null) {

                if (!db.checkTableExists()) {

                    String query = "CREATE TABLE " + Config.table +
                            "(id INTEGER not NULL AUTO_INCREMENT, " +
                            " name VARCHAR(45), " +
                            " salary INTEGER, " +
                            " age INTEGER, " +
                            " PRIMARY KEY ( id ))";

                    try {

                        Statement st = con.createStatement();
                        st.executeUpdate(query);

                    }

                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return con;

    }

    boolean checkTableExists() throws SQLException {

        boolean check = false;
        DatabaseMetaData dbm = con.getMetaData();

        try {

            ResultSet rs = dbm.getTables(null, null, Config.table, null);

            if (rs.next()) {

                check = true;

            } else {

                check = false;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return check;

    }
}
