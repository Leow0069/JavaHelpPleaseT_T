import java.math.BigDecimal;

public class FixedSalary extends Employee {
    // OW
    private BigDecimal ordinaryWage;
    // AW
    private BigDecimal bizExpense;

    FixedSalary (String name, BigDecimal ordinaryWage, BigDecimal bizExpense) {
        super(name);
        this.ordinaryWage = ordinaryWage;
        this.bizExpense = bizExpense;
    }

//    A fixed salary employee will have a fixed amount paid each month. This
//    employee is subjected to mandatory CDF contributions. In addition, he/she is entitled to
//    additional wage in the form of business expenses.
    @Override
    protected void setupWageComponents() {
        super.setOrdinaryWage(this.ordinaryWage);
        super.setAdditionalWage(this.bizExpense);
        super.setGrossPay(this.ordinaryWage.add(this.bizExpense));
    }

    @Override
    public BigDecimal[] generatePayroll () {
        this.setupWageComponents();

        return super.generatePayroll();
    }
}
