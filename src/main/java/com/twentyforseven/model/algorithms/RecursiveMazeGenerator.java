package com.twentyforseven.model.algorithms;

import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

import com.twentyforseven.model.classes.board.IBoard;
import com.twentyforseven.model.classes.tile.ITile;
import com.twentyforseven.model.enumerate.TileType;
import com.twentyforseven.model.factory.ITileFactory;

public class RecursiveMazeGenerator implements IMapRandomAlgo {
    private final Random random = new Random();
    private final ITileFactory tileFactory;

    public RecursiveMazeGenerator(ITileFactory tileFactory) {
        this.tileFactory = tileFactory;
    }

    @Override
    public void constructMap(IBoard board) {
        int height = board.getHeight();
        int width = board.getWidth();

        // Inisialisasi semua tiles menjadi NORMALPOINT
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                ITile tile = tileFactory.createTile(TileType.NORMALPOINT, new Point(i, j));
                board.setTile(i, j, tile);
            }
        }

        // Generate maze menggunakan DFS iteratif
        boolean[][] visited = new boolean[height][width];
        generateMaze(board, visited, 0, 0);

        // Tempatkan STARTPOINT dan FINISHPOINT
        int[] start = placeTile(board, TileType.STARTPOINT);
        int[] finish = placeTile(board, TileType.FINISHPOINT);

        // Tambahkan CHECKPOINTS secara random di jalur yang valid
        addCheckpoints(board, start, finish);

        // Isi tile sisanya dengan DANGERPOINT secara acak
        fillWithDangerTiles(board);
    }

    private void generateMaze(IBoard board, boolean[][] visited, int startX, int startY) {
        Deque<Point> stack = new ArrayDeque<>();
        stack.push(new Point(startX, startY));

        while (!stack.isEmpty()) {
            Point current = stack.pop();
            int x = current.x;
            int y = current.y;

            if (!visited[x][y]) {
                visited[x][y] = true;

                int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
                shuffleArray(directions); // Acak urutan arah

                for (int[] dir : directions) {
                    int nx = x + dir[0] * 2;
                    int ny = y + dir[1] * 2;

                    if (isValid(nx, ny, visited)) {
                        // Buat jalur
                        ITile pathTile = tileFactory.createTile(TileType.NORMALPOINT, new Point(x + dir[0], y + dir[1]));
                        board.setTile(x + dir[0], y + dir[1], pathTile);

                        // Tambahkan ke stack
                        stack.push(new Point(nx, ny));
                    }
                }
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
        ITile tile = tileFactory.createTile(type, new Point(x, y));
        board.setTile(x, y, tile);
        return new int[] { x, y };
    }

    private void addCheckpoints(IBoard board, int[] start, int[] finish) {
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int x = current[0];
            int y = current[1];

            // Tambahkan CHECKPOINT dengan probabilitas
            if (random.nextDouble() < 0.2) {
                ITile checkpointTile = tileFactory.createTile(TileType.CHECKPOINT, new Point(x, y));
                board.setTile(x, y, checkpointTile);
            }

            // Dorong tetangga yang merupakan bagian dari jalur valid
            for (int[] dir : new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } }) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (isWithinBounds(nx, ny, board) && board.getTile(nx, ny).getType().equals(TileType.NORMALPOINT)) {
                    stack.push(new int[] { nx, ny });
                }
            }
        }
    }

    private void fillWithDangerTiles(IBoard board) {
        for (int i = 0; i < board.getHeight(); i++) {
            for (int j = 0; j < board.getWidth(); j++) {
                ITile tile = board.getTile(i, j);
                if (tile.getType().equals(TileType.NORMALPOINT) && random.nextDouble() < 0.1) {
                    ITile dangerTile = tileFactory.createTile(TileType.DANGERPOINT, new Point(i, j));
                    board.setTile(i, j, dangerTile);
                }
            }
        }
    }

    private boolean isWithinBounds(int x, int y, IBoard board) {
        return x >= 0 && x < board.getHeight() && y >= 0 && y < board.getWidth();
    }
}
