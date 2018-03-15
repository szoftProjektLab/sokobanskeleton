package display;
import java.util.Random;

public class Colours {
    private int Red;
    private int Green;
    private int Blue;

    private Colours(){
        Random rand = new Random();
        Red = rand.nextInt()%256;
        Green = rand.nextInt()%256;
        Blue = rand.nextInt()%256;
    }
    public Colours RandomColour()
    {
        return new Colours();
    }

    public int getBlue() {
        return Blue;
    }

    public int getGreen() {
        return Green;
    }

    public int getRed() {
        return Red;
    }
}
