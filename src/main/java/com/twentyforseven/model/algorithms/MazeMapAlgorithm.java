package com.twentyforseven.model.algorithms;

import com.twentyforseven.model.interfaces.IBoard;
import com.twentyforseven.model.interfaces.ITile;
import com.twentyforseven.model.enumerate.TileType;

import java.util.Random;
import java.util.Stack;

public class MazeMapAlgorithm implements MapCreationAlgorithm {
    private final Random random = new Random();

    @Override
    public void createMap(IBoard board) {
        int height = board.getHeight();
        int width = board.getWidth();

        // Initialize all tiles to NORMALPOINT by default
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board.setTile(i, j, TileType.NORMALPOINT);
            }
        }

        // Generate maze with Recursive Backtracking
        boolean[][] visited = new boolean[height][width];
        generateMaze(board, visited, 0, 0);

        // Place STARTPOINT and FINISHPOINT
        int[] start = placeTile(board, TileType.STARTPOINT);
        int[] finish = placeTile(board, TileType.FINISHPOINT);

        // Add CHECKPOINTS randomly along the valid path
        addCheckpoints(board, start, finish);

        // Fill remaining tiles with DANGERPOINT randomly
        fillWithDangerTiles(board);
    }

    private void generateMaze(IBoard board, boolean[][] visited, int x, int y) {
        visited[x][y] = true;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        shuffleArray(directions); // Randomize direction order

        for (int[] dir : directions) {
            int nx = x + dir[0] * 2;
            int ny = y + dir[1] * 2;

            if (isValid(nx, ny, visited)) {
                // Carve a path
                board.setTile(x + dir[0], y + dir[1], TileType.NORMALPOINT);
                generateMaze(board, visited, nx, ny);
            }
        }
    }

    private void shuffleArray(int[][] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int[] temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    private boolean isValid(int x, int y, boolean[][] visited) {
        return x >= 0 && x < visited.length && y >= 0 && y < visited[0].length && !visited[x][y];
    }

    private int[] placeTile(IBoard board, TileType type) {
        int x, y;
        do {
            x = random.nextInt(board.getHeight());
            y = random.nextInt(board.getWidth());
        } while (!board.getTile(x, y).getType().equals(TileType.NORMALPOINT));
        board.setTile(x, y, type);
        return new int[]{x, y};
    }

    private void addCheckpoints(IBoard board, int[] start, int[] finish) {
        Stack<int[]> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int x = current[0], y = current[1];

            // Add CHECKPOINT with probability
            if (random.nextDouble() < 0.2) {
                board.setTile(x, y, TileType.CHECKPOINT);
            }

            // Push neighbors that are part of the valid path
            for (int[] dir : new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (isWithinBounds(nx, ny, board) && board.getTile(nx, ny).getType().equals(TileType.NORMALPOINT)) {
                    stack.push(new int[]{nx, ny});
                }
            }
        }
    }

    private void fillWithDangerTiles(IBoard board) {
        for (int i = 0; i < board.getHeight(); i++) {
            for (int j = 0; j < board.getWidth(); j++) {
                ITile tile = board.getTile(i, j);
                if (tile.getType().equals(TileType.NORMALPOINT) && random.nextDouble() < 0.1) {
                    board.setTile(i, j, TileType.DANGERPOINT);
                }
            }
        }
    }

    private boolean isWithinBounds(int x, int y, IBoard board) {
        return x >= 0 && x < board.getHeight() && y >= 0 && y < board.getWidth();
    }
}
