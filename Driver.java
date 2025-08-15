
import deductionpackage.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;



public class Driver {
    public static void main(String[] args) {
        Employee employees [] = new Employee[71];
        for (int i = 0; i < employees.length; i++) {
            employees[i]=new Employee();
        }
        PrintWriter oStream;
        Scanner iStream;
        int lineCount = 0, errorCount = 0;
        try {
            System.out.println("Opening file payroll...");
            iStream = new Scanner(new FileInputStream("payroll.txt"));
            int i = 0;
            System.out.println("Reading file payroll...");
            System.out.println("Error lines found in file payroll:");
            while(iStream.hasNextLine()){
                String line = iStream.nextLine();
                lineCount++;
                String words [] = line.split(" ");
                try {
                    long id = Long.parseLong(words[0]);
                    String fname = words[1];
                    String lname = words[2];
                    double wage = Double.parseDouble(words[3]);
                    double hours = Double.parseDouble(words[4]);

                    

                    employees[i].setEmployeeNumber(id);
                    employees[i].setFirstName(fname);
                    employees[i].setLastName(lname);
                    employees[i].setHourlyWage(wage);
                    employees[i].setHoursWorked(hours);

                    i++;
                } catch (NumberFormatException | MinimumWageException e) {
                    try {
                        oStream = new PrintWriter(new FileOutputStream("payrollError.txt",true));
                        errorCount++;
                        System.out.println(line);
                        oStream.println(line);
                        oStream.close();
                    } catch (Exception o) {
                        System.out.println("File payrollError.txt not found.");
                    }
                }
            }
            iStream.close(); 
        } catch(FileNotFoundException e) {
            System.out.println("File payroll.txt not found.");
            System.exit(0);
        }

        try {
            oStream = new PrintWriter(new FileOutputStream("payrollReport.txt", true));
            oStream.format("%48s%48s", "iDroid Solutions","");
            oStream.println();
            oStream.format("%48s%48s", "-----------------","");
            oStream.println();
            oStream.format("%-16s%-16s%-16s%-16s%-16s%-16s", "Employee ID", "First Name", "Last Name", "Gross Salary", "Deductions", "Net Salary");
            oStream.println();
            oStream.close();
        } catch (Exception e) {
            System.out.println("File payrollReport.txt not found.");
        }

        System.out.println(lineCount+" lines read from file payroll");
        System.out.println(errorCount+" lines written to error file");
        System.out.println("Calculating deductions");
        System.out.println("Writing output file");
        System.out.printf("%48s%48s", "iDroid Solutions","");
        System.out.println("");
        System.out.printf("%48s%48s", "-----------------","");
        System.out.println("");
        System.out.printf("%-16s%-16s%-16s%-16s%-16s%-16s", "Employee ID", "First Name", "Last Name", "Gross Salary", "Deductions", "Net Salary");
        System.out.println("");


        for (int i = 0; i < employees.length; i++){
            if (employees[i].getEmployeeNumber()!=0){
                try {
                    oStream = new PrintWriter(new FileOutputStream("payrollReport.txt", true));
                    
                    QuebecParentalInsurancePlan qpip = new QuebecParentalInsurancePlan();
                    QuebecPensionPlan qpp = new QuebecPensionPlan();
                    ProvincialIncomeTax pit = new ProvincialIncomeTax();
                    FederalIncomeTax fit = new FederalIncomeTax();
                    EmploymentInsurance ei = new EmploymentInsurance();
    
                    double annualSalary = employees[i].calculateAnnualGrossSalary();
    
                    double totalTax = qpip.calculateTax(annualSalary)
                        +qpp.calculateTax(annualSalary)
                        +pit.calculateTax(annualSalary)
                        +fit.calculateTax(annualSalary)
                        +ei.calculateTax(annualSalary);
    
                    double netSalary = annualSalary-totalTax;
    
                    DecimalFormat df = new DecimalFormat("0.00");
    
                    String grossSalary = "$"+df.format(annualSalary);
                    String deductions = "$"+df.format(totalTax);
                    String netsalary = "$"+df.format(netSalary);
    
                    oStream.format("%-16s%-16s%-16s%-16s%-16s%-16s", employees[i].getEmployeeNumber(),employees[i].getFirstName(),employees[i].getLastName(),grossSalary,deductions,netsalary);
                    oStream.println();
                    System.out.printf("%-16s%-16s%-16s%-16s%-16s%-16s", employees[i].getEmployeeNumber(),employees[i].getFirstName(),employees[i].getLastName(),grossSalary,deductions,netsalary);
                    System.out.println("");
                    oStream.close();
    
                } catch (Exception o) {
                    System.out.println("File payrollReport.txt not found.");
                }
            }
            
        }
    }
    
}
