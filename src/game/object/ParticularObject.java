package game.object;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class ParticularObject extends GameObject {
    public static final int LEAGUE_TEAM = 1;
    public static final int ENEMY_TEAM = 2;
    private int TEAM;
    public boolean isATTACK = false;
    public boolean isHurt = false;
    public boolean isDeath = false;
    public boolean remove = false;



    private int direction=0;
    public static final int DIR_X_L = 1;
    public static final int DIR_X_R = 2;
    public static final int DIR_Y_U = 3;
    public static final int DIR_Y_D = 4;

    public static final int ALIVE = 0;
    public static final int BEHURT = 1;
    public static final int DEATH = 2;

    private int state = ALIVE;

    private int blood;
    public float MAX_SPEED = 3;
    private float speed = 0;
    private int damage;

    private final int width=30;
    private final int height=30;

    public ParticularObject(float posX, float posY, int blood, int damage, float maxSpeed, GameWorld gameWorld) {
        super(posX, posY, gameWorld);
        this.blood = blood;
        this.damage = damage;
        this.MAX_SPEED = maxSpeed;
    }

    public int getTEAM() {
        return TEAM;
    }

    public void setTEAM(int TEAM) {
        this.TEAM = TEAM;
    }

    public float getMAX_SPEED() {
        return MAX_SPEED;
    }

    public void setMAX_SPEED(float MAX_SPEED) {
        this.MAX_SPEED = MAX_SPEED;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDirection() {
        return direction;
    }

    public  void setDirection(int direction) {
        this.direction = direction;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Rectangle getBoundForCollisionWithMap(){
        Rectangle bound = new Rectangle();
        bound.x = (int) getPosX() - width/2;
        bound.y = (int) getPosY()- height/2;
        bound.width = width;
        bound.height = height;
        return bound;
    }

    public boolean collisionWithOther(Rectangle other){
        Rectangle bound = getBoundForCollisionWithMap();
        if (bound.intersects(other)) return true;
        return  false;
    }

    public void CollisionWithMap(){
        if (direction == DIR_Y_D) {
            Rectangle futureRect = getBoundForCollisionWithMap();
            futureRect.y += speed;
            Rectangle rect = getGameWorld().map.haveCollisionWithWallBOTTOM(futureRect);
            if (rect != null) {
                setPosY(rect.y - height / 2);
            } else {
                setPosY(getPosY() + speed);
            }
        }

        if (direction == DIR_Y_U) {
            Rectangle futureRect = getBoundForCollisionWithMap();
            futureRect.y -= speed;
            Rectangle rect = getGameWorld().map.haveCollisionWithWallTOP(futureRect);
            if (rect != null) {
                setPosY(rect.y +height/2+ getGameWorld().map.BLOCK_SIZE);
            } else {
                setPosY(getPosY() - speed);
            }
        }


        if (direction == DIR_X_L) {
            Rectangle futureRect = getBoundForCollisionWithMap();
            futureRect.x -= speed;
            Rectangle rect = getGameWorld().map.haveCollisionWithWallLEFT(futureRect);
            if (rect != null) {
                setPosX(rect.x +width/2+ getGameWorld().map.BLOCK_SIZE);
            } else {
                setPosX(getPosX() - speed);
            }

        }
        if (direction == DIR_X_R) {
            Rectangle futureRect = getBoundForCollisionWithMap();
            futureRect.x += speed;
            Rectangle rect = getGameWorld().map.haveCollisionWithWallRIGHT(futureRect);
            if (rect != null) {
                setPosX(rect.x -width/2);
            } else {
                setPosX(getPosX() + speed);
            }
        }
    }

    public abstract void update();
    public abstract void render(Graphics2D g2d);
    public abstract void attack();
    public abstract void drawAnimation(Graphics2D g2d);
}
