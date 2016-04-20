
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
public class Position {

    float x, y;
    PApplet p;

    public Position(PApplet p) {
        this.x = 0;
        this.y = 0;
        this.p=p;
    }

    public Position(PApplet p,float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    
    public void checkWalls(LifeForm l) {
        
        int w = 10;              
            
            if (x <= 0) {
                w = 4;
                x=0;
                l.changeDirection(w);
            }
            if (y <= 0) {
                w = 1;
                y=0;
                l.changeDirection(w);
            }
            if (y >= p.height) {
                w = 3;
                y=p.height;
                l.changeDirection(w);
            }
            if (x >= p.width) {
                w = 2;
                x=p.width;
                l.changeDirection(w);
            }
            
        

    }

    public void updatePosition(int dir, float speed) {
        switch (dir) {
            case 1:
                setY(getY() - speed);
                break;
            case 2:
                setY(getY() - speed);
                setX(getX() + speed);
                break;
            case 3:
                setX(getX() + speed);
                break;
            case 4:
                setY(getY() + speed);
                setX(getX() + speed);
                break;
            case 5:
                setY(getY() + speed);
                break;
            case 6:
                setY(getY() + speed);
                setX(getX() - 1);
                break;
            case 7:
                setX(getX() - speed);
                break;
            case 8:
                setY(getY() - speed);
                setX(getX() - speed);
                break;
            case 0:
                break;
        }

    }

}
