package com.twentyforseven.view.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.twentyforseven.model.classes.board.Board;
import com.twentyforseven.model.factory.ITileFactory;
import com.twentyforseven.model.factory.TileFactoryImpl;
import com.twentyforseven.model.interfaces.IBoard;
import com.twentyforseven.model.interfaces.ITile;

public class GameFrame extends JFrame implements PropertyChangeListener {
    private IBoard board;
    private JPanel boardPanel;

    public GameFrame(IBoard board) {
        this.board = board;
        initializeUI();
        registerListeners();
    }

    private void registerListeners() {
        this.board.addPropertyChangeListener(this);
    }

    private void initializeUI() {
        setTitle("Hiking Game");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Kontrol Panel di Bagian Atas
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
        controlPanel.setBackground(new Color(220, 240, 240)); // Warna pastel untuk background

        JButton randomizeButton = new JButton("Randomize Map");
        JButton createMapButton = new JButton("Create Map");
        JButton loadMapButton = new JButton("Load Map");
        JButton startGameButton = new JButton("Start Game");

        styleControlButton(randomizeButton);
        styleControlButton(createMapButton);
        styleControlButton(loadMapButton);
        styleControlButton(startGameButton);

        controlPanel.add(randomizeButton);
        controlPanel.add(createMapButton);
        controlPanel.add(loadMapButton);
        controlPanel.add(startGameButton);

        add(controlPanel, BorderLayout.NORTH);

        // Grid Panel untuk Board
        boardPanel = new JPanel(new GridLayout(board.getHeight(), board.getWidth()));
        boardPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Padding antar tile
        boardPanel.setBackground(Color.WHITE); // Background grid
        updateBoard();
        add(boardPanel, BorderLayout.CENTER);
    }

    private void styleControlButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(70, 130, 180)); // Warna biru
        button.setForeground(Color.WHITE); // Tulisan putih
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(new Color(40, 90, 150), 2));
        button.setPreferredSize(new Dimension(150, 40));
    }

    private void updateBoard() {
        boardPanel.removeAll();
        for (int i = 0; i < board.getHeight(); i++) {
            for (int j = 0; j < board.getWidth(); j++) {
                ITile tile = board.getTile(i, j);
                JButton tileButton = new JButton(tile.getType().toString().charAt(0) + "");
                tileButton.setFont(new Font("Arial", Font.BOLD, 16));
                tileButton.setFocusPainted(false);
                tileButton.setBackground(tile.getColor());
                tileButton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
                boardPanel.add(tileButton);
            }
        }
        boardPanel.revalidate();
        boardPanel.repaint();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("tile".equals(evt.getPropertyName())) {
            updateBoard();
        }
    }

    public static void main(String[] args) {
        ITileFactory tileFactory = new TileFactoryImpl();
        IBoard board = new Board(6, 12, tileFactory);
        SwingUtilities.invokeLater(() -> {
            GameFrame landingPage = new GameFrame(board);
            landingPage.setVisible(true);
        });
    }
}
