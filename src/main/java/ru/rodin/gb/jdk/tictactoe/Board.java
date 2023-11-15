package ru.rodin.gb.jdk.tictactoe;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

public class Board extends JPanel {
    private int panelWidth;
    private int panelHeight;
    private int cellWidth;
    private int cellHeight;
    private int boardSize;

    void startNewGame(int gameMode, int boardSize) {
        this.boardSize = boardSize;
        System.out.println("startNewGame: " + gameMode + " " + boardSize);
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
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        render(g2);
    }

}
