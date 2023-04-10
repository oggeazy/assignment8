import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseMotionListener;

/**
 * Displays and updates the logic for the top-down raymarcher.
 */
public class RaymarcherPanel extends JPanel { 
    
    /**
     * We need to keep a reference to the parent swing app for sizing and 
     * other bookkeeping.
     */
    private Camera camera;
    private final RaymarcherRunner raymarcherRunner;
    
    public RaymarcherPanel(RaymarcherRunner raymarcherRunner) {
        this.raymarcherRunner = raymarcherRunner;
        this.setPreferredSize(new Dimension(this.raymarcherRunner.getFrame().getWidth(),
                this.raymarcherRunner.getFrame().getHeight()));
        camera = new Camera(500,320);
        addMouseMotionListener(camera);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.MAGENTA);
        g.fillRect(0, 0, this.getWidth(),this.getHeight());
        camera.drawObject(g);


    }
}
