package Model;

public class Company {
    private int companyId;
    private String companyName;
    private double minCgpa;

    public Company(int companyId, String companyName, double minCgpa) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.minCgpa = minCgpa;
    }

    public int getCompanyId() { return companyId; }
    public String getCompanyName() { return companyName; }
    public double getMinCgpa() { return minCgpa; }

    public void display() {
        System.out.println("Company ID : " + companyId);
        System.out.println("Company Name : " + companyName);
        System.out.println("Minimum CGPA : " + minCgpa);
        System.out.println("");
    }
}
