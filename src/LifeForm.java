/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gvpm
 */
import java.util.ArrayList;
import java.util.Random;
import processing.core.*;

public abstract class LifeForm {

    Position position;
    float speed, size,maxSpeed;
    float life;
    float maxLife;
    int direction;
    PApplet p;
    Tank t;

    LifeForm(PApplet p,Tank t) {
        this.p=p;
        position = new Position(p);
        this.t=t;
        

    }

    public void update(ArrayList<Food> foods) {
        updateLife();
        if (life < maxLife) {
            searchFood(foods);
        }
        move();

    }

    public void searchFood(ArrayList<Food> foods) {
        Food f = closeFood(foods);
        if (f == null) {
            Random rand = new Random();
            if ((rand.nextInt(1000 - 1 + 1) + 1) > 998) {
                this.changeDirection(5);
            }
        } else {

            float fx, fy, lx, ly;
            fx = f.getPosition().getX();
            fy = f.getPosition().getY();
            lx = position.getX();
            ly = position.getY();

            if (lx>=fx-f.radius&&lx < fx+f.radius) {
                position.setX(fx);
                if (fy > ly) {
                    direction = 5;
                } else {
                    direction = 1;
                }
            }else

            if (ly>=fy-f.radius&&ly < fy+f.radius) {
                position.setY(fy);
                if (fx > lx) {
                    direction = 3;
                } else {
                    direction = 7;
                }
            }else

            if (fx > lx && fy < ly) {
                direction = 2;
            }else
            if (fx > lx && fy > ly) {
                direction = 4;
            }else
            if (fx < lx && fy > ly) {
                direction = 6;
            }else
            if (fx < lx && fy < ly) {
                direction = 8;
            }
        }
    }

    private Food closeFood(ArrayList<Food> foods) {
        float minDist;
        Food closeFood=null;
        if (!foods.isEmpty()) {
            minDist = foods.get(0).checkDistance(position.getX(), position.getY());
            
            for (int i = 0; i < foods.size(); i++) {
                if(foods.get(i).checkDistance(position.getX(), position.getY())<=minDist){
                    minDist = foods.get(i).checkDistance(position.getX(), position.getY());
                    closeFood = foods.get(i);
                }
                
            }
            //closeFood = foods.get(0);
        }
            return closeFood;
        
    }

    public boolean feed(Food f) {
        if (this.life == maxLife) {
            return false;
        } else {
            this.life = this.life + f.life;
            if (this.life > maxLife) {
                this.life = this.maxLife;
            }

            return true;
        }

    }

    

    public void changeDirection(int w) {

        //Random rand = new Random();
        //this.direction = rand.nextInt(8 - 1 + 1) + 1;
        Random rand = new Random();
        int newDir;
        switch (w) {
            case 1:
                do {
                    newDir = rand.nextInt(8 - 1 + 1) + 1;
                } while (newDir == 8 || newDir == 1 || newDir == 2 || newDir == 7 || newDir == 3);
                this.direction = newDir;
                break;
            case 2:
                do {
                    newDir = rand.nextInt(8 - 1 + 1) + 1;
                } while (newDir == 2 || newDir == 3 || newDir == 4 || newDir == 1 || newDir == 5);
                this.direction = newDir;

                break;
            case 3:
                do {
                    newDir = rand.nextInt(8 - 1 + 1) + 1;
                } while (newDir == 6 || newDir == 5 || newDir == 4 || newDir == 7 || newDir == 3);
                this.direction = newDir;

                break;
            case 4:
                do {
                    newDir = rand.nextInt(8 - 1 + 1) + 1;
                } while (newDir == 6 || newDir == 7 || newDir == 8 || newDir == 1 || newDir == 5);
                this.direction = newDir;

                break;
            case 5:

                this.direction = rand.nextInt(8 - 1 + 1) + 1;

                break;
        }
        /*
        
   
        if(direction==1)direction = 5;
        if(direction==2)direction = 6;
        if(direction==3)direction = 7;
        if(direction==4)direction = 8;
        if(direction==5)direction = 1;
        if(direction==6)direction = 2;
        if(direction==7)direction = 3;
        if(direction==8)direction = 4;
         */

    }

    public Position getPosition() {
        return position;
    }

    public boolean isDead() {
        if (life == 0) {
            return true;
        } else {
            return false;
        }

    }

    public abstract void display();

    public abstract void move();

    public abstract void updateLife();

}
