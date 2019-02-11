import java.awt.*;
import java.awt.geom.*;
public class Car extends Vehicle
{
    public static final int width = 100;
    public static final int height = 50;

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
        super.c = new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256));
        super.rect = new Rectangle(x,y,width,height);
    }

    //------------------------------------------

    public void draw(Graphics2D g2)
    {
        g2.setColor(c);
       Rectangle body = new Rectangle(x,y + (height / 3), width, height / 3);

       Ellipse2D.Double wheel1 = new Ellipse2D.Double(x + width * 0.2, y + height * 2 / 3,  height / 3, height / 3);
       Ellipse2D.Double wheel2 = new Ellipse2D.Double(x + width * 0.7, y + height * 2 / 3, height / 3, height / 3);

       Point2D.Double p1 = new Point2D.Double(x + width  * 0.2, y + (height / 3));
       Point2D.Double p2 = new Point2D.Double(x + width  * 0.4, y );
       Point2D.Double p3 = new Point2D.Double(x + width  * 0.6, y );
       Point2D.Double p4 = new Point2D.Double(x + width  * 0.8, y + (height / 3));

       Line2D.Double l1 = new Line2D.Double(p1,p2);
       Line2D.Double l2 = new Line2D.Double(p2,p3);
       Line2D.Double l3 = new Line2D.Double(p3,p4);

       g2.fill(body);
       g2.fill(wheel1);
       g2.fill(wheel2);

       g2.setColor(Color.BLACK);
       g2.draw(body);
       g2.draw(wheel1);
       g2.draw(wheel2);
       g2.draw(l1);
       g2.draw(l2);
       g2.draw(l3);
       g2.draw(new Rectangle(x,y,width,height));

    }
}
