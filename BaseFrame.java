import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

class BaseFrame extends JFrame implements KeyListener, ActionListener{
 protected int mx,my,mb;
 protected boolean []keys;

 protected Image back,dbImage;
 protected Graphics dbg;
 protected String col="";
 protected GamePane pane;
 protected Timer timer;
 
 final protected static int LEFT = 37;
 final protected static int UP = 38;
 final protected static int RIGHT = 39;
 final protected static int DOWN = 40;
 final protected static int SPACE = 32;
 final protected int ESC = 27;
 
    public BaseFrame(String t, int w, int h) {
      super(t);
      pane = new GamePane(this);
      pane.setPreferredSize(new Dimension(w, h));
      
      addKeyListener(this);
      
      
      keys = new boolean[2000];
      add(pane);
      pack();
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      timer = new Timer(20, this);
      timer.setInitialDelay(1000);
      timer.start();
    }
 
    public void click(int x, int y){
    
    }
    
    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

 // should be overloaded
 public void move(){
  
 }

 public void draw(Graphics g){
  
 }


 @Override
 public void actionPerformed(ActionEvent e){
  move();  // never draw in move
  repaint();  // only draw
 }
 
 class GamePane extends JPanel implements MouseMotionListener, MouseListener{
  BaseFrame main;
  private void updateMouse(MouseEvent e){
   mx = e.getX();
   my = e.getY();  
  }   
 
     public void mouseEntered(MouseEvent e) {}
     public void mouseExited(MouseEvent e) {}
 
     public void mouseReleased(MouseEvent e) {
       updateMouse(e);      
       mb = 0;
     }    
     public void mouseClicked(MouseEvent e){
      updateMouse(e);
      mb = 0;
     }    
     public void mouseDragged(MouseEvent e){
      updateMouse(e);
  }
     public void mouseMoved(MouseEvent e){
      updateMouse(e);
  }
     public void mousePressed(MouseEvent e){
      updateMouse(e);
      mb = e.getButton();
      main.click(e.getX(), e.getY());
  }  
  public GamePane(BaseFrame m){
   main = m;
   addMouseListener (this);
   addMouseMotionListener(this);
  }
  public void paint(Graphics g){
   main.draw(g);
  }  
 }
 
}