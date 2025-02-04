package frames;
import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class BallPanel extends JPanel implements Runnable{
    public int x = 50;
    public int y = 50;
    public int d = 20;
    public int vx =10;
    public int vy =10;

    public BallPanel(){
        this.setBackground(Color.cyan);
        new Thread(this).start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red); 
        g.fillOval(x,y,d,d); 
    }

    @Override
    public void run() {
        while (true) {
            x += vx;
            y -= vy;
            
            if (y <= 0) {     //up
               vy = -vy;
            }
            if (x >= getWidth() - d) {  // right
                vx = -vx; 
            }
            if (y >= getHeight() - d) {  //down
                vy = -vy; 
            }
            if (x <= 0) {  //left
                vx = -vx; 
            }
            repaint();
            try {
                Thread.sleep(100); 
            } catch (InterruptedException ex) {
                 Logger.getLogger(MyPanelMq.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
    }
}

public class BallApp {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        BallPanel BP = new BallPanel();

        f.setContentPane(BP);
        f.setSize(300,200);
        f.setVisible(true);
    }
}
