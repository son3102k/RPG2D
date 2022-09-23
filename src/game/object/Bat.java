package game.object;

import game.graphics.AnimationBat;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Bat extends ParticularObject{
    private final int FOLLOW_WIDTH = 300;
    private final int FOLLOW_HEIGHT = 300;
    private long skillTime;
    private long skillDelay;

    private long lastTimeAttack = 0;
    private AnimationBat animation;

    public Bat(float posX, float posY, int blood, int damage, float maxSpeed, GameWorld gameWorld) {
        super( posX,  posY,  blood,  damage,maxSpeed, gameWorld);
        setDirection(1);
        setTEAM(ENEMY_TEAM);
        animation = new AnimationBat();
        skillTime = System.nanoTime();
        skillDelay = 3000;
    }


    public void render(Graphics2D g2d) {
        if (getPosX()>=getGameWorld().camera.getPosX() && getPosX()<=getGameWorld().camera.getPosX()+getGameWorld().camera.getWidthView() && getPosY()>=getGameWorld().camera.getPosY() && getPosY()<=getGameWorld().camera.getPosY()+getGameWorld().camera.getHeightView()) {
            drawAnimation(g2d);
        }
    }

    @Override
    public void attack() {
        if (collisionWithHero()) {
            long current = System.nanoTime();
            if (current - lastTimeAttack > 1500 * 1000000) {
                isATTACK=true;
                getGameWorld().hero.setState(BEHURT);
                getGameWorld().hero.setBlood(getGameWorld().hero.getBlood() - getDamage());
                lastTimeAttack = current;
            }
        }
    }

    @Override
    public void drawAnimation(Graphics2D g2d) {

        if (getDirection()==1){
            animation.left((int)(getPosX()-getGameWorld().camera.getPosX()),(int)(getPosY()-getGameWorld().camera.getPosY()),g2d,System.nanoTime());
        }
        if (getDirection()==2){
            animation.right((int)(getPosX()-getGameWorld().camera.getPosX()),(int)(getPosY()-getGameWorld().camera.getPosY()),g2d,System.nanoTime());
        }
        if (isDeath==true) {
            animation.death((int)(getPosX()-getGameWorld().camera.getPosX()),(int)(getPosY()-getGameWorld().camera.getPosY()),g2d,System.nanoTime());
            if (animation.bat_Death.isLastFrame()) {
                remove = true;
            }
        }
        if (isHurt==true) {
            beHurt();
            animation.hurt((int) (getPosX() - getGameWorld().camera.getPosX()), (int) (getPosY() - getGameWorld().camera.getPosY()-getHeight()/2), g2d , System.nanoTime());
            if (animation.bat_Hurt.isLastFrame()){
                isHurt = false;
            }
        }
    }

    public void update() {
        if (getPosX()>=getGameWorld().camera.getPosX() && getPosX()<=getGameWorld().camera.getPosX()+getGameWorld().camera.getWidthView() && getPosY()>=getGameWorld().camera.getPosY() && getPosY()<=getGameWorld().camera.getPosY()+getGameWorld().camera.getHeightView()) {
            switch (getState()) {
                case ALIVE:
                    follow();
                    skill();
                    attack();
                    break;
                case BEHURT:
                    if (getBlood() <= 0) setState(DEATH);
                    else {
                        isHurt = true;
                        setState(ALIVE);
                    }
                    break;
                case DEATH:
                    isDeath = true;
                    break;
            }
        }
    }
    public void skill(){
        long elapskill = (System.nanoTime() - skillTime) / 1000000;
        if (elapskill > skillDelay){
            if (GameWorld.hero.getPosX() >= getPosX()){
                for(int i = 0; i<=3; i++){
                    getGameWorld().bullet_enemy.add(new Bullet((int)getPosX(), (int)getPosY(), 270 + i*30, getGameWorld(), 4, 3) );
                }
            }
            else {
                for(int i = 0; i<=3; i++){
                    getGameWorld().bullet_enemy.add(new Bullet((int)getPosX(), (int)getPosY(), 90 + i*30, getGameWorld(), 4, 3) );
                }
            }
            skillTime = System.nanoTime();
        }
    }

    public boolean inRange(){
        Rectangle bat = new Rectangle((int)getPosX()-FOLLOW_WIDTH/2,(int)getPosY()-FOLLOW_HEIGHT/2,FOLLOW_WIDTH,FOLLOW_HEIGHT);
        Rectangle hero = getGameWorld().hero.getBoundForCollisionWithMap();
        return bat.intersects(hero);
    }

    public boolean collisionWithHero(){
        Rectangle bat = new Rectangle((int)getPosX()-getWidth()/2,(int)getPosY()-getHeight()/2,getWidth(),getHeight());
        Rectangle hero = getGameWorld().hero.getBoundForCollisionWithMap();
        return bat.intersects(hero);
    }

    public void beHurt() {
        if (getGameWorld().hero.getDirection() ==1) {
            if (getPosX()-3>0) {
                setPosX(getPosX()-3);
            }
        }
        if (getGameWorld().hero.getDirection() ==2) {
            if (getPosX()+3<getGameWorld().map.getWidth()) {
                setPosX(getPosX()+3);
            }
        }
        if (getGameWorld().hero.getDirection() ==3) {
            if (getPosY()-3 > 0) {
                setPosY(getPosY()-3);
            }
        }
        if (getGameWorld().hero.getDirection() ==4) {
            if (getPosY()+3 < getGameWorld().map.getHeight()) {
                setPosY(getPosY()+3);
            }
        }
    }

    public void follow(){
        if (inRange() && !collisionWithHero()) {
            if (getPosY() != getGameWorld().hero.getPosY() || getPosX()!= getGameWorld().hero.getPosX()) {
                if (getPosY() > getGameWorld().hero.getPosY()) {
                    setPosY(getPosY() - MAX_SPEED);
                }
                if (getPosY() < getGameWorld().hero.getPosY()) {
                    setPosY(getPosY() + MAX_SPEED);
                }
                if (getPosX() > getGameWorld().hero.getPosX()) {
                    setPosX(getPosX() - MAX_SPEED);
                    setDirection(1);
                }
                if (getPosX() < getGameWorld().hero.getPosX()) {
                    setPosX(getPosX() + MAX_SPEED);
                    setDirection(2);
                }
            }
        }
    }

}