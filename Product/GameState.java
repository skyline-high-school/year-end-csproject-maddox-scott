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
        // Check for winner.
        if (value() != 0) {
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
            for (int j = 0; j < size; j++) {
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
            for (int j = 0; j < size; j++) {
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
            for (int j = 0; j < size; j++) {
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
            for (int j = 0; j < size; j++) {
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

    public int heuristicValue() {
        return XHeuristic() + OHeuristic();
    }

    public int XHeuristic() {
        int value = 0;
        // Rows
        for (int i = 0; i < size; i++) {
            boolean allX = true;
            boolean useless = false;
            int emptySpaces = 0;
            for (int j = 0; j < size; j++) {
                if (board[i][j] == '-') {
                    allX = false;
                    emptySpaces++;;
                } else if (board[i][j] == 'O') {
                    allX = false;
                    useless = true;
                    break;
                }
            }
            if (allX) {
                value += 100;
            } else if (!useless) {
                value += (size - emptySpaces) * 10;
            } 
        }
        // Columns
        for (int i = 0; i < size; i++) {
            boolean allX = true;
            boolean useless = false;
            int emptySpaces = 0;
            for (int j = 0; j < size; j++) {
                if (board[j][i] == '-') {
                    allX = false;
                    emptySpaces++;
                } else if (board[j][i] == 'O') {
                    allX = false;
                    useless = true;
                    break;
                }
            }
            if (allX) {
                value += 100;
            } else if (!useless) {
                value += (size - emptySpaces) * 10;
            } 
        }
        // Diagonals
        boolean allX = true;
        boolean useless = false;
        int emptySpaces = 0;
        for (int i = 0; i < size; i++) {
            if (board[i][i] == '-') {
                allX = false;
                emptySpaces++;
            } else if (board[i][i] == 'O') {
                allX = false;
                useless = true;
                break;
            }
        }
        if (allX) {
            value += 100;
        } else if (!useless) {
            value += (size - emptySpaces) * 10;
        } 
        allX = true;
        useless = false;
        emptySpaces = 0;
        for (int i = 0; i < size; i++) {
            if (board[i][size - i - 1] == '-') {
                allX = false;
                emptySpaces++;
            } else if (board[i][size - i - 1] == 'O') {
                allX = false;
                useless = true;
                break;
            }
        }
        if (allX) {
            value += 100;
        } else if (!useless) {
            value += (size - emptySpaces) * 10;
        } 
        // Output.
        return value;
    }

    public int OHeuristic() {
        int value = 0;
        // Rows
        for (int i = 0; i < size; i++) {
            boolean allO = true;
            boolean useless = false;
            int emptySpaces = 0;
            for (int j = 0; j < size; j++) {
                if (board[i][j] == '-') {
                    allO = false;
                    emptySpaces++;;
                } else if (board[i][j] == 'X') {
                    allO = false;
                    useless = true;
                    break;
                }
            }
            if (allO) {
                value -= 100;
            } else if (!useless) {
                value -= (size - emptySpaces) * 10;
            } 
        }
        // Columns
        for (int i = 0; i < size; i++) {
            boolean allO = true;
            boolean useless = false;
            int emptySpaces = 0;
            for (int j = 0; j < size; j++) {
                if (board[j][i] == '-') {
                    allO = false;
                    emptySpaces++;
                } else if (board[j][i] == 'X') {
                    allO = false;
                    useless = true;
                    break;
                }
            }
            if (allO) {
                value -= 100;
            } else if (!useless) {
                value -= (size - emptySpaces) * 10;
            } 
        }
        // Diagonals
        boolean allO = true;
        boolean useless = false;
        int emptySpaces = 0;
        for (int i = 0; i < size; i++) {
            if (board[i][i] == '-') {
                allO = false;
                emptySpaces++;
            } else if (board[i][i] == 'X') {
                allO = false;
                useless = true;
                break;
            }
        }
        if (allO) {
            value -= 100;
        } else if (!useless) {
            value -= (size - emptySpaces) * 10;
        } 
        allO = true;
        useless = false;
        emptySpaces = 0;
        for (int i = 0; i < size; i++) {
            if (board[i][size - i - 1] == '-') {
                allO = false;
                emptySpaces++;
            } else if (board[i][size - i - 1] == 'X') {
                allO = false;
                useless = true;
                break;
            }
        }
        if (allO) {
            value -= 100;
        } else if (!useless) {
            value -= (size - emptySpaces) * 10;
        } 
        // Output.
        return value;
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

    public GameState[] getMoves(char symbol) {
        GameState[] moves = new GameState[movesLeft()];
        int counter = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == '-') {
                    char[][] tempBoard = new char[size][size];
                    for (int a = 0; a < size; a++) {
                        for (int b = 0; b < size; b++) {
                            tempBoard[a][b] = board[a][b];
                        }
                    }
                    tempBoard[i][j] = symbol;
                    moves[counter] = new GameState(size, tempBoard);
                    counter++;
                }
            }
        }
        return moves;
    }

    public void printBoard() {
        System.out.print(" ");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + i + " ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(i);
            for (int j = 0; j < size; j++) {
                System.out.print(" " + board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }

    public char[][] getBoard() {
        return board;
    }
}