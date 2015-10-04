package com.mygdx.game;




import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class CurrentCharacter {
	Preferences prefs;
	
	public void saveCharacter(int Hair, int Gender,  int SpriteX, int SpriteY, boolean inside, String name, int clothes, int race) 
	{
		prefs = Gdx.app.getPreferences("My Preferences");
		prefs.putInteger("Hair", Hair);
		prefs.putInteger("Gender", Gender);
		prefs.putInteger("SpriteX", SpriteX);
		prefs.putInteger("SpriteY", SpriteY);
		prefs.putBoolean("Inside", inside);
		prefs.putString("Name", name);
		prefs.putInteger("Clothes", clothes);
		prefs.putInteger("Race", race);
		prefs.flush();
	}
	public int loadCharacter(int setting)
	{
		prefs = Gdx.app.getPreferences("My Preferences");
		int hair = prefs.getInteger("Hair");
		int gender = prefs.getInteger("Gender");
		int clothes = prefs.getInteger("Clothes");
		int race = prefs.getInteger("Race");
		if(setting == 1)
			return hair;
		if(setting == 2)	
			return gender;
		if(setting == 3)
			return clothes;
		if(setting == 4)
			return race;
		return 0;
		
	}
}
