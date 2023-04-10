import java.awt.*;

public class CircleObject extends CollisionObject{

    int diameter;

    Color color;

    CircleObject(float x, float y, int radius, Color color){
        super(x, y);
        setDiameter(radius);
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

}
