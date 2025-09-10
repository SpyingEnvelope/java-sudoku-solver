/*
* This class is just created to display the board
* throughout the solving process.
* */

public class BoardDisplayer {

    /*
    * This method prints the sudoku board onto the console
    * */
    public void displayBoard(String board) {
        String row1 = "|" + board.substring(0,3) + "|" + board.substring(3,6) + "|" + board.substring(6,9) + "|";
        String row2 = "|" + board.substring(9,12) + "|" + board.substring(12,15) + "|" + board.substring(15,18) + "|";
        String row3 = "|" + board.substring(18,21) + "|" + board.substring(21,24) + "|" + board.substring(24,27) + "|";
        String row4 = "|" + board.substring(27,30) + "|" + board.substring(30,33) + "|" + board.substring(33,36) + "|";
        String row5 = "|" + board.substring(36,39) + "|" + board.substring(39,42) + "|" + board.substring(42,45) + "|";
        String row6 = "|" + board.substring(45,48) + "|" + board.substring(48,51) + "|" + board.substring(51,54) + "|";
        String row7 = "|" + board.substring(54,57) + "|" + board.substring(57,60) + "|" + board.substring(60,63) + "|";
        String row8 = "|" + board.substring(63,66) + "|" + board.substring(66,69) + "|" + board.substring(69,72) + "|";
        String row9 = "|" + board.substring(72,75) + "|" + board.substring(75,78) + "|" + board.substring(78,81) + "|";

        this.displaySpacer();
        System.out.println(row1);
        this.displaySpacer();
        System.out.println(row2);
        this.displaySpacer();
        System.out.println(row3);
        this.displaySpacer();
        System.out.println(row4);
        this.displaySpacer();
        System.out.println(row5);
        this.displaySpacer();
        System.out.println(row6);
        this.displaySpacer();
        System.out.println(row7);
        this.displaySpacer();
        System.out.println(row8);
        this.displaySpacer();
        System.out.println(row9);

    }

    /*
    * This method prints a horizontal line onto the console.
    * */
    private void displaySpacer() {
        System.out.println("――――――――");
    }

}
