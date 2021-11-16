package Project;

import java.util.Random;

public class FirstDice implements myInterface {

    FirstDiceSide firstSide = new FirstDiceSide(6);

    @Override
    public int throwDice() {
        Random random = new Random();
        int firstDice = random.nextInt(firstSide.getFirstDiceSide()) + 1;
        return firstDice;
    }
}
