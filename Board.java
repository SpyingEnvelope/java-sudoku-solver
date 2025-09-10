/*
* A class that stores the sudoku board itself.
* It also contains an array that stores the location of the all the periods.
* */
public class Board {
    String board; // The string inputted by the user after passing all checks

    /*
    * Constructor for the class. It instantiates and populates the period array.
    * */
    public Board(String board) {
        this.board = board;
    }

    /*
    * A function that checks if a number can be placed at a specified
    * position. It returns true if it can. It returns false otherwise.
    * */
    public boolean checker(int num, int position) {
        BoardChecker checker = new BoardChecker(position);
        boolean result = checker.totalChecker(this.board, num);
        return result;
    }

    public String solve() {
        Solver solver = new Solver(this.board);
        boolean solution = solver.solveSudoku();

        if (solution) {
            return solver.getBoard();
        }

        return "Sudoku puzzle cannot be solved";
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

}
