package game.graphics;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

public class AnimationMonster {
	private BufferedImage img0,img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15,img16,img17,img18,img19,img20,img21,img22,img23,img24,img25,img26,img27,img28,img29,img30,img31,img32,img33,img34,img35,img36,img37,img38,img39,img40,img41,img42,img43,img44,img45,img46,img47,img48,img49,img50,img51,img52,img53,img54,img55,img56,img57,img58,img59,img60,img61,img62,img63,img64,img65,img66,img67,img68,img69,img70,img71,img72,img73,img74,img75,img76,img77,img78,img79,img80,img81,img82,img83,img84,img85,img86,img87,img88,img89,img90,img91,img92,img93,img94,img95,img96,img97,img98;
    public Animation monster_Right,monster_Left,monster_Death,monster_AttackRight,monster_AttackLeft,monster_HurtRight,monster_HurtLeft;

    private FrameImage frame0,frame1,frame2,frame3,frame4,frame5,frame6,frame7,frame8,frame9,frame10,frame11,frame12,frame13,frame14,frame15,frame16,frame17,frame18,frame19,frame20,frame21,frame22,frame23,frame24,frame25,frame26,frame27,frame28,frame29,frame30,frame31,frame32,frame33,frame34,frame35,frame36,frame37,frame38,frame39,frame40,frame41,frame42,frame43,frame44,frame45,frame46,frame47,frame48,frame49,frame50,frame51,frame52,frame53,frame54,frame55,frame56,frame57,frame58,frame59,frame60,frame61,frame62,frame63,frame64,frame65,frame66,frame67,frame68,frame69,frame70,frame71,frame72,frame73,frame74,frame75,frame76,frame77,frame78,frame79,frame80,frame81,frame82,frame83,frame84,frame85,frame86,frame87,frame88,frame89,frame90,frame91,frame92,frame93,frame94,frame95,frame96,frame97,frame98,frame99,frame100;
    public AnimationMonster(){
    	monster_Right = new Animation();
    	monster_Left= new Animation();
    	monster_Death = new Animation();
    	monster_AttackRight = new Animation();
    	monster_AttackLeft = new Animation();
    	monster_HurtRight = new Animation();
    	monster_HurtLeft = new Animation();
    	try {
    		//WalkingRight
            img0 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Walking_000.png"));
            img1 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Walking_001.png"));
            img2 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Walking_002.png"));
            img3 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Walking_003.png"));
            img4 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Walking_004.png"));
            img5 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Walking_005.png"));
            img6 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Walking_006.png"));
            img7 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Walking_007.png"));
            img8 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Walking_008.png"));
            img9 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Walking_009.png"));
            img10 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Walking_010.png"));
            img11 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Walking_011.png"));
            img12 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Walking_012.png"));
            img13 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Walking_013.png"));
            img14 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Walking_014.png"));
            img15 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Walking_015.png"));
            img16 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Walking_016.png"));
            img17 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Walking_017.png"));
            //WalkingLeft
            img57 = ImageIO.read(new File("Data/EnemyImage/SatyrWalking_000.png"));
            img58 = ImageIO.read(new File("Data/EnemyImage/SatyrWalking_001.png"));
            img59 = ImageIO.read(new File("Data/EnemyImage/SatyrWalking_002.png"));
            img60 = ImageIO.read(new File("Data/EnemyImage/SatyrWalking_003.png"));
            img61 = ImageIO.read(new File("Data/EnemyImage/SatyrWalking_004.png"));
            img62 = ImageIO.read(new File("Data/EnemyImage/SatyrWalking_005.png"));
            img63 = ImageIO.read(new File("Data/EnemyImage/SatyrWalking_006.png"));
            img64 = ImageIO.read(new File("Data/EnemyImage/SatyrWalking_007.png"));
            img65 = ImageIO.read(new File("Data/EnemyImage/SatyrWalking_008.png"));
            img66 = ImageIO.read(new File("Data/EnemyImage/SatyrWalking_009.png"));
            img67 = ImageIO.read(new File("Data/EnemyImage/SatyrWalking_010.png"));
            img68 = ImageIO.read(new File("Data/EnemyImage/SatyrWalking_011.png"));
            img69 = ImageIO.read(new File("Data/EnemyImage/SatyrWalking_012.png"));
            img70 = ImageIO.read(new File("Data/EnemyImage/SatyrWalking_013.png"));
            img71 = ImageIO.read(new File("Data/EnemyImage/SatyrWalking_014.png"));
            img72 = ImageIO.read(new File("Data/EnemyImage/SatyrWalking_015.png"));
            img73 = ImageIO.read(new File("Data/EnemyImage/SatyrWalking_016.png"));
            img74 = ImageIO.read(new File("Data/EnemyImage/SatyrWalking_017.png"));
            //Attackingright
            img18 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Attacking_000.png"));
            img19 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Attacking_001.png"));
            img20 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Attacking_002.png"));
            img21 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Attacking_003.png"));
            img22 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Attacking_004.png"));
            img23 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Attacking_005.png"));
            img24 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Attacking_006.png"));
            img25 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Attacking_007.png"));
            img26 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Attacking_008.png"));
            img27 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Attacking_009.png"));
            img28 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Attacking_010.png"));
            img29 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Attacking_011.png"));
            //Attackingleft
            img75 = ImageIO.read(new File("Data/EnemyImage/SatyrAttacking_000.png"));
            img76 = ImageIO.read(new File("Data/EnemyImage/SatyrAttacking_001.png"));
            img77 = ImageIO.read(new File("Data/EnemyImage/SatyrAttacking_002.png"));
            img78 = ImageIO.read(new File("Data/EnemyImage/SatyrAttacking_003.png"));
            img79 = ImageIO.read(new File("Data/EnemyImage/SatyrAttacking_004.png"));
            img80 = ImageIO.read(new File("Data/EnemyImage/SatyrAttacking_005.png"));
            img81 = ImageIO.read(new File("Data/EnemyImage/SatyrAttacking_006.png"));
            img82 = ImageIO.read(new File("Data/EnemyImage/SatyrAttacking_007.png"));
            img83 = ImageIO.read(new File("Data/EnemyImage/SatyrAttacking_008.png"));
            img84 = ImageIO.read(new File("Data/EnemyImage/SatyrAttacking_009.png"));
            img85 = ImageIO.read(new File("Data/EnemyImage/SatyrAttacking_010.png"));
            img86 = ImageIO.read(new File("Data/EnemyImage/SatyrAttacking_011.png"));
            //Dying
            img30 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Dying_000.png"));
            img31 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Dying_001.png"));
            img32 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Dying_002.png"));
            img33 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Dying_003.png"));
            img34 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Dying_004.png"));
            img35 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Dying_005.png"));
            img36 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Dying_006.png"));
            img37 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Dying_007.png"));
            img38 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Dying_008.png"));
            img39 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Dying_009.png"));
            img40 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Dying_010.png"));
            img41 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Dying_011.png"));
            img42 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Dying_012.png"));
            img43 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Dying_013.png"));
            img44 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Dying_014.png"));
            //Hurtright
            img45 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Hurt_000.png"));
            img46 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Hurt_001.png"));
            img47 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Hurt_002.png"));
            img48 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Hurt_003.png"));
            img49 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Hurt_004.png"));
            img50 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Hurt_005.png"));
            img51 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Hurt_006.png"));
            img52 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Hurt_007.png"));
            img53 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Hurt_008.png"));
            img54 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Hurt_009.png"));
            img55 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Hurt_010.png"));
            img56 = ImageIO.read(new File("Data/EnemyImage/Satyr_01_Hurt_011.png"));
            //Hurtleft
            img87 = ImageIO.read(new File("Data/EnemyImage/SatyrHurt_000.png"));
            img88 = ImageIO.read(new File("Data/EnemyImage/SatyrHurt_001.png"));
            img89 = ImageIO.read(new File("Data/EnemyImage/SatyrHurt_002.png"));
            img90 = ImageIO.read(new File("Data/EnemyImage/SatyrHurt_003.png"));
            img91 = ImageIO.read(new File("Data/EnemyImage/SatyrHurt_004.png"));
            img92 = ImageIO.read(new File("Data/EnemyImage/SatyrHurt_005.png"));
            img93 = ImageIO.read(new File("Data/EnemyImage/SatyrHurt_006.png"));
            img94 = ImageIO.read(new File("Data/EnemyImage/SatyrHurt_007.png"));
            img95 = ImageIO.read(new File("Data/EnemyImage/SatyrHurt_008.png"));
            img96 = ImageIO.read(new File("Data/EnemyImage/SatyrHurt_009.png"));
            img97 = ImageIO.read(new File("Data/EnemyImage/SatyrHurt_010.png"));
            img98 = ImageIO.read(new File("Data/EnemyImage/SatyrHurt_011.png"));

        } catch (Exception e) {}
    	//right
//    	frame0 = new FrameImage("frame0",img0);
//        monster_Right.add(frame0);
        frame1 = new FrameImage("frame1",img1);
        monster_Right.add(frame1);
        frame2 = new FrameImage("frame2",img2);
        monster_Right.add(frame2);
        frame3 = new FrameImage("frame3",img3);
        monster_Right.add(frame3);
        frame4 = new FrameImage("frame4",img4);
        monster_Right.add(frame4);
        frame5 = new FrameImage("frame5",img5);
        monster_Right.add(frame5);
        frame6 = new FrameImage("frame6",img6);
        monster_Right.add(frame6);
        frame7 = new FrameImage("frame7",img7);
        monster_Right.add(frame7);
        frame8 = new FrameImage("frame8",img8);
        monster_Right.add(frame8);
        frame9 = new FrameImage("frame9",img9);
        monster_Right.add(frame9);
        frame10 = new FrameImage("frame10",img10);
        monster_Right.add(frame10);
        frame11 = new FrameImage("frame11",img11);
        monster_Right.add(frame11);
        frame12 = new FrameImage("frame12",img12);
        monster_Right.add(frame12);
        frame13 = new FrameImage("frame13",img13);
        monster_Right.add(frame13);
        frame14 = new FrameImage("frame14",img14);
        monster_Right.add(frame14);
        frame15 = new FrameImage("frame15",img15);
        monster_Right.add(frame15);
        frame16 = new FrameImage("frame16",img16);
        monster_Right.add(frame16);
        frame17 = new FrameImage("frame17",img17);
        monster_Right.add(frame17);
        //left
//        frame18 = new FrameImage("frame18",img0);
//        monster_Left.add(frame18);
        frame19= new FrameImage("frame19",img58);
        monster_Left.add(frame19);
        frame20 = new FrameImage("frame20",img59);
        monster_Left.add(frame20);
        frame21 = new FrameImage("frame21",img60);
        monster_Left.add(frame21);
        frame22 = new FrameImage("frame22",img61);
        monster_Left.add(frame22);
        frame23 = new FrameImage("frame23",img62);
        monster_Left.add(frame23);
        frame24 = new FrameImage("frame24",img63);
        monster_Left.add(frame24);
        frame25 = new FrameImage("frame25",img64);
        monster_Left.add(frame25);
        frame26 = new FrameImage("frame26",img65);
        monster_Left.add(frame26);
        frame27 = new FrameImage("frame27",img66);
        monster_Left.add(frame27);
        frame28 = new FrameImage("frame28",img67);
        monster_Left.add(frame28);
        frame29 = new FrameImage("frame29",img68);
        monster_Left.add(frame29);
        frame30 = new FrameImage("frame30",img69);
        monster_Left.add(frame30);
        frame31 = new FrameImage("frame31",img70);
        monster_Left.add(frame31);
        frame32 = new FrameImage("frame32",img71);
        monster_Left.add(frame32);
        frame33 = new FrameImage("frame33",img72);
        monster_Left.add(frame33);
        frame34 = new FrameImage("frame34",img73);
        monster_Left.add(frame34);
        frame35 = new FrameImage("frame35",img74);
        monster_Left.add(frame35);
        //die
        frame36 = new FrameImage("frame36",img30);
        monster_Death.add(frame36);
        frame37 = new FrameImage("frame37",img31);
        monster_Death.add(frame37);
        frame38 = new FrameImage("frame38",img32);
        monster_Death.add(frame38);
        frame39 = new FrameImage("frame39",img33);
        monster_Death.add(frame39);
        frame40 = new FrameImage("frame40",img34);
        monster_Death.add(frame40);
        frame41 = new FrameImage("frame41",img35);
        monster_Death.add(frame41);
        frame42 = new FrameImage("frame42",img36);
        monster_Death.add(frame42);
        frame43 = new FrameImage("frame43",img37);
        monster_Death.add(frame43);
        frame44 = new FrameImage("frame44",img38);
        monster_Death.add(frame44);
        frame45 = new FrameImage("frame45",img39);
        monster_Death.add(frame45);
        frame46 = new FrameImage("frame46",img40);
        monster_Death.add(frame46);
        frame47 = new FrameImage("frame47",img41);
        monster_Death.add(frame47);
        frame48 = new FrameImage("frame48",img42);
        monster_Death.add(frame48);
        frame49 = new FrameImage("frame49",img43);
        monster_Death.add(frame49);
        frame50 = new FrameImage("frame50",img44);
        monster_Death.add(frame50);
        //attackright
        frame51 = new FrameImage("frame51",img18);
        monster_AttackRight.add(frame51);
        frame52 = new FrameImage("frame52",img19);
        monster_AttackRight.add(frame52);
        frame53 = new FrameImage("frame53",img20);
        monster_AttackRight.add(frame53);
       // frame54 = new FrameImage("frame54",img21);
       // monster_Attack.add(frame54);
        frame55 = new FrameImage("frame55",img22);
        monster_AttackRight.add(frame55);
        frame56 = new FrameImage("frame56",img23);
        monster_AttackRight.add(frame56);
        frame57 = new FrameImage("frame57",img24);
        monster_AttackRight.add(frame57);
        frame58 = new FrameImage("frame58",img25);
        monster_AttackRight.add(frame58);
        frame59 = new FrameImage("frame59",img26);
        monster_AttackRight.add(frame59);
        frame60 = new FrameImage("frame60",img27);
        monster_AttackRight.add(frame60);
        frame61 = new FrameImage("frame61",img28);
        monster_AttackRight.add(frame61);
        frame62 = new FrameImage("frame62",img29);
        monster_AttackRight.add(frame62);
        //attackleft
        frame75 = new FrameImage("frame75",img75);
        monster_AttackLeft.add(frame75);
        frame76 = new FrameImage("frame76",img76);
        monster_AttackLeft.add(frame76);
        frame77 = new FrameImage("frame77",img77);
        monster_AttackLeft.add(frame77);
//        frame78 = new FrameImage("frame78",img78);
//        monster_AttackLeft.add(frame78);
        frame79 = new FrameImage("frame79",img79);
        monster_AttackLeft.add(frame79);
        frame80 = new FrameImage("frame80",img80);
        monster_AttackLeft.add(frame80);
        frame81 = new FrameImage("frame81",img81);
        monster_AttackLeft.add(frame81);
        frame82 = new FrameImage("frame82",img82);
        monster_AttackLeft.add(frame82);
        frame83 = new FrameImage("frame83",img83);
        monster_AttackLeft.add(frame83);
        frame84 = new FrameImage("frame84",img84);
        monster_AttackLeft.add(frame84);
        frame85 = new FrameImage("frame85",img85);
        monster_AttackLeft.add(frame85);
        frame86 = new FrameImage("frame86",img86);
        monster_AttackLeft.add(frame86);
        //hurtright
        frame63 = new FrameImage("frame63",img45);
        monster_HurtRight.add(frame63);
        frame64 = new FrameImage("frame64",img46);
        monster_HurtRight.add(frame64);
        frame65 = new FrameImage("frame65",img47);
        monster_HurtRight.add(frame65);
        frame66 = new FrameImage("frame66",img48);
        monster_HurtRight.add(frame66);
        frame67 = new FrameImage("frame67",img49);
        monster_HurtRight.add(frame67);
        frame68 = new FrameImage("frame68",img50);
        monster_HurtRight.add(frame68);
        frame69 = new FrameImage("frame69",img51);
        monster_HurtRight.add(frame69);
        frame70 = new FrameImage("frame70",img52);
        monster_HurtRight.add(frame70);
        frame71 = new FrameImage("frame71",img53);
        monster_HurtRight.add(frame71);
        frame72 = new FrameImage("frame72",img54);
        monster_HurtRight.add(frame72);
        frame73 = new FrameImage("frame73",img55);
        monster_HurtRight.add(frame73);
        frame74 = new FrameImage("frame74",img56);
        monster_HurtRight.add(frame74);
        //hurtleft
        frame87 = new FrameImage("frame87",img87);
        monster_HurtLeft.add(frame87);
        frame88 = new FrameImage("frame88",img88);
        monster_HurtLeft.add(frame88);
        frame89 = new FrameImage("frame89",img89);
        monster_HurtLeft.add(frame89);
        frame90 = new FrameImage("frame90",img90);
        monster_HurtLeft.add(frame90);
        frame91 = new FrameImage("frame91",img91);
        monster_HurtLeft.add(frame91);
        frame92 = new FrameImage("frame92",img92);
        monster_HurtLeft.add(frame92);
        frame93 = new FrameImage("frame93",img93);
        monster_HurtLeft.add(frame93);
        frame94 = new FrameImage("frame94",img94);
        monster_HurtLeft.add(frame94);
        frame95 = new FrameImage("frame95",img95);
        monster_HurtLeft.add(frame95);
        frame96 = new FrameImage("frame96",img96);
        monster_HurtLeft.add(frame96);
        frame97 = new FrameImage("frame97",img97);
        monster_HurtLeft.add(frame97);
        frame98 = new FrameImage("frame98",img98);
        monster_HurtLeft.add(frame98);
    }
    public void right(int x, int y, Graphics2D g2d, long current){
        monster_Right.update(current);
        monster_Right.draw(x,y,g2d);
    }

    public void left(int x, int y, Graphics2D g2d, long current){
        monster_Left.update(current);
        monster_Left.draw(x,y,g2d);
    }

    public void death(int x, int y, Graphics2D g2d , long current) {
        monster_Death.update(current);
        monster_Death.draw(x,y,g2d);
    }

    public void hurtr(int x, int y, Graphics2D g2d , long current) {
        monster_HurtRight.update(current);
        monster_HurtRight.draw(x, y, g2d);
    }
    public void hurtl(int x, int y, Graphics2D g2d , long current) {
        monster_HurtLeft.update(current);
        monster_HurtLeft.draw(x, y, g2d);
    }
    public void attackr(int x, int y, Graphics2D g2d , long current) {
        monster_AttackRight.update(current);
        monster_AttackRight.draw(x, y, g2d);
    }
    public void attackl(int x, int y, Graphics2D g2d , long current) {
        monster_AttackLeft.update(current);
        monster_AttackLeft.draw(x, y, g2d);
    }
}
