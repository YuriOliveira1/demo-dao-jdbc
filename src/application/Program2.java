package application;

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

        sc.close();
    }
}
