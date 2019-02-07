import java.awt.*;
import java.awt.geom.*;

public class Truck extends Vehicle
{

    public static int width = 120;
    public static int height = 100;

    Truck()
    {

    }

    Truck(int x, int y)
    {
        super.x = x;
        super.y = y;
        super.width = Car.width;
        super.height = Car.height;
        super.c = new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256));
        super.rect = new Rectangle(x,y,width,height);
    }
    public void draw(Graphics2D g2)
    {
        g2.setColor(c);

       Rectangle head = new Rectangle(x, y + (height >> 2), width >> 2, height >> 1);
       Rectangle body = new Rectangle(x + (width >> 2), y, (int)(width * 0.75), (int)(height * 0.75));

       Ellipse2D.Double wheel1 = new Ellipse2D.Double(x,y + y * height * 0.75, width / 9,width / 9);
       Ellipse2D.Double wheel2 = new Ellipse2D.Double(x * 3 / 9,y + y * height * 0.75, width / 9,width / 9);
       Ellipse2D.Double wheel3 = new Ellipse2D.Double(x * 4 / 9,y + y * height * 0.75, width / 9,width / 9);
       Ellipse2D.Double wheel4 = new Ellipse2D.Double(x * 7 / 9,y + y * height * 0.75, width / 9,width / 9);
       Ellipse2D.Double wheel5 = new Ellipse2D.Double(x * 8 / 9,y + y * height * 0.75, width / 9,width / 9);

       g2.fill(body);
       g2.fill(head);
       g2.fill(wheel1);
       g2.fill(wheel2);
       g2.fill(wheel3);
       g2.fill(wheel4);
       g2.fill(wheel5);

    }
}
