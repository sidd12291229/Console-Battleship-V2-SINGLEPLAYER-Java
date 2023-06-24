import java.util.Scanner;

public class BattleshipGame {
    private static final int BOARD_SIZE = 10;
    private static final int NUM_SHIPS = 5;

    private char[][] board;
    private int numShips;

    public BattleshipGame() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        numShips = NUM_SHIPS;
        initializeBoard();
        placeShips();
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (numShips > 0) {
            displayBoard();

            System.out.print("Enter row: ");
            int row = scanner.nextInt();

            System.out.print("Enter column: ");
            int col = scanner.nextInt();

            if (isValidMove(row, col)) {
                if (isHit(row, col)) {
                    System.out.println("Hit!");
                    numShips--;
                    board[row][col] = 'X';
                } else {
                    System.out.println("Miss!");
                    board[row][col] = '-';
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        System.out.println("Congratulations! You sank all the battleships!");
        scanner.close();
    }

    private void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = '~';
            }
        }
    }

    private void placeShips() {
        int shipsPlaced = 0;
        while (shipsPlaced < NUM_SHIPS) {
            int row = (int) (Math.random() * BOARD_SIZE);
            int col = (int) (Math.random() * BOARD_SIZE);

            if (board[row][col] == '~') {
                board[row][col] = '~';
                shipsPlaced++;
            }
        }
    }

    private boolean isValidMove(int row, int col) {
        return (row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE);
    }

    private boolean isHit(int row, int col) {
        return (board[row][col] == 'S');
    }

    private void displayBoard() {
        System.out.println("    0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print(i + "   ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BattleshipGame game = new BattleshipGame();
        game.play();
    }
}
