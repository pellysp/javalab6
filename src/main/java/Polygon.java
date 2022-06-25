import javax.swing.*;
import java.awt.*;

/**
 * The type Polygon.
 */
public class Polygon extends JPanel {

    /**
     * The X.
     */
    int[] x;
    /**
     * The Y.
     */
    int[] y;
    /**
     * The Color.
     */
    Color color;

    /**
     * Instantiates a new Polygon.
     *
     * @param x     the x
     * @param y     the y
     * @param color the color
     */
    public Polygon(int[] x, int[] y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    /**
     * Gets first x.
     *
     * @return the first x
     */
    public int getFirstX() {
        return this.x[0];
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.color);
        g.drawPolygon(this.x, this.y, 3);
    }
}
