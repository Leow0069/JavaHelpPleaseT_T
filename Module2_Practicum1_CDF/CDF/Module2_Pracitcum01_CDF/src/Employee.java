import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * An abstract class used to create concrete employee classes.
 * The abstract class provides the general implementation of the CDF 
 * calculations based off a Fixed Salaried employee. It also provides
 * a getter method to return the current number of employees employed 
 * by the company.
 * An abstract method is also provided for the concrete classes to setup its
 * individual wage components before generating the payroll.
 */

public abstract class Employee {
    protected String name;		  // variable for employee name
    private static int count = 0; // count the total number of employees
    Employee(String name) {
        this.name = name;
        count++;
    }
    BigDecimal ordinaryWage = new BigDecimal("0.00");
    BigDecimal additionalWage = new BigDecimal("0.00");
    BigDecimal grossPay =  new BigDecimal("0.00");
    BigDecimal employeeCDF =  new BigDecimal("0.00");
    BigDecimal totalCDF = new BigDecimal("0.00");
    BigDecimal employerCDF = new BigDecimal("0.00");

    public void setOrdinaryWage(BigDecimal ordinaryWage) {
        this.ordinaryWage = ordinaryWage;
    }
    public void setAdditionalWage(BigDecimal additionalWage) {
        this.additionalWage = additionalWage;
    }

    /**
     * Abstract method for the concrete classes to implement their own
     * calculation of the different wage components
     */
    protected abstract void setupWageComponents();

    /**
     * Returns the payroll components as a BigDecimal array depending on 
     * the type of employee, wage, and if applicable, number of hours 
     * worked.
     * Payroll components include:
     * 1. gross pay i.e. OW + AW (before CDF deduction)
     * 2. employee's CDF                               
     * 3. employer's CDF                               
     * 4. net pay (after CPF deduction)
     * 5. total CPF contributions
     *
     * @return	payroll components
     */
    protected void setGrossPay (BigDecimal grossPay) {
        this.grossPay = grossPay;
    }
    protected BigDecimal getGrossPay () {
        return this.grossPay;
    }
    protected void setEmployeeCDF (BigDecimal employeeCDF) {
        this.employeeCDF = employeeCDF;
    }
    protected BigDecimal getEmployeeCDF () {
        return this.employeeCDF;
    }

    BigDecimal percentSeventeen = new BigDecimal("0.17");
    BigDecimal percentThirtyThree = new BigDecimal("0.33");
    BigDecimal percentSixty = new BigDecimal("0.60");
    BigDecimal percentThirteen = new BigDecimal("0.13");
    BigDecimal sevenHundredFifty = new BigDecimal("750");
    BigDecimal fiveHundred = new BigDecimal("500");
    BigDecimal fifty = new BigDecimal("50");
    BigDecimal sixThousand = new BigDecimal("6000");
    BigDecimal thousandTwenty = new BigDecimal("1020");

    protected BigDecimal[] generatePayroll() {
        // your code here
        BigDecimal OW17PercAbove750 = ordinaryWage.multiply(percentSeventeen);
        BigDecimal AW17PercAbove750 = additionalWage.multiply(percentSeventeen);

        BigDecimal OW33PercAbove750 = ordinaryWage.multiply(percentThirtyThree);
        BigDecimal AW33PercAbove750 = additionalWage.multiply(percentThirtyThree);

        BigDecimal twMinus500 = grossPay.subtract(fiveHundred);
        BigDecimal perc60Btw500to750 = twMinus500.multiply(percentSixty);
        BigDecimal twTimesThirteenPercent = grossPay.multiply(percentThirteen);

        if (grossPay.compareTo(sevenHundredFifty) >0) {
            if (ordinaryWage.compareTo(sixThousand)<=0) {
                employeeCDF = OW17PercAbove750.add(AW17PercAbove750);
            } else {
                employeeCDF = thousandTwenty.add(AW17PercAbove750);
            }
            totalCDF = OW33PercAbove750.add(AW33PercAbove750).setScale(0, RoundingMode.HALF_DOWN);
            employerCDF = totalCDF.subtract(employeeCDF);
        } else if ((grossPay.compareTo(fiveHundred) >0) && (grossPay.compareTo(sevenHundredFifty) <=0)) {
            employeeCDF = perc60Btw500to750;
            totalCDF = twTimesThirteenPercent.add(perc60Btw500to750);
            employerCDF = totalCDF.subtract(employeeCDF);
        } else if ((grossPay.compareTo(fifty) >0) && (grossPay.compareTo(fiveHundred) <=0)) {
            employeeCDF = BigDecimal.ZERO;
            totalCDF = twTimesThirteenPercent;
            employerCDF = totalCDF.subtract(employeeCDF);
        } else if (grossPay.compareTo(fifty) <0)  {
            employeeCDF = BigDecimal.ZERO;
            totalCDF = BigDecimal.ZERO;
            employerCDF = totalCDF.subtract(employeeCDF);
        }

        BigDecimal[] payrollComponents = new BigDecimal[5];
        payrollComponents[0] = grossPay;
        payrollComponents[1] = employeeCDF.setScale(0, RoundingMode.DOWN);
        payrollComponents[2] = employerCDF.setScale(0, RoundingMode.DOWN);;
        payrollComponents[3] = grossPay.subtract(employeeCDF).setScale(0, RoundingMode.DOWN);; // after CDF deduction
        payrollComponents[4] = totalCDF;

        return payrollComponents;
    }
    
    /**
     * Returns the current number of employees employed by the company
     * 
     * @return int Number of employees 
     */
    protected static int getCount() {
        return count;
    }
}