package game.object;

public class Level {
    private int Level;
    private GameWorld gameWorld;
    public Level(GameWorld gameWorld){
        this.gameWorld = gameWorld;

    }
    public void setLevel(int Level){
        this.Level = Level;
        this.SetBlood_Damage();
    }
    public int getLevel(){
        return Level;
    }
    public void SetBlood_Damage(){
        if (getLevel() == 1){
            for (ParticularObject p : gameWorld.hero.getGameWorld().listParticularObject) {
                if (p.getTEAM() != gameWorld.hero.getTEAM()) {
                    if (p instanceof Bat){
                    p.setBlood(500);
                    }
                    
                     
                }
            }

        }
        else if (getLevel() == 2){
            for (ParticularObject p : gameWorld.hero.getGameWorld().listParticularObject) {
                if (p.getTEAM() != gameWorld.hero.getTEAM()) {
                    if (p instanceof Bat){
                        p.setBlood(1000);
                    }
                    
                     
                }
            }
        }
        else if (getLevel() == 3){
            for (ParticularObject p : gameWorld.hero.getGameWorld().listParticularObject) {
                if (p.getTEAM() != gameWorld.hero.getTEAM()) {
                    if (p instanceof Bat){
                        p.setBlood(5000);
                    }
                        
                    
                    
                     
                }
            }
        }
    }


    
}