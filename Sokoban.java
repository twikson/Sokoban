package be.uliege.boigelot.oop.sokoban.main;
import be.uliege.boigelot.oop.sokoban.gui.*;

public class Sokoban
{
    public static void main(String[] args)
    {
        SokobanGUI window;
        try
        {
            int width = 10;
            int height = 10;
			int xPlayer = 5, yPlayer = 5;
			
			Structure st = new Structure();
            Window w =  new Window(height, width, st);
            Player player = new Player(xPlayer, yPlayer, width, height);
            
			//tous les setCell seront à faire dans randomize
            w.getDisplay().setCell(4, 4, w.getCrateImage());
            w.getDisplay().setCell(4, 2, w.getCrateImage());
			
            Box b = new Box(4, 4);
            Box otherb = new Box(4, 2);

            st.addBox(otherb);
            st.addBox(b);

            w.getDisplay().setCell(2, 2, w.getTargetImage());
            st.addTarget(2, 2);


            w.getDisplay().setCell(xPlayer, yPlayer, w.getPlayerImage());
            w.getDisplay().show();

            w.startWindow(st, player);
        }
        catch(SokobanError e)
        {
            String message = e.getMessage();
            System.err.println("SokobanError : "+ message);
            if(message == "Invalid cell coordinates")
                {
                    System.exit(1);
                }
        }
        catch (Exception e) {
		
			// catching the exception
			System.out.println(e);
		}
	}
	
}