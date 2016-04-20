
import processing.core.*;

public class Sketch extends PApplet {

    public static void main(String[] args) {

        PApplet.main(new String[]{"Sketch"});
    }
    LifeForm fish;
    Tank tank;
    PImage bg;

    @Override
    public void settings() {
        size(1100, 700);
        bg = loadImage("bg.png");
        //fullScreen();
    }

    @Override
    public void setup() {
        background(bg);
        tank = new Tank(this);
        LifeFormFactory factory = new LifeFormFactory(tank);
        factory.fabricate(1, 5);
        factory.fabricate(2, 5);
        


    }

    @Override
    public void draw() {
        background(bg);
        tank.update();
        tank.display();

    }

    public void mouseClicked() {
        tank.addFood(mouseX, mouseY);
        
    }

   
    
    
}
