package Model;

import java.util.Scanner;

public class Admin {
    private final String username = "admin";
    private final String password = "1234";

    public boolean login(Scanner sc) {
        System.out.println("===== ADMIN LOGIN =====");
        System.out.print("Username: ");
        
        String user = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();
        
        if (user.equals(username) && pass.equals(password)) {
            System.out.println("Login Successful!");
            return true;
        } else {
            System.out.println("Invalid Username or Password!");
            return false;
        }
        
    }
}
