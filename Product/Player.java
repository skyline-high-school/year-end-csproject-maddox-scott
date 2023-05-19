import java.util.Scanner;

public class Player {
    static GameState returnMove(GameState state) {
        GameState move = null;
        Scanner input = new Scanner (System.in);
        int row, col;
        boolean validCoordinate = false;
        while (!validCoordinate) {
            while (true) {
                row = -1;
                System.out.print("Which row will you capture?: ");
                if (input.hasNextInt()) {
                    row = input.nextInt();
                    if (row >= 0 && row < state.getSize()) {
                        break;
                    } else {
                        System.out.println("Invalid input: Please select an integer value between 0 and " + (state.getSize() - 1) + ".");
                        input.nextLine();
                    }
                } else {
                    System.out.println("Invalid input: Please select an integer value between 0 and " + (state.getSize() - 1) + ".");
                    input.nextLine();
                }
            }
            while (true) {
                col = -1;
                System.out.print("Which column will you capture?: ");
                if (input.hasNextInt()) {
                    col = input.nextInt();
                    if (col >= 0 && col < state.getSize()) {
                        break;
                    } else {
                        System.out.println("Invalid input: Please select an integer value between 0 and " + (state.getSize() - 1) + ".");
                        input.nextLine();
                    }
                } else {
                    System.out.println("Invalid input: Please select an integer value between 0 and " + (state.getSize() - 1) + ".");
                    input.nextLine();
                }
            }
            if (state.getBoard()[row][col] == '-') {
                char[][] newBoard = state.getBoard().clone();
                newBoard[row][col] = 'X';
                move = new GameState(state.getSize(), newBoard);
                validCoordinate = true;
            } else {
                System.out.println("Invalid Coordinate: this coordinate has already been captured.");
            }
        }
        input.close();
        return move;
    }
}
