import java.awt.*;
import java.awt.geom.*;

public class Bicyle extends Vehicle
{
    public static int width = 80;
    public static int height = 40;

    //  constructor

    Bicyle()
    {

    }

    ///////////////////////////////////////////////////////

    Bicyle(int x, int y)
    {
        super.x = x;
        super.y = y;
        super.width = Bicyle.width;
        super.height = Bicyle.height;
        super.c = new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256));
        super.rect = new Rectangle(x,y,width,height);
    }

    public void draw(Graphics2D g2)
    {
        g2.setColor(c);
       Point2D.Double p1 = new Point2D.Double(x, y + height * 0.6);
       Point2D.Double p2 = new Point2D.Double(x + width, y + height * 0.6);
       Point2D.Double p3 = new Point2D.Double(x + width, y + height * 0.3);
       Point2D.Double p4 = new Point2D.Double(x + width * 0.8, y + height * 0.2);
       Point2D.Double p5 = new Point2D.Double(x + width * 0.6, y + height * 0.2);

       Line2D.Double body = new Line2D.Double(p1,p2);
       Line2D.Double head = new Line2D.Double(p2,p3);
       Line2D.Double l1 = new Line2D.Double(p3,p4);
       Line2D.Double l2 = new Line2D.Double(p3,p5);

       Ellipse2D.Double wheel1 = new Ellipse2D.Double(x, y * height * 0.6, width >> 2, width >> 2);
       Ellipse2D.Double wheel2 = new Ellipse2D.Double(x + width, y * height * 0.6, width >> 2, width >> 2);

       g2.draw(body);
       g2.draw(head);
       g2.draw(l1);
       g2.draw(l2);
       g2.fill(wheel1);
       g2.fill(wheel2);
    }
}
