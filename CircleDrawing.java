import javax.swing.*;
import java.awt.*;

public class CircleDrawing extends JFrame {
    private int algorithm = 1; // 1-DDA, 2-Bresenham, 3-Midpoint
    private int style = 1;     // 1-Solid, 2-Dotted, 3-Dashed
    private int xc = 200, yc = 200, r = 100;

    public CircleDrawing() {
        setTitle("Circle Drawing Algorithms");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu algoMenu = new JMenu("Algorithm");
        JMenu styleMenu = new JMenu("Style");

        String[] algorithms = {"DDA", "Bresenham", "Midpoint"};
        String[] styles = {"Solid", "Dotted", "Dashed"};

        // Add algorithm menu items
        for (int i = 0; i < algorithms.length; i++) {
            JMenuItem item = new JMenuItem(algorithms[i]);
            final int idx = i + 1;
            item.addActionListener(e -> { algorithm = idx; repaint(); });
            algoMenu.add(item);
        }

        // Add style menu items
        for (int i = 0; i < styles.length; i++) {
            JMenuItem item = new JMenuItem(styles[i]);
            final int idx = i + 1;
            item.addActionListener(e -> { style = idx; repaint(); });
            styleMenu.add(item);
        }

        menuBar.add(algoMenu);
        menuBar.add(styleMenu);
        setJMenuBar(menuBar);
    }

    public void paint(Graphics g) {
        super.paint(g);
        switch (algorithm) {
            case 1: drawCircleDDA(xc, yc, r, g, style); break;
            case 2: drawCircleBresenham(xc, yc, r, g, style); break;
            case 3: drawCircleMidpoint(xc, yc, r, g, style); break;
        }
    }

    // ----- DDA Algorithm -----
    void drawCircleDDA(int xc, int yc, int r, Graphics g, int style) {
        double step = 1.0 / r;
        int count = 0;
        for (double theta = 0; theta < 2 * Math.PI; theta += step) {
            int x = (int) Math.round(xc + r * Math.cos(theta));
            int y = (int) Math.round(yc + r * Math.sin(theta));
            if (shouldDraw(count, style)) g.drawLine(x, y, x, y);
            count++;
        }
    }

    // ----- Bresenham Algorithm -----
    void drawCircleBresenham(int xc, int yc, int r, Graphics g, int style) {
        int x = 0, y = r, d = 3 - 2 * r;
        int count = 0;
        while (y >= x) {
            drawPoints(xc, yc, x, y, g, count, style);
            x++;
            if (d > 0) {
                y--;
                d = d + 4 * (x - y) + 10;
            } else d = d + 4 * x + 6;
            count++;
        }
    }

    // ----- Midpoint Algorithm -----
    void drawCircleMidpoint(int xc, int yc, int r, Graphics g, int style) {
        int x = 0, y = r;
        int p = 1 - r;
        int count = 0;
        while (x <= y) {
            drawPoints(xc, yc, x, y, g, count, style);
            x++;
            if (p < 0) p += 2 * x + 1;
            else { y--; p += 2 * (x - y) + 1; }
            count++;
        }
    }

    // Draw all 8 symmetrical points
    void drawPoints(int xc, int yc, int x, int y, Graphics g, int count, int style) {
        if (!shouldDraw(count, style)) return;
        g.drawLine(xc + x, yc + y, xc + x, yc + y);
        g.drawLine(xc - x, yc + y, xc - x, yc + y);
        g.drawLine(xc + x, yc - y, xc + x, yc - y);
        g.drawLine(xc - x, yc - y, xc - x, yc - y);
        g.drawLine(xc + y, yc + x, xc + y, yc + x);
        g.drawLine(xc - y, yc + x, xc - y, yc + x);
        g.drawLine(xc + y, yc - x, xc + y, yc - x);
        g.drawLine(xc - y, yc - x, xc - y, yc - x);
    }

    // Determine whether to draw based on style
    boolean shouldDraw(int count, int style) {
        if (style == 1) return true;          // Solid
        if (style == 2) return count % 3 == 0; // Dotted
        if (style == 3) return (count / 5) % 2 == 0; // Dashed
        return true;
    }

    public static void main(String[] args) {
        new CircleDrawing().setVisible(true);
    }
}
