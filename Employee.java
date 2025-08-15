//
// Assignment 2
// Written by: Rayan Rekmani 40283058
//

public class Employee {
    private long employeeNumber;
    private String firstName, lastName;
    private double hoursWorked, hourlyWage;

    public Employee(){
        this.employeeNumber=0;
        this.firstName="Unknown";
        this.lastName="Unknown";
        this.hourlyWage=0;
        this.hoursWorked=0;
    }
    public Employee(long employeeNumber, String firstName, String lastName, double hoursWorked, double hourlyWage) {
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hoursWorked = hoursWorked;
        this.hourlyWage = hourlyWage;
    }
    public long getEmployeeNumber() {
        return employeeNumber;
    }
    public void setEmployeeNumber(long employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public double getHoursWorked() {
        return hoursWorked;
    }
    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    public double getHourlyWage() {
        return hourlyWage;
    }
    public void setHourlyWage (double hourlyWage) throws MinimumWageException {
        if (hourlyWage<15.75) {
            throw new MinimumWageException();
        }
        else {
            this.hourlyWage = hourlyWage;
        }
    }

    /**
     * 
     * @return calculated salary of the year, before taxes
     */
    public double calculateAnnualGrossSalary () {
        int weeksPerYear = 52;
        return (hoursWorked*hourlyWage*weeksPerYear);
    }

    
}