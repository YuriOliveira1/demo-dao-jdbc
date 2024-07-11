package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DepartmentDao dd = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1 INSERT ===");
        Department dp = new Department(null, "Exotic Itens");
        dd.insert(dp);

        System.out.println("Inserted! New id = " + dp.getId());

        System.out.println("=== TEST 2 DELETE ===");
        System.out.print("Enter id for Delete: ");
        int id = sc.nextInt();
        dd.deleteById(id);

        System.out.println("=== TEST 3 UPDATE ===");
        dp = dd.findById(1);
        dp.setName("Xambrulitos");
        dd.update(dp);
        sc.close();

        System.out.println("=== TEST 4 FindById ===");
        dp = dd.findById(1);
        System.out.println(dp);

        System.out.println("=== TEST 5 FindAll ===");

        List<Department> departments = dd.findAll(); 
        for (Department department : departments) {
            System.out.println(department);
        }

    }
}
