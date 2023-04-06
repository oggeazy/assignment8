
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
public class RaymarcherPanel extends JPanel {

    ArrayList<CollisionObject> listCollisionObjects = new ArrayList<>();

    //ListCollisionObjects setter + getter
    public void setListCollisionObjects() {
        //loop
        for (int i = 0; i < randomizeAmountOfShapes(); i++) {
            if (randomizeIsCircle()) {
               CircleObject circleObject = new CircleObject(randomizeX(), randomizeY(),
                       randomizeDiameter(), randomizeColor());
               listCollisionObjects.add(circleObject);
            }
            else {
                RectangleObject rectangleObject = new RectangleObject(randomizeX(), randomizeY(),
                        randomizeWidth(), randomizeHeight(), randomizeColor());
                listCollisionObjects.add(rectangleObject);
            }
        }
    }
    public ArrayList<CollisionObject> getListCollisionObjects() {
        return listCollisionObjects;
    }

    //Todo: Implement each one of these methods
    //Randomizers for ListCollisionObjects setter
    public boolean randomizeIsCircle() {
        boolean result = false;
        Random random = new Random();
        if ( random.nextInt(10) % 2 == 0) {
            result = true;
        }
        return result;
    }
    public Color randomizeColor() {
        Color result;
        Color color0 = new Color(92, 150, 100);
        Color color1 = new Color(59, 125, 95);
        Color color2 = new Color(53, 94, 92);
        Color color3 = new Color(39, 70, 94);
        Color color4 = new Color(35, 108, 130);
        Color color5 = new Color(62, 168, 163);
        Random random = new Random();
        int n = random.nextInt(5);
        if (n == 0) {
            result = color0;
        }
        else if (n ==1){
            result = color1;
        }
        else if (n ==2){
            result = color2;
        }
        else if (n ==3){
            result = color3;
        }
        else if (n ==4){
            result = color4;
        }
        else {
            result = color5;
        }
        return result;
    }
    public float randomizeX() {
        Random random = new Random();
        return random.nextInt((int) this.getPreferredSize().getWidth());
    }
    public float randomizeY() {
        Random random = new Random();
        return random.nextInt((int) this.getPreferredSize().getHeight());
    }
    public int randomizeAmountOfShapes() {
        Random random = new Random();
        return random.nextInt(15) + 5;
    }
    public int randomizeDiameter() {
        Random random = new Random();
        return random.nextInt(100) + 25;
    }
    public int randomizeWidth() {
        Random random = new Random();
        return random.nextInt(150) + 25;
    }
    public int randomizeHeight() {
        Random random = new Random();
        return random.nextInt(150) + 25;
    }


//Other Methods:
    public RaymarcherPanel(RaymarcherRunner raymarcherRunner) {
        this.setPreferredSize(new Dimension(raymarcherRunner.getFrame().getWidth(),
                raymarcherRunner.getFrame().getHeight()));
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
