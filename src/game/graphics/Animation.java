package game.graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animation {
    private String name;
    private ArrayList<FrameImage> frameImages;
    private int currentFrame;



    private double delayFrames;
    private boolean drawRectFrame;
    private long beginTime;

    public Animation() {
        currentFrame = 0;
        delayFrames = 100*1000000;
        drawRectFrame = false;
        frameImages = new ArrayList<>();
    }

    public Animation(Animation animation) {
        currentFrame = animation.currentFrame;
        drawRectFrame = animation.drawRectFrame;
        frameImages = new ArrayList<>();
        for (FrameImage f : animation.frameImages) {
            frameImages.add(f);
        }
    }

    // getter & setter

    public void setDelayFrames(double delayFrames) {
        this.delayFrames = delayFrames;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<FrameImage> getFrameImages() {
        return frameImages;
    }

    public void setFrameImages(ArrayList<FrameImage> frameImages) {
        this.frameImages = frameImages;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame) {
        if (currentFrame >= 0 && currentFrame < frameImages.size())
            this.currentFrame = currentFrame;
        else this.currentFrame = 0;
    }

    public boolean getDrawRectFrame() {
        return drawRectFrame;
    }

    public void setDrawRectFrame(boolean drawRectFrame) {
        this.drawRectFrame = drawRectFrame;
    }

    public void add(FrameImage frameImage) {
        frameImages.add(frameImage);
    }

    public BufferedImage getCurrentImage() {
        return frameImages.get(currentFrame).getImg();
    }

    public void update(long currentTime) {
        if (currentFrame>= frameImages.size()) currentFrame=0;
        if (beginTime==0) beginTime = currentTime;
        else
        {
            if (currentTime-beginTime>delayFrames) {
                nextFrame();
                beginTime=currentTime;
            }
        }
    }

    public void nextFrame() {
            if (currentFrame >= 0 && currentFrame < frameImages.size() - 1) {
                currentFrame++;
            }
            else currentFrame = 0;
    }

    public void reset(){
        currentFrame=0;
    }

    public boolean isLastFrame() {
        if (currentFrame == frameImages.size() - 1)
            return true;
        else return false;
    }

    public void draw(int x, int y, Graphics2D g2d) {
            BufferedImage image = getCurrentImage();
            g2d.drawImage(image, x - image.getWidth() / 2, y - image.getHeight() / 2, null);

            if (drawRectFrame == true)
                g2d.drawRect(x - image.getWidth() / 2, y - image.getHeight() / 2, image.getWidth(), image.getHeight());
    }
}

