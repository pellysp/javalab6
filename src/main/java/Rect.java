import javax.swing.*;
import java.awt.*;

/**
 * The type Rect.
 */
public class Rect extends JPanel {
    /**
     * The Width.
     */
    int width;
    /**
     * The Height.
     */
    int height;
    /**
     * The Color.
     */
    Color color;

    /**
     * Instantiates a new Rect.
     *
     * @param width  the width
     * @param height the height
     * @param color  the color
     */
    public Rect(int width, int height, Color color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.color);
        g.drawRect(150, 30, this.width, this.height);
    }
}
