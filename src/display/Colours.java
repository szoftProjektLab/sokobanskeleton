package display;
import game.Skeleton;

import java.util.Random;

public class Colours {
    /**
     * Piros 0-255
     */
    private int Red;
    /**
     * Zöld 0-255
     */
    private int Green;
    /**
     * Kék 0-255
     */
    private int Blue;

    /**
     * Random színt generáló konstruktor.
     */
    private Colours(){
        Random rand = new Random();
        Red = rand.nextInt()%256;
        Green = rand.nextInt()%256;
        Blue = rand.nextInt()%256;
    }

    /**
     * Random színt készít.
     * @return Random színt visszaad.
     */
    public Colours RandomColour()
    {
        Skeleton.getInstance().Return(this);
        return new Colours();
    }

    /**
     *
     * @return Blue
     */
    public int getBlue() {
        return Blue;
    }
    /**
     *
     * @return Green
     */
    public int getGreen() {
        return Green;
    }
    /**
     *
     * @return Red
     */
    public int getRed() {
        return Red;
    }
}
