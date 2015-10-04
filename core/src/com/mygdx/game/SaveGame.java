package com.mygdx.game;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;


public class SaveGame {
    
	
	
		Preferences prefs;
		Preferences prefs2;
		Preferences prefsLoad;
		public void saveGame(int Hair, int Gender, int SpriteX, int SpriteY, boolean inside, String Name, String fileName, int clothes, int race) 
		{
			prefsLoad = Gdx.app.getPreferences("SaveFiles");
			prefs = Gdx.app.getPreferences(fileName);
			String Old;
			String Current;
			Boolean yes;
			int ID = prefsLoad.getInteger("Files");
			for(int i = 0; i < prefsLoad.getInteger("Files"); i++){
				
				Old = prefsLoad.getString(Integer.toString(i));
				yes = Old.equals(fileName);
				if(yes)
				{
					ID = i;
				}
				
			}
			
			
			prefs.putInteger("Hair", Hair);
			prefs.putInteger("Gender", Gender);
			prefs.putInteger("SpriteX", SpriteX);
			prefs.putInteger("SpriteY", SpriteY);
			prefs.putBoolean("inside", inside);
			prefs.putString("Name", Name);
			prefs.putInteger("Clothes", clothes);
			prefs.putInteger("Race", race);
			prefsLoad.putString(Integer.toString(ID), fileName);
			
			if(ID == prefsLoad.getInteger("Files"))
			prefsLoad.putInteger("Files", ID+1);
			
			prefsLoad.flush();
			prefs.flush();
		}
		public void loadGame(String fileName)
		{
			prefs = Gdx.app.getPreferences(fileName);
			prefs2 = Gdx.app.getPreferences("My Preferences");
			prefs2.putInteger("Hair", prefs.getInteger("Hair"));
			prefs2.putInteger("Gender", prefs.getInteger("Gender"));
			prefs2.putInteger("SpriteX", prefs.getInteger("SpriteX"));
			prefs2.putInteger("SpriteY", prefs.getInteger("SpriteY"));
			prefs2.putBoolean("inside", prefs.getBoolean("inside"));
			prefs2.putString("Name", prefs.getString("Name"));
			prefs2.putInteger("Clothes", prefs.getInteger("Clothes"));
			prefs2.putInteger("Race", prefs.getInteger("Race"));
			prefs2.flush();
			
		}
	
    
}