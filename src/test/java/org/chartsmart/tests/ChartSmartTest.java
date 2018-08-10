package org.chartsmart.tests;

import junit.framework.TestCase;

import org.approvaltests.Approvals;
import org.approvaltests.reporters.DelayedClipboardReporter;
import org.approvaltests.reporters.UseReporter;
import org.chartsmart.Chart;
import org.chartsmart.MainWindow;

@UseReporter(DelayedClipboardReporter.class)
public class ChartSmartTest extends TestCase
{
  public void testRun() throws Exception
  {
    MainWindow chartSmart = new MainWindow();
    Approvals.verify(chartSmart);
  }
  public void testBarChart() throws Exception
  {
    Chart cw = new Chart();
    cw.initializeDS(406, "rpfll");
    Approvals.verify(cw);
  }
  public void testBarChartCompare() throws Exception
  {
    Chart cw = new Chart();
    cw.initializeDS(406, "shareddisplay");
    Approvals.verify(cw);
  }
  public void testPieChart() throws Exception
  {
    Chart cw = new Chart();
    cw.initializeDS(323, "rpfll");
    Approvals.verify(cw);
  }
  public void testPieChartCompare() throws Exception
  {
    Chart cw = new Chart();
    cw.initializeDS(323, "shareddisplay");
    Approvals.verify(cw);
  }
}
