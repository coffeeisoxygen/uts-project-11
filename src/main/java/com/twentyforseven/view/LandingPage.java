package com.twentyforseven.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.twentyforseven.util.GameContext;
import com.twentyforseven.view.game.GameFrame;

public class LandingPage extends JFrame {

    public LandingPage() {
        setTitle("Landing Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        String[] menuItems = { "Hiking Game", "Create Custom Map", "Exit" };
        for (String menuItem : menuItems) {
            JButton button = new JButton(menuItem);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.addActionListener(e -> handleMenuClick(menuItem));
            menuPanel.add(button);
            menuPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer
        }

        add(menuPanel, BorderLayout.CENTER);
    }

    private void handleMenuClick(String menuItem) {
        switch (menuItem) {
            case "Hiking Game" -> startHikingGame();
            case "Create Custom Map" -> createCustomMap();
            case "Exit" -> exitApplication();
            default -> showNotImplementedMessage(menuItem);
        }
    }

    private void startHikingGame() {
        GameContext context = GameContext.getInstance();
        new GameFrame(context.getBoard(), context.getMazeGenerator());
        dispose();
    }

    private void createCustomMap() {
        JTextField rowsField = new JTextField(5);
        JTextField colsField = new JTextField(5);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Rows:"));
        myPanel.add(rowsField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Cols:"));
        myPanel.add(colsField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter Map Dimensions", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int rows = Integer.parseInt(rowsField.getText());
            int cols = Integer.parseInt(colsField.getText());
            GameContext context = GameContext.getInstance();
            context.getBoardManager().createMap(rows, cols, context.getTileFactory());
            new GameFrame(context.getBoard(), context.getMazeGenerator());
            dispose();
        }
    }

    private void exitApplication() {
        System.exit(0);
    }

    private void showNotImplementedMessage(String menuItem) {
        JOptionPane.showMessageDialog(this, menuItem + " belum diimplementasi.",
                "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LandingPage landingPage = new LandingPage();
            landingPage.setVisible(true);
        });
    }
}