
import static java.lang.Math.sqrt;
import processing.core.PApplet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gvpm
 */
public class Food {

    int life;
    Position position;
    int radius;
    PApplet p;

    public Food(PApplet p,float x, float y) {
        life = 255;
        radius = 10;
        position = new Position (p,x,y);
        this.p=p;        

    }

    public void update() {
        float newPos = position.getY();
        
        position.setY((float) (newPos + 1));
        if(position.getY()>p.height-radius)
            position.setY(p.height-radius);

    }

    public void display() {

        p.stroke(255);          // Setting the outline (stroke) to black
        p.fill(150);
        p.ellipse(position.getX(), position.getY(), radius, radius);

    }

    public boolean checkColision(Position pos){
        if(pos.getX()>=position.getX()&&pos.getX()<=position.getX()+radius&&pos.getY()>=position.getY()&&pos.getY()<=position.getY()+radius) 
            return true;
    return false;

    }

    public Position getPosition() {
        return position;
    }
    
    public float checkDistance(float x,float y){
        float dist=0;
        
        dist = (float) sqrt(Math.pow((position.getX()+x), 2) +Math.pow((position.getY()+y), 2));
        
        
        return dist;
    }
    

}
