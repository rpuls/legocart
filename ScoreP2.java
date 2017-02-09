 
import greenfoot.*;
import java.awt.Color;

public class ScoreP2 extends Actor
{
    private double points;
    private double scrollSpeed;
    public Color TRANS = new Color(0f,0f,0f,0f);
    public void act(){
        Track track = (Track)getWorld();
        points = track.coinsCollectedP2;
        scrollSpeed = track.scrollSpeed;
        setImage(new GreenfootImage("Player 2\n"+"LEGO COINS: " + points + "   \n" + "SPEED: " + scrollSpeed, 20, Color.YELLOW, TRANS));
    }     
}
