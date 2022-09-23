package game.object;
import java.awt.Graphics2D;
import java.awt.*;
public class Score {
    
    private int score = 0;
    private GameWorld gameWorld;
    public Score(GameWorld gameWorld){
        this.gameWorld = gameWorld;

    }
    public int getscore(){
        return score;
    }
    public void update(){
        for (ParticularObject p : gameWorld.hero.getGameWorld().listParticularObject) {
            if (p.getTEAM() != gameWorld.hero.getTEAM()) {
                if(p.remove){
                    if (p instanceof Bat){
                        score += 100;
                    }
                    if (p instanceof Monster){
                        score += 100;
                    }
                }
            }

            
        }
        

    }

    public void render(Graphics2D g2d){
    Font myFont = new Font ("FontFile/ka1.ttf", 1, 25);
    Color color = new Color(255,255,0);
    g2d.setColor(color);
    g2d.setFont(myFont);
    g2d.drawString(String.valueOf(getscore()),50,30);
    }
}
    
