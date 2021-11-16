package Project;

import java.util.Random;

public class SecondDice implements myInterface {

    SecondDiceSide secondSide = new SecondDiceSide(6);
    
    @Override
    public int throwDice() {
        Random random = new Random();
        int secondDice = random.nextInt(secondSide.getSecondDiceSide()) + 1;
        return secondDice;
    }
}
