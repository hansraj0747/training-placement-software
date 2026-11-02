package service;

import java.util.ArrayList;
import java.util.Scanner;
import Model.Student;
import Model.Admin;
import Model.Company;

public class TPOManagementSystem {
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Company> companies = new ArrayList<>();

    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        Admin admin = new Admin();
        if (!admin.login(sc)) {
            sc.close();
            return;
        }

        while (true) {
            System.out.println("\n===== TPO MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Add Company");
            System.out.println("5. View Companies");
            System.out.println("6. Check Eligibility");
            System.out.println("7. Exit");
            System.out.println("8. Update Student");
            System.out.println("9. Delete Student");
            System.out.print("Enter Choice: ");

            int choice = readInt(sc);
             
            switch (choice) {
                case 1:
                    System.out.print("Student ID: ");
                    int id = readInt(sc);
                    sc.nextLine();

                    System.out.print("Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Branch: ");
                    String branch = sc.nextLine();

                    System.out.print("CGPA: ");
                    double cgpa = readDouble(sc);

                    students.add(new Student(id, name, branch, cgpa));
                    System.out.println("Student Added Successfully!");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No Student Record Found!");
                    } else {
                        for (Student s : students) {
                            s.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    int searchId = readInt(sc);
                    boolean found = false;

                    for (Student s : students) {
                        if (s.getId() == searchId) {
                            s.display();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student Not Found!");
                    }
                    break;

                case 4:
                    System.out.print("Company ID: ");
                    int cid = readInt(sc);
                    sc.nextLine();

                    System.out.print("Company Name: ");
                    String cname = sc.nextLine();

                    System.out.print("Minimum CGPA: ");
                    double min = readDouble(sc);

                    companies.add(new Company(cid, cname, min));
                    System.out.println("Company Added Successfully!");
                    break;

                case 5:
                    if (companies.isEmpty()) {
                        System.out.println("No Company Record Found!");
                    } else {
                        for (Company c : companies) {
                            c.display();
                        }
                    }
                    break;

                case 6:
                    System.out.print("Enter Student ID: ");
                    int sid = readInt(sc);
                    Student student = null;

                    for (Student s : students) {
                        if (s.getId() == sid) {
                            student = s;
                            break;
                        }
                    }

                    if (student == null) {
                        System.out.println("Student Not Found!");
                    } else {
                        System.out.println("\nEligible Companies:");
                        boolean eligible = false;

                        for (Company c : companies) {
                            if (student.getCgpa() >= c.getMinCgpa()) {
                                System.out.println(c.getCompanyName());
                                eligible = true;
                            }
                        }

                        if (!eligible) {
                            System.out.println("No Eligible Company Found.");
                        }
                    }
                    break;

                case 7:
                    System.out.println("Thank You!");
                    sc.close();
                    return;

                case 8:
                    System.out.print("Enter Student ID to Update: ");
                    int updateId = readInt(sc);
                    sc.nextLine();
                    boolean updated = false;

                    for (Student s : students) {
                        if (s.getId() == updateId) {
                            System.out.print("Enter New Name: ");
                            String newName = sc.nextLine();

                            System.out.print("Enter New Branch: ");
                            String newBranch = sc.nextLine();

                            System.out.print("Enter New CGPA: ");
                            double newCgpa = readDouble(sc);

                            s.setName(newName);
                            s.setBranch(newBranch);
                            s.setCgpa(newCgpa);

                            System.out.println("Student Updated Successfully!");
                            updated = true;
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Student Not Found!");
                    }
                    break;

                case 9:
                    System.out.print("Enter Student ID to Delete: ");
                    int deleteId = readInt(sc);
                    boolean deleted = false;

                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getId() == deleteId) {
                            students.remove(i);
                            System.out.println("Student Deleted Successfully!");
                            deleted = true;
                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("Student Not Found!");
                    }
                    break;

                default:
                    System.out.println("Invalid Choice!");
           
            }
        }
    }

    private int readInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Please enter a whole number: ");
            sc.next();
        }
        return sc.nextInt();
    }

    private double readDouble(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.print("Please enter a valid number: ");
            sc.next();
        }
        return sc.nextDouble();
    }
}
