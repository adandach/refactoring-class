package org.chartsmart;

import java.awt.*;

interface Chart {
    String SINGLE_MODE = "rpfll";

    int BAR_CHART_TYPE = 406;

    static Chart create(int chartType, String mode) {
        if (chartType == BAR_CHART_TYPE) {
            return new BarChart(mode);
        } else {
            return new PieChart(mode);
        }
    }

    void paint(Graphics canvas, int height, int i);

    String getTitle();
}
