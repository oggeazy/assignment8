
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import javax.swing.JPanel;
public class RaymarcherPanel extends JPanel {

    //Instance variables
    private final Camera camera;
    ArrayList<CollisionObject> listCollisionObjects = new ArrayList<>();
    ArrayList<March> march = new ArrayList<>();
    ArrayList<Double> distancesFromCamera = new ArrayList<>();

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
        int n = random.nextInt(6);
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
        return random.nextInt(12) + 9;
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

    //Getter + setter March
    public void setMarch(float inputX, float inputY){
        int j = 0;
        float currentX = inputX;
        while (currentX <= this.getPreferredSize().getWidth()) {
            int i = 0;
            do {
                i++;
                setDistancesFromCamera(currentX + i, inputY);
            }
            while (getDistancesFromCamera().get(j) <= 0.01 );
            March march1 = new March(currentX, inputY, currentX + i, inputY);
            march.add(march1);
            currentX = currentX + i;
        }
    }
    public void setDistancesFromCamera(float inputX, float inputY){
        ArrayList<Double> distancesFromCameraNew = new ArrayList<>();
        for (int i = 0; i < getListCollisionObjects().size(); i++){
            double distanceNew = getListCollisionObjects().get(i).computeDistance(inputX, inputY);
            distancesFromCameraNew.add(distanceNew);
        }
        distancesFromCameraNew.sort(Comparator.naturalOrder());
        distancesFromCamera = distancesFromCameraNew;
    }

    public ArrayList<Double> getDistancesFromCamera() {
        return distancesFromCamera;
    }

    public ArrayList<March> getMarch() {
        return march;
    }

    //Other Methods:
    public RaymarcherPanel(RaymarcherRunner raymarcherRunner) {
        this.setPreferredSize(new Dimension(raymarcherRunner.getFrame().getWidth(),
                raymarcherRunner.getFrame().getHeight()));
        setListCollisionObjects();
        camera = new Camera(1,190, 0);
        addMouseMotionListener(camera);
        addMouseListener(camera);
        setDistancesFromCamera(camera.getX(), camera.getY());
        setMarch(camera.getX(), camera.getY());
        for (March m : march) {
            addMouseMotionListener(m);
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < getListCollisionObjects().size(); i++) {
            getListCollisionObjects().get(i).drawObject(g2d);
        }
        for (int i = 0; i < getMarch().size(); i++) {
            getMarch().get(i).drawObject(g2d);
        }
        camera.drawObject((Graphics2D) g);
    }
}
