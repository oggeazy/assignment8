
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
public class RaymarcherPanel extends JPanel {

    //Instance variables
    private final Camera camera;
    ArrayList<CollisionObject> listCollisionObjects = new ArrayList<>();
    ArrayList<March> march = new ArrayList<>();

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
        return random.nextInt(12) + 8;
    }
    public int randomizeDiameter() {
        Random random = new Random();
        return random.nextInt(150) + 25;
    }
    public int randomizeWidth() {
        Random random = new Random();
        return random.nextInt(175) + 25;
    }
    public int randomizeHeight() {
        Random random = new Random();
        return random.nextInt(175) + 25;
    }

//Getter + setter march
    /*Use a loop to keep track of the minimum distance between the current iteration
point, i.e., the camera coordinates, and any object in the world. Once this goes
below that threshold mentioned in step 11, break out, and return the list.
ii. After one march, update the current iteration point to be the end-point of the
march (with no alterations to the y coordinate - see step 16 for more on this!).
*/
    public void setMarch(){
        int i = 0;
        float inputX = camera.getX();
        float inputY = camera.getY();

       do {
           if (listCollisionObjects.get(i).getX() < 0.01 || listCollisionObjects.get(i).getY() < 0.01 ){
               break;
           }
           else {
               March march1 = new March(inputX, inputY,
                       listCollisionObjects.get(i).getX(),listCollisionObjects.get(i).getY());
               march.add(march1);
               if (march1.getEndingX() > this.getPreferredSize().getWidth() ||
                       march1.getEndingY() > this.getPreferredSize().getHeight()){
                   break;
               }
           }
           inputX =  listCollisionObjects.get(i).getX();
           i++;
       }
       while (i < listCollisionObjects.size());
    }


//Other Methods:
    public RaymarcherPanel(RaymarcherRunner raymarcherRunner) {
        this.setPreferredSize(new Dimension(raymarcherRunner.getFrame().getWidth(),
                raymarcherRunner.getFrame().getHeight()));
        setListCollisionObjects();
        camera = new Camera(500,320, 0);
        setMarch();
        addMouseMotionListener(camera);
        addMouseListener(camera);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < getListCollisionObjects().size(); i++) {
            getListCollisionObjects().get(i).drawObject(g2d);
        }
        camera.drawObject((Graphics2D) g);
    }
}
