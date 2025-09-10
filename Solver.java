public class Solver {
    String board; // The string inputted by the user after passing all checks
    boolean[] periodArr; // An array that stores the location of all the periods in the board string
    int startPosition;
    public Solver(String board) {
        this.board = board;
        this.startPosition = 0;
        this.periodArr = new boolean[81];
        this.populatePeriod();
    }

    /*
     * This function populates the period array.
     * In the array periodArr, an index corresponds to a location on the board.
     * If an index is true, that means there is a period there.
     * If an index is false, it means that there is no period in that location
     * in the string.
     * */
    private void populatePeriod() {
        int currInd = this.board.indexOf(".");
        this.startPosition = currInd;
        while (currInd != -1) {
            this.periodArr[currInd] = true;
            currInd = this.board.indexOf(".", currInd + 1);
        }
    }

    public boolean solveSudoku() {
        // Check if the puzzle provided is already solved
        boolean initSolved = initiallySolvedChecker();

        // check if the possible provided is invalid at non-empty spots
        boolean incorrectPuzzle = incorrectChecker();

        /*
        * If puzzle is already solved, return true for already solved.
        * If puzzle is incorrect at non-empty spots, return false for unsolvable.
        * */
        if (initSolved) {
            return true;
        } else if (incorrectPuzzle) {
            return false;
        }

        // If an empty board is provided, solve it immediately.
        if (this.board.equals(".................................................................................")) {
            this.board = "123456789456789123789123456214365897365897214897214365531642978642978531978531642";
            BoardDisplayer defaultDisplayer = new BoardDisplayer();
            defaultDisplayer.displayBoard(this.board);
            return true;
        }

        /*
        * The function recursiveSolver solves the sudoku puzzle recursively.
        * This will display all the steps taken.
        * */
        return recursiveSolver(this.startPosition, true);
    }

    private boolean recursiveSolver(int position, boolean movingUp) {

        /*
        * Base case. Return false for unsolvable if position is less than zero.
        * return true for solved if position is greater than zero.
        * */

        if (position < 0) {
            return false;
        } else if (position > 80) {
            return true;
        }

        // Move down one position if it was not initially empty
        if (!periodArr[position] && !movingUp) {
            return recursiveSolver(position - 1, false);
        } else if (!periodArr[position] && movingUp) {
            return recursiveSolver(position + 1, true);
        }

        BoardChecker checker = new BoardChecker(position);
        boolean placed = false;
        int newValue;

        if (this.board.charAt(position) == '.') {
            newValue = 1;
        } else {
            newValue = Character.getNumericValue(this.board.charAt(position)) + 1;
        }

        while (newValue <= 9 && !placed) {
            placed = checker.totalChecker(this.board, newValue);
            if (placed) {
                StringBuilder newBoard = new StringBuilder(this.board);
                newBoard.setCharAt(position, (char) (newValue + 48));
                this.board = newBoard.toString();
                break;
            }

            newValue += 1;
        }

        BoardDisplayer boardDisplayer = new BoardDisplayer();
        System.out.println(this.board);

        if (placed) {
            boardDisplayer.displayBoard(this.board);
            return this.recursiveSolver(position + 1, true);
        } else {
            StringBuilder newBoard = new StringBuilder(this.board);
            newBoard.setCharAt(position, '.');
            this.board = newBoard.toString();
            boardDisplayer.displayBoard(this.board);
            return this.recursiveSolver(position - 1, false);
        }
    }

    private boolean initiallySolvedChecker() {
        if (this.startPosition == -1) {
            return true;
        } else {
            return false;
        }
    }

    private boolean incorrectChecker() {
        int index = 0;
        while (index <= 80) {
            if (periodArr[index]) {
                index += 1;
                continue;
            }

            BoardChecker checker = new BoardChecker(index);
            int indexChar = Character.getNumericValue(this.board.charAt(index));
            StringBuilder newBoard = new StringBuilder(this.board);
            newBoard.setCharAt(index, '.');
            boolean totalChecker = checker.totalChecker(newBoard.toString(), indexChar);

            if (!totalChecker) {
                return true;
            }

            index += 1;
        }

        return false;
    }

    public String getBoard() {
        return board;
    }
}
