package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
    public static void main(String[] args) {
        DepartmentDao dd = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1 INSERT ===");
        Department dp = new Department(null, "Exotic Itens");
        dd.insert(dp);

        System.out.println("Inserted! New id = " + dp.getId());
    }
}
