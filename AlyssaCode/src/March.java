import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;

public class March implements Drawable, MouseMotionListener {
    float startingX;
    float startingY;
    float endingX;
    float endingY;
    float radius;

    //Getters and setters
    public float getStartingX() {
        return startingX;
    }
    public void setStartingX(float startingX) {
        this.startingX = startingX;
    }
    public float getEndingY() {return endingY;}
    public void setEndingY(float endingY) {this.endingY = endingY;}
    public float getEndingX() {
        return endingX;
    }
    public void setEndingX(float endingX) {
        this.endingX = endingX;
    }
    public float getStartingY() {
        return startingY;
    }
    public void setStartingY(float startingY) {
        this.startingY = startingY;
    }
    public void setRadius() {
        radius = (float) Point2D.distance(getStartingX(), getStartingY(), getEndingX(), getEndingY());
    }
    public float getRadius() {return radius;}

    //Constructor
    March(float startingX, float startingY, float endingX, float endingY){
        setStartingX(startingX);
        setStartingY(startingY);
        setEndingX(endingX);
        setEndingY(endingY);
        setRadius();
    }

    @Override
    public void drawObject(Graphics2D g2d) {
        Color color = new Color(39, 65, 55);
        g2d.setColor(color);
        g2d.drawOval((int) (getStartingX() - getRadius()), (int) (getStartingY() - getRadius()),
                (int) (2*getRadius()), (int) (2*getRadius()));
        g2d.setColor(Color.MAGENTA);
        g2d.drawLine((int) getStartingX(), (int) getStartingY(),(int) getEndingX(), (int) getEndingY());
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        setStartingX(e.getX() + 4);
        setStartingY(e.getY() + 9);
    }
}
