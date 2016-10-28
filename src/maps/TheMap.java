package maps;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class TheMap
{
	TiledMap theMap;
	boolean blocked[][];
	
	public TheMap(String location) throws SlickException
	{
		theMap = new TiledMap(location);
		blocked = new boolean[theMap.getWidth()][theMap.getHeight()];
		fillBlockedMatrix();
	}
	
	public TiledMap getMap()
	{
		return theMap;
	}
	
	public void fillBlockedMatrix()
	{
		for (int h = 0; h < theMap.getHeight(); h++)
		{
			for (int w = 0; w < theMap.getWidth(); w++)
			{
				if ((theMap.getTileProperty(theMap.getTileId(w, h, 0), "Blocked", "False").equals("True")))
				{
					blocked[w][h] = true;
				}
				else
				{
					blocked[w][h] = false;
				}
			}
		}
	}
	
	public boolean[][] getBlockedMatrix()
	{
		return blocked;
	}
	
	public boolean isBlocked(int x, int y)
	{
		return blocked[x][y];
	}
}
