import javax.swing.*;
import java.awt.*;

public class VehicleComponent extends JComponent
{
    int numberOfCar;
    Vehicle[] cars;

    //    contturctor

    VehicleComponent()
    {
        numberOfCar = getInput();
        cars = new Vehicle[numberOfCar];
    }

    //-----------------------------------------------------------
    private int getInput()
    {
        String userInput;

        do {
            userInput = JOptionPane.showInputDialog
                    (
                            null,
                            "please enter the number of vehicle in the program",
                            "ask for number",
                            JOptionPane.PLAIN_MESSAGE
                    );

            if (validInput(userInput)) {
                return Integer.parseInt(userInput);
            }
        }
        while (true);
    }

    ///////////////////////////////////////////////////////////////////

    private boolean validInput(String input)
    {
        input = input.trim();

        for (int i = 0; i < input.length(); i++)
        {
            if (input.charAt(i) < '0' || input.charAt(i) > '9')
            {
                return false;
            }
        }

        return true;
    }

    ////////////////////////////////////////////////////////////////////////

    private void initialCars(Vehicle[] arr)
    {
        int firstRandom = 1 + (int) (Math.random() * numberOfCar);
        int secondRandom = 1 + (int) (Math.random() * (numberOfCar - firstRandom));
        int thirdRandom = numberOfCar - firstRandom - secondRandom;

        loadCar(0, firstRandom, arr);

    }

    ////////////////////////////////////////////////////////////

    private void loadCar(int start, int end, Vehicle[] arr)
    {
        Rectangle rect;
        int x;
        int y;

        for (int i = start; i < end; i++)
        {
            do
             {
                //get random position for the car
                x = (int) (Math.random() * 1920);
                y = (int) (Math.random() * 1080);
                // create rectangle for checking overlapping
                rect = new Rectangle(x, y, Car.width, Car.height);
             }
            while (Vehicle.checkOverLap(rect, arr));   // check overlapping

            //once not overlapping
            arr[i] = new Car(x, y);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////

    private void loadBicyle(int start, int end, Vehicle[] arr)
    {
        Rectangle rect;
        int x;
        int y;

        for (int i = start; i < end; i++)
        {
            do
             {
                //get random position for the car
                 x = (int) (Math.random() * 1920);
                y = (int) (Math.random() * 1080);
                // create rectangle for checking overlapping
                rect = new Rectangle(x, y, Bicyle.width, Bicyle.height);
              }
            while (Vehicle.checkOverLap(rect, arr));   // check overlapping

            //once not overlapping
            arr[i] = new Car(x, y);
        }

    }
}

