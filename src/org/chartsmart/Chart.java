package org.chartsmart;

import javax.swing.*;
import java.awt.*;

public class Chart extends JPanel {

    public static final String SINGLE_MODE = "rpfll";
    public static final int BAR = 406;
    public static final String COMPARE_MODE = "shareddisplay";
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

    public void paint(Graphics chart) {
        if (type == BAR) {
            if (mode.equals(SINGLE_MODE)) {
                chart.setColor(Color.RED);
                chart.fillRect(100, 90, getWidth() - 200, 420);
            } else {
                chart.setColor(Color.BLACK);
                chart.fillRect(95, 95, 210, 210);
            }
        } else {
            if (mode.equals(SINGLE_MODE)) {
                chart.setColor(Color.BLUE);
                chart.fillOval(100, 100, 450, getHeight() - 150);
            } else {
                chart.setColor(Color.BLUE);
                chart.fillOval(100, 100, 225, 225);
            }
        }
        String[] barChartText = new String[2];
        String[] pieChartText = new String[2];
        if (type == BAR) {
            barChartText[0] = "Bar Chart";
            if (!mode.equals(SINGLE_MODE)) {
                barChartText[1] = "Small";
            }
        } else {
            if (!mode.equals(SINGLE_MODE)) {
                pieChartText[0] = "Pie Chart";
                pieChartText[1] = "Small";
            }
        }
        Font font;
        if (type == BAR) {
            if (mode.equals(COMPARE_MODE)) {
                font = new Font("Arial Black", Font.BOLD, 25);
                chart.setColor(Color.CYAN);
                int bottomY = 300;
                chart.fillRect(100, bottomY - 100, 40, 100);
                chart.fillRect(140, bottomY - 200, 40, 200);
                chart.fillRect(180, bottomY - 150, 40, 150);
                chart.fillRect(220, bottomY - 125, 40, 125);
                chart.fillRect(260, bottomY - 170, 40, 170);
                chart.setColor(Color.RED);
                chart.setFont(font);
                chart.drawString(barChartText[0], 130, 250);
                chart.drawString(barChartText[1], 130, 270);
            } else {
                int bottomY = 500;
                chart.setColor(Color.CYAN);
                chart.fillRect(112, bottomY - 200, 75, 200);
                chart.fillRect(187, bottomY - 400, 75, 400);
                chart.fillRect(262, bottomY - 300, 75, 300);
                chart.fillRect(337, bottomY - 250, 75, 250);
                chart.fillRect(412, bottomY - 340, 75, 340);
                font = new Font("Arial Black", Font.BOLD, 55);
                chart.setColor(Color.BLACK);
                chart.setFont(font);
                chart.drawString(barChartText[0], 130, 400);
            }
        } else {
            if (mode.equals(SINGLE_MODE)) {
                font = new Font("Bookman Old Style", Font.BOLD, 55);
                chart.setColor(Color.WHITE);
                chart.setFont(font);
                chart.drawString("Pie Chart", 200, 340);
            } else {
                font = new Font("Bookman Old Style", Font.BOLD, 30);
                chart.setFont(font);
                chart.setColor(Color.WHITE);
                chart.drawString(pieChartText[0], 145, 205);
                chart.drawString(pieChartText[1], 170, 235);
            }
        }
        if (getTitle().contains("daily")) {
            try {
                repaint(200);
            } catch (Throwable e) {
                repaint();
            }
        }
    }
}
