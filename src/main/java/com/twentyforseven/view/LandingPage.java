package com.twentyforseven.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.twentyforseven.model.classes.board.Board;
import com.twentyforseven.model.factory.ITileFactory;
import com.twentyforseven.model.factory.TileFactoryImpl;
import com.twentyforseven.model.interfaces.IBoard;
import com.twentyforseven.view.game.GameFrame;
public class LandingPage extends JFrame {
    public LandingPage() {
        setTitle("Project Coffee Is Oxygen");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Placeholder Gambar di Kiri
        JLabel imagePlaceholder = new JLabel("Gambar Placeholder", SwingConstants.CENTER);
        imagePlaceholder.setPreferredSize(new Dimension(200, 0));
        imagePlaceholder.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(imagePlaceholder, BorderLayout.WEST);

        // Menu di Kanan
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        // Tombol-tombol Menu
        String[] menuItems = {
            "Hiking Game",
            "Array Visualize",
            "Algorithm Visualize",
            "Queue Visualize",
            "Stack Visualize",
            "Exit"
        };

        for (String item : menuItems) {
            JButton button = new JButton(item);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.addActionListener((ActionEvent e) -> handleMenuClick(item));
            menuPanel.add(button);
            menuPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer
        }

        add(menuPanel, BorderLayout.CENTER);
    }

    private void handleMenuClick(String menuItem) {
        switch (menuItem) {
            case "Hiking Game" -> {
                ITileFactory tileFactory = new TileFactoryImpl();
                IBoard board = new Board(6, 12, tileFactory);
                new GameFrame(board);
                dispose();
            }
            case "Exit" -> System.exit(0);
            default -> JOptionPane.showMessageDialog(this, menuItem + " belum diimplementasi.", 
                    "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LandingPage landingPage = new LandingPage();
            landingPage.setVisible(true);
        });
    }
}
