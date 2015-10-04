package com.mygdx.game;


import com.badlogic.gdx.Game;

public class MyGdxGame extends Game {
	public Main_Screen main_screen;
	public Game_Screen game_screen;
	public NewGame_Screen newGame_screen;
	public LoadGame_Screen loadGame_screen;
	public CurrentCharacter CurrentCharacter = new CurrentCharacter();

	public void create() {
		setMainMenuScreen();
	}
	public void setMainMenuScreen()
	{
		main_screen = new Main_Screen(this);
		setScreen(main_screen);
	}
	public void setNewGameScreen()
	{
		newGame_screen = new NewGame_Screen(this);
		setScreen(newGame_screen);
	}
	public void setGameScreen(boolean load)
	{
		game_screen = new Game_Screen(this, load);
		setScreen(game_screen);
	}
	public void setLoadGameScreen()
	{
		loadGame_screen = new LoadGame_Screen(this);
		setScreen(loadGame_screen);
	}
	
}