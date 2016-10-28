package entities.enemies;

import maps.TheMap;

import org.newdawn.slick.SlickException;

import entities.AiEntity;

public class EnemyOne extends AiEntity 
{

	public EnemyOne(int posX, int posY, String name, String type, String spriteLocation, TheMap theMapThingy, double health, double maxHealth, double moveSpeed) throws SlickException
	{
		super(posX, posY, name, type, spriteLocation, theMapThingy, health, maxHealth, moveSpeed);
	}
	
}
