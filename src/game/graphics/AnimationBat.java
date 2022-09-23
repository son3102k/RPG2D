package game.graphics;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

public class AnimationBat {
    private BufferedImage image,image1,image2,image3,img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15,img16,img17,img18;
    public Animation bat_Right,bat_Left,bat_Death,bat_Hurt;

    private FrameImage frame1,frame2,frame3,frame4,frame5,frame6,frame7,frame8,frame9,frame10,frame11,frame12,frame13,frame14,frame15,frame16,frame17,frame18;
    public AnimationBat(){
        bat_Right = new Animation();
        bat_Left = new Animation();
        bat_Death = new Animation();
        bat_Hurt = new Animation();
        try {
            image = ImageIO.read(new File("Data/BatImage/Bat.png"));
            image1 = ImageIO.read(new File("Data/BatImage/bat1.png"));
            image2 = ImageIO.read(new File("Data/GuiImage/EnemyDeathEffect.png"));
            image3 = ImageIO.read(new File("Data/GuiImage/HitEffect.png"));
        } catch (Exception e) {}
        img1 = image.getSubimage(0,0,16,16);
        frame1 = new FrameImage("frame1",img1);
        bat_Right.add(frame1);
        img2 = image.getSubimage(16,0,16,16);
        frame2 = new FrameImage("frame2",img2);
        bat_Right.add(frame2);
        img3 = image.getSubimage(32,0,16,16);
        frame3 = new FrameImage("frame3",img3);
        bat_Right.add(frame3);
        img4 = image.getSubimage(48,0,16,16);
        frame4 = new FrameImage("frame4",img4);
        bat_Right.add(frame4);
        img5 = image.getSubimage(64,0,16,16);
        frame5 = new FrameImage("frame5",img5);
        bat_Right.add(frame5);

        img6 = image1.getSubimage(64,0,16,16);
        frame6 = new FrameImage("frame6",img6);
        bat_Left.add(frame6);
        img7 = image1.getSubimage(48,0,16,16);
        frame7 = new FrameImage("frame7",img7);
        bat_Left.add(frame7);
        img8 = image1.getSubimage(32,0,16,16);
        frame8 = new FrameImage("frame8",img8);
        bat_Left.add(frame8);
        img9 = image1.getSubimage(16,0,16,16);
        frame9 = new FrameImage("frame9",img9);
        bat_Left.add(frame9);
        img10 = image1.getSubimage(0,0,16,16);
        frame10 = new FrameImage("frame1",img10);
        bat_Left.add(frame10);

        img11 = image2.getSubimage(129,0,29,29);
        frame11 = new FrameImage("f11",img11);
        bat_Death.add(frame11);
        img12 = image2.getSubimage(164,0,25,28);
        frame12 = new FrameImage("f12",img12);
        bat_Death.add(frame12);
        img13 = image2.getSubimage(192,0,31,32);
        frame13 = new FrameImage("f13",img13);
        bat_Death.add(frame13);
        img14 = image2.getSubimage(224,0,32,32);
        frame14 = new FrameImage("f14",img14);
        bat_Death.add(frame14);
        img15 = image2.getSubimage(256,0,32,32);
        frame15 = new FrameImage("f15",img15);
        bat_Death.add(frame15);
        img16 = image2.getSubimage(288,0,32,32);
        frame16 = new FrameImage("f16",img16);
        bat_Death.add(frame16);
        img17 = image3.getSubimage(0,0,24,24);
        frame17 = new FrameImage("f17",img17);
        bat_Hurt.add(frame17);
        img18 = image3.getSubimage(24,0,24,24);
        frame18 = new FrameImage("f18",img18);
        bat_Hurt.add(frame18);
    }

    public void right(int x, int y, Graphics2D g2d, long current){
        bat_Right.update(current);
        bat_Right.draw(x,y,g2d);
    }

    public void left(int x, int y, Graphics2D g2d, long current){
        bat_Left.update(current);
        bat_Left.draw(x,y,g2d);
    }

    public void death(int x, int y, Graphics2D g2d , long current) {
        bat_Death.update(current);
        bat_Death.draw(x,y,g2d);
    }

    public void hurt(int x, int y, Graphics2D g2d , long current) {
        bat_Hurt.update(current);
        bat_Hurt.draw(x, y, g2d);
    }



}
