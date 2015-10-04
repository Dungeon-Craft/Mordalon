package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameStory {
	String text;
	boolean trigger1;
	boolean trigger2;
	boolean trigger3;
	boolean trigger4;
	boolean trigger5;
	boolean trigger6;
	boolean trigger7;
	boolean trigger8;

	SpriteBatch batch ;

	Preferences prefs;
	Preferences prefs1;
	public void setUp(){
		trigger1 = false;
		trigger2 = false;
		trigger3 = false;
		trigger4 = false;
		trigger5 = false;
		trigger6 = false;
		trigger7 = false;
		trigger8 = false;
	}
	
	public String talk(int CellX, int CellY)
	{	
		prefs = Gdx.app.getPreferences("My Preferences");
		text = Integer.toString(CellX) + "," + Integer.toString(CellY);
	
		if(CellX == 23 && CellY == 59)
		{
			if(trigger1 == false & trigger2 == true)
			text = "Hello " + prefs.getString("Name");
			else if(trigger1 == true & trigger2 == true)
			text = "HOW DARE YOU PULL MY LEVER!";
			else if(trigger1 == false & trigger2 == false)
			text = "Hello " + prefs.getString("Name") + ", why are you naked? Here, have some Clothes!";
			else if(trigger1 == true & trigger2 == false)
			text = "Hello " + prefs.getString("Name") + ", why are you naked? Here, have some Clothes!";
		}
		else if(CellX == 22 && CellY == 54)
		{
			text = "This is a Sign, They Normally Tell You Things";
		}
		return text;
		
	}
	
	public boolean getTrigger1()
	{
		return trigger1;
	}
	public void setTrigger1(boolean check)
	{
		trigger1 = check;
	}
	
	public boolean getTrigger2()
	{
		return trigger2;
	}
	public void setTrigger2(boolean check)
	{
		trigger2 = check;
	}
	
	public void triggers(int cellX, int cellY)
	{
		if(cellX == 61 && cellY == 16)
		setTrigger1(true);
		if(cellX == 23 && cellY == 59)
		setTrigger2(true);
	}
	
	public void saveStory()
	{
		prefs1 = Gdx.app.getPreferences("My Preferences");
		prefs = Gdx.app.getPreferences(prefs1.getString("SaveFile"));
		prefs.putBoolean("Trigger1", trigger1);
		prefs.putBoolean("Trigger2", trigger2);
		prefs.flush();
	}
	
	public void loadStory()
	{
		prefs1 = Gdx.app.getPreferences("My Preferences");
		prefs = Gdx.app.getPreferences(prefs1.getString("SaveFile"));
		trigger1 = prefs.getBoolean("Trigger1");
		trigger2 = prefs.getBoolean("Trigger2");
		
	}

	public boolean getYesNo(int cellX, int cellY) {
		
		
		if(cellX == 23 && cellY == 59 && trigger2 == true)
			return false;
		
		
		return true;
		
		
		
		
	}
	public boolean isChest(int cellX, int cellY)
	{
		if(cellX == 93 && cellY == 53)
			return true;
		
		
		
		return false;
	}
	
	
	
	
	
	
}
