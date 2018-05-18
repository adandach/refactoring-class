package org.chartsmart;

import javax.swing.*;
import java.awt.*;

public class DisplayCharts extends JPanel {
    private Chart chart;

    String getChartTitle() {
        return chart.getTitle();
    }

    public void initializeChart(int chartType, String mode) {
        chart = Chart.create(chartType, mode);
        this.setPreferredSize(new Dimension(600, 600));
    }

    public void paint(Graphics g) {
        chart.paint(g, getWidth(), getHeight());
    }
}
