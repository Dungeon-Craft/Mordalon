package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.List.ListStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane.ScrollPaneStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Main_Screen implements Screen{
	OrthographicCamera camera;
	boolean loading = false;
    boolean homeScreen = true;
    Texture home;
    int height = Gdx.graphics.getHeight();
    int width = Gdx.graphics.getWidth();
    float containerWidth = (float)(0.412*width);
    float containerHeight = (float)(0.4629*height);
    int clickX = 0;
    int clickY = 0;
    CallSprite dude;
    MyGdxGame						game;
    SpriteBatch                     spriteBatch;         // #7
    int								spriteX = 0;
    int								spriteY = 0;
    Stage stage;
    Stage loadGameStage;
    ImageButton newGameButton;
    ImageButton loadGameButton;
    ImageButton exitButton;	
    Skin skin;
    float 							stateTime; ;
    
    

    
    
    
    
    
    

    ScrollPane scroll;
	List list;
	ListStyle listStyle;
    
    
    
    
    
    
    Table container = new Table();
    
    
    
    
    
    
    

    TextButton loadIt;
    TextButton cancelIt;
    TextButtonStyle loadStyle;
    TextButtonStyle cancelStyle;
    

    TextFieldStyle loadNameStyle = new TextFieldStyle();
    

    TextField loadName;
    
    

    Window loadWindow;
    WindowStyle windowStyle;
    ScrollPaneStyle scrollStyle = new ScrollPaneStyle();
    Preferences prefs;
    Preferences prefsLoad;
    
    Table table = new Table();
    
    
    
    @SuppressWarnings("rawtypes")
	public Main_Screen(final MyGdxGame game) {
    	this.game = game;

    	skin= new Skin();
        skin.add("NewGame", new Texture("NewGameButton.png"));
        skin.add("Exit", new Texture("ExitButton.png"));
        skin.add("Selection", new Texture("selected.png"));
        skin.add("Scroll", new Texture("scrollBar.png"));
        skin.add("knob", new Texture("scrollknob.png"));
        skin.add("back", new Texture("scrollback.png"));
        newGameButton = new ImageButton(skin.getDrawable("NewGame"));
        exitButton = new ImageButton(skin.getDrawable("Exit"));


        
        
        
        int positionNGX = (int) ((.4046875)*width);
        int positionNGY = (int)((0.2528)*height);
        
        newGameButton.setPosition(positionNGX, positionNGY);
        
        int positionEX = (int) ((0.447917)*width);
        int positionEY = (int)((0.10926)*height);
      
        
        exitButton.setPosition(positionEX,positionEY);
        
        
        scrollStyle.vScroll = skin.getDrawable("Scroll");
        scrollStyle.vScrollKnob = skin.getDrawable("knob");
        scrollStyle.background = skin.getDrawable("back");
        


    	listStyle = new ListStyle();
    	listStyle.font = new BitmapFont();
    	listStyle.fontColorSelected = Color.BLUE;
    	listStyle.fontColorUnselected = Color.GREEN;
        listStyle.selection = skin.getDrawable("Selection");
        list = new List(listStyle);
        

       
        scroll = new ScrollPane(list, scrollStyle);
        
        scroll.setFillParent(true);
        scroll.setWidth((float) (0.1765625*width));
        
        scroll.setVariableSizeKnobs(false);
        scroll.setFadeScrollBars(false);
        list.setHeight((float) (0.0926*height));
        list.setWidth((float) (0.1765625*width));
        list.setFillParent(true);
        scroll.setPosition(40, 40);
        container.add(scroll).width((float) (0.1765625*width)).height((float) (0.0926*height));
        container.setHeight((float) (0.0926*height));
        container.setWidth((float) (0.1765625*width));
        String[] blue = setLoadGameList();
        list.setItems(blue);
        
        
        container.setPosition(containerWidth,containerHeight);
        
        stage = new Stage();
        stage.addActor(newGameButton);
        stage.addActor(exitButton);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.position.set(spriteX,spriteY, stateTime);
        
        home = new Texture("Mordalon_Main_Menu.png");
        newGameButton.addListener(new ClickListener(){
        	public void clicked(InputEvent e, float x, float y) {
        		stage.clear();
                game.setNewGameScreen();
            }
        });
        
        exitButton.addListener(new ClickListener(){
        	public void clicked(InputEvent e, float x, float y) {
                Gdx.app.exit();
            }
        });
      
        spriteBatch = new SpriteBatch();                // #12
        stateTime = 0f;                         // #13

        loadStyle = new TextButtonStyle();
        loadStyle.font = new BitmapFont();
        skin.add("LoadScreen", new Texture("SaveScreen.png"));
        skin.add("Cursor", new Texture("cursor.png"));
        skin.add("BGText", new Texture("SaveName.png"));

		windowStyle = new WindowStyle();
		windowStyle.titleFont = new BitmapFont();
		windowStyle.background = skin.getDrawable("LoadScreen");
        
        

        loadNameStyle.font = new BitmapFont();
        loadNameStyle.fontColor = Color.WHITE;
        loadNameStyle.cursor = skin.getDrawable("Cursor");
        loadNameStyle.background = skin.getDrawable("BGText");
        

        loadWindow = new Window("Load Game:", windowStyle);

        loadWindow.setHeight((float) (.1528*height));
		loadWindow.setWidth((float) (0.2015625*width));
		loadWindow.setPosition((float) (0.39947917*width), (float) (0.4240741*height));
		
        
        

        
        
        
        

    	loadIt = new TextButton("LOAD", loadStyle);
    	cancelIt = new TextButton("CANCEL", loadStyle);
		loadIt.setPosition((float)(0.5677083)*width, (float) (0.435185*height));
		cancelIt.setPosition((float) (0.412037*width), (float) (0.435185*height));
        
        
        loadWindow.setTouchable(Touchable.disabled);

		loadGameStage = new Stage();
		loadGameStage.addActor(loadWindow);
		loadGameStage.addActor(loadIt);
		loadGameStage.addActor(cancelIt);
		loadGameStage.addActor(container);
        
		
        
        
        
		loadIt.addListener(new ClickListener(){
        	public void clicked(InputEvent e, float x, float y){
        	

        		prefsLoad = Gdx.app.getPreferences("SaveFiles");
    			prefs = Gdx.app.getPreferences("My Preferences");
    			prefs.putString("SaveFile", prefsLoad.getString(Integer.toString(list.getSelectedIndex())));
        		stage.clear();
        		loadGameStage.clear();
        		
        		game.setGameScreen(true);
        		
        	}
        });
        
        cancelIt.addListener(new ClickListener(){
        	public void clicked(InputEvent e, float x, float y){
        	loading = false;
        	}
        });
        
        
        
        
        
        
        
        
        
        
        
    }
    
	
	
    @Override
    public void render(float delta) {
    	
    	if(!loading)
        Gdx.input.setInputProcessor(stage);

        if(loading)
        {
        	loadGameStage.act();
            Gdx.input.setInputProcessor(loadGameStage);
        }	
    	camera.update();
		spriteBatch.setProjectionMatrix(camera.combined);
		Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);                        // #14
        stateTime += Gdx.graphics.getDeltaTime();    
        mouseClicks();
        spriteBatch.begin();
        spriteBatch.draw(home, -(width/2), -height/2);
        spriteBatch.end();
        stage.draw();
        if(loading)
        {
        	loadGameStage.draw();
        }
    }
    @Override
	public void dispose() {
		spriteBatch.dispose();
		stage.dispose();
		

	}
    public void setNewGame()
    {
    	
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
	public void mouseClicks()
	{
		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
			if(Gdx.input.getX() >=0.40364583*width && Gdx.input.getX()<=.625*width && Gdx.input.getY()>=0.476852*height && Gdx.input.getY()<=.593*height)
			{
				
				//game.setLoadGameScreen();
				
				loading = true;
			}
			
		}
		

			

			
			
			
			
			
			
	}
	public String[] setLoadGameList(){
		
		prefsLoad = Gdx.app.getPreferences("SaveFiles");
		int Size = prefsLoad.getInteger("Files");
		
		
		
		String[] blue = new String[Size];
		
		for(int i = 0; i<Size; i++)
		{
			blue[i] = prefsLoad.getString(Integer.toString(i));
		}
		
		
		
		return blue;
	}

	@Override
	public void hide() {
		
		
	}

	@Override
	public void show() {
		
		
	}
}
