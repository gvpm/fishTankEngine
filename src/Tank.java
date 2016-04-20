
import java.util.ArrayList;
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
public class Tank {

    ArrayList<LifeForm> population;
    ArrayList<Food> foods;
    PApplet p;

    public Tank(PApplet p) {
        population = new ArrayList<LifeForm>();
        foods = new ArrayList<Food>();
        this.p=p;
    }

    public void update() {
        //checkWalls();
        updateAll();
        checkFeed();
        removeDead();

    }
       public void updateAll() {
        
        if(!foods.isEmpty()){
        for (int i = 0; i < foods.size(); i++) {
            foods.get(i).update();
        }
        }
        
        for (int i = 0; i < population.size(); i++) {
            population.get(i).update(foods);
        }

    }

    public void display() {
        
        if(!foods.isEmpty()){
        for (int i = 0; i < foods.size(); i++) {
            foods.get(i).display();

        }
        }
        for (int i = 0; i < population.size(); i++) {
            population.get(i).display();

        }
        

    }

    public void checkWalls() {
        float x, y;
        int w = 5;
        for (int i = 0; i < population.size(); i++) {
            x = population.get(i).getPosition().getX();
            y = population.get(i).getPosition().getY();
            if (x <= 0) {
                w = 4;
                population.get(i).getPosition().setX(0);
                population.get(i).changeDirection(w);
            }
            if (y <= 0) {
                w = 1;
                population.get(i).getPosition().setY(0);
                population.get(i).changeDirection(w);
            }
            if (y >= p.height) {
                w = 3;
                population.get(i).getPosition().setY(p.height);
                population.get(i).changeDirection(w);
            }
            if (x >= p.width) {
                w = 2;
                population.get(i).getPosition().setX(p.width);
                population.get(i).changeDirection(w);
            }
        }

    }

    public void addLifeForm(LifeForm lf) {
        population.add(lf);

    }

 

    public void removeDead() {
        /*
        for (int i = 0; i < population.size(); i++) {
            System.out.println(population.size());
            if (population.get(i).isDead()) {
                population.remove(i);
            }

        }
        */
        int j=0;
         while ( j < population.size() ) {
            if ( population.get(j).isDead() ) {
                population.remove(j);
            } else {
                ++j;
            }
        }

    }
    public void addFood(float x, float y){
        Food f = new Food(p,x,y);
        foods.add(f);
        
    }
    
    public void checkFeed(){
        Food f;
        LifeForm l;
        for (int i = 0; i < population.size(); i++) {
            for (int j = 0; j < foods.size(); j++) {
                f=foods.get(j);
                l=population.get(i);
                
                if(f.checkColision(l.getPosition())){
                    if(l.feed(f));
                    foods.remove(j);
                }
                
            }         
            
            
        }
        
    }

    public PApplet getP() {
        return p;
    }
    
    

}
