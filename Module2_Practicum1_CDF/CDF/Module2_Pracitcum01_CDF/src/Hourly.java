import java.math.BigDecimal;
public class Hourly extends Employee{

    private BigDecimal hourlyRate;
    // AW
    private BigDecimal hours;

    Hourly (String name, BigDecimal hourlyRate, BigDecimal hours) {
        super(name);
        this.hourlyRate = hourlyRate;
        this.hours = hours;
    }

    @Override
    protected void setupWageComponents() {
        BigDecimal maxHours = new BigDecimal("176");
        BigDecimal overTimeRate = new BigDecimal("1.5");
        BigDecimal normalWorkCalc = hours.multiply(hourlyRate);

        super.setOrdinaryWage(normalWorkCalc);

        if (hours.compareTo(maxHours) >0)  {
            BigDecimal noHoursOT = hours.subtract(maxHours);
            BigDecimal overTimeCalc = overTimeRate.multiply(noHoursOT);

            super.setAdditionalWage(overTimeCalc);
            super.setGrossPay(normalWorkCalc.add(overTimeCalc));
        } else {
            super.setAdditionalWage(BigDecimal.ZERO);
            super.setGrossPay(normalWorkCalc);
        }
    }
    @Override
    public BigDecimal[] generatePayroll () {
        this.setupWageComponents();

        return super.generatePayroll();
    }
}
