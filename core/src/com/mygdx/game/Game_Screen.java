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
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;	
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.List.ListStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Game_Screen implements Screen{
	boolean chatting = false;
	boolean yesno = false;
	boolean moving = false;
	private TiledMap map;
	private OrthogonalTiledMapRenderer	renderer;
	OrthographicCamera camera;
    CallSprite dude = new CallSprite();
    GameStory story = new GameStory();
    BitmapFont Words = new BitmapFont();
    BitmapFont YesNoWords = new BitmapFont();
    String getWords = "";
    int SelectionArrowY;
    int height = Gdx.graphics.getHeight();
    int width = Gdx.graphics.getWidth();
    Cell cellRight;
    int blockedRight = 0;
    Cell cellLeft;
    int blockedLeft = 0;
    Cell cellUp;
    int blockedUp = 1;
    Cell cellDown;
    int blockedDown = 1;
    int clickX = 0;
    int clickY = 0;
    int cellX;
    int cellY;
    int[] layers = {0,1,2,3};
    Preferences prefs;
    Stage ui;
    Stage inventoryStage;
    Stage equipmentStage;
    Stage stage;
    Skin skin;
    ImageButton saveGameButton;
    ImageButton quitButton;
    ImageButton mainButton;
    String Name;
    boolean saveScreen = false;
    boolean choice =  false;
    boolean goingUp =  false;
    boolean goingDown =  false;
    int[] inventory = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    boolean inside = false;
    int								boundaryXLeft = 0;
    int								boundaryYDown = 0;
    int								boundaryXRight = 6720;
    int								boundaryYUp = 4032;
    MyGdxGame						game;
    SpriteBatch                     spriteBatch;            // #6
    TextureRegion                   currentFrame;           // #7
    TextureRegion                   currentHairFrame;           // #7
    TextureRegion                   currentClothesFrame;           // #7
    int								spriteX = 0;
    int								spriteY = 0;
    int								newX = 0;
    int								newY = 0;
    int								LastKey = 3;
    int								speed;
    float 							stateTime;
    int								Hair;
    int								Gender;
    int								Race;
    int								Clothes;
    boolean 						pause = false;
    TiledMapTileLayer 				layer;
    TiledMapTileLayer 				objects;
    String collisionLayer;
    Texture chatter;
    Texture selection;
    Texture selectionArrow;
    SaveGame save = new SaveGame();
    Window saveWindow;
    WindowStyle windowStyle;
    Stage saveGameStage;
    CurrentCharacter file1 = new CurrentCharacter();
    
    NewGame_Screen newgame = new NewGame_Screen(game);
    TextButton saveIt;
    TextButton cancelIt;
    TextButtonStyle saveStyle;
    TextButtonStyle cancelStyle;
    

    TextFieldStyle saveNameStyle = new TextFieldStyle();
    

    TextField saveName;
    
    public Game_Screen(final MyGdxGame game, boolean load) {
    	this.game = game;
    	story.setUp();
    	skin= new Skin();
        skin.add("Save", new Texture("SaveGame.png"));
        skin.add("Quit", new Texture("QuitGame.png"));
        skin.add("MainMenu", new Texture("MainMenuButton.png"));
        skin.add("SaveScreen", new Texture("SaveScreen.png"));
        skin.add("Cursor", new Texture("cursor.png"));
        skin.add("BGText", new Texture("SaveName.png"));
        skin.add("Selected", new Texture("selected.png"));
        saveGameButton = new ImageButton(skin.getDrawable("Save"));
        quitButton = new ImageButton(skin.getDrawable("Quit"));
        mainButton = new ImageButton(skin.getDrawable("MainMenu"));
        quitButton.setPosition(866, 412);
        saveGameButton.setPosition(866, 540);
        mainButton.setPosition(866, 476);
        saveStyle = new TextButtonStyle();
    	saveStyle.font = new BitmapFont();
    	
    	
        saveNameStyle.font = new BitmapFont();
        saveNameStyle.fontColor = Color.WHITE;
        saveNameStyle.cursor = skin.getDrawable("Cursor");
        saveNameStyle.background = skin.getDrawable("BGText");
        saveNameStyle.selection = skin.getDrawable("Selected");
    	
    	
    	
    	saveIt = new TextButton("SAVE", saveStyle);
    	cancelIt = new TextButton("CANCEL", saveStyle);
    	TmxMapLoader loader = new TmxMapLoader();
		map = loader.load("ActualMap.tmx");
		renderer = new OrthogonalTiledMapRenderer(map);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.position.set(spriteX,spriteY, stateTime);
        chatter = new Texture("textScreen.png");
        selection = new Texture("SelectionUI.png");
        selectionArrow = new Texture("selectionArrow.png");
        collisionLayer = "collision";
        
        speed = 2;
        spriteBatch = new SpriteBatch();                // #12
        stateTime = 0f;                         // #13
        Words.getData().setScale(3);
        prefs = Gdx.app.getPreferences("My Preferences");
		Hair = file1.loadCharacter(1);
		Gender = file1.loadCharacter(2);
		Clothes = file1.loadCharacter(3);
		Race = file1.loadCharacter(4);
		windowStyle = new WindowStyle();
		windowStyle.titleFont = new BitmapFont();
		windowStyle.background = skin.getDrawable("SaveScreen");
		

        saveWindow = new Window("Save Game:", windowStyle);
		
        saveName = new TextField("FileName", saveNameStyle);
        saveName.setPosition(791, 550);
        saveName.setWidth(338);
        saveName.setAlignment(1);
        saveName.setMaxLength(9);
     
        
		saveWindow.setHeight(165);
		saveWindow.setWidth(387);
		saveWindow.setPosition(767, 458);
		saveWindow.setTouchable(Touchable.disabled);
		saveIt.setPosition(1067, 470);
		cancelIt.setPosition(817, 470);
		
		saveGameStage = new Stage();
		saveGameStage.addActor(saveWindow);
		saveGameStage.addActor(saveIt);
		saveGameStage.addActor(cancelIt);
		saveGameStage.addActor(saveName);
		
		stage = new Stage();
		stage.addActor(quitButton);
		stage.addActor(mainButton);
		stage.addActor(saveGameButton);
        preferenceLoader(load, prefs.getString("SaveFile"));
        
        saveIt.addListener(new ClickListener(){
        	public void clicked(InputEvent e, float x, float y){
        	save.saveGame(Hair, Gender, spriteX, spriteY, inside, Name, saveName.getText(), Clothes, Race);
    		story.saveStory();
    		saveScreen = false;
        	}
        });
        
        cancelIt.addListener(new ClickListener(){
        	public void clicked(InputEvent e, float x, float y){
        	saveScreen = false;
        	}
        });
        
        quitButton.addListener(new ClickListener(){
        	public void clicked(InputEvent e, float x, float y) {
        		
        		Gdx.app.exit();
        		
            }
        });
        mainButton.addListener(new ClickListener(){
        	public void clicked(InputEvent e, float x, float y) {
        		
        		game.setMainMenuScreen();
        		
            }
        });
        saveGameButton.addListener(new ClickListener(){
        	public void clicked(InputEvent e, float x, float y) {
        		
        		saveScreen = true;
        		
        		
            }
        });
        
        
    }
    
	
	
    @Override
    public void render(float delta) {
    	if(pause && !saveScreen)
        Gdx.input.setInputProcessor(stage);
    	
    	if(saveScreen)
    	Gdx.input.setInputProcessor(saveGameStage);
    		
    	
    	
    	layer = (TiledMapTileLayer) map.getLayers().get(collisionLayer);
    	objects = (TiledMapTileLayer) map.getLayers().get("objects");
    	
		camera.update();
		spriteBatch.setProjectionMatrix(camera.combined);
		Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);                        // #14
        stateTime += Gdx.graphics.getDeltaTime();           // #15
        
       
        cellX = spriteX/64;
        cellY = spriteY/64;
        cellUp = layer.getCell(cellX, cellY+1);
        cellDown = layer.getCell(cellX, cellY-1);
        cellRight = layer.getCell(cellX+1, cellY);
        cellLeft = layer.getCell(cellX-1, cellY);
        if(cellY != 63)
        blockedUp = Integer.parseInt((String) cellUp.getTile().getProperties().get("blocked"));
        if(cellY != 0)
        blockedDown = Integer.parseInt((String) cellDown.getTile().getProperties().get("blocked"));
        if(cellX != 0)
        blockedLeft = Integer.parseInt((String) cellLeft.getTile().getProperties().get("blocked"));
        if(cellX != 105)
        blockedRight = Integer.parseInt((String) cellRight.getTile().getProperties().get("blocked"));
 
        			
        if(!chatting && !pause)
        {
        moveSprite();
        mouseClicks();

        loadTriggeredEvents();
        }
        if(chatting && yesno)
        selectionArrowMove();
        otherKeys();
        
        currentFrame = dude.getSprite(LastKey, moving)[0].getKeyFrame(stateTime, true); // #16
        currentHairFrame = dude.getSprite(LastKey, moving)[1].getKeyFrame(stateTime, true); // #16
        currentClothesFrame = dude.getSprite(LastKey, moving)[2].getKeyFrame(stateTime, true); // #16
        
        camera.position.set(spriteX, spriteY, 0);
        
        renderer.setView(camera);
        renderer.render(layers);
        
        spriteBatch.begin();
        if(chatting == true)
        {
        spriteBatch.draw(chatter, spriteX-(width/2), spriteY-(height/2));
        if(yesno == true)
        {

            spriteBatch.draw(selection, spriteX+(width/2)-154, spriteY-(height/2)+256);
            spriteBatch.draw(selectionArrow, spriteX+(width/2)-144, SelectionArrowY);
            Words.draw(spriteBatch, "Yes\nNo", spriteX+(width/2)-94, spriteY-(height/2)+358);
            	
        }
        
        Words.draw(spriteBatch, getWords, spriteX-(width/100)*46, spriteY-(height/100)*24);
        }
        
        spriteBatch.draw(currentFrame, spriteX, spriteY);  
        spriteBatch.draw(currentClothesFrame, spriteX, spriteY); 
        spriteBatch.draw(currentHairFrame, spriteX, spriteY);    
        spriteBatch.end();
        int[] layer = {7};
        if(!inside)
        renderer.render(layer);
        if(pause && saveScreen)
        saveGameStage.draw();
        if(pause && !saveScreen)
        stage.draw();
    }
    @Override
	public void dispose() {
		spriteBatch.dispose();
		renderer.dispose();
		map.dispose();
		dude.dispose();
		Words.dispose();
		game.dispose();
		
		
		
		

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
	public void selectionArrowMove(){
		
		
		if(Gdx.input.isKeyJustPressed(Input.Keys.UP))
		{
			SelectionArrowY = spriteY-(height/2)+320;
			choice = true;
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN))
		{
			choice = false;
			SelectionArrowY = (int) (spriteY-(height/2)+(0.24629*height));
		}
	}
	public void moveSprite()
	{
		if(Gdx.input.isKeyJustPressed(Input.Keys.SHIFT_LEFT) && spriteX == newX && spriteY == newY)
		{
			if(speed ==2)
				speed = 16;
			else if (speed ==16)
				speed = 2;
		}

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && spriteX == newX && spriteY == newY && spriteX > boundaryXLeft && blockedLeft == 0)
        {
        	LastKey = 1;
        	newX-=64;
        	moving = true;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && spriteX == newX && spriteY == newY && spriteX < boundaryXRight && blockedRight == 0 )
        {
        	LastKey = 0;
        	newX+=64;
        	moving = true;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.UP) && spriteY == newY && spriteX == newX && spriteY < boundaryYUp  && blockedUp == 0)
        {
        	LastKey = 2;
        	newY+=64;
        	moving = true;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.DOWN) && spriteY == newY && spriteX == newX && spriteY > boundaryYDown && blockedDown == 0 )
        {
        	LastKey = 3;
        	newY-=64;
        	moving = true;
        }
        else if(spriteX == newX && spriteY == newY)
        {
        	moving = false;
        }
        
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN) && spriteY == newY && spriteX == newX && spriteY > boundaryYDown && blockedDown == 2 && LastKey == 3)
        {
        	LastKey = 3;
        	newY-=128;
        	moving = true;
        	if(collisionLayer.equals("collision"))
        	{
        		collisionLayer = "Inside";
        		layers[2] = 4;
            	layers[3] = 4;
            	inside = true;
            	
        	}
        	else if(collisionLayer.equals("Inside"))
        	{
        		collisionLayer = "collision";
        		layers[2] = 2;
        		layers[3] = 3;
            	inside = false;
        	}
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP) && spriteY == newY && spriteX == newX && spriteY < boundaryYUp && blockedUp == 2 && LastKey == 2)
        {
        	LastKey = 2;
        	newY+=128;
        	moving = true;
        	if(collisionLayer.equals("collision"))
        	{
        		collisionLayer = "Inside";
        		layers[2] = 4;
            	layers[3] = 4;
            	inside = true;
            	
        	}
        	else if(collisionLayer.equals("Inside"))
        	{
        		collisionLayer = "collision";
        		layers[2] = 2;
        		layers[3] = 3;
            	inside = false;
        	}
        	
        		
        }
         
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && LastKey != 1 && spriteY == newY && spriteX == newX )
        {
        	LastKey = 1;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && LastKey != 0 && spriteY == newY && spriteX == newX )
        {
        	LastKey = 0;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.UP) && LastKey != 2 && spriteY == newY && spriteX == newX )
        {
        	LastKey = 2;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.DOWN) && LastKey != 3 && spriteY == newY && spriteX == newX )
        {
        	LastKey = 3;
        }
        
        
        
        

        
        if(spriteX < newX)
        	spriteX+=(speed);
        if(spriteX > newX)
        	spriteX-=(speed);
        if(spriteY < newY)
        	spriteY+=(speed);
        if(spriteY > newY)
        	spriteY-=(speed);
	}

	public void otherKeys()
	{
		if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && blockedUp == 6 && LastKey == 2)
		{
			SelectionArrowY = spriteY-(height/2)+266;
			
			if(chatting == true)
				chatting = false;
			else if (chatting ==  false)
				chatting = true;
			

			yesno = story.getYesNo(cellX,cellY);
			
			
			getWords = story.talk(cellX, cellY);
			
			if(choice){
			story.triggers(cellX, cellY);
			
			if(story.trigger2)
			{
				
				
				if(prefs.getInteger("Gender") == 1)
				{
				dude.setSprite(prefs.getInteger("Hair"), prefs.getInteger("Gender") , 2 , prefs.getInteger("Race"));
				Clothes = 2;
				}
				if(prefs.getInteger("Gender")==2)
				{
					dude.setSprite(prefs.getInteger("Hair"), prefs.getInteger("Gender") , 3 , prefs.getInteger("Race"));
					Clothes = 3;	
				}
			
			
			}
			}
			
			
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && blockedUp == 3 && LastKey == 2)
		{
			yesno = false;
			if(chatting == true)
				chatting = false;
			else if (chatting ==  false)
				chatting = true;
			getWords = story.talk(cellX, cellY);
			
			
			story.triggers(cellX, cellY);
			
			if(story.trigger2)
			{
				dude.setSprite(prefs.getInteger("Hair"), prefs.getInteger("Gender") , 2 , prefs.getInteger("Race"));
				
				Clothes = 1 + prefs.getInteger("Gender");

			}
			
			
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && blockedUp == 4 && LastKey == 2)
		{
			
			story.triggers(cellX, cellY);
			layer.setCell(cellX, cellY+1, objects.getCell(cellX, cellY+1));
			
			
			
		}
		
		if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE) && !saveScreen)
        {
        if(!pause)
        	pause=true;
        	else
        		pause = false;
        	
        }
	}

	public void mouseClicks()
	{
		
		

			
			
			
			
			
	}
	public void preferenceLoader(boolean load, String fileName){
		
		if(load == true)
		{
		save.loadGame(fileName);
		story.loadStory();
		if(prefs.getBoolean("inside"))
		{
			layers[2] = 4;
        	layers[3] = 4;
        	collisionLayer = "Inside";
        	inside = true;
		}
		}
		Name = prefs.getString("Name");
		spriteY = prefs.getInteger("SpriteY");
		spriteX= prefs.getInteger("SpriteX");
		newY = spriteY;
		newX =spriteX;
		
		
		
		dude.setSprite(prefs.getInteger("Hair"), prefs.getInteger("Gender") , prefs.getInteger("Clothes") , prefs.getInteger("Race"));
		
	}
	public void loadTriggeredEvents()
	{
		if(story.trigger1 == true)
			layer.setCell(61, 17, objects.getCell(61, 17));
	}
	@Override
	public void hide() {
		
		
	}
	
	@Override
	public void show() {
		
		
	}
}

