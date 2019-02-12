/**

 * File:        Main.java

 * Author:      Zhilong Gan

 * ID:          100331942

 * Date:        2019.02.11

 * class:       CPSC 1181-03

 * instructor:  Hengameh Hamavand

 * title        main method class

 * Compiler:    java JDK 10.2

 */


/**
*  this class is for testing the vehicle component class and the vehcile class
*  this is the main tester program
*  it has a main method inside 
*/

import javax.swing.*;
public class Main
{

    public static void main(String[] args)
    {
    	// create JFrame to contain the drawing 
	    JFrame jf = new JFrame();
	    jf.setTitle("cars");
	    jf.setLocation(300,20);
	    jf.setSize(900,800);
	    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //create the cars on the screen 
	    VehicleComponent vc = new VehicleComponent();
        
        // if the user choose cancel on the pop up window the number of car will be -1
        // so end the program 
	    if(vc.getNumOfCar() < 0)
	    {
           return;
	    }

	    jf.add(vc);
	    jf.setVisible(true);

    }
}
