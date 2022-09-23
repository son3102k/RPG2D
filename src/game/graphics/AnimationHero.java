package game.graphics;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;


public class AnimationHero {
    private BufferedImage image,image1,image2;
    public Animation left,right,up,down,attackd,attackl,attackr,attacku,beHurt,death;
    private BufferedImage img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15,img16,img17,img18,img19,
            img20,img21,img22,img23,img24,img25,img26,img27,img28,img29,img30,img31,img32,img33,img34,img35,img36,img37,img38,img39,img40,img41,img42,img43,img44,img45,img46,img47,img48;
    private FrameImage fimg1,fimg2,fimg3,fimg4,fimg5,fimg6,fimg7,fimg8,fimg9,fimg10,fimg11,fimg12,fimg13,fimg14,fimg15,fimg16,fimg17,fimg18,fimg19,
            fimg20,fimg21,fimg22,fimg23,fimg24,fimg25,fimg26,fimg27,fimg28,fimg29,fimg30,fimg31,fimg32,fimg33,fimg34,fimg35,fimg36,fimg37,fimg38,fimg39,fimg40,fimg41,fimg42,fimg43,fimg44,fimg45,fimg46,fimg47,fimg48;
    public AnimationHero(){
        left = new Animation();
        right = new Animation();
        up = new Animation();
        down = new Animation();
        beHurt = new Animation();
        attackl = new Animation();
        attackr = new Animation();
        attacku = new Animation();
        attackd = new Animation();
        death = new Animation();
        try {
            image = ImageIO.read(new File("Data/PlayerImage/Player.png"));
            image1 = ImageIO.read(new File("Data/GuiImage/HitEffect.png"));
            image2 = ImageIO.read(new File("Data/GuiImage/EnemyDeathEffect.png"));
        } catch (Exception e) {}

        img1 = image.getSubimage(15,19,30,30);
        fimg1 = new FrameImage("f1",img1);
        right.add(fimg1);
        img2 = image.getSubimage(80,19,30,30);
        fimg2 = new FrameImage("f2",img2);
        right.add(fimg2);
        img3 = image.getSubimage(144,19,30,30);
        fimg3 = new FrameImage("f3",img3);
        right.add(fimg3);
        img4 = image.getSubimage(209,19,30,30);
        fimg4 = new FrameImage("f4",img4);
        right.add(fimg4);
        img5 = image.getSubimage(270,19,30,30);
        fimg5 = new FrameImage("f5",img5);
        right.add(fimg5);
        img6 = image.getSubimage(335,19,30,30);
        fimg6 = new FrameImage("f6",img6);
        right.add(fimg6);
        img7 = image.getSubimage(399,19,30,30);
        fimg7 = new FrameImage("f7",img7);
        up.add(fimg7);
        img8 = image.getSubimage(465,19,30,30);
        fimg8 = new FrameImage("f8",img8);
        up.add(fimg8);
        img9 = image.getSubimage(530,19,30,30);
        fimg9 = new FrameImage("f9",img9);
        up.add(fimg9);
        img10 = image.getSubimage(591,19,30,30);
        fimg10 = new FrameImage("f10",img10);
        up.add(fimg10);
        img11 = image.getSubimage(656,19,30,30);
        fimg11 = new FrameImage("f11",img11);
        up.add(fimg11);
        img12 = image.getSubimage(721,19,30,30);
        fimg12 = new FrameImage("f12",img12);
        up.add(fimg12);
        img13 = image.getSubimage(789,19,30,30);
        fimg13 = new FrameImage("f13",img13);
        left.add(fimg13);
        img14 = image.getSubimage(851,19,30,30);
        fimg14 = new FrameImage("f14",img14);
        left.add(fimg14);
        img15 = image.getSubimage(916,19,30,30);
        fimg15 = new FrameImage("f15",img15);
        left.add(fimg15);
        img16 = image.getSubimage(978,19,30,30);
        fimg16 = new FrameImage("f16",img16);
        left.add(fimg16);
        img17 = image.getSubimage(1044,19,30,30);
        fimg17 = new FrameImage("f17",img17);
        left.add(fimg17);
        img18 = image.getSubimage(1107,19,30,30);
        fimg18 = new FrameImage("f18",img18);
        left.add(fimg18);
        img19 = image.getSubimage(1168,19,30,30);
        fimg19 = new FrameImage("f19",img19);
        down.add(fimg19);
        img20 = image.getSubimage(1234,19,30,30);
        fimg20 = new FrameImage("f20",img20);
        down.add(fimg20);
        img21 = image.getSubimage(1300,19,30,30);
        fimg21 = new FrameImage("f21",img21);
        down.add(fimg21);
        img22 = image.getSubimage(1360,19,30,30);
        fimg22 = new FrameImage("f22",img22);
        down.add(fimg22);
        img23 = image.getSubimage(1424,19,30,30);
        fimg23 = new FrameImage("f23",img23);
        down.add(fimg23);
        img24 = image.getSubimage(1489,19,30,30);
        fimg24 = new FrameImage("f24",img24);
        down.add(fimg24);
        img25 = image.getSubimage(1553,15,40,30);
        fimg25 = new FrameImage("f25",img25);
        attackr.add(fimg25);
        img26 = image.getSubimage(1618,15,40,30);
        fimg26 = new FrameImage("f26",img26);
        attackr.add(fimg26);
        img27 = image.getSubimage(1680,15,40,30);
        fimg27 = new FrameImage("f27",img27);
        attackr.add(fimg27);
        img28 = image.getSubimage(1744,15,40,30);
        fimg28 = new FrameImage("f28",img28);
        attackr.add(fimg28);
        img29 = image.getSubimage(1802,7,41,39);
        fimg29 = new FrameImage("f29",img29);
        attacku.add(fimg29);
        img30 = image.getSubimage(1870,7,40,40);
        fimg30 = new FrameImage("f30",img30);
        attacku.add(fimg30);
        img31 = image.getSubimage(1930,7,40,40);
        fimg31 = new FrameImage("f31",img31);
        attacku.add(fimg31);
        img32 = image.getSubimage(1995,7,40,40);
        fimg32 = new FrameImage("f32",img32);
        attacku.add(fimg32);
        img33 = image.getSubimage(2056,14,40,40);
        fimg33 = new FrameImage("f33",img33);
        attackl.add(fimg33);
        img34 = image.getSubimage(2114,14,40,40);
        fimg34 = new FrameImage("f34",img34);
        attackl.add(fimg34);
        img35 = image.getSubimage(2184,14,40,40);
        fimg35 = new FrameImage("f35",img35);
        attackl.add(fimg35);
        img36 = image.getSubimage(2246,14,40,40);
        fimg36 = new FrameImage("f36",img36);
        attackl.add(fimg36);
        img37 = image.getSubimage(2316,19,40,40);
        fimg37 = new FrameImage("f37",img37);
        attackd.add(fimg37);
        img38 = image.getSubimage(2376,19,40,40);
        fimg38 =  new FrameImage("f38",img38);
        attackd.add(fimg38);
        img39 = image.getSubimage(2439,19,40,40);
        fimg39 = new FrameImage("f39",img39);
        attackd.add(fimg39);
        img40 = image.getSubimage(2509,19,40,40);
        fimg40 = new FrameImage("f40",img40);
        attackd.add(fimg40);
        img41 = image1.getSubimage(0,0,24,24);
        fimg41 = new FrameImage("f42",img41);
        beHurt.add(fimg41);
        img42 = image1.getSubimage(24,0,24,24);
        fimg42 = new FrameImage("f43",img42);
        beHurt.add(fimg42);
        img43 = image2.getSubimage(129,0,29,29);
        fimg43 = new FrameImage("f43",img43);
        death.add(fimg43);
        img44 = image2.getSubimage(164,0,25,28);
        fimg44 = new FrameImage("f44",img44);
        death.add(fimg44);
        img45 = image2.getSubimage(192,0,31,32);
        fimg45 = new FrameImage("f45",img45);
        death.add(fimg45);
        img46 = image2.getSubimage(224,0,32,32);
        fimg46 = new FrameImage("f46",img46);
        death.add(fimg46);
        img47 = image2.getSubimage(256,0,32,32);
        fimg47 = new FrameImage("f47",img47);
        death.add(fimg47);
        img48 = image2.getSubimage(288,0,32,32);
        fimg48 = new FrameImage("f48",img48);
        death.add(fimg48);
    }

