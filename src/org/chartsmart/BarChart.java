package org.chartsmart;

import java.awt.*;

class BarChart implements Chart {
    private Mode mode;

    BarChart(String comparisonMode) {
        if (comparisonMode.equals(SINGLE_MODE)) {
            mode = new SingleMode();
        } else {
            mode = new CompareMode();
        }
    }

    private void paintTitle(Graphics canvas) {
        mode.colorRect(canvas);
        mode.drawTitle(canvas);
    }

    private void paintBackground(Graphics canvas, int width) {
        mode.paintBackground(canvas, width);
    }

    public void paint(Graphics canvas, int width, int height) {
        paintBackground(canvas, width);
        paintTitle(canvas);
    }

    public String getTitle() {
        return "Bar Chart - " + mode.title();
    }

    private interface Mode {
        void colorRect(Graphics canvas);

        void drawTitle(Graphics canvas);

        void paintBackground(Graphics canvas, int width);

        String title();
    }

    private class SingleMode implements Mode {
        public void colorRect(Graphics canvas) {
            int bottomY = 500;
            canvas.setColor(Color.CYAN);
            canvas.fillRect(112, bottomY - 200, 75, 200);
            canvas.fillRect(187, bottomY - 400, 75, 400);
            canvas.fillRect(262, bottomY - 300, 75, 300);
            canvas.fillRect(337, bottomY - 250, 75, 250);
            canvas.fillRect(412, bottomY - 340, 75, 340);
        }

        public void drawTitle(Graphics canvas) {
            canvas.setColor(Color.BLACK);
            canvas.setFont(new Font("Arial Black", Font.BOLD, 55));
            canvas.drawString("Bar Chart", 130, 400);
        }

        public void paintBackground(Graphics canvas, int width) {
            canvas.setColor(Color.RED);
            canvas.fillRect(100, 90, width - 200, 420);
        }

        public String title() {
            return "Single Mode";
        }
    }

    private class CompareMode implements Mode {
        public void colorRect(Graphics canvas) {
            int bottomY = 300;
            canvas.setColor(Color.CYAN);
            canvas.fillRect(100, bottomY - 100, 40, 100);
            canvas.fillRect(140, bottomY - 200, 40, 200);
            canvas.fillRect(180, bottomY - 150, 40, 150);
            canvas.fillRect(220, bottomY - 125, 40, 125);
            canvas.fillRect(260, bottomY - 170, 40, 170);
        }

        public void drawTitle(Graphics canvas) {
            canvas.setColor(Color.RED);
            canvas.setFont(new Font("Arial Black", Font.BOLD, 25));
            canvas.drawString("Bar Chart", 130, 250);
            canvas.drawString("Small", 130, 270);
        }

        public void paintBackground(Graphics canvas, int width) {
            canvas.setColor(Color.BLACK);
            canvas.fillRect(95, 95, 210, 210);
        }

        public String title() {
            return "Compare Mode";
        }
    }
}
