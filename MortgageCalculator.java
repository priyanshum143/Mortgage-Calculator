public class MortgageCalculator {
    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENTAGE = 100;

    private int principal;
    private float annualInterest;
    private byte timePeriod;

    public MortgageCalculator(int principal, float annualInterest, byte timePeriod){
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.timePeriod = timePeriod;
    }

    public double calculateMortgage(){
        float monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENTAGE;
        int numberOfPayments = timePeriod * MONTHS_IN_YEAR;

        double amount = (principal * (monthlyInterest * Math.pow(monthlyInterest + 1, numberOfPayments))) / (Math.pow(1+monthlyInterest, numberOfPayments) - 1);
        return amount;
    }

    public double calculateBalance(int numberOfPaymentsMade){
        float monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENTAGE;
        int numberOfPayments = timePeriod * MONTHS_IN_YEAR;

        double balance = principal * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return balance;
    }

    public byte getTimePeriod(){
        return timePeriod;
    }

    public int getPrincipal(){
        return principal;
    }
}