package Main;

import Piece.*;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Main implements MouseListener {
    public static JLabel[][] board;
    public static ImageIcon blackRook1;
    public static ImageIcon whiteRook1;
    public static ImageIcon blackRook2;
    public static ImageIcon whiteRook2;
    public static ImageIcon blackKnight1;
    public static ImageIcon whiteKnight1;
    public static ImageIcon blackKnight2;
    public static ImageIcon whiteKnight2;
    public static ImageIcon blackBishop1;
    public static ImageIcon whiteBishop1;
    public static ImageIcon blackBishop2;
    public static ImageIcon whiteBishop2;
    public static ImageIcon blackQueen;
    public static ImageIcon whiteQueen;
    public static ImageIcon blackKing;
    public static ImageIcon whiteKing;
    public static ImageIcon blackPawn1;
    public static ImageIcon blackPawn2;
    public static ImageIcon blackPawn3;
    public static ImageIcon blackPawn4;
    public static ImageIcon blackPawn5;
    public static ImageIcon blackPawn6;
    public static ImageIcon blackPawn7;
    public static ImageIcon blackPawn8;
    public static ImageIcon whitePawn1;
    public static ImageIcon whitePawn2;
    public static ImageIcon whitePawn3;
    public static ImageIcon whitePawn4;
    public static ImageIcon whitePawn5;
    public static ImageIcon whitePawn6;
    public static ImageIcon whitePawn7;
    public static ImageIcon whitePawn8;
    public static Color blueHighlight = new Color(135, 206, 235);
    public static Color redHighlight = new Color(228, 119, 119);
    public static Color pinkHighLight = new Color(252, 168, 210);
    public static Color purpleHighLight = new Color(148, 107, 219);
    public static Color darkSquare = new Color(118, 150, 86);
    public static Color lightSquare = new Color(238, 238, 210);
    public static Stack<JLabel> clickedStack = new Stack<>(); // 0 -> Chess Piece, 1 -> movable Cell
    public static boolean whiteKingMoved = false;
    public static boolean whiteRook1Moved = false;
    public static boolean whiteRook2Moved = false;
    public static boolean blackKingMoved = false;
    public static boolean blackRook1Moved = false;
    public static boolean blackRook2Moved = false;
    public static boolean blackEnpasante1 = false;
    public static boolean blackEnpasante2 = false;
    public static boolean blackEnpasante3 = false;
    public static boolean blackEnpasante4 = false;
    public static boolean blackEnpasante5 = false;
    public static boolean blackEnpasante6 = false;
    public static boolean blackEnpasante7 = false;
    public static boolean blackEnpasante8 = false;
    public static boolean whiteEnpasante1 = false;
    public static boolean whiteEnpasante2 = false;
    public static boolean whiteEnpasante3 = false;
    public static boolean whiteEnpasante4 = false;
    public static boolean whiteEnpasante5 = false;
    public static boolean whiteEnpasante6 = false;
    public static boolean whiteEnpasante7 = false;
    public static boolean whiteEnpasante8 = false;
    public static boolean isCreatorModeOn = false;
    public static String player = "white";
    public static int uselessHalfMoves = 0;
    public static JMenuBar menubar;
    public static JMenu game;
    public static JMenuItem restart;
    public static JMenuItem creatorMode;
    public static File move;
    public static File castle;
    public static File capture;
    public static File promote;
    public static File start;
    public static File win;

    Main() {
        JFrame frame = new JFrame("Chess");
        frame.setLayout(new GridLayout(8, 8));
        board = new JLabel[8][8];

        setupSounds();
        setupMenubar(frame);
        setupPieces();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = new JLabel();
                board[i][j].setHorizontalAlignment(JLabel.CENTER);
                board[i][j].setOpaque(true); // Ensure the background color is visible
                board[i][j].addMouseListener(this);

                if ((i + j) % 2 != 0) {
                    board[i][j].setBackground(darkSquare); // Dark square color
                } else {
                    board[i][j].setBackground(lightSquare); // Light square color
                }

                frame.add(board[i][j]);
            }
        }

        // Set frame properties
        frame.setSize(650, 650);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initialiseBoard();
    }

    private void setupPieces() {
        // Rooks
        blackRook1 = getImageIcon("/Images/black_rook.png");
        blackRook2 = getImageIcon("/Images/black_rook.png");
        whiteRook1 = getImageIcon("/Images/white_rook.png");
        whiteRook2 = getImageIcon("/Images/white_rook.png");

        // Knights
        blackKnight1 = getImageIcon("/Images/black_knight.png");
        blackKnight2 = getImageIcon("/Images/black_knight.png");
        whiteKnight1 = getImageIcon("/Images/white_knight.png");
        whiteKnight2 = getImageIcon("/Images/white_knight.png");

        // Bishops
        blackBishop1 = getImageIcon("/Images/black_bishop.png");
        blackBishop2 = getImageIcon("/Images/black_bishop.png");
        whiteBishop1 = getImageIcon("/Images/white_bishop.png");
        whiteBishop2 = getImageIcon("/Images/white_bishop.png");

        // Queens
        blackQueen = getImageIcon("/Images/black_queen.png");
        whiteQueen = getImageIcon("/Images/white_queen.png");

        // Kings
        blackKing = getImageIcon("/Images/black_king.png");
        whiteKing = getImageIcon("/Images/white_king.png");

        // Pawns
        whitePawn1 = getImageIcon("/Images/white_pawn.png", 46, 58);
        whitePawn2 = getImageIcon("/Images/white_pawn.png", 46, 58);
        whitePawn3 = getImageIcon("/Images/white_pawn.png", 46, 58);
        whitePawn4 = getImageIcon("/Images/white_pawn.png", 46, 58);
        whitePawn5 = getImageIcon("/Images/white_pawn.png", 46, 58);
        whitePawn6 = getImageIcon("/Images/white_pawn.png", 46, 58);
        whitePawn7 = getImageIcon("/Images/white_pawn.png", 46, 58);
        whitePawn8 = getImageIcon("/Images/white_pawn.png", 46, 58);
        blackPawn1 = getImageIcon("/Images/black_pawn.png");
        blackPawn2 = getImageIcon("/Images/black_pawn.png");
        blackPawn3 = getImageIcon("/Images/black_pawn.png");
        blackPawn4 = getImageIcon("/Images/black_pawn.png");
        blackPawn5 = getImageIcon("/Images/black_pawn.png");
        blackPawn6 = getImageIcon("/Images/black_pawn.png");
        blackPawn7 = getImageIcon("/Images/black_pawn.png");
        blackPawn8 = getImageIcon("/Images/black_pawn.png");
    }

    private ImageIcon getImageIcon(String path) {
        return getImageIcon(path, 65, 65);
    }

    private ImageIcon getImageIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(
                Objects.requireNonNull(getClass().getResource(path))
        );

        Image scaledImage = icon.getImage()
                .getScaledInstance(width, height, Image.SCALE_SMOOTH);

        return new ImageIcon(scaledImage);
    }

    private static void setupMenubar(JFrame frame) {
        restart = new JMenuItem("Restart");
        creatorMode = new JMenuItem("Creator Mode OFF");

        game = new JMenu("Game");
        game.add(restart);
        game.add(creatorMode);

        menubar = new JMenuBar();

        menubar.add(game);
        restart.addActionListener(e -> resetGame());
        creatorMode.addActionListener(e -> {
            handleCreatorMode();
        });

        frame.setJMenuBar(menubar);
    }

    private static void handleCreatorMode() {
        if (!isCreatorModeOn) {
            isCreatorModeOn = true;
            showClearBoardPopup();
            whiteKingMoved = false;
            whiteRook1Moved = false;
            whiteRook2Moved = false;
            blackRook2Moved = false;
            blackRook1Moved = false;
            blackKingMoved = false;
            whiteEnpasante1 = false;
            whiteEnpasante2 = false;
            whiteEnpasante3 = false;
            whiteEnpasante4 = false;
            whiteEnpasante5 = false;
            whiteEnpasante6 = false;
            whiteEnpasante7 = false;
            whiteEnpasante8 = false;
            blackEnpasante1 = false;
            blackEnpasante2 = false;
            blackEnpasante3 = false;
            blackEnpasante4 = false;
            blackEnpasante5 = false;
            blackEnpasante6 = false;
            blackEnpasante7 = false;
            blackEnpasante8 = false;
            uselessHalfMoves = 0;
        } else {
            boolean isWhiteKingPresent = false;
            boolean isBlackKingPresent = false;
            for (JLabel[] jLabels : board) {
                for (int j = 0; j < board.length; j++) {
                    if (getType((ImageIcon) jLabels[j].getIcon()).equals("king")
                            && getColor(jLabels[j]).equals("white")) {
                        isWhiteKingPresent = true;
                    }
                    if (getType((ImageIcon) jLabels[j].getIcon()).equals("king")
                            && getColor(jLabels[j]).equals("black")) {
                        isBlackKingPresent = true;
                    }
                }
            }
            if (!isWhiteKingPresent || !isBlackKingPresent) {
                JOptionPane.showMessageDialog(null, "Please Add at least one black King and one white King");
                return;
            }
            isCreatorModeOn = false;
            creatorMode.setText("Creator Mode OFF");
            showPlayerChoicePopup();
        }
    }

    private static void setupSounds() {
        start = new File("src/sounds/game-start.wav");
        capture = new File("src/sounds/capture.wav");
        move = new File("src/sounds/move.wav");
        castle = new File("src/sounds/castle.wav");
        promote = new File("src/sounds/promote.wav");
        win = new File("src/sounds/win.wav");
    }

    public static void showPlayerChoicePopup() {
        JFrame PlayerChoiceWindow = new JFrame("Player Choice Window");
        PlayerChoiceWindow.setSize(400, 85);
        PlayerChoiceWindow.setLocationRelativeTo(null); // Center the window

        JPanel PlayerChoicePanel = new JPanel();
        PlayerChoicePanel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Who Goes First?");
        PlayerChoicePanel.add(label);

        JButton Player1Button = new JButton("White");
        Player1Button.addActionListener(e -> {
            player = "white";
            PlayerChoiceWindow.dispose();
        });
        PlayerChoicePanel.add(Player1Button);

        JButton Player2Button = new JButton("Black");
        Player2Button.addActionListener(e -> {
            player = "black";
            PlayerChoiceWindow.dispose();
        });
        PlayerChoicePanel.add(Player2Button);


        PlayerChoiceWindow.add(PlayerChoicePanel);
        PlayerChoiceWindow.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }

    public static void initialiseBoard() {
        if (!isCreatorModeOn) {
            try {
                AudioInputStream ais = AudioSystem.getAudioInputStream(start);
                Clip clip = AudioSystem.getClip();
                clip.open(ais);
                clip.loop(0);
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                throw new RuntimeException(e);
            }
            board[0][0].setIcon(blackRook1);
            board[0][7].setIcon(blackRook2);
            board[0][1].setIcon(blackKnight1);
            board[0][6].setIcon(blackKnight2);
            board[0][2].setIcon(blackBishop1);
            board[0][5].setIcon(blackBishop2);
            board[0][3].setIcon(blackQueen);
            board[0][4].setIcon(blackKing);
            board[1][0].setIcon(blackPawn1);
            board[1][1].setIcon(blackPawn2);
            board[1][2].setIcon(blackPawn3);
            board[1][3].setIcon(blackPawn4);
            board[1][4].setIcon(blackPawn5);
            board[1][5].setIcon(blackPawn6);
            board[1][6].setIcon(blackPawn7);
            board[1][7].setIcon(blackPawn8);
            board[7][0].setIcon(whiteRook1);
            board[7][7].setIcon(whiteRook2);
            board[7][1].setIcon(whiteKnight1);
            board[7][6].setIcon(whiteKnight2);
            board[7][2].setIcon(whiteBishop1);
            board[7][5].setIcon(whiteBishop2);
            board[7][3].setIcon(whiteQueen);
            board[7][4].setIcon(whiteKing);
            board[6][0].setIcon(whitePawn1);
            board[6][1].setIcon(whitePawn2);
            board[6][2].setIcon(whitePawn3);
            board[6][3].setIcon(whitePawn4);
            board[6][4].setIcon(whitePawn5);
            board[6][5].setIcon(whitePawn6);
            board[6][6].setIcon(whitePawn7);
            board[6][7].setIcon(whitePawn8);
        }

        // Perform Modifications below
    }

    public static void showClearBoardPopup() {
        JFrame clearBoardWindow = new JFrame("Clear Board");
        clearBoardWindow.setSize(400, 85);
        clearBoardWindow.setLocationRelativeTo(null); // Center the window

        JPanel clearBoardPanel = new JPanel();
        clearBoardPanel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Want to reset the board?");
        clearBoardPanel.add(label);

        JButton yes = new JButton("Yes");
        yes.addActionListener(e -> {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    board[i][j].setBackground((i + j) % 2 != 0 ? darkSquare : lightSquare);
                    board[i][j].setIcon(null);
                    board[i][j].setBorder(null);
                }
            }
            clearBoardWindow.dispose();
        });
        clearBoardPanel.add(yes);

        JButton no = new JButton("No");
        no.addActionListener(e -> {
            clearBoardWindow.dispose();
        });
        clearBoardPanel.add(no);
        clearBoardWindow.add(clearBoardPanel);
        clearBoardWindow.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel clickedCell = (JLabel) e.getSource();
        int row = -1;
        int col = -1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != clickedCell) {
                    board[i][j].setBorder(null);
                    board[i][j].setBackground((i + j) % 2 != 0 ? darkSquare : lightSquare);
                } else {
                    row = i;
                    col = j;
                }
            }
        }
        if (isCreatorModeOn) {
            handleCreatorMode(row, col);
        } else {
            if (clickedStack.isEmpty()) {

                if (player.equals(getColor(clickedCell))) {
                    clickedStack.push(clickedCell);
                }
            } else {
                clickedStack.push(clickedCell);
            }
            // Highlight the selected piece
            if ((clickedCell.getBorder() == null && clickedCell.getIcon() != null
                    && player.equals(getColor(clickedCell))
                    || clickedCell.getBackground() == pinkHighLight)) {
                clickedCell.setBorder(BorderFactory.createLineBorder(Color.red, 5));
            } else {
                clickedCell.setBorder(null);
            }
            if (clickedStack.size() == 2) {
                movePiece(clickedStack.get(0), clickedStack.get(1));
                clickedStack.pop();
                clickedStack.pop();
            }

            String pieceColor = getColor(clickedCell);
            String pieceType = getType((ImageIcon) clickedCell.getIcon());
            if (pieceType.equals("pawn")) {
                Pawn pawn = new Pawn(row, col, pieceColor);
                pawn.highlightCells(row, col);
            }
            if (pieceType.equals("queen")) {
                Queen queen = new Queen(row, col, pieceColor);
                queen.highlightCells(row, col);
            }
            if (pieceType.equals("knight")) {
                Knight knight = new Knight(row, col, pieceColor);
                knight.highlightCells(row, col);
            }
            if (pieceType.equals("rook")) {
                Rook rook = new Rook(row, col, pieceColor);
                rook.highlightCells(row, col);
            }
            if (pieceType.equals("bishop")) {
                Bishop bishop = new Bishop(row, col, pieceColor);
                bishop.highlightCells(row, col);
            }
            if (pieceType.equals("king")) {
                King king = new King(row, col, pieceColor);
                king.highlightCells(row, col);
            }
            if (clickedCell.getBorder() == null && clickedCell.getIcon() != null) {
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board.length; j++) {
                        board[i][j].setBorder(null);
                        if ((i + j) % 2 != 0) {
                            board[i][j].setBackground(darkSquare); // Dark square color
                        } else {
                            board[i][j].setBackground(lightSquare); // Light square color
                        }
                    }
                }
            }
            if (!isCreatorModeOn) {
                if (isCheck("white", board)) {
                    for (JLabel[] jLabels : board) {
                        for (int j = 0; j < board.length; j++) {
                            if (getColor(jLabels[j]).equals("white")
                                    && getType((ImageIcon) jLabels[j].getIcon()).equals("king")) {
                                try {
                                    AudioInputStream ais = AudioSystem.getAudioInputStream(capture);
                                    Clip clip = AudioSystem.getClip();
                                    clip.open(ais);
                                    clip.loop(0);
                                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException a) {
                                    throw new RuntimeException(a);
                                }
                                jLabels[j].setBackground(pinkHighLight);
                                jLabels[j].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                            }
                        }
                    }
                    if (isCheckMate("white")) {
                        try {
                            AudioInputStream ais = AudioSystem.getAudioInputStream(win);
                            Clip clip = AudioSystem.getClip();
                            clip.open(ais);
                            clip.loop(0);
                        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException a) {
                            throw new RuntimeException(a);
                        }
                        JOptionPane.showMessageDialog(null, "Black wins!");
                        resetGame();
                    }
                } else {
                    if (checkDraw("white") == 1) {
                        try {
                            AudioInputStream ais = AudioSystem.getAudioInputStream(win);
                            Clip clip = AudioSystem.getClip();
                            clip.open(ais);
                            clip.loop(0);
                        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException a) {
                            throw new RuntimeException(a);
                        }
                        JOptionPane.showMessageDialog(null, "Draw by Stalemate!");
                        resetGame();
                    } else if (checkDraw("white") == 2) {
                        try {
                            AudioInputStream ais = AudioSystem.getAudioInputStream(win);
                            Clip clip = AudioSystem.getClip();
                            clip.open(ais);
                            clip.loop(0);
                        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException a) {
                            throw new RuntimeException(a);
                        }
                        JOptionPane.showMessageDialog(null, "Draw by Insufficient pieces!");
                        resetGame();
                    } else if (checkDraw("white") == 3) {
                        try {
                            AudioInputStream ais = AudioSystem.getAudioInputStream(win);
                            Clip clip = AudioSystem.getClip();
                            clip.open(ais);
                            clip.loop(0);
                        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException a) {
                            throw new RuntimeException(a);
                        }
                        JOptionPane.showMessageDialog(null, "Draw by 50-move rule");
                        resetGame();
                    }
                }
                if (isCheck("black", board)) {
                    for (JLabel[] jLabels : board) {
                        for (int j = 0; j < board.length; j++) {
                            if (getColor(jLabels[j]).equals("black")
                                    && getType((ImageIcon) jLabels[j].getIcon()).equals("king")) {
                                try {
                                    AudioInputStream ais = AudioSystem.getAudioInputStream(capture);
                                    Clip clip = AudioSystem.getClip();
                                    clip.open(ais);
                                    clip.loop(0);
                                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException a) {
                                    throw new RuntimeException(a);
                                }
                                jLabels[j].setBackground(pinkHighLight);
                                jLabels[j].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                            }
                        }
                    }
                    if (isCheckMate("black")) {
                        try {
                            AudioInputStream ais = AudioSystem.getAudioInputStream(win);
                            Clip clip = AudioSystem.getClip();
                            clip.open(ais);
                            clip.loop(0);
                        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException a) {
                            throw new RuntimeException(a);
                        }
                        JOptionPane.showMessageDialog(null, "White wins!");
                        resetGame();
                    }
                } else {
                    if (checkDraw("black") == 1) {
                        try {
                            AudioInputStream ais = AudioSystem.getAudioInputStream(win);
                            Clip clip = AudioSystem.getClip();
                            clip.open(ais);
                            clip.loop(0);
                        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException a) {
                            throw new RuntimeException(a);
                        }
                        JOptionPane.showMessageDialog(null, "Draw by Stalemate!");
                        resetGame();
                    } else if (checkDraw("black") == 2) {
                        try {
                            AudioInputStream ais = AudioSystem.getAudioInputStream(win);
                            Clip clip = AudioSystem.getClip();
                            clip.open(ais);
                            clip.loop(0);
                        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException a) {
                            throw new RuntimeException(a);
                        }
                        JOptionPane.showMessageDialog(null, "Draw by Insufficient pieces!");
                        resetGame();
                    } else if (checkDraw("black") == 3) {
                        try {
                            AudioInputStream ais = AudioSystem.getAudioInputStream(win);
                            Clip clip = AudioSystem.getClip();
                            clip.open(ais);
                            clip.loop(0);
                        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException a) {
                            throw new RuntimeException(a);
                        }
                        JOptionPane.showMessageDialog(null, "Draw by 50-move rule");
                        resetGame();
                    }
                }
            }
        }

    }

    public static void handleCreatorMode(int row, int col) {
        JFrame creatorModeWindow = new JFrame("Creator Mode");
        creatorModeWindow.setSize(400, 400);
        creatorModeWindow.setLocationRelativeTo(null); // Center the window

        JPanel creatorModePanel = new JPanel();
        creatorModePanel.setLayout(new FlowLayout());

        JButton whiteQueenButton = new JButton(whiteQueen);
        whiteQueenButton.addActionListener(e -> addPiece(row, col, whiteQueen, creatorModeWindow, "white"));
        creatorModePanel.add(whiteQueenButton);

        JButton whiteRookButton = new JButton(whiteRook2);
        whiteRookButton.addActionListener(e -> addPiece(row, col, whiteRook1, creatorModeWindow, "white"));
        creatorModePanel.add(whiteRookButton);

        JButton whiteBishopButton = new JButton(whiteBishop1);
        whiteBishopButton.addActionListener(e -> addPiece(row, col, whiteBishop1, creatorModeWindow, "white"));
        creatorModePanel.add(whiteBishopButton);

        JButton whiteKnightButton = new JButton(whiteKnight1);
        whiteKnightButton.addActionListener(e -> addPiece(row, col, whiteKnight1, creatorModeWindow, "white"));
        creatorModePanel.add(whiteKnightButton);

        JButton whiteKingButton = new JButton(whiteKing);
        whiteKingButton.addActionListener(e -> addPiece(row, col, whiteKing, creatorModeWindow, "white"));
        creatorModePanel.add(whiteKingButton);

        JButton whitePawnButton = new JButton(whitePawn1);
        whitePawnButton.addActionListener(e -> addPiece(row, col, whitePawn1, creatorModeWindow, "white"));
        creatorModePanel.add(whitePawnButton);

        JButton blackQueenButton = new JButton(blackQueen);
        blackQueenButton.addActionListener(e -> addPiece(row, col, blackQueen, creatorModeWindow, "black"));
        creatorModePanel.add(blackQueenButton);

        JButton blackRookButton = new JButton(blackRook2);
        blackRookButton.addActionListener(e -> addPiece(row, col, blackRook1, creatorModeWindow, "black"));
        creatorModePanel.add(blackRookButton);

        JButton blackBishopButton = new JButton(blackBishop1);
        blackBishopButton.addActionListener(e -> addPiece(row, col, blackBishop1, creatorModeWindow, "black"));
        creatorModePanel.add(blackBishopButton);

        JButton blackKnightButton = new JButton(blackKnight1);
        blackKnightButton.addActionListener(e -> addPiece(row, col, blackKnight1, creatorModeWindow, "black"));
        creatorModePanel.add(blackKnightButton);

        JButton blackKingButton = new JButton(blackKing);
        blackKingButton.addActionListener(e -> addPiece(row, col, blackKing, creatorModeWindow, "black"));
        creatorModePanel.add(blackKingButton);

        JButton blackPawnButton = new JButton(blackPawn1);
        blackPawnButton.addActionListener(e -> addPiece(row, col, blackPawn1, creatorModeWindow, "black"));
        creatorModePanel.add(blackPawnButton);

        JButton removeButton = new JButton("Remove Piece");
        removeButton.addActionListener(e -> {
            board[row][col].setIcon(null);
            creatorModeWindow.dispose();
        });
        creatorModePanel.add(removeButton);

        creatorModeWindow.add(creatorModePanel);
        creatorModeWindow.setVisible(true);
    }

    public static void addPiece(int row, int col, ImageIcon addedPiece, JFrame creatorModeWindow, String pieceColor) {
        if (getType(addedPiece).equals("king")) {
            if (pieceColor.equals("white")) {
                for (JLabel[] jLabels : board) {
                    for (int j = 0; j < board.length; j++) {
                        if (getType((ImageIcon) jLabels[j].getIcon()).equals("king")
                                && getColor(jLabels[j]).equals("white")) {
                            JOptionPane.showMessageDialog(null, "white King already exists");
                            return;
                        }
                    }
                }
                if (!new King(row, col, "white").isSafe(row, col)) {
                    JOptionPane.showMessageDialog(null, "Invalid position for king");
                    return;
                }
            } else if (pieceColor.equals("black")) {
                for (JLabel[] jLabels : board) {
                    for (int j = 0; j < board.length; j++) {
                        if (getType((ImageIcon) jLabels[j].getIcon()).equals("king")
                                && getColor(jLabels[j]).equals("black")) {
                            JOptionPane.showMessageDialog(null, "black King already exists");
                            return;
                        }
                    }
                }
                if (!new King(row, col, "black").isSafe(row, col)) {
                    JOptionPane.showMessageDialog(null, "Invalid position for king");
                    return;
                }
            }

        }
        board[row][col].setIcon(addedPiece);
        creatorModeWindow.dispose();
    }

    public static void movePiece(JLabel source, JLabel destination) {
        if (source != destination
                && source.getIcon() != null
                && getColor(source).equals(player)
                && !getColor(source).equals(getColor(destination))
                && !(getColor( source).equals("white")
                && getType((ImageIcon) destination.getIcon()).equals("king")
                && getColor(destination).equals("black"))
                && !(getColor(source).equals("black")
                && getType((ImageIcon) destination.getIcon()).equals("king")
                && getColor(destination).equals("white"))
                && movableCells(source).contains(destination)) {
            Icon sourceIcon = source.getIcon();

            if (sourceIcon == whitePawn1 || sourceIcon == blackPawn1 || destination.getIcon() != null) {
                uselessHalfMoves = 0;
            } else {
                uselessHalfMoves++;
            }
            if (blackEnpasante1 && sourceIcon != whitePawn1 && destination != board[2][0]) {
                blackEnpasante1 = false;
            } else if (blackEnpasante2 && sourceIcon != whitePawn1 && destination != board[2][1]) {
                blackEnpasante2 = false;
            } else if (blackEnpasante3 && sourceIcon != whitePawn1 && destination != board[2][2]) {
                blackEnpasante3 = false;
            } else if (blackEnpasante4 && sourceIcon != whitePawn1 && destination != board[2][3]) {
                blackEnpasante4 = false;
            } else if (blackEnpasante5 && sourceIcon != whitePawn1 && destination != board[2][4]) {
                blackEnpasante5 = false;
            } else if (blackEnpasante6 && sourceIcon != whitePawn1 && destination != board[2][5]) {
                blackEnpasante6 = false;
            } else if (blackEnpasante7 && sourceIcon != whitePawn1 && destination != board[2][6]) {
                blackEnpasante7 = false;
            } else if (blackEnpasante8 && sourceIcon != whitePawn1 && destination != board[2][7]) {
                blackEnpasante8 = false;
            }

            if (whiteEnpasante1 && sourceIcon != blackPawn1 && destination != board[5][0]) {
                whiteEnpasante1 = false;
            } else if (whiteEnpasante2 && sourceIcon != blackPawn1 && destination != board[5][1]) {
                whiteEnpasante2 = false;
            } else if (whiteEnpasante3 && sourceIcon != blackPawn1 && destination != board[5][2]) {
                whiteEnpasante3 = false;
            } else if (whiteEnpasante4 && sourceIcon != blackPawn1 && destination != board[5][3]) {
                whiteEnpasante4 = false;
            } else if (whiteEnpasante5 && sourceIcon != blackPawn1 && destination != board[5][4]) {
                whiteEnpasante5 = false;
            } else if (whiteEnpasante6 && sourceIcon != blackPawn1 && destination != board[5][5]) {
                whiteEnpasante6 = false;
            } else if (whiteEnpasante7 && sourceIcon != blackPawn1 && destination != board[5][6]) {
                whiteEnpasante7 = false;
            } else if (whiteEnpasante8 && sourceIcon != blackPawn1 && destination != board[5][7]) {
                whiteEnpasante8 = false;
            }
            if (sourceIcon == blackPawn1) {
                if (source == board[1][0] && destination == board[3][0]) {
                    blackEnpasante1 = true;
                } else if (source == board[1][1] && destination == board[3][1]) {
                    blackEnpasante2 = true;
                } else if (source == board[1][2] && destination == board[3][2]) {
                    blackEnpasante3 = true;
                } else if (source == board[1][3] && destination == board[3][3]) {
                    blackEnpasante4 = true;
                } else if (source == board[1][4] && destination == board[3][4]) {
                    blackEnpasante5 = true;
                } else if (source == board[1][5] && destination == board[3][5]) {
                    blackEnpasante6 = true;
                } else if (source == board[1][6] && destination == board[3][6]) {
                    blackEnpasante7 = true;
                } else if (source == board[1][7] && destination == board[3][7]) {
                    blackEnpasante8 = true;
                }
            } else if (sourceIcon == whitePawn1) {
                if (source == board[6][0] && destination == board[4][0]) {
                    whiteEnpasante1 = true;
                } else if (source == board[6][1] && destination == board[4][1]) {
                    whiteEnpasante2 = true;
                } else if (source == board[6][2] && destination == board[4][2]) {
                    whiteEnpasante3 = true;
                } else if (source == board[6][3] && destination == board[4][3]) {
                    whiteEnpasante4 = true;
                } else if (source == board[6][4] && destination == board[4][4]) {
                    whiteEnpasante5 = true;
                } else if (source == board[6][5] && destination == board[4][5]) {
                    whiteEnpasante6 = true;
                } else if (source == board[6][6] && destination == board[4][6]) {
                    whiteEnpasante7 = true;
                } else if (source == board[6][7] && destination == board[4][7]) {
                    whiteEnpasante8 = true;
                }
            }

            // movements
            if (blackEnpasante1 && sourceIcon == whitePawn1 && destination == board[2][0]) {
                blackEnpasante1 = false;
                destination.setIcon(sourceIcon);
                source.setIcon(null);
                board[3][0].setIcon(null);
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (blackEnpasante2 && sourceIcon == whitePawn1 && destination == board[2][1]) {
                destination.setIcon(sourceIcon);
                source.setIcon(null);
                board[3][1].setIcon(null);
                blackEnpasante2 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (blackEnpasante3 && sourceIcon == whitePawn1 && destination == board[2][2]) {
                destination.setIcon(sourceIcon);
                source.setIcon(null);
                board[3][2].setIcon(null);
                blackEnpasante3 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (blackEnpasante4 && sourceIcon == whitePawn1 && destination == board[2][3]) {
                destination.setIcon(sourceIcon);
                source.setIcon(null);
                board[3][3].setIcon(null);
                blackEnpasante4 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (blackEnpasante5 && sourceIcon == whitePawn1 && destination == board[2][4]) {
                destination.setIcon(sourceIcon);
                source.setIcon(null);
                board[3][4].setIcon(null);
                blackEnpasante5 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (blackEnpasante6 && sourceIcon == whitePawn1 && destination == board[2][5]) {
                destination.setIcon(sourceIcon);
                source.setIcon(null);
                board[3][5].setIcon(null);
                blackEnpasante6 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (blackEnpasante7 && sourceIcon == whitePawn1 && destination == board[2][6]) {
                destination.setIcon(sourceIcon);
                source.setIcon(null);
                board[3][6].setIcon(null);
                blackEnpasante7 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (blackEnpasante8 && sourceIcon == whitePawn1 && destination == board[2][7]) {
                destination.setIcon(sourceIcon);
                source.setIcon(null);
                board[3][7].setIcon(null);
                blackEnpasante8 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            }

            if (whiteEnpasante1 && sourceIcon == blackPawn1 && destination == board[5][0]) {
                destination.setIcon(sourceIcon);
                source.setIcon(null);
                board[4][0].setIcon(null);
                whiteEnpasante1 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (whiteEnpasante2 && sourceIcon == blackPawn1 && destination == board[5][1]) {
                destination.setIcon(sourceIcon);
                source.setIcon(null);
                board[4][1].setIcon(null);
                whiteEnpasante2 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (whiteEnpasante3 && sourceIcon == blackPawn1 && destination == board[5][2]) {
                destination.setIcon(sourceIcon);
                source.setIcon(null);
                board[4][2].setIcon(null);
                whiteEnpasante3 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (whiteEnpasante4 && sourceIcon == blackPawn1 && destination == board[5][3]) {
                destination.setIcon(sourceIcon);
                source.setIcon(null);
                board[4][3].setIcon(null);
                whiteEnpasante4 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (whiteEnpasante5 && sourceIcon == blackPawn1 && destination == board[5][4]) {
                destination.setIcon(sourceIcon);
                source.setIcon(null);
                board[4][4].setIcon(null);
                whiteEnpasante5 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (whiteEnpasante6 && sourceIcon == blackPawn1 && destination == board[5][5]) {
                destination.setIcon(sourceIcon);
                source.setIcon(null);
                board[4][5].setIcon(null);
                whiteEnpasante6 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (whiteEnpasante7 && sourceIcon == blackPawn1 && destination == board[5][6]) {
                destination.setIcon(sourceIcon);
                source.setIcon(null);
                board[4][6].setIcon(null);
                whiteEnpasante7 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (whiteEnpasante8 && sourceIcon == blackPawn1 && destination == board[5][7]) {
                destination.setIcon(sourceIcon);
                source.setIcon(null);
                board[4][7].setIcon(null);
                whiteEnpasante8 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            }

            if (sourceIcon == blackPawn1) {
                if (source == board[1][0] && destination == board[3][0]) {
                    blackEnpasante1 = true;
                } else if (source == board[1][1] && destination == board[3][1]) {
                    blackEnpasante2 = true;
                } else if (source == board[1][2] && destination == board[3][2]) {
                    blackEnpasante3 = true;
                } else if (source == board[1][3] && destination == board[3][3]) {
                    blackEnpasante4 = true;
                } else if (source == board[1][4] && destination == board[3][4]) {
                    blackEnpasante5 = true;
                } else if (source == board[1][5] && destination == board[3][5]) {
                    blackEnpasante6 = true;
                } else if (source == board[1][6] && destination == board[3][6]) {
                    blackEnpasante7 = true;
                } else if (source == board[1][7] && destination == board[3][7]) {
                    blackEnpasante8 = true;
                }
            } else if (sourceIcon == whitePawn1) {
                if (source == board[6][0] && destination == board[4][0]) {
                    whiteEnpasante1 = true;
                } else if (source == board[6][1] && destination == board[4][1]) {
                    whiteEnpasante2 = true;
                } else if (source == board[6][2] && destination == board[4][2]) {
                    whiteEnpasante3 = true;
                } else if (source == board[6][3] && destination == board[4][3]) {
                    whiteEnpasante4 = true;
                } else if (source == board[6][4] && destination == board[4][4]) {
                    whiteEnpasante5 = true;
                } else if (source == board[6][5] && destination == board[4][5]) {
                    whiteEnpasante6 = true;
                } else if (source == board[6][6] && destination == board[4][6]) {
                    whiteEnpasante7 = true;
                } else if (source == board[6][7] && destination == board[4][7]) {
                    whiteEnpasante8 = true;
                }
            }
            if (sourceIcon == whiteKing) {
                whiteKingMoved = true;
            } else if (sourceIcon == whiteRook1 && board[7][0] == source) {
                whiteRook1Moved = true;
            } else if (sourceIcon == whiteRook1 && board[7][7] == source) {
                whiteRook2Moved = true;
            } else if (sourceIcon == blackKing) {
                blackKingMoved = true;
            } else if (sourceIcon == blackRook1 && board[0][0] == source) {
                blackRook1Moved = true;
            } else if (sourceIcon == blackRook1 && board[0][7] == source) {
                blackRook2Moved = true;
            }
            if (source == board[7][4] && sourceIcon == whiteKing && destination == board[7][6]) {
                destination.setIcon(whiteKing);
                source.setIcon(null);
                board[7][7].setIcon(null);
                board[7][5].setIcon(whiteRook2);
                player = Objects.equals(player, "white") ? "black" : "white";
                destination.setBorder(null);
                try {
                    AudioInputStream ais = AudioSystem.getAudioInputStream(castle);
                    Clip clip = AudioSystem.getClip();
                    clip.open(ais);
                    clip.loop(0);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    throw new RuntimeException(e);
                }
                return;
            }
            if (source == board[7][4] && sourceIcon == whiteKing && destination == board[7][1]) {
                destination.setIcon(whiteKing);
                source.setIcon(null);
                board[7][0].setIcon(null);
                board[7][2].setIcon(whiteRook1);
                player = Objects.equals(player, "white") ? "black" : "white";
                destination.setBorder(null);
                try {
                    AudioInputStream ais = AudioSystem.getAudioInputStream(castle);
                    Clip clip = AudioSystem.getClip();
                    clip.open(ais);
                    clip.loop(0);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    throw new RuntimeException(e);
                }
                return;
            }
            if (source == board[0][4] && sourceIcon == blackKing && destination == board[0][6]) {
                destination.setIcon(blackKing);
                source.setIcon(null);
                board[0][7].setIcon(null);
                board[0][5].setIcon(blackRook2);
                player = Objects.equals(player, "white") ? "black" : "white";
                destination.setBorder(null);
                try {
                    AudioInputStream ais = AudioSystem.getAudioInputStream(castle);
                    Clip clip = AudioSystem.getClip();
                    clip.open(ais);
                    clip.loop(0);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    throw new RuntimeException(e);
                }
                return;
            }
            if (source == board[0][4] && sourceIcon == blackKing && destination == board[0][1]) {
                destination.setIcon(blackKing);
                source.setIcon(null);
                board[0][0].setIcon(null);
                board[0][2].setIcon(blackRook1);
                player = Objects.equals(player, "white") ? "black" : "white";
                destination.setBorder(null);
                try {
                    AudioInputStream ais = AudioSystem.getAudioInputStream(castle);
                    Clip clip = AudioSystem.getClip();
                    clip.open(ais);
                    clip.loop(0);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    throw new RuntimeException(e);
                }
                return;
            }
            if (destination.getIcon() == null) {
                try {
                    AudioInputStream ais = AudioSystem.getAudioInputStream(move);
                    Clip clip = AudioSystem.getClip();
                    clip.open(ais);
                    clip.loop(0);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    AudioInputStream ais = AudioSystem.getAudioInputStream(capture);
                    Clip clip = AudioSystem.getClip();
                    clip.open(ais);
                    clip.loop(0);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    throw new RuntimeException(e);
                }
            }
            destination.setIcon(sourceIcon);
            source.setIcon(null);
            if (canPromote(player)) {
                handlePromotion(player);
                destination.setBorder(null);
                player = Objects.equals(player, "white") ? "black" : "white";
                return;
            }
            player = Objects.equals(player, "white") ? "black" : "white";
        }
        destination.setBorder(null);
    }

    public static void handlePromotion(String color) {
        if (color.equals("white")) {
            int row = 0;
            int x = 0;
            for (int j = 0; j < board.length; j++) {
                if (isWhite(board[0][j])
                        && getType((ImageIcon) board[0][j].getIcon()).equals("pawn")) {
                    x = j;
                    break;
                }
            }
            int col = x;
            JFrame promotionWindow = new JFrame("Pawn Promotion");
            promotionWindow.setSize(400, 230);
            promotionWindow.setLocationRelativeTo(null); // Center the window

            JPanel promotionPanel = new JPanel();
            promotionPanel.setLayout(new FlowLayout());
            JButton queenButton = new JButton(whiteQueen);
            queenButton.addActionListener(e -> promotePawn(row, col, whiteQueen, promotionWindow));
            promotionPanel.add(queenButton);

            JButton rookButton = new JButton(whiteRook1);
            rookButton.addActionListener(e -> promotePawn(row, col, whiteRook1, promotionWindow));
            promotionPanel.add(rookButton);

            JButton bishopButton = new JButton(whiteBishop1);
            bishopButton.addActionListener(e -> promotePawn(row, col, whiteBishop1, promotionWindow));
            promotionPanel.add(bishopButton);

            JButton knightButton = new JButton(whiteKnight1);
            knightButton.addActionListener(e -> promotePawn(row, col, whiteKnight1, promotionWindow));
            promotionPanel.add(knightButton);

            promotionWindow.add(promotionPanel);
            promotionWindow.setVisible(true);
        } else {
            int row = 7;
            int x = 0;
            for (int j = 0; j < board.length; j++) {
                if (isBlack(board[7][j])
                        && getType((ImageIcon) board[7][j].getIcon()).equals("pawn")) {
                    x = j;
                    break;
                }
            }
            int col = x;
            JFrame promotionWindow = new JFrame("Pawn Promotion");
            promotionWindow.setSize(400, 230);
            promotionWindow.setLocationRelativeTo(null); // Center the window

            JPanel promotionPanel = new JPanel();
            promotionPanel.setLayout(new FlowLayout());
            JButton queenButton = new JButton(blackQueen);
            queenButton.addActionListener(e -> promotePawn(row, col, blackQueen, promotionWindow));
            promotionPanel.add(queenButton);

            JButton rookButton = new JButton(blackRook1);
            rookButton.addActionListener(e -> promotePawn(row, col, blackRook1, promotionWindow));
            promotionPanel.add(rookButton);

            JButton bishopButton = new JButton(blackBishop1);
            bishopButton.addActionListener(e -> promotePawn(row, col, blackBishop1, promotionWindow));
            promotionPanel.add(bishopButton);

            JButton knightButton = new JButton(blackKnight1);
            knightButton.addActionListener(e -> promotePawn(row, col, blackKnight1, promotionWindow));
            promotionPanel.add(knightButton);

            promotionWindow.add(promotionPanel);
            promotionWindow.setVisible(true);
        }
    }

    public static void promotePawn(int row, int col, ImageIcon promotionPiece, JFrame promotionWindow) {
        board[row][col].setIcon(promotionPiece);
        promotionWindow.dispose(); // Close promotion window
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(promote);
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.loop(0);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean canPromote(String color) {
        if (color.equals("white")) {
            for (int col = 0; col < board.length; col++) {
                if (isWhite(board[0][col])
                        && getType((ImageIcon) board[0][col].getIcon()).equals("pawn")) {
                    return true;
                }
            }
            return false;
        } else {
            for (int col = 0; col < board.length; col++) {
                if (isBlack(board[7][col])
                        && getType((ImageIcon) board[7][col].getIcon()).equals("pawn")) {
                    return true;
                }
            }
            return false;
        }
    }

    public static boolean isWhite(JLabel cell) {
        return getColor(cell).equals("white");
    }

    public static boolean isBlack(JLabel cell) {
        return getColor(cell).equals("black");
    }

    public static boolean isEmpty(JLabel cell) {
        return getColor(cell).equals("empty");
    }

    public static List<JLabel> movableCells(JLabel source) {
        int row = -1;
        int col = -1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == source) {
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        if (getType((ImageIcon) source.getIcon()).equals("pawn")) {
            Pawn pawn = new Pawn(row, col, getColor(source));
            return pawn.movableCells();
        }
        if (getType((ImageIcon) source.getIcon()).equals("queen")) {
            Queen queen = new Queen(row, col, getColor(source));
            return queen.movableCells();
        }
        if (getType((ImageIcon) source.getIcon()).equals("knight")) {
            Knight knight = new Knight(row, col, getColor(source));
            return knight.movableCells();
        }
        if (getType((ImageIcon) source.getIcon()).equals("rook")) {
            Rook rook = new Rook(row, col, getColor(source));
            return rook.movableCells();
        }
        if (getType((ImageIcon) source.getIcon()).equals("bishop")) {
            Bishop bishop = new Bishop(row, col, getColor(source));
            return bishop.movableCells();
        }
        if (getType((ImageIcon) source.getIcon()).equals("king")) {
            King king = new King(row, col, getColor(source));
            return king.movableCells();
        }
        return new ArrayList<>();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public static String getColor(JLabel cell) {
        ImageIcon i = (ImageIcon) cell.getIcon();
        if (i == null) {
            return "empty";
        }
        if (compareImages(i.getImage(), blackRook1.getImage())
                || compareImages(i.getImage(), blackRook2.getImage())
                || compareImages(i.getImage(), blackBishop1.getImage())
                || compareImages(i.getImage(), blackBishop2.getImage())
                || compareImages(i.getImage(), blackKnight1.getImage())
                || compareImages(i.getImage(), blackKnight2.getImage())
                || compareImages(i.getImage(), blackKing.getImage())
                || compareImages(i.getImage(), blackQueen.getImage())
                || compareImages(i.getImage(), blackPawn2.getImage())
                || compareImages(i.getImage(), blackPawn3.getImage())
                || compareImages(i.getImage(), blackPawn4.getImage())
                || compareImages(i.getImage(), blackPawn5.getImage())
                || compareImages(i.getImage(), blackPawn6.getImage())
                || compareImages(i.getImage(), blackPawn7.getImage())
                || compareImages(i.getImage(), blackPawn8.getImage())
                || compareImages(i.getImage(), blackPawn1.getImage())) {
            return "black";
        }
        return "white";
    }


    public static String getType(ImageIcon i) {
        if (i == null) {
            return "empty";
        }
        if (compareImages(i.getImage(), blackRook2.getImage())
                || compareImages(i.getImage(), blackRook1.getImage())
                || compareImages(i.getImage(), whiteRook1.getImage())
                || compareImages(i.getImage(), whiteRook2.getImage())) {
            return "rook";
        }

        if (compareImages(i.getImage(), blackBishop1.getImage())
                || compareImages(i.getImage(), blackBishop2.getImage())
                || compareImages(i.getImage(), whiteBishop1.getImage())
                || compareImages(i.getImage(), whiteBishop2.getImage())) {
            return "bishop";
        }

        if (compareImages(i.getImage(), blackKnight2.getImage())
                || compareImages(i.getImage(), blackKnight1.getImage())
                || compareImages(i.getImage(), whiteKnight1.getImage())
                || compareImages(i.getImage(), whiteKnight2.getImage())) {
            return "knight";
        }

        if (compareImages(i.getImage(), blackQueen.getImage())
                || compareImages(i.getImage(), whiteQueen.getImage())) {
            return "queen";
        }

        if (compareImages(i.getImage(), blackKing.getImage())
                || compareImages(i.getImage(), whiteKing.getImage())) {
            return "king";
        }

        return "pawn";
    }

    public static boolean compareImages(Image img1, Image img2) {
        BufferedImage bufferedImage1 = toBufferedImage(img1);
        BufferedImage bufferedImage2 = toBufferedImage(img2);

        if (bufferedImage1.getWidth() != bufferedImage2.getWidth() ||
                bufferedImage1.getHeight() != bufferedImage2.getHeight()) {
            return false;
        }

        for (int y = 0; y < bufferedImage1.getHeight(); y++) {
            for (int x = 0; x < bufferedImage1.getWidth(); x++) {
                if (bufferedImage1.getRGB(x, y) != bufferedImage2.getRGB(x, y)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        BufferedImage bufferedImage = new BufferedImage(
                img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawImage(img, 0, 0, null);
        g2d.dispose();

        return bufferedImage;
    }

    public static boolean isCheck(String color, JLabel[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (getColor(board[i][j]).equals(color)
                        && getType((ImageIcon) board[i][j].getIcon()).equals("king")) {
                    King king = new King(i, j, color);
                    return !king.isSafe(i, j);
                }
            }
        }
        return false;
    }

    public static boolean isCheckMate(String color) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (getColor(board[i][j]).equals(color)) {
                    if (getType((ImageIcon) board[i][j].getIcon()).equals("king")) {
                        King king = new King(i, j, color);
                        if (!king.movableCells().isEmpty()) {
                            return false;
                        }
                    } else if (getType((ImageIcon) board[i][j].getIcon()).equals("queen")) {
                        Queen queen = new Queen(i, j, color);
                        if (!queen.movableCells().isEmpty()) {
                            return false;
                        }
                    } else if (getType((ImageIcon) board[i][j].getIcon()).equals("rook")) {
                        Rook rook = new Rook(i, j, color);
                        if (!rook.movableCells().isEmpty()) {
                            return false;
                        }
                    } else if (getType((ImageIcon) board[i][j].getIcon()).equals("knight")) {
                        Knight knight = new Knight(i, j, color);
                        if (!knight.movableCells().isEmpty()) {
                            return false;
                        }
                    } else if (getType((ImageIcon) board[i][j].getIcon()).equals("bishop")) {
                        Bishop bishop = new Bishop(i, j, color);
                        if (!bishop.movableCells().isEmpty()) {
                            return false;
                        }
                    } else {
                        Pawn pawn = new Pawn(i, j, color);
                        if (!pawn.movableCells().isEmpty()) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void resetGame() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j].setBackground((i + j) % 2 != 0 ? darkSquare : lightSquare);
                board[i][j].setIcon(null);
                board[i][j].setBorder(null);
            }
        }
        initialiseBoard();
        player = "white";
        whiteKingMoved = false;
        whiteRook1Moved = false;
        whiteRook2Moved = false;
        blackRook2Moved = false;
        blackRook1Moved = false;
        blackKingMoved = false;
        whiteEnpasante1 = false;
        whiteEnpasante2 = false;
        whiteEnpasante3 = false;
        whiteEnpasante4 = false;
        whiteEnpasante5 = false;
        whiteEnpasante6 = false;
        whiteEnpasante7 = false;
        whiteEnpasante8 = false;
        blackEnpasante1 = false;
        blackEnpasante2 = false;
        blackEnpasante3 = false;
        blackEnpasante4 = false;
        blackEnpasante5 = false;
        blackEnpasante6 = false;
        blackEnpasante7 = false;
        blackEnpasante8 = false;
        uselessHalfMoves = 0;
        initialiseBoard();
    }

    public static int checkDraw(String color) {
        if (Objects.equals(color, "white")) {
            // Stalemate
            if (!isCheck(color, board) && isCheckMate(color)) {
                return 1;
            }
            // Insufficient Material
            else if (insufficientMaterial(color)) {
                return 2;
            } else if (uselessHalfMoves == 100) {
                return 3;
            }
        } else {
            // Stalemate
            if (!isCheck(color, board) && isCheckMate(color)) {
                return 1;
            }
            // Insufficient Material
            else if (insufficientMaterial(color)) {
                return 2;
            } else if (uselessHalfMoves == 100) {
                return 3;
            }
        }
        return 0;
    }

    public static boolean insufficientMaterial(String color) {
        return kingvsking() || kingAndBishopVsKing(color) || kingAndKnightVsKing(color)
                || kingAndBishopVsKingAndBishop();
    }

    public static boolean kingvsking() {
        for (JLabel[] jLabels : board) {
            for (int j = 0; j < board.length; j++) {
                if (getType((ImageIcon) jLabels[j].getIcon()).equals("king")) {
                    continue;
                }
                if (!getType((ImageIcon) jLabels[j].getIcon()).equals("empty")) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean kingAndBishopVsKing(String color) {
        for (JLabel[] jLabels : board) {
            for (int j = 0; j < board.length; j++) {
                if (getType((ImageIcon) jLabels[j].getIcon()).equals("king")) {
                    continue;
                }
                if (!(getColor(jLabels[j]).equals(color)
                        && getType((ImageIcon) jLabels[j].getIcon()).equals("bishop"))
                        && !getColor(jLabels[j]).equals("empty")) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean kingAndKnightVsKing(String color) {
        for (JLabel[] jLabels : board) {
            for (int j = 0; j < board.length; j++) {
                if (getType((ImageIcon) jLabels[j].getIcon()).equals("king")) {
                    continue;
                }
                if (!(getColor(jLabels[j]).equals(color)
                        && getType((ImageIcon) jLabels[j].getIcon()).equals("knight"))
                        && !getColor(jLabels[j]).equals("empty")) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean kingAndBishopVsKingAndBishop() {
        int whiteRow = -1;
        int whiteCol = -1;
        int blackRow = -1;
        int blackCol = -1;
        int whiteBishops = 0;
        int blackBishops = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (getType((ImageIcon) board[i][j].getIcon()).equals("king") ||
                        (getColor(board[i][j]).equals("white")
                                && getType((ImageIcon) board[i][j].getIcon()).equals("bishop"))
                        ||
                        (getColor(board[i][j]).equals("black")
                                && getType((ImageIcon) board[i][j].getIcon()).equals("bishop"))
                        || getColor(board[i][j]).equals("empty")) {
                    if (getColor(board[i][j]).equals("white")
                            && getType((ImageIcon) board[i][j].getIcon()).equals("bishop")) {
                        whiteBishops++;
                        whiteRow = i;
                        whiteCol = j;
                    } else if (getColor(board[i][j]).equals("black")
                            && getType((ImageIcon) board[i][j].getIcon()).equals("bishop")) {
                        blackBishops++;
                        blackRow = i;
                        blackCol = j;
                    }
                } else {
                    return false;
                }
            }
        }

        if (whiteBishops > 1 || blackBishops > 1) {
            return false;
        }
        return board[whiteRow][whiteCol].getBackground() == board[blackRow][blackCol].getBackground();
    }
}
