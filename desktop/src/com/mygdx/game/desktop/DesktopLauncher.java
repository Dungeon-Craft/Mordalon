package com.mygdx.game.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		new LwjglApplication(new MyGdxGame(), config);
		System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");
		config.height = Gdx.graphics.getHeight();
		config.width = Gdx.graphics.getWidth();
		config.resizable = false;
	}
}
