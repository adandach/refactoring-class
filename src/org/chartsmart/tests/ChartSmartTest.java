package org.chartsmart.tests;

import org.approvaltests.Approvals;
import org.approvaltests.reporters.DelayedClipboardReporter;
import org.approvaltests.reporters.UseReporter;
import org.chartsmart.DisplayCharts;
import org.chartsmart.MainWindow;
import org.junit.Test;

@UseReporter(DelayedClipboardReporter.class)
public class ChartSmartTest {
    @Test
    public void testRun() throws Exception {
        MainWindow chartSmart = new MainWindow();
        Approvals.verify(chartSmart);
    }

    @Test
    public void testBarChart() throws Exception {
        DisplayCharts cw = new DisplayCharts();
        cw.initializeChart(406, "rpfll");
        Approvals.verify(cw);
    }

    @Test
    public void testBarChartCompare() throws Exception {
        DisplayCharts cw = new DisplayCharts();
        cw.initializeChart(406, "shareddisplay");
        Approvals.verify(cw);
    }

    @Test
    public void testPieChart() throws Exception {
        DisplayCharts cw = new DisplayCharts();
        cw.initializeChart(323, "rpfll");
        Approvals.verify(cw);
    }

    @Test
    public void testPieChartCompare() throws Exception {
        DisplayCharts cw = new DisplayCharts();
        cw.initializeChart(323, "shareddisplay");
        Approvals.verify(cw);
    }
}
