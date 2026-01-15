package Project3;

public class Student {
    private String eno;
    private String name;
    private String branch;
    private int sem;
    private double percentage;

    public Student(String eno, String name, String branch, int sem, double percentage) {
        this.eno = eno;
        this.name = name;
        this.branch = branch;
        this.sem = sem;
        this.percentage = percentage;
    }

    public String getEno() { return eno; }
    public String getName() { return name; }
    public String getBranch() { return branch; }
    public int getSem() { return sem; }
    public double getPercentage() { return percentage; }

    public void setBranch(String branch) { this.branch = branch; }

    @Override
    public String toString() {
        return "Eno: " + eno + ", Name: " + name + ", Branch: " + branch +
               ", Sem: " + sem + ", Percentage: " + percentage;
    }
}