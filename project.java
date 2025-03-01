
import java.util.Scanner;

public class project {

    public static void main(String[] args) {
        project calculator = new project();
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("hello user");
            System.out.print("Enter an Operator (+,-,*,/)  :  ");
            String input = sc.next();
            char ch = input.charAt(0);
            if (input.length() != 1) {
                System.out.println("wrong input");
            } else {

                calculator.chooseOperation(ch);
            }

            boolean exit = calculator.retryLogic();

            if (exit) {
                break;
            }

        } while (true);
    }

    public boolean retryLogic() {
        Scanner sc = new Scanner(System.in);
        int times = 0;
        int retry = 5;
        for (times = 0; times < retry; times++) {

            System.out.println("do you want to continue (y/n)");
            String exitInput = sc.next();
            char ch1 = exitInput.charAt(0);
            if (exitInput.length() == 1 && ch1 == 'n') {
                return true;

            } else if (ch1 == 'y') {
                return false;
            } else {
                System.out.println("wrong input");
            }
            if (times >= retry) {
                System.out.println("limit exceeded");
                return true;
            }
        }
        return false;

    }

    public int takeNumber() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        return num;
    }

    public void chooseOperation(char ch) {
        switch (ch) {
            case '+':
                int num1 = takeNumber();
                int num2 = takeNumber();
                System.out.println("Addition : " + (num1 + num2));
                break;
            case '-':
                int num3 = takeNumber();
                int num4 = takeNumber();
                System.out.println("Subtraction : " + (num3 - num4));
                break;
            case '*':
                int num5 = takeNumber();
                int num6 = takeNumber();
                System.out.println("multiplication : " + (num5 * num6));
                break;
            case '/':
                int num7 = takeNumber();
                int num8 = takeNumber();
                if (num8 == 0) {
                    System.out.println("Can not divide by 0");
                    break;
                }

                System.out.println("Division : " + (num7 / num8));
                break;
            case '%':
                int num9 = takeNumber();
                int num10 = takeNumber();
                System.out.println("Modulo : " + (num9 % num10));
                break;

            default:
                System.out.println("unknown operator");

        }
    }
}
