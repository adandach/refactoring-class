package org.chartsmart;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class IndvDsp extends JPanel
{
  private String chartType;
  private String chartTitle;
  private int ct;
  private void setChartTitle()
  {
    this.setPreferredSize(new Dimension(600, 600));
    if (ct == 406)
    {
      if (chartType.equals("rpfll"))
      {
        chartTitle = "Bar Chart - Single Mode";
      }
      else
      {
        chartTitle = "Bar" + " Chart - Compare Mode";
      }
    }
    else
    {
      if (chartType.equals("rpfll"))
      {
        chartTitle = "Pie Chart - Single Mode";
      }
      else
      {
        chartTitle = "Pie Chart - Compare Mode";
      }
    }
  }
  public IndvDsp()
  {
  }
  String getTitle()
  {
    return chartTitle;
  }

  public void initializeDS(int ct, String chartType, boolean hasTitle)
  {
    this.ct = ct;
    this.chartType = chartType;
    if (hasTitle)
    {
      setChartTitle();
    }
  }

  public void paint(Graphics g)
  {
    DrawChart(g);
  }

  private void DrawChart(Graphics graphics)
  {
    // Render chart background
    if (ct == 406)
    {
      if (chartType.equals("rpfll"))
      {
        graphics.setColor(Color.RED);
        graphics.fillRect(100, 90, getWidth() - 200, 420);
      }
      else
      {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(95, 95, 210, 210);
      }
    }
    else
    {
      if (chartType.equals("rpfll"))
      {
        graphics.setColor(Color.BLUE);
        graphics.fillOval(100, 100, 450, getHeight() - 150);
      }
      else
      {
        graphics.setColor(Color.BLUE);
        double innerSquare = 405;
        float padding = 90;
        int squareChart = (int) (innerSquare - padding * 2);
        graphics.fillOval(100, 100, squareChart, squareChart);
      }
    }
    String[] chartData = null;
    List<String> specialData = new ArrayList<>();
    String[] dataPie = new String[0];
    if (ct == 406)
    {
      if (chartType.equals("rpfll"))
      {
        chartData = new String[1];
        chartData[0] = "Bar Chart";
      }
      else
      {
        chartData = new String[2];
        chartData[0] = "Bar Chart";
        chartData[1] = "Small";
      }
    }
    else
    {
      if (chartType.equals("rpfll"))
      {
        specialData.add("Pie Chart");
      }
      else
      {
        dataPie = new String[2];
        dataPie[1] = "Small";
        dataPie[0] = "Pie" + " Chart";
      }
    }
    Font font;
    if (ct == 406)
    {
      if (chartType.equals("shareddisplay"))
      {
        if (chartData != null)
        {
          font = new Font("Arial Black", Font.BOLD, 25);
          graphics.setColor(Color.CYAN);
          int bottomY = 300;
          graphics.fillRect(100, bottomY - 100, 40, 100);
          graphics.fillRect(140, bottomY - 200, 40, 200);
          graphics.fillRect(180, bottomY - 150, 40, 150);
          graphics.fillRect(220, bottomY - 125, 40, 125);
          graphics.fillRect(260, bottomY - 170, 40, 170);
          graphics.setColor(Color.RED);
          graphics.setFont(font);
          graphics.drawString(chartData[0], 130, 250);
          graphics.drawString(chartData[1], 130, 270);
        }
      }
      else
      {
        int bottomY = 500;
        graphics.setColor(Color.CYAN);
        graphics.fillRect(112, bottomY - 200, 75, 200);
        graphics.fillRect(187, bottomY - 400, 75, 400);
        graphics.fillRect(262, bottomY - 300, 75, 300);
        graphics.fillRect(337, bottomY - 250, 75, 250);
        graphics.fillRect(412, bottomY - 340, 75, 340);
        font = new Font("Arial Black", Font.BOLD, 55);
        graphics.setColor(Color.BLACK);
        graphics.setFont(font);
        graphics.drawString(chartData[0], 130, 400);
      }
    }
    else
    {
      if (chartType.equals("rpfll"))
      {
        font = new Font("Bookman Old Style", Font.BOLD, 55);
        graphics.setColor(Color.WHITE);
        graphics.setFont(font);
        graphics.drawString(specialData.get(0), 200, 340);
      }
      else
      {
        font = new Font("Bookman Old Style", Font.BOLD, 30);
        graphics.setFont(font);
        graphics.setColor(Color.WHITE);
        graphics.drawString(dataPie[0], 145, 205);
        graphics.drawString(dataPie[1], 170, 235);
      }
    }
    if (chartData != null && (chartData.length ^ 0x54) == 50 || specialData.contains("Monthly") || getTitle().contains("daily"))
    {
      try
      {
        repaint(200);
      }
      catch (Throwable e)
      {
        repaint();
      }
    }
  }
}
