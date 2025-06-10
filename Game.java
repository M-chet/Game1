import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class Game extends BaseFrame {
    private Player player;
    private GameMap gameMap;
    private LowEnemy ez;
    private BufferedImage playerImage;

    public Game() {
        super("Game Title", 960, 640);
        player = new Player(100,180,32,32);
        playerImage = loadImage("player.png");
        ez = new LowEnemy(490, 251, 32, 32, 5);
        gameMap = new GameMap();
    }

    @Override
    public void move() {
        player.move(keys, gameMap.map);
        ez.move(gameMap.map);
    }
    
    public void click(int x, int y){
        if (mb == 1) {
            player.direction(x, y);
            player.shoot();
        }
        player.updatebul();
      }
    
   
    
    private BufferedImage loadImage(String fileName) {
        try {
            return ImageIO.read(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void draw(Graphics g) {
        BufferedImage bi = loadImage("map.png");
        g.drawImage(bi, 0,0,null);
        g.drawImage(playerImage, (int) player.body.getX(), (int) player.body.getY(), (int) player.body.getWidth(), (int) player.body.getHeight(), null);
        player.bdraw(g);
        ez.draw(g);
    }

    public static void main(String[] args) {
        new Game();
    }
}

