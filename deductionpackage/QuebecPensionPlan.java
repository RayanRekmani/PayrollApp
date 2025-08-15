package deductionpackage;

//
// Assignment 2
// Written by: Rayan Rekmani 40283058
//

public class QuebecPensionPlan extends Deductions {

    @Override
    public double calculateTax(double annualGrossSalary) {
        double tax = 7700.40;
        if (annualGrossSalary<71300) {
            tax = .108*annualGrossSalary;
        }
        return tax;
    }
    
}
