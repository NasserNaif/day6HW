import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class menu_EX7 {
    public static void isEqualZero(int len) throws Exception {
        if (len == 0) {
            throw new Exception("Sorry! the length must not be ZERO.");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.printf("please enter the length of array : ");

            int length = input.nextInt();

            boolean isPlaying = true;


            int[] elments = new int[length];

            do {
                try {
                    isEqualZero(length);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    break;
                }
                System.out.println("please enter number for services. " +
                        "1- for enter array values. " +
                        "2- Display elements of an array. " +
                        "3- Search the element within array" +
                        "4- Sort the array. " +
                        "5- to stop app");

                int options = input.nextInt();

                switch (options) {
                    case 1 -> {
                        for (int i = 0; i < length; i++) {
                            System.out.printf("please enter the value of " + i + " index :");
                            int elm = input.nextInt();
                            elments[i] = elm;
                        }

                    }
                    case 2 -> {
                        System.out.println("this is your array : " + Arrays.toString(elments));
                    }
                    case 3 -> {
                        System.out.printf("please enter the value to search : ");
                        int src = input.nextInt();
                        boolean isHere = false;

                        for (int i = 0; i < length; i++) {
                            if (elments[i] == src) {

                                System.out.println("yes there's " + src + " in the array");
                                isHere = true;
                                break;
                            }
                        }
                        if (!isHere) {
                            System.out.println("sorry the number not avaliable in this array");
                        }
                    }
                    case 4 -> {
                        int rep;
                        for (int i = 1; i < elments.length; i++) {
                            for (int j = 0; j < i; j++) {
                                if (elments[i] < elments[j]) {
                                    rep = elments[j];
                                    elments[j] = elments[i];
                                    elments[i] = rep;
                                }
                                rep = 0;
                            }
                        }
                        System.out.println(Arrays.toString(elments));
                    }
                    case 5 -> {
                        isPlaying = false;
                    }
                }


            } while (isPlaying);

        } catch (InputMismatchException e) {
            System.out.println("Sorry! please enter a number ");
        } catch (NegativeArraySizeException e) {
            System.out.println("Sorry! the length must be greater than zero");
        }


        System.out.println("thank you");

    }
}
