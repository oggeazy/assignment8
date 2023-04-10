import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MyPanel extends JPanel {
    private List<Drawable> objects;

    public MyPanel() {
        objects = new ArrayList<>();
        // create some objects
        objects.add(new Circle(100, 100, 50, Color.RED));
        objects.add(new Rectangle(200, 200, 100, 50, Color.BLUE));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (Drawable object : objects) {
            object.drawObject(g2d);
        }
    }
}
