
public class Main {
    private static final int NumEmployee = 5;

    public static void main(String[] args) {
        int ageEmployee=0;

        Employee[] employee = new Employee[NumEmployee];
        employee[0] = new Employee("Ivanov Petr Sidorovich", "Engineer", "+1-555-555-550", 50);
        employee[1] = new Employee("Petrov Alexey Ivanovich", "Engineer", "+1-555-555-545", 45);
        employee[2] = new Employee("Sidorov Ivan Romanovich", "Engineer", "+1-555-555-540", 40);
        employee[3] = new Employee("Petrov Alexey Petrovich", "Engineer", "+1-555-555-549", 49);
        employee[4] = new Employee("Ivanov Petr Petrovich", "Engineer", "+1-555-555-530", 30);

        for (Employee employee1: employee) {
            ageEmployee=employee1.getAge();

            if (ageEmployee>=40){
                System.out.println(employee1.toPrintInfo());
            }
        }

    }
}

