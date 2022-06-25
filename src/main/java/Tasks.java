import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The type Tasks.
 */
public class Tasks {

    /**
     * Task 1.
     */
    public static void task1() {
        JFrame frame = new JFrame("Task 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        AtomicInteger width = new AtomicInteger(100);
        AtomicInteger height = new AtomicInteger(100);
        Rect rect = new Rect(width.get(), height.get(), Color.BLACK);
        container.add(BorderLayout.SOUTH, rect);

        JPanel downPanel = new JPanel();

        JLabel colorLabel = new JLabel("Колір");
        String[] colors = new String[]{"Чорний", "Червоний", "Зелений", "Синій"};
        HashMap<String, Color> map = new HashMap<>();
        map.put(colors[0], Color.BLACK);
        map.put(colors[1], Color.RED);
        map.put(colors[2], Color.GREEN);
        map.put(colors[3], Color.BLUE);
        JComboBox colorCB = new JComboBox(colors);
        downPanel.add(colorLabel);
        downPanel.add(colorCB);

        JButton btnLeft = new JButton("Вліво");
        JButton btnUp = new JButton("Вгору");
        JButton btnRight = new JButton("Вправо");
        JButton btnDown = new JButton("Вниз");
        downPanel.add(btnLeft);
        downPanel.add(btnUp);
        downPanel.add(btnRight);
        downPanel.add(btnDown);

        container.add(downPanel);

        frame.add(container);
        frame.setVisible(true);

        btnUp.addActionListener(event -> {
            height.addAndGet(-10);
            container.remove(rect);
            Rect rectNew = new Rect(width.get(), height.get(), map.get(colorCB.getSelectedItem()));
            container.add(rectNew);
            container.revalidate();
        });

        btnDown.addActionListener(event -> {
            height.addAndGet(10);
            container.remove(rect);
            Rect rectNew = new Rect(width.get(), height.get(), map.get(colorCB.getSelectedItem()));
            container.add(rectNew);
            container.revalidate();
        });

        btnRight.addActionListener(event -> {
            width.addAndGet(10);
            container.remove(rect);
            Rect rectNew = new Rect(width.get(), height.get(), map.get(colorCB.getSelectedItem()));
            container.add(rectNew);
            container.revalidate();
        });

        btnLeft.addActionListener(event -> {
            width.addAndGet(-10);
            container.remove(rect);
            Rect rectNew = new Rect(width.get(), height.get(), map.get(colorCB.getSelectedItem()));
            container.add(rectNew);
            container.revalidate();
        });
    }


    /**
     * Task 2.
     */
    static void task2() {
        JFrame frame = new JFrame("Task 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        RoundRect roundRect = new RoundRect(Color.BLACK, 20, 20);
        container.add(BorderLayout.SOUTH, roundRect);

        JPanel downPanel = new JPanel();

        JLabel labelColor = new JLabel("Колір:");
        String[] colors = new String[]{"Чорний", "Червоний", "Зелений", "Синій"};
        HashMap<String, Color> map = new HashMap<>();
        map.put(colors[0], Color.BLACK);
        map.put(colors[1], Color.RED);
        map.put(colors[2], Color.GREEN);
        map.put(colors[3], Color.BLUE);
        JSpinner spinnerColors = new JSpinner(new SpinnerListModel(colors));
        spinnerColors.setBounds(50, 50, 90, 20);
        downPanel.add(labelColor);
        downPanel.add(spinnerColors);

        JLabel labelWidthArc = new JLabel("Ширина заокруглення:");
        JTextField widthArcField = new JTextField(5);
        downPanel.add(labelWidthArc);
        downPanel.add(widthArcField);

        JLabel labelHeightArc = new JLabel("Висота заокруглення:");
        JTextField heightArcField = new JTextField(5);
        downPanel.add(labelHeightArc);
        downPanel.add(heightArcField);

        JButton btn = new JButton("Змінити прямокутник");
        downPanel.add(btn);

        container.add(BorderLayout.PAGE_END, downPanel);

        frame.add(container);
        frame.setVisible(true);

        btn.addActionListener(event -> {
            container.remove(roundRect);
            RoundRect roundRectNew = new RoundRect(map.get(spinnerColors.getValue().toString()), Integer.parseInt(widthArcField.getText()), Integer.parseInt(heightArcField.getText()));
            container.add(roundRectNew);
            container.revalidate();
        });
    }


    /**
     * Task 3.
     */
    public static void task3() {
        JFrame frame = new JFrame("Task 3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JPanel panel = new JPanel();

        JLabel labelColor = new JLabel("Колір");
        panel.add(labelColor);
        ButtonGroup bg1 = new ButtonGroup();
        JRadioButton btnBlack = new JRadioButton("Чорний");
        bg1.add(btnBlack);
        panel.add(btnBlack);
        btnBlack.setForeground(Color.BLACK);
        JRadioButton btnRed = new JRadioButton("Червоний");
        bg1.add(btnRed);
        panel.add(btnRed);
        btnRed.setForeground(Color.RED);
        JRadioButton btnGreen = new JRadioButton("Зелений");
        bg1.add(btnGreen);
        panel.add(btnGreen);
        btnGreen.setForeground(Color.GREEN);
        JRadioButton btnBlue = new JRadioButton("Синій");
        bg1.add(btnBlue);
        panel.add(btnBlue);
        btnBlue.setForeground(Color.BLUE);

        JTextField sizeField = new JTextField(5);
        sizeField.setText("12");
        panel.add(sizeField);

        container.add(panel);

        JTextPane pane = new JTextPane();
        pane.setText("12");

        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, pane);
        frame.setVisible(true);

        String regex = "^\\d{1,2}$";

        btnBlack.addActionListener(event -> {
            if (isNumeric(sizeField.getText()) && sizeField.getText().matches(regex)) {
                pane.setForeground(Color.BLACK);
                pane.setFont(new Font("Verdana", Font.PLAIN, Integer.parseInt(sizeField.getText())));
            }
        });
        btnRed.addActionListener(event -> {
            if (isNumeric(sizeField.getText()) && sizeField.getText().matches(regex)) {
                pane.setForeground(Color.RED);
                pane.setFont(new Font("Verdana", Font.PLAIN, Integer.parseInt(sizeField.getText())));
            }
        });
        btnGreen.addActionListener(event -> {
            if (isNumeric(sizeField.getText()) && sizeField.getText().matches(regex)) {
                pane.setForeground(Color.GREEN);
                pane.setFont(new Font("Verdana", Font.PLAIN, Integer.parseInt(sizeField.getText())));
            }
        });
        btnBlue.addActionListener(event -> {
            System.out.println(isNumeric(sizeField.getText()));
            System.out.println(sizeField.getText().matches(regex));
            if (isNumeric(sizeField.getText()) && sizeField.getText().matches(regex)) {
                pane.setForeground(Color.BLUE);
                pane.setFont(new Font("Verdana", Font.PLAIN, Integer.parseInt(sizeField.getText())));
            }
        });
    }

    /**
     * Is numeric boolean.
     *
     * @param string the string
     * @return the boolean
     */
    public static boolean isNumeric(String string) {
        int intValue;

        if (string == null || string.equals("")) {
            System.out.println("String cannot be parsed, it is null or empty.");
            return false;
        }

        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }

    /**
     * Task 4.
     */
    static void task4() {
        JFrame frame = new JFrame("Task 4");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(340, 400);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JPanel upperPanel = new JPanel();

        String[] sizes = new String[101];
        for (int i = 0; i <= 100; i++) {
            sizes[i] = String.valueOf(i);
        }

        JLabel labelX1 = new JLabel("X1:");
        JSpinner spinnerX1 = new JSpinner(new SpinnerListModel(sizes));
        upperPanel.add(labelX1);
        upperPanel.add(spinnerX1);

        JLabel labelY1 = new JLabel("Y1:");
        JSpinner spinnerY1 = new JSpinner(new SpinnerListModel(sizes));
        upperPanel.add(labelY1);
        upperPanel.add(spinnerY1);

        JLabel labelX2 = new JLabel("X2:");
        JSpinner spinnerX2 = new JSpinner(new SpinnerListModel(sizes));
        upperPanel.add(labelX2);
        upperPanel.add(spinnerX2);

        JLabel labelY2 = new JLabel("Y2:");
        JSpinner spinnerY2 = new JSpinner(new SpinnerListModel(sizes));
        upperPanel.add(labelY2);
        upperPanel.add(spinnerY2);

        JLabel labelX3 = new JLabel("X3:");
        JSpinner spinnerX3 = new JSpinner(new SpinnerListModel(sizes));
        upperPanel.add(labelX3);
        upperPanel.add(spinnerX3);

        JLabel labelY3 = new JLabel("Y3:");
        JSpinner spinnerY3 = new JSpinner(new SpinnerListModel(sizes));
        upperPanel.add(labelY3);
        upperPanel.add(spinnerY3);

        JButton btn = new JButton("Вивести трикутник");
        upperPanel.add(btn);
        container.add(BorderLayout.PAGE_END, upperPanel);

        frame.add(container);
        frame.setVisible(true);
        frame.setVisible(true);

        btn.addActionListener(event -> {
            int x1 = Integer.parseInt(spinnerX1.getValue().toString());
            int y1 = Integer.parseInt(spinnerY1.getValue().toString());
            int x2 = Integer.parseInt(spinnerX2.getValue().toString());
            int y2 = Integer.parseInt(spinnerY2.getValue().toString());
            int x3 = Integer.parseInt(spinnerX3.getValue().toString());
            int y3 = Integer.parseInt(spinnerY3.getValue().toString());
            System.out.println(x1);
            System.out.println(y1);
            System.out.println(x2);
            System.out.println(y2);
            System.out.println(x3);
            System.out.println(y3);
            Polygon polygonNew = new Polygon(new int[]{x1, x2, x3}, new int[]{y1, y2, y3}, Color.BLACK);
            container.add(polygonNew);
            container.revalidate();
        });
    }
}
