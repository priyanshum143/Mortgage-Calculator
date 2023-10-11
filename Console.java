import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static double readNumber(String prompt, int min, int max, String errorMsg){
        double value = min;
        while(true){
            System.out.print(prompt);
            value = scanner.nextDouble();
            if(value > min && value <= max) break;
            System.out.println(errorMsg);
        }
        return value;
    }
}