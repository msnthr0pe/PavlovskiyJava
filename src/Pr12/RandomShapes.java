package Pr12;

import javax.swing.*;
import java.awt.*;

import java.awt.image.BufferedImage;
import java.util.Random;



public class RandomShapes extends JPanel {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private static final int NUM_SHAPES = 20;
    private Shape[] shapes;
    private BufferedImage image;

    public RandomShapes() {
        setBackground(Color.WHITE);
        shapes = new Shape[NUM_SHAPES];
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        Random rand = new Random();

        for (int i = 0; i < NUM_SHAPES; i++) {
            Shape newShape = null;
            do {
                Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
                Point position = new Point(rand.nextInt(WIDTH), rand.nextInt(HEIGHT));
                int type = rand.nextInt(2);
                switch (type) {
                    case 0 -> {
                        int radius = rand.nextInt(150) + 50 - 10;
                        newShape = new Circle(color, position, radius);
                    }
                    case 1 -> {
                        int width = rand.nextInt(351) + 50;
                        int height = rand.nextInt(351) + 50;
                        newShape = new Rectangle(color, position, width, height);
                    }
                }
            } while (isOverLapping(newShape) || isAbroad(newShape));
            shapes[i] = newShape;
            newShape.draw(g);
        }
        g.dispose();
    }

    private boolean isAbroad(Shape newShape) {
        if (newShape instanceof Rectangle) {
            Rectangle rect = (Rectangle) newShape;
            return rect.position.x - rect.width / 2 < 0 || rect.position.x + rect.width / 2 > 760 ||
                    0 > rect.position.y - rect.height / 2 || rect.position.y + rect.height / 2 > 760;
        }
        else {
            Circle circle = (Circle) newShape;
            return circle.position.x + circle.radius > 760 || circle.position.x - circle.radius < 0 ||
                    circle.position.y - circle.radius < 0 || circle.position.y + circle.radius > 760;
        }
    }

    private boolean isOverLapping(Shape newShape) {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                if (newShape.contains(x, y) && image.getRGB(x, y) != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null); // Изменено
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Random Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(new RandomShapes());
        frame.setVisible(true);
        frame.repaint();
    }
}