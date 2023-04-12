import java.awt.*;

public class Rectangle extends CollisionObject {

    int width;
    int height;
    Color color;

    Rectangle(float x, float y, int width, int height, Color color) {
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

    @Override
    public double computeDistance(double cameraX, double cameraY) {
        float x2 = getX() + getWidth() / 2;
        float y2 = getY() + getHeight() / 2;
        float r = (float) Math.sqrt(Math.pow(getWidth() / 2, 2) + Math.pow(getHeight() / 2, 2));
        float d = (float) (Math.sqrt(Math.pow(cameraX - x2, 2) + Math.pow(cameraY - y2, 2)) - r);
        return d;
    }

    @Override
    public void drawObject(Graphics g) {

    }

    @Override
    public double getDistance(java.awt.Rectangle rect) {
        return 0;
    }
}