package Project;

import java.util.Random;

public class Dice implements myInterface {
    
    int sizeAmount;

    public Dice(int sizeAmount) {
        this.sizeAmount = sizeAmount;
    }

    public int getSizeAmount() {
        return sizeAmount;
    }

    public void setSizeAmount(int sizeAmount) {
        this.sizeAmount = sizeAmount;
    }

    @Override
    public int throwDice() {
        Random random = new Random();
        int firstDice = random.nextInt(sizeAmount) + 1;
        return firstDice;
    }
}

