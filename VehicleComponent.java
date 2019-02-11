import javax.swing.*;
import java.awt.*;

public class VehicleComponent extends JComponent
{
    int numberOfCar;
    Vehicle[] cars;
    public static final int screenWidth = 1400;
    public static final int screenHeight = 800;


    //    contturctor

    VehicleComponent()
    {
        numberOfCar = getInput();
        cars = new Vehicle[numberOfCar];
        initialCars(cars);
    }


    //-----------------------------------------------------------------


    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        for(Vehicle a : cars)
        {
            a.draw(g2);
        }
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
                return Integer.parseInt(userInput.trim());
            }
        }
        while (true);
    }

    ///////////////////////////////////////////////////////////////////

    private boolean validInput(String input)
    {
        boolean isAllEmpty = true;

        if(input == null || input.equals(""))
            return false;

        for (int i = 0; i < input.length(); i++)
        {
            if ((input.charAt(i) < '0' || input.charAt(i) > '9') && input.charAt(i) != ' ')
            {
                return false;
            }

            if(input.charAt(i) != ' ')
            {
                isAllEmpty = false;
            }
        }

        return !isAllEmpty;
    }

    ////////////////////////////////////////////////////////////////////////

    private void initialCars(Vehicle[] arr)
    {
        int firstRandom = (int) (Math.random() * numberOfCar);
        int secondRandom = (int) (Math.random() * (numberOfCar - firstRandom));

        loadCar(0, firstRandom, arr);
        loadBicyle(firstRandom,firstRandom + secondRandom, arr);
        loadTruck(secondRandom + firstRandom, arr.length, arr);

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
                x = (int) (Math.random() * screenWidth);
                y = (int) (Math.random() * screenHeight);
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
                 x = (int) (Math.random() * screenWidth);
                y = (int) (Math.random() * screenHeight);
                // create rectangle for checking overlapping
                rect = new Rectangle(x, y, Bicyle.width, Bicyle.height);
              }
            while (Vehicle.checkOverLap(rect, arr));   // check overlapping

            //once not overlapping
            arr[i] = new Bicyle(x,y);
        }

    }

    ////////////////////////////////////////////////////////////////////////////

    private void loadTruck(int start, int end, Vehicle[] arr)
    {
        Rectangle rect;
        int x;
        int y;

        for (int i = start; i < end; i++)
        {
            do
            {
                //get random position for the car
                x = (int) (Math.random() * screenWidth);
                y = (int) (Math.random() * screenHeight);
                // create rectangle for checking overlapping
                rect = new Rectangle(x, y, Truck.width, Truck.height);
            }
            while (Vehicle.checkOverLap(rect, arr));   // check overlapping

            //once not overlapping
            arr[i] = new Truck(x,y);
        }

    }

}

