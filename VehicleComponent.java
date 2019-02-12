/**

 * File:        VehicleComponent.java

 * Author:      Zhilong Gan

 * ID:          100331942

 * Date:        2019.02.11

 * class:       CPSC 1181-03

 * instructor:  Hengameh Hamavand

 * title        Vehicle component class

 * Compiler:    java JDK 10.2

 */

/**
*  this is the class extended the JComponent class 
*  this class will draw the Vehicle class object on the screen
*  it let the user to input the number of class in the screen 
*  if the user do not input correctly than a warnnin message will show up
*  if the user enter a larger than cars may not fit in the screen than 
*  it will tell the user to input a smaller number
*/

import javax.swing.*;
import java.awt.*;

public class VehicleComponent extends JComponent
{
    int numberOfCar;
    Vehicle[] cars;          // an array to contain the vehicle object 
    // get the dimension for the screen
    Toolkit kit = Toolkit.getDefaultToolkit();    
    Dimension screenSize = kit.getScreenSize();
    int screenWidth = screenSize.width;   
    // -60 is because the tool bars on the top and bottom of the window 
    int screenHeight = screenSize.height - 60; 


    
    //    contturctor
    //----------------------------------------------------------------------------------

    /**
    *  this is a constructor for the class with no parameter
    *  it will let user to input number and set up the vehicle array 
    *  which mean creat vechicle object randomly in the array
    */

    VehicleComponent()
    {
        numberOfCar = getInput();

        // if the user choose cancel in the pop up window
        if(numberOfCar == -1)
        	return;           // exit the method 

        cars = new Vehicle[numberOfCar]; 
        initialCars(cars);
    }


    //-----------------------------------------------------------------



    public int getNumOfCar()
    {
    	return numberOfCar;
    }