    public void up(int x, int y, Graphics2D g2d,long current){
        up.update(current);
        up.draw(x,y,g2d);
    }

    public void down(int x, int y, Graphics2D g2d,long current){
        down.update(current);
        down.draw(x,y,g2d);
    }

    public void left(int x, int y, Graphics2D g2d,long current){
        left.update(current);
        left.draw(x,y,g2d);
    }

    public void right(int x, int y, Graphics2D g2d,long current) {
        right.update(current);
        right.draw(x,y,g2d);
    }

    public void attackRight(int x, int y, Graphics2D g2d,long current){
        attackr.update(current);
        attackr.draw(x,y,g2d);
    }

    public void attackUp(int x, int y, Graphics2D g2d,long current){
        attacku.update(current);
        attacku.draw(x,y,g2d);
    }
    public void attackLeft(int x, int y, Graphics2D g2d,long current){
        attackl.update(current);
        attackl.draw(x,y,g2d);
    }
    public void attackDown(int x, int y, Graphics2D g2d,long current){
        attackd.update(current);
        attackd.draw(x,y,g2d);
    }

    public void hurt(int x, int y, Graphics2D g2d,long current){
        beHurt.update(current);
        beHurt.draw(x,y,g2d);
    }

    public void death(int x, int y, Graphics2D g2d,long current){
        death.update(current);
        death.draw(x,y,g2d);
    }
}
