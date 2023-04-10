import java.awt.*;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

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

    @Override
    public double getDistance(Rectangle rect) {
        double x1 = mouseX;
        double y1 = mouseY;
        double x2 = rect.getX() + rect.getWidth() / 2;
        double y2 = rect.getY() + rect.getHeight() / 2;
        double r = Math.sqrt(Math.pow(rect.getWidth() / 2, 2) + Math.pow(rect.getHeight() / 2, 2));
        double d = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)) - r;
        return d;
    }
    public double getDistance(Circle circle) {
        double x1 = mouseX;
        double y1 = mouseY;
        double x2 = circle.getX();
        double y2 = circle.getY();
        double r = circle.getRadius();
        double d = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)) - r;
        return d;
    }
    public double getDistance(Line2D line) {
        double x1 = mouseX;
        double y1 = mouseY;
        double x2 = line.getX1();
        double y2 = line.getY1();
        double x3 = line.getX2();
        double y3 = line.getY2();
        double d1 = Line2D.ptSegDist(x2, y2, x3, y3, x1, y1);
        double d2 = Line2D.ptSegDist(x2, y2, x3, y3, x1 + 1, y1);
        double d3 = Line2D.ptSegDist(x2, y2, x3, y3, x1, y1 + 1);
        double d4 = Line2D.ptSegDist(x2, y2, x3, y3, x1 + 1, y1 + 1);
        double d = Math.min(Math.min(d1, d2), Math.min(d3, d4));
        return d;
    }

    public void getplace(int mouseX, int mouseY) {
        this.mouseX = mouseX;
        this.mouseY = mouseY;
    }

    private int mouseY;
    private int mouseX;
}





