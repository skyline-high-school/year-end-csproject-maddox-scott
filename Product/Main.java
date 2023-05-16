import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        System.out.println("Tic-Tac-Toe!\n__________________________________________________\nPlayer 1: X\nAI: O\n__________________________________________________");
        Scanner input = new Scanner(System.in);
        System.out.print("How many tiles wide do you wish the board to be?: ");
        int size = input.nextInt();
        // Finish.
    }
}