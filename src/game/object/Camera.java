package game.object;

public class Camera extends GameObject {

    private float widthView;
    private float heightView;
    private boolean isLocked=false;

    public Camera(float posX, float posY, GameWorld gameWorld,float widthView,float heightView) {
        super(posX, posY, gameWorld);
        this.widthView = widthView;
        this.heightView = heightView;
    }

    public void lock(){
        isLocked = true;
    }

    public void unlock(){
        isLocked = false;
    }

    public float getWidthView() {
        return widthView;
    }

    public void setWidthView(float widthView) {
        this.widthView = widthView;
    }

    public float getHeightView() {
        return heightView;
    }

    public void setHeightView(float heightView) {
        this.heightView = heightView;
    }

    @Override
    public void update() {
        unlock();
        if (!isLocked){
            // thiết kế sao cho cân với bản đồ

            if (getGameWorld().hero.getPosX() - getWidthView()/2 >=0) {
                if (getGameWorld().hero.getPosX() - getPosX() < getWidthView() / 2) {
                    setPosX(getGameWorld().hero.getPosX() - getWidthView() / 2);
                }
            }

            if (getGameWorld().hero.getPosX() + getWidthView()/2 <= getGameWorld().map.getWidth()) {
                if (getGameWorld().hero.getPosX() - getPosX() > getWidthView() / 2) {
                    setPosX(getGameWorld().hero.getPosX() - getWidthView() / 2);
                }
            }

            if (getGameWorld().hero.getPosY() + getHeightView()/2 <= getGameWorld().map.getHeight()) {
                if (getGameWorld().hero.getPosY() - getPosY() > getHeightView() / 2) {
                    setPosY(getGameWorld().hero.getPosY() - getHeightView() / 2);
                }
            }

            if (getGameWorld().hero.getPosY() - getHeightView()/2 >=0) {
                if (getGameWorld().hero.getPosY() - getPosY() < getHeightView() / 2) {
                    setPosY(getGameWorld().hero.getPosY() - getHeightView() / 2);
                }
            }
        }

    }
}
