import java.util.*;
import java.util.List;
import java.awt.*;

public class Player {
public Rectangle body;

Bullet bullet = null;
private ArrayList<Bullet> b;
public int dx, dy;
public Player(int startX, int startY, int width, int height) {
    body = new Rectangle(startX, startY, width, height);
    b = new ArrayList<>();            
}



public void move(boolean[] keys, int[][] map) {
    if (keys[BaseFrame.RIGHT] && collision(body.x + 10, body.y, map)) {
        body.x += 10;
    }
    if (keys[BaseFrame.LEFT] && collision(body.x - 10, body.y, map)) {
        body.x -= 10;
    }
    if (keys[BaseFrame.UP] && collision(body.x, body.y - 10, map)) {
        body.y -= 10;
    }
    if (keys[BaseFrame.DOWN] && collision(body.x, body.y + 10, map)) {
        body.y += 10;
    }
    
   

}

public static boolean collision(int nextX, int nextY, int[][] map) {
    int tile = 32;
    int nextTX = nextX / tile;
    int nextTY = nextY / tile;
    return nextTX >= 0 && nextTX < map[0].length && nextTY >= 0 && nextTY < map.length && map[nextTY][nextTX] == 0;
    }
 
public void updatebul() {
    for (Bullet bul : b) {
        bul.move();
    }
}
    
public void direction(int moX, int moY){
     dx = moX - (int) body.x;
     dy = moY - (int) body.y;
}

public void shoot() {
    if (bullet == null) {
        b.add(new Bullet((int) body.getX() + body.width, (int) body.getY() + body.height / 3, 15));
    }
}

public void bdraw(Graphics g){
    for (Bullet bul : b) {
        bul.draw(g);
    }
}
}
