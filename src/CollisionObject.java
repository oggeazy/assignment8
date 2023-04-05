import java.awt.*;

public abstract class CollisionObject implements Drawable {
    protected int x, y;
    protected Color color;

    public CollisionObject(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    @Override
    public void drawObject(Graphics2D g2d) {
        g2d.setColor(color);
        // draw the shape at its center
        drawShape(g2d, x - getWidth() / 2, y - getHeight() / 2);
    }

    protected abstract void drawShape(Graphics2D g2d, int x, int y);

    protected abstract int getWidth();

    protected abstract int getHeight();
}
