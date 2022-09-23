package game.object;

import java.awt.*;



import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import game.GamePanel;


public class Bullet {
  
    private int x;
    private int y;
    private int r;
    private double rad;
    private double dx;
    private double dy;
    private float speed;
    private GameWorld gameWorld;
    private double angle;
    private int type_bullet;
    private int OrinalX;
    private int OrinalY;


    public Bullet(int x, int y,double angle, GameWorld gameWorld, int r, int type_bullet ){
         this.x =x;
         OrinalX = x;
         this.y=y;  
         OrinalY = y;      
         this.angle = angle;
         this.type_bullet = type_bullet;
         this.r = r;
         this.gameWorld = gameWorld;
         rad = Math.toRadians(angle);
         //Color color2  = new Color(255,0,255);
         //color1 = Color.YELLOW;
         //Color color2 = new Color (R, G, B)
        //color2 = Color.RED;
        //color3 = Color.BLUE;
         //speed = 10;
         if (type_bullet == 1){
            speed = 10;
        }
        else if (type_bullet == 2){
            speed = 8;
        }
        else{
            speed = 5;
        }
         dx = Math.cos(rad) * speed;
         dy = Math.sin(rad) * speed;
         
         
         
    }

    public  int getDamage_on_(String check){
        if(check == "HERO"){
            return 20;
        }
        else{
            return 100;
        }
    }
    public void setx(int x){
        this.x = x;
    }
    public void sety(int y){
        this.y = y;
    }
    public int getx(){
        return x;
    }
    public int gety(){
        return y;
    }
    public int getr(){
        return r;
    }
    public boolean avaible(){
        if (getx() < -r || getx() > GamePanel.width + r ||
        gety() < -r || gety() > GamePanel.height + r){
            return true;
        }
        return false;
    }
 
    
    public void render(Graphics2D g2d) {
        if (type_bullet == 1){
            Color color1 = new Color(0,245,255);
            
            g2d.setColor(color1);
            
            g2d.fillOval((int)(getx() -r - gameWorld.camera.getPosX()), (int)(gety() - r - gameWorld.camera.getPosY()), 2 * r, 2 * r);
            //Rectangle rect = Bullet_rectangle();
            //g2d.drawRect(rect.x - (int) gameWorld.camera.getPosX(),rect.y - (int) gameWorld.camera.getPosY(),rect.width,rect.height);
        }
        else if (type_bullet == 2){
            Color color2 = new Color(0,0,255);
            g2d.setColor(color2);
            g2d.fillOval((int)(getx() -r - gameWorld.camera.getPosX()), (int)(gety() - r - gameWorld.camera.getPosY()), 2 * r, 2 * r);
        //Rectangle rect = Bullet_rectangle();
        //g2d.drawRect(rect.x - (int) gameWorld.camera.getPosX(),rect.y - (int) gameWorld.camera.getPosY(),rect.width,rect.height);
        }
        else if (type_bullet == 3){
            Color color3 = new Color(255,150,0);
            g2d.setColor(color3);
            g2d.fillOval((int)(getx() -r - gameWorld.camera.getPosX()), (int)(gety() - r - gameWorld.camera.getPosY()), 2 * r, 2 * r);
            //Rectangle rect = Bullet_rectangle();
            //g2d.drawRect(rect.x - (int) gameWorld.camera.getPosX(),rect.y - (int) gameWorld.camera.getPosY(),rect.width,rect.height);   
        }
        
        
    }
    
    
    public boolean Update(){
        if (Destroy()){
            return true;
        }
        else{
        if(type_bullet == 1){
        if (angle == 180) {
                    Rectangle futureRect = Bullet_rectangle();
                    futureRect.x += dx;
                    Rectangle rect = gameWorld.map.haveCollisionWithWallLEFT(futureRect);
                    if (rect != null){
                        
                        return true;
                    } 
                    else{
                        x += dx;
                        y += dy;
                        
                        return false;
                    }
            
                }
        else if (angle == 270) {
                    Rectangle futureRect = Bullet_rectangle();
                   
                    futureRect.y += dy;
                    Rectangle rect = gameWorld.map.haveCollisionWithWallTOP(futureRect);
                    if (rect != null) {
                        
                       return true;
                    } else {
                        x += dx;
                        y += dy;
                        
                        return false;
                    }
            
                }
        else if (angle == 90) {
                    Rectangle futureRect = Bullet_rectangle();
                    
                    futureRect.y += dy;
                    Rectangle rect = gameWorld.map.haveCollisionWithWallBOTTOM(futureRect);
                    if (rect != null) {
                        
                        return true;
                    } else {
                        x += dx;
                        y += dy;
                        
                        return false;
                    }
            
                }
        else{
                    Rectangle futureRect = Bullet_rectangle();
                   
                    futureRect.x += dx;
                    Rectangle rect = gameWorld.map.haveCollisionWithWallRIGHT(futureRect);
                    if (rect != null) {
                        
                        return true;
                    } else {
                        x += dx;
                        y += dy;
                        
                        return false;
                    }
        
        }
        }
        else {
            if (Math.abs((x - OrinalX)*(x - OrinalX) + (y- OrinalY)*(y- OrinalY)) <= 90000){
            x += dx;
            y += dy;
            return false;
            }
            
            else{
                return true;
            }
             
        }

    }

}
        
    

    public Rectangle Bullet_rectangle(){
        Rectangle Bull = new Rectangle();
        Bull.x = (int) getx()- r;
        Bull.y = (int) gety()- r;
        Bull.width = 2*r;
        Bull.height = 2*r;
        return Bull;
    }

    public boolean Destroy(){
        int count = 0;
        if (type_bullet == 1){
                for (ParticularObject p : gameWorld.hero.getGameWorld().listParticularObject) {
                        if (p.getTEAM() != gameWorld.hero.getTEAM()) {
                            if (p.collisionWithOther(Bullet_rectangle())) {
                                p.setState(gameWorld.hero.BEHURT);
                                p.setBlood(p.getBlood() - getDamage_on_("GHOST"));
                                count++;
                            }
                        }
                    }
                    //gameWorld.sniper.setBlood(gameWorld.enemy1.getBlood() - this.getDamage_on_("GHOST"));
                    
        }
        else {
            if (gameWorld.hero != null){
           
                Rectangle rect_hero = gameWorld.hero.getBoundForCollisionWithMap();
                Rectangle rect_bullet = Bullet_rectangle();
                if (rect_hero.intersects(rect_bullet)){
                    gameWorld.hero.getGameWorld().hero.setState(gameWorld.hero.BEHURT);
                    gameWorld.hero.getGameWorld().hero.setBlood(gameWorld.hero.getBlood() - getDamage_on_("HERO"));
                    //gameWorld.hero.setBlood(gameWorld.hero.getBlood() - this.getDamage_on_("HERO"));
                    count++;
                }
                
            }
        }
        
        
        if (count > 0){
            return true;
        }
        else{
            return false;
        }
        
    }
    
}