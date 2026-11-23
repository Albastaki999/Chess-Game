package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class ChessMainMenu extends JFrame {

    public ChessMainMenu() {
        setTitle("Chess Game Main Menu");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(600, 400));
        add(layeredPane);

        ImageIcon coverImage = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/KingsGame.png")));
        ImageIcon play8Icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/play8.png")));
        ImageIcon play16Icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/play15.png")));

        JLabel coverLabel = new JLabel(coverImage);
        coverLabel.setBounds(0, 0, 600, 400);
        layeredPane.add(coverLabel, JLayeredPane.DEFAULT_LAYER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBounds(10, 300, 580, 50);

        // Create and resize the 8x8 game button
        JButton button8x8 = new JButton();
        button8x8.setIcon(resizeIcon(play8Icon)); // Set the desired size here
        button8x8.setPreferredSize(new Dimension(100, 50));
        button8x8.addActionListener(e -> {
            new Main();
            this.dispose();
        });
        buttonPanel.add(button8x8);

        // Create and resize the 16x16 game button
        JButton button16x16 = new JButton();
        button16x16.setIcon(resizeIcon(play16Icon)); // Set the desired size here
        button16x16.setPreferredSize(new Dimension(100, 50));
        button16x16.addActionListener(e -> {
            new Main2();
            this.dispose();
        });
        buttonPanel.add(button16x16);

        layeredPane.add(buttonPanel, JLayeredPane.PALETTE_LAYER);

        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private ImageIcon resizeIcon(ImageIcon icon) {
        Image img = icon.getImage();
        BufferedImage bi = new BufferedImage(100, 50, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bi.createGraphics();
        g2d.drawImage(img, 0, 0, 100, 50, null);
        g2d.dispose();
        return new ImageIcon(bi);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ChessMainMenu());
    }
}
