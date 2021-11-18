package Project;

import java.util.Random;

public class Die implements DieInterface {
    
    private int sideAmount;

    public Die(int sideAmount) {
        this.sideAmount = sideAmount;
    }

    public int getSizeAmount() {
        return sideAmount;
    }

    public void setSizeAmount(int sideAmount) {
        this.sideAmount = sideAmount;
    }

    @Override
    public int throwDie() {
        Random random = new Random();
        int firstDice = random.nextInt(sideAmount) + 1;
        return firstDice;
    }
}