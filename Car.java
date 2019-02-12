/**

 * File:        Car.java

 * Author:      Zhilong Gan

 * ID:          100331942

 * Date:        2019.02.11

 * class:       CPSC 1181-03

 * instructor:  Hengameh Hamavand

 * title        car class

 * Compiler:    java JDK 10.2

 */


import java.awt.*;
import java.awt.geom.*;
public class Car extends Vehicle
{
    public static final int width = 100;   // define the width for the car 
    public static final int height = 50;  // define the height for the car

    ///-------------------------------------------------------------------------

    /**
     the this a construtor for the vehicle which doing nothing but just incase to compile and run
    */

    Car()
    {

    }

    ////////////////////////////////////////////////////////////////

    /**
    *  the constructor will initial the field which define in the vehicle class
    *  @param x the int type show the position x aix for the car
    *  @param y the int type show the position y aix for the car
    *  @param c the color type show the color for the car
    */

    Car(int x, int y, Color c)
    {
        super.x = x;
        super.y = y;
        super.width = Car.width;
        super.height = Car.height;
        super.c = c;
        super.rect = new Rectangle(x,y,width,height);  // the boundary
    }



    //--------------------------------------------------------


    /**
    *  the mehtod over ride the method in Vehicle class
    *  it will draw the shape which related to itselt
    *  @param g2 a Graphics2D type which showu the drawing pen for the screen
    */

    @Override

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
       
       // fill color
       g2.fill(body);
       g2.fill(wheel1);
       g2.fill(wheel2);

       // draw the outter shape
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
