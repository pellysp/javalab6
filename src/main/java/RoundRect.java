import javax.swing.*;
import java.awt.*;

/**
 * The type Round rect.
 */
public class RoundRect extends JPanel {
    /**
     * The Color.
     */
    Color color;
    /**
     * The Arc width.
     */
    int arcWidth;
    /**
     * The Arc height.
     */
    int arcHeight;

    /**
     * Instantiates a new Round rect.
     *
     * @param color     the color
     * @param arcWidth  the arc width
     * @param arcHeight the arc height
     */
    public RoundRect(Color color, int arcWidth, int arcHeight) {
        this.color = color;
        this.arcHeight = arcHeight;
        this.arcWidth = arcWidth;
    }

    /**
     * Gets arc height.
     *
     * @return the arc height
     */
    public int getArcHeight() {
        return arcHeight;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.color);
        g.drawRoundRect(150, 30, 100, 100, this.arcWidth, this.arcHeight);
    }
}
