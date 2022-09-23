package game.object;
import game.graphics.AnimationMonster;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Monster extends ParticularObject{
	private final int FOLLOW_WIDTH = 300;
    private final int FOLLOW_HEIGHT = 300;

    private long lastTimeAttack = 0;
    private boolean isAttack = false;
    private boolean isDeath = false;
    private boolean isHurt = false;

    private AnimationMonster animation;

	public Monster(float posX, float posY, int blood, int damage, float maxSpeed, GameWorld gameWorld) {
		super(posX, posY, blood, damage, maxSpeed, gameWorld);
		setDirection(1);
        setTEAM(ENEMY_TEAM);
        animation = new AnimationMonster();
	}
	public void render(Graphics2D g2d) {
		if (getPosX()>=getGameWorld().camera.getPosX() && getPosX()<=getGameWorld().camera.getPosX()+getGameWorld().camera.getWidthView() && getPosY()>=getGameWorld().camera.getPosY() && getPosY()<=getGameWorld().camera.getPosY()+getGameWorld().camera.getHeightView()) {
            drawAnimation(g2d);
        }
    }
	public void attack() {
        if (collisionWithHero()) {
            long current = System.nanoTime();
            if (current - lastTimeAttack > 1500 * 1000000) {
                isAttack=true;
                getGameWorld().hero.setState(BEHURT);
                getGameWorld().hero.setBlood(getGameWorld().hero.getBlood() - getDamage());
                lastTimeAttack = current;
            }
        }
    }
	public void drawAnimation(Graphics2D g2d) {

		if ((getDirection()==1)&& !isAttack && !isHurt && !isDeath){
            animation.left((int)(getPosX()-getGameWorld().camera.getPosX()),(int)(getPosY()-getGameWorld().camera.getPosY()),g2d,System.nanoTime());
        }
        if ((getDirection()==2)&& !isAttack && !isHurt && !isDeath){
            animation.right((int)(getPosX()-getGameWorld().camera.getPosX()),(int)(getPosY()-getGameWorld().camera.getPosY()),g2d,System.nanoTime());
        }
        if (isDeath) {
            animation.death((int)(getPosX()-getGameWorld().camera.getPosX()),(int)(getPosY()-getGameWorld().camera.getPosY()),g2d,System.nanoTime());
            if (animation.monster_Death.isLastFrame()) {
                remove = true;
            }
        }
        if (isHurt==true && getDirection()==2) {
            animation.hurtr((int) (getPosX() - getGameWorld().camera.getPosX()), (int) (getPosY() - getGameWorld().camera.getPosY()), g2d, System.nanoTime());
            if (animation.monster_HurtRight.isLastFrame()){
                isHurt = false;
            }
        } 
        if (isHurt==true && getDirection()==1) {
            animation.hurtl((int) (getPosX() - getGameWorld().camera.getPosX()), (int) (getPosY() - getGameWorld().camera.getPosY()), g2d, System.nanoTime());
            if (animation.monster_HurtLeft.isLastFrame()){
                isHurt = false;
            }
        }  
        if (isAttack && !isHurt && !isDeath && getDirection()==2) {
             animation.attackr((int) (getPosX() - getGameWorld().camera.getPosX()), (int) (getPosY() - getGameWorld().camera.getPosY()), g2d, System.nanoTime());
               if (animation.monster_AttackRight.isLastFrame()) {
                   isAttack = false;
               }
           }
        if (isAttack && !isHurt && !isDeath && getDirection()==1) {
            animation.attackl((int) (getPosX() - getGameWorld().camera.getPosX()), (int) (getPosY() - getGameWorld().camera.getPosY()), g2d, System.nanoTime());
              if (animation.monster_AttackLeft.isLastFrame()) {
                  isAttack = false;
              }
          }
	}
	public void update() {
        switch (getState()){
            case ALIVE:
                follow();
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
                isDeath = true;
                break;
        }
    }
	public boolean inRange(){
        Rectangle monster = new Rectangle((int)getPosX()-FOLLOW_WIDTH/2,(int)getPosY()-FOLLOW_HEIGHT/2,FOLLOW_WIDTH,FOLLOW_HEIGHT);
        Rectangle hero = getGameWorld().hero.getBoundForCollisionWithMap();
        return monster.intersects(hero);
    }
	public boolean collisionWithHero(){
        Rectangle monster = new Rectangle((int)getPosX()-getWidth()/2,(int)getPosY()-getHeight()/2,getWidth(),getHeight());
        Rectangle hero = getGameWorld().hero.getBoundForCollisionWithMap();
        return monster.intersects(hero);
    }
//	public void follow(){
//        if (inRange() && !collisionWithHero()) {
//            if (getPosY() != getGameWorld().hero.getPosY() || getPosX()!= getGameWorld().hero.getPosX()) {
//                if (getPosY() > getGameWorld().hero.getPosY()) {
//                    setPosY(getPosY() - MAX_SPEED);
//                }
//                if (getPosY() < getGameWorld().hero.getPosY()) {
//                    setPosY(getPosY() + MAX_SPEED);
//                }
//                if (getPosX() > getGameWorld().hero.getPosX()) {
//                    setPosX(getPosX() - MAX_SPEED);
//                    setDirection(1);
//                }
//                if (getPosX() < getGameWorld().hero.getPosX()) {
//                    setPosX(getPosX() + MAX_SPEED);
//                    setDirection(2);
//                }
//            }
//        }
        public void follow(){
        	if (inRange() && !collisionWithHero()) {
    		float dx= Math.abs(this.getPosX()- getGameWorld().hero.getPosX());
    		float dy= Math.abs(this.getPosY()- getGameWorld().hero.getPosY());
    		Rectangle rect4 = this.getGameWorld().map.haveCollisionWithWallBOTTOM(this.getBoundForCollisionWithMap());
    		Rectangle rect3 = this.getGameWorld().map.haveCollisionWithWallTOP(this.getBoundForCollisionWithMap());
    		Rectangle rect2 = this.getGameWorld().map.haveCollisionWithWallRIGHT(this.getBoundForCollisionWithMap());
    		Rectangle rect1 = this.getGameWorld().map.haveCollisionWithWallLEFT(this.getBoundForCollisionWithMap());
    		if(dx >= dy) {
    			if(this.getPosX()< getGameWorld().hero.getPosX())
    			 {
                          
    			if(rect2 != null) {
    				if(this.getPosY()< getGameWorld().hero.getPosY())
    					 setPosY(getPosY() + 2*MAX_SPEED);
    				if(this.getPosY()> getGameWorld().hero.getPosY())
    					setPosY(getPosY() - 2*MAX_SPEED);
    			}else {
    				setPosX(getPosX() + 2*MAX_SPEED);
                    setDirection(2);
    			}
    			 }
    			if(this.getPosX()> getGameWorld().hero.getPosX())
    			{
                    
                
    			if(rect1 != null){
    				if(this.getPosY()< getGameWorld().hero.getPosY())
    					setPosY(getPosY() + 2*MAX_SPEED);
    				if(this.getPosY()> getGameWorld().hero.getPosY())
    					setPosY(getPosY() - 2*MAX_SPEED);
    			}else {
    				setPosX(getPosX() - 2*MAX_SPEED);
                    setDirection(1);
    			}
    			}
    		}else {
    			if(this.getPosY()< getGameWorld().hero.getPosY()) {
    				
    			if(rect4 != null){
    				if(this.getPosX()< getGameWorld().hero.getPosX())    			
    				{
                        setPosX(getPosX() + 2*MAX_SPEED);
                        setDirection(2);
                    }
    				if(this.getPosX()> getGameWorld().hero.getPosX())
    				{
                        setPosX(getPosX() - 2*MAX_SPEED);
                        setDirection(1);
                    }
    			}else {
    				setPosY(getPosY() + 2*MAX_SPEED);
    			}
    			}
    			if(this.getPosY()> getGameWorld().hero.getPosY()) {
    				
    			if(rect3 != null){
    				if(this.getPosX()< getGameWorld().hero.getPosX())    			
    				{
                        setPosX(getPosX() + 2*MAX_SPEED);
                        setDirection(2);
                    }
    				if(this.getPosX()> getGameWorld().hero.getPosX())
    				{
                        setPosX(getPosX() - 2*MAX_SPEED);
                        setDirection(1);
                    }
    			}else {
    				setPosY(getPosY() - 2*MAX_SPEED);
    			}
    			}
    				
    		}
        	}
    }
}
