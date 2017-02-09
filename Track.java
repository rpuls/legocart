 
import greenfoot.*;
import java.util.List;
import java.awt.Color;
import java.awt.Font;

public class Track extends World{
    private int picHeight = 490;//(new GreenfootImage(bgImageName)).getHeight();
    private String bgImageName = "legoroad490.png"; //default image
    private String carImageName = "Car.png"; //default image
    private String obstacleImageName = "Obstacle.png"; //default image
    private int coinPromile = 10;
    private int obstaclePromile = 4;
    public double scrollSpeed = 2;
    private GreenfootImage bgImage, bgBase;
    private int scrollPosition = this.getHeight();
    public Color TRANS = new Color(0f,0f,0f,0f);
    public double coinsCollected = 0;
    public double coinsCollectedP2 = 0;
    public int level = 1;
    public boolean multiPlayer = true;
    
    public Track(){    
        super(490, 860, 1);
        bgImage = new GreenfootImage(bgImageName);
        paint(scrollPosition);
        prepare();
    }

    public void act(){
        scrollPosition += scrollSpeed;
        if(scrollPosition > this.getHeight()) scrollPosition -= picHeight;
        paint(scrollPosition);
        randomObject();
        difficulty();
    }
    
    public void difficulty(){
        scrollSpeed = 2 + coinsCollected/10;
    }
    
    private void paint(int position){
        GreenfootImage bg = getBackground();
        bg.drawImage(bgImage, 0, position);
        bg.drawImage(bgImage, 0, position - picHeight);
        bg.drawImage(bgImage, 0, position - picHeight * 2);
    }

    private void prepare(){
        //getVisualization("legoroad490.png","Car.png", "Obstacle.png");//DENNE METODE SKAL IKKE KALDES HER! men fra ingame shop classen istedet!
        setBackground(bgImageName);
        Car car = new Car();
        addObject(car, getWidth()/2, 770);
        car.setCarImage(carImageName);
        Score score = new Score();
        addObject(score, 70, 830);
        if(multiPlayer){
            ScoreP2 score2 = new ScoreP2();
            addObject(score2, 400, 830);
            Car2 car2 = new Car2();
            addObject(car2, (getWidth()/2)-55, 770);
            if(carImageName == "Car-2.png"){
                car2.setCarImage("Car.png");
            }else {car2.setCarImage("Car-2.png");}
        }
        bgImage = new GreenfootImage(bgImageName);
    }
    
   public int getRandomNumber(int start,int end){
        int normal = Greenfoot.getRandomNumber(end-start+1);
        return normal+start;
   }
   
      private void randomObject(){
       int random = Greenfoot.getRandomNumber(1000);
       random -= coinPromile;
              if(random < 0){
           Coin coin = new Coin();
           addObject(coin, getRandomNumber(75, 415), 0);
           return;
       }
       random -= obstaclePromile;
       if(random < 0){
           Obstacle obstacle = new Obstacle();
           addObject(obstacle, getRandomNumber(75, 415), 0);
           obstacle.setObstacleImage(obstacleImageName);
           return;
       }
   }
   
   public double getSpeed(){
       return scrollSpeed;
   }
   
   public void gameOver(){
       coinsCollected = coinsCollected * (1+scrollSpeed/10);
       coinsCollected = (int)coinsCollected;
       List objects = getObjects(null);
       removeObjects(objects);
       GameOver gameOver = new GameOver();
       addObject(gameOver, getWidth()/2, getHeight()/2);
       Score scoreGameOver = new Score();
       addObject(scoreGameOver, getWidth()/2, 530);
       if(multiPlayer){
           ScoreP2 scoreGameOver2 = new ScoreP2();
           addObject(scoreGameOver2, getWidth()/2, 600);
           coinsCollectedP2 = coinsCollectedP2 * (1+scrollSpeed/10);
           coinsCollectedP2 = (int)coinsCollectedP2;
       }
       obstaclePromile = 0;
       coinPromile = 0;
       //Greenfoot.stop();
   }
   
   //Methods that have to be called from the main application!
   public void multiPlayer(){//toggles 2-player when true
       multiPlayer = true;
   }
   
   public void getVisualization(String vbg, String vcar, String vobst){//sets the graphics of the game. should be called from shop
       bgImageName = vbg; //
       carImageName = vcar; //
       obstacleImageName = vobst; //
   }
   
   public int endGameAndGetCoins(){
       Greenfoot.stop();
       return (int)coinsCollected;
   }
}
