package game.object;

import game.graphics.AnimationHero;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Hero extends ParticularObject{
    public static boolean release = true;
    private AnimationHero animation;
    private long lastTimeAttack=0;
    private boolean ATTACK = false;
    private long firingTimer;
    private long firingDelay;
    private boolean SKILL = false;
    private  float dir_bullet;
    private healthBar bar;

    public boolean getSKILL(){
        return SKILL;
    }
    public void setSKILL(boolean SKILL){
        this.SKILL = SKILL;

    }


    public boolean getATTACK() {
        return ATTACK;
    }

    public void setATTACK(boolean ATTACK) {
        this.ATTACK = ATTACK;
    }

    public Hero(float posX, float posY, int blood, int damage,float maxSpeed, GameWorld gameWorld) {
        super(posX, posY, blood, damage,maxSpeed,gameWorld);
        setDirection(4);
        setState(ALIVE);
        setTEAM(LEAGUE_TEAM);
        bar = new healthBar(getGameWorld(),this);
        animation = new AnimationHero();
        firingDelay = 1000;
        firingTimer = System.nanoTime();
    }

    @Override
    public void update() {
        bar.update();
        {
            switch (getState()){
                case ALIVE:
                    CollisionWithMap();
                    skill();
                    attack();
                    break;
                case BEHURT:

                    if (getBlood()<=0) setState(DEATH);
                    else {
                        isHurt = true;
                        setState(ALIVE);
                    }
                    break;
                case DEATH:
                    isDeath=true;
                    break;
            }

        }
    }

    @Override
    public void render(Graphics2D g2d) {
        bar.draw(g2d);
        //g2d.drawString(String.valueOf(getBlood()),30,30);
        drawAnimation(g2d);
    }

    @Override
    public void attack() {
        if (getATTACK()==true){
            long current = System.nanoTime();
            if (current - lastTimeAttack >= 500*1000000){
                isATTACK=true;
                lastTimeAttack = current;
                for (ParticularObject p : getGameWorld().listParticularObject) {
                    if (getTEAM() != p.getTEAM()) {
                        if (collisionWithEnemy(getDirection(),p.getBoundForCollisionWithMap())) {
                            p.setState(BEHURT);
                            p.setBlood(p.getBlood() - getDamage());
                        }
                    }
                }
            }
            else{
                setATTACK(false);
            }
        }

    }

    public boolean collisionWithEnemy(int direction,Rectangle enemy) {
        if (direction == 1 ) {
            Rectangle hero = new Rectangle((int)getPosX()-getWidth()/2,(int)getPosY()-getHeight()/2+3,getWidth()/2,getHeight()-6);
            if (hero.intersects(enemy)) {
                return true;
            }
        }
        if (direction == 2) {
            Rectangle hero = new Rectangle((int)getPosX(),(int)getPosY()-getHeight()/2+3,getWidth()/2,getHeight()-6);
            if (hero.intersects(enemy)) {
                return true;
            }
        }
        if (direction == 3) {
            Rectangle hero = new Rectangle((int)getPosX()-getWidth()/2+3,(int)getPosY()-getHeight()/2,getWidth()-6,getHeight()/2);
            if (hero.intersects(enemy)) {
                return true;
            }
        }
        if (direction == 4) {
            Rectangle hero = new Rectangle((int)getPosX()-getWidth()/2+3,(int)getPosY(),getWidth()-6,getHeight()/2);
            if (hero.intersects(enemy)) {
                return true;
            }
        }
        return false;
    }
    public void skill(){
        if(getSKILL() == true){
        
        long elapsed = (System.nanoTime() - firingTimer) / 1000000;
            if (elapsed > firingDelay){
                Sound.SHOOT.play();
                if (getDirection() == DIR_Y_U){
                    dir_bullet = 270;
                }
                else if ( getDirection() == DIR_Y_D){
                    dir_bullet = 90;
                }
                else if (getDirection() == DIR_X_L){
                    dir_bullet = 180;
                }
                else if (getDirection() == DIR_X_R){
                    dir_bullet = 360;
                }
                getGameWorld().bullets.add(new Bullet((int)(getPosX()),(int)(getPosY()), dir_bullet, getGameWorld(),8,1));
                firingTimer = System.nanoTime();
            }
        }
        else {
            setSKILL(false);
        }
    }


    public void drawAnimation(Graphics2D g2d){
        if (isDeath == false) {
            if (release == false && getDirection() == DIR_X_R && isATTACK == false) {
                animation.right((int) (getPosX() - (int) getGameWorld().camera.getPosX()), (int) (getPosY() - (int) getGameWorld().camera.getPosY()), g2d, System.nanoTime());
            } else if (getDirection() == DIR_X_R && isATTACK == false) {
                animation.right.reset();
                animation.right.draw((int) (getPosX() - getGameWorld().camera.getPosX()), (int) (getPosY() - getGameWorld().camera.getPosY()), g2d);
            }

            if (release == false && getDirection() == DIR_Y_U && isATTACK == false) {
                animation.up((int) (getPosX() - (int) getGameWorld().camera.getPosX()), (int) (getPosY() - (int) getGameWorld().camera.getPosY()), g2d, System.nanoTime());
            } else if (getDirection() == DIR_Y_U && isATTACK == false) {
                animation.up.reset();
                animation.up.draw((int) (getPosX() - getGameWorld().camera.getPosX()), (int) (getPosY() - getGameWorld().camera.getPosY()), g2d);
            }

            if (release == false && getDirection() == DIR_X_L && isATTACK == false) {
                animation.left((int) (getPosX() - (int) getGameWorld().camera.getPosX()), (int) (getPosY() - (int) getGameWorld().camera.getPosY()), g2d, System.nanoTime());
            } else if (getDirection() == DIR_X_L && isATTACK == false) {
                animation.left.reset();
                animation.left.draw((int) (getPosX() - getGameWorld().camera.getPosX()), (int) (getPosY() - getGameWorld().camera.getPosY()), g2d);
            }

            if (release == false && getDirection() == DIR_Y_D && isATTACK == false) {
                animation.down((int) (getPosX() - (int) getGameWorld().camera.getPosX()), (int) (getPosY() - (int) getGameWorld().camera.getPosY()), g2d, System.nanoTime());
            } else if (getDirection() == DIR_Y_D && isATTACK == false) {
                animation.down.reset();
                animation.down.draw((int) (getPosX() - getGameWorld().camera.getPosX()), (int) (getPosY() - getGameWorld().camera.getPosY()), g2d);
            }
        }
        if (isATTACK==true && getDirection()==2) {
            animation.attackRight((int) (getPosX() - getGameWorld().camera.getPosX()), (int) (getPosY() - getGameWorld().camera.getPosY()), g2d, System.nanoTime());
            if (animation.attackr.isLastFrame()){
                isATTACK = false;
            }
        }
        if (isATTACK==true && getDirection()==3) {
            animation.attackUp((int) (getPosX() - getGameWorld().camera.getPosX()), (int) (getPosY() - getGameWorld().camera.getPosY()), g2d, System.nanoTime());
            if (animation.attacku.isLastFrame()){
                isATTACK = false;
            }
        }
        if (isATTACK==true && getDirection()==1) {
            animation.attackLeft((int) (getPosX() - getGameWorld().camera.getPosX()), (int) (getPosY() - getGameWorld().camera.getPosY()), g2d, System.nanoTime());
            if (animation.attackl.isLastFrame()){
                isATTACK = false;
            }
        }
        if (isATTACK==true && getDirection()==4) {
            animation.attackDown((int) (getPosX() - getGameWorld().camera.getPosX()), (int) (getPosY() - getGameWorld().camera.getPosY()), g2d, System.nanoTime());
            if (animation.attackd.isLastFrame()){
                isATTACK = false;
            }
        }

        if (isHurt==true) {
            animation.hurt((int) (getPosX() - getGameWorld().camera.getPosX()), (int) (getPosY() - getGameWorld().camera.getPosY()-getHeight()/2), g2d , System.nanoTime());
            if (animation.beHurt.isLastFrame()){
                isHurt = false;
            }
        }

        if (isDeath == true) {
                animation.death((int)(getPosX()-getGameWorld().camera.getPosX()),(int)(getPosY()-getGameWorld().camera.getPosY()),g2d,System.nanoTime());
                if (animation.death.isLastFrame()) {
                    remove = true;
                }
        }
    }
}
