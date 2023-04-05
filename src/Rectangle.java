import java.awt.*;

public class Rectangle extends CollisionObject {
    private int width, height;

    public Rectangle(int x, int y, int width, int height, Color color) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    @Override
    protected void drawShape(Graphics2D g2d, int x, int y) {
        g2d.fillRect(x, y, width, height);
    }

    @Override
    protected int getWidth() {
        return width;
    }

    @Override
    protected int getHeight() {
        return height;
    }

    @Override
    public void drawObject(Graphics g) {

    }
}
