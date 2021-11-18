package Project;

import java.util.Random;

public class Dice implements DiceInterface {
    
    private int sideAmount;

    public Dice(int sideAmount) {
        this.sideAmount = sideAmount;
    }

    public int getSizeAmount() {
        return sideAmount;
    }

    public void setSizeAmount(int sideAmount) {
        this.sideAmount = sideAmount;
    }

    @Override
    public int throwDice() {
        Random random = new Random();
        int firstDice = random.nextInt(sideAmount) + 1;
        return firstDice;
    }
}