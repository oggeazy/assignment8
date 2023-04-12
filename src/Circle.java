import java.awt.*;
import java.awt.Rectangle;

public class Circle extends CollisionObject{

    int diameter;

    Color color;

    Circle(float x, float y, int diameter, Color color){
        super(x, y);
        setDiameter(diameter);
        setColor(color);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    @Override
    public void paintShape(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(getColor());
        g2d.fillOval((int) getX() - (getDiameter()/ 2), (int) getY() - (getDiameter()/ 2), getDiameter(), getDiameter());
    }

    @Override
    public double computeDistance(double cameraX, double cameraY) {
        double x2 = getX();
        double y2 = getY();
        double r = getDiameter() / 2;
        double d = Math.sqrt(Math.pow(cameraX - x2, 2) + Math.pow(cameraY - y2, 2)) - r;
        return d;
    }


    @Override
    public void drawObject(Graphics g) {

    }

    @Override
    public double getDistance(Rectangle rect) {
        return 0;
    }
}