import java.awt.*;

public class RectangleObject extends CollisionObject {

    int width;
    int height;
    Color color;

    RectangleObject(float x, float y, int width, int height, Color color) {
        super(x, y);
        setHeight(height);
        setWidth(width);
        setColor(color);
    }

    //Width getter + setter
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    //Height getter + setter
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    //Color getter + setter
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }

    //Other Methods:
    @Override
    public void paintShape(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(getColor());
        g2d.fillRect((int) getX() - (this.getWidth() / 2), (int) getY() - (this.getHeight() / 2), this.getWidth(), this.getHeight());
    }
}
