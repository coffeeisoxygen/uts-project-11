package com.twentyforseven.model.algorithms;

import java.awt.Point;
import java.util.Random;
import java.util.Stack;

import com.twentyforseven.model.classes.board.IBoard;
import com.twentyforseven.model.classes.tile.ITile;
import com.twentyforseven.model.enumerate.TileType;
import com.twentyforseven.model.factory.ITileFactory;

public class SimpleMapMaze implements IMapRandomAlgo {

    private final Random random = new Random();
    private final ITileFactory tileFactory;

    public SimpleMapMaze(ITileFactory tileFactory) {
        this.tileFactory = tileFactory;
    }

    @Override
    public void constructMap(IBoard board) {
        int height = board.getHeight();
        int width = board.getWidth();

        // Inisialisasi semua tile sebagai NORMALPOINT
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                ITile tile = tileFactory.createTile(TileType.NORMALPOINT, new Point(i, j));
                board.setTile(i, j, tile);
            }
        }

        // Tetapkan STARTPOINT dan FINISHPOINT
        int[] start = placeTile(board, TileType.STARTPOINT);
        int[] finish = placeTile(board, TileType.FINISHPOINT);

        // Buat jalur aman dengan checkpoint
        int safeRoutes = 4; // Jumlah jalur aman
        int checkpointsPerRoute = 3; // Jumlah checkpoint per jalur

        for (int i = 0; i < safeRoutes; i++) {
            generateSafeRoute(board, start, finish, checkpointsPerRoute);
        }

        // Isi sisa tile dengan DANGERPOINT
        fillWithDangerTiles(board);
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

    private void generateSafeRoute(IBoard board, int[] start, int[] finish, int checkpoints) {
        Stack<int[]> path = new Stack<>();
        boolean[][] visited = new boolean[board.getHeight()][board.getWidth()];

        // Mulai dari STARTPOINT
        path.push(start);
        visited[start[0]][start[1]] = true;

        while (!path.isEmpty() && !path.peek().equals(finish)) {
            int[] current = path.peek();
            int x = current[0], y = current[1];

            // Cari tetangga yang belum dikunjungi
            boolean moved = false;
            for (int[] dir : shuffleDirections()) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (isWithinBounds(nx, ny, board) && !visited[nx][ny] &&
                        board.getTile(nx, ny).getType() == TileType.NORMALPOINT) {
                    // Tandai jalan aman
                    ITile safeTile = tileFactory.createTile(TileType.NORMALPOINT, new Point(nx, ny));
                    board.setTile(nx, ny, safeTile);

                    path.push(new int[] { nx, ny });
                    visited[nx][ny] = true;

                    moved = true;

                    // Jika mencapai FINISHPOINT, berhenti
                    if (nx == finish[0] && ny == finish[1]) {
                        break;
                    }
                }
            }

            // Jika tidak ada langkah valid, backtrack
            if (!moved) {
                path.pop();
            }
        }

        // Tambahkan CHECKPOINT secara merata di rute ini
        addCheckpointsAlongPath(board, path, checkpoints);
    }

    private void addCheckpointsAlongPath(IBoard board, Stack<int[]> path, int checkpoints) {
        int step = Math.max(1, path.size() / checkpoints);
        for (int i = 0; i < path.size(); i += step) {
            int[] checkpoint = path.get(i);
            ITile checkpointTile = tileFactory.createTile(TileType.CHECKPOINT, new Point(checkpoint[0], checkpoint[1]));
            board.setTile(checkpoint[0], checkpoint[1], checkpointTile);
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

    private int[][] shuffleDirections() {
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        shuffleArray(directions);
        return directions;
    }

    private void shuffleArray(int[][] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int[] temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    private boolean isWithinBounds(int x, int y, IBoard board) {
        return x >= 0 && x < board.getHeight() && y >= 0 && y < board.getWidth();
    }
}
