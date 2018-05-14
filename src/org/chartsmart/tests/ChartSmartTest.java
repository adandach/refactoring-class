package org.chartsmart.tests;

import org.approvaltests.Approvals;
import org.approvaltests.reporters.DelayedClipboardReporter;
import org.approvaltests.reporters.UseReporter;
import org.chartsmart.IndividualDisplay;
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
        IndividualDisplay cw = new IndividualDisplay();
        cw.initializeDisplayArea(406, "rpfll", true);
        Approvals.verify(cw);
    }

    @Test
    public void testBarChartCompare() throws Exception {
        IndividualDisplay cw = new IndividualDisplay();
        cw.initializeDisplayArea(406, "shareddisplay", true);
        Approvals.verify(cw);
    }

    @Test
    public void testPieChart() throws Exception {
        IndividualDisplay cw = new IndividualDisplay();
        cw.initializeDisplayArea(323, "rpfll", true);
        Approvals.verify(cw);
    }

    @Test
    public void testPieChartCompare() throws Exception {
        IndividualDisplay cw = new IndividualDisplay();
        cw.initializeDisplayArea(323, "shareddisplay", true);
        Approvals.verify(cw);
    }
}