package application;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {
    public static void main(String[] args) {
        Department dp = new Department(2, "Eletronics");
        Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 1750.0, dp);
        System.out.println(seller);
    }
}
