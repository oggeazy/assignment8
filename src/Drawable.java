import javax.swing.*;
import java.awt.*;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public interface Drawable {

    void drawObject(Graphics2D g2d);

    void drawObject(Graphics g);

    double getDistance(Rectangle rect);
}