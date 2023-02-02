import java.math.BigDecimal;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//       write a Java program that will allow a user to
//       generate an employee's payroll depending on the type of employee, wage, and, if applicable,
//       number of hours worked.

//       FixedSalary emp1 = new FixedSalary("John");
        FixedSalary fix1 = new FixedSalary("John", new BigDecimal(9000), new BigDecimal(100));
        System.out.println(fix1.name);
        fix1.setupWageComponents();
        System.out.println(fix1.getGrossPay());
        System.out.println(fix1.percentSeventeen);
        System.out.println(Arrays.toString(fix1.generatePayroll()));

        Hourly hour1 = new Hourly("Hour", new BigDecimal(10), new BigDecimal(170));
        System.out.println(Arrays.toString(hour1.generatePayroll()));

//        output :
//        1. gross pay i.e. OW + AW (before CDF deduction)
//        2. employee's CDF
//        3. employer's CDF
//        4. net pay (after CPF deduction)
//        5. total CPF contributions
    }
}