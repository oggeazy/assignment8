import java.awt.*;

public class Circle extends CollisionObject {
    private int radius;

    public Circle(int x, int y, int radius, Color color) {
        super(x, y, color);
        this.radius = radius;
    }

    @Override
    protected void drawShape(Graphics2D g2d, int x, int y) {
        g2d.fillOval(x, y, radius * 2, radius * 2);
    }

    @Override
    protected int getWidth() {
        return radius * 2;
    }

    @Override
    protected int getHeight() {
        return radius * 2;
    }

    @Override
    public void drawObject(Graphics g) {

    }
}
