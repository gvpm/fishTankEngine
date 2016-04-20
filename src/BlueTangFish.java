
import java.util.Random;
import processing.core.*;

public class BlueTangFish extends LifeForm {
    
    PImage img;
    float imgSize;

    public BlueTangFish(Tank t,PApplet p, Position pos, float size) {
        super(p,t);
        this.position = pos;
        this.size = size;
        //this.speed = 2;
        this.maxSpeed = 2;
        this.maxLife = 255;
        this.life = maxLife;
        Random rand = new Random();
        this.direction = rand.nextInt(8 - 1 + 1) + 1;
        this.speed = rand.nextFloat() * (maxSpeed - 0) + 0;
    }

    public BlueTangFish(Tank t,PApplet p, float x, float y, float size) {
        super(p,t);
        this.position.setX(x);
        this.position.setY(y);
        this.size = size;
        //this.speed = 2;
        this.maxSpeed = 2;
        this.maxLife = 255;
        this.life = maxLife;
        Random rand = new Random();
        this.direction = rand.nextInt(8 - 1 + 1) + 1;
        this.speed = rand.nextFloat() * (maxSpeed - 0) + 0;
    }

    @Override
    public void display() {
        p.stroke(255);          // Setting the outline (stroke) to black
        p.fill(150);
        //p.ellipse(position.getX(), position.getY(), size, size);
        
        int imgD=1;
        
        if(direction == 1||direction == 2||direction == 3||direction == 4){
            img = p.loadImage("fish2R.png");   
            imgD=1;
        }else {
            img = p.loadImage("fish2L.png");
            imgD=0;
        }
        
        p.pushMatrix();
            p.translate(position.getX(), position.y);
            if(direction == 2)
            p.rotate(p.radians(315));
            if(direction == 4)
            p.rotate(p.radians(45));
            if(direction == 6)
            p.rotate(p.radians(315));
            if(direction == 8)
            p.rotate(p.radians(45));
            if(direction == 1)
            p.rotate(p.radians(270));
            if(direction == 5)
            p.rotate(p.radians(270));
           
            p.image(img, 0-(img.width*imgD), -img.height/2);
        p.popMatrix();
        
        
    }

    @Override
    public void move() {
        Random rand = new Random();
        if ((rand.nextInt(1000 - 1 + 1) + 1) > 998&& life==maxLife) {
            this.changeDirection(5);
        }
        if ((rand.nextInt(1000 - 1 + 1) + 1) > 998) {
            this.speed = rand.nextFloat() * (maxSpeed - 0) + 0;
        }      
        
        position.checkWalls(this);
        
        position.updatePosition(direction, speed);

    }

    @Override
    public void updateLife() {
        life = (float) (life-0.1);
        System.out.println(life);
        if(life<0)
            life = 0;
    }

}
