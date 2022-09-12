package model;

import exceptions.InvalidOperationException;
import exceptions.WrongCharException;

public class Board {
    private final Character[][] boardContent;
    private final char[] allowedChars;

    public Board(int rows, int columns, char[] allowedChars) {
        boardContent = new Character[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                boardContent[i][j] = '.';
            }
        }
        this.allowedChars = allowedChars;
    }

    public void display() {
        for (int i = 0; i < boardContent.length; i++) {
            for (int j = 0; j < boardContent[i].length; j++) {
                System.out.print(boardContent[i][j]);
            }
            System.out.println();
        }
    }

    public void setShip(int row, int column, boolean isVertical, int lengthShip) throws IndexOutOfBoundsException, InvalidOperationException {
        for (int i = row; i < row + lengthShip; i++) {
            for (int j = column; j < column + lengthShip; j++) {
                if (isVertical) {
                    if (boardContent[i][column] == '@') {
                        throw new InvalidOperationException("Invalid coordinates entered. The ship overlaps another.");
                    }
                } else {
                    if (boardContent[row][j] == '@') {
                        throw new InvalidOperationException("Invalid coordinates entered. The ship overlaps another.");
                    }
                }
            }
        }

        for (int i = row; i < row + lengthShip; i++) {
            for (int j = column; j < column + lengthShip; j++) {
                if (isVertical) {
                    if (isAdjoin(i, column)) {
                        throw new InvalidOperationException("Invalid coordinates entered. Ships cannot touch each other.");
                    }
                } else {
                    if (isAdjoin(row, j)) {
                        throw new InvalidOperationException("Invalid coordinates entered. Ships cannot touch each other.");
                    }
                }
            }
        }

        for (int i = row; i < row + lengthShip; i++) {
            for (int j = column; j < column + lengthShip; j++) {
                if (isVertical) {
                    boardContent[i][column] = '@';
                } else {
                    boardContent[row][j] = '@';
                }
            }
        }
    }

    private boolean isAdjoin(int row, int column) {
        if (row - 1 >= 0 && column - 1 >= 0 && boardContent[row - 1][column - 1] == '@') {
            return true;
        } else if (row - 1 >= 0 && boardContent[row - 1][column] == '@') {
            return true;
        } else if (row - 1 >= 0 && column + 1 < boardContent[row - 1].length && boardContent[row - 1][column + 1] == '@') {
            return true;
        } else if (column - 1 >= 0 && boardContent[row][column - 1] == '@') {
            return true;
        } else if (column + 1 < boardContent[row].length && boardContent[row][column + 1] == '@') {
            return true;
        } else if (row + 1 < boardContent.length && column - 1 >= 0 && boardContent[row + 1][column - 1] == '@') {
            return true;
        } else if (row + 1 < boardContent.length && boardContent[row + 1][column] == '@') {
            return true;
        } else if (row + 1 < boardContent.length && column + 1 < boardContent[row + 1].length && boardContent[row + 1][column + 1] == '@') {
            return true;
        }
        return false;
    }

    public Character fieldStatus(int row, int column) throws IndexOutOfBoundsException {
        return boardContent[row][column];
    }

    public void setField(int row, int column, Character mark) throws IndexOutOfBoundsException, WrongCharException {
        boolean doesContain = false;
        for (int i = 0; i < allowedChars.length; i++) {
            if (mark == allowedChars[i]) {
                doesContain = true;
            }
        }
        if (!doesContain) {
            throw new WrongCharException();
        }
        boardContent[row][column] = mark;
    }

    public boolean contains(Character mark) {
        for (int i = 0; i < boardContent.length; i++) {
            for (int j = 0; j < boardContent[i].length; j++) {
                if (boardContent[i][j] == mark) {
                    return true;
                }
            }
        }
        return false;
    }
}
