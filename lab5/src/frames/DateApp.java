package frames;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


 class MyPanel extends JPanel implements Runnable{
    public String dateTime;
    public MyPanel(){
        this.setBackground(Color.cyan);
        new Thread(this).start();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.black);
        g.drawString(dateTime,100,100);
    }
    @Override
    public void run(){
        while (true){
            dateTime = new Date().toLocaleString();
            repaint();
            try{
                this.repaint();
                Thread.sleep(1000);
            }
            catch(InterruptedException ex){
                Logger.getLogger(MyPanel.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
    }
} 
public class DateApp {
public static void main(String[] args) {
        JFrame f = new JFrame();
        MyPanel mp = new MyPanel();
        
        f.setContentPane(mp);
        f.setSize(300, 200);
        f.setVisible(true);
    }
}
    

