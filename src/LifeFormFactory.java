
import java.util.Random;
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
public class LifeFormFactory {

    Tank t;
    PApplet p;

    public LifeFormFactory(Tank t) {
        this.t = t;
        this.p = t.getP();
    }

    public void fabricate(int type, int amount) {

        switch (type) {
            case 1:
                fabricateClownFish(amount);
                break;
            case 2:
                fabricateBlueTangFish(amount);
                break;
         
        }

    }

    private void fabricateClownFish(int amount) {

        Random rand = new Random();

        for (int i = 0; i < amount; i++) {
            float x = rand.nextFloat() * (p.width - 0) + 0;
            float y = rand.nextFloat() * (p.height - 0) + 0;
            int size = rand.nextInt(50 - 10 + 10) + 10;
            //float speed = rand.nextFloat() * (2 - 1) + 1;

            LifeForm fish = new ClownFish(t, p, x, y, size);
            t.addLifeForm(fish);
        }
    }

    private void fabricateBlueTangFish(int amount) {

        Random rand = new Random();

        for (int i = 0; i < amount; i++) {
            float x = rand.nextFloat() * (p.width - 0) + 0;
            float y = rand.nextFloat() * (p.height - 0) + 0;
            int size = rand.nextInt(50 - 10 + 10) + 10;
            //float speed = rand.nextFloat() * (2 - 1) + 1;

            LifeForm fish = new BlueTangFish(t, p, x, y, size);
            t.addLifeForm(fish);
        }
    }



}
