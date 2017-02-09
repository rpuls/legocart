 
import greenfoot.*;
import java.awt.Color;
import java.awt.Font;

public class GameOver extends Actor{
    public Color TRANS = new Color(0f,0f,0f,0f);
    public void act() {
        setImage(new GreenfootImage("GAME\nOVER", 76, Color.RED, TRANS));
    }    
}