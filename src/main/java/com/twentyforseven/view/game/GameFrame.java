// package com.twentyforseven.view.game;

// import java.awt.BorderLayout;
// import java.awt.Color;
// import java.awt.Dimension;
// import java.awt.FlowLayout;
// import java.awt.Font;
// import java.awt.GridLayout;
// import java.beans.PropertyChangeEvent;
// import java.beans.PropertyChangeListener;

// import javax.swing.BorderFactory;
// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JPanel;
// import javax.swing.SwingUtilities;
// import javax.swing.border.EmptyBorder;

// import com.twentyforseven.model.algorithms.IMapRandomAlgo;
// import com.twentyforseven.model.interfaces.IBoard;
// import com.twentyforseven.model.interfaces.ITile;
// import com.twentyforseven.util.GameContext;

// public class GameFrame extends JFrame implements PropertyChangeListener {
// private static final int FRAME_WIDTH = 1000;
// private static final int FRAME_HEIGHT = 700;
// private static final Color CONTROL_PANEL_BG_COLOR = new Color(220, 240, 240);
// private static final Color BUTTON_BG_COLOR = new Color(70, 130, 180);
// private static final Color BUTTON_BORDER_COLOR = new Color(40, 90, 150);
// private static final Color BOARD_PANEL_BG_COLOR = Color.WHITE;

// private IBoard board;
// private JPanel boardPanel;
// private IMapRandomAlgo mapCreationAlgorithm;

// public GameFrame(IBoard board, IMapRandomAlgo mapCreationAlgorithm) {
// this.board = board;
// this.mapCreationAlgorithm = mapCreationAlgorithm;
// initializeUI();
// registerListeners();
// setVisible(true);
// }

// private void registerListeners() {
// this.board.addPropertyChangeListener(this);
// }

// private void initializeUI() {
// setTitle("Hiking Game");
// setSize(FRAME_WIDTH, FRAME_HEIGHT);
// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// setLayout(new BorderLayout());

// add(createControlPanel(), BorderLayout.NORTH);
// add(createBoardPanel(), BorderLayout.CENTER);
// }

// private JPanel createControlPanel() {
// JPanel controlPanel = new JPanel();
// controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
// controlPanel.setBackground(CONTROL_PANEL_BG_COLOR);

// JButton randomizeButton = new JButton("Randomize Map");
// JButton createMapButton = new JButton("Create Map");
// JButton loadMapButton = new JButton("Load Map");
// JButton startGameButton = new JButton("Start Game");

// styleControlButton(randomizeButton);
// styleControlButton(createMapButton);
// styleControlButton(loadMapButton);
// styleControlButton(startGameButton);

// randomizeButton.addActionListener(e -> {
// mapCreationAlgorithm.constructMap(board);
// updateBoard();
// });

// controlPanel.add(randomizeButton);
// controlPanel.add(createMapButton);
// controlPanel.add(loadMapButton);
// controlPanel.add(startGameButton);

// return controlPanel;
// }

// private JPanel createBoardPanel() {
// boardPanel = new JPanel(new GridLayout(board.getHeight(), board.getWidth()));
// boardPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
// boardPanel.setBackground(BOARD_PANEL_BG_COLOR);
// updateBoard();
// return boardPanel;
// }

// private void styleControlButton(JButton button) {
// button.setFont(new Font("Arial", Font.BOLD, 14));
// button.setBackground(BUTTON_BG_COLOR);
// button.setForeground(Color.WHITE);
// button.setFocusPainted(false);
// button.setBorder(BorderFactory.createLineBorder(BUTTON_BORDER_COLOR, 2));
// button.setPreferredSize(new Dimension(150, 40));
// }

// private void updateBoard() {
// boardPanel.removeAll();
// for (int i = 0; i < board.getHeight(); i++) {
// for (int j = 0; j < board.getWidth(); j++) {
// ITile tile = board.getTile(i, j);
// JButton tileButton = new JButton(tile.getType().toString().charAt(0) + "");
// tileButton.setFont(new Font("Arial", Font.BOLD, 16));
// tileButton.setFocusPainted(false);
// tileButton.setBackground(tile.getColor());
// tileButton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
// boardPanel.add(tileButton);
// }
// }
// boardPanel.revalidate();
// boardPanel.repaint();
// }

// @Override
// public void propertyChange(PropertyChangeEvent evt) {
// if ("tile".equals(evt.getPropertyName())) {
// updateBoard();
// }
// }

// public static void main(String[] args) {
// GameContext context = GameContext.getInstance();
// SwingUtilities.invokeLater(() -> {
// GameFrame gameFrame = new GameFrame(context.getBoard(),
// context.getMazeGenerator());
// gameFrame.setVisible(true);
// });
// }
// }