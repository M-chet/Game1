import java.awt.*;
class Bullet {
    int x, y;
    int speed;
    //boolean active;
    
    public Bullet(int bx, int by, int bspeed) {
        x = bx;
        y = by;
        speed = bspeed;
       // active = true;
    }


//  public boolean activebullet() {
//     if(x<960||x<=0||y>640||y<0){
//         active = false;
//     }else{
//     active = true;
//     }
//     return active;
// }

    public void move() {
            x += Player.dx*speed;
            y += Player.dy*speed;
    }
    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.fillOval(x,y,6,6);
        
      }
}

/*
 * private int tx1,ty1,tx2,ty2 ,currentTX,currentTY;
 * 
 */
