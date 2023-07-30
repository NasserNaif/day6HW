import java.util.*;

public class tec_tac_toe {
    static int cols = 3;
    static int rows = 3;

    static char[][] arrPos = new char[rows][cols];
    static ArrayList playerList = new ArrayList();
    static ArrayList cpuList = new ArrayList();

    static boolean isPlaying = true;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 3 * 3 matrix   -- arr[3][3]
        // TEC TAC TOE Game

        newGame();
        do {
            BoardGame(arrPos);

            try {
                System.out.print("enter a number between ( 1-9 ) : ");
                int playerPos = input.nextInt();

                while (playerList.contains(playerPos) || cpuList.contains(playerPos)) {
                    if (playerList.size() + cpuList.size() == 9) {
                        System.out.println(checkWin());
                        break;
                    }
                    System.out.println("Position taken. Try again!");
                    playerPos = input.nextInt();
                }
                placePos(arrPos, playerPos, "player");
            } catch (InputMismatchException e) {
                System.out.println("sorry you only have to enter a number from 1 to 9 ! ");
                break;
            }


            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;

            while (playerList.contains(cpuPos) || cpuList.contains(cpuPos)) {
                if (playerList.size() + cpuList.size() == 9) {
                    System.out.println(checkWin());
                    break;
                }
                System.out.println();
                cpuPos = rand.nextInt(9) + 1;
            }
            System.out.println("computer chose : " + cpuPos);
            placePos(arrPos, cpuPos, "cpu");

            String result = checkWin();

            if (result.length() > 0) {
                try {
                    BoardGame(arrPos);
                    System.out.println(result);

                    System.out.print("Enter any key to play again OR E to stop playing : ");
                    String rr = input.nextLine();
                    String ch = input.nextLine();

                    if (ch.equalsIgnoreCase("E")) {
                        break;
                    } else {
                        newGame();
                        isPlaying = true;
                    }
                } catch (Exception e) {
                    System.out.println("please enter a latter or number only  !");
                }


            }

        } while (isPlaying);

    }


    public static void newGame() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arrPos[i][j] = ' ';
            }
        }

        playerList.clear();
        cpuList.clear();

    }

    public static void BoardGame(char[][] arr) {
        System.out.println(arr[0][0] + " | " + arr[0][1] + " | " + arr[0][2]);
        System.out.println("-" + " + " + "-" + " + " + "-");
        System.out.println(arr[1][0] + " | " + arr[1][1] + " | " + arr[1][2]);
        System.out.println("-" + " + " + "-" + " + " + "-");
        System.out.println(arr[2][0] + " | " + arr[2][1] + " | " + arr[2][2]);
    }

    public static void placePos(char[][] arr, int pos, String user) {
        String result = checkWin();
        if (result.length() > 0) {
            return;
        }
        char symbol = ' ';
        if (user.equalsIgnoreCase("player")) {
            symbol = 'X';
            playerList.add(pos);
        } else {
            symbol = 'O';
            cpuList.add(pos);
        }

        switch (pos) {
            case 1 -> arrPos[0][0] = symbol;
            case 2 -> arrPos[0][1] = symbol;
            case 3 -> arrPos[0][2] = symbol;
            case 4 -> arrPos[1][0] = symbol;
            case 5 -> arrPos[1][1] = symbol;
            case 6 -> arrPos[1][2] = symbol;
            case 7 -> arrPos[2][0] = symbol;
            case 8 -> arrPos[2][1] = symbol;
            case 9 -> arrPos[2][2] = symbol;
            default -> {
            }
        }

    }

    public static String checkWin() {
        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> midRow = Arrays.asList(4, 5, 6);
        List<Integer> bottomRow = Arrays.asList(7, 8, 9);
        List<Integer> leftcol = Arrays.asList(1, 4, 7);
        List<Integer> midcol = Arrays.asList(2, 5, 8);
        List<Integer> rightcol = Arrays.asList(3, 6, 9);
        List<Integer> firstCross = Arrays.asList(1, 5, 9);
        List<Integer> secCross = Arrays.asList(3, 5, 7);

        ArrayList<List> winnigChance = new ArrayList<>();
        winnigChance.add(topRow);
        winnigChance.add(midRow);
        winnigChance.add(bottomRow);
        winnigChance.add(leftcol);
        winnigChance.add(midcol);
        winnigChance.add(rightcol);
        winnigChance.add(firstCross);
        winnigChance.add(secCross);

        for (List elm : winnigChance
        ) {
            if (playerList.containsAll(elm)) {
                return "you won !";
            } else if (cpuList.containsAll(elm)) {
                return "sorry, computer won";
            }

            if (playerList.size() + cpuList.size() == 9) {
                return "Draw!";
            }
        }
        return "";
    }
}