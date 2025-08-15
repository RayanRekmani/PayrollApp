package deductionpackage;
//
// Assignment 2
// Written by: Rayan Rekmani 40283058
//
public class QuebecParentalInsurancePlan extends Deductions{

    @Override
    public double calculateTax(double annualGrossSalary) {
        double tax = 484.12;
        if (annualGrossSalary<98000){
            tax = .00494*annualGrossSalary;
        }
        return tax;
    }
    
}
