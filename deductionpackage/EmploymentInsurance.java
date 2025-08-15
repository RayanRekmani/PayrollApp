package deductionpackage;

//
// Assignment 2
// Written by: Rayan Rekmani 40283058
//

public class EmploymentInsurance extends Deductions{

    @Override
    public double calculateTax(double annualGrossSalary) {
        double tax = 1077.48;
        if (annualGrossSalary<65700){
            tax = (.0164)*annualGrossSalary;
        }
        return tax;
    }
    
}
