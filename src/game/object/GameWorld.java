package game.object;

import java.awt.Graphics2D;
import java.util.ArrayList;

import game.GamePanel;


public class GameWorld  {
    private float x;
    private float y;

    public static int width;
    public static int height;
    public static Hero hero;
    public Map map;
    public Camera camera;
    public ArrayList<ParticularObject> listParticularObject;
    public Bat enemy1,enemy2,enemy3,enemy4,enemy5,enemy6,enemy7,enemy8,enemy9,enemy10;
    public Monster mon1, mon2, mon3, mon4, mon5, mon6;
    public static ArrayList<Bullet> bullets;
    public static ArrayList<Bullet> bullet_enemy;
    private Level level;
    private Score score;
    public GameWorld(float x,float y,int width,int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        hero = new Hero(200,200,1000,300,(float) 2.5,this);
        map = new Map(0,0,this);
        camera = new Camera((float)0,(float)0,this,width,height);
        Sound.BACKGROUND.loop();
        listParticularObject = new ArrayList<ParticularObject>();
        enemy1 = new Bat(450,400,1000,10,(float)0.3,this);
        enemy2 = new Bat(600,600,1000,10,(float)0.3,this);
        enemy3 = new Bat(300,400,1000,10,(float)0.3,this);
        enemy4 = new Bat(200,600,1000,10,(float)0.3,this);
        enemy5 = new Bat(100,400,1000,10,(float)0.3,this);
        enemy6 = new Bat(600,500,1000,10,(float)0.3,this);
        enemy7 = new Bat(450,300,1000,10,(float)0.3,this);
        enemy8 = new Bat(600,200,1000,10,(float)0.3,this);
        enemy9 = new Bat(450,100,1000,10,(float)0.3,this);
        enemy10 = new Bat(600,150,1000,10,(float)0.3,this);
        mon1 = new Monster(450,500,1000,10,(float)0.3,this);
        mon2 = new Monster(500,200,1000,10,(float)0.3,this);
        mon3 = new Monster(650,250,1000,10,(float)0.3,this);
        mon4 = new Monster(450,650,1000,10,(float)0.3,this);
        mon5 = new Monster(550,150,1000,10,(float)0.3,this);
        mon6 = new Monster(600,100,1000,10,(float)0.3,this);
        
        listParticularObject.add(hero);
        listParticularObject.add(enemy1);
        listParticularObject.add(enemy2);
        listParticularObject.add(enemy3);
        listParticularObject.add(enemy4);
        listParticularObject.add(enemy5);
        listParticularObject.add(enemy6);
        listParticularObject.add(enemy7);
        listParticularObject.add(enemy8);
        listParticularObject.add(enemy9);
        listParticularObject.add(enemy10);
        listParticularObject.add(mon1);
        listParticularObject.add(mon2);
        listParticularObject.add(mon3);
        listParticularObject.add(mon4);
        listParticularObject.add(mon5);
        listParticularObject.add(mon6);
        
        
        bullets = new ArrayList<Bullet>();
        bullet_enemy = new ArrayList<Bullet>();
        level = new Level(this);
        score = new Score(this);




    }
    public void setLevel(int level){
        this.level.setLevel(level);

    }
    public Score getscore(){
        return score;
    }

    public void update(){
        map.update();
        ArrayList <ParticularObject> toRemove = new ArrayList<>();
        for (ParticularObject p : listParticularObject) {
            if (p.remove) toRemove.add(p);
        }
        score.update();
        listParticularObject.removeAll(toRemove);
       for (ParticularObject p : listParticularObject) {
           p.update();
       }
       camera.update();
       for (int i = 0; i < bullets.size(); i++){
        boolean remove = bullets.get(i).Update();
        if (remove){
        bullets.remove(i);
        i--;
        }
        }
        for (int j =0; j < bullet_enemy.size();j++){
            boolean remove_e = bullet_enemy.get(j).Update();
            if (remove_e){
                bullet_enemy.remove(j);
                j--;
            }
        }
        


    }

    public void render(Graphics2D g2d){
            map.draw(g2d);
        for (ParticularObject p : listParticularObject) {
            p.render(g2d);
        }
        for (int j = 0; j< bullet_enemy.size();j++){
            bullet_enemy.get(j).render(g2d);
        }
        
         for (int i = 0; i < bullets.size(); i++){
             bullets.get(i).render(g2d);
        }
        score.render(g2d);
    }


}
