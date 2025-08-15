package deductionpackage;

//
// Assignment 2
// Written by: Rayan Rekmani 40283058
//
public class FederalIncomeTax extends Deductions {

    @Override
    public double calculateTax(double annualGrossSalary) {
        double tax = 0;
        if (annualGrossSalary>=16129 && annualGrossSalary<=57375){
            tax = .15*annualGrossSalary;
        } else if (annualGrossSalary>57375 && annualGrossSalary <= 114750){
            tax = .205*annualGrossSalary;
        } else if (annualGrossSalary>114750 && annualGrossSalary <= 177882){
            tax = .26*annualGrossSalary;
        } else if (annualGrossSalary>177882&& annualGrossSalary <=253414){
            tax = .29*annualGrossSalary;
        } else if (annualGrossSalary>253414){
            tax= .33*annualGrossSalary;
        }
        return tax;
    }
    
}
