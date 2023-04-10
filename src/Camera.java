import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Camera implements Drawable, MouseMotionListener {
    private int x;
    private int y;
    private int radius;
    public Camera(int x, int y) {
        this.x = x;
        this.y = y;
        radius = 10;
    }


    @Override
    public void drawObject(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.drawOval(x-radius, y-radius, 2*radius, 2*radius);
    }

    @Override
    public void drawObject(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawOval(x-radius, y-radius, 2*radius, 2*radius);
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
