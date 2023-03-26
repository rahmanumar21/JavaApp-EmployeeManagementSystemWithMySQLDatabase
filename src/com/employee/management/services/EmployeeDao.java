package com.employee.management.services;

import com.employee.management.model.Employee;
import com.employee.management.util.Config;
import com.employee.management.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDao implements EmployeeDaoInterface {

    // db connection
    Connection con;

    @Override
    public void createEmployee(Employee emp) {

        con = DBConnection.dbConnection();

        String query = "INSERT INTO " + Config.table +" VALUES(?,?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, emp.getId());
            ps.setString(2, emp.getName());
            ps.setDouble(3, emp.getSalary());
            ps.setInt(4, emp.getAge());

            int insert = ps.executeUpdate();

            if (insert != 0) {
                System.out.println("Inserted Successfully !!!\n");
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void showAllEmployee() {

        con = DBConnection.dbConnection();

        String query = "SELECT * FROM " + Config.table;

        System.out.println(Config.table + "Details: ");
        System.out.printf("%s\t%s\t%s\t%s\n",
                "ID", "Name", "Salary", "Age");

        System.out.println("----------------------------------------------");
        try {

            Statement st = con.createStatement();
            ResultSet result = st.executeQuery(query);

            while (result.next()) {
                System.out.printf("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4)
                );

                System.out.println("----------------------------------------------");

            }

        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void showEmployeeBasedOnID(int id) {

        con = DBConnection.dbConnection();

        String query = "SELECT * FROM " + Config.table + " WHERE id = " + id;

        System.out.printf("%s\t%s\t%s\t%s\n", "ID", "Name", "Salary", "Age");
        System.out.println("------------------------------------------------------------");

        try {

            Statement st = con.createStatement();
            ResultSet result = st.executeQuery(query);

            while (result.next()) {
                System.out.printf("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4)
                );

                System.out.println("----------------------------------------------");

            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(int id, String name) {

        con = DBConnection.dbConnection();

        String query = "UPDATE " + Config.table + " SET name=? WHERE id=?";

        try {

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, id);

            int update = ps.executeUpdate();

            if (update != 0) {
                System.out.println(id + " has been updated\n");
            }
            else {
                System.out.println(id + " has not been updated !!!\n");
            }

        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {

        con = DBConnection.dbConnection();

        String query = "DELETE FROM " + Config.table + " WHERE id = ?";

        try {

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            int delete = ps.executeUpdate();

            if (delete != 0) {
                System.out.println(id + " has been deleted !!!\n");
            }

        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
