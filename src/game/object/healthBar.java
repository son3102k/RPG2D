package game.object;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class healthBar {
    private GameWorld gameWorld;
    private Hero hero;
    public float currentHP;
    private BufferedImage image,Bar;
    public healthBar(GameWorld gameWorld, Hero hero) {
        this.gameWorld = gameWorld;
        this.hero = hero;
        currentHP = hero.getBlood()/10;
        try {
            image = ImageIO.read(new File("Data/GuiImage/healthbar.png"));
        } catch (Exception e) {}
        Bar = image.getSubimage(0,0,760,164);
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(Bar,30,30,(int)currentHP,15,null);
        g2d.setColor(Color.red);
        g2d.setFont(new Font("Tahoma", Font.BOLD, 13));
        g2d.drawString("HP: " + (int) currentHP + " / 100",40,60);
    }

    public void update() {
        if (currentHP>hero.getBlood()/10) {
            currentHP -= 1;
        }
        if (currentHP<=0) currentHP=0;
    }
}


