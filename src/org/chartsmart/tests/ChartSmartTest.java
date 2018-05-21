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
    cw.initialize(406, "rpfll", true);
    Approvals.verify(cw);
  }
  public void testBarChartCompare() throws Exception
  {
    Chart cw = new Chart();
    cw.initialize(406, "shareddisplay", true);
    Approvals.verify(cw);
  }
  public void testPieChart() throws Exception
  {
    Chart cw = new Chart();
    cw.initialize(323, "rpfll", true);
    Approvals.verify(cw);
  }
  public void testPieChartCompare() throws Exception
  {
    Chart cw = new Chart();
    cw.initialize(323, "shareddisplay", true);
    Approvals.verify(cw);
  }
}
