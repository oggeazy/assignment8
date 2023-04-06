import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Camera implements Drawable, MouseMotionListener {
    private int x;
    private int y;
    private final int radius;

    //Setters
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    //Constructor
    public Camera(int x, int y) {
        setX(x);
        setY(y);
        radius = 10;
    }

//Other Methods
    @Override
    public void drawObject(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.drawOval(x-radius, y-radius, 2*radius, 2*radius);
    }
    @Override
    public void mouseDragged(MouseEvent e) {

    }
    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX() + 4;
        y = e.getY() + 9;
    }
}
