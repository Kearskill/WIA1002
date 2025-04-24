 interface Employee {

    /**
     * Retrieves the name of the employee.
     *
     * @return the name of the employee.
     * @precondition none
     * @postcondition the employee's name is returned.
     */
    String getName();

    /**
     * Retrieves the unique ID of the employee.
     *
     * @return the ID of the employee.
     * @precondition none
     * @postcondition the employee's ID is returned.
     */
    int getId();

    /**
     * Retrieves the current salary of the employee.
     * For full-time employees, it's the monthly salary.
     * For part-time employees, it's calculated as hourlyRate * hoursWorkedInMonth.
     *
     * @return the employee's salary.
     * @precondition none
     * @postcondition the salary is returned based on the employee type.
     */
    double getSalary();

    /**
     * Calculates the employee's yearly salary.
     * For full-time: salary * 12.
     * For part-time: hourlyRate * hoursWorkedInMonth * 12.
     *
     * @return the yearly salary of the employee.
     * @precondition the salary or hourly rate and hours worked must be properly set.
     * @postcondition the calculated yearly salary is returned.
     */
    double calculateYearlySalary();

    /**
     * Prints the employee's details to the console.
     * Includes name, ID, and salary information specific to employee type.
     *
     * @precondition none
     * @postcondition employee details are printed to the standard output.
     */
    void printEmployeeDetails();
}

 class FullTimeEmployee implements Employee {
    private String name;
    private int id;
    private double salary;

    public FullTimeEmployee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public double calculateYearlySalary() {
        return salary * 12;
    }

    @Override
    public void printEmployeeDetails() {
        System.out.println("Full-Time Employee: " + name + " (ID: " + id + ") | Salary: " + salary);
    }
}

 class PartTimeEmployee implements Employee {
    private String name;
    private int id;
    private double hourlyRate;
    private int hoursWorkedInMonth;

    public PartTimeEmployee(String name, int id, double hourlyRate, int hoursWorkedInMonth) {
        this.name = name;
        this.id = id;
        this.hourlyRate = hourlyRate;
        this.hoursWorkedInMonth = hoursWorkedInMonth;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public double getSalary() {
        return hourlyRate * hoursWorkedInMonth;
    }

    @Override
    public double calculateYearlySalary() {
        return hourlyRate * hoursWorkedInMonth * 12;
    }

    @Override
    public void printEmployeeDetails() {
        System.out.println("Part-Time Employee: " + name + " (ID: " + id + ") | Hourly Rate: " + hourlyRate + " | Hours Worked in Month: " + hoursWorkedInMonth);
    }
}