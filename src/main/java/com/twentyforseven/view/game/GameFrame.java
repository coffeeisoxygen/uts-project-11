package com.twentyforseven.view.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import com.twentyforseven.model.services.GameManager;
import com.twentyforseven.util.GameContext;
import com.twentyforseven.model.classes.tile.ITile;
import com.twentyforseven.model.commands.CommandHandler;

public class GameFrame extends JFrame implements PropertyChangeListener {
    private GameManager gameManager;
    private JTextField commandInput;
    private JPanel boardPanel;
    private TilePanel[][] tilePanels;

    public GameFrame() {
        // Initialize the game context and game manager
        GameContext context = GameContext.getInstance();
        gameManager = context.getGameManager();

        // Set up the UI components
        setTitle("2D Game");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        commandInput = new JTextField();
        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(gameManager.getBoard().getHeight(), gameManager.getBoard().getWidth()));

        // Initialize tile panels
        tilePanels = new TilePanel[gameManager.getBoard().getHeight()][gameManager.getBoard().getWidth()];
        for (int i = 0; i < gameManager.getBoard().getHeight(); i++) {
            for (int j = 0; j < gameManager.getBoard().getWidth(); j++) {
                ITile tile = gameManager.getBoard().getTile(i, j);
                TilePanel tilePanel = new TilePanel(tile);
                tilePanels[i][j] = tilePanel;
                boardPanel.add(tilePanel);
            }
        }

        JButton startButton = new JButton("Start");
        startButton.addActionListener((ActionEvent e) -> {
            String commands = commandInput.getText();
            gameManager.startGame(commands);
            updateBoardDisplay();
        });

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(commandInput, BorderLayout.CENTER);
        inputPanel.add(startButton, BorderLayout.EAST);

        add(inputPanel, BorderLayout.NORTH);
        add(boardPanel, BorderLayout.CENTER);

        // Add property change listeners
        addPropertyChangeListeners();

        // Initial board display
        updateBoardDisplay();
    }

    private void addPropertyChangeListeners() {
        gameManager.getPlayer().addPropertyChangeListener(this::propertyChange);
        gameManager.getBoard().addPropertyChangeListener(this::propertyChange);
        ((CommandHandler) gameManager.getCommandHandler()).addPropertyChangeListener(this::propertyChange);
    }

    private void updateBoardDisplay() {
        Point playerPosition = gameManager.getPlayer().getPosition();

        for (int i = 0; i < gameManager.getBoard().getHeight(); i++) {
            for (int j = 0; j < gameManager.getBoard().getWidth(); j++) {
                tilePanels[i][j].setHasPlayer(playerPosition.x == i && playerPosition.y == j);
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("invalidMove".equals(evt.getPropertyName())) {
            JOptionPane.showMessageDialog(this, "Invalid move! Player moved out of board boundaries.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if ("deathReason".equals(evt.getPropertyName())) {
            JOptionPane.showMessageDialog(this, "Player has died: " + evt.getNewValue(), "Game Over", JOptionPane.ERROR_MESSAGE);
        } else if ("hasWon".equals(evt.getPropertyName()) && (boolean) evt.getNewValue()) {
            JOptionPane.showMessageDialog(this, "Player has won the game!", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
        }
        updateBoardDisplay();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GameFrame gameFrame = new GameFrame();
                gameFrame.setVisible(true);
            }
        });
    }
}