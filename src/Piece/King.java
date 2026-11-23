package Piece;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

import static Main.Main.*;

//completing king
public class King {
    public int row = -1;
    public int col = -1;
    public String color = "";

    public King(int row, int col, String color) {
        this.row = row;
        this.col = col;
        this.color = color;
    }

    public List<JLabel> movableCells() {
        List<JLabel> ans = new ArrayList<>();
        if (Objects.equals(this.color, "white")) {
            //check for castling
            if(canCastle("right")){
                ans.add(board[7][6]);
            }
            if(canCastle("left")){
                ans.add(board[7][1]);
            }


            //check if forward cell is empty and ensure we are 1 square away from opposite king
            if (row - 1 >= 0) {
                if (isEmpty(board[row - 1][col])
                        && isSafe(row - 1, col)
                ) {
                    ans.add(board[row - 1][col]);
                }


                //check if forward cell has a opposite piece and ensure we are 1 square away from opposite king
                if (isBlack(board[row - 1][col]) && isSafe(row - 1, col)) {
                    ans.add(board[row - 1][col]);
                }
            }


            //check if backward cell is empty and ensure we are 1 square away from opposite king
            if (row + 1 < board.length) {
                if (isEmpty(board[row + 1][col])
                        && isSafe(row + 1, col)
                ) {
                    ans.add(board[row + 1][col]);
                }


                //check if backward cell has an opposite piece and ensure we are 1 square away from opposite king
                if (isBlack(board[row + 1][col]) && isSafe(row + 1, col)) {
                    ans.add(board[row + 1][col]);
                }
            }

            //check if left cell is empty and ensure we are 1 square away from opposite king
            if (col - 1 >= 0) {
                if (isEmpty(board[row][col - 1])
                        && isSafe(row, col - 1)
                ) {
                    ans.add(board[row][col - 1]);
                }


                //check if left cell has an opposite piece and ensure we are 1 square away from opposite king
                if (isBlack(board[row][col - 1]) && isSafe(row, col - 1)) {
                    ans.add(board[row][col - 1]);
                }
            }

            //check if right cell is empty and ensure we are 1 square away from opposite king
            if (col + 1 < board.length) {
                if (isEmpty(board[row][col + 1])
                        && isSafe(row, col + 1)
                ) {
                    ans.add(board[row][col + 1]);
                }


                //check if right cell has an opposite piece and ensure we are 1 square away from opposite king
                if (isBlack(board[row][col + 1]) && isSafe(row, col + 1)) {
                    ans.add(board[row][col + 1]);
                }
            }

            //check if upper left diagonal is empty and ensure it is 1 square away from opposite king
            if (row - 1 >= 0 && col - 1 >= 0) {
                if (isEmpty(board[row - 1][col - 1])
                        && isSafe(row - 1, col - 1)
                ) {
                    ans.add(board[row - 1][col - 1]);
                }
            }

            //check if upper left diagonal has an opposite piece and ensure it is 1 square away from opposite king
            if (row - 1 >= 0 && col - 1 >= 0) {
                if (isBlack(board[row - 1][col - 1])
                        && isSafe(row - 1, col - 1)
                ) {
                    ans.add(board[row - 1][col - 1]);
                }
            }

            //check if upper right diagonal is empty and ensure it is 1 square away from opposite king
            if (row - 1 >= 0 && col + 1 < board.length) {
                if (isEmpty(board[row - 1][col + 1])
                        && isSafe(row - 1, col + 1)
                ) {
                    ans.add(board[row - 1][col + 1]);
                }
            }

            //check if upper right diagonal has an opposite piece and ensure it is 1 square away from opposite king
            if (row - 1 >= 0 && col + 1 < board.length) {
                if (isBlack(board[row - 1][col + 1])
                        && isSafe(row - 1, col + 1)
                ) {
                    ans.add(board[row - 1][col + 1]);
                }
            }

            //check if lower right diagonal is empty and ensure it is 1 square away from opposite king
            if (row + 1 < board.length && col + 1 < board.length) {
                if (isEmpty(board[row + 1][col + 1])
                        && isSafe(row + 1, col + 1)
                ) {
                    ans.add(board[row + 1][col + 1]);
                }
            }


            //check if lower right diagonal has an opposite piece and ensure it is 1 square away from opposite king
            if (row + 1 < board.length && col + 1 < board.length) {
                if (isBlack(board[row + 1][col + 1])
                        && isSafe(row + 1, col + 1)
                ) {
                    ans.add(board[row + 1][col + 1]);
                }
            }

            //check if lower left diagonal is empty and ensure it is 1 square away from opposite king
            if (row + 1 < board.length && col - 1 >= 0) {
                if (isEmpty(board[row + 1][col - 1])
                        && isSafe(row + 1, col - 1)
                ) {
                    ans.add(board[row + 1][col - 1]);
                }
            }


            //check if lower left diagonal has an opposite piece and ensure it is 1 square away from opposite king
            if (row + 1 < board.length && col - 1 >= 0) {
                if (isBlack(board[row + 1][col - 1])
                        && isSafe(row + 1, col - 1)
                ) {
                    ans.add(board[row + 1][col - 1]);
                }
            }
        } else {
            //check for castling
            if(canCastle("right")){
                ans.add(board[0][6]);
            }
            if(canCastle("left")){
                ans.add(board[0][1]);
            }


            //check if forward cell is empty and ensure we are 1 square away from opposite king
            if (row - 1 >= 0) {
                if (isEmpty(board[row - 1][col])
                        && isSafe(row - 1, col)
                ) {
                    ans.add(board[row - 1][col]);
                }


                //check if forward cell has a opposite piece and ensure we are 1 square away from opposite king
                if (isWhite(board[row - 1][col]) && isSafe(row - 1, col)) {
                    ans.add(board[row - 1][col]);
                }
            }


            //check if backward cell is empty and ensure we are 1 square away from opposite king
            if (row + 1 < board.length) {
                if (isEmpty(board[row + 1][col])
                        && isSafe(row + 1, col)
                ) {
                    ans.add(board[row + 1][col]);
                }


                //check if backward cell has an opposite piece and ensure we are 1 square away from opposite king
                if (isWhite(board[row + 1][col]) && isSafe(row + 1, col)) {
                    ans.add(board[row + 1][col]);
                }
            }

            //check if left cell is empty and ensure we are 1 square away from opposite king
            if (col - 1 >= 0) {
                if (isEmpty(board[row][col - 1])
                        && isSafe(row, col - 1)
                ) {
                    ans.add(board[row][col - 1]);
                }


                //check if left cell has an opposite piece and ensure we are 1 square away from opposite king
                if (isWhite(board[row][col - 1]) && isSafe(row, col - 1)) {
                    ans.add(board[row][col - 1]);
                }
            }

            //check if right cell is empty and ensure we are 1 square away from opposite king
            if (col + 1 < board.length) {
                if (isEmpty(board[row][col + 1])
                        && isSafe(row, col + 1)
                ) {
                    ans.add(board[row][col + 1]);
                }


                //check if right cell has an opposite piece and ensure we are 1 square away from opposite king
                if (isWhite(board[row][col + 1]) && isSafe(row, col + 1)) {
                    ans.add(board[row][col + 1]);
                }
            }


            //check if upper left diagonal is empty and ensure it is 1 square away from opposite king
            if (row - 1 >= 0 && col - 1 >= 0) {
                if (isEmpty(board[row - 1][col - 1])
                        && isSafe(row - 1, col - 1)
                ) {
                    ans.add(board[row - 1][col - 1]);
                }
            }


            //check if upper left diagonal has an opposite piece and ensure it is 1 square away from opposite king
            if (row - 1 >= 0 && col - 1 >= 0) {
                if (isWhite(board[row - 1][col - 1])
                        && isSafe(row - 1, col - 1)
                ) {
                    ans.add(board[row - 1][col - 1]);
                }
            }

            //check if upper right diagonal is empty and ensure it is 1 square away from opposite king
            if (row - 1 >= 0 && col + 1 < board.length) {
                if (isEmpty(board[row - 1][col + 1])
                        && isSafe(row - 1, col + 1)
                ) {
                    ans.add(board[row - 1][col + 1]);
                }
            }


            //check if upper right diagonal has an opposite piece and ensure it is 1 square away from opposite king
            if (row - 1 >= 0 && col + 1 < board.length) {
                if (isWhite(board[row - 1][col + 1])
                        && isSafe(row - 1, col + 1)
                ) {
                    ans.add(board[row - 1][col + 1]);
                }
            }

            //check if lower right diagonal is empty and ensure it is 1 square away from opposite king
            if (row + 1 < board.length && col + 1 < board.length) {
                if (isEmpty(board[row + 1][col + 1])
                        && isSafe(row + 1, col + 1)
                ) {
                    ans.add(board[row + 1][col + 1]);
                }
            }


            //check if lower right diagonal has an opposite piece and ensure it is 1 square away from opposite king
            if (row + 1 < board.length && col + 1 < board.length) {
                if (isWhite(board[row + 1][col + 1])
                        && isSafe(row + 1, col + 1)
                ) {
                    ans.add(board[row + 1][col + 1]);
                }
            }

            //check if lower left diagonal is empty and ensure it is 1 square away from opposite king
            if (row + 1 < board.length && col - 1 >= 0) {
                if (isEmpty(board[row + 1][col - 1])
                        && isSafe(row + 1, col - 1)
                ) {
                    ans.add(board[row + 1][col - 1]);
                }
            }


            //check if lower left diagonal has an opposite piece and ensure it is 1 square away from opposite king
            if (row + 1 < board.length && col - 1 >= 0) {
                if (isWhite(board[row + 1][col - 1])
                        && isSafe(row + 1, col - 1)
                ) {
                    ans.add(board[row + 1][col - 1]);
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
            //check for castling
            if(canCastle("right")){
                board[7][6].setBackground(purpleHighLight);
                board[7][6].setBorder(BorderFactory.createLineBorder(Color.black, 1));
            }
            if(canCastle("left")){
                board[7][1].setBackground(purpleHighLight);
                board[7][1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
            }


            //check if forward cell is empty and ensure we are 1 square away from opposite king
            if (row - 1 >= 0) {
                if (isEmpty(board[row - 1][col])
                        && isSafe(row - 1, col)
                ) {
                    board[row - 1][col].setBackground(blueHighlight);
                    board[row - 1][col].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }


                //check if forward cell has a opposite piece and ensure we are 1 square away from opposite king
                if (isBlack(board[row - 1][col]) && isSafe(row - 1, col)) {
                    board[row - 1][col].setBackground(redHighlight);
                    board[row - 1][col].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }


            //check if backward cell is empty and ensure we are 1 square away from opposite king
            if (row + 1 < board.length) {
                if (isEmpty(board[row + 1][col])
                        && isSafe(row + 1, col)
                ) {
                    board[row + 1][col].setBackground(blueHighlight);
                    board[row + 1][col].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }


                //check if backward cell has an opposite piece and ensure we are 1 square away from opposite king
                if (isBlack(board[row + 1][col]) && isSafe(row + 1, col)) {
                    board[row + 1][col].setBackground(redHighlight);
                    board[row + 1][col].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }

            //check if left cell is empty and ensure we are 1 square away from opposite king
            if (col - 1 >= 0) {
                if (isEmpty(board[row][col - 1])
                        && isSafe(row, col - 1)
                ) {
                    board[row][col - 1].setBackground(blueHighlight);
                    board[row][col - 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }


                //check if left cell has an opposite piece and ensure we are 1 square away from opposite king
                if (isBlack(board[row][col - 1]) && isSafe(row, col - 1)) {
                    board[row][col - 1].setBackground(redHighlight);
                    board[row][col - 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }

            //check if right cell is empty and ensure we are 1 square away from opposite king
            if (col + 1 < board.length) {
                if (isEmpty(board[row][col + 1])
                        && isSafe(row, col + 1)
                ) {
                    board[row][col + 1].setBackground(blueHighlight);
                    board[row][col + 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }


                //check if right cell has an opposite piece and ensure we are 1 square away from opposite king
                if (isBlack(board[row][col + 1]) && isSafe(row, col + 1)) {
                    board[row][col + 1].setBackground(redHighlight);
                    board[row][col + 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }


            //check if upper left diagonal is empty and ensure it is 1 square away from opposite king
            if (row - 1 >= 0 && col - 1 >= 0) {
                if (isEmpty(board[row - 1][col - 1])
                        && isSafe(row - 1, col - 1)
                ) {
                    board[row - 1][col - 1].setBackground(blueHighlight);
                    board[row - 1][col - 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }


            //check if upper left diagonal has an opposite piece and ensure it is 1 square away from opposite king
            if (row - 1 >= 0 && col - 1 >= 0) {
                if (isBlack(board[row - 1][col - 1])
                        && isSafe(row - 1, col - 1)
                ) {
                    board[row - 1][col - 1].setBackground(redHighlight);
                    board[row - 1][col - 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }

            //check if upper right diagonal is empty and ensure it is 1 square away from opposite king
            if (row - 1 >= 0 && col + 1 < board.length) {
                if (isEmpty(board[row - 1][col + 1])
                        && isSafe(row - 1, col + 1)
                ) {
                    board[row - 1][col + 1].setBackground(blueHighlight);
                    board[row - 1][col + 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }


            //check if upper right diagonal has an opposite piece and ensure it is 1 square away from opposite king
            if (row - 1 >= 0 && col + 1 < board.length) {
                if (isBlack(board[row - 1][col + 1])
                        && isSafe(row - 1, col + 1)
                ) {
                    board[row - 1][col + 1].setBackground(redHighlight);
                    board[row - 1][col + 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }

            //check if lower right diagonal is empty and ensure it is 1 square away from opposite king
            if (row + 1 < board.length && col + 1 < board.length) {
                if (isEmpty(board[row + 1][col + 1])
                        && isSafe(row + 1, col + 1)
                ) {
                    board[row + 1][col + 1].setBackground(blueHighlight);
                    board[row + 1][col + 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }


            //check if lower right diagonal has an opposite piece and ensure it is 1 square away from opposite king
            if (row + 1 < board.length && col + 1 < board.length) {
                if (isBlack(board[row + 1][col + 1])
                        && isSafe(row + 1, col + 1)
                ) {
                    board[row + 1][col + 1].setBackground(redHighlight);
                    board[row + 1][col + 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }

            //check if lower left diagonal is empty and ensure it is 1 square away from opposite king
            if (row + 1 < board.length && col - 1 >= 0) {
                if (isEmpty(board[row + 1][col - 1])
                        && isSafe(row + 1, col - 1)
                ) {
                    board[row + 1][col - 1].setBackground(blueHighlight);
                    board[row + 1][col - 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }


            //check if lower left diagonal has an opposite piece and ensure it is 1 square away from opposite king
            if (row + 1 < board.length && col - 1 >= 0) {
                if (isBlack(board[row + 1][col - 1])
                        && isSafe(row + 1, col - 1)
                ) {
                    board[row + 1][col - 1].setBackground(redHighlight);
                    board[row + 1][col - 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }
        } else {
            //check for castling
            if(canCastle("right")){
                board[0][6].setBackground(purpleHighLight);
                board[0][6].setBorder(BorderFactory.createLineBorder(Color.black, 1));
            }
            if(canCastle("left")){
                board[0][1].setBackground(purpleHighLight);
                board[0][1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
            }


            //check if forward cell is empty and ensure we are 1 square away from opposite king
            if (row - 1 >= 0) {
                if (isEmpty(board[row - 1][col])
                        && isSafe(row - 1, col)
                ) {
                    board[row - 1][col].setBackground(blueHighlight);
                    board[row - 1][col].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }


                //check if forward cell has a opposite piece and ensure we are 1 square away from opposite king
                if (isWhite(board[row - 1][col]) && isSafe(row - 1, col)) {
                    board[row - 1][col].setBackground(redHighlight);
                    board[row - 1][col].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }


            //check if backward cell is empty and ensure we are 1 square away from opposite king
            if (row + 1 < board.length) {
                if (isEmpty(board[row + 1][col])
                        && isSafe(row + 1, col)
                ) {
                    board[row + 1][col].setBackground(blueHighlight);
                    board[row + 1][col].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }


                //check if backward cell has an opposite piece and ensure we are 1 square away from opposite king
                if (isWhite(board[row + 1][col]) && isSafe(row + 1, col)) {
                    board[row + 1][col].setBackground(redHighlight);
                    board[row + 1][col].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }

            //check if left cell is empty and ensure we are 1 square away from opposite king
            if (col - 1 >= 0) {
                if (isEmpty(board[row][col - 1])
                        && isSafe(row, col - 1)
                ) {
                    board[row][col - 1].setBackground(blueHighlight);
                    board[row][col - 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }


                //check if left cell has an opposite piece and ensure we are 1 square away from opposite king
                if (isWhite(board[row][col - 1]) && isSafe(row, col - 1)) {
                    board[row][col - 1].setBackground(redHighlight);
                    board[row][col - 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }

            //check if right cell is empty and ensure we are 1 square away from opposite king
            if (col + 1 < board.length) {
                if (isEmpty(board[row][col + 1])
                        && isSafe(row, col + 1)
                ) {
                    board[row][col + 1].setBackground(blueHighlight);
                    board[row][col + 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }


                //check if right cell has an opposite piece and ensure we are 1 square away from opposite king
                if (isWhite(board[row][col + 1]) && isSafe(row, col + 1)) {
                    board[row][col + 1].setBackground(redHighlight);
                    board[row][col + 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }


            //check if upper left diagonal is empty and ensure it is 1 square away from opposite king
            if (row - 1 >= 0 && col - 1 >= 0) {
                if (isEmpty(board[row - 1][col - 1])
                        && isSafe(row - 1, col - 1)
                ) {
                    board[row - 1][col - 1].setBackground(blueHighlight);
                    board[row - 1][col - 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }


            //check if upper left diagonal has an opposite piece and ensure it is 1 square away from opposite king
            if (row - 1 >= 0 && col - 1 >= 0) {
                if (isWhite(board[row - 1][col - 1])
                        && isSafe(row - 1, col - 1)
                ) {
                    board[row - 1][col - 1].setBackground(redHighlight);
                    board[row - 1][col - 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }

            //check if upper right diagonal is empty and ensure it is 1 square away from opposite king
            if (row - 1 >= 0 && col + 1 < board.length) {
                if (isEmpty(board[row - 1][col + 1])
                        && isSafe(row - 1, col + 1)
                ) {
                    board[row - 1][col + 1].setBackground(blueHighlight);
                    board[row - 1][col + 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }


            //check if upper right diagonal has an opposite piece and ensure it is 1 square away from opposite king
            if (row - 1 >= 0 && col + 1 < board.length) {
                if (isWhite(board[row - 1][col + 1])
                        && isSafe(row - 1, col + 1)
                ) {
                    board[row - 1][col + 1].setBackground(redHighlight);
                    board[row - 1][col + 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }

            //check if lower right diagonal is empty and ensure it is 1 square away from opposite king
            if (row + 1 < board.length && col + 1 < board.length) {
                if (isEmpty(board[row + 1][col + 1])
                        && isSafe(row + 1, col + 1)
                ) {
                    board[row + 1][col + 1].setBackground(blueHighlight);
                    board[row + 1][col + 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }


            //check if lower right diagonal has an opposite piece and ensure it is 1 square away from opposite king
            if (row + 1 < board.length && col + 1 < board.length) {
                if (isWhite(board[row + 1][col + 1])
                        && isSafe(row + 1, col + 1)
                ) {
                    board[row + 1][col + 1].setBackground(redHighlight);
                    board[row + 1][col + 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }

            //check if lower left diagonal is empty and ensure it is 1 square away from opposite king
            if (row + 1 < board.length && col - 1 >= 0) {
                if (isEmpty(board[row + 1][col - 1])
                        && isSafe(row + 1, col - 1)
                ) {
                    board[row + 1][col - 1].setBackground(blueHighlight);
                    board[row + 1][col - 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }


            //check if lower left diagonal has an opposite piece and ensure it is 1 square away from opposite king
            if (row + 1 < board.length && col - 1 >= 0) {
                if (isWhite(board[row + 1][col - 1])
                        && isSafe(row + 1, col - 1)
                ) {
                    board[row + 1][col - 1].setBackground(redHighlight);
                    board[row + 1][col - 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }
        }
    }

    public boolean isSafe(int row, int col) {
        if (Objects.equals(this.color, "white")) {
            if (row - 1 >= 0 && col - 1 >= 0) {
                if (isBlack(board[row - 1][col - 1]) && getType((ImageIcon) board[row - 1][col - 1].getIcon()).equals("pawn")) {
                    return false;
                }
            }
            if (row - 1 >= 0 && col + 1 < board.length) {
                if (isBlack(board[row - 1][col + 1]) && getType((ImageIcon) board[row - 1][col + 1].getIcon()).equals("pawn")) {
                    return false;
                }
            }
            if (row - 1 >= 0 && col - 1 >= 0) {
                if(isBlack(board[row - 1][col - 1]) && getType((ImageIcon) board[row - 1][col - 1].getIcon()).equals("king")){
                    return false;
                }
            }
            if (row - 1 >= 0) {
                if(isBlack(board[row - 1][col]) && getType((ImageIcon) board[row - 1][col].getIcon()).equals("king")){
                    return false;
                }
            }
            if (row - 1 >= 0 && col + 1 < board.length) {
                if(isBlack(board[row - 1][col + 1]) && getType((ImageIcon) board[row - 1][col + 1].getIcon()).equals("king")){
                    return false;
                }
            }
            if (col - 1 >= 0) {
                if(isBlack(board[row][col - 1]) && getType((ImageIcon) board[row][col - 1].getIcon()).equals("king")){
                    return false;
                }
            }

            if (col + 1 < board.length) {
                if(isBlack(board[row][col + 1]) && getType((ImageIcon) board[row][col + 1].getIcon()).equals("king")){
                    return false;
                }
            }
            if (row + 1 < board.length && col - 1 >= 0) {
                if(isBlack(board[row + 1][col - 1]) && getType((ImageIcon) board[row + 1][col - 1].getIcon()).equals("king")){
                    return false;
                }
            }
            if (row + 1 < board.length) {
                if(isBlack(board[row + 1][col]) && getType((ImageIcon) board[row + 1][col].getIcon()).equals("king")){
                    return false;
                }
            }
            if (row + 1 < board.length && col + 1 < board.length) {
                if(isBlack(board[row + 1][col + 1]) && getType((ImageIcon) board[row + 1][col + 1].getIcon()).equals("king")){
                    return false;
                }
            }
            //check diagonals
            //left upper diagonal
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (isBlack(board[i][j]) && (getType((ImageIcon) board[i][j].getIcon()).equals("bishop") || getType((ImageIcon) board[i][j].getIcon()).equals("queen"))) {
                    return false;
                } else if (!isEmpty(board[i][j])) {
                    break;
                }
            }

            //right upper diagonal
            for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
                if(getType((ImageIcon) board[i][j].getIcon()).equals("king")){
                    continue;
                }
                if (isBlack(board[i][j]) && (getType((ImageIcon) board[i][j].getIcon()).equals("bishop") || getType((ImageIcon) board[i][j].getIcon()).equals("queen"))) {
                    return false;
                } else if (!isEmpty(board[i][j])) {
                    break;
                }
            }

            //left lower diagonal
            for (int i = row + 1, j = col - 1; i < board.length && j >= 0; i++, j--) {
                if(getType((ImageIcon) board[i][j].getIcon()).equals("king")){
                    continue;
                }
                if (isBlack(board[i][j]) && (getType((ImageIcon) board[i][j].getIcon()).equals("bishop") || getType((ImageIcon) board[i][j].getIcon()).equals("queen"))) {
                    return false;
                } else if (!isEmpty(board[i][j])) {
                    break;
                }
            }

            //right lower diagonal
            for (int i = row + 1, j = col + 1; i < board.length && j < board.length; i++, j++) {
                if(getType((ImageIcon) board[i][j].getIcon()).equals("king")){
                    continue;
                }
                if (isBlack(board[i][j]) && (getType((ImageIcon) board[i][j].getIcon()).equals("bishop") || getType((ImageIcon) board[i][j].getIcon()).equals("queen"))) {
                    return false;
                } else if (!isEmpty(board[i][j])) {
                    break;
                }
            }

            //check vertical and horizontal
            //up
            for (int i = row - 1; i >= 0; i--) {
                if(getType((ImageIcon) board[i][col].getIcon()).equals("king")){
                    continue;
                }
                if (isBlack(board[i][col]) && (getType((ImageIcon) board[i][col].getIcon()).equals("rook") || getType((ImageIcon) board[i][col].getIcon()).equals("queen"))) {
                    return false;
                } else if (!isEmpty(board[i][col])) {
                    break;
                }
            }

            //down
            for (int i = row + 1; i < board.length; i++) {
                if(getType((ImageIcon) board[i][col].getIcon()).equals("king")){
                    continue;
                }
                if (isBlack(board[i][col]) && (getType((ImageIcon) board[i][col].getIcon()).equals("rook") || getType((ImageIcon) board[i][col].getIcon()).equals("queen"))) {
                    return false;
                } else if (!isEmpty(board[i][col])) {
                    break;
                }
            }

            //left
            for (int j = col - 1; j >= 0; j--) {
                if(getType((ImageIcon) board[row][j].getIcon()).equals("king")){
                    continue;
                }
                if (isBlack(board[row][j]) && (getType((ImageIcon) board[row][j].getIcon()).equals("rook") || getType((ImageIcon) board[row][j].getIcon()).equals("queen"))) {
                    return false;
                } else if (!isEmpty(board[row][j])) {
                    break;
                }
            }

            //right
            for (int j = col + 1; j < board.length; j++) {
                if(getType((ImageIcon) board[row][j].getIcon()).equals("king")){
                    continue;
                }
                if (isBlack(board[row][j]) && (getType((ImageIcon) board[row][j].getIcon()).equals("rook") || getType((ImageIcon) board[row][j].getIcon()).equals("queen"))) {
                    return false;
                } else if (!isEmpty(board[row][j])) {
                    break;
                }
            }

            //detect Knights
            //upper right
            if (row - 2 >= 0 && col + 1 < board.length) {
                if (isBlack(board[row - 2][col + 1]) && getType((ImageIcon) board[row - 2][col + 1].getIcon()).equals("knight")) {
                    return false;
                }
            }

            //upper left
            if (row - 2 >= 0 && col - 1 >= 0) {
                if (isBlack(board[row - 2][col - 1]) && getType((ImageIcon) board[row - 2][col - 1].getIcon()).equals("knight")) {
                    return false;
                }
            }

            //lower right
            if (row + 2 < board.length && col + 1 < board.length) {
                if (isBlack(board[row + 2][col + 1]) && getType((ImageIcon) board[row + 2][col + 1].getIcon()).equals("knight")) {
                    return false;
                }
            }

            //lower left
            if (row + 2 < board.length && col - 1 >= 0) {
                if (isBlack(board[row + 2][col - 1]) && getType((ImageIcon) board[row + 2][col - 1].getIcon()).equals("knight")) {
                    return false;
                }
            }

            //left down
            if (row + 1 < board.length && col - 2 >= 0) {
                if (isBlack(board[row + 1][col - 2]) && getType((ImageIcon) board[row + 1][col - 2].getIcon()).equals("knight")) {
                    return false;
                }
            }

            //left up
            if (row - 1 >= 0 && col - 2 >= 0) {
                if (isBlack(board[row - 1][col - 2]) && getType((ImageIcon) board[row - 1][col - 2].getIcon()).equals("knight")) {
                    return false;
                }
            }

            //right down
            if (row + 1 < board.length && col + 2 < board.length) {
                if (isBlack(board[row + 1][col + 2]) && getType((ImageIcon) board[row + 1][col + 2].getIcon()).equals("knight")) {
                    return false;
                }
            }

            //right up
            if (row - 1 >= 0 && col + 2 < board.length) {
                return !isBlack(board[row - 1][col + 2]) || !getType((ImageIcon) board[row - 1][col + 2].getIcon()).equals("knight");
            }
        } else {
            if (row + 1 < board.length && col - 1 >= 0) {
                if (isWhite(board[row + 1][col - 1]) && getType((ImageIcon) board[row + 1][col - 1].getIcon()).equals("pawn")) {
                    return false;
                }
            }
            if (row + 1 < board.length && col + 1 < board.length) {
                if (isWhite(board[row + 1][col + 1]) && getType((ImageIcon) board[row + 1][col + 1].getIcon()).equals("pawn")) {
                    return false;
                }
            }
            if (row - 1 >= 0 && col - 1 >= 0) {
                if(isWhite(board[row - 1][col - 1]) && getType((ImageIcon) board[row - 1][col - 1].getIcon()).equals("king")){
                    return false;
                }
            }
            if (row - 1 >= 0) {
                if(isWhite(board[row - 1][col]) && getType((ImageIcon) board[row - 1][col].getIcon()).equals("king")){
                    return false;
                }
            }
            if (row - 1 >= 0 && col + 1 < board.length) {
                if(isWhite(board[row - 1][col + 1]) && getType((ImageIcon) board[row - 1][col + 1].getIcon()).equals("king")){
                    return false;
                }
            }
            if (col - 1 >= 0) {
                if(isWhite(board[row][col - 1]) && getType((ImageIcon) board[row][col - 1].getIcon()).equals("king")){
                    return false;
                }
            }

            if (col + 1 < board.length) {
                if(isWhite(board[row][col + 1]) && getType((ImageIcon) board[row][col + 1].getIcon()).equals("king")){
                    return false;
                }
            }
            if (row + 1 < board.length && col - 1 >= 0) {
                if(isWhite(board[row + 1][col - 1]) && getType((ImageIcon) board[row + 1][col - 1].getIcon()).equals("king")){
                    return false;
                }
            }
            if (row + 1 < board.length) {
                if(isWhite(board[row + 1][col]) && getType((ImageIcon) board[row + 1][col].getIcon()).equals("king")){
                    return false;
                }
            }
            if (row + 1 < board.length && col + 1 < board.length) {
                if(isWhite(board[row + 1][col + 1]) && getType((ImageIcon) board[row + 1][col + 1].getIcon()).equals("king")){
                    return false;
                }
            }
            //check diagonals
            //left upper diagonal
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if(getType((ImageIcon) board[i][j].getIcon()).equals("king")){
                    continue;
                }
                if (isWhite(board[i][j]) && (getType((ImageIcon) board[i][j].getIcon()).equals("bishop") || getType((ImageIcon) board[i][j].getIcon()).equals("queen"))) {
                    return false;
                } else if (!isEmpty(board[i][j])) {
                    break;
                }
            }

            //right upper diagonal
            for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
                if(getType((ImageIcon) board[i][j].getIcon()).equals("king")){
                    continue;
                }
                if (isWhite(board[i][j]) && (getType((ImageIcon) board[i][j].getIcon()).equals("bishop") || getType((ImageIcon) board[i][j].getIcon()).equals("queen"))) {
                    return false;
                } else if (!isEmpty(board[i][j])) {
                    break;
                }
            }

            //left lower diagonal
            for (int i = row + 1, j = col - 1; i < board.length && j >= 0; i++, j--) {
                if(getType((ImageIcon) board[i][j].getIcon()).equals("king")){
                    continue;
                }
                if (isWhite(board[i][j]) && (getType((ImageIcon) board[i][j].getIcon()).equals("bishop") || getType((ImageIcon) board[i][j].getIcon()).equals("queen"))) {
                    return false;
                } else if (!isEmpty(board[i][j])) {
                    break;
                }
            }

            //right lower diagonal
            for (int i = row + 1, j = col + 1; i < board.length && j < board.length; i++, j++) {
                if(getType((ImageIcon) board[i][j].getIcon()).equals("king")){
                    continue;
                }
                if (isWhite(board[i][j]) && (getType((ImageIcon) board[i][j].getIcon()).equals("bishop") || getType((ImageIcon) board[i][j].getIcon()).equals("queen"))) {
                    return false;
                } else if (!isEmpty(board[i][j])) {
                    break;
                }
            }

            //check vertical and horizontal
            //up
            for (int i = row - 1; i >= 0; i--) {
                if(getType((ImageIcon) board[i][col].getIcon()).equals("king")){
                    continue;
                }
                if (isWhite(board[i][col]) && (getType((ImageIcon) board[i][col].getIcon()).equals("rook") || getType((ImageIcon) board[i][col].getIcon()).equals("queen"))) {
                    return false;
                } else if (!isEmpty(board[i][col])) {
                    break;
                }
            }

            //down
            for (int i = row + 1; i < board.length; i++) {
                if(getType((ImageIcon) board[i][col].getIcon()).equals("king")){
                    continue;
                }
                if (isWhite(board[i][col]) && (getType((ImageIcon) board[i][col].getIcon()).equals("rook") || getType((ImageIcon) board[i][col].getIcon()).equals("queen"))) {
                    return false;
                } else if (!isEmpty(board[i][col])) {
                    break;
                }
            }

            //left
            for (int j = col - 1; j >= 0; j--) {
                if(getType((ImageIcon) board[row][j].getIcon()).equals("king")){
                    continue;
                }
                if (isWhite(board[row][j]) && (getType((ImageIcon) board[row][j].getIcon()).equals("rook") || getType((ImageIcon) board[row][j].getIcon()).equals("queen"))) {
                    return false;
                } else if (!isEmpty(board[row][j])) {
                    break;
                }
            }

            //right
            for (int j = col + 1; j < board.length; j++) {
                if(getType((ImageIcon) board[row][j].getIcon()).equals("king")){
                    continue;
                }
                if (isWhite(board[row][j]) && (getType((ImageIcon) board[row][j].getIcon()).equals("rook") || getType((ImageIcon) board[row][j].getIcon()).equals("queen"))) {
                    return false;
                } else if (!isEmpty(board[row][j])) {
                    break;
                }
            }


            //detect Knights
            //upper right
            if (row - 2 >= 0 && col + 1 < board.length) {
                if (isWhite(board[row - 2][col + 1]) && getType((ImageIcon) board[row - 2][col + 1].getIcon()).equals("knight")) {
                    return false;
                }
            }

            //upper left
            if (row - 2 >= 0 && col - 1 >= 0) {
                if (isWhite(board[row - 2][col - 1]) && getType((ImageIcon) board[row - 2][col - 1].getIcon()).equals("knight")) {
                    return false;
                }
            }

            //lower right
            if (row + 2 < board.length && col + 1 < board.length) {
                if (isWhite(board[row + 2][col + 1]) && getType((ImageIcon) board[row + 2][col + 1].getIcon()).equals("knight")) {
                    return false;
                }
            }

            //lower left
            if (row + 2 < board.length && col - 1 >= 0) {
                if (isWhite(board[row + 2][col - 1]) && getType((ImageIcon) board[row + 2][col - 1].getIcon()).equals("knight")) {
                    return false;
                }
            }

            //left down
            if (row + 1 < board.length && col - 2 >= 0) {
                if (isWhite(board[row + 1][col - 2]) && getType((ImageIcon) board[row + 1][col - 2].getIcon()).equals("knight")) {
                    return false;
                }
            }

            //left up
            if (row - 1 >= 0 && col - 2 >= 0) {
                if (isWhite(board[row - 1][col - 2]) && getType((ImageIcon) board[row - 1][col - 2].getIcon()).equals("knight")) {
                    return false;
                }
            }

            //right down
            if (row + 1 < board.length && col + 2 < board.length) {
                if (isWhite(board[row + 1][col + 2]) && getType((ImageIcon) board[row + 1][col + 2].getIcon()).equals("knight")) {
                    return false;
                }
            }

            //right up
            if (row - 1 >= 0 && col + 2 < board.length) {
                return !isWhite(board[row - 1][col + 2]) || !getType((ImageIcon) board[row - 1][col + 2].getIcon()).equals("knight");
            }
        }
        return true;
    }
    public boolean canCastle(String direction){
        if(Objects.equals(this.color, "white")){
            if(direction.equals("right")){
//                System.out.println(whiteRook2Moved);
                return !isCheck("white", board) && (board[7][7].getIcon() == whiteRook2 || board[7][7].getIcon() == whiteRook1) && this.row == 7 && this.col == 4 && board[7][5].getIcon() == null && board[7][6].getIcon() == null && isSafe(7, 5) && isSafe(7, 6) && !whiteKingMoved && !whiteRook2Moved;
            }
            else{
                return !isCheck("white", board) && (board[7][0].getIcon() == whiteRook1 || board[7][0].getIcon() == whiteRook2) && this.row == 7 && this.col == 4 && board[7][3].getIcon() == null && board[7][2].getIcon() == null && board[7][1].getIcon() == null && isSafe(7, 3) && isSafe(7, 2) && isSafe(7, 2) && !whiteKingMoved && !whiteRook1Moved;
            }
        }
        else{
            if(direction.equals("right")){
                return !isCheck("black", board) && (board[0][7].getIcon() == blackRook1 || board[0][7].getIcon() == blackRook2) && this.row == 0 && this.col == 4 && board[0][5].getIcon() == null && board[0][6].getIcon() == null && isSafe(0, 5) && isSafe(0, 6) && !blackKingMoved && !blackRook2Moved;
            }
            else{
                return !isCheck("black", board) && (board[0][0].getIcon() == blackRook2 || board[0][0].getIcon() == blackRook1) && this.row == 0 && this.col == 4 && board[0][3].getIcon() == null && board[0][2].getIcon() == null && board[0][1].getIcon() == null && isSafe(0, 3) && isSafe(0, 2) && isSafe(0, 2) && !blackKingMoved && !blackRook1Moved;
            }
        }
    }
}
