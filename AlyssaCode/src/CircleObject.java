import java.awt.*;

public class CircleObject extends CollisionObject{

    int radius;

    CircleObject(float x, float y, int radius){
        super(x, y);
        setRadius(radius);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void paintShape(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GREEN);
        g2d.fillOval((int) getX(), (int) getY(), getRadius(), getRadius());
    }

}
