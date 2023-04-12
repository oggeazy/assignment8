import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import javax.swing.JPanel;
public class RaymarcherPanel extends JPanel {

    //Instance variables
    private final Camera camera;
    ArrayList<CollisionObject> listCollisionObjects = new ArrayList<>();
    ArrayList<Double> distancesFromCamera = new ArrayList<>();

    //ListCollisionObjects setter + getter
    public void setListCollisionObjects() {
        //loop
        for (int i = 0; i < randomizeAmountOfShapes(); i++) {
            if (randomizeIsCircle()) {
                Circle circleObject = new Circle(randomizeX(), randomizeY(),
                        randomizeDiameter(), randomizeColor());
                listCollisionObjects.add(circleObject);
            }
            else {
                Rectangle rectangleObject = new Rectangle(randomizeX(), randomizeY(),
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

    public ArrayList<March> march(float cameraX, float cameraY) {
        ArrayList<March> marchArray = new ArrayList<>();
        Double closestObjectsDistanceFromCamera = getDistancesFromCamera().get(0);
        float endingX = (float) (cameraX + closestObjectsDistanceFromCamera);

        do {
            March marchNew = new March(cameraX, cameraY, endingX, cameraY);
            marchArray.add(marchNew);
            cameraX = endingX;
            setDistancesFromCamera(cameraX, cameraY);
            closestObjectsDistanceFromCamera = getDistancesFromCamera().get(0);
        }while (closestObjectsDistanceFromCamera > 0.01 &&
                cameraX >= this.getPreferredSize().getWidth());


        //track the smallest distance with closestObjectsDistanceFromCamera.
        //make new marches by feeding it endingX until--
        //If it goes below 0.01, then return the listOfMarch complied thus far

        return marchArray;

    }
    public void setDistancesFromCamera(float inputX, float inputY){
        ArrayList<Double> distancesFromCameraNew = new ArrayList<>();
        for (int i = 0; i < getListCollisionObjects().size(); i++){
            double distanceNew = getListCollisionObjects().get(i).computeDistance(inputX, inputY);
            distancesFromCameraNew.add(distanceNew);
            System.out.println("Distance "+ i+ ": "+ distanceNew);
        }
        distancesFromCameraNew.sort(Comparator.naturalOrder());
        for (int i = 0; i < distancesFromCameraNew.size(); i++){
            System.out.println("Distance after sort "+ i+ ": "+ distancesFromCameraNew.get(i));
        }
        distancesFromCamera = distancesFromCameraNew;
    }
    public ArrayList<Double> getDistancesFromCamera() {
        return distancesFromCamera;
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
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < getListCollisionObjects().size(); i++) {
            getListCollisionObjects().get(i).drawObject(g2d);
        }
        camera.drawObject((Graphics2D) g);
        for (int i = 0; i < march(camera.getX(), camera.getY()).size(); i++) {
            march(camera.getX(), camera.getY()).get(i).drawObject(g2d);
        }

    }
}