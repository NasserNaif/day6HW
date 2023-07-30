import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator_Exercise {
    public static void main(String[] args) {
//
        try {
            Scanner input = new Scanner(System.in);
            ArrayList results = new ArrayList<>();
            boolean isPlay = true;
            double lastRes = 0;

            do {
                System.out.println("1 - addition " +
                        "2 - subtraction " +
                        "3- mult " +
                        "4- dividion " +
                        "5 - modulus " +
                        "6 - min " +
                        "7 - max " +
                        "8 - avg " +
                        "9 - last result " +
                        "10 - all resulte");

                try {
                    int opition = input.nextInt();


                    switch (opition) {
                        case 1 -> {
                            System.out.printf("first number :");
                            int num1 = input.nextInt();
                            System.out.printf("second number :");
                            int num2 = input.nextInt();
                            int result = add(num1, num2);
                            results.add(result);
                            lastRes = result;
                        }
                        case 2 -> {
                            System.out.printf("first number :");
                            int num1 = input.nextInt();
                            System.out.printf("second number :");
                            int num2 = input.nextInt();
                            int result = sub(num1, num2);
                            results.add(result);
                            lastRes = result;

                        }
                        case 3 -> {
                            System.out.printf("first number :");
                            int num1 = input.nextInt();
                            System.out.printf("second number :");
                            int num2 = input.nextInt();
                            int result = mul(num1, num2);
                            results.add(result);
                            lastRes = result;
                        }
                        case 4 -> {
                            System.out.printf("first number :");
                            int num1 = input.nextInt();
                            System.out.printf("second number :");
                            int num2 = input.nextInt();
                            double result = div(num1, num2);
                            results.add(result);
                            lastRes = result;


                        }
                        case 5 -> {
                            System.out.printf("first number :");
                            int num1 = input.nextInt();
                            System.out.printf("second number :");
                            int num2 = input.nextInt();
                            int result = mod(num1, num2);
                            results.add(result);
                            lastRes = result;
                        }
                        case 6 -> {
                            System.out.printf("first number :");
                            int num1 = input.nextInt();
                            System.out.printf("second number :");
                            int num2 = input.nextInt();
                            int result = min(num1, num2);
                            results.add(result);
                            lastRes = result;
                        }
                        case 7 -> {
                            System.out.printf("first number :");
                            int num1 = input.nextInt();
                            System.out.printf("second number :");
                            int num2 = input.nextInt();
                            int result = max(num1, num2);
                            results.add(result);
                            lastRes = result;
                        }
                        case 8 -> {
                            System.out.printf("first number :");
                            int num1 = input.nextInt();
                            System.out.printf("second number :");
                            int num2 = input.nextInt();
                            double result = avg(num1, num2);
                            results.add(result);
                            lastRes = result;
                        }
                        case 9 -> {
                            System.out.println(lastRes);
                        }
                        case 10 -> {
                            System.out.println(results);
                            isPlay = false;
                        }
                        default -> {
                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Sorry! you have to input a number only.");
                    break;
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                    break;
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } while (isPlay);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    public static int add(int num1, int num2) {
        System.out.println(num1 + num2);
        return num1 + num2;
    }

    public static int sub(int num1, int num2) {
        System.out.println(num1 - num2);
        return num1 - num2;
    }

    public static int mul(int num1, int num2) {
        System.out.println(num1 * num2);
        return num1 * num2;
    }

    public static double div(int num1, int num2) {
        double res = 0;
        try {
            isEqualZero(num2);
            res = (double) num1 / num2;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(res);
        return res;
    }

    public static int mod(int num1, int num2) {
        System.out.println(num1 % num2);
        return num1 % num2;
    }

    public static int min(int num1, int num2) {

        int minval = 0;
        if (num1 > num2) {
            System.out.println(num2);
            minval = num2;
        } else if (num1 < num2) {

            System.out.println(num1);
            minval = num1;
        } else {
            System.out.println("they are Equal");
            minval = num1;
        }

        return minval;
    }

    public static int max(int num1, int num2) {
        int maxVal = 0;
        if (num1 < num2) {
            System.out.println(num2);
            maxVal = num2;
        } else if (num1 > num2) {

            System.out.println(num1);
            maxVal = num1;
        } else {
            System.out.println("they are Equal");
            maxVal = num1;
        }

        return maxVal;
    }

    public static double avg(int num1, int num2) {
        double avg = (double) (num1 + num2) / 2;
        System.out.println(avg);
        return avg;
    }

    public static void isEqualZero(int num) throws Exception {
        if (num == 0) {
            throw new Exception("Sorry! you can't divided by ZERO.");
        }
    }
}
