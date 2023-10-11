import java.text.NumberFormat;

public class MortgageReport {
    private final static byte MONTHS_IN_YEAR = 12;

    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator){
        this.calculator = calculator;
    }

    public void printMortgage(){
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        String mortgagePayment = NumberFormat.getCurrencyInstance().format(calculator.calculateMortgage());
        System.out.println("Monthly Payment: " + mortgagePayment);
    }
    
    public void printPaymentSchedule(){
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for(short month=1; month<=(calculator.getTimePeriod()*MONTHS_IN_YEAR); month++){
            double balance = calculator.calculateBalance(month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public void printInterest(){
        double intersetPaid = (calculator.calculateMortgage() * calculator.getTimePeriod() * MONTHS_IN_YEAR) - calculator.getPrincipal();
        System.out.println();
        System.out.println("INTERSET PAID");
        System.out.println("-------------");
        System.out.println(NumberFormat.getCurrencyInstance().format(intersetPaid));
    }
}