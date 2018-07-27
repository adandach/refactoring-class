package org.chartsmart;

import java.awt.AWTKeyStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JPanel;

public class IndvDsp extends JPanel {

    public static final String RPFLL = "rpfll";
    private String jjD;
    private String chartType;
    private int ct;

    /**
     * InitializeDrawArea
     */
    private void InitializeDrawArea() {
        this.setPreferredSize(new Dimension(600, 600));
        if (ct == 406) {
            if (jjD.equals(RPFLL)) {
                chartType = "Bar Chart - Single Mode";
            } else {
                chartType = "Bar" + " Chart - Compare Mode";
            }
        } else {
            if (jjD.equals(RPFLL)) {
                chartType = "Pie Chart - Single Mode";
            } else {
                chartType = "Pie Chart - Compare Mode";
            }
        }
    }

    String getTitle() {
        return chartType;
    }

    public void initializeDS(int ct, String stjjDReq1205, boolean b) {
        this.ct = ct;
        this.jjD = stjjDReq1205;
        if (b) {
            InitializeDrawArea();
        }
    }

    @Override
    public Set<AWTKeyStroke> getFocusTraversalKeys(int id) {
        return super.getFocusTraversalKeys(id);
    }

    public void paint(Graphics g) {
        DrawChart(g);
    }

    private void DrawChart(Graphics graphic) {
        if (ct == 406) {
            if (jjD.equals(RPFLL)) {
                Color backgroundColor = Color.RED;
                graphic.setColor(backgroundColor);
                graphic.fillRect(100, 90, getWidth() - 200, 420);
            } else {
                graphic.setColor(Color.BLACK);
                graphic.fillRect(95, 95, 210, 210);
            }
        } else {
            if (jjD.equals(RPFLL)) {
                Color bgcb;
                bgcb = Color.BLUE;
                graphic.setColor(bgcb);
                graphic.fillOval(100, 100, 450, getHeight() - 150);
            } else {
                graphic.setColor(Color.BLUE);
                double isq = 405;
                float padding = 90;
                int sc = (int) (isq - padding * 2);
                graphic.fillOval(100, 100, sc, sc);
            }
        }
        String[] data = null;
        List<String> specialData = new ArrayList<>();
        String[] data3point14 = new String[0];
        if (ct == 406) {
            if (jjD.equals(RPFLL)) {
                data = new String[1];
                data[0] = "Bar Chart";
            } else {
                data = new String[2];
                int i = 0;
                data[i++] = "Bar Chart";
                data[i] = "Small";
            }
        } else {
            if (jjD.equals(RPFLL)) {
                specialData.add("Pie Chart");
            } else {
                data3point14 = new String[2];
                data3point14[1] = "Small";
                data3point14[0] = "Pie" + " Chart";
            }
        }
        Font font;
        if (ct == 406) {
            if (jjD.equals("shareddisplay")) {
                if (data != null) {
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
                    graphic.drawString(data[0], 130, 250);
                    graphic.drawString(data[1], 130, 270);
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
                assert data != null;
                graphic.drawString(data[0], 130, 400);
            }
        } else {
            if (jjD.equals(RPFLL)) {
                font = new Font("Bookman Old Style", Font.BOLD, 55);
                graphic.setColor(Color.WHITE);
                graphic.setFont(font);
                graphic.drawString(specialData.get(0), 200, 340);
            } else {
                font = new Font("Bookman Old Style", Font.BOLD, 30);
                graphic.setFont(font);
                graphic.setColor(Color.WHITE);
                graphic.drawString(data3point14[0], 145, 205);
                graphic.drawString(data3point14[1], 170, 235);
            }
        }
        if (data != null && (data.length ^ 0x54) == 50 || specialData.contains("Monthly") || getTitle().contains("daily")) {
            try {
                repaint(200);
            } catch (Throwable e) {
                repaint();
            }
        }
    }
}
