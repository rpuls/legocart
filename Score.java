 
import greenfoot.*;
import java.awt.Color;



public class Score extends Actor
{
  private double points;
  private double scrollSpeed;
  private boolean multiPlayer = true;
  public Color TRANS = new Color(0f,0f,0f,0f);
  public void act(){
      Track track = (Track)getWorld();
      points = track.coinsCollected;
      scrollSpeed = track.scrollSpeed;
      if(multiPlayer){
          setImage(new GreenfootImage("Player 1\n"+"LEGO COINS: " + points + "   \n" + "SPEED: " + scrollSpeed, 20, Color.YELLOW, TRANS));
      }else{
          setImage(new GreenfootImage("LEGO COINS: " + points + "   \n" + "SPEED: " + scrollSpeed, 20, Color.YELLOW, TRANS));
      } 
  }
}