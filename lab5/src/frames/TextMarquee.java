package frames;
import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class MyPanelMq extends JPanel implements Runnable{
    public String text = "Hagar"; 
    public int x = 0; 
    public MyPanelMq(){
        this.setBackground(Color.cyan);
        new Thread(this).start();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.drawString(text,x, 100); 
    }
    
    @Override
    public void run() {
        while (true) {
            x += 30;
             if (x > getWidth()) {
                x = 0;
            }
            repaint();
            try {
                Thread.sleep(1000);
            } 
            catch (InterruptedException ex) {
                Logger.getLogger(MyPanelMq.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
    }
}

public class TextMarquee {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        MyPanelMq mp = new MyPanelMq();

        f.setContentPane(mp);
        f.setSize(300, 200);
        f.setVisible(true);
    }
}