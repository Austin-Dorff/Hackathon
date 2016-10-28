package entities.player;

import maps.TheMap;

import org.newdawn.slick.SlickException;

import entities.BasicEntity;

public class ThePlayer extends BasicEntity
{

	public ThePlayer(int posX, int posY, String name, String type, String spriteLocation, TheMap theMapThingy, double health, double maxHealth, double moveSpeed) throws SlickException
	{
		super(posX, posY, name, type, spriteLocation, theMapThingy, health, maxHealth, moveSpeed);
	}
	
}
