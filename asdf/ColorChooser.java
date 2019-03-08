import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class ColorChooser extends JFrame
{
    private JPanel centerControl;
    private JPanel southControl;
    private JPanel sideControl;

    private JPanel centerColor;
    private JPanel southColor;
    private JPanel sideColorLeft;
    private JPanel sideColorRight;

    private JButton cRed;
    private JButton cBlue;
    private JButton cGreen;

    private JRadioButton southRed;
    private JRadioButton southBlue;
    private JRadioButton southGreen;
    private ButtonGroup buttonGroup;

    private JCheckBox sideRed;
    private JCheckBox sideBlue;
    private JCheckBox sideGreen;

    private JPanel controlColor;

    //--------------------------------------------------------------------


    public ColorChooser()
    {
        createVariable();
        createWindow();
        locateComponent();
        addListener();

        initialBackground();
    }


    //////////////////////////////////////////////////////////////////////

    private void createVariable()
    {
        centerColor = new JPanel();
        southColor = new JPanel();
        sideColorLeft = new JPanel();
        sideColorRight = new JPanel();

        centerControl = new JPanel();
        southControl = new JPanel();
        sideControl = new JPanel();

        cRed = new JButton("red");
        cBlue = new JButton("blue");
        cGreen = new JButton("green");

        southRed = new JRadioButton("red");
        southBlue = new JRadioButton("blue");
        southGreen = new JRadioButton("green");
        buttonGroup = new ButtonGroup();

        sideRed = new JCheckBox("red");
        sideBlue = new JCheckBox("blue");
        sideGreen = new JCheckBox("green");

        controlColor = new JPanel(new GridLayout(3,1));
    }


    //////////////////////////////////////////////////////////////


    private void locateComponent()
    {
        //whole layout
        this.add(centerColor,BorderLayout.CENTER);
        this.add(sideColorRight,BorderLayout.EAST);
        this.add(sideColorLeft,BorderLayout.WEST);
        this.add(southColor,BorderLayout.SOUTH);
        this.add(controlColor,BorderLayout.NORTH);
        //set size
        sideColorRight.setPreferredSize(new Dimension(this.getWidth() >> 2,this.getHeight() >> 1));
        sideColorLeft.setPreferredSize(new Dimension(this.getWidth() >> 2,this.getHeight() >> 1));
        southColor.setPreferredSize(new Dimension(this.getWidth(),this.getHeight() / 5));

        //color control area
        controlColor.add(centerControl);
        controlColor.add(southControl);
        controlColor.add(sideControl);

        //the center control area
        centerControl.setBorder(new TitledBorder("center color"));
        centerControl.add(cRed);
        centerControl.add(cBlue);
        centerControl.add(cGreen);

        //the south control area
        southControl.setBorder(new TitledBorder("south color"));
        southControl.add(southRed);
        southControl.add(southBlue);
        southControl.add(southGreen);
        // add group button
        buttonGroup.add(southRed);
        buttonGroup.add(southBlue);
        buttonGroup.add(southGreen);

        //the side control area
        sideControl.setBorder(new TitledBorder("side color"));
        sideControl.add(sideRed);
        sideControl.add(sideBlue);
        sideControl.add(sideGreen);
    }

    /////////////////////////////////////////////////////////////////////////

    private void createWindow()
    {
        setSize(500,500);
        setLocation(300,300);
        setTitle("color chooser");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }


    ////////////////////////////////////////////////////////////////////////


    private void addListener()
    {
        AllListener listener = new AllListener();
        cRed.addActionListener(listener);
        cBlue.addActionListener(listener);
        cGreen.addActionListener(listener);

        southRed.addActionListener(listener);
        southBlue.addActionListener(listener);
        southGreen.addActionListener(listener);

        sideRed.addActionListener(listener);
        sideBlue.addActionListener(listener);
        sideGreen.addActionListener(listener);

    }



    private void initialBackground()
    {
        sideRed.setSelected(true);
        southGreen.setSelected(true);
        centerColor.setBackground(Color.blue);
        sideColorLeft.setBackground(Color.red);
        sideColorRight.setBackground(Color.red);
        southColor.setBackground(Color.green);
    }


    //----------------------------------------------------------------------------------------------------


    class AllListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // center color check with button
            checkButton(e);

            //south color check with radio button
            checkRadioButton(e);

            //side color check with check box
            checkCheckBox(e);
        }


        ////////////////////////////////////////////////////////


        private void checkButton(ActionEvent e)
        {
            if(e.getSource().equals(cRed))
                centerColor.setBackground(Color.red);

            else if(e.getSource().equals(cBlue))
                centerColor.setBackground(Color.blue);

            else if(e.getSource().equals(cGreen))
                centerColor.setBackground((Color.green));
        }

        //////////////////////////////////////////////////////


        private void checkRadioButton(ActionEvent e)
        {
            if(southRed.isSelected())
                southColor.setBackground(Color.red);

            else if(southBlue.isSelected())
                southColor.setBackground(Color.blue);

            else if(southGreen.isSelected())
                southColor.setBackground(Color.green);
        }


        //////////////////////////////////////////////////////////////////


        private void checkCheckBox(ActionEvent e)
        {
            int red;
            int green;
            int blue;
            Color c;

            if(sideRed.isSelected())
                red = 255;
            else
                red = 0;

            if(sideGreen.isSelected())
                green = 255;
            else
                green = 0;

            if(sideBlue.isSelected())
                blue = 255;
            else
                blue = 0;

            c = new Color(red,green,blue);

            sideColorLeft.setBackground(c);
            sideColorRight.setBackground(c);
        }
    }






}
