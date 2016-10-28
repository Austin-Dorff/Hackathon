package runner;

import maps.TheMap;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import entities.enemies.EnemyOne;
import entities.player.ThePlayer;

public class TheGame extends StateBasedGame 
{
	static TheMap theMap;
	static ThePlayer thePlayer;
	static EnemyOne  enemyOne;
	
	public static void main(String[] args) throws SlickException
	{
		AppGameContainer c = new AppGameContainer(new TheGame("Engine"));
		c.setVSync(true);
		c.setShowFPS(true);
		c.setTargetFrameRate(144);
		c.setDisplayMode(800, 800, false);
		c.start();
		theMap = new TheMap(Reference.MAP_LOCATION_FOLDER + "map.tmx");
		thePlayer = new ThePlayer(32, 32, "Fred", Reference.TYPE_PLAYER, Reference.SPRITE_LOCATION_FOLDER + "player.png" , theMap, Reference.PLAYER_HEALTH, Reference.PLAYER_MAX_HEALTH, Reference.PLAYER_MOVE_SPEED);
	}

	public TheGame(String name) throws SlickException
	{
		super(name);
	}

	public void initStatesList(GameContainer container) throws SlickException
	{
		
	}

}
