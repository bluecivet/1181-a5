/**

 * File:        Bicyle.java

 * Author:      Zhilong Gan

 * ID:          100331942

 * Date:        2019.02.11

 * class:       CPSC 1181-03

 * instructor:  Hengameh Hamavand

 * title        bicyle class

 * Compiler:    java JDK 10.2

 */


import java.awt.*;
import java.awt.geom.*;

public class Bicyle extends Vehicle
{
    public static int width = 80;
    public static int height = 50;



    //  constructor
    //----------------------------------------------------------------

    Bicyle()
    {

    }

    ///////////////////////////////////////////////////////

    /**
    *  the constructor will initial the field which define in the vehicle class
    *  @param x the int type show the position x aix for the bicyle
    *  @param y the int type show the position y aix for the bicyle
    *  @param c the color type show the color for the car
    */

    Bicyle(int x, int y, Color c)
    {
        super.x = x;
        super.y = y;
        super.width = Bicyle.width;
        super.height = Bicyle.height;
        super.c = c;
        super.rect = new Rectangle(x,y,width,height);
    }

    //----------------------------------------------------------------------------

    /**
    *  the mehtod over ride the method in Vehicle class
    *  it will draw the shape which related to itselt
    *  @param g2 a Graphics2D type which showu the drawing pen for the screen
    */

    @Override

    public void draw(Graphics2D g2)
    {
        g2.setColor(c);
       Point2D.Double p1 = new Point2D.Double(x + width * 0.1, y + height * 0.6);
       Point2D.Double p2 = new Point2D.Double(x + width * 0.8, y + height * 0.6);
       Point2D.Double p3 = new Point2D.Double(x + width * 0.8, y + height * 0.3);
       Point2D.Double p4 = new Point2D.Double(x + width * 0.6, y + height * 0.1);
       Point2D.Double p5 = new Point2D.Double(x + width * 0.6, y + height * 0.4);

       Line2D.Double body = new Line2D.Double(p1,p2);
       Line2D.Double head = new Line2D.Double(p2,p3);
       Line2D.Double l1 = new Line2D.Double(p3,p4);
       Line2D.Double l2 = new Line2D.Double(p3,p5);

       Ellipse2D.Double wheel1 = new Ellipse2D.Double(x, y + height * 0.6, width >> 2, width >> 2);
       Ellipse2D.Double wheel2 = new Ellipse2D.Double(x + width * 0.7, y + height * 0.6, width >> 2, width >> 2);
       
       //draw outter shape
       g2.draw(body);
       g2.draw(head);
       g2.draw(l1);
       g2.draw(l2);

       //fill color
       g2.fill(wheel1);
       g2.fill(wheel2);
       g2.setColor(Color.BLACK);
       g2.draw(new Rectangle(x,y,width,height));
    }
}
