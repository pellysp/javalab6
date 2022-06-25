import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Tests.
 */
class Tests {
    /**
     * Task 1.
     */
    @Test
    @DisplayName("Polygon class test")
    public void task1() {
        Polygon polygon = new Polygon(new int[]{10, 20, 30}, new int[]{10, 20, 10}, Color.BLACK);
        assertEquals(10, polygon.getFirstX());
    }

    /**
     * Task 2.
     */
    @Test
    @DisplayName("Rect class test")
    public void task2() {
        Rect rect = new Rect(100, 100, Color.BLACK);
        assertEquals(Color.BLACK, rect.getColor());
    }

    /**
     * Task 3.
     */
    @Test
    @DisplayName("Round Rect class test")
    public void task3() {
        RoundRect roundRect = new RoundRect(Color.BLACK, 20, 20);
        assertEquals(20, roundRect.getArcHeight());
    }
}