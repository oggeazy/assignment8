
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * Displays and updates the logic for the top-down raymarcher.
 */
public class RaymarcherPanel extends JPanel { 
    
    /**
     * We need to keep a reference to the parent swing app for sizing and 
     * other bookkeeping.
     */
    private final RaymarcherRunner raymarcherRunner;

    ArrayList<CollisionObject> listCollisionObjects = new ArrayList<>();

    //Todo: Fix this to add random shapes at random places
    //Todo: Make it to where I can't set x to be out of bounds
    //Todo: Make it to where I can't set y to be out of bounds
    public void setListCollisionObjects() {
        //will make some random objects and add it to the list using a for loop
        //add a random amount between 5 and 15
        CircleObject circleObject = new CircleObject(0,0,50);
        RectangleObject rectangleObject = new RectangleObject(200,200, 50, 100);
        listCollisionObjects.add(circleObject);
        listCollisionObjects.add(rectangleObject);
        //For checking the window size
        this.getPreferredSize().getWidth();
        this.getPreferredSize().getHeight();
    }

    public ArrayList<CollisionObject> getListCollisionObjects() {
        return listCollisionObjects;
    }

    public RaymarcherPanel(RaymarcherRunner raymarcherRunner) {
        this.raymarcherRunner = raymarcherRunner;
        this.setPreferredSize(new Dimension(this.raymarcherRunner.getFrame().getWidth(),
                this.raymarcherRunner.getFrame().getHeight()));
        setListCollisionObjects();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < getListCollisionObjects().size(); i++) {
            getListCollisionObjects().get(i).drawObject(g2d);
        }
    }
}
