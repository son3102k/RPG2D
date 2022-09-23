package game.object;

import game.MainFrame;
import game.tile.tileManager;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JDialog;
import javax.swing.JOptionPane;


public class Map extends GameObject {
    private tileManager title;
    public final int BLOCK_SIZE =32;
    private int width,height;
    private int currentMap;

    private int mainMap = 1;
    private int caveMap = 2;
    private int winterMap = 3;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Map(float x, float y, GameWorld gameWorld){
        super(x,y,gameWorld);
        title = new tileManager();
        title.getmainMap();
        currentMap = mainMap;
        setWidth(title.col*BLOCK_SIZE);
        setHeight(title.row*BLOCK_SIZE);
    }

    @Override
    public void update() {
        transMap();

    }

    public void draw(Graphics2D g2d){
        Camera camera = getGameWorld().camera;
        BufferedImage subImage = title.backGround.getSubimage((int)camera.getPosX(),(int)camera.getPosY(),(int)camera.getWidthView(),(int)camera.getHeightView());
        g2d.drawImage(subImage,0,0,null);
    }

    public Rectangle haveCollisionWithWallBOTTOM(Rectangle rect) {
        int X1 = rect.x/BLOCK_SIZE;;
        int X2 = (rect.x + rect.width)/BLOCK_SIZE;
        int Y = (rect.y+rect.height)/BLOCK_SIZE;
        if (Y<0) Y=0;

        X1 -=1;
        X2 +=1;
        if (X1<0) X1 =0;
        if (X2>=title.psyMap[0].length-1) X2 = title.psyMap[0].length-1;
        for (int x = X1 ; x <= X2 ; x++){
            for (int y= Y ; y < Y+1;y++)
                if (title.psyMap[y][x]!=1){
                    Rectangle r = new Rectangle((int) getPosX() + x*BLOCK_SIZE,(int) getPosY() + y*BLOCK_SIZE,BLOCK_SIZE,BLOCK_SIZE);
                    if (rect.intersects(r)) return r;
                }
        }
        return null;
    }

    public Rectangle haveCollisionWithWallTOP(Rectangle rect) {
        int X1 = rect.x/BLOCK_SIZE;;
        int X2 = (rect.x + rect.width)/BLOCK_SIZE;
        int Y = rect.y/BLOCK_SIZE;
        if (Y<0) Y=0;

        X1 -=1;
        X2 +=1;
        if (X1<0) X1 =0;
        if (X2>=title.psyMap[0].length-1) X2 = title.psyMap[0].length-1;

        for (int y = Y ; y >= 0 ; y--){
            for (int x = X1 ; x <= X2 ; x++)
                if (title.psyMap[y][x]!=1){
                    Rectangle r = new Rectangle((int) getPosX() + x*BLOCK_SIZE,(int) getPosY() + y*BLOCK_SIZE,BLOCK_SIZE,BLOCK_SIZE);
                    if (rect.intersects(r)) return r;
                }
        }
        return null;
    }

    public Rectangle haveCollisionWithWallLEFT(Rectangle rect) {
        int X = rect.x / BLOCK_SIZE;
        int Y1 = rect.y / BLOCK_SIZE;
        int Y2 = (rect.y + rect.height) / BLOCK_SIZE;
        Y1-=1;
        Y2+=1;

        if (X<0) X=0;

        if (Y1<0) Y1=0;
        if (Y2>=title.psyMap.length-1) Y2 = title.psyMap.length-1;

        for (int x = X ; x>=0 ;x-- ){
            for (int y=Y1 ; y<=Y2; y++){
                if (title.psyMap[y][x]!=1){
                    Rectangle r = new Rectangle((int) getPosX() + x*BLOCK_SIZE,(int) getPosY() + y*BLOCK_SIZE,BLOCK_SIZE,BLOCK_SIZE);
                    if (rect.intersects(r)) return r;
                }
            }
        }
        return null;
    }

    public Rectangle haveCollisionWithWallRIGHT(Rectangle rect) {
        int X = (rect.x + rect.width) / BLOCK_SIZE;
        int Y1 = rect.y / BLOCK_SIZE;
        int Y2 = (rect.y + rect.height) / BLOCK_SIZE;
        Y1-=1;
        Y2+=1;
        if (X<0) X=0;
        if (X > title.psyMap[0].length) X = title.psyMap[0].length -1;

        if (Y1 < 0) Y1 = 0;
        if (Y2 >= title.psyMap.length - 1) Y2 = title.psyMap.length - 1;

            for (int y = Y1 ; y <= Y2; y++) {
                if (title.psyMap[y][X] != 1) {
                    Rectangle r = new Rectangle((int) getPosX() + X * BLOCK_SIZE, (int) getPosY() + y * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                    if (rect.intersects(r)) return r;
                }
            }
        return null;
    }

    public void transMap() {
        if (currentMap == mainMap) {
            if (getGameWorld().hero.getPosX()>=1568 && getGameWorld().hero.getPosY() >= 864 ) {
                title.getWinterMap();
                currentMap = winterMap;
                getGameWorld().hero.setPosX(50);
                getGameWorld().hero.setPosY(910);
                getGameWorld().camera.setPosX(0);
                getGameWorld().camera.setPosY(480);
                generateEnemy(0);
            }
            if (getGameWorld().hero.getPosX() <= 16 && getGameWorld().hero.getPosY() <= 96 ) {
                title.getcaveMap();
                currentMap = caveMap;
                getGameWorld().hero.setPosX(1550);
                getGameWorld().hero.setPosY(50);
                getGameWorld().camera.setPosX(880);
                getGameWorld().camera.setPosY(0);
                generateEnemy(0);
            }
        }

        if (currentMap == caveMap ) {
            if (getGameWorld().hero.getPosX() >= 1568 && getGameWorld().hero.getPosY() <= 96 ) {
                title.getmainMap();
                currentMap = mainMap;
                getGameWorld().hero.setPosX(50);
                getGameWorld().hero.setPosY(50);
                getGameWorld().camera.setPosX(0);
                getGameWorld().camera.setPosY(0);
            }
        }

        if (currentMap == winterMap ) {
            if (getGameWorld().hero.getPosX() <= 16 && getGameWorld().hero.getPosY() <= 910 ) {
                title.getmainMap();
                currentMap = mainMap;
                getGameWorld().hero.setPosX(1550);
                getGameWorld().hero.setPosY(910);
                getGameWorld().camera.setPosX(880);
                getGameWorld().camera.setPosY(480);
            }
        }
    }

    public void generateEnemy(int level) {

        Random r = new Random();
        int q = r.nextInt(10);
        if (q<5) q=5;
        for (int i=1 ; i<=q ; i++) {
            int posX = new Random().nextInt(1600);
            int posY = new Random().nextInt(960);
            Bat bat = new Bat((float)posX,(float)posY,1000,10,(float)0.9,getGameWorld());
            getGameWorld().listParticularObject.add(bat);
        }
    }
}
