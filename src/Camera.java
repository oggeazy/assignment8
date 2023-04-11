import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Camera implements Drawable, MouseMotionListener, MouseListener {
    private int x;
    private int y;
    private final int radius;
    private int angle;

    //Setters
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setAngle(int angle) {
        this.angle = angle;
    }

    //Getters
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getAngle() {
        return angle;
    }

    public int getRadius() {
        return radius;
    }

    //Constructor
    public Camera(int x, int y, int angle) {
        setX(x);
        setY(y);
        setAngle(angle);
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
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
       if (e.getButton() == MouseEvent.BUTTON1){
           setAngle(getAngle() + 1);
        }
       else  if (e.getButton() == MouseEvent.BUTTON3){
           setAngle(getAngle() - 1);
       }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
