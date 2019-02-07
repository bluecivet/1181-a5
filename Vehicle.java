import java.awt.*;
abstract public class Vehicle
{
    int x;
    int y;
    int width;
    int height;
    Color c;
    Rectangle rect;

  //-------------------------------------------------

    abstract public void draw(Graphics2D g2);

    //-----------------------------------------------

    public static boolean checkOverLap(Rectangle rect, Vehicle[] arr)
    {
        for(Vehicle a : arr)
        {
            if(a == null)
            {
                return false;
            }

            if(rect.intersects(a.rect))
            {
                return true;
            }
        }

        return false;
    }
}
