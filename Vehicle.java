/**

 * File:        Vehicle.java

 * Author:      Zhilong Gan

 * ID:          100331942

 * Date:        2019.02.11

 * class:       CPSC 1181-03

 * instructor:  Hengameh Hamavand

 * title        vehicle class

 * Compiler:    java JDK 10.2

 */



/**
*  this is an abstract class 
*  it represent the vehicle 
*  there are 3 child in the program : Car, Truck, Bicyle
*/

import java.awt.*;
abstract public class Vehicle
{
    int x;      // the position for x aix
    int y;     // the psition for y aix
    int width;      // the dimension for the vehicle: width 
    int height;    // the dimension for the vehicle: width 
    Color c;      // the color for the vehicle
    Rectangle rect;     // a rectangle represent the boundary of the vehicle


  //-------------------------------------------------------------------------
    
    /**
     the this a construtor for the vehicle which doing nothing but just incase to compile and run
    */

    Vehicle()
    {

    }






  //-------------------------------------------------

    /**
    *  this is a abstract method which to let all the vehcile subclass can draw 
    *  @param g2 the Graphics2D type represen the drawing pen in the screen
    */

    abstract public void draw(Graphics2D g2);





    //------------------------------------------------------------

    /**
    *  this is a public static method 
    *  it check a rectangle is overlapping the bounary for the vehivle in the array or not
    *  @param rect the rectangle that need to be checkd
    *  @param arr the behicle array 
    *  @return true for the objects are overlapping false for not overlapping 
    */
    public static boolean checkOverLap(Rectangle rect, Vehicle[] arr)
    {
        for(Vehicle a : arr)   // check every vehicle in the array
        {
            if(a == null)   // if there are not vehicel in that position
            {
                return false;
            }

            if(rect.intersects(a.rect))  // if interset together
            {
                return true;
            }
        }

        return false;
    }



    ////////////////////////////////////////////////////////////

    /**
    *  the method over ride the method in object
    *  when the behicle need to be printed 
    *  the type of the vehicle will be show
    *  @return a string type show the message for the vehicle
    */
     
     @Override
  
    public String toString()
    {
    	return "this is a " + this.getClass();
    }


    ////////////////////////////////////////////////////////////

    /**
    *  the method over ride the method in the object class
    *  it will compare the vehicle that is that the same
    *  it compare every field in the vehicel class 
    *  @param v the vehicle that need to be compared
    *  @return true for they are the same false for not the same
    */

     @Override

    public boolean equals(Object obj)
    {
    	if(obj == null)     // if v is not an object
    		return false;

    	if(this.getClass() != obj.getClass())   // if they donot have the same class
    		return false; 

        Vehicle v = (Vehicle) obj;

    	if(this.x != v.x || this.y != v.y)  // if the position is different
    		return false;

    	if(this.width != v.width || this.height != v.height)  // if the size is different
    		return false;

    	if(!this.c.equals(v.c))   // if the color is different
    		return false;

    	return true;
    }


}
