//
// Assignment 2
// Written by: Rayan Rekmani 40283058
//

package deductionpackage;

public class ProvincialIncomeTax extends Deductions {

    @Override
    public double calculateTax(double annualGrossSalary) {
        double taxAmount = 0;
        if (annualGrossSalary>18571 && annualGrossSalary<=53255){
            taxAmount = annualGrossSalary*.14;
        } else if (annualGrossSalary > 53255 && annualGrossSalary<= 106495){
            taxAmount = annualGrossSalary*.19;
        } else if (annualGrossSalary>106495 && annualGrossSalary<= 129590){
            taxAmount = annualGrossSalary*.24;
        } else if (annualGrossSalary>129590){
            taxAmount = annualGrossSalary*.2575;
        }
        return taxAmount;
    }
    
}
