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
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Main2 implements MouseListener {
    private static final IdentityHashMap<ImageIcon, String> colorCache = new IdentityHashMap<>();
    private static final IdentityHashMap<ImageIcon, String> typeCache = new IdentityHashMap<>();
    private static final IdentityHashMap<Image, BufferedImage> bufferedImageCache = new IdentityHashMap<>();
    public static JLabel[][] board2;
    public static ImageIcon blackRook1;
    public static ImageIcon blackRook2;
    public static ImageIcon blackRook3;
    public static ImageIcon blackRook4;
    public static ImageIcon whiteRook1;
    public static ImageIcon whiteRook2;
    public static ImageIcon whiteRook3;
    public static ImageIcon whiteRook4;
    public static ImageIcon blackKnight1;
    public static ImageIcon blackKnight2;
    public static ImageIcon blackKnight3;
    public static ImageIcon blackKnight4;
    public static ImageIcon whiteKnight1;
    public static ImageIcon whiteKnight2;
    public static ImageIcon whiteKnight3;
    public static ImageIcon whiteKnight4;
    public static ImageIcon blackBishop1;
    public static ImageIcon blackBishop2;
    public static ImageIcon blackBishop3;
    public static ImageIcon blackBishop4;
    public static ImageIcon whiteBishop1;
    public static ImageIcon whiteBishop2;
    public static ImageIcon whiteBishop3;
    public static ImageIcon whiteBishop4;
    public static ImageIcon blackQueen1;
    public static ImageIcon blackQueen2;
    public static ImageIcon whiteQueen1;
    public static ImageIcon whiteQueen2;
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
    public static ImageIcon blackPawn9;
    public static ImageIcon blackPawn10;
    public static ImageIcon blackPawn11;
    public static ImageIcon blackPawn12;
    public static ImageIcon blackPawn13;
    public static ImageIcon blackPawn14;
    public static ImageIcon blackPawn15;
    public static ImageIcon blackPawn16;
    public static ImageIcon whitePawn1;
    public static ImageIcon whitePawn2;
    public static ImageIcon whitePawn3;
    public static ImageIcon whitePawn4;
    public static ImageIcon whitePawn5;
    public static ImageIcon whitePawn6;
    public static ImageIcon whitePawn7;
    public static ImageIcon whitePawn8;
    public static ImageIcon whitePawn9;
    public static ImageIcon whitePawn10;
    public static ImageIcon whitePawn11;
    public static ImageIcon whitePawn12;
    public static ImageIcon whitePawn13;
    public static ImageIcon whitePawn14;
    public static ImageIcon whitePawn15;
    public static ImageIcon whitePawn16;
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
    public static boolean blackEnpasante9 = false;
    public static boolean blackEnpasante10 = false;
    public static boolean blackEnpasante11 = false;
    public static boolean blackEnpasante12 = false;
    public static boolean blackEnpasante13 = false;
    public static boolean blackEnpasante14 = false;
    public static boolean blackEnpasante15 = false;
    public static boolean blackEnpasante16 = false;
    public static boolean whiteEnpasante1 = false;
    public static boolean whiteEnpasante2 = false;
    public static boolean whiteEnpasante3 = false;
    public static boolean whiteEnpasante4 = false;
    public static boolean whiteEnpasante5 = false;
    public static boolean whiteEnpasante6 = false;
    public static boolean whiteEnpasante7 = false;
    public static boolean whiteEnpasante8 = false;
    public static boolean whiteEnpasante9 = false;
    public static boolean whiteEnpasante10 = false;
    public static boolean whiteEnpasante11 = false;
    public static boolean whiteEnpasante12 = false;
    public static boolean whiteEnpasante13 = false;
    public static boolean whiteEnpasante14 = false;
    public static boolean whiteEnpasante15 = false;
    public static boolean whiteEnpasante16 = false;
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

    Main2() {
        JFrame frame = new JFrame("Chess");
        frame.setLayout(new GridLayout(15, 15));
        board2 = new JLabel[15][15];

        // menubar
        menubar = new JMenuBar();
        game = new JMenu("Game");
        restart = new JMenuItem("Restart");
        creatorMode = new JMenuItem("Creator Mode OFF");

        // start sound
        start = new File("src/sounds/game-start.wav");
        capture = new File("src/sounds/capture.wav");
        move = new File("src/sounds/move.wav");
        castle = new File("src/sounds/castle.wav");
        promote = new File("src/sounds/promote.wav");
        win = new File("src/sounds/win.wav");

        menubar.add(game);
        game.add(restart);
        game.add(creatorMode);
        restart.addActionListener(e -> resetGame());
        creatorMode.addActionListener(e -> {
            if (!isCreatorModeOn) {
                isCreatorModeOn = true;
            } else {
                boolean isWhiteKingPresent = false;
                boolean isBlackKingPresent = false;
                for (int i = 0; i < board2.length; i++) {
                    for (int j = 0; j < board2.length; j++) {
                        if (getType((ImageIcon) board2[i][j].getIcon()).equals("king")
                                && getColor((ImageIcon) board2[i][j].getIcon()).equals("white")) {
                            isWhiteKingPresent = true;
                        }
                        if (getType((ImageIcon) board2[i][j].getIcon()).equals("king")
                                && getColor((ImageIcon) board2[i][j].getIcon()).equals("black")) {
                            isBlackKingPresent = true;
                        }
                    }
                }
                if (isWhiteKingPresent && isBlackKingPresent) {
                    isCreatorModeOn = false;
                    playerChoice();
                } else {
                    JOptionPane.showMessageDialog(null, "Please Add atleast one black King and one white King");
                    return;
                }
            }
            if (isCreatorModeOn) {
                creatorMode.setText("Creator Mode ON");
                clearBoard();
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
                whiteEnpasante9 = false;
                whiteEnpasante10 = false;
                whiteEnpasante11 = false;
                whiteEnpasante12 = false;
                whiteEnpasante13 = false;
                whiteEnpasante14 = false;
                whiteEnpasante15 = false;
                blackEnpasante1 = false;
                blackEnpasante2 = false;
                blackEnpasante3 = false;
                blackEnpasante4 = false;
                blackEnpasante5 = false;
                blackEnpasante6 = false;
                blackEnpasante7 = false;
                blackEnpasante8 = false;
                blackEnpasante9 = false;
                blackEnpasante10 = false;
                blackEnpasante11 = false;
                blackEnpasante12 = false;
                blackEnpasante13 = false;
                blackEnpasante14 = false;
                blackEnpasante15 = false;
                uselessHalfMoves = 0;

            } else {
                creatorMode.setText("Creator Mode OFF");
            }
        });
        frame.setJMenuBar(menubar);

        // Load the image icon
        blackRook1 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/black_rook.png")));
        blackRook2 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/black_rook.png")));
        blackRook3 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/black_rook.png")));
        blackRook4 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/black_rook.png")));
        whiteRook1 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/white_rook.png")));
        whiteRook2 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/white_rook.png")));
        whiteRook3 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/white_rook.png")));
        whiteRook4 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/white_rook.png")));
        blackKnight1 = blackKnight2 = blackKnight3 = blackKnight4 = new ImageIcon(
                Objects.requireNonNull(Objects.requireNonNull(getClass().getResource("/Images/black_knight.png"))));
        whiteKnight1 = whiteKnight2 = whiteKnight3 = whiteKnight4 = new ImageIcon(
                Objects.requireNonNull(getClass().getResource("/Images/white_knight.png")));
        blackBishop1 = blackBishop2 = blackBishop3 = blackBishop4 = new ImageIcon(
                Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(Objects
                        .requireNonNull(Objects.requireNonNull(getClass().getResource("/Images/black_bishop.png")))))));
        whiteBishop1 = whiteBishop2 = whiteBishop3 = whiteBishop4 = new ImageIcon(Objects.requireNonNull(
                Objects.requireNonNull(Objects.requireNonNull(getClass().getResource("/Images/white_bishop.png")))));
        blackQueen1 = blackQueen2 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/black_queen.png")));
        whiteQueen1 = whiteQueen2 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/white_queen.png")));
        blackKing = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/black_king.png")));
        whiteKing = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/white_king.png")));
        whitePawn1 = whitePawn2 = whitePawn3 = whitePawn4 = whitePawn5 = whitePawn6 = whitePawn7 = whitePawn8 = whitePawn9 = whitePawn10 = whitePawn11 = whitePawn12 = whitePawn13 = whitePawn14 = whitePawn15 = new ImageIcon(
                Objects.requireNonNull(getClass().getResource("/Images/white_pawn.png")));
        blackPawn1 = blackPawn2 = blackPawn3 = blackPawn4 = blackPawn5 = blackPawn6 = blackPawn7 = blackPawn8 = blackPawn9 = blackPawn10 = blackPawn11 = blackPawn12 = blackPawn13 = blackPawn14 = blackPawn15 = new ImageIcon(
                Objects.requireNonNull(getClass().getResource("/Images/black_pawn.png")));

        Image image1 = blackRook1.getImage();
        Image scaledImage1 = image1.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        blackRook1 = new ImageIcon(scaledImage1);

        Image image2 = blackRook2.getImage();
        Image scaledImage2 = image2.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        blackRook2 = new ImageIcon(scaledImage2);

        Image image33 = blackRook3.getImage();
        Image scaledImage33 = image33.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        blackRook3 = new ImageIcon(scaledImage33);

        Image image34 = blackRook4.getImage();
        Image scaledImage34 = image34.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        blackRook4 = new ImageIcon(scaledImage34);

        Image image3 = blackKnight1.getImage();
        Image scaledImage3 = image3.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        blackKnight1 = new ImageIcon(scaledImage3);

        Image image4 = blackKnight2.getImage();
        Image scaledImage4 = image4.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        blackKnight2 = new ImageIcon(scaledImage4);

        Image image35 = blackKnight3.getImage();
        Image scaledImage35 = image35.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        blackKnight3 = new ImageIcon(scaledImage35);

        Image image36 = blackKnight4.getImage();
        Image scaledImage36 = image36.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        blackKnight4 = new ImageIcon(scaledImage36);

        Image image5 = blackBishop1.getImage();
        Image scaledImage5 = image5.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        blackBishop1 = new ImageIcon(scaledImage5);

        Image image6 = blackBishop2.getImage();
        Image scaledImage6 = image6.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        blackBishop2 = new ImageIcon(scaledImage6);

        Image image37 = blackBishop3.getImage();
        Image scaledImage37 = image37.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        blackBishop3 = new ImageIcon(scaledImage37);

        Image image38 = blackBishop4.getImage();
        Image scaledImage38 = image38.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        blackBishop4 = new ImageIcon(scaledImage38);

        Image image7 = blackQueen1.getImage();
        Image scaledImage7 = image7.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        blackQueen1 = new ImageIcon(scaledImage7);

        Image image39 = blackQueen2.getImage();
        Image scaledImage39 = image39.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        blackQueen2 = new ImageIcon(scaledImage39);

        Image image8 = blackKing.getImage();
        Image scaledImage8 = image8.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        blackKing = new ImageIcon(scaledImage8);

        Image image9 = blackPawn1.getImage();
        Image scaledImage9 = image9.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        blackPawn1 = new ImageIcon(scaledImage9);

        Image image10 = blackPawn2.getImage();
        Image scaledImage10 = image10.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        blackPawn2 = new ImageIcon(scaledImage10);

        Image image11 = blackPawn3.getImage();
        Image scaledImage11 = image11.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        blackPawn3 = new ImageIcon(scaledImage11);

        Image image12 = blackPawn4.getImage();
        Image scaledImage12 = image12.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        blackPawn4 = new ImageIcon(scaledImage12);

        Image image13 = blackPawn5.getImage();
        Image scaledImage13 = image13.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        blackPawn5 = new ImageIcon(scaledImage13);

        Image image14 = blackPawn6.getImage();
        Image scaledImage14 = image14.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        blackPawn6 = new ImageIcon(scaledImage14);

        Image image15 = blackPawn7.getImage();
        Image scaledImage15 = image15.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        blackPawn7 = new ImageIcon(scaledImage15);

        Image image16 = blackPawn8.getImage();
        Image scaledImage16 = image16.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        blackPawn8 = new ImageIcon(scaledImage16);

        Image image40 = blackPawn9.getImage();
        Image scaledImage40 = image40.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        blackPawn9 = new ImageIcon(scaledImage40);

        Image image41 = blackPawn10.getImage();
        Image scaledImage41 = image41.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        blackPawn10 = new ImageIcon(scaledImage41);

        Image image42 = blackPawn11.getImage();
        Image scaledImage42 = image42.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        blackPawn11 = new ImageIcon(scaledImage42);

        Image image43 = blackPawn12.getImage();
        Image scaledImage43 = image43.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        blackPawn12 = new ImageIcon(scaledImage43);

        Image image44 = blackPawn13.getImage();
        Image scaledImage44 = image44.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        blackPawn13 = new ImageIcon(scaledImage44);

        Image image45 = blackPawn14.getImage();
        Image scaledImage45 = image45.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        blackPawn14 = new ImageIcon(scaledImage45);

        Image image46 = blackPawn15.getImage();
        Image scaledImage46 = image46.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        blackPawn15 = new ImageIcon(scaledImage46);


        Image image17 = whiteRook1.getImage();
        Image scaledImage17 = image17.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        whiteRook1 = new ImageIcon(scaledImage17);

        Image image18 = whiteRook2.getImage();
        Image scaledImage18 = image18.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        whiteRook2 = new ImageIcon(scaledImage18);

        Image image48 = whiteRook3.getImage();
        Image scaledImage48 = image48.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        whiteRook3 = new ImageIcon(scaledImage48);

        Image image49 = whiteRook4.getImage();
        Image scaledImage49 = image49.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        whiteRook4 = new ImageIcon(scaledImage49);

        Image image19 = whiteKnight1.getImage();
        Image scaledImage19 = image19.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        whiteKnight1 = new ImageIcon(scaledImage19);

        Image image20 = whiteKnight2.getImage();
        Image scaledImage20 = image20.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        whiteKnight2 = new ImageIcon(scaledImage20);

        Image image50 = whiteKnight3.getImage();
        Image scaledImage50 = image50.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        whiteKnight3 = new ImageIcon(scaledImage50);

        Image image51 = whiteKnight4.getImage();
        Image scaledImage51 = image51.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        whiteKnight4 = new ImageIcon(scaledImage51);

        Image image21 = whiteBishop1.getImage();
        Image scaledImage21 = image21.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        whiteBishop1 = new ImageIcon(scaledImage21);

        Image image22 = whiteBishop2.getImage();
        Image scaledImage22 = image22.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        whiteBishop2 = new ImageIcon(scaledImage22);

        Image image52 = whiteBishop3.getImage();
        Image scaledImage52 = image52.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        whiteBishop3 = new ImageIcon(scaledImage52);

        Image image53 = whiteBishop4.getImage();
        Image scaledImage53 = image53.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        whiteBishop4 = new ImageIcon(scaledImage53);

        Image image23 = whiteQueen1.getImage();
        Image scaledImage23 = image23.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        whiteQueen1 = new ImageIcon(scaledImage23);

        Image image54 = whiteQueen2.getImage();
        Image scaledImage54 = image54.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        whiteQueen2 = new ImageIcon(scaledImage54);

        Image image24 = whiteKing.getImage();
        Image scaledImage24 = image24.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Adjust the size as needed
        whiteKing = new ImageIcon(scaledImage24);

        Image image25 = whitePawn1.getImage();
        Image scaledImage25 = image25.getScaledInstance(26, 38, Image.SCALE_SMOOTH); // Adjust the size as needed
        whitePawn1 = new ImageIcon(scaledImage25);

        Image image26 = whitePawn2.getImage();
        Image scaledImage26 = image26.getScaledInstance(26, 38, Image.SCALE_SMOOTH); // Adjust the size as needed
        whitePawn2 = new ImageIcon(scaledImage26);

        Image image27 = whitePawn3.getImage();
        Image scaledImage27 = image27.getScaledInstance(26, 38, Image.SCALE_SMOOTH); // Adjust the size as needed
        whitePawn3 = new ImageIcon(scaledImage27);

        Image image28 = whitePawn4.getImage();
        Image scaledImage28 = image28.getScaledInstance(26, 38, Image.SCALE_SMOOTH); // Adjust the size as needed
        whitePawn4 = new ImageIcon(scaledImage28);

        Image image29 = whitePawn5.getImage();
        Image scaledImage29 = image29.getScaledInstance(26, 38, Image.SCALE_SMOOTH); // Adjust the size as needed
        whitePawn5 = new ImageIcon(scaledImage29);

        Image image30 = whitePawn6.getImage();
        Image scaledImage30 = image30.getScaledInstance(26, 38, Image.SCALE_SMOOTH); // Adjust the size as needed
        whitePawn6 = new ImageIcon(scaledImage30);

        Image image31 = whitePawn7.getImage();
        Image scaledImage31 = image31.getScaledInstance(26, 38, Image.SCALE_SMOOTH); // Adjust the size as needed
        whitePawn7 = new ImageIcon(scaledImage31);

        Image image32 = whitePawn8.getImage();
        Image scaledImage32 = image32.getScaledInstance(26, 38, Image.SCALE_SMOOTH); // Adjust the size as needed
        whitePawn8 = new ImageIcon(scaledImage32);

        Image image55 = whitePawn9.getImage();
        Image scaledImage55 = image55.getScaledInstance(26, 38, Image.SCALE_SMOOTH); // Adjust the size as needed
        whitePawn9 = new ImageIcon(scaledImage55);

        Image image56 = whitePawn10.getImage();
        Image scaledImage56 = image56.getScaledInstance(26, 38, Image.SCALE_SMOOTH); // Adjust the size as needed
        whitePawn10 = new ImageIcon(scaledImage56);

        Image image57 = whitePawn11.getImage();
        Image scaledImage57 = image57.getScaledInstance(26, 38, Image.SCALE_SMOOTH); // Adjust the size as needed
        whitePawn11 = new ImageIcon(scaledImage57);

        Image image58 = whitePawn12.getImage();
        Image scaledImage58 = image58.getScaledInstance(26, 38, Image.SCALE_SMOOTH); // Adjust the size as needed
        whitePawn12 = new ImageIcon(scaledImage58);

        Image image59 = whitePawn13.getImage();
        Image scaledImage59 = image59.getScaledInstance(26, 38, Image.SCALE_SMOOTH); // Adjust the size as needed
        whitePawn13 = new ImageIcon(scaledImage59);

        Image image60 = whitePawn14.getImage();
        Image scaledImage60 = image60.getScaledInstance(26, 38, Image.SCALE_SMOOTH); // Adjust the size as needed
        whitePawn14 = new ImageIcon(scaledImage60);

        Image image61 = whitePawn15.getImage();
        Image scaledImage61 = image61.getScaledInstance(26, 38, Image.SCALE_SMOOTH); // Adjust the size as needed
        whitePawn15 = new ImageIcon(scaledImage61);


        for (int i = 0; i < board2.length; i++) {
            for (int j = 0; j < board2.length; j++) {
                board2[i][j] = new JLabel();
                board2[i][j].setHorizontalAlignment(JLabel.CENTER);
                board2[i][j].setOpaque(true); // Ensure the background color is visible
                board2[i][j].addMouseListener(this);

                if ((i + j) % 2 != 0) {
                    board2[i][j].setBackground(darkSquare); // Dark square color
                } else {
                    board2[i][j].setBackground(lightSquare); // Light square color
                }

                frame.add(board2[i][j]);
            }
        }

        // Set frame properties
        frame.setSize(1000, 750);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initialiseBoard();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main2::new);
    }

    public static void playerChoice() {
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
            board2[0][0].setIcon(blackRook1);
            board2[0][14].setIcon(blackRook2);
            board2[0][1].setIcon(blackRook3);
            board2[0][13].setIcon(blackRook4);
            board2[0][2].setIcon(blackKnight1);
            board2[0][3].setIcon(blackKnight2);
            board2[0][11].setIcon(blackKnight3);
            board2[0][12].setIcon(blackKnight4);
            board2[0][4].setIcon(blackBishop1);
            board2[0][5].setIcon(blackBishop2);
            board2[0][9].setIcon(blackBishop3);
            board2[0][10].setIcon(blackBishop4);
            board2[0][6].setIcon(blackQueen1);
            board2[0][8].setIcon(blackQueen2);
            board2[0][7].setIcon(blackKing);
            board2[1][0].setIcon(blackPawn1);
            board2[1][1].setIcon(blackPawn2);
            board2[1][2].setIcon(blackPawn3);
            board2[1][3].setIcon(blackPawn4);
            board2[1][4].setIcon(blackPawn5);
            board2[1][5].setIcon(blackPawn6);
            board2[1][6].setIcon(blackPawn7);
            board2[1][7].setIcon(blackPawn8);
            board2[1][8].setIcon(blackPawn9);
            board2[1][9].setIcon(blackPawn10);
            board2[1][10].setIcon(blackPawn11);
            board2[1][11].setIcon(blackPawn12);
            board2[1][12].setIcon(blackPawn13);
            board2[1][13].setIcon(blackPawn14);
            board2[1][14].setIcon(blackPawn15);
            board2[14][0].setIcon(whiteRook1);
            board2[14][14].setIcon(whiteRook2);
            board2[14][1].setIcon(whiteRook3);
            board2[14][13].setIcon(whiteRook4);
            board2[14][2].setIcon(whiteKnight1);
            board2[14][3].setIcon(whiteKnight2);
            board2[14][11].setIcon(whiteKnight3);
            board2[14][12].setIcon(whiteKnight4);
            board2[14][4].setIcon(whiteBishop1);
            board2[14][5].setIcon(whiteBishop2);
            board2[14][9].setIcon(whiteBishop3);
            board2[14][10].setIcon(whiteBishop4);
            board2[14][6].setIcon(whiteQueen1);
            board2[14][8].setIcon(whiteQueen2);
            board2[14][7].setIcon(whiteKing);
            board2[13][0].setIcon(whitePawn1);
            board2[13][1].setIcon(whitePawn2);
            board2[13][2].setIcon(whitePawn3);
            board2[13][3].setIcon(whitePawn4);
            board2[13][4].setIcon(whitePawn5);
            board2[13][5].setIcon(whitePawn6);
            board2[13][6].setIcon(whitePawn7);
            board2[13][7].setIcon(whitePawn8);
            board2[13][8].setIcon(whitePawn8);
            board2[13][9].setIcon(whitePawn8);
            board2[13][10].setIcon(whitePawn8);
            board2[13][11].setIcon(whitePawn8);
            board2[13][12].setIcon(whitePawn8);
            board2[13][13].setIcon(whitePawn8);
            board2[13][14].setIcon(whitePawn8);
        }

        // Perform Modifications below
    }

    public static void clearBoard() {
        JFrame clearBoardWindow = new JFrame("Clear Board");
        clearBoardWindow.setSize(400, 85);
        clearBoardWindow.setLocationRelativeTo(null); // Center the window

        JPanel clearBoardPanel = new JPanel();
        clearBoardPanel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Want to reset the board?");
        clearBoardPanel.add(label);

        JButton yes = new JButton("Yes");
        yes.addActionListener(e -> {
            for (int i = 0; i < board2.length; i++) {
                for (int j = 0; j < board2.length; j++) {
                    board2[i][j].setBackground((i + j) % 2 != 0 ? darkSquare : lightSquare);
                    board2[i][j].setIcon(null);
                    board2[i][j].setBorder(null);
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
        for (int i = 0; i < board2.length; i++) {
            for (int j = 0; j < board2.length; j++) {
                if (board2[i][j] != clickedCell) {
                    board2[i][j].setBorder(null);
                    board2[i][j].setBackground((i + j) % 2 != 0 ? darkSquare : lightSquare);
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
                if (player.equals(getColor((ImageIcon) clickedCell.getIcon()))) {
                    clickedStack.push(clickedCell);
                }
            } else {
                clickedStack.push(clickedCell);
            }
            // Highlight the selected piece
            if ((clickedCell.getBorder() == null && clickedCell.getIcon() != null
                    && player.equals(getColor((ImageIcon) clickedCell.getIcon()))
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

            String pieceColor = getColor((ImageIcon) clickedCell.getIcon());
            String pieceType = getType((ImageIcon) clickedCell.getIcon());
            if (pieceType.equals("pawn")) {
                Pawn2 pawn = new Pawn2(row, col, pieceColor);
                pawn.highlightCells(row, col);
            }
            if (pieceType.equals("queen")) {
                Queen2 queen = new Queen2(row, col, pieceColor);
                queen.highlightCells(row, col);
            }
            if (pieceType.equals("knight")) {
                Knight2 knight = new Knight2(row, col, pieceColor);
                knight.highlightCells(row, col);
            }
            if (pieceType.equals("rook")) {
                Rook2 rook = new Rook2(row, col, pieceColor);
                rook.highlightCells(row, col);
            }
            if (pieceType.equals("bishop")) {
                Bishop2 bishop = new Bishop2(row, col, pieceColor);
                bishop.highlightCells(row, col);
            }
            if (pieceType.equals("king")) {
                King2 king = new King2(row, col, pieceColor);
                king.highlightCells(row, col);
            }
            if (clickedCell.getBorder() == null && clickedCell.getIcon() != null) {
                for (int i = 0; i < board2.length; i++) {
                    for (int j = 0; j < board2.length; j++) {
                        board2[i][j].setBorder(null);
                        if ((i + j) % 2 != 0) {
                            board2[i][j].setBackground(darkSquare); // Dark square color
                        } else {
                            board2[i][j].setBackground(lightSquare); // Light square color
                        }
                    }
                }
            }
            if (!isCreatorModeOn) {
                if (isCheck("white", board2)) {
                    for (JLabel[] jLabels : board2) {
                        for (int j = 0; j < board2.length; j++) {
                            if (getColor((ImageIcon) jLabels[j].getIcon()).equals("white")
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
                if (isCheck("black", board2)) {
                    for (JLabel[] jLabels : board2) {
                        for (int j = 0; j < board2.length; j++) {
                            if (getColor((ImageIcon) jLabels[j].getIcon()).equals("black")
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

        JButton whiteQueenButton = new JButton(whiteQueen1);
        whiteQueenButton.addActionListener(e -> addPiece(row, col, whiteQueen1, creatorModeWindow));
        creatorModePanel.add(whiteQueenButton);

        JButton whiteRookButton = new JButton(whiteRook2);
        whiteRookButton.addActionListener(e -> addPiece(row, col, whiteRook1, creatorModeWindow));
        creatorModePanel.add(whiteRookButton);

        JButton whiteBishopButton = new JButton(whiteBishop1);
        whiteBishopButton.addActionListener(e -> addPiece(row, col, whiteBishop1, creatorModeWindow));
        creatorModePanel.add(whiteBishopButton);

        JButton whiteKnightButton = new JButton(whiteKnight1);
        whiteKnightButton.addActionListener(e -> addPiece(row, col, whiteKnight1, creatorModeWindow));
        creatorModePanel.add(whiteKnightButton);

        JButton whiteKingButton = new JButton(whiteKing);
        whiteKingButton.addActionListener(e -> addPiece(row, col, whiteKing, creatorModeWindow));
        creatorModePanel.add(whiteKingButton);

        JButton whitePawnButton = new JButton(whitePawn1);
        whitePawnButton.addActionListener(e -> addPiece(row, col, whitePawn1, creatorModeWindow));
        creatorModePanel.add(whitePawnButton);

        JButton blackQueenButton = new JButton(blackQueen1);
        blackQueenButton.addActionListener(e -> addPiece(row, col, blackQueen1, creatorModeWindow));
        creatorModePanel.add(blackQueenButton);

        JButton blackRookButton = new JButton(blackRook2);
        blackRookButton.addActionListener(e -> addPiece(row, col, blackRook2, creatorModeWindow));
        creatorModePanel.add(blackRookButton);

        JButton blackBishopButton = new JButton(blackBishop1);
        blackBishopButton.addActionListener(e -> addPiece(row, col, blackBishop1, creatorModeWindow));
        creatorModePanel.add(blackBishopButton);

        JButton blackKnightButton = new JButton(blackKnight1);
        blackKnightButton.addActionListener(e -> addPiece(row, col, blackKnight1, creatorModeWindow));
        creatorModePanel.add(blackKnightButton);

        JButton blackKingButton = new JButton(blackKing);
        blackKingButton.addActionListener(e -> addPiece(row, col, blackKing, creatorModeWindow));
        creatorModePanel.add(blackKingButton);

        JButton blackPawnButton = new JButton(blackPawn1);
        blackPawnButton.addActionListener(e -> addPiece(row, col, blackPawn1, creatorModeWindow));
        creatorModePanel.add(blackPawnButton);

        JButton removeButton = new JButton("Remove Piece");
        removeButton.addActionListener(e -> {
            board2[row][col].setIcon(null);
            creatorModeWindow.dispose();
        });
        creatorModePanel.add(removeButton);

        creatorModeWindow.add(creatorModePanel);
        creatorModeWindow.setVisible(true);
    }

    public static void addPiece(int row, int col, ImageIcon addedPiece, JFrame creatorModeWindow) {
        if (getType(addedPiece).equals("king")) {
            if (getColor(addedPiece).equals("white")) {
                for (int i = 0; i < board2.length; i++) {
                    for (int j = 0; j < board2.length; j++) {
                        if (getType((ImageIcon) board2[i][j].getIcon()).equals("king")
                                && getColor((ImageIcon) board2[i][j].getIcon()).equals("white")) {
                            JOptionPane.showMessageDialog(null, "white King already exists");
                            return;
                        }
                    }
                }
                if (!new King2(row, col, "white").isSafe(row, col)) {
                    JOptionPane.showMessageDialog(null, "Invalid position for king");
                    return;
                }
            } else if (getColor(addedPiece).equals("black")) {
                for (int i = 0; i < board2.length; i++) {
                    for (int j = 0; j < board2.length; j++) {
                        if (getType((ImageIcon) board2[i][j].getIcon()).equals("king")
                                && getColor((ImageIcon) board2[i][j].getIcon()).equals("black")) {
                            JOptionPane.showMessageDialog(null, "black King already exists");
                            return;
                        }
                    }
                }
                if (!new King2(row, col, "black").isSafe(row, col)) {
                    JOptionPane.showMessageDialog(null, "Invalid position for king");
                    return;
                }
            }

        }
        board2[row][col].setIcon(addedPiece);
        creatorModeWindow.dispose();
    }

    public static void movePiece(JLabel source, JLabel destination) {
        if (source != destination
                && source.getIcon() != null
                && getColor((ImageIcon) source.getIcon()).equals(player)
                && !getColor((ImageIcon) source.getIcon()).equals(getColor((ImageIcon) destination.getIcon()))
                && !(getColor((ImageIcon) source.getIcon()).equals("white")
                && getType((ImageIcon) destination.getIcon()).equals("king")
                && getColor((ImageIcon) destination.getIcon()).equals("black"))
                && !(getColor((ImageIcon) source.getIcon()).equals("black")
                && getType((ImageIcon) destination.getIcon()).equals("king")
                && getColor((ImageIcon) destination.getIcon()).equals("white"))
                && movableCells(source).contains(destination)) {
            if (source.getIcon() == whitePawn1 || source.getIcon() == blackPawn1 || destination.getIcon() != null) {
                uselessHalfMoves = 0;
            } else {
                uselessHalfMoves++;
            }
            if (blackEnpasante1 && source.getIcon() != whitePawn1 && destination != board2[2][0]) {
                blackEnpasante1 = false;
            } else if (blackEnpasante2 && source.getIcon() != whitePawn1 && destination != board2[2][1]) {
                blackEnpasante2 = false;
            } else if (blackEnpasante3 && source.getIcon() != whitePawn1 && destination != board2[2][2]) {
                blackEnpasante3 = false;
            } else if (blackEnpasante4 && source.getIcon() != whitePawn1 && destination != board2[2][3]) {
                blackEnpasante4 = false;
            } else if (blackEnpasante5 && source.getIcon() != whitePawn1 && destination != board2[2][4]) {
                blackEnpasante5 = false;
            } else if (blackEnpasante6 && source.getIcon() != whitePawn1 && destination != board2[2][5]) {
                blackEnpasante6 = false;
            } else if (blackEnpasante7 && source.getIcon() != whitePawn1 && destination != board2[2][6]) {
                blackEnpasante7 = false;
            } else if (blackEnpasante8 && source.getIcon() != whitePawn1 && destination != board2[2][7]) {
                blackEnpasante8 = false;
            } else if (blackEnpasante9 && source.getIcon() != whitePawn1 && destination != board2[2][8]) {
                blackEnpasante9 = false;
            } else if (blackEnpasante10 && source.getIcon() != whitePawn1 && destination != board2[2][9]) {
                blackEnpasante10 = false;
            } else if (blackEnpasante11 && source.getIcon() != whitePawn1 && destination != board2[2][10]) {
                blackEnpasante11 = false;
            } else if (blackEnpasante12 && source.getIcon() != whitePawn1 && destination != board2[2][11]) {
                blackEnpasante12 = false;
            } else if (blackEnpasante13 && source.getIcon() != whitePawn1 && destination != board2[2][12]) {
                blackEnpasante13 = false;
            } else if (blackEnpasante14 && source.getIcon() != whitePawn1 && destination != board2[2][13]) {
                blackEnpasante14 = false;
            } else if (blackEnpasante15 && source.getIcon() != whitePawn1 && destination != board2[2][14]) {
                blackEnpasante15 = false;
            }


            if (whiteEnpasante1 && source.getIcon() != blackPawn1 && destination != board2[5][0]) {
                whiteEnpasante1 = false;
            } else if (whiteEnpasante2 && source.getIcon() != blackPawn1 && destination != board2[5][1]) {
                whiteEnpasante2 = false;
            } else if (whiteEnpasante3 && source.getIcon() != blackPawn1 && destination != board2[5][2]) {
                whiteEnpasante3 = false;
            } else if (whiteEnpasante4 && source.getIcon() != blackPawn1 && destination != board2[5][3]) {
                whiteEnpasante4 = false;
            } else if (whiteEnpasante5 && source.getIcon() != blackPawn1 && destination != board2[5][4]) {
                whiteEnpasante5 = false;
            } else if (whiteEnpasante6 && source.getIcon() != blackPawn1 && destination != board2[5][5]) {
                whiteEnpasante6 = false;
            } else if (whiteEnpasante7 && source.getIcon() != blackPawn1 && destination != board2[5][6]) {
                whiteEnpasante7 = false;
            } else if (whiteEnpasante8 && source.getIcon() != blackPawn1 && destination != board2[5][7]) {
                whiteEnpasante8 = false;
            } else if (whiteEnpasante9 && source.getIcon() != blackPawn1 && destination != board2[5][8]) {
                whiteEnpasante9 = false;
            } else if (whiteEnpasante10 && source.getIcon() != blackPawn1 && destination != board2[5][9]) {
                whiteEnpasante10 = false;
            } else if (whiteEnpasante11 && source.getIcon() != blackPawn1 && destination != board2[5][10]) {
                whiteEnpasante11 = false;
            } else if (whiteEnpasante12 && source.getIcon() != blackPawn1 && destination != board2[5][11]) {
                whiteEnpasante12 = false;
            } else if (whiteEnpasante13 && source.getIcon() != blackPawn1 && destination != board2[5][12]) {
                whiteEnpasante13 = false;
            } else if (whiteEnpasante14 && source.getIcon() != blackPawn1 && destination != board2[5][13]) {
                whiteEnpasante14 = false;
            } else if (whiteEnpasante15 && source.getIcon() != blackPawn1 && destination != board2[5][14]) {
                whiteEnpasante15 = false;
            }
            if (source.getIcon() == blackPawn1) {
                if (source == board2[1][0] && destination == board2[3][0]) {
                    blackEnpasante1 = true;
                } else if (source == board2[1][1] && destination == board2[3][1]) {
                    blackEnpasante2 = true;
                } else if (source == board2[1][2] && destination == board2[3][2]) {
                    blackEnpasante3 = true;
                } else if (source == board2[1][3] && destination == board2[3][3]) {
                    blackEnpasante4 = true;
                } else if (source == board2[1][4] && destination == board2[3][4]) {
                    blackEnpasante5 = true;
                } else if (source == board2[1][5] && destination == board2[3][5]) {
                    blackEnpasante6 = true;
                } else if (source == board2[1][6] && destination == board2[3][6]) {
                    blackEnpasante7 = true;
                } else if (source == board2[1][7] && destination == board2[3][7]) {
                    blackEnpasante8 = true;
                } else if (source == board2[1][8] && destination == board2[3][8]) {
                    blackEnpasante9 = true;
                } else if (source == board2[1][9] && destination == board2[3][9]) {
                    blackEnpasante10 = true;
                } else if (source == board2[1][10] && destination == board2[3][10]) {
                    blackEnpasante11 = true;
                } else if (source == board2[1][11] && destination == board2[3][11]) {
                    blackEnpasante12 = true;
                } else if (source == board2[1][12] && destination == board2[3][12]) {
                    blackEnpasante13 = true;
                } else if (source == board2[1][13] && destination == board2[3][13]) {
                    blackEnpasante14 = true;
                } else if (source == board2[1][14] && destination == board2[3][14]) {
                    blackEnpasante15 = true;
                }
            } else if (source.getIcon() == whitePawn1) {
                if (source == board2[13][0] && destination == board2[11][0]) {
                    whiteEnpasante1 = true;
                } else if (source == board2[13][1] && destination == board2[11][1]) {
                    whiteEnpasante2 = true;
                } else if (source == board2[13][2] && destination == board2[11][2]) {
                    whiteEnpasante3 = true;
                } else if (source == board2[13][3] && destination == board2[11][3]) {
                    whiteEnpasante4 = true;
                } else if (source == board2[13][4] && destination == board2[11][4]) {
                    whiteEnpasante5 = true;
                } else if (source == board2[13][5] && destination == board2[11][5]) {
                    whiteEnpasante6 = true;
                } else if (source == board2[13][6] && destination == board2[11][6]) {
                    whiteEnpasante7 = true;
                } else if (source == board2[13][7] && destination == board2[11][7]) {
                    whiteEnpasante8 = true;
                } else if (source == board2[13][8] && destination == board2[11][8]) {
                    whiteEnpasante9 = true;
                } else if (source == board2[13][9] && destination == board2[11][9]) {
                    whiteEnpasante10 = true;
                } else if (source == board2[13][10] && destination == board2[11][10]) {
                    whiteEnpasante11 = true;
                } else if (source == board2[13][11] && destination == board2[11][11]) {
                    whiteEnpasante12 = true;
                } else if (source == board2[13][12] && destination == board2[11][12]) {
                    whiteEnpasante13 = true;
                } else if (source == board2[13][13] && destination == board2[11][13]) {
                    whiteEnpasante14 = true;
                } else if (source == board2[13][14] && destination == board2[11][14]) {
                    whiteEnpasante15 = true;
                }
            }

            // movements
            if (blackEnpasante1 && source.getIcon() == whitePawn1 && destination == board2[2][0]) {
                blackEnpasante1 = false;
                destination.setIcon(source.getIcon());
                source.setIcon(null);
                board2[3][0].setIcon(null);
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (blackEnpasante2 && source.getIcon() == whitePawn1 && destination == board2[2][1]) {
                destination.setIcon(source.getIcon());
                source.setIcon(null);
                board2[3][1].setIcon(null);
                blackEnpasante2 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (blackEnpasante3 && source.getIcon() == whitePawn1 && destination == board2[2][2]) {
                destination.setIcon(source.getIcon());
                source.setIcon(null);
                board2[3][2].setIcon(null);
                blackEnpasante3 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (blackEnpasante4 && source.getIcon() == whitePawn1 && destination == board2[2][3]) {
                destination.setIcon(source.getIcon());
                source.setIcon(null);
                board2[3][3].setIcon(null);
                blackEnpasante4 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (blackEnpasante5 && source.getIcon() == whitePawn1 && destination == board2[2][4]) {
                destination.setIcon(source.getIcon());
                source.setIcon(null);
                board2[3][4].setIcon(null);
                blackEnpasante5 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (blackEnpasante6 && source.getIcon() == whitePawn1 && destination == board2[2][5]) {
                destination.setIcon(source.getIcon());
                source.setIcon(null);
                board2[3][5].setIcon(null);
                blackEnpasante6 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (blackEnpasante7 && source.getIcon() == whitePawn1 && destination == board2[2][6]) {
                destination.setIcon(source.getIcon());
                source.setIcon(null);
                board2[3][6].setIcon(null);
                blackEnpasante7 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (blackEnpasante8 && source.getIcon() == whitePawn1 && destination == board2[2][7]) {
                destination.setIcon(source.getIcon());
                source.setIcon(null);
                board2[3][7].setIcon(null);
                blackEnpasante8 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (blackEnpasante9 && source.getIcon() == whitePawn1 && destination == board2[2][8]) {
                destination.setIcon(source.getIcon());
                source.setIcon(null);
                board2[3][8].setIcon(null);
                blackEnpasante9 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (blackEnpasante10 && source.getIcon() == whitePawn1 && destination == board2[2][9]) {
                destination.setIcon(source.getIcon());
                source.setIcon(null);
                board2[3][9].setIcon(null);
                blackEnpasante10 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (blackEnpasante11 && source.getIcon() == whitePawn1 && destination == board2[2][10]) {
                destination.setIcon(source.getIcon());
                source.setIcon(null);
                board2[3][10].setIcon(null);
                blackEnpasante11 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (blackEnpasante12 && source.getIcon() == whitePawn1 && destination == board2[2][11]) {
                destination.setIcon(source.getIcon());
                source.setIcon(null);
                board2[3][11].setIcon(null);
                blackEnpasante12 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (blackEnpasante13 && source.getIcon() == whitePawn1 && destination == board2[2][12]) {
                destination.setIcon(source.getIcon());
                source.setIcon(null);
                board2[3][12].setIcon(null);
                blackEnpasante13 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (blackEnpasante14 && source.getIcon() == whitePawn1 && destination == board2[2][13]) {
                destination.setIcon(source.getIcon());
                source.setIcon(null);
                board2[3][13].setIcon(null);
                blackEnpasante14 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (blackEnpasante15 && source.getIcon() == whitePawn1 && destination == board2[2][14]) {
                destination.setIcon(source.getIcon());
                source.setIcon(null);
                board2[3][14].setIcon(null);
                blackEnpasante15 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            }

            if (whiteEnpasante1 && source.getIcon() == blackPawn1 && destination == board2[12][0]) {
                destination.setIcon(source.getIcon());
                source.setIcon(null);
                board2[11][0].setIcon(null);
                whiteEnpasante1 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (whiteEnpasante2 && source.getIcon() == blackPawn1 && destination == board2[12][1]) {
                destination.setIcon(source.getIcon());
                source.setIcon(null);
                board2[11][1].setIcon(null);
                whiteEnpasante2 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (whiteEnpasante3 && source.getIcon() == blackPawn1 && destination == board2[12][2]) {
                destination.setIcon(source.getIcon());
                source.setIcon(null);
                board2[11][2].setIcon(null);
                whiteEnpasante3 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (whiteEnpasante4 && source.getIcon() == blackPawn1 && destination == board2[12][3]) {
                destination.setIcon(source.getIcon());
                source.setIcon(null);
                board2[11][3].setIcon(null);
                whiteEnpasante4 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (whiteEnpasante5 && source.getIcon() == blackPawn1 && destination == board2[12][4]) {
                destination.setIcon(source.getIcon());
                source.setIcon(null);
                board2[11][4].setIcon(null);
                whiteEnpasante5 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (whiteEnpasante6 && source.getIcon() == blackPawn1 && destination == board2[12][5]) {
                destination.setIcon(source.getIcon());
                source.setIcon(null);
                board2[11][5].setIcon(null);
                whiteEnpasante6 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (whiteEnpasante7 && source.getIcon() == blackPawn1 && destination == board2[12][6]) {
                destination.setIcon(source.getIcon());
                source.setIcon(null);
                board2[11][6].setIcon(null);
                whiteEnpasante7 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (whiteEnpasante8 && source.getIcon() == blackPawn1 && destination == board2[12][7]) {
                destination.setIcon(source.getIcon());
                source.setIcon(null);
                board2[11][7].setIcon(null);
                whiteEnpasante8 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (whiteEnpasante9 && source.getIcon() == blackPawn1 && destination == board2[12][8]) {
                destination.setIcon(source.getIcon());
                source.setIcon(null);
                board2[11][8].setIcon(null);
                whiteEnpasante9 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (whiteEnpasante10 && source.getIcon() == blackPawn1 && destination == board2[12][9]) {
                destination.setIcon(source.getIcon());
                source.setIcon(null);
                board2[11][9].setIcon(null);
                whiteEnpasante10 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (whiteEnpasante11 && source.getIcon() == blackPawn1 && destination == board2[12][10]) {
                destination.setIcon(source.getIcon());
                source.setIcon(null);
                board2[11][10].setIcon(null);
                whiteEnpasante11 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (whiteEnpasante12 && source.getIcon() == blackPawn1 && destination == board2[12][11]) {
                destination.setIcon(source.getIcon());
                source.setIcon(null);
                board2[11][11].setIcon(null);
                whiteEnpasante12 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (whiteEnpasante13 && source.getIcon() == blackPawn1 && destination == board2[12][12]) {
                destination.setIcon(source.getIcon());
                source.setIcon(null);
                board2[11][12].setIcon(null);
                whiteEnpasante13 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (whiteEnpasante14 && source.getIcon() == blackPawn1 && destination == board2[12][13]) {
                destination.setIcon(source.getIcon());
                source.setIcon(null);
                board2[11][13].setIcon(null);
                whiteEnpasante14 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            } else if (whiteEnpasante15 && source.getIcon() == blackPawn1 && destination == board2[12][14]) {
                destination.setIcon(source.getIcon());
                source.setIcon(null);
                board2[11][14].setIcon(null);
                whiteEnpasante15 = false;
                player = player.equals("white") ? "black" : "white";
                destination.setBorder(null);
                return;
            }
            if (source.getIcon() == whiteKing) {
                whiteKingMoved = true;
            } else if (source.getIcon() == whiteRook1 && board2[14][1] == source) {
                whiteRook1Moved = true;
            } else if (source.getIcon() == whiteRook1 && board2[14][13] == source) {
                whiteRook2Moved = true;
            } else if (source.getIcon() == blackKing) {
                blackKingMoved = true;
            } else if (source.getIcon() == blackRook1 && board2[0][1] == source) {
                blackRook1Moved = true;
            } else if (source.getIcon() == blackRook1 && board2[0][13] == source) {
                blackRook2Moved = true;
            }
            if (source == board2[14][7] && source.getIcon() == whiteKing && destination == board2[14][2]) {
                destination.setIcon(whiteKing);
                source.setIcon(null);
                board2[14][1].setIcon(null);
                board2[14][3].setIcon(whiteRook2);
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
            if (source == board2[14][7] && source.getIcon() == whiteKing && destination == board2[14][12]) {
                destination.setIcon(whiteKing);
                source.setIcon(null);
                board2[14][13].setIcon(null);
                board2[14][11].setIcon(whiteRook2);
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
            if (source == board2[0][7] && source.getIcon() == blackKing && destination == board2[0][12]) {
                destination.setIcon(blackKing);
                source.setIcon(null);
                board2[0][13].setIcon(null);
                board2[0][11].setIcon(blackRook2);
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
            if (source == board2[0][7] && source.getIcon() == blackKing && destination == board2[0][2]) {
                destination.setIcon(blackKing);
                source.setIcon(null);
                board2[0][1].setIcon(null);
                board2[0][3].setIcon(blackRook1);
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
            destination.setIcon(source.getIcon());
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
            for (int j = 0; j < board2.length; j++) {
                if (getColor((ImageIcon) board2[0][j].getIcon()).equals("white")
                        && getType((ImageIcon) board2[0][j].getIcon()).equals("pawn")) {
                    x = j;
                    break;
                }
            }
            int col = x;
            JFrame promotionWindow = new JFrame("Pawn Promotion");
            promotionWindow.setSize(400, 80);
            promotionWindow.setLocationRelativeTo(null); // Center the window

            JPanel promotionPanel = new JPanel();
            promotionPanel.setLayout(new FlowLayout());
            JButton queenButton = new JButton("Queen");
            queenButton.addActionListener(e -> promotePawn(row, col, whiteQueen1, promotionWindow));
            promotionPanel.add(queenButton);

            JButton rookButton = new JButton("Rook");
            rookButton.addActionListener(e -> promotePawn(row, col, whiteRook1, promotionWindow));
            promotionPanel.add(rookButton);

            JButton bishopButton = new JButton("Bishop");
            bishopButton.addActionListener(e -> promotePawn(row, col, whiteBishop1, promotionWindow));
            promotionPanel.add(bishopButton);

            JButton knightButton = new JButton("Knight");
            knightButton.addActionListener(e -> promotePawn(row, col, whiteKnight1, promotionWindow));
            promotionPanel.add(knightButton);

            promotionWindow.add(promotionPanel);
            promotionWindow.setVisible(true);
        } else {
            int row = 14;
            int x = 0;
            for (int j = 0; j < board2.length; j++) {
                if (getColor((ImageIcon) board2[14][j].getIcon()).equals("black")
                        && getType((ImageIcon) board2[14][j].getIcon()).equals("pawn")) {
                    x = j;
                    break;
                }
            }
            int col = x;
            JFrame promotionWindow = new JFrame("Pawn Promotion");
            promotionWindow.setSize(400, 80);
            promotionWindow.setLocationRelativeTo(null); // Center the window

            JPanel promotionPanel = new JPanel();
            promotionPanel.setLayout(new FlowLayout());
            JButton queenButton = new JButton("Queen");
            queenButton.addActionListener(e -> promotePawn(row, col, blackQueen1, promotionWindow));
            promotionPanel.add(queenButton);

            JButton rookButton = new JButton("Rook");
            rookButton.addActionListener(e -> promotePawn(row, col, blackRook1, promotionWindow));
            promotionPanel.add(rookButton);

            JButton bishopButton = new JButton("Bishop");
            bishopButton.addActionListener(e -> promotePawn(row, col, blackBishop1, promotionWindow));
            promotionPanel.add(bishopButton);

            JButton knightButton = new JButton("Knight");
            knightButton.addActionListener(e -> promotePawn(row, col, blackKnight1, promotionWindow));
            promotionPanel.add(knightButton);

            promotionWindow.add(promotionPanel);
            promotionWindow.setVisible(true);
        }
    }

    public static void promotePawn(int row, int col, ImageIcon promotionPiece, JFrame promotionWindow) {
        board2[row][col].setIcon(promotionPiece);
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
            for (int col = 0; col < board2.length; col++) {
                if (getColor((ImageIcon) board2[0][col].getIcon()).equals("white")
                        && getType((ImageIcon) board2[0][col].getIcon()).equals("pawn")) {
                    return true;
                }
            }
            return false;
        } else {
            for (int col = 0; col < board2.length; col++) {
                if (getColor((ImageIcon) board2[14][col].getIcon()).equals("black")
                        && getType((ImageIcon) board2[14][col].getIcon()).equals("pawn")) {
                    return true;
                }
            }
            return false;
        }
    }

    public static List<JLabel> movableCells(JLabel source) {
        int row = -1;
        int col = -1;
        for (int i = 0; i < board2.length; i++) {
            for (int j = 0; j < board2.length; j++) {
                if (board2[i][j] == source) {
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        if (getType((ImageIcon) source.getIcon()).equals("pawn")) {
            Pawn2 pawn = new Pawn2(row, col, getColor((ImageIcon) source.getIcon()));
            return pawn.movableCells();
        }
        if (getType((ImageIcon) source.getIcon()).equals("queen")) {
            Queen2 queen = new Queen2(row, col, getColor((ImageIcon) source.getIcon()));
            return queen.movableCells();
        }
        if (getType((ImageIcon) source.getIcon()).equals("knight")) {
            Knight2 knight = new Knight2(row, col, getColor((ImageIcon) source.getIcon()));
            return knight.movableCells();
        }
        if (getType((ImageIcon) source.getIcon()).equals("rook")) {
            Rook2 rook = new Rook2(row, col, getColor((ImageIcon) source.getIcon()));
            return rook.movableCells();
        }
        if (getType((ImageIcon) source.getIcon()).equals("bishop")) {
            Bishop2 bishop = new Bishop2(row, col, getColor((ImageIcon) source.getIcon()));
            return bishop.movableCells();
        }
        if (getType((ImageIcon) source.getIcon()).equals("king")) {
            King2 king = new King2(row, col, getColor((ImageIcon) source.getIcon()));
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

    public static String getColor(ImageIcon i) {
        if (i == null) {
            return "empty";
        }
        String cachedColor = colorCache.get(i);
        if (cachedColor != null) {
            return cachedColor;
        }
        if (compareImages(i.getImage(), blackRook1.getImage())
                || compareImages(i.getImage(), blackRook2.getImage())
                || compareImages(i.getImage(), blackRook3.getImage())
                || compareImages(i.getImage(), blackRook4.getImage())
                || compareImages(i.getImage(), blackBishop1.getImage())
                || compareImages(i.getImage(), blackBishop2.getImage())
                || compareImages(i.getImage(), blackBishop3.getImage())
                || compareImages(i.getImage(), blackBishop4.getImage())
                || compareImages(i.getImage(), blackKnight1.getImage())
                || compareImages(i.getImage(), blackKnight2.getImage())
                || compareImages(i.getImage(), blackKnight3.getImage())
                || compareImages(i.getImage(), blackKnight4.getImage())
                || compareImages(i.getImage(), blackKing.getImage())
                || compareImages(i.getImage(), blackQueen1.getImage())
                || compareImages(i.getImage(), blackQueen2.getImage())
                || compareImages(i.getImage(), blackPawn2.getImage())
                || compareImages(i.getImage(), blackPawn3.getImage())
                || compareImages(i.getImage(), blackPawn4.getImage())
                || compareImages(i.getImage(), blackPawn5.getImage())
                || compareImages(i.getImage(), blackPawn6.getImage())
                || compareImages(i.getImage(), blackPawn7.getImage())
                || compareImages(i.getImage(), blackPawn8.getImage())
                || compareImages(i.getImage(), blackPawn1.getImage())
                || compareImages(i.getImage(), blackPawn9.getImage())
                || compareImages(i.getImage(), blackPawn10.getImage())
                || compareImages(i.getImage(), blackPawn11.getImage())
                || compareImages(i.getImage(), blackPawn12.getImage())
                || compareImages(i.getImage(), blackPawn13.getImage())
                || compareImages(i.getImage(), blackPawn14.getImage())
                || compareImages(i.getImage(), blackPawn15.getImage())
        ) {
            colorCache.put(i, "black");
            return "black";
        }
        colorCache.put(i, "white");
        return "white";
    }

    public static String getType(ImageIcon i) {
        if (i == null) {
            return "empty";
        }
        String cachedType = typeCache.get(i);
        if (cachedType != null) {
            return cachedType;
        }
        if (compareImages(i.getImage(), blackRook2.getImage())
                || compareImages(i.getImage(), blackRook1.getImage())
                || compareImages(i.getImage(), blackRook3.getImage())
                || compareImages(i.getImage(), blackRook4.getImage())
                || compareImages(i.getImage(), whiteRook1.getImage())
                || compareImages(i.getImage(), whiteRook2.getImage())
                || compareImages(i.getImage(), whiteRook3.getImage())
                || compareImages(i.getImage(), whiteRook4.getImage())
        ) {
            typeCache.put(i, "rook");
            return "rook";
        }

        if (compareImages(i.getImage(), blackBishop1.getImage())
                || compareImages(i.getImage(), blackBishop2.getImage())
                || compareImages(i.getImage(), blackBishop3.getImage())
                || compareImages(i.getImage(), blackBishop4.getImage())
                || compareImages(i.getImage(), whiteBishop1.getImage())
                || compareImages(i.getImage(), whiteBishop2.getImage())
                || compareImages(i.getImage(), whiteBishop3.getImage())
                || compareImages(i.getImage(), whiteBishop4.getImage())
        ) {
            typeCache.put(i, "bishop");
            return "bishop";
        }

        if (compareImages(i.getImage(), blackKnight2.getImage())
                || compareImages(i.getImage(), blackKnight1.getImage())
                || compareImages(i.getImage(), blackKnight3.getImage())
                || compareImages(i.getImage(), blackKnight4.getImage())
                || compareImages(i.getImage(), whiteKnight1.getImage())
                || compareImages(i.getImage(), whiteKnight2.getImage())
                || compareImages(i.getImage(), whiteKnight3.getImage())
                || compareImages(i.getImage(), whiteKnight4.getImage())
        ) {
            typeCache.put(i, "knight");
            return "knight";
        }

        if (compareImages(i.getImage(), blackQueen1.getImage())
                || compareImages(i.getImage(), whiteQueen1.getImage())
                || compareImages(i.getImage(), whiteQueen2.getImage())
                || compareImages(i.getImage(), blackQueen2.getImage())
        ) {
            typeCache.put(i, "queen");
            return "queen";
        }

        if (compareImages(i.getImage(), blackKing.getImage())
                || compareImages(i.getImage(), whiteKing.getImage())) {
            typeCache.put(i, "king");
            return "king";
        }

        typeCache.put(i, "pawn");
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
        BufferedImage cached = bufferedImageCache.get(img);
        if (cached != null) {
            return cached;
        }

        BufferedImage bufferedImage = new BufferedImage(
                img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawImage(img, 0, 0, null);
        g2d.dispose();

        bufferedImageCache.put(img, bufferedImage);
        return bufferedImage;
    }

    public static boolean isCheck(String color, JLabel[][] board2) {
        for (int i = 0; i < board2.length; i++) {
            for (int j = 0; j < board2.length; j++) {
                if (getColor((ImageIcon) board2[i][j].getIcon()).equals(color)
                        && getType((ImageIcon) board2[i][j].getIcon()).equals("king")) {
                    King2 king = new King2(i, j, color);
                    if (!king.isSafe(i, j)) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isCheckMate(String color) {
        for (int i = 0; i < board2.length; i++) {
            for (int j = 0; j < board2.length; j++) {
                if (getColor((ImageIcon) board2[i][j].getIcon()).equals(color)) {
                    if (getType((ImageIcon) board2[i][j].getIcon()).equals("king")) {
                        King2 king = new King2(i, j, color);
                        if (!king.movableCells().isEmpty()) {
                            return false;
                        }
                    } else if (getType((ImageIcon) board2[i][j].getIcon()).equals("queen")) {
                        Queen2 queen = new Queen2(i, j, color);
                        if (!queen.movableCells().isEmpty()) {
                            return false;
                        }
                    } else if (getType((ImageIcon) board2[i][j].getIcon()).equals("rook")) {
                        Rook2 rook = new Rook2(i, j, color);
                        if (!rook.movableCells().isEmpty()) {
                            return false;
                        }
                    } else if (getType((ImageIcon) board2[i][j].getIcon()).equals("knight")) {
                        Knight2 knight = new Knight2(i, j, color);
                        if (!knight.movableCells().isEmpty()) {
                            return false;
                        }
                    } else if (getType((ImageIcon) board2[i][j].getIcon()).equals("bishop")) {
                        Bishop2 bishop = new Bishop2(i, j, color);
                        if (!bishop.movableCells().isEmpty()) {
                            return false;
                        }
                    } else {
                        Pawn2 pawn = new Pawn2(i, j, color);
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
        for (int i = 0; i < board2.length; i++) {
            for (int j = 0; j < board2.length; j++) {
                board2[i][j].setBackground((i + j) % 2 != 0 ? darkSquare : lightSquare);
                board2[i][j].setIcon(null);
                board2[i][j].setBorder(null);
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
        whiteEnpasante9 = false;
        whiteEnpasante10 = false;
        whiteEnpasante11 = false;
        whiteEnpasante12 = false;
        whiteEnpasante13 = false;
        whiteEnpasante14 = false;
        whiteEnpasante15 = false;
        blackEnpasante1 = false;
        blackEnpasante2 = false;
        blackEnpasante3 = false;
        blackEnpasante4 = false;
        blackEnpasante5 = false;
        blackEnpasante6 = false;
        blackEnpasante7 = false;
        blackEnpasante8 = false;
        blackEnpasante9 = false;
        blackEnpasante10 = false;
        blackEnpasante11 = false;
        blackEnpasante12 = false;
        blackEnpasante13 = false;
        blackEnpasante14 = false;
        blackEnpasante15 = false;
        uselessHalfMoves = 0;
        initialiseBoard();
    }

    public static int checkDraw(String color) {
        if (Objects.equals(color, "white")) {
            // Stalemate
            if (!isCheck(color, board2) && isCheckMate(color)) {
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
            if (!isCheck(color, board2) && isCheckMate(color)) {
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
        if (kingvsking() || kingAndBishopVsKing(color) || kingAndKnightVsKing(color)
                || kingAndBishopVsKingAndBishop()) {
            return true;
        }
        return false;
    }

    public static boolean kingvsking() {
        for (int i = 0; i < board2.length; i++) {
            for (int j = 0; j < board2.length; j++) {
                if (getType((ImageIcon) board2[i][j].getIcon()).equals("king")) {
                    continue;
                }
                if (!getType((ImageIcon) board2[i][j].getIcon()).equals("empty")) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean kingAndBishopVsKing(String color) {
        for (int i = 0; i < board2.length; i++) {
            for (int j = 0; j < board2.length; j++) {
                if (getType((ImageIcon) board2[i][j].getIcon()).equals("king")) {
                    continue;
                }
                if (!(getColor((ImageIcon) board2[i][j].getIcon()).equals(color)
                        && getType((ImageIcon) board2[i][j].getIcon()).equals("bishop"))
                        && !getColor((ImageIcon) board2[i][j].getIcon()).equals("empty")) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean kingAndKnightVsKing(String color) {
        for (int i = 0; i < board2.length; i++) {
            for (int j = 0; j < board2.length; j++) {
                if (getType((ImageIcon) board2[i][j].getIcon()).equals("king")) {
                    continue;
                }
                if (!(getColor((ImageIcon) board2[i][j].getIcon()).equals(color)
                        && getType((ImageIcon) board2[i][j].getIcon()).equals("knight"))
                        && !getColor((ImageIcon) board2[i][j].getIcon()).equals("empty")) {
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
        for (int i = 0; i < board2.length; i++) {
            for (int j = 0; j < board2.length; j++) {
                if (getType((ImageIcon) board2[i][j].getIcon()).equals("king") ||
                        (getColor((ImageIcon) board2[i][j].getIcon()).equals("white")
                                && getType((ImageIcon) board2[i][j].getIcon()).equals("bishop"))
                        ||
                        (getColor((ImageIcon) board2[i][j].getIcon()).equals("black")
                                && getType((ImageIcon) board2[i][j].getIcon()).equals("bishop"))
                        || getColor((ImageIcon) board2[i][j].getIcon()).equals("empty")) {
                    if (getColor((ImageIcon) board2[i][j].getIcon()).equals("white")
                            && getType((ImageIcon) board2[i][j].getIcon()).equals("bishop")) {
                        whiteBishops++;
                        whiteRow = i;
                        whiteCol = j;
                    } else if (getColor((ImageIcon) board2[i][j].getIcon()).equals("black")
                            && getType((ImageIcon) board2[i][j].getIcon()).equals("bishop")) {
                        blackBishops++;
                        blackRow = i;
                        blackCol = j;
                    }
                    continue;
                } else {
                    return false;
                }
            }
        }

        if (whiteBishops > 1 || blackBishops > 1) {
            return false;
        }
        if (board2[whiteRow][whiteCol].getBackground() != board2[blackRow][blackCol].getBackground()) {
            return false;
        }
        return true;
    }
}
