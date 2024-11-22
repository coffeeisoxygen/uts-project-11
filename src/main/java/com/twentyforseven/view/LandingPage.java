package com.twentyforseven.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.twentyforseven.model.classes.board.Board;
import com.twentyforseven.model.factory.ITileFactory;
import com.twentyforseven.model.factory.TileFactoryImpl;
import com.twentyforseven.model.interfaces.IBoard;
import com.twentyforseven.model.interfaces.ITile;

public class LandingPage extends JFrame implements PropertyChangeListener {
    private IBoard board;
    private JPanel boardPanel;

    public LandingPage(IBoard board) {
        this.board = board;
        initializeUI();
        registerListeners();
    }

    private void registerListeners() {
        this.board.addPropertyChangeListener(this);
    }

    private void initializeUI() {
        setTitle("Board Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        boardPanel = new JPanel(new GridLayout(board.getHeight(), board.getWidth()));
        updateBoard();
        add(boardPanel, BorderLayout.CENTER);
    }

    private void updateBoard() {
        boardPanel.removeAll();
        for (int i = 0; i < board.getHeight(); i++) {
            for (int j = 0; j < board.getWidth(); j++) {
                ITile tile = board.getTile(i, j);
                JButton tileButton = new JButton(tile.getType().toString().charAt(0) + "");
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
            LandingPage landingPage = new LandingPage(board);
            landingPage.setVisible(true);
        });
    }
}