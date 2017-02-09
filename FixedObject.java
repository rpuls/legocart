 
import greenfoot.*;


public class FixedObject extends Actor{
    
    public FixedObject(){
        this.turn(90);
    }

    public void act(){
        Track track = (Track)getWorld();
        double speed = track.getSpeed();
        move((int)speed);
        removeIfBottom();
    }

    private void removeIfBottom(){
        Track track = (Track)getWorld();
        if(this.getY() >= track.getHeight()-1){
            track.removeObject(this);
        }
    }
}

