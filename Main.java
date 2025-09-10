import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please enter the sudoku riddle. NOTE: Mark empty spots on the sudoku board with a period (.).");
        System.out.println("Type exit to terminate the program.");
        String sudokuInput = getInput(); // receive input from user
        boolean match = checkPattern(sudokuInput); // check if the input is proper

        // a loop to continuously check if the correct input was provided
        while (match || sudokuInput.length() != 81) {
            if (sudokuInput.toLowerCase().equals("exit")) {
                System.out.println("Terminating program. Goodbye.");
                System.exit(0);
            }

            if (match) {
                System.out.println("You can only enter numbers and periods.");
            }

            if (sudokuInput.length() != 81) {
                System.out.println("You must input precisely 81 characters.");
            }

            sudokuInput = getInput();
            match = checkPattern(sudokuInput);
        }

        Board board = new Board(sudokuInput);
        String solution = board.solve();
        System.out.println("The final solution is: ");
        System.out.println(solution);

    }

    /*
    * A function that gets a string input from the user
    * and returns it.
    * */
    public static String getInput() {
        Scanner input = new Scanner(System.in); // The input scanner object
        System.out.print("Sudoku riddle: ");
        String sudokuInput = input.nextLine();

        return sudokuInput;
    }

    /*
    * A function that checks if the string provided by the user
    * is comprised only of periods and numbers.
    * */
    public static boolean checkPattern(String pattern) {
        Pattern pattCheck = Pattern.compile("[^0-9\\.]");
        Matcher checkMatch = pattCheck.matcher(pattern);
        boolean match = checkMatch.find();

        return match;
    }
}