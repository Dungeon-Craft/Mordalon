package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class LoadGame_Screen implements Screen{
	Stage stage;
	Table container;
	Table list;
	Skin skin;
	TextButtonStyle style;
    public LoadGame_Screen(MyGdxGame game) {
    	game = new MyGdxGame();
    	skin = new Skin();
    	skin.add("BG", new Texture("loadGameListBG.png"));
    	style = new TextButtonStyle();
    	style.up = skin.getDrawable("BG");
    	style.font =new BitmapFont();
    	list.addActor(new TextButton("Meow", style));
    	container = new Table();
    	container.setFillParent(true);
    	
        }
    
	
	
    @Override
    public void render(float delta) {
        Gdx.input.setInputProcessor(stage);
    	stage.draw();
    }
    @Override
	public void dispose() {
		
		

	}
	@Override
	public void resize(int width, int height) {
		
		
	}

	@Override
	public void pause() {
		
		
	}

	@Override
	public void resume() {
		
		
	}

	

	@Override
	public void hide() {
		
		
	}

	@Override
	public void show() {
		
		
	}
}
