package application;


import java.util.Date;
import java.util.List;
import java.util.Scanner;


import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("=== TESTE 1: seller FindById ===");
        Seller seller = sellerDao.findById(3);
        
        System.out.println(seller);

        System.out.println("\n=== TESTE 1: seller FindByDep ===");
        Department dp = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(dp);

        for (Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n=== TESTE 3: seller FindAll ===");
        list = sellerDao.findAll();

        for (Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n=== TESTE 4: seller insert ===");
        Seller newSeller = new Seller(null, "John", "John@gamil.com", new Date(), 1750.50, dp);

        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("\n=== TESTE 5: seller UPDATE ===");
        seller = sellerDao.findById(1);
        seller.setName("Robert Camp");
        sellerDao.update(seller);
        System.out.println("Update Completed");

        System.out.println("\n=== TESTE 6: seller DELETE ===");
        System.out.print("Enter id for delete: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Deleted Completed");

        sc.close();
    }
}
