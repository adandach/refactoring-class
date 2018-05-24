package org.chartsmart.tests;

import org.approvaltests.Approvals;
import org.approvaltests.reporters.DelayedClipboardReporter;
import org.approvaltests.reporters.UseReporter;
import org.chartsmart.Chart;
import org.chartsmart.MainWindow;
import org.junit.Test;

@UseReporter(DelayedClipboardReporter.class)
public class ChartSmartTest {
    @Test
    public void testRun() {
        MainWindow chartSmart = new MainWindow();
        Approvals.verify(chartSmart);
    }

    @Test
    public void testBarChart() {
        Chart cw = new Chart();
        cw.initialize(406, "rpfll", true);
        Approvals.verify(cw);
    }

    @Test
    public void testBarChartCompare() {
        Chart cw = new Chart();
        cw.initialize(406, "shareddisplay", true);
        Approvals.verify(cw);
    }

    @Test
    public void testPieChart() {
        Chart cw = new Chart();
        cw.initialize(323, "rpfll", true);
        Approvals.verify(cw);
    }

    @Test
    public void testPieChartCompare() {
        Chart cw = new Chart();
        cw.initialize(323, "shareddisplay", true);
        Approvals.verify(cw);
    }
}
