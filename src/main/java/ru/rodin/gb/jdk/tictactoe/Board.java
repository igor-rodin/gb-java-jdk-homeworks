package ru.rodin.gb.jdk.tictactoe;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Random;

import javax.swing.JPanel;

public class Board extends JPanel {

    private static final String MSG_HUMAN_WIN = "Вы победили!";
    private static final String MSG_AI_WIN = "Компьютер победил!";
    private static final String MSG_DRAW = "Ничья!";

    private static final Random RANDOM = new Random();
    private final int SYMBOL_PADDING = 8;
    private int panelWidth;
    private int panelHeight;
    private int cellWidth;
    private int cellHeight;
    private int boardSize;
    private int lastX;
    private int lastY;

    private CellState firstTurn = CellState.AI_DOT;

    private boolean isGameOver = false;
    private WinGameState winGameState;

    enum CellState {
        HUMAN_DOT,
        AI_DOT,
        Emty,
    };

    enum WinGameState {
        HUMAN,
        AI,
        DRAW,
    }

    private CellState[][] board;

    Board() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
    }

    private void initBoard() {
        board = new CellState[this.boardSize][this.boardSize];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = CellState.Emty;
            }
        }
    }

    private boolean isCellValid(int x, int y) {
        return x >= 0 && x < boardSize && y >= 0 && y < boardSize;
    }

    private boolean isCellEmpty(int x, int y) {
        return board[y][x] == CellState.Emty;
    }

    private CellState getCellState(int x, int y) {
        return board[y][x];
    }

    private void aiTurn() {
        int x = RANDOM.nextInt(boardSize);
        int y = RANDOM.nextInt(boardSize);
        while (!isCellEmpty(x, y)) {
            x = RANDOM.nextInt(boardSize);
            y = RANDOM.nextInt(boardSize);
        }
        lastX = x;
        lastY = y;
        board[y][x] = CellState.AI_DOT;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j] == CellState.Emty) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isWin(int lastX, int lastY, CellState player) {
        if (lastX == lastY && diagonalIsWin(player)) {
            return true;
        }

        if (lastX + lastY == boardSize - 1 && reverseDiagonalIsWin(player)) {
            return true;
        }

        if (rowIsWin(lastY, player))
            return true;
        if (columnIsWin(lastX, player))
            return true;

        return false;
    }

    private boolean rowIsWin(int row, CellState player) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean columnIsWin(int column, CellState player) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean diagonalIsWin(CellState player) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean reverseDiagonalIsWin(CellState player) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][boardSize - 1 - i] != player) {
                return false;
            }
        }
        return true;
    }

    void startNewGame(int gameMode, int boardSize) {
        this.boardSize = boardSize;
        initBoard();
        System.out.println("startNewGame: " + gameMode + " " + boardSize);

        if (firstTurn == CellState.AI_DOT) {
            aiTurn();
        }
        repaint();
    }

    private void render(Graphics2D g) {
        g.setPaint(Color.DARK_GRAY);
        g.setStroke(new BasicStroke(1.5f));
        panelWidth = getWidth();
        panelHeight = getHeight();
        cellWidth = panelWidth / boardSize;
        cellHeight = panelHeight / boardSize;

        for (int i = 0; i < boardSize; i++) {
            g.draw(new Line2D.Double(0, i * cellHeight, panelWidth, i * cellHeight));
            g.draw(new Line2D.Double(i * cellWidth, 0, i * cellWidth, panelHeight));
        }

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < board.length; j++) {
                switch (getCellState(i, j)) {
                    case HUMAN_DOT:
                        paintCrosAt(i, j, g);
                        break;
                    case AI_DOT:
                        paintZeroAt(i, j, g);
                        break;
                    case Emty:
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + getCellState(i, j));
                }
            }
        }

        if (isGameOver) {
            paintWinMesage(g);
        }
        repaint();
    }

    private void paintWinMesage(Graphics2D g) {
        g.setPaint(Color.DARK_GRAY);
        g.fillRect(0, 200, panelWidth, 70);
        g.setPaint(Color.YELLOW);
        g.setFont(new Font("Arial", Font.BOLD, 46));

        switch (winGameState) {
            case HUMAN:
                g.drawString(MSG_HUMAN_WIN, 70, panelHeight / 2);
                break;
            case AI:
                g.drawString(MSG_AI_WIN, 20, panelHeight / 2);
                break;
            case DRAW:
                g.drawString(MSG_DRAW, 180, panelHeight / 2);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + winGameState);
        }
    }

    private void paintCrosAt(int x, int y, Graphics2D g) {
        g.setPaint(Color.RED);
        g.setStroke(new BasicStroke(4.0f));
        g.draw(new Line2D.Double(x * cellWidth + SYMBOL_PADDING, y * cellHeight + SYMBOL_PADDING,
                (x + 1) * cellWidth - SYMBOL_PADDING,
                (y + 1) * cellHeight - SYMBOL_PADDING));
        g.draw(new Line2D.Double(x * cellWidth + SYMBOL_PADDING, (y + 1) * cellHeight - SYMBOL_PADDING,
                (x + 1) * cellWidth - SYMBOL_PADDING,
                y * cellHeight + SYMBOL_PADDING));
    }

    private void paintZeroAt(int x, int y, Graphics2D g) {
        g.setPaint(Color.BLUE);
        g.setStroke(new BasicStroke(4.0f));
        g.draw(new Ellipse2D.Double(x * cellWidth + SYMBOL_PADDING, y * cellHeight + SYMBOL_PADDING,
                cellWidth - 2 * SYMBOL_PADDING, cellHeight - 2 * SYMBOL_PADDING));
    }

    public void update(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        if (!isCellValid(cellX, cellY) || !isCellEmpty(cellX, cellY) || isGameOver) {
            return;
        }
        board[cellY][cellX] = CellState.HUMAN_DOT;
        this.lastX = cellX;
        this.lastY = cellY;
        System.out.println("update: " + lastX + " " + lastY);
        if (checkEndGame(lastX, lastY, CellState.HUMAN_DOT)) {
            return;
        }
        aiTurn();
        if (checkEndGame(lastX, lastY, CellState.AI_DOT)) {
            return;
        }
        repaint();
    }

    private boolean checkEndGame(int x, int y, CellState player) {
        if (isWin(x, y, player)) {
            if (player == CellState.HUMAN_DOT) {
                winGameState = WinGameState.HUMAN;
            } else if (player == CellState.AI_DOT) {
                winGameState = WinGameState.AI;
            }
            isGameOver = true;
            return true;
        }
        if (isBoardFull()) {
            isGameOver = true;
            winGameState = WinGameState.DRAW;
            return true;
        }
        return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        render(g2);
    }

}
