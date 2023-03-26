package com.employee.management;

import com.employee.management.model.Employee;
import com.employee.management.services.EmployeeDao;
import com.employee.management.services.EmployeeDaoInterface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        EmployeeDaoInterface dao = new EmployeeDao();
        Scanner input = new Scanner(System.in).useDelimiter("\n");

        int id, age;
        String name;
        double salary;

        System.out.println("Welcome to Employee Application\n");

        do {

            try {

                System.out.println(
                        "1. Add Employee\n" +
                                "2. Show All Employee\n" +
                                "3. Show Employee Based on ID\n" +
                                "4. Update Employee\n" +
                                "5. Delete Employee\n"
                );

                System.out.println("Choose menu:");
                int menu = input.nextInt();

                switch (menu) {

                    case 1:

                        System.out.println("Enter ID:");
                        id = input.nextInt();
                        System.out.println("Enter name:");
                        name = input.next();
                        System.out.println("Enter salary:");
                        salary = input.nextDouble();
                        System.out.println("Enter age:");
                        age = input.nextInt();

                        Employee emp = new Employee(id, name, salary, age);
                        dao.createEmployee(emp);

                        System.out.println(emp);

                        break;
                    case 2:

                        dao.showAllEmployee();

                        break;
                    case 3:

                        System.out.println("Enter id to show the details:");
                        id = input.nextInt();
                        dao.showEmployeeBasedOnID(id);

                        break;
                    case 4:

                        System.out.println("Enter ID:");
                        id = input.nextInt();

                        System.out.println("Enter Name:");
                        name = input.next();

                        dao.updateEmployee(id, name);

                        break;
                    case 5:

                        System.out.println("Enter ID:");
                        id = input.nextInt();

                        dao.deleteEmployee(id);

                        break;
                    default:
                        System.out.println("Please enter menu number (1 - 5)");

                }
            }

            catch (Exception e) {
                System.out.println(e);
                break;
            }

        } while (true);
    }
}
