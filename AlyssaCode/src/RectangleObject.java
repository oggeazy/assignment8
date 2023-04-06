import java.awt.*;

public class RectangleObject extends CollisionObject {

    int width;
    int height;

    RectangleObject(float x, float y, int width, int height) {
        super(x, y);
        setHeight(height);
        setWidth(width);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
@Override
    public void paintShape(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GREEN);
        g2d.fillRect((int) getX(), (int) getY(), this.getWidth(), this.getHeight());
    }
}
