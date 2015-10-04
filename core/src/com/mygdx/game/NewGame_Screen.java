package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class NewGame_Screen implements Screen{
	OrthographicCamera camera;
    CallSprite dude = new CallSprite();
    int height = Gdx.graphics.getHeight();
    int width = Gdx.graphics.getWidth();
    int clickX = 0;
    int clickY = 0;            // #6
    TextureRegion                   currentFrame;           // #7
    TextureRegion                   currentHairFrame;  
    TextureRegion					currentClothesFrame;
    MyGdxGame						game;
    SpriteBatch                     spriteBatch;            // #6
    
    float 							stateTime;    
    int								Hair;
    int								Gender;
    int								Race;
    Stage stage;
    Skin skin;
    ImageButton rightArrowHair;
    ImageButton leftArrowHair;
    ImageButton rightArrowGender;
    ImageButton leftArrowGender;
    ImageButton rightArrowRace;
    ImageButton leftArrowRace;
    ImageButton playButton;
    int hairStyles = 2;
    int races = 2;
    Texture characterScreen;
    CurrentCharacter file1 = new CurrentCharacter();
    TextFieldStyle blue = new TextFieldStyle();
    TextField name;
    int clothes = 1;
    public NewGame_Screen(final MyGdxGame game) {
    	this.game = game;
    	camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.position.set(0,0, stateTime);
        characterScreen = new Texture("CharacterScreen.png");
        Hair = 1;
        Gender = 1;
        Race = 1;
        dude.setSprite(Hair,Gender,1,1);
        spriteBatch = new SpriteBatch();                // #12
        stateTime = 0f;
        
    	skin= new Skin();
        skin.add("Left", new Texture("LeftArrow.png"));
        skin.add("Cursor", new Texture("cursor.png"));
        skin.add("BGText", new Texture("TextBox.png"));
        skin.add("Right", new Texture("RightArrow.png"));
        skin.add("Play", new Texture("PlayButton.png"));
        skin.add("Selected", new Texture("selected.png"));
        rightArrowHair = new ImageButton(skin.getDrawable("Right"));
        leftArrowHair = new ImageButton(skin.getDrawable("Left"));
        rightArrowGender = new ImageButton(skin.getDrawable("Right"));
        leftArrowGender = new ImageButton(skin.getDrawable("Left"));
        rightArrowRace = new ImageButton(skin.getDrawable("Right"));
        leftArrowRace = new ImageButton(skin.getDrawable("Left"));
        playButton = new ImageButton(skin.getDrawable("Play"));
        

        blue.font = new BitmapFont();
        blue.fontColor = Color.BLACK;
        blue.cursor = skin.getDrawable("Cursor");
        blue.background = skin.getDrawable("BGText");
        blue.selection =skin.getDrawable("Selected");
        
        int positionPBX = (int) ((.4046875)*width);
        int positionPBY = (int)((0.217593)*height);

        playButton.setPosition(positionPBX, positionPBY);

        rightArrowHair.setPosition((float) (0.29635417*width), (float) (0.63519*height));

       	leftArrowHair.setPosition((float) (0.15260417*width), (float) (0.63519*height));

        rightArrowGender.setPosition((float) (0.29635417*width), (float) (0.537*height));

        leftArrowGender.setPosition((float) (0.15260417*width), (float) (0.537*height));

        rightArrowRace.setPosition((float) (0.29635417*width), (float) (0.737*height));

        leftArrowRace.setPosition((float) (0.15260417*width), (float) (0.737*height));

        name = new TextField("Name", blue);
        name.setPosition((float) (0.260417*width), (float) (0.4629*height));
        name.setWidth((float) (0.202083*width));
        name.setAlignment(1);
        name.setMaxLength(9);
        
        stage = new Stage();
        stage.addActor(playButton);
        stage.addActor(rightArrowHair);
        stage.addActor(leftArrowHair);
        stage.addActor(rightArrowGender);
        stage.addActor(leftArrowGender);
        stage.addActor(rightArrowRace);
        stage.addActor(leftArrowRace);
        stage.addActor(name);

        rightArrowHair.addListener(new ClickListener(){
        	public void clicked(InputEvent e, float x, float y) {
        		
        		Hair++;
        		if(Hair > hairStyles)
        			Hair = 1;
        		
        		file1.saveCharacter(Hair, Gender, 0 , 0 , false, name.getText(), clothes,Race);
				dude.setSprite(Hair, Gender,1,Race);
        		
        		
            }
        });
        leftArrowHair.addListener(new ClickListener(){
        	public void clicked(InputEvent e, float x, float y) {
        		Hair--;
        		if(Hair < 1)
        			Hair = hairStyles;
        		
        		file1.saveCharacter(Hair, Gender, 0 , 0 , false, name.getText(), clothes,Race);
				dude.setSprite(Hair, Gender,1,Race);
            }
        });
        rightArrowRace.addListener(new ClickListener(){
        	public void clicked(InputEvent e, float x, float y) {
        		
        		Race++;
        		if(Race > races)
        			Race = 1;
        		
        		file1.saveCharacter(Hair, Gender, 0 , 0 , false, name.getText(), clothes,Race);
				dude.setSprite(Hair, Gender,1,Race);
        		
        		
            }
        });
        leftArrowRace.addListener(new ClickListener(){
        	public void clicked(InputEvent e, float x, float y) {
        		Race--;
        		if(Race < 1)
        			Race = races;
        		
        		file1.saveCharacter(Hair, Gender, 0 , 0 , false, name.getText(), clothes,Race);
				dude.setSprite(Hair, Gender,1,Race);
            }
        });
        rightArrowGender .addListener(new ClickListener(){
        	public void clicked(InputEvent e, float x, float y) {
        		
        			Gender++;
        			if(Gender > 2)
        				Gender = 1;
        			
        			file1.saveCharacter(Hair, Gender, 0 , 0 , false, name.getText(),clothes,Race);
    				dude.setSprite(Hair, Gender, 1,Race);
        		
        		
            }
        });
        leftArrowGender.addListener(new ClickListener(){
        	public void clicked(InputEvent e, float x, float y) {
        		Gender++;
    			if(Gender > 2)
    				Gender = 1;
    			
    			file1.saveCharacter(Hair, Gender, 0 , 0 , false, name.getText(), clothes,Race);
				dude.setSprite(Hair, Gender, 1,Race);
            }
        });
        playButton.addListener(new ClickListener(){
        	public void clicked(InputEvent e, float x, float y) {

				file1.saveCharacter(Hair, Gender, 0 , 0 , false , name.getText(), clothes ,Race);
						
        		stage.clear();
        		game.setGameScreen(false);
        		
            }
        });
        
        
        
        
        
        
        
        
        
        
        
        
        
        

        }
    
	
	
    @Override
    public void render(float delta) {
    	camera.update();

        Gdx.input.setInputProcessor(stage);
		spriteBatch.setProjectionMatrix(camera.combined);
		Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);                        // #14
        stateTime += Gdx.graphics.getDeltaTime();           // #15
        mouseClicks();
        otherKeys();
        currentFrame = dude.getSprite(3, false)[0].getKeyFrame(stateTime, true); // #16
        currentHairFrame = dude.getSprite(3, false)[1].getKeyFrame(stateTime, true); // #16
        currentClothesFrame = dude.getSprite(3, false)[2].getKeyFrame(stateTime, true); // #16

        camera.position.set(0, 0, 0);
        spriteBatch.begin();
        spriteBatch.draw(characterScreen, -(width/2), -(height/2));
        spriteBatch.draw(currentFrame, 0, 0);
        spriteBatch.draw(currentHairFrame, 0, 0);
        spriteBatch.draw(currentClothesFrame, 0, 0);
        spriteBatch.end();
        stage.draw();
    }
    @Override
	public void dispose() {
		spriteBatch.dispose();
		dude.dispose();
		game.dispose();
		stage.dispose();
		skin.dispose();
		

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

	public void otherKeys()
	{
			
		if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
        {
        Gdx.app.exit();
        	
        }
	}

	public void mouseClicks()
	{
		
		
	}


	@Override
	public void hide() {
		
		
	}

	@Override
	public void show() {
		
		
	}
}
