package Piece;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static Main.Main.*;

public class Knight {
    public int row = -1;
    public int col = -1;
    public String color = "";

    public Knight(int row, int col, String color) {
        this.row = row;
        this.col = col;
        this.color = color;
    }

    public List<JLabel> movableCells() {
        List<JLabel> ans = new ArrayList<>();
        if (Objects.equals(this.color, "white")) {
            //upper right
            if (row - 2 >= 0 && col + 1 < board.length) {
                if (isEmpty(board[row - 2][col + 1]) && canMove(row, col, row - 2, col + 1)) {
                    ans.add(board[row - 2][col + 1]);
                }
                if (isEmpty(board[row - 2][col + 1]) && !getType((ImageIcon) board[row - 2][col + 1].getIcon()).equals("king") && canMove(row, col, row - 2, col + 1)) {
                    ans.add(board[row - 2][col + 1]);
                }
            }

            //upper left
            if (row - 2 >= 0 && col - 1 >= 0) {
                if (isEmpty(board[row - 2][col - 1]) && canMove(row, col, row - 2, col - 1)) {
                    ans.add(board[row - 2][col - 1]);
                }
                if (isBlack(board[row - 2][col - 1]) && !getType((ImageIcon) board[row - 2][col - 1].getIcon()).equals("king") && canMove(row, col, row - 2, col - 1)) {
                    ans.add(board[row - 2][col - 1]);
                }
            }

            //lower right
            if (row + 2 < board.length && col + 1 < board.length) {
                if (isEmpty(board[row + 2][col + 1]) && canMove(row, col, row + 2, col + 1)) {
                    ans.add(board[row + 2][col + 1]);
                }
                if (isBlack(board[row + 2][col + 1]) && !getType((ImageIcon) board[row + 2][col + 1].getIcon()).equals("king") && canMove(row, col, row + 2, col + 1)) {
                    ans.add(board[row + 2][col + 1]);
                }
            }

            //lower left
            if (row + 2 < board.length && col - 1 >= 0) {
                if (isEmpty(board[row + 2][col - 1]) && canMove(row, col, row + 2, col - 1)) {
                    ans.add(board[row + 2][col - 1]);
                }
                if (isBlack(board[row + 2][col - 1]) && !getType((ImageIcon) board[row + 2][col - 1].getIcon()).equals("king") && canMove(row, col, row + 2, col - 1)) {
                    ans.add(board[row + 2][col - 1]);
                }
            }

            //left down
            if (row + 1 < board.length && col - 2 >= 0) {
                if (isEmpty(board[row + 1][col - 2]) && canMove(row, col, row + 1, col - 2)) {
                    ans.add(board[row + 1][col - 2]);
                }
                if (isBlack(board[row + 1][col - 2]) && !getType((ImageIcon) board[row + 1][col - 2].getIcon()).equals("king") && canMove(row, col, row + 1, col - 2)) {
                    ans.add(board[row + 1][col - 2]);
                }
            }

            //left up
            if (row - 1 >= 0 && col - 2 >= 0) {
                if (isEmpty(board[row - 1][col - 2]) && canMove(row, col, row - 1, col - 2)) {
                    ans.add(board[row - 1][col - 2]);
                }
                if (isBlack(board[row - 1][col - 2]) && !getType((ImageIcon) board[row - 1][col - 2].getIcon()).equals("king") && canMove(row, col, row - 1, col - 2)) {
                    ans.add(board[row - 1][col - 2]);
                }
            }

            //right down
            if (row + 1 < board.length && col + 2 < board.length) {
                if (isEmpty(board[row + 1][col + 2]) && canMove(row, col, row + 1, col + 2)) {
                    ans.add(board[row + 1][col + 2]);
                }
                if (isBlack(board[row + 1][col + 2]) && !getType((ImageIcon) board[row + 1][col + 2].getIcon()).equals("king") && canMove(row, col, row + 1, col + 2)) {
                    ans.add(board[row + 1][col + 2]);
                }
            }

            //right up
            if (row - 1 >= 0 && col + 2 < board.length) {
                if (isEmpty(board[row - 1][col + 2]) && canMove(row, col, row - 1, col + 2)) {
                    ans.add(board[row - 1][col + 2]);
                }
                if (isBlack(board[row - 1][col + 2]) && !getType((ImageIcon) board[row - 1][col + 2].getIcon()).equals("king") && canMove(row, col, row - 1, col + 2)) {
                    ans.add(board[row - 1][col + 2]);
                }
            }
        } else {
            //upper right
            if (row - 2 >= 0 && col + 1 < board.length) {
                if (isEmpty(board[row - 2][col + 1]) && canMove(row, col, row - 2, col + 1)) {
                    ans.add(board[row - 2][col + 1]);
                }
                if (isWhite(board[row - 2][col + 1]) && !getType((ImageIcon) board[row - 2][col + 1].getIcon()).equals("king") && canMove(row, col, row - 2, col + 1)) {
                    ans.add(board[row - 2][col + 1]);
                }
            }

            //upper left
            if (row - 2 >= 0 && col - 1 >= 0) {
                if (isEmpty(board[row - 2][col - 1]) && canMove(row, col, row - 2, col - 1)) {
                    ans.add(board[row - 2][col - 1]);
                }
                if (isWhite(board[row - 2][col - 1]) && !getType((ImageIcon) board[row - 2][col - 1].getIcon()).equals("king") && canMove(row, col, row - 2, col - 1)) {
                    ans.add(board[row - 2][col - 1]);
                }
            }

            //lower right
            if (row + 2 < board.length && col + 1 < board.length) {
                if (isEmpty(board[row + 2][col + 1]) && canMove(row, col, row + 2, col + 1)) {
                    ans.add(board[row + 2][col + 1]);
                }
                if (isWhite(board[row + 2][col + 1]) && !getType((ImageIcon) board[row + 2][col + 1].getIcon()).equals("king") && canMove(row, col, row + 2, col + 1)) {
                    ans.add(board[row + 2][col + 1]);
                }
            }

            //lower left
            if (row + 2 < board.length && col - 1 >= 0) {
                if (isEmpty(board[row + 2][col - 1]) && canMove(row, col, row + 2, col - 1)) {
                    ans.add(board[row + 2][col - 1]);
                }
                if (isWhite(board[row + 2][col - 1]) && !getType((ImageIcon) board[row + 2][col - 1].getIcon()).equals("king") && canMove(row, col, row + 2, col - 1)) {
                    ans.add(board[row + 2][col - 1]);
                }
            }

            //left down
            if (row + 1 < board.length && col - 2 >= 0) {
                if (isEmpty(board[row + 1][col - 2]) && canMove(row, col, row + 1, col - 2)) {
                    ans.add(board[row + 1][col - 2]);
                }
                if (isWhite(board[row + 1][col - 2]) && !getType((ImageIcon) board[row + 1][col - 2].getIcon()).equals("king") && canMove(row, col, row + 1, col - 2)) {
                    ans.add(board[row + 1][col - 2]);
                }
            }

            //left up
            if (row - 1 >= 0 && col - 2 >= 0) {
                if (isEmpty(board[row - 1][col - 2]) && canMove(row, col, row - 1, col - 2)) {
                    ans.add(board[row - 1][col - 2]);
                }
                if (isWhite(board[row - 1][col - 2]) && !getType((ImageIcon) board[row - 1][col - 2].getIcon()).equals("king") && canMove(row, col, row - 1, col - 2)) {
                    ans.add(board[row - 1][col - 2]);
                }
            }

            //right down
            if (row + 1 < board.length && col + 2 < board.length) {
                if (isEmpty(board[row + 1][col + 2]) && canMove(row, col, row + 1, col + 2)) {
                    ans.add(board[row + 1][col + 2]);
                }
                if (isWhite(board[row + 1][col + 2]) && !getType((ImageIcon) board[row + 1][col + 2].getIcon()).equals("king") && canMove(row, col, row + 1, col + 2)) {
                    ans.add(board[row + 1][col + 2]);
                }
            }

            //right up
            if (row - 1 >= 0 && col + 2 < board.length) {
                if (isEmpty(board[row - 1][col + 2]) && canMove(row, col, row - 1, col + 2)) {
                    ans.add(board[row - 1][col + 2]);
                }
                if (isWhite(board[row - 1][col + 2]) && !getType((ImageIcon) board[row - 1][col + 2].getIcon()).equals("king") && canMove(row, col, row - 1, col + 2)) {
                    ans.add(board[row - 1][col + 2]);
                }
            }
        }
        return ans;
    }

