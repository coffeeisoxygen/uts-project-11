package com.twentyforseven.view.game;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

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

    public TilePanel(ITile tile) {
        this.tile = tile;
        this.hasPlayer = false;
        setBackground(getTileColor(tile));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
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