import java.awt.*;

public abstract class CollisionObject implements Drawable{
    float x;
    float y;

    CollisionObject(float x, float y) {
        setX(x);
        setY(y);
    }


    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public abstract void paintShape(Graphics g);

    public abstract double computeDistance(double cameraX, double cameraY);

    @Override
    public void drawObject(Graphics2D g2d) {
        paintShape(g2d);
        //The only reason I have it implemented in this way is because I made paintShape first, but noticed
        //I was supposed to do something else. Changing it to drawObject seemed like more work, so I just
        //fed the command I made to the drawObject to do the same thing.
    }
}


