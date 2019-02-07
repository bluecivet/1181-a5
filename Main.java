import javax.swing.*;
public class Main
{

    public static void main(String[] args)
    {
	    JFrame jf = new JFrame();
	    jf.setTitle("cars");
	    jf.setLocation(300,20);
	    jf.setSize(900,800);
	    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    VehicleComponent vc = new VehicleComponent();
	    jf.add(vc);
	    jf.setVisible(true);

    }
}
