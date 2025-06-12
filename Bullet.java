import java.awt.*;
class Bullet {
    int x, y;
    int speed;
    int dx, dy;
    //boolean active;
    
    public Bullet(int bx, int by, int bspeed, int dirX, int dirY) {
        x = bx;
        y = by;
        speed = bspeed;
        dx = dirX;
        dy = dirY;
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
            x += dx*speed;
            y += dy*speed;
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
