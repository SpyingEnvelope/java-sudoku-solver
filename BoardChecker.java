/*
* This class contains all the functions that check
* if a number exists in a certain row, square, or column.
*
* The functions return false if a number exists in a row, square or column.
* They return true otherwise.
* */

public class BoardChecker {
    int rowNum;
    int columnNum;

    public BoardChecker(int position) {
        this.rowNum = this.rowExtractor(position);
        this.columnNum = this.columnExtractor(position);
    }

    /*
    * This function checks if a number exists in a row.
    * */
    private boolean rowChecker(String board, int newValue) {
        if (this.rowNum == 8) {

            String rowNine = board.substring(72,81);
            if (rowNine.contains(Integer.toString(newValue))) {
                return false;
            };

        } else if (this.rowNum == 7) {

            String rowEight = board.substring(63,72);
            if (rowEight.contains(Integer.toString(newValue))) {
                return false;
            };

        } else if (this.rowNum == 6) {

            String rowSeven = board.substring(54,63);
            if (rowSeven.contains(Integer.toString(newValue))) {
                return false;
            };

        } else if (this.rowNum == 5) {

            String rowSix = board.substring(45,54);
            if (rowSix.contains(Integer.toString(newValue))) {
                return false;
            };

        } else if (this.rowNum == 4) {

            String rowFive = board.substring(36,45);
            if (rowFive.contains(Integer.toString(newValue))) {
                return false;
            };

        } else if (this.rowNum == 3) {

            String rowFour = board.substring(27,36);
            if (rowFour.contains(Integer.toString(newValue))) {
                return false;
            };

        } else if (this.rowNum == 2) {

            String rowThree = board.substring(18,27);
            if (rowThree.contains(Integer.toString(newValue))) {
                return false;
            };

        } else if (this.rowNum == 1) {

            String rowTwo = board.substring(9,18);
            if (rowTwo.contains(Integer.toString(newValue))) {
                return false;
            };

        } else {

            String rowOne = board.substring(0,9);
            if (rowOne.contains(Integer.toString(newValue))) {
                return false;
            };

        }

        return true;
    }

    /*
    * This function checks if a number exists in a square.
    * */
    private boolean squareChecker(String board, int newValue) {
        int squareNum = this.squareExtractor();
        int[] squareIndices = this.squareIndices(squareNum);

        String strValue = Integer.toString(newValue);

        for (int index : squareIndices) {
            String valueAtIndex = String.valueOf(board.charAt(index));
            if (strValue.equals(valueAtIndex)) {
                return false;
            }
        }

        return true;
    }

    /*
    * This function checks if a number exists in a column.
    * */
    private boolean columnChecker(String board, int newValue) {
        int columnIterator = this.columnNum; // an iterator to use for checking the new value
        String newValueStr = Integer.toString(newValue); // converts newValue to str for comparisons

        while (columnIterator <= 80) {
            String charNum = String.valueOf(board.charAt(columnIterator)); // convert char to str for comparisons
            if (charNum.equals(newValueStr)) {
                return false;
            }
            columnIterator += 9;
        }

        return true;
    }

    /*
    * This function returns the column number based on the position
    * and the row number.
    * */
    private int columnExtractor(int position) {
        return position - (9*this.rowNum); // this sets the current column number
    }

    /*
    * This function returns the row number of the position provided.
    * */
    private int rowExtractor(int position) {
        if (position >= 72) {
            return 8;
        } else if (position >= 63) {
            return 7;
        } else if (position >= 54) {
            return 6;
        } else if (position >= 45) {
            return 5;
        } else if (position >= 36) {
            return 4;
        } else if (position >= 27) {
            return 3;
        } else if (position >= 18) {
            return 2;
        } else if (position >= 9) {
            return 1;
        } else {
            return 0;
        }
    }

    /*
    * This function returns the square number of the
    * column and row number provided.
    * */
    private int squareExtractor() {
        if (this.rowNum <= 2 && this.columnNum <= 2) {
            return 0;
        } else if (this.rowNum <= 2 && this.columnNum <= 5) {
            return 1;
        } else if (this.rowNum <= 2 && this.columnNum <= 8) {
            return 2;
        } else if (this.rowNum <= 5 && this.columnNum <= 2) {
            return 3;
        } else if (this.rowNum <= 5 && this.columnNum <= 5) {
            return 4;
        } else if (this.rowNum <= 5 && this.columnNum <= 8) {
            return 5;
        } else if (this.rowNum <= 8 && this.columnNum <= 2) {
            return 6;
        } else if (this.rowNum <= 8 && this.columnNum <= 5) {
            return 7;
        } else {
            return 8;
        }
    }

    /*
    * This function returns the square indices in the square number
    * */
    private int[] squareIndices(int squareNum) {
        int[] indicesArray;

        switch(squareNum) {
            case 0:
                indicesArray = new int[]{0, 1, 2, 9, 10, 11, 18, 19, 20};
                break;
            case 1:
                indicesArray = new int[]{3, 4, 5, 12, 13, 14, 21, 22, 23};
                break;
            case 2:
                indicesArray = new int[]{6, 7, 8, 15, 16, 17, 24, 25, 26};
                break;
            case 3:
                indicesArray = new int[]{27, 28, 29, 36, 37, 38, 45, 46, 47};
                break;
            case 4:
                indicesArray = new int[]{30, 31, 32, 39, 40, 41, 48, 49, 50};
                break;
            case 5:
                indicesArray = new int[]{33, 34, 35, 42, 43, 44, 51, 52, 53};
                break;
            case 6:
                indicesArray = new int[]{54, 55, 56, 63, 64, 65, 72, 73, 74};
                break;
            case 7:
                indicesArray = new int[]{57, 58, 59, 66, 67, 68, 75, 76, 77};
                break;
            default:
                indicesArray = new int[]{60, 61, 62, 69, 70, 71, 78, 79, 80};
                break;
        }

        return indicesArray;
    }

    /*
    * A function that runs all of the checker functions.
    * It returns true if all checkers return true.
    * */
    public boolean totalChecker (String board, int newValue) {
        boolean row = this.rowChecker(board, newValue);
        boolean column = this.columnChecker(board, newValue);
        boolean square = this.squareChecker(board, newValue);

        if (!row || !column || !square) {
            return false;
        }

        return true;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getColumnNum() {
        return columnNum;
    }

    public void setColumnNum(int columnNum) {
        this.columnNum = columnNum;
    }
}
