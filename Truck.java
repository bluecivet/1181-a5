import java.awt.*;
import java.awt.geom.*;

public class Truck extends Vehicle
{

    public static int width = 120;
    public static int height = 85;

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

       Ellipse2D.Double wheel1 = new Ellipse2D.Double(x ,y + height * 0.75, width / 9,width / 9);
       Ellipse2D.Double wheel2 = new Ellipse2D.Double(x + width * 2 / 9,y + height * 0.75, width / 9,width / 9);
       Ellipse2D.Double wheel3 = new Ellipse2D.Double(x + width * 3 / 9,y + height * 0.75, width / 9,width / 9);
       Ellipse2D.Double wheel4 = new Ellipse2D.Double(x + width * 7 / 9,y + height * 0.75, width / 9,width / 9);
       Ellipse2D.Double wheel5 = new Ellipse2D.Double(x + width * 8 / 9,y + height * 0.75, width / 9,width / 9);

       g2.fill(body);
       g2.fill(head);
       g2.fill(wheel1);
       g2.fill(wheel2);
       g2.fill(wheel3);
       g2.fill(wheel4);
       g2.fill(wheel5);

       g2.setColor(Color.black);
       g2.draw(body);
       g2.draw(head);
       g2.draw(wheel1);
       g2.draw(wheel2);
       g2.draw(wheel3);
       g2.draw(wheel4);
       g2.draw(wheel5);
       g2.draw(new Rectangle(x,y,width,height));

    }
}
