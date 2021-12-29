import java.util.Locale;

public class Employee {
    private String fullName;
    private String positionInCompany;
    private String email;
    private String telephoneNumber;
    private int age;
    private double salary;
    private static int employeeCount = 0;

    public Employee(
            String fullName, String positionInCompany, String telephoneNumber,
            int age) {
        this.fullName = fullName.toUpperCase();
        int lastSpace = fullName.lastIndexOf(" ");
        int firstSpace = fullName.indexOf(" ");
        String firstLitterSecondName = "."+fullName.substring(lastSpace+1, lastSpace + 2);
        this.positionInCompany=positionInCompany;
        this.email = (fullName.substring(0, lastSpace)).replace(" ", "_") + (firstLitterSecondName + "@company.com");
        this.telephoneNumber = telephoneNumber;
        this.age = age;
        this.salary = 100000.99;

        employeeCount++;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toPrintInfo() {
        return String.format("Сотрудник %s%n Должность %s%n e-mail: %s%n phone: %s%n",fullName,positionInCompany,email, telephoneNumber);
    }
}