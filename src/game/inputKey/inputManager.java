package game.inputKey;

import game.object.GameWorld;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;


public class inputManager {

    public static Map<String, Integer> map = new HashMap<String,Integer>();
    static String u = "up",r="right",d="down",l="left";

    public GameWorld gameWorld;
    public inputManager(GameWorld gameWorld){
        this.gameWorld = gameWorld;
    }

    public void proccessKeypressed(int Keycode) {

        if (Keycode == KeyEvent.VK_UP) {
            if (map.get(u) == null) map.put(u,map.size());
            gameWorld.hero.setSpeed(gameWorld.hero.MAX_SPEED);
            gameWorld.hero.setDirection(3);
            gameWorld.hero.release=false;
        }

        if (Keycode == KeyEvent.VK_DOWN) {
            if (map.get(d) == null) map.put(d,map.size());
            gameWorld.hero.setSpeed(gameWorld.hero.MAX_SPEED);
            gameWorld.hero.setDirection(4);
            gameWorld.hero.release=false;
        }

        if (Keycode == KeyEvent.VK_LEFT) {
            if (map.get(l) == null) map.put(l,map.size());
            gameWorld.hero.setSpeed(gameWorld.hero.MAX_SPEED);
            gameWorld.hero.setDirection(1);
            gameWorld.hero.release=false;
        }


        if (Keycode == KeyEvent.VK_RIGHT) {
            if (map.get(r) == null) map.put(r,map.size());
            gameWorld.hero.setSpeed(gameWorld.hero.MAX_SPEED);
            gameWorld.hero.setDirection(2);
            gameWorld.hero.release=false;
        }

        if (Keycode == KeyEvent.VK_SPACE) {
            gameWorld.hero.setATTACK(true);
        }
        if (Keycode == KeyEvent.VK_ENTER){
            gameWorld.hero.setSKILL(true);
        }
    }

    public void proccessKeyrelease(int Keycode){
        if (Keycode == KeyEvent.VK_UP) {
            map.remove(u);
            if (map.size()==0) {
                gameWorld.hero.setSpeed(0);
                gameWorld.hero.release=true;
            }
        }

        if (Keycode == KeyEvent.VK_DOWN) {
            map.remove(d);
            if (map.size()==0) {
                gameWorld.hero.setSpeed(0);
                gameWorld.hero.release=true;
            }
        }

        if (Keycode == KeyEvent.VK_LEFT) {
            map.remove(l);
            if (map.size()==0) {
                gameWorld.hero.setSpeed(0);
                gameWorld.hero.release=true;
            }
        }

        if (Keycode == KeyEvent.VK_RIGHT) {
            map.remove(r);
            if (map.size()==0) {
                gameWorld.hero.setSpeed(0);
                gameWorld.hero.release=true;
            }
        }

        if (map.size()==1) {
            for (String key : map.keySet()){
                if (key==d){
                    gameWorld.hero.setSpeed(gameWorld.hero.MAX_SPEED);
                    gameWorld.hero.setDirection(4);
                }
                if (key==u){
                    gameWorld.hero.setSpeed(gameWorld.hero.MAX_SPEED);
                    gameWorld.hero.setDirection(3);
                }
                if (key==l){
                    gameWorld.hero.setSpeed(gameWorld.hero.MAX_SPEED);
                    gameWorld.hero.setDirection(1);
                }
                if (key==r){
                    gameWorld.hero.setSpeed(gameWorld.hero.MAX_SPEED);
                    gameWorld.hero.setDirection(2);
                }
            }
        }

        if (Keycode == KeyEvent.VK_SPACE) {
            gameWorld.hero.setATTACK(false);
        }
        if (Keycode == KeyEvent.VK_ENTER){
            gameWorld.hero.setSKILL(false);
        }
    }
}
