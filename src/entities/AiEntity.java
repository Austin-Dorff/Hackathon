package entities;

import maps.TheMap;

import org.newdawn.slick.SlickException;

public class AiEntity extends BasicEntity 
{

	public AiEntity(int posX, int posY, String name, String type, String spriteLocation, TheMap theMapThingy, double health, double maxHealth, double moveSpeed) throws SlickException
	{
		super(posX, posY, name, type, spriteLocation, theMapThingy, health, maxHealth, moveSpeed);
	}
	
	public void goToEntity(BasicEntity entity, int delta)
	{
		double entityXPosition = entity.getPosX();
		double entityYPosition = entity.getPosY();
		double myXPosition = getPosX();
		double myYPosition = getPosY();
		
		double changeInX;
		double changeInY;
		double direction;
		
		if ((myXPosition != entityXPosition) && (myYPosition != entityYPosition))
		{
			if (myXPosition > entityXPosition)
			{
				direction = 270;
				setOriginalDirection2(direction);
				changeInX = entityXPosition - myXPosition;
				if (myYPosition > entityYPosition)
				{
					changeInY = entityYPosition - myYPosition;
					direction += Math.toDegrees(Math.atan(changeInY / changeInX));
					setOriginalDirection2(direction);
				}
				else if (myYPosition < entityYPosition)
				{
					changeInY = myYPosition - entityYPosition;
					direction -= Math.toDegrees(Math.atan(changeInY / changeInX));
					setOriginalDirection2(direction);
				}
			}
			else if (myXPosition < entityXPosition)
			{
				direction = 90;
				setOriginalDirection2(direction);
				changeInX = myXPosition - entityXPosition;
				if (myYPosition > entityYPosition)
				{
					changeInY = entityYPosition - myYPosition;
					direction -= Math.toDegrees(Math.atan(changeInY / changeInX));
					setOriginalDirection2(direction);
				}
				else if (myYPosition < entityYPosition)
				{
					changeInY = myYPosition - entityYPosition;
					direction += Math.toDegrees(Math.atan(changeInY / changeInX));
					setOriginalDirection2(direction);
				}
			}
			else if (myXPosition == entityXPosition)
			{
				if (myYPosition > entityYPosition)
				{
					direction = 0;
					setOriginalDirection2(direction);
				}
				else
				{
					direction = 180;
					setOriginalDirection2(direction);
				}
			}
			if (isOppositeDirection(getOriginalDirection(), getOriginalDirection2()))
			{
				setDirection(getOriginalDirection());
			}
			else
			{
				End:
					while (!canMove(getDirection()))
					{
						if ((isTargetBelow(entity)) && (canMove(180)))
						{
							setDirection(180);
							break End;
						}
						else if ((isTargetBelow(entity)) && (canMove(90)) && (isTargetToRight(entity)))
						{
							setDirection(90);
							break End;
						}
						else if ((isTargetBelow(entity)) && (canMove(270)) && (isTargetToLeft(entity)))
						{
							setDirection(270);
							break End;
						}
						else if ((isTargetBelow(entity)) && (canMove(90)))
						{
							setDirection(90);
							break End;
						}
						else if ((isTargetBelow(entity)) && (canMove(270)))
						{
							setDirection(270);
							break End;
						}
						else if ((isTargetAbove(entity)) && (canMove(0)))
						{
							setDirection(0);
							break End;
						}
						else if ((isTargetAbove(entity)) && (canMove(90)) && (isTargetToRight(entity)))
						{
							setDirection(90);
							break End;
						}
						else if ((isTargetAbove(entity)) && (canMove(270)) && (isTargetToLeft(entity)))
						{
							setDirection(270);
							break End;
						}
						else if ((isTargetAbove(entity)) && (canMove(90)))
						{
							setDirection(90);
							break End;
						}
						else if ((isTargetAbove(entity)) && (canMove(270)))
						{
							setDirection(270);
							break End;
						}
						else if ((isTargetToLeft(entity)) && (canMove(270)))
						{
							setDirection(270);
							break End;
						}
						else if ((isTargetToLeft(entity)) && (canMove(0)) && (isTargetAbove(entity)))
						{
							setDirection(0);
							break End;
						}
						else if ((isTargetToLeft(entity)) && (canMove(180)) && (isTargetBelow(entity)))
						{
							setDirection(180);
							break End;
						}
						else if ((isTargetToLeft(entity)) && (canMove(0)))
						{
							setDirection(0);
							break End;
						}
						else if ((isTargetToLeft(entity)) && (canMove(180)))
						{
							setDirection(180);
							break End;
						}
						else if ((isTargetToRight(entity)) && (canMove(90)))
						{
							setDirection(90);
							break End;
						}
						else if ((isTargetToRight(entity)) && (canMove(0)) && (isTargetAbove(entity)))
						{
							setDirection(0);
							break End;
						}
						else if ((isTargetToRight(entity)) && (canMove(180)) && (isTargetBelow(entity)))
						{
							setDirection(180);
							break End;
						}
						else if ((isTargetToRight(entity)) && (canMove(0)))
						{
							setDirection(0);
							break End;
						}
						else if ((isTargetToRight(entity)) && (canMove(180)))
						{
							setDirection(180);
							break End;
						}
					}
			}
			if (canMove(getDirection()))
			{
				setOriginalDirection(getDirection());
				move(getDirection(), getMoveSpeed() * delta);
			}
		}
	}

	public boolean isTargetToLeft(BasicEntity target)
	{
		if (getPosX() > target.getPosX())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isTargetToRight(BasicEntity target)
	{
		if (getPosX() < target.getPosX())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isTargetAbove(BasicEntity target)
	{
		if (getPosY() > target.getPosY())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isTargetBelow(BasicEntity target)
	{
		if (getPosY() < target.getPosY())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
