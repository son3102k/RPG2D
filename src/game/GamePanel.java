package game;
import game.inputKey.inputManager;
import game.object.GameWorld;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class GamePanel extends JPanel implements Runnable,KeyListener {
    public static int width;
    public static int height;
    public static int level;
    private boolean CheckAliveLoop;



    private boolean running = false;
    private static boolean pause = false;
    private Thread thread;
    private double averageFPS = 0;
    private BufferedImage bufferedImage;
    private Graphics2D bufG2D;
    private GameWorld gameWorld;
    private inputManager input;
    private GameFrame gameframe;


    public GamePanel(int width, int height, GameFrame gameframe) {
    	this.width = width;
        this.height = height;
        this.gameframe = gameframe;
        CheckAliveLoop = true;
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocus();
        gameWorld = new GameWorld((float) 0, (float) 0,width,height);
        running = true;
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        input = new inputManager(gameWorld);
        addKeyListener(this);
        newThread();

    }
    public void setLevel(int level2){
        
        level = level2;
        gameWorld.setLevel(level);
    }

    public void newThread() {
        if (thread == null) {
            thread = new Thread(this, "Game thread");
            thread.start();
        }
    }


    public void run() {

        final double GAME_HERZT = 60.0;
        final double TBU = 1000000000/GAME_HERZT; // time before update
        final int MUBR =5; // must update before render

        double lastUpdateTime = System.nanoTime();
        double lastRenderTime;

        final double TARGET_FPS = 60;
        final double TTBR = 1000000000/TARGET_FPS; // total time before render;

        int frameCount=0;
        int lastSecondTime = (int) (lastUpdateTime/1000000000);
        int oldFrameCount=0;


        while (running) {
            double now = System.nanoTime();
            int updateCount=0;
            while((now -lastUpdateTime>TBU && updateCount<MUBR)) {
                update();
                lastUpdateTime += TBU;
                updateCount++;
            }
            if (now - lastUpdateTime > TBU){
                lastUpdateTime = now - TBU;
            }
            render();
            repaint();
            lastRenderTime = now;
            frameCount++;

            int thisSecond= (int) (lastUpdateTime/1000000000);
            if (thisSecond > lastSecondTime){
                if (frameCount != oldFrameCount){
                    System.out.println("NEW SECOND "+ thisSecond+" "+ frameCount);
                    oldFrameCount = frameCount;
                }
                frameCount=0;
                lastSecondTime = thisSecond;
            }

            while (now-lastRenderTime<TTBR && now-lastUpdateTime<TBU){
                Thread.yield();

                try{
                    Thread.sleep(1);
                } catch (Exception e){
                    System.out.println("EROR : yielding thread");
                }
                now = System.nanoTime();
            }
        }
    }

    public void update() {
        if (pause == false) {
            gameWorld.update();
            if (CheckAliveLoop) {
                if (gameWorld.hero.remove) {
                    CheckAliveLoop = false;
                    
                    
                    gameframe.refresh(new GameoverPanel(gameframe));
                }

            }
        }
    }
    public GameWorld getgameworld(){
        return gameWorld;
    }

    public void render() {
        if (bufferedImage == null) {
            bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        } else {
            bufG2D = (Graphics2D) bufferedImage.getGraphics();
        }

        if (bufG2D != null) {
            if (pause == true) {
                PauseScreen(bufG2D);
            } else {
                gameWorld.render(bufG2D);
            }
        }
    }

    public void paint(Graphics g) {
        g.drawImage(bufferedImage, 0, 0, this);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_P && pause == true) {
            pause = false;
        }
        else {
            if (e.getKeyCode() == KeyEvent.VK_P && pause == false) {
                pause = true;
            }
        }
        input.proccessKeypressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        input.proccessKeyrelease(e.getKeyCode());
    }

    public void PauseScreen(Graphics2D g2d) {
        g2d.drawImage(resizeImage("Data/GuiImage/pause state.png"),160,140,null);
    }

    public Image resizeImage(String image) {
        BufferedImage img=null;
        try {
            img= ImageIO.read(new File(image));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Image dimg=img.getScaledInstance(400, 200, Image.SCALE_SMOOTH);
        return dimg;
    }
}




