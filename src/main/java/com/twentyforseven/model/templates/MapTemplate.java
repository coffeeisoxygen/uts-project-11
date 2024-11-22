package com.twentyforseven.model.templates;

import com.twentyforseven.model.classes.board.IBoard;

public abstract class MapTemplate {
    public final void loadTemplate(IBoard board) {
        initializeTemplate(board);
        placeTiles(board);
    }

    protected abstract void initializeTemplate(IBoard board);

    protected abstract void placeTiles(IBoard board);

}
