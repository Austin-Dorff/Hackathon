package entities;

import maps.TheMap;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BasicEntity
{
	int		posX				= 0;
	int		posY				= 0;
	int		posX2				= 0;
	int		posY2				= 0;
	int		tilePosX			= 0;
	int		tilePosY			= 0;
	
	int		entityImageWidth	= 0;
	int		entityImageHeight	= 0;
	
	Image	entityImage;
	
	double	health				= 0;
	double	maxHealth			= 0;
	double	moveSpeed			= 0;
	double	direction			= 0;
	double	origDirection		= 0;
	double	origDirection2		= 0;
	
	TheMap	theMap;
	
	String	type				= "";
	String	name				= "";
	
	public BasicEntity(int posX, int posY, String name, String type, String spriteLocation, TheMap theMapThingy, double health, double maxHealth, double moveSpeed) throws SlickException
	{
		setPosX(posX);
		setPosY(posY);
		setName(name);
		setType(type);
		setHealth(health);
		setMaxHealth(maxHealth);
		setMoveSpeed(moveSpeed);
		entityImage = new Image(spriteLocation);
		theMap = theMapThingy;
	}
	
	public int getPosX()
	{
		return posX;
	}
	
	public int getPosY()
	{
		return posY;
	}
	
	public int getPosX2()
	{
		return posX + getEntityImageWidth();
	}
	
	public int getPosY2()
	{
		return posY + getEntityImageHeight();
	}
	
	public int getTilePosX()
	{
		if (getPosX() > theMap.getMap().getWidth() / 2)
		{
			return (getPosX2() / theMap.getMap().getTileWidth());
		}
		else
		{
			return (getPosX() / theMap.getMap().getTileWidth());
		}
	}
	
	public int getTilePosY()
	{
		if (getPosY() > theMap.getMap().getWidth() / 2)
		{
			return (getPosY2() / theMap.getMap().getTileHeight());
		}
		else
		{
			return (getPosY() / theMap.getMap().getTileHeight());
		}
	}
	
	public double getDirection()
	{
		return direction;
	}
	
	public double getOriginalDirection()
	{
		return origDirection;
	}
	
	public double getOriginalDirection2()
	{
		return origDirection2;
	}
	
	public int getEntityImageWidth()
	{
		return entityImageWidth;
	}
	
	public int getEntityImageHeight()
	{
		return entityImageHeight;
	}
	
	public Image getEntityImage()
	{
		return entityImage;
	}
	
	public double getHealth()
	{
		return health;
	}
	
	public double getMaxHealth()
	{
		return maxHealth;
	}
	
	public double getMoveSpeed()
	{
		return moveSpeed;
	}
	
	public TheMap getTheMap()
	{
		return theMap;
	}
	
	public String getType()
	{
		return type;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setPosX(int posX)
	{
		this.posX = posX;
	}
	
	public void setPosY(int posY)
	{
		this.posY = posY;
	}
	
	public void setDirection(double value)
	{
		direction = value;
	}
	
	public void setOriginalDirection(double value)
	{
		origDirection = value;
	}
	
	public void setOriginalDirection2(double value)
	{
		origDirection2 = value;
	}
	
	public void setEntityImageWidth(int entityImageWidth)
	{
		this.entityImageWidth = entityImageWidth;
	}
	
	public void setEntityImageHeight(int entityImageHeight)
	{
		this.entityImageHeight = entityImageHeight;
	}
	
	public void setEntityImage(Image entityImage)
	{
		this.entityImage = entityImage;
	}
	
	public void setHealth(double health)
	{
		this.health = health;
	}
	
	public void setMaxHealth(double maxHealth)
	{
		this.maxHealth = maxHealth;
	}
	
	public void setMoveSpeed(double moveSpeed)
	{
		this.moveSpeed = moveSpeed;
	}
	
	public void setTheMap(TheMap theMap)
	{
		this.theMap = theMap;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void decreaseHealthBy(double amount)
	{
		if (getHealth() - amount <= 0)
		{
			setHealth(0);
		}
		else
		{
			setHealth(getHealth() - amount);
		}
	}
	
	public void increaseHealthBy(double amount)
	{
		if (getHealth() + amount >= getMaxHealth())
		{
			setHealth(getMaxHealth());
		}
		else
		{
			setHealth(getHealth() + amount);
		}
	}
	
	public void move(double direction, double speed)
	{
		if (direction == 0)
		{
			setPosY((int) (getPosY() - (1 * speed)));
		}
		if (direction == 90)
		{
			setPosX((int) (getPosX() + (1 * speed)));
		}
		if (direction == 180)
		{
			setPosY((int) (getPosY() + (1 * speed)));
		}
		if (direction == 270)
		{
			setPosX((int) (getPosX() - (1 * speed)));
		}
		if (direction > 270)
		{
			setPosX((int) (getPosX() - (1 * speed)));
			setPosY((int) (getPosY() - (1 * speed)));
		}
		if ((direction > 180) && (direction < 270))
		{
			setPosX((int) (getPosX() + (1 * speed)));
			setPosY((int) (getPosY() + (1 * speed)));
		}
		if ((direction > 90) && (direction < 180))
		{
			setPosX((int) (getPosX() + (1 * speed)));
			setPosY((int) (getPosY() + (1 * speed)));
		}
		if ((direction > 0) && (direction < 90))
		{
			setPosX((int) (getPosX() + (1 * speed)));
			setPosY((int) (getPosY() - (1 * speed)));
		}
	}
	
	public boolean canMove(double direction)
	{
		
		if (direction == 0)
		{
			if (theMap.isBlocked(getTilePosX(), getTilePosY() - 1) == false)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if ((direction > 0) && (direction < 90))
		{
			if ((theMap.isBlocked(getTilePosX() + 1, getTilePosY() - 1) == false) && (theMap.isBlocked(getTilePosX(), getTilePosY() - 1) == false) && (theMap.isBlocked(getTilePosX() + 1, getTilePosY()) == false))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if (direction == 90)
		{
			if (theMap.isBlocked(getTilePosX() + 1, getTilePosY()) == false)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if ((direction > 90) && (direction < 180))
		{
			if ((theMap.isBlocked(getTilePosX() + 1, getTilePosY() + 1) == false) && (theMap.isBlocked(getTilePosX(), getTilePosY() + 1) == false) && (theMap.isBlocked(getTilePosX() + 1, getTilePosY()) == false))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if (direction == 180)
		{
			if (theMap.isBlocked(getTilePosX(), getTilePosY() + 1) == false)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if ((direction > 180) && (direction < 270))
		{
			if ((theMap.isBlocked(getTilePosX() - 1, getTilePosY() + 1) == false) && (theMap.isBlocked(getTilePosX(), getTilePosY() + 1) == false) && (theMap.isBlocked(getTilePosX() - 1, getTilePosY()) == false))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if (direction == 270)
		{
			if (theMap.isBlocked(getTilePosX() - 1, getTilePosY()) == false)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if ((direction > 270) && (direction < 360))
		{
			if ((theMap.isBlocked(getTilePosX() - 1, getTilePosY() - 1) == false) && (theMap.isBlocked(getTilePosX(), getTilePosY() - 1) == false) && (theMap.isBlocked(getTilePosX() - 1, getTilePosY()) == false))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	public boolean isOppositeDirection(double direction, double direction2)
	{
		if ((direction <= 180) && (direction2 == direction + 180))
		{
			return true;
		}
		else if ((direction >= 180) && (direction2 == direction - 180))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
