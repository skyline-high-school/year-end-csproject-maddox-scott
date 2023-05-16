public class GameState {
    private int size;
    private char[][] board;

    public GameState(int size, char[][] board) {
        this.size = size;
        this.board = board;
    }

    public GameState(int size) {
        this.size = size;
        this.board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '-';
            }
        }
    }

    public boolean isTerminalState() {
        // Check for p1 win.
        for (int i = 0; i < size; i++) {
            boolean onlyX = true;
            for (int j = 0; i < size; j++) {
                if (board[i][j] == '-' || board[i][j] == 'O') {
                    onlyX = false;
                }
            }
            if (onlyX) {
                return true;
            }
        }
        for (int i = 0; i < size; i++) {
            boolean onlyX = true;
            for (int j = 0; i < size; j++) {
                if (board[j][i] == '-' || board[j][i] == 'O') {
                    onlyX = false;
                }
            }
            if (onlyX) {
                return true;
            }
        }
        boolean onlyX = true;
        for (int i = 0; i < size; i++) {
            if (board[i][i] == '-' || board[i][i] == 'O') {
                onlyX = false;
            }
        }
        if (onlyX) {
            return true;
        }
        onlyX = true;
        for (int i = 0; i < size; i++) {
            if (board[i][size - 1 - i] == '-' || board[i][size - 1 - i] == 'O') {
                onlyX = false;
            }
        }
        if (onlyX) {
            return true;
        }
        // Check for p2 win.
        for (int i = 0; i < size; i++) {
            boolean onlyO = true;
            for (int j = 0; i < size; j++) {
                if (board[i][j] == '-' || board[i][j] == 'X') {
                    onlyO = false;
                }
            }
            if (onlyO) {
                return true;
            }
        }
        for (int i = 0; i < size; i++) {
            boolean onlyO = true;
            for (int j = 0; i < size; j++) {
                if (board[j][i] == '-' || board[j][i] == 'X') {
                    onlyO = false;
                }
            }
            if (onlyO) {
                return true;
            }
        }
        boolean onlyO = true;
        for (int i = 0; i < size; i++) {
            if (board[i][i] == '-' || board[i][i] == 'X') {
                onlyO = false;
            }
        }
        if (onlyO) {
            return true;
        }
        onlyO = true;
        for (int i = 0; i < size; i++) {
            if (board[i][size - 1 - i] == '-' || board[i][size - 1 - i] == 'X') {
                onlyO = false;
            }
        }
        if (onlyO) {
            return true;
        }
        // Check for more moves.
        if (movesLeft() > 0) {
            return false;
        }
        // Check for tie.
        return true;
    }

    public int value() {
        // Check for p1 win.
        for (int i = 0; i < size; i++) {
            boolean onlyX = true;
            for (int j = 0; i < size; j++) {
                if (board[i][j] == '-' || board[i][j] == 'O') {
                    onlyX = false;
                }
            }
            if (onlyX) {
                return 1;
            }
        }
        for (int i = 0; i < size; i++) {
            boolean onlyX = true;
            for (int j = 0; i < size; j++) {
                if (board[j][i] == '-' || board[j][i] == 'O') {
                    onlyX = false;
                }
            }
            if (onlyX) {
                return 1;
            }
        }
        boolean onlyX = true;
        for (int i = 0; i < size; i++) {
            if (board[i][i] == '-' || board[i][i] == 'O') {
                onlyX = false;
            }
        }
        if (onlyX) {
            return 1;
        }
        onlyX = true;
        for (int i = 0; i < size; i++) {
            if (board[i][size - 1 - i] == '-' || board[i][size - 1 - i] == 'O') {
                onlyX = false;
            }
        }
        if (onlyX) {
            return 1;
        }
        // Check for p2 win.
        for (int i = 0; i < size; i++) {
            boolean onlyO = true;
            for (int j = 0; i < size; j++) {
                if (board[i][j] == '-' || board[i][j] == 'X') {
                    onlyO = false;
                }
            }
            if (onlyO) {
                return -1;
            }
        }
        for (int i = 0; i < size; i++) {
            boolean onlyO = true;
            for (int j = 0; i < size; j++) {
                if (board[j][i] == '-' || board[j][i] == 'X') {
                    onlyO = false;
                }
            }
            if (onlyO) {
                return -1;
            }
        }
        boolean onlyO = true;
        for (int i = 0; i < size; i++) {
            if (board[i][i] == '-' || board[i][i] == 'X') {
                onlyO = false;
            }
        }
        if (onlyO) {
            return -1;
        }
        onlyO = true;
        for (int i = 0; i < size; i++) {
            if (board[i][size - 1 - i] == '-' || board[i][size - 1 - i] == 'X') {
                onlyO = false;
            }
        }
        if (onlyO) {
            return -1;
        }
        return 0;
    }

    public int movesLeft() {
        int moves = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == '-') {
                    moves++;
                }
            }
        }
        return moves;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + ' ');
            }
            System.out.println();
        }
    }
}