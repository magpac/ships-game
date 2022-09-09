import java.util.Random;
import java.util.Scanner;

public class Ships {
    public static void main(String[] args) {
        Player p1 = new Player(10, 10);
        Player p2 = new Player(10, 10);

        // 1st ship of 1st player:
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Specify the location of the first ship of length 1.");
                System.out.println("Row:");
                int row = scan.nextInt();
                System.out.println("Column:");
                int column = scan.nextInt();

                p1.setShip(row, column, true, 1);
                break;
            } catch (InvalidOperationException e) {
                System.out.println(e.getMessage());
            }
        }

        // 2nd ship of 1st player:
        while (true) {
            try {
                System.out.println("Specify the location of the first ship of length 4.");
                System.out.println("Row:");
                int row = scan.nextInt();
                System.out.println("Column:");
                int column = scan.nextInt();
                System.out.println("Is it vertical? Type true or false:");
                boolean isVertical = scan.nextBoolean();

                p1.setShip(row, column, isVertical, 4);
                break;
            } catch (InvalidOperationException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("This is your board:");
        p1.displayOwnBoard();
        System.out.println();

        // Ships of 2nd player:
        try {
            p2.setShip(0, 9, false, 1);
            p2.setShip(2, 0, false, 4);
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }

        // Shots:
        while (true) {
            try {
                // Shots of 1st player:
                System.out.println("Specify the location of the shots.");
                System.out.println("Row:");
                int row = scan.nextInt();
                System.out.println("Column:");
                int column = scan.nextInt();

                p1.ownShotEffect(row, column, p2.enemyShot(row, column));

                if (p2.isGameOver()) {
                    System.out.println("Game over. Player 1 won.");
                    p1.displayEnemyBoard();
                    break;
                }

                // Shots of 2nd player:
                Random random = new Random();
                row = random.nextInt(10);
                column = random.nextInt(10);

                p2.ownShotEffect(row, column, p1.enemyShot(row, column));

                System.out.println("This is your board:");
                p1.displayOwnBoard();
                System.out.println();
                System.out.println("This is the enemy board:");
                p1.displayEnemyBoard();

                if (p1.isGameOver()) {
                    System.out.println("Game over. Player 2 won.");
                    p2.displayEnemyBoard();
                    break;
                }
            } catch (InvalidOperationException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
