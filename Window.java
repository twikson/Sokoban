package be.uliege.boigelot.oop.sokoban.main;
import be.uliege.boigelot.oop.sokoban.gui.*;

public class Window 
{
    private int height;
    private int width;
    private int crateImage;
    private int playerImage; 
    private int crate2Image;
    private int emptyImage;
    private int targetImage;
    private int wallImage;
    private SokobanGUI w;

    public Window(int height, int width, Structure st)
    {
        try
        {
			this.height = height;
			this.width = width;
			this.w = new SokobanGUI(height, width);
			this.crateImage = w.loadImage("./tiles/crate.png");
			this.playerImage = w.loadImage("./tiles/player.png");
			this.crate2Image = w.loadImage("./tiles/crate2.png");
			this.emptyImage = w.loadImage("./tiles/empty.png");
			this.targetImage = w.loadImage("./tiles/target.png");
			this.wallImage = w.loadImage("./tiles/wall.png");
			
			for(int i = 0; i < width; i++)
			{
				for(int j = 0; j < height; j++)
				{
					if(i == 0 || j == 0 || i == width - 1 || j == height - 1)
					{
						w.setCell(i, j, wallImage);
						st.addWall(i, j);
					}
					else
						w.setCell(i, j, emptyImage);
				}
			}
		}
        catch (Exception e)
        {
			System.out.println(e);
            System.exit(1);
		}
		
    }
	
	public void startWindow(Structure st, Player player)
	{
		while(true)
            {
				try
				{
					int result = w.getEvent();
					
					if(result != SokobanGUI.QUIT)
					{
						switch(result)
						{
							case SokobanGUI.UP:
							{
								player.move(st, this, 1);
								break;
							}
							case SokobanGUI.RIGHT:
							{
								player.move(st, this, 2);
								break;
							}
							case SokobanGUI.DOWN:
							{
								player.move(st, this, 3);
								break;
							}	
							case SokobanGUI.LEFT:
							{
								player.move(st, this, 4);
								break;
							}
						}   
					}	
					else if(result == SokobanGUI.QUIT)
					{
						System.exit(0);
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
					System.exit(1);
				}
            }
	}
	
	public SokobanGUI getDisplay()
	{
		return w;
	}
	
	public int getCrateImage()
    {
        return crateImage;
    }

    public int getPlayerImage()
    {
        return playerImage;
    }

    public int getCrate2Image()
    {
        return crate2Image;
    }

    public int getEmptyImage()
    {
        return emptyImage;
    }

    public int getTargetImage()
    {
        return targetImage;
    }

    public int getWallImage()
    {
        return wallImage;
    }

}
