package com.twentyforseven.view.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.twentyforseven.model.classes.tile.ITile;

public class TilePanel extends JPanel {
    private static final Color CHECKPOINT_COLOR = Color.GREEN;
    private static final Color STARTPOINT_COLOR = Color.BLUE;
    private static final Color FINISHPOINT_COLOR = Color.MAGENTA;
    private static final Color DANGERPOINT_COLOR = Color.RED;
    private static final Color NORMALPOINT_COLOR = Color.WHITE;
    private static final Color PLAYER_COLOR = Color.YELLOW;

    private ITile tile;
    private boolean hasPlayer;
    private int x, y;

    public TilePanel(ITile tile, int x, int y) {
        this.tile = tile;
        this.x = x;
        this.y = y;
        this.hasPlayer = false;

        setBackground(getTileColor(tile));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setLayout(new BorderLayout());

        JLabel infoLabel = new JLabel("<html>" +
                "Name: " + tile.getName() + "<br>" +
                "Type: " + tile.getType() + "<br>" +
                "Pos: (" + x + ", " + y + ")" +
                "</html>");
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        infoLabel.setFont(new Font("Arial", Font.PLAIN, 10));
        add(infoLabel, BorderLayout.CENTER);
    }

    public void setHasPlayer(boolean hasPlayer) {
        this.hasPlayer = hasPlayer;
        setBackground(hasPlayer ? PLAYER_COLOR : getTileColor(tile));
    }

    private Color getTileColor(ITile tile) {
        switch (tile.getType()) {
            case CHECKPOINT:
                return CHECKPOINT_COLOR;
            case STARTPOINT:
                return STARTPOINT_COLOR;
            case FINISHPOINT:
                return FINISHPOINT_COLOR;
            case DANGERPOINT:
                return DANGERPOINT_COLOR;
            case NORMALPOINT:
            default:
                return NORMALPOINT_COLOR;
        }
    }
}
