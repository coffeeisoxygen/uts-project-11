package com.twentyforseven.view.game;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import com.twentyforseven.model.classes.tile.ITile;
import com.twentyforseven.model.commands.CommandHandler;
import com.twentyforseven.model.services.GameManager;
import com.twentyforseven.util.GameContext;

public class GameFrame extends JFrame implements PropertyChangeListener {
    private GameManager gameManager;
    private JTextField commandInput;
    private JPanel boardPanel;
    private TilePanel[][] tilePanels;
    private JTextArea logArea;

    public GameFrame() {
        // Initialize the game context and game manager
        GameContext context = GameContext.getInstance();
        gameManager = context.getGameManager();

        // Set up the frame
        setTitle("2D Game");
        setSize(800, 900);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize components
        initializeUIComponents();

        // Add property change listeners
        addPropertyChangeListeners();

        // Initial board display
        updateBoardDisplay();
    }

    private void initializeUIComponents() {
        // Create the board panel
        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(gameManager.getBoard().getHeight(), gameManager.getBoard().getWidth()));

        // Initialize tile panels
        tilePanels = new TilePanel[gameManager.getBoard().getHeight()][gameManager.getBoard().getWidth()];
        for (int i = 0; i < gameManager.getBoard().getHeight(); i++) {
            for (int j = 0; j < gameManager.getBoard().getWidth(); j++) {
                ITile tile = gameManager.getBoard().getTile(i, j);
                TilePanel tilePanel = new TilePanel(tile, i, j);
                tilePanels[i][j] = tilePanel;
                boardPanel.add(tilePanel);
            }
        }

        // Create control panel (top)
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener((ActionEvent e) -> restartGame());

        JButton randomizeButton = new JButton("Randomize Tiles");
        randomizeButton.addActionListener((ActionEvent e) -> {
            GameContext context = GameContext.getInstance();
            context.createCustomBoard(gameManager.getBoard().getHeight(), gameManager.getBoard().getWidth());
            gameManager = context.getGameManager();
            updateBoardDisplay();
        });

        controlPanel.add(restartButton);
        controlPanel.add(randomizeButton);

        // Create input panel (bottom)
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        commandInput = new JTextField();
        JButton startButton = new JButton("Start");
        startButton.addActionListener((ActionEvent e) -> {
            String commands = commandInput.getText();
            gameManager.startGame(commands);
            updateBoardDisplay();
        });

        inputPanel.add(commandInput, BorderLayout.CENTER);
        inputPanel.add(startButton, BorderLayout.EAST);

        // Create log area (side)
        logArea = new JTextArea();
        logArea.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(logArea);

        // Add components to the frame
        add(controlPanel, BorderLayout.NORTH);
        add(boardPanel, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
        add(logScrollPane, BorderLayout.EAST);
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

    private void restartGame() {
        // Reinitialize the game context and game manager
        GameContext context = GameContext.getInstance();
        context.createCustomBoard(gameManager.getBoard().getHeight(), gameManager.getBoard().getWidth());
        gameManager = context.getGameManager();

        // Clear the log area
        logArea.setText("");

        // Update the board display
        updateBoardDisplay();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("invalidMove".equals(evt.getPropertyName())) {
            JOptionPane.showMessageDialog(this, "Invalid move! Player moved out of board boundaries.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            logArea.append("Invalid move! Player moved out of board boundaries.\n");
        } else if ("deathReason".equals(evt.getPropertyName())) {
            JOptionPane.showMessageDialog(this, "Player has died: " + evt.getNewValue(), "Game Over",
                    JOptionPane.ERROR_MESSAGE);
            logArea.append("Player has died: " + evt.getNewValue() + "\n");
        } else if ("hasWon".equals(evt.getPropertyName()) && (boolean) evt.getNewValue()) {
            JOptionPane.showMessageDialog(this, "Player has won the game!", "Congratulations",
                    JOptionPane.INFORMATION_MESSAGE);
            logArea.append("Player has won the game!\n");
        }
        updateBoardDisplay();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameFrame gameFrame = new GameFrame();
            gameFrame.setVisible(true);
        });
    }
}
