package Piece;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static Main.Main.*;
import static Main.Main.board;

public class Rook {
    public int row = -1;
    public int col = -1;
    public String color = "";

    public Rook(int row, int col, String color) {
        this.row = row;
        this.col = col;
        this.color = color;
    }

    public List<JLabel> movableCells() {
        List<JLabel> ans = new ArrayList<>();
        if (Objects.equals(this.color, "white")) {
            //forward
            for (int i = row - 1; i >= 0; i--) {
                if(!canMove(row, col, i, col)){
                    continue;
                }
                if (isWhite(board[i][col]) || (isBlack(board[i][col]) && getType((ImageIcon) board[i][col].getIcon()).equals("king"))) {
                    break;
                }
                if (isBlack(board[i][col])) {
                    ans.add(board[i][col]);
                    break;
                }
                ans.add(board[i][col]);
            }

            //backward
            for (int i = row + 1; i < board.length; i++) {
                if(!canMove(row, col, i, col)){
                    continue;
                }
                if (isWhite(board[i][col]) || (isBlack(board[i][col]) && getType((ImageIcon) board[i][col].getIcon()).equals("king"))) {
                    break;
                }
                if (isBlack(board[i][col])) {
                    ans.add(board[i][col]);
                    break;
                }
                ans.add(board[i][col]);
            }

            //left
            for (int i = col - 1; i >= 0; i--) {
                if(!canMove(row, col, row, i)){
                    continue;
                }
                if (isWhite(board[row][i]) || (isBlack(board[row][i]) && getType((ImageIcon) board[row][i].getIcon()).equals("king"))) {
                    break;
                }
                if (isBlack(board[row][i])) {
                    ans.add(board[row][i]);
                    break;
                }
                ans.add(board[row][i]);
            }

            //right
            for (int i = col + 1; i < board.length; i++) {
                if(!canMove(row, col, row, i)){
                    continue;
                }
                if (isWhite(board[row][i]) || (isBlack(board[row][i]) && getType((ImageIcon) board[row][i].getIcon()).equals("king"))) {
                    break;
                }
                if (isBlack(board[row][i])) {
                    ans.add(board[row][i]);
                    break;
                }
                ans.add(board[row][i]);
            }
        } else {
            //forward
            for (int i = row - 1; i >= 0; i--) {
                if(!canMove(row, col, i, col)){
                    continue;
                }
                if (isBlack(board[i][col]) || (isWhite(board[i][col]) && getType((ImageIcon) board[i][col].getIcon()).equals("king"))) {
                    break;
                }
                if (isWhite(board[i][col])) {
                    ans.add(board[i][col]);
                    break;
                }
                ans.add(board[i][col]);
            }

            //backward
            for (int i = row + 1; i < board.length; i++) {
                if(!canMove(row, col, i, col)){
                    continue;
                }
                if (isBlack(board[i][col]) || (isWhite(board[i][col]) && getType((ImageIcon) board[i][col].getIcon()).equals("king"))) {
                    break;
                }
                if (isWhite(board[i][col])) {
                    ans.add(board[i][col]);
                    break;
                }
                ans.add(board[i][col]);
            }

            //left
            for (int i = col - 1; i >= 0; i--) {
                if(!canMove(row, col, row, i)){
                    continue;
                }
                if (isBlack(board[row][i]) || (isWhite(board[row][i]) && getType((ImageIcon) board[row][i].getIcon()).equals("king"))) {
                    break;
                }
                if (isWhite(board[row][i])) {
                    ans.add(board[row][i]);
                    break;
                }
                ans.add(board[row][i]);
            }

            //right
            for (int i = col + 1; i < board.length; i++) {
                if(!canMove(row, col, row, i)){
                    continue;
                }
                if (isBlack(board[row][i]) || (isWhite(board[row][i]) && getType((ImageIcon) board[row][i].getIcon()).equals("king"))) {
                    break;
                }
                if (isWhite(board[row][i])) {
                    ans.add(board[row][i]);
                    break;
                }
                ans.add(board[row][i]);
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
            //forward
            for (int i = row - 1; i >= 0; i--) {
                if(!canMove(row, col, i, col)){
                    continue;
                }
                if (isWhite(board[i][col]) || (isBlack(board[i][col]) && getType((ImageIcon) board[i][col].getIcon()).equals("king"))) {
                    break;
                }
                if (isBlack(board[i][col])) {
                    board[i][col].setBackground(redHighlight);
                    board[i][col].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    break;
                }
                board[i][col].setBackground(blueHighlight);
                board[i][col].setBorder(BorderFactory.createLineBorder(Color.black, 1));
            }

            //backward
            for (int i = row + 1; i < board.length; i++) {
                if(!canMove(row, col, i, col)){
                    continue;
                }
                if (isWhite(board[i][col]) || (isBlack(board[i][col]) && getType((ImageIcon) board[i][col].getIcon()).equals("king"))) {
                    break;
                }
                if (isBlack(board[i][col])) {
                    board[i][col].setBackground(redHighlight);
                    board[i][col].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    break;
                }
                board[i][col].setBackground(blueHighlight);
                board[i][col].setBorder(BorderFactory.createLineBorder(Color.black, 1));
            }

            //left
            for (int i = col - 1; i >= 0; i--) {
                if(!canMove(row, col, row, i)){
                    continue;
                }
                if (isWhite(board[row][i]) || (isBlack(board[row][i]) && getType((ImageIcon) board[row][i].getIcon()).equals("king"))) {
                    break;
                }
                if (isBlack(board[row][i])) {
                    board[row][i].setBackground(redHighlight);
                    board[row][i].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    break;
                }
                board[row][i].setBackground(blueHighlight);
                board[row][i].setBorder(BorderFactory.createLineBorder(Color.black, 1));
            }

            //right
            for (int i = col + 1; i < board.length; i++) {
                if(!canMove(row, col, row, i)){
                    continue;
                }
                if (isWhite(board[row][i]) || (isBlack(board[row][i]) && getType((ImageIcon) board[row][i].getIcon()).equals("king"))) {
                    break;
                }
                if (isBlack(board[row][i])) {
                    board[row][i].setBackground(redHighlight);
                    board[row][i].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    break;
                }
                board[row][i].setBackground(blueHighlight);
                board[row][i].setBorder(BorderFactory.createLineBorder(Color.black, 1));
            }
        } else {
            //forward
            for (int i = row - 1; i >= 0; i--) {
                if(!canMove(row, col, i, col)){
                    continue;
                }
                if (isBlack(board[i][col]) || (isWhite(board[i][col]) && getType((ImageIcon) board[i][col].getIcon()).equals("king"))) {
                    break;
                }
                if (isWhite(board[i][col])) {
                    board[i][col].setBackground(redHighlight);
                    board[i][col].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    break;
                }
                board[i][col].setBackground(blueHighlight);
                board[i][col].setBorder(BorderFactory.createLineBorder(Color.black, 1));
            }

            //backward
            for (int i = row + 1; i < board.length; i++) {
                if(!canMove(row, col, i, col)){
                    continue;
                }
                if (isBlack(board[i][col]) || (isWhite(board[i][col]) && getType((ImageIcon) board[i][col].getIcon()).equals("king"))) {
                    break;
                }
                if (isWhite(board[i][col])) {
                    board[i][col].setBackground(redHighlight);
                    board[i][col].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    break;
                }
                board[i][col].setBackground(blueHighlight);
                board[i][col].setBorder(BorderFactory.createLineBorder(Color.black, 1));
            }

            //left
            for (int i = col - 1; i >= 0; i--) {
                if(!canMove(row, col, row, i)){
                    continue;
                }
                if (isBlack(board[row][i]) || (isWhite(board[row][i]) && getType((ImageIcon) board[row][i].getIcon()).equals("king"))) {
                    break;
                }
                if (isWhite(board[row][i])) {
                    board[row][i].setBackground(redHighlight);
                    board[row][i].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    break;
                }
                board[row][i].setBackground(blueHighlight);
                board[row][i].setBorder(BorderFactory.createLineBorder(Color.black, 1));
            }

            //right
            for (int i = col + 1; i < board.length; i++) {
                if(!canMove(row, col, row, i)){
                    continue;
                }
                if (isBlack(board[row][i]) || (isWhite(board[row][i]) && getType((ImageIcon) board[row][i].getIcon()).equals("king"))) {
                    break;
                }
                if (isWhite(board[row][i])) {
                    board[row][i].setBackground(redHighlight);
                    board[row][i].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    break;
                }
                board[row][i].setBackground(blueHighlight);
                board[row][i].setBorder(BorderFactory.createLineBorder(Color.black, 1));
            }
        }
    }
    public boolean canMove(int prevRow, int prevCol, int row, int col){
        if(Objects.equals(this.color, "white")){
            ImageIcon temp = (ImageIcon) board[row][col].getIcon();
            board[row][col].setIcon(whiteRook1);
            board[prevRow][prevCol].setIcon(null);
            if(isCheck("white", board)){
                board[row][col].setIcon(temp);
                board[prevRow][prevCol].setIcon(whiteRook1);
                return false;
            }
            else{
                board[row][col].setIcon(temp);
                board[prevRow][prevCol].setIcon(whiteRook1);
                return true;
            }
        }
        else{
            ImageIcon temp = (ImageIcon) board[row][col].getIcon();
            board[row][col].setIcon(blackRook1);
            board[prevRow][prevCol].setIcon(null);
            if(isCheck("black", board)){
                board[row][col].setIcon(temp);
                board[prevRow][prevCol].setIcon(blackRook1);
                return false;
            }
            else{
                board[row][col].setIcon(temp);
                board[prevRow][prevCol].setIcon(blackRook1);
                return true;
            }
        }
    }
}