    //////////////////////////////////////////////////////////////////

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        for(Vehicle a : cars)
        {
            a.draw(g2);
            System.out.println(a);
        }
    }







    //-----------------------------------------------------------

    /**
    *  the method will let user to input a number that they want for the cars that show 
    *  on screen
    *  and if the user enter the characters not valid than show up a warning message
    *  if the user enter a number that is too large than a warning message will show
    *  if a warning message showed than the user need to enter again
    *  define the user choose cancle and want to exit it will return -1
    */

    private int getInput()
    {
        String userInput;

        do
         {
            userInput = JOptionPane.showInputDialog
                    (
                            null,
                            "please enter the number of vehicle in the program",
                            "ask for number",
                            JOptionPane.PLAIN_MESSAGE
                    );

            if(userInput == null)  // if user choose cancle
            {
            	return -1;
            }

            if (validInput(userInput)) // check the validation for the input 
            {
                 /*
                 the program run inside mean the input is valid
                 it will check if the number of the input is too large
                 using the area of the screen divid the area of the Truck
                 because the truck has the largest area of the three
                 since the vehicle is randomly put in the screen 
                 -30 is to make sure the vehicles will have enough space to fit in 
                */
            	if(Integer.parseInt(userInput) > ((screenWidth * screenHeight) / (Truck.width * Truck.height)) - 30)
            	{
            		JOptionPane.showMessageDialog
            		(
            			null,
            			"the screen cannot fit try a smaller number",
            			"too many cars",
            			JOptionPane.WARNING_MESSAGE
            		);

            		continue;
            	}

                return Integer.parseInt(userInput);
            }

            else
            {
            	JOptionPane.showMessageDialog
            	(
            		null,
            		"invalid input!",
            		"invalid input",
            		JOptionPane.WARNING_MESSAGE
            	);
            }
        }
        while (true);
    }


    ///////////////////////////////////////////////////////////////////

    /**
    *  this method will check the vaildation for the user input 
    *  first the input should not be a null statement 
    *  the input should not be a empty statement
    *  the input should only contain number
    *  @param input a String type indecate the user input
    *  @return return ture for valid false for not valid 
    */

    private boolean validInput(String input)
    {
        if(input == null || input.equals(""))
            return false;

        for (int i = 0; i < input.length(); i++)  // check each character in the input
        {
            if ((input.charAt(i) < '0' || input.charAt(i) > '9')) // within range of 0 to 9
            {
                return false;
            }

        }

        return true;
    }


    ////////////////////////////////////////////////////////////////////////

    /**
    *  the method will initial the vehicle array
    *  it will create the randomly pick whicle type of vehicle to create
    *  @param arr the array for the vehicle 
    */


    private void initialCars(Vehicle[] arr)
    {

    	for(int i = 0; i < numberOfCar; i++)
    	{
    		int random = (int) (Math.random() * 3);  // create a random number from 0 to 2

    		switch(random)
    		{
    			case 0: arr[i] = loadCar(arr); break;  // 0 means create car

    			case 1: arr[i] = loadTruck(arr); break;  // 1 means create truck

    			case 2: arr[i] = loadBicyle(arr); break;  // 2 means create bicyle 

    			default: break;  // in case do nothing
    		}
    	}

    }


    ////////////////////////////////////////////////////////////

    /**
    *  this method will create the car object which is a type of vehicle
    *  the positeion of the ovehicle will randomly picked by the sustem
    *  if the position of the vechicle will over lap with other behicle in the array 
    *  the system will pick other position until it is not overlaooing
    *  also it will create a random color for the vehicle
    *  @param arr  this a the vehicle array   
    *  @return a Vehcile type but real is a car
    */


    private Vehicle loadCar(Vehicle[] arr)
    {
        Rectangle rect;
        int x;
        int y;

        do
        {
          //get random position for the car
           x = (int) (Math.random() * (screenWidth - Car.width));
           y = (int) (Math.random() * (screenHeight - Car.height));
           // create rectangle for checking overlapping

           rect = new Rectangle(x, y, Car.width, Car.height);
        }
        while (Vehicle.checkOverLap(rect, arr));   // check overlapping

        Color c = randomColor();  // randomly pick the color 
     
        return new Car(x, y, c);

    }


    //////////////////////////////////////////////////////////////////////////////////

    /**
    *  this method will create the bicyle object which is a type of vehicle
    *  the positeion of the ovehicle will randomly picked by the sustem
    *  if the position of the vechicle will over lap with other behicle in the array 
    *  the system will pick other position until it is not overlaooing
    *  also it will create a random color for the vehicle
    *  @param arr  this a the vehicle array   
    *  @return a Vehcile type but real is a bicyle
    */


    private Vehicle loadBicyle(Vehicle[] arr)
    {
        Rectangle rect;
        int x;
        int y;

        do
        {
          //get random position for the car
          x = (int) (Math.random() * (screenWidth - Bicyle.width));
          y = (int) (Math.random() * (screenHeight - Bicyle.height));
          // create rectangle for checking overlapping
          rect = new Rectangle(x, y, Bicyle.width, Bicyle.height);
        }
         while (Vehicle.checkOverLap(rect, arr));   // check overlapping

          Color c = randomColor();    // randomly pick the color 

          //once not overlapping
         return new Bicyle(x,y,c);

    }


    ////////////////////////////////////////////////////////////////////////////

    /**
    *  this method will create the truck object which is a type of vehicle
    *  the positeion of the ovehicle will randomly picked by the sustem
    *  if the position of the vechicle will over lap with other behicle in the array 
    *  the system will pick other position until it is not overlaooing
    *  also it will create a random color for the vehicle
    *  @param arr  this a the vehicle array   
    *  @return a Vehcile type but real is a truck
    */


    private Vehicle loadTruck(Vehicle[] arr)
    {
        Rectangle rect;
        int x;
        int y;

        do
        {
          //get random position for the car
          x = (int) (Math.random() * (screenWidth - Truck.width));
          y = (int) (Math.random() * (screenHeight - Truck.height));
          // create rectangle for checking overlapping
          rect = new Rectangle(x, y, Truck.width, Truck.height);
        }
        while (Vehicle.checkOverLap(rect, arr));   // check overlapping

         Color c = randomColor();    // randomly pick the color 

        //once not overlapping
        return new Truck(x,y,c);
        
    }


    ////////////////////////////////////////////////////////////////////////

    /**
    *  the mehod will randomly create a color object by the system
    *  @return the color type which create randomly by the system
    */


    public Color randomColor()
    {
    	return new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256));
    }

}

