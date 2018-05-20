package org.chartsmart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JPanel {
    private JButton showChartButton;
    private JButton showPieOrBarChartButton;
    private JComboBox chartTypeSelector;
    private JComboBox displayTypeSelector;

    private void initializeLayout() {
        this.setPreferredSize(new Dimension(500, 500));
        this.setLayout(null);
        showChartButton = new ShowChartButton(this);
        showPieOrBarChartButton = new ShowPieOrBarChartButton(this);
        chartTypeSelector = new BarOrPieChartSelector(this, showPieOrBarChartButton);
        JButton showDisplayTypeButton = new ShowDisplayTypeButton(this);
        displayTypeSelector = new DisplayTypeSelector(this, showDisplayTypeButton);
    }

    public MainWindow() {
        initializeLayout();
    }

    private void showGui() {
        JFrame frame = new JFrame("ChartSmart, the Smart way to do Charts.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        Insets insets = frame.getInsets();
        frame.setSize(500 + insets.left + insets.right, 500 + insets.top + insets.bottom);
        frame.setLocation(100, 100);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            MainWindow chartSmart = new MainWindow();
            chartSmart.showGui();
        });
    }

    private class ButtonListener implements ActionListener {
        private boolean isSingleDisplayType(Object pressedButton, Object selectedDisplayType) {
            return pressedButton == showChartButton
                    || pressedButton == showPieOrBarChartButton
                    || selectedDisplayType == "Single";
        }

        private String determineDisplayType(ActionEvent e) {
            Object pressedButton = e.getSource();
            Object selectedDisplayType = displayTypeSelector.getSelectedItem();
            if (isSingleDisplayType(pressedButton, selectedDisplayType)) {
                return "rpfll";
            }

            return "shareddisplay";
        }

        private boolean isBarChart(Object pressedButton, Object selectedChartType) {
            return pressedButton == showChartButton || selectedChartType == "Bar Chart";
        }

        private int determineChartType(ActionEvent e) {
            Object pressedButton = e.getSource();
            Object selectedChartType = chartTypeSelector.getSelectedItem();
            if (isBarChart(pressedButton, selectedChartType)) {
                return 406;
            }
            return 323;
        }

        private void display(DisplayCharts chartWindow) {
            JFrame frame = new JFrame();
            frame.getContentPane().add(chartWindow);
            frame.setLocation(150, 150);
            frame.setBackground(new Color(255, 239, 213));
            frame.pack();
            frame.setTitle(chartWindow.getChartTitle());
            frame.setVisible(true);
        }

        public void actionPerformed(ActionEvent e) {
            int chartType = determineChartType(e);
            String displayType = determineDisplayType(e);
            DisplayCharts chartWindow = new DisplayCharts();
            chartWindow.initializeChart(chartType, displayType);
            display(chartWindow);
        }

    }

    private class ShowChartButton extends JButton {
        ShowChartButton(JPanel parent) {
            super("Show Chart");
            this.addActionListener(new ButtonListener());
            Dimension size = this.getPreferredSize();
            Insets insets = parent.getInsets();
            this.setBounds(25 + insets.left, 25 + insets.top, size.width, size.height);
            parent.add(this);

        }
    }

    private class ShowPieOrBarChartButton extends JButton {
        ShowPieOrBarChartButton(JPanel parent) {
            super("Show Pie or Bar");
            this.addActionListener(new ButtonListener());
            Dimension size = this.getPreferredSize();
            Insets insets = parent.getInsets();
            this.setBounds(25 + insets.left, 65 + insets.top, size.width, size.height);
            parent.add(this);
        }
    }

    private class BarOrPieChartSelector extends JComboBox<String> {
        BarOrPieChartSelector(JPanel parent, JButton adjacent) {
            super(new String[]{"Bar Chart", "Pie Chart"});
            Dimension size = adjacent.getPreferredSize();
            this.setBounds(200, 65 + parent.getInsets().top, 200, size.height);
            parent.add(this);
        }
    }

    private class ShowDisplayTypeButton extends JButton {
        ShowDisplayTypeButton(JPanel parent) {
            super("Show Display Type");
            this.addActionListener(new ButtonListener());
            Dimension size = this.getPreferredSize();
            Insets insets = parent.getInsets();
            this.setBounds(25 + insets.left, 105 + insets.top, size.width, size.height);
            parent.add(this);

        }
    }

    private class DisplayTypeSelector extends JComboBox<String> {
        DisplayTypeSelector(JPanel parent, JButton adjacent) {
            super(new String[]{"Single", "Compare"});
            Insets insets = parent.getInsets();
            this.setBounds(200, 105 + insets.top, 200, adjacent.getPreferredSize().height);
            parent.add(this);
        }
    }
}
