package org.chartsmart;

import java.awt.*;

class PieChart implements Chart {
    private Mode mode;

    PieChart(String comparisonMode) {
        if (comparisonMode.equals(SINGLE_MODE)) {
            mode = new SingleMode();
        } else {
            mode = new CompareMode();
        }
    }

    private void paintBackground(Graphics canvas, int height) {
        mode.paintBackground(canvas, height);
    }

    private void drawTitle(Graphics canvas) {
        mode.drawTitle(canvas);
    }

    public void paint(Graphics canvas, int width, int height) {
        paintBackground(canvas, height);
        drawTitle(canvas);
    }

    public String getTitle() {
        return "Pie Chart - " + mode.title();
    }

    private interface Mode {
        void paintBackground(Graphics canvas, int height);

        void drawTitle(Graphics canvas);

        String title();
    }

    private class SingleMode implements Mode {
        public void paintBackground(Graphics canvas, int height) {
            canvas.setColor(Color.BLUE);
            canvas.fillOval(100, 100, 450, height - 150);
        }

        public void drawTitle(Graphics canvas) {
            canvas.setColor(Color.WHITE);
            canvas.setFont(new Font("Bookman Old Style", Font.BOLD, 55));
            canvas.drawString("Pie Chart", 200, 340);
        }

        public String title() {
            return "Single Mode";
        }
    }

    private class CompareMode implements Mode {
        public void paintBackground(Graphics canvas, int height) {
            canvas.setColor(Color.BLUE);
            canvas.fillOval(100, 100, 225, 225);
        }

        public void drawTitle(Graphics canvas) {
            canvas.setColor(Color.WHITE);
            canvas.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
            canvas.drawString("Pie Chart", 145, 205);
            canvas.drawString("Small", 170, 235);
        }

        public String title() {
            return "Compare Mode";
        }
    }
}
