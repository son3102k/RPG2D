package game.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class FrameImage {
    private String name;
    private BufferedImage img;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public FrameImage(String name, BufferedImage img) {
        this.name = name;
        this.img = img;
    }

    public FrameImage(FrameImage frameImage){
        img = new BufferedImage(frameImage.getImageWidth(),frameImage.getImageHeight(),frameImage.getImg().getType());
        Graphics g = img.getGraphics();
        g.drawImage(frameImage.getImg(),0,0,null);
    }

    public int getImageWidth(){
        return img.getWidth();
    }

    public int getImageHeight(){
        return img.getHeight();
    }

    public void draw(int x ,int y,Graphics2D g2d){
        g2d.drawImage(img,x-getImageWidth()/2,y-getImageHeight()/2,null);
    }
}
