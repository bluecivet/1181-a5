import java.awt.*;
public class Car extends Vehicle
{
    public static final int width = 40;
    public static final int height = 20;

    Car()
    {




    }

    ////////////////////////////////////////////////////////////////

    Car(int x, int y)
    {
        super.x = x;
        super.y = y;
        super.width = Car.width;
        super.height = Car.height;
        super.c = new Color((int)Math.random() * 256, (int)Math.random() * 256, (int)Math.random() * 256);
        super.rect = new Rectangle(x,y,width,height);
    }

    //------------------------------------------

    public void draw()
    {

    }
}
