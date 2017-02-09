 
import greenfoot.*;

public class Car2 extends Actor
{
    private double SpeedMove = 0;
    private double SpeedMax = 15;
    private double SpeedAcceleration = 0.6;
    private double SpeedBreak = 0.2;
    private int coinsInCar2 = 0;
    
    public void setCarImage(String imageName){
        this.setImage(imageName);
    }
    
    public void ControlAdvanced(){
        if(SpeedMove < 0){
            SpeedMove += SpeedBreak;
        }
  
        if(SpeedMove > 0){
            SpeedMove -= SpeedBreak;
        }

        if((SpeedMove < SpeedMax) && (SpeedMove > (-SpeedMax))){
            if(Greenfoot.isKeyDown("a")){
                SpeedMove -= SpeedAcceleration;
            }
      
            if(Greenfoot.isKeyDown("d")){
                SpeedMove += SpeedAcceleration;
            }
        } 
        //move((int)SpeedMove);
        if(getX() >= 75-(int)SpeedMove && getX() <= 415-(int)SpeedMove){
            setLocation(getX()+(int)SpeedMove, getY());
            setRotation((int)SpeedMove);
        }
        
    }
    
    public void act(){
        ControlAdvanced();
        CoinCheck();
        ObstacleCollideCheck();
    } 
  
    public void CoinCheck(){
        Track track = (Track)getWorld();
        if(isTouching(Coin.class)){
            Actor Coin = getOneIntersectingObject(Coin.class);
            getWorld().removeObject(Coin);
            Greenfoot.playSound("coin.wav");
            if(track.multiPlayer){
                coinsInCar2 +=2;
                track.coinsCollectedP2 = coinsInCar2;
            }else {coinsInCar2 +=1;
            track.coinsCollectedP2 = coinsInCar2;}
        }
    }
    public void ObstacleCollideCheck(){
        Track track = (Track)getWorld();
        if(isTouching(Obstacle.class)){
            Actor Coin = getOneIntersectingObject(Obstacle.class);
            track.gameOver();
            Greenfoot.playSound("crash.mp3");
        }
    }
    
    

}
