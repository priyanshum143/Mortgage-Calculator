public class App {
    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Principal ($1K - $1M): ", 999, 1_000_000, "Enter an amount between $1K and $1M");
        float annualInterest = (float) Console.readNumber("Annual Interset Rate : ", 0, 30, "Enter a number between 0 and 30");
        byte timePeriod = (byte) Console.readNumber("Period (Years): ", 0, 40, "Enter a time period between 1 and 40 years");

        var calculator = new MortgageCalculator(principal, annualInterest, timePeriod);
        var report = new MortgageReport(calculator);

        report.printMortgage();
        report.printPaymentSchedule();
        report.printInterest();
    }
}