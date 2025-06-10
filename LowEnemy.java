import java.awt.*;
public class LowEnemy {
public Rectangle body;
private int speed;
 

public LowEnemy(int startX, int startY, int width, int height, int speed) {
    body = new Rectangle(startX, startY, width, height);
}

public void move(int[][] map) {
    if (!Player.collision((int) body.x, (int) body.y + speed, map)) {
        body.y += speed;
    } else{
        speed = -speed;
    }
}


public void draw(Graphics g) {
    g.setColor(Color.BLUE);
    g.fillRect(body.x, body.y, body.width, body.height);
}
}

