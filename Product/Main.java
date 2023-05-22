import java.util.Scanner;

public class Main {
    public static void main (String[] args) {

        GameState bruh = new GameState(3); {
            bruh.getMoves('X');
        }

        Scanner input = new Scanner(System.in);
        GameState state;
        System.out.println("Wlecome to Tic-Tac-Toe!\n__________________________________________________\nPlayer 1: X\nAI: O\n__________________________________________________");
        int size;
        while (true) {
            System.out.print("How many tiles wide should the board be?: ");
            if (input.hasNextInt()) {
                size = input.nextInt();
                input.nextLine();
                if (size > 0 && size <= 10) {
                    state = new GameState(size);
                    break;
                } else {
                    System.out.println("Invalid input: please select an integer between 1 and 10.");
                }
            } else {
                System.out.println("Invalid input: please select an integer value.");
                input.nextLine();
            }
        }
        state.printBoard();
        while (true) {
            state = Player.returnMove(state, input);
            state.printBoard();
            if (state.isTerminalState()) {
                if (state.value() == 1) {
                    System.out.println("Player 1 wins!");
                } else if (state.value() == -1) {
                    System.out.println("AI wins!");
                } else {
                    System.out.println("Tie! No winners!");
                }
                break; 
            }
            System.out.println("AI\'s Turn");
            state = AI.returnMove(state, size);
            state.printBoard();
            if (state.isTerminalState()) {
                if (state.value() == 1) {
                    System.out.println("Player 1 wins!");
                } else if (state.value() == -1) {
                    System.out.println("AI wins!");
                } else {
                    System.out.println("Tie! No winners!");
                }
                break; 
            }
        }
        System.out.println("Thank you for playing. Better luck next time!");
        input.close();
    }
}