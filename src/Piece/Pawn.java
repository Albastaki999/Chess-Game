package Piece;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static Main.Main.*;

public class Pawn {
    public int row = -1;
    public int col = -1;
    public String color = "";

    public Pawn(int row, int col, String color) {
        this.row = row;
        this.col = col;
        this.color = color;
    }

    public List<JLabel> movableCells() {
        List<JLabel> ans = new ArrayList<>();
        if (Objects.equals(this.color, "white")) {
            //check for enpasante
            if(row == 3){
                if(col == 0){
                    //right
                    if(isWhite(board[2][1]) && canMove(row, col, 2, 1) && blackEnpasante2){
                        ans.add(board[2][1]);
                    }
                }
                else if(col == 1){
                    //left
                    if(isEmpty(board[2][0]) && canMove(row, col, 2, 0) && blackEnpasante1){
                        ans.add(board[2][0]);
                    }
                    //right
                    if(isEmpty(board[2][2]) && canMove(row, col, 2, 2) && blackEnpasante3){
                        ans.add(board[2][2]);
                    }
                }
                else if(col == 2){
                    //left
                    if(isEmpty(board[2][1]) && canMove(row, col, 2, 1) && blackEnpasante2){
                        ans.add(board[2][1]);
                    }
                    //right
                    if(isEmpty(board[2][3]) && canMove(row, col, 2, 3) && blackEnpasante4){
                        ans.add(board[2][3]);
                    }
                }
                else if(col == 3){
                    //left
                    if(isEmpty(board[2][2]) && canMove(row, col, 2, 2) && blackEnpasante3){
                        ans.add(board[2][2]);
                    }
                    //right
                    if(isEmpty(board[2][4]) && canMove(row, col, 2, 4) && blackEnpasante5){
                        ans.add(board[2][4]);
                    }
                }
                else if(col == 4){
                    //left
                    if(isEmpty(board[2][3]) && canMove(row, col, 2, 3) && blackEnpasante4){
                        ans.add(board[2][3]);
                    }
                    //right
                    if(isEmpty(board[2][5]) && canMove(row, col, 2, 5) && blackEnpasante6){
                        ans.add(board[2][5]);
                    }
                }
                else if(col == 5){
                    //left
                    if(isEmpty(board[2][4]) && canMove(row, col, 2, 4) && blackEnpasante5){
                        ans.add(board[2][4]);
                    }
                    //right
                    if(isEmpty(board[2][6]) && canMove(row, col, 2, 6) && blackEnpasante7){
                        ans.add(board[2][6]);
                    }
                }
                else if(col == 6){
                    //left
                    if(isEmpty(board[2][5]) && canMove(row, col, 2, 5) && blackEnpasante6){
                        ans.add(board[2][5]);
                    }
                    //right
                    if(isEmpty(board[2][7]) && canMove(row, col, 2, 7) && blackEnpasante8){
                        ans.add(board[2][7]);
                    }
                }
                else if(col == 7){
                    //left
                    if(isEmpty(board[2][6]) && canMove(row, col, 2, 6) && blackEnpasante7){
                        ans.add(board[2][6]);
                    }
                }
            }
            if (row - 1 >= 0) {
                if (isEmpty(board[row - 1][col]) && canMove(row, col, row - 1, col)) {
                    ans.add(board[row - 1][col]);

                    if (row == 6 && isEmpty(board[row - 2][col]) && canMove(row, col, row - 2, col)) {
                        ans.add(board[row - 2][col]);
                    }
                }
            }
            if ((row - 1 >= 0 && col - 1 >= 0)) {
                if (isBlack(board[row - 1][col - 1]) && !getType((ImageIcon) board[row - 1][col - 1].getIcon()).equals("king") && canMove(row, col, row - 1, col - 1)) {
                    ans.add(board[row - 1][col - 1]);
                }
            }
            if ((row - 1 >= 0 && col + 1 < board.length)) {
                if (isBlack(board[row - 1][col + 1]) && !getType((ImageIcon) board[row - 1][col + 1].getIcon()).equals("king") && canMove(row, col, row - 1, col + 1)) {
                    ans.add(board[row - 1][col + 1]);
                }
            }
        } else {
            //check for enpasante
            if(row == 4){
                if(col == 0){
                    //right
                    if(isEmpty(board[5][1]) && canMove(row, col, 5, 1) && whiteEnpasante2){
                        ans.add(board[5][1]);
                    }
                }
                else if(col == 1){
                    //left
                    if(isEmpty(board[5][0]) && canMove(row, col, 5, 0) && whiteEnpasante1){
                        ans.add(board[5][0]);
                    }
                    //right
                    if(isEmpty(board[5][2]) && canMove(row, col, 5, 2) && whiteEnpasante3){
                        ans.add(board[5][2]);
                    }
                }
                else if(col == 2){
                    //left
                    if(isEmpty(board[5][1]) && canMove(row, col, 5, 1) && whiteEnpasante2){
                        ans.add(board[5][1]);
                    }
                    //right
                    if(isEmpty(board[5][3]) && canMove(row, col, 5, 3) && whiteEnpasante4){
                        ans.add(board[5][3]);
                    }
                }
                else if(col == 3){
                    //left
                    if(isEmpty(board[5][2]) && canMove(row, col, 5, 2) && whiteEnpasante3){
                        ans.add(board[5][2]);
                    }
                    //right
                    if(isEmpty(board[5][4]) && canMove(row, col, 5, 4) && whiteEnpasante5){
                        ans.add(board[5][4]);
                    }
                }
                else if(col == 4){
                    //left
                    if(isEmpty(board[5][3]) && canMove(row, col, 5, 3) && whiteEnpasante4){
                        ans.add(board[5][3]);
                    }
                    //right
                    if(isEmpty(board[5][5]) && canMove(row, col, 5, 5) && whiteEnpasante6){
                        ans.add(board[5][5]);
                    }
                }
                else if(col == 5){
                    //left
                    if(isEmpty(board[5][4]) && canMove(row, col, 5, 4) && whiteEnpasante5){
                        ans.add(board[5][4]);
                    }
                    //right
                    if(isEmpty(board[5][6]) && canMove(row, col, 5, 6) && whiteEnpasante7){
                        ans.add(board[5][6]);
                    }
                }
                else if(col == 6){
                    //left
                    if(isEmpty(board[5][5]) && canMove(row, col, 5, 5) && whiteEnpasante6){
                        ans.add(board[5][5]);
                    }
                    //right
                    if(isEmpty(board[5][7]) && canMove(row, col, 5, 7) && whiteEnpasante8){
                        ans.add(board[5][7]);
                    }
                }
                else if(col == 7){
                    //left
                    if(isEmpty(board[5][6]) && canMove(row, col, 5, 6) && whiteEnpasante7){
                        ans.add(board[5][6]);
                    }
                }
            }
            //check vacancy of forward cell
            if (row + 1 < board.length) {
                if (isEmpty(board[row + 1][col]) && canMove(row, col, row + 1, col)) {
                    ans.add(board[row + 1][col]);

                    //check initial position of pawn in order to advance 2 steps forward
                    if (row == 1 && isEmpty(board[row + 2][col]) && canMove(row, col, row + 2, col)) {
                        ans.add(board[row + 2][col]);
                    }
                }
            }

            //handle IOB
            if (col - 1 >= 0 && row + 1 < board.length) {
                //check if left diagonal cell contains an enemy piece
                if (isWhite(board[row + 1][col - 1]) && !getType((ImageIcon) board[row + 1][col - 1].getIcon()).equals("king") && canMove(row, col, row + 1, col - 1)) {
                    ans.add(board[row + 1][col - 1]);
                }
            }

            //Handle IOB
            if (col + 1 < board.length && row + 1 < board.length) {
                //check if right diagonal cell contains an enemy piece
                if (isWhite(board[row + 1][col + 1]) && !getType((ImageIcon) board[row + 1][col + 1].getIcon()).equals("king") && canMove(row, col, row + 1, col + 1)) {
                    ans.add(board[row + 1][col + 1]);
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
            //check for enpasante
            if(row == 3){
                if(col == 0){
                    //right
                    if(isEmpty(board[2][1]) && canMove(row, col, 2, 1) && blackEnpasante2){
                        board[2][1].setBackground(redHighlight);
                        board[2][1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    }
                }
                else if(col == 1){
                    //left
                    if(isEmpty(board[2][0]) && canMove(row, col, 2, 0) && blackEnpasante1){
                        board[2][0].setBackground(redHighlight);
                        board[2][0].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    }
                    //right
                    if(isEmpty(board[2][2]) && canMove(row, col, 2, 2) && blackEnpasante3){
                        board[2][2].setBackground(redHighlight);
                        board[2][2].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    }
                }
                else if(col == 2){
                    //left
                    if(isEmpty(board[2][1]) && canMove(row, col, 2, 1) && blackEnpasante2){
                        board[2][1].setBackground(redHighlight);
                        board[2][1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    }
                    //right
                    if(isEmpty(board[2][3]) && canMove(row, col, 2, 3) && blackEnpasante4){
                        board[2][3].setBackground(redHighlight);
                        board[2][3].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    }
                }
                else if(col == 3){
                    //left
                    if(isEmpty(board[2][2]) && canMove(row, col, 2, 2) && blackEnpasante3){
                        board[2][2].setBackground(redHighlight);
                        board[2][2].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    }
                    //right
                    if(isEmpty(board[2][4]) && canMove(row, col, 2, 4) && blackEnpasante5){
                        board[2][4].setBackground(redHighlight);
                        board[2][4].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    }
                }
                else if(col == 4){
                    //left
                    if(isEmpty(board[2][3]) && canMove(row, col, 2, 3) && blackEnpasante4){
                        board[2][3].setBackground(redHighlight);
                        board[2][3].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    }
                    //right
                    if(isEmpty(board[2][5]) && canMove(row, col, 2, 5) && blackEnpasante6){
                        board[2][5].setBackground(redHighlight);
                        board[2][5].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    }
                }
                else if(col == 5){
                    //left
                    if(isEmpty(board[2][4]) && canMove(row, col, 2, 4) && blackEnpasante5){
                        board[2][4].setBackground(redHighlight);
                        board[2][4].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    }
                    //right
                    if(isEmpty(board[2][6]) && canMove(row, col, 2, 6) && blackEnpasante7){
                        board[2][6].setBackground(redHighlight);
                        board[2][6].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    }
                }
                else if(col == 6){
                    //left
                    if(isEmpty(board[2][5]) && canMove(row, col, 2, 5) && blackEnpasante6){
                        board[2][5].setBackground(redHighlight);
                        board[2][5].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    }
                    //right
                    if(isEmpty(board[2][7]) && canMove(row, col, 2, 7) && blackEnpasante8){
                        board[2][7].setBackground(redHighlight);
                        board[2][7].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    }
                }
                else if(col == 7){
                    //left
                    if(isEmpty(board[2][6]) && canMove(row, col, 2, 6) && blackEnpasante7){
                        board[2][6].setBackground(redHighlight);
                        board[2][6].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    }
                }
            }
            //check vacancy of forward cell
            if (row - 1 >= 0) {
                if (isEmpty(board[row - 1][col]) && canMove(row, col, row - 1, col)) {
                    board[row - 1][col].setBackground(blueHighlight);
                    board[row - 1][col].setBorder(BorderFactory.createLineBorder(Color.black, 1));

                    //check initial position of pawn in order to advance 2 steps forward
                    if (row == 6 && isEmpty(board[row - 2][col]) && canMove(row, col, row - 2, col)) {
                        board[row - 2][col].setBackground(blueHighlight);
                        board[row - 2][col].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    }
                }
            }

            //handle IOB
            if (col - 1 >= 0 && row - 1 >= 0) {
                //check if left diagonal cell contains an enemy piece
                if (isBlack(board[row - 1][col - 1]) && !getType((ImageIcon) board[row - 1][col - 1].getIcon()).equals("king") && canMove(row, col, row - 1, col - 1)) {
                    board[row - 1][col - 1].setBackground(redHighlight);
                    board[row - 1][col - 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }

            //Handle IOB
            if (col + 1 < board.length && row - 1 >= 0) {
                //check if right diagonal cell contains an enemy piece
                if (isBlack(board[row - 1][col + 1]) && !getType((ImageIcon) board[row - 1][col + 1].getIcon()).equals("king") && canMove(row, col, row - 1, col + 1)) {
                    board[row - 1][col + 1].setBackground(redHighlight);
                    board[row - 1][col + 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }
        } else {
            //check for enpasante
            if(row == 4){
                if(col == 0){
                    //right
                    if(isEmpty(board[5][1]) && canMove(row, col, 5, 1) && whiteEnpasante2){
                        board[5][1].setBackground(redHighlight);
                        board[5][1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    }
                }
                else if(col == 1){
                    //left
                    if(isEmpty(board[5][0]) && canMove(row, col, 5, 0) && whiteEnpasante1){
                        board[5][0].setBackground(redHighlight);
                        board[5][0].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    }
                    //right
                    if(isEmpty(board[5][2]) && canMove(row, col, 5, 2) && whiteEnpasante3){
                        board[5][2].setBackground(redHighlight);
                        board[5][2].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    }
                }
                else if(col == 2){
                    //left
                    if(isEmpty(board[5][1]) && canMove(row, col, 5, 1) && whiteEnpasante2){
                        board[5][1].setBackground(redHighlight);
                        board[5][1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    }
                    //right
                    if(isEmpty(board[5][3]) && canMove(row, col, 5, 3) && whiteEnpasante4){
                        board[5][3].setBackground(redHighlight);
                        board[5][3].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    }
                }
                else if(col == 3){
                    //left
                    if(isEmpty(board[5][2]) && canMove(row, col, 5, 2) && whiteEnpasante3){
                        board[5][2].setBackground(redHighlight);
                        board[5][2].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    }
                    //right
                    if(isEmpty(board[5][2]) && canMove(row, col, 5, 2) && whiteEnpasante5){
                        board[5][4].setBackground(redHighlight);
                        board[5][4].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    }
                }
                else if(col == 4){
                    //left
                    if(isEmpty(board[5][3]) && canMove(row, col, 5, 3) && whiteEnpasante4){
                        board[5][3].setBackground(redHighlight);
                        board[5][3].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    }
                    //right
                    if(isEmpty(board[5][5]) && canMove(row, col, 5, 5) && whiteEnpasante6){
                        board[5][5].setBackground(redHighlight);
                        board[5][5].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    }
                }
                else if(col == 5){
                    //left
                    if(isEmpty(board[5][4]) && canMove(row, col, 5, 4) && whiteEnpasante5){
                        board[5][4].setBackground(redHighlight);
                        board[5][4].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    }
                    //right
                    if(isEmpty(board[5][6]) && canMove(row, col, 5, 6) && whiteEnpasante7){
                        board[5][6].setBackground(redHighlight);
                        board[5][6].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    }
                }
                else if(col == 6){
                    //left
                    if(isEmpty(board[5][5]) && canMove(row, col, 5, 5) && whiteEnpasante6){
                        board[5][5].setBackground(redHighlight);
                        board[5][5].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    }
                    //right
                    if(isEmpty(board[5][7]) && canMove(row, col, 5, 7) && whiteEnpasante8){
                        board[5][7].setBackground(redHighlight);
                        board[5][7].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    }
                }
                else if(col == 7){
                    //left
                    if(isEmpty(board[5][6]) && canMove(row, col, 5, 6) && whiteEnpasante7){
                        board[5][6].setBackground(redHighlight);
                        board[5][6].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    }
                }
            }
            //check vacancy of forward cell
            if (row + 1 < board.length) {
                if (isEmpty(board[row + 1][col]) && canMove(row, col, row + 1, col)) {
                    board[row + 1][col].setBackground(blueHighlight);
                    board[row + 1][col].setBorder(BorderFactory.createLineBorder(Color.black, 1));

                    //check initial position of pawn in order to advance 2 steps forward
                    if (row == 1 && isEmpty(board[row + 2][col]) && canMove(row, col, row + 2, col)) {
                        board[row + 2][col].setBackground(blueHighlight);
                        board[row + 2][col].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    }
                }
            }

            //handle IOB
            if (col - 1 >= 0 && row + 1 < board.length) {
                //check if left diagonal cell contains an enemy piece
                if (isWhite(board[row + 1][col - 1]) && !getType((ImageIcon) board[row + 1][col - 1].getIcon()).equals("king") && canMove(row, col, row + 1, col - 1)) {
                    board[row + 1][col - 1].setBackground(redHighlight);
                    board[row + 1][col - 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }

            //Handle IOB
            if (col + 1 < board.length && row + 1 < board.length) {
                //check if right diagonal cell contains an enemy piece
                if (isWhite(board[row + 1][col + 1]) && !getType((ImageIcon) board[row + 1][col + 1].getIcon()).equals("king") && canMove(row, col, row + 1, col + 1)) {
                    board[row + 1][col + 1].setBackground(redHighlight);
                    board[row + 1][col + 1].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }
            }
        }
    }

    public boolean canMove(int prevRow, int prevCol, int row, int col) {
        if (Objects.equals(this.color, "white")) {
            ImageIcon temp = (ImageIcon) board[row][col].getIcon();
            board[row][col].setIcon(whitePawn1);
            board[prevRow][prevCol].setIcon(null);
            if (isCheck("white", board)) {
                board[row][col].setIcon(temp);
                board[prevRow][prevCol].setIcon(whitePawn1);
                return false;
            } else {
                board[row][col].setIcon(temp);
                board[prevRow][prevCol].setIcon(whitePawn1);
                return true;
            }
        } else {
            ImageIcon temp = (ImageIcon) board[row][col].getIcon();
            board[row][col].setIcon(blackPawn1);
            board[prevRow][prevCol].setIcon(null);
            if (isCheck("black", board)) {
                board[row][col].setIcon(temp);
                board[prevRow][prevCol].setIcon(blackPawn1);
                return false;
            } else {
                board[row][col].setIcon(temp);
                board[prevRow][prevCol].setIcon(blackPawn1);
                return true;
            }
        }
    }
}