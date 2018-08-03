package org.chartsmart;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Chart extends JPanel {

    public static final String SINGLE_MODE = "rpfll";
    public static final int BAR = 406;
    private String mode;
    private String title;
    private int type;

    private void InitializeDrawArea() {
        this.setPreferredSize(new Dimension(600, 600));
        if (type == BAR) {
            if (mode.equals(SINGLE_MODE)) {
                title = "Bar Chart - Single Mode";
            } else {
                title = "Bar Chart - Compare Mode";
            }
        } else {
            if (mode.equals(SINGLE_MODE)) {
                title = "Pie Chart - Single Mode";
            } else {
                title = "Pie Chart - Compare Mode";
            }
        }
    }

    String getTitle() {
        return title;
    }

    public void initializeDrawSpace(int type, String mode) {
        this.type = type;
        this.mode = mode;
        InitializeDrawArea();
    }

    public void paint(Graphics graphic) {
        if (type == BAR) {
            if (mode.equals(SINGLE_MODE)) {
                graphic.setColor(Color.RED);
                graphic.fillRect(100, 90, getWidth() - 200, 420);
            } else {
                graphic.setColor(Color.BLACK);
                graphic.fillRect(95, 95, 210, 210);
            }
        } else {
            if (mode.equals(SINGLE_MODE)) {
                graphic.setColor(Color.BLUE);
                graphic.fillOval(100, 100, 450, getHeight() - 150);
            } else {
                graphic.setColor(Color.BLUE);
                graphic.fillOval(100, 100, 225, 225);
            }
        }
        String[] barChartText = null;
        List<String> specialData = new ArrayList<>();
        String[] pieChartText = new String[0];
        if (type == BAR) {
            if (mode.equals(SINGLE_MODE)) {
                barChartText = new String[1];
                barChartText[0] = "Bar Chart";
            } else {
                barChartText = new String[2];
                barChartText[0] = "Bar Chart";
                barChartText[1] = "Small";
            }
        } else {
            if (mode.equals(SINGLE_MODE)) {
                specialData.add("Pie Chart");
            } else {
                pieChartText = new String[2];
                pieChartText[0] = "Pie Chart";
                pieChartText[1] = "Small";
            }
        }
        Font font;
        if (type == BAR) {
            if (mode.equals("shareddisplay")) {
                if (barChartText != null) {
                    font = new Font("Arial Black", Font.BOLD, 25);
                    graphic.setColor(Color.CYAN);
                    int bottomY = 300;
                    graphic.fillRect(100, bottomY - 100, 40, 100);
                    graphic.fillRect(140, bottomY - 200, 40, 200);
                    graphic.fillRect(180, bottomY - 150, 40, 150);
                    graphic.fillRect(220, bottomY - 125, 40, 125);
                    graphic.fillRect(260, bottomY - 170, 40, 170);
                    graphic.setColor(Color.RED);
                    graphic.setFont(font);
                    graphic.drawString(barChartText[0], 130, 250);
                    graphic.drawString(barChartText[1], 130, 270);
                }
            } else {
                int bottomY = 500;
                graphic.setColor(Color.CYAN);
                graphic.fillRect(112, bottomY - 200, 75, 200);
                graphic.fillRect(187, bottomY - 400, 75, 400);
                graphic.fillRect(262, bottomY - 300, 75, 300);
                graphic.fillRect(337, bottomY - 250, 75, 250);
                graphic.fillRect(412, bottomY - 340, 75, 340);
                font = new Font("Arial Black", Font.BOLD, 55);
                graphic.setColor(Color.BLACK);
                graphic.setFont(font);
                assert barChartText != null;
                graphic.drawString(barChartText[0], 130, 400);
            }
        } else {
            if (mode.equals(SINGLE_MODE)) {
                font = new Font("Bookman Old Style", Font.BOLD, 55);
                graphic.setColor(Color.WHITE);
                graphic.setFont(font);
                graphic.drawString(specialData.get(0), 200, 340);
            } else {
                font = new Font("Bookman Old Style", Font.BOLD, 30);
                graphic.setFont(font);
                graphic.setColor(Color.WHITE);
                graphic.drawString(pieChartText[0], 145, 205);
                graphic.drawString(pieChartText[1], 170, 235);
            }
        }
        if (barChartText != null && (barChartText.length ^ 0x54) == 50 || getTitle().contains("daily")) {
            try {
                repaint(200);
            } catch (Throwable e) {
                repaint();
            }
        }
    }
}