    public void highlightCells(int row, int col) {
        //unselect rest
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if ((i + j) % 2 != 0) {
                    board[i][j].setBackground(darkSquare); // Dark square color
                } else {
                    board[i][j].setBackground(lightSquare); // Light square color
                }
            }
        }
        if (Objects.equals(this.color, "white")) {
            //upper right
            if (row - 2 >= 0 && col + 1 < board.length) {
                if (isEmpty(board[row - 2][col + 1]) && canMove(row, col, row - 2, col + 1)) {
                    board[row - 2][col + 1].setBackground(blueHighlight);
                    board[row - 2][col + 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
                if (isBlack(board[row - 2][col + 1]) && !getType((ImageIcon) board[row - 2][col + 1].getIcon()).equals("king") && canMove(row, col, row - 2, col + 1)) {
                    board[row - 2][col + 1].setBackground(redHighlight);
                    board[row - 2][col + 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }

            //upper left
            if (row - 2 >= 0 && col - 1 >= 0) {
                if (isEmpty(board[row - 2][col - 1]) && canMove(row, col, row - 2, col - 1)) {
                    board[row - 2][col - 1].setBackground(blueHighlight);
                    board[row - 2][col - 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
                if (isBlack(board[row - 2][col - 1]) && !getType((ImageIcon) board[row - 2][col - 1].getIcon()).equals("king") && canMove(row, col, row - 2, col - 1)) {
                    board[row - 2][col - 1].setBackground(redHighlight);
                    board[row - 2][col - 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }

            //lower right
            if (row + 2 < board.length && col + 1 < board.length) {
                if (isEmpty(board[row + 2][col + 1]) && canMove(row, col, row + 2, col + 1)) {
                    board[row + 2][col + 1].setBackground(blueHighlight);
                    board[row + 2][col + 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
                if (isBlack(board[row + 2][col + 1]) && !getType((ImageIcon) board[row + 2][col + 1].getIcon()).equals("king") && canMove(row, col, row + 2, col + 1)) {
                    board[row + 2][col + 1].setBackground(redHighlight);
                    board[row + 2][col + 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }

            //lower left
            if (row + 2 < board.length && col - 1 >= 0) {
                if (isEmpty(board[row + 2][col - 1]) && canMove(row, col, row + 2, col - 1)) {
                    board[row + 2][col - 1].setBackground(blueHighlight);
                    board[row + 2][col - 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
                if (isBlack(board[row + 2][col - 1]) && !getType((ImageIcon) board[row + 2][col - 1].getIcon()).equals("king") && canMove(row, col, row + 2, col - 1)) {
                    board[row + 2][col - 1].setBackground(redHighlight);
                    board[row + 2][col - 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }

            //left down
            if (row + 1 < board.length && col - 2 >= 0) {
                if (isEmpty(board[row + 1][col - 2]) && canMove(row, col, row + 1, col - 2)) {
                    board[row + 1][col - 2].setBackground(blueHighlight);
                    board[row + 1][col - 2].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
                if (isBlack(board[row + 1][col - 2]) && !getType((ImageIcon) board[row + 1][col - 2].getIcon()).equals("king") && canMove(row, col, row + 1, col - 2)) {
                    board[row + 1][col - 2].setBackground(redHighlight);
                    board[row + 1][col - 2].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }

            //left up
            if (row - 1 >= 0 && col - 2 >= 0) {
                if (isEmpty(board[row - 1][col - 2]) && canMove(row, col, row - 1, col - 2)) {
                    board[row - 1][col - 2].setBackground(blueHighlight);
                    board[row - 1][col - 2].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
                if (isBlack(board[row - 1][col - 2]) && !getType((ImageIcon) board[row - 1][col - 2].getIcon()).equals("king") && canMove(row, col, row - 1, col - 2)) {
                    board[row - 1][col - 2].setBackground(redHighlight);
                    board[row - 1][col - 2].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }

            //right down
            if (row + 1 < board.length && col + 2 < board.length) {
                if (isEmpty(board[row + 1][col + 2]) && canMove(row, col, row + 1, col + 2)) {
                    board[row + 1][col + 2].setBackground(blueHighlight);
                    board[row + 1][col + 2].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
                if (isBlack(board[row + 1][col + 2]) && !getType((ImageIcon) board[row + 1][col + 2].getIcon()).equals("king") && canMove(row, col, row + 1, col + 2)) {
                    board[row + 1][col + 2].setBackground(redHighlight);
                    board[row + 1][col + 2].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }

            //right up
            if (row - 1 >= 0 && col + 2 < board.length) {
                if (isEmpty(board[row - 1][col + 2]) && canMove(row, col, row - 1, col + 2)) {
                    board[row - 1][col + 2].setBackground(blueHighlight);
                    board[row - 1][col + 2].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
                if (isBlack(board[row - 1][col + 2]) && !getType((ImageIcon) board[row - 1][col + 2].getIcon()).equals("king") && canMove(row, col, row - 1, col + 2)) {
                    board[row - 1][col + 2].setBackground(redHighlight);
                    board[row - 1][col + 2].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }
        } else {
            //upper right
            if (row - 2 >= 0 && col + 1 < board.length) {
                if (isEmpty(board[row - 2][col + 1]) && canMove(row, col, row - 2, col + 1)) {
                    board[row - 2][col + 1].setBackground(blueHighlight);
                    board[row - 2][col + 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
                if (isWhite(board[row - 2][col + 1]) && !getType((ImageIcon) board[row - 2][col + 1].getIcon()).equals("king") && canMove(row, col, row - 2, col + 1)) {
                    board[row - 2][col + 1].setBackground(redHighlight);
                    board[row - 2][col + 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }

            //upper left
            if (row - 2 >= 0 && col - 1 >= 0) {
                if (isEmpty(board[row - 2][col - 1]) && canMove(row, col, row - 2, col - 1)) {
                    board[row - 2][col - 1].setBackground(blueHighlight);
                    board[row - 2][col - 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
                if (isWhite(board[row - 2][col - 1]) && !getType((ImageIcon) board[row - 2][col - 1].getIcon()).equals("king")) {
                    board[row - 2][col - 1].setBackground(redHighlight);
                    board[row - 2][col - 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }

            //lower right
            if (row + 2 < board.length && col + 1 < board.length) {
                if (isEmpty(board[row + 2][col + 1]) && canMove(row, col, row + 2, col + 1)) {
                    board[row + 2][col + 1].setBackground(blueHighlight);
                    board[row + 2][col + 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
                if (isWhite(board[row + 2][col + 1]) && !getType((ImageIcon) board[row + 2][col + 1].getIcon()).equals("king") && canMove(row, col, row + 2, col + 1)) {
                    board[row + 2][col + 1].setBackground(redHighlight);
                    board[row + 2][col + 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }

            //lower left
            if (row + 2 < board.length && col - 1 >= 0) {
                if (isEmpty(board[row + 2][col - 1]) && canMove(row, col, row + 2, col - 1)) {
                    board[row + 2][col - 1].setBackground(blueHighlight);
                    board[row + 2][col - 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
                if (isWhite(board[row + 2][col - 1]) && !getType((ImageIcon) board[row + 2][col - 1].getIcon()).equals("king") && canMove(row, col, row + 2, col - 1)) {
                    board[row + 2][col - 1].setBackground(redHighlight);
                    board[row + 2][col - 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }

            //left down
            if (row + 1 < board.length && col - 2 >= 0) {
                if (isEmpty(board[row + 1][col - 2]) && canMove(row, col, row + 1, col - 2)) {
                    board[row + 1][col - 2].setBackground(blueHighlight);
                    board[row + 1][col - 2].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
                if (isWhite(board[row + 1][col - 2]) && !getType((ImageIcon) board[row + 1][col - 2].getIcon()).equals("king")) {
                    board[row + 1][col - 2].setBackground(redHighlight);
                    board[row + 1][col - 2].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }

            //left up
            if (row - 1 >= 0 && col - 2 >= 0) {
                if (isEmpty(board[row - 1][col - 2]) && canMove(row, col, row - 1, col - 2)) {
                    board[row - 1][col - 2].setBackground(blueHighlight);
                    board[row - 1][col - 2].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
                if (isWhite(board[row - 1][col - 2]) && !getType((ImageIcon) board[row - 1][col - 2].getIcon()).equals("king") && canMove(row, col, row - 1, col - 2)) {
                    board[row - 1][col - 2].setBackground(redHighlight);
                    board[row - 1][col - 2].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }

            //right down
            if (row + 1 < board.length && col + 2 < board.length) {
                if (isEmpty(board[row + 1][col + 2]) && canMove(row, col, row + 1, col + 2)) {
                    board[row + 1][col + 2].setBackground(blueHighlight);
                    board[row + 1][col + 2].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
                if (isWhite(board[row + 1][col + 2]) && !getType((ImageIcon) board[row + 1][col + 2].getIcon()).equals("king") && canMove(row, col, row + 1, col + 2)) {
                    board[row + 1][col + 2].setBackground(redHighlight);
                    board[row + 1][col + 2].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }

            //right up
            if (row - 1 >= 0 && col + 2 < board.length) {
                if (isEmpty(board[row - 1][col + 2]) && canMove(row, col, row - 1, col + 2)) {
                    board[row - 1][col + 2].setBackground(blueHighlight);
                    board[row - 1][col + 2].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
                if (isWhite(board[row - 1][col + 2]) && !getType((ImageIcon) board[row - 1][col + 2].getIcon()).equals("king") && canMove(row, col, row - 1, col + 2)) {
                    board[row - 1][col + 2].setBackground(redHighlight);
                    board[row - 1][col + 2].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }
        }
    }
    public boolean canMove(int prevRow, int prevCol, int row, int col){
        if(Objects.equals(this.color, "white")){
            ImageIcon temp = (ImageIcon) board[row][col].getIcon();
            board[row][col].setIcon(whiteKnight1);
            board[prevRow][prevCol].setIcon(null);
            if(isCheck("white", board)){
                board[row][col].setIcon(temp);
                board[prevRow][prevCol].setIcon(whiteKnight1);
                return false;
            }
            else{
                board[row][col].setIcon(temp);
                board[prevRow][prevCol].setIcon(whiteKnight1);
                return true;
            }
        }
        else{
            ImageIcon temp = (ImageIcon) board[row][col].getIcon();
            board[row][col].setIcon(blackKnight1);
            board[prevRow][prevCol].setIcon(null);
            if(isCheck("black", board)){
                board[row][col].setIcon(temp);
                board[prevRow][prevCol].setIcon(blackKnight1);
                return false;
            }
            else{
                board[row][col].setIcon(temp);
                board[prevRow][prevCol].setIcon(blackKnight1);
                return true;
            }
        }
    }
}
