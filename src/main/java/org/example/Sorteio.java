package org.example;
import java.util.ArrayList;
import java.util.Random;

public class Sorteio {
    Random random = new Random();
    ArrayList<Integer> valores = new ArrayList<Integer>(5);

    public Sorteio() {

        for(int j = 0; j < 5; j++) {
            valores.add(random.nextInt(50) + 1);
        }
    }

    public void adicionavalor() {
        valores.add(random.nextInt(50) + 1);
    }
}
