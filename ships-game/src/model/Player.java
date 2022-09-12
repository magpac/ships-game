package model;

import exceptions.InvalidOperationException;
import exceptions.WrongCharException;

public class Player {

    private Board ownBoard;
    private Board enemyBoard;
    private final char[] allowedChars = {'.', '@', 'X', '*'};

    public Player(int rows, int columns) {
        ownBoard = new Board(rows, columns, allowedChars);
        enemyBoard = new Board(rows, columns, allowedChars);
    }

    public void setShip(int row, int column, boolean isVertical, int lengthShip) throws InvalidOperationException {
        try {
            ownBoard.setShip(row,column,isVertical,lengthShip);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidOperationException("Invalid coordinates entered. The ship is off the board.", e);
        }
    }

    public void displayOwnBoard() {
        ownBoard.display();
    }

    public void displayEnemyBoard() {
        enemyBoard.display();
    }

    public String enemyShot(int row, int column) throws InvalidOperationException {
        try {
            Character mark = ownBoard.fieldStatus(row,column);
            if (mark == '@') {
                ownBoard.setField(row, column,'X');
                return "hit";
            } else {
                return "miss" ;
            }
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidOperationException("Invalid coordinates entered.", e);
        } catch (WrongCharException e) {
            throw new InvalidOperationException("Invalid character entered.", e);
        }
    }

    public void ownShotEffect(int row, int column, String result) throws InvalidOperationException {
        try {
            if ("hit".equals(result)) {
                enemyBoard.setField(row, column,'X');
            } else {
                enemyBoard.setField(row, column,'*');
            }
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidOperationException("Invalid coordinates entered.", e);
        } catch (WrongCharException e) {
            throw new InvalidOperationException("Invalid character entered.", e);
        }
    }

    public boolean isGameOver() {
       return !ownBoard.contains('@');
    }
}
