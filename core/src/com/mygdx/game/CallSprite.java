package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class CallSprite {
	        // #4
    private static final int        FRAME_COLS = 4;         // #1
    private static final int        FRAME_ROWS = 4;
	private static TextureRegion[]                 walkFramesUp;             // #5
    private static TextureRegion[]                 walkFramesUpIdle;             // #5
    private static TextureRegion[]                 walkFramesDown;             // #5
    private static TextureRegion[]                 walkFramesDownIdle;             // #5
    private static TextureRegion[]                 walkFramesLeft;             // #5
    private static TextureRegion[]                 walkFramesLeftIdle;             // #5
    private static TextureRegion[]                 walkFramesRight;
    private static TextureRegion[]                 walkFramesRightIdle;
    private static Animation                       walkAnimationUp;          // #3
    private static Animation                       walkAnimationUpIdle;          // #3
    private static Animation                       walkAnimationDown;          // #3
    private static Animation                       walkAnimationDownIdle;          // #3
    private static Animation                       walkAnimationLeft;          // #3
    private static Animation                       walkAnimationLeftIdle;          // #3
    private static Animation                       walkAnimationRight;          // #3
    private static Animation                       walkAnimationRightIdle;
    
    
    
    
    
    

	private static TextureRegion[]                 hairFramesUp;             // #5
    private static TextureRegion[]                 hairFramesUpIdle;             // #5
    private static TextureRegion[]                 hairFramesDown;             // #5
    private static TextureRegion[]                 hairFramesDownIdle;             // #5
    private static TextureRegion[]                 hairFramesLeft;             // #5
    private static TextureRegion[]                 hairFramesLeftIdle;             // #5
    private static TextureRegion[]                 hairFramesRight;
    private static TextureRegion[]                 hairFramesRightIdle;
    private static Animation                       hairAnimationUp;          // #3
    private static Animation                       hairAnimationUpIdle;          // #3
    private static Animation                       hairAnimationDown;          // #3
    private static Animation                       hairAnimationDownIdle;          // #3
    private static Animation                       hairAnimationLeft;          // #3
    private static Animation                       hairAnimationLeftIdle;          // #3
    private static Animation                       hairAnimationRight;          // #3
    private static Animation                       hairAnimationRightIdle;
	
    private static TextureRegion[]                 clothesFramesUp;             // #5
    private static TextureRegion[]                 clothesFramesUpIdle;             // #5
    private static TextureRegion[]                 clothesFramesDown;             // #5
    private static TextureRegion[]                 clothesFramesDownIdle;             // #5
    private static TextureRegion[]                 clothesFramesLeft;             // #5
    private static TextureRegion[]                 clothesFramesLeftIdle;             // #5
    private static TextureRegion[]                 clothesFramesRight;
    private static TextureRegion[]                 clothesFramesRightIdle;
    private static Animation                       clothesAnimationUp;          // #3
    private static Animation                       clothesAnimationUpIdle;          // #3
    private static Animation                       clothesAnimationDown;          // #3
    private static Animation                       clothesAnimationDownIdle;          // #3
    private static Animation                       clothesAnimationLeft;          // #3
    private static Animation                       clothesAnimationLeftIdle;          // #3
    private static Animation                       clothesAnimationRight;          // #3
    private static Animation                       clothesAnimationRightIdle;
    
    
    
    
    
    
    
    // #3
    private static Texture walkSheet;
    private static Texture walkSheetM = new Texture(Gdx.files.internal("newSprite.png")); // #9
    private static Texture walkSheetF = new Texture(Gdx.files.internal("newSpriteF.png")); // #9
    private static Texture walkSheetCM = new Texture(Gdx.files.internal("coontahSpriteM.png")); // #9
    private static Texture walkSheetCF = new Texture(Gdx.files.internal("coontahSpriteF.png")); // #9
    private static Texture hairSheet;
    private static Texture hairSheet1= new Texture(Gdx.files.internal("HairSprite.png")); // #9
    private static Texture hairSheet2 = new Texture(Gdx.files.internal("HairSprite2.png")); // #9
    private static Texture femaleHairSheet1 = new Texture(Gdx.files.internal("femaleHair1.png")); // #9
    private static Texture femaleHairSheet2 = new Texture(Gdx.files.internal("femaleHair2.png")); // #9
    private static Texture clothesSheet;
    private static Texture clothesSheet1= new Texture(Gdx.files.internal("Naked.png")); // #9
    private static Texture clothesSheet2 = new Texture(Gdx.files.internal("Robes1.png")); // #9
    private static Texture clothesSheet3 = new Texture(Gdx.files.internal("femaleClothing.png")); // #9
    private Animation[] SpriteUp = {null, null, null};
    private Animation[] SpriteUpIdle = {null, null, null};
    private Animation[] SpriteDown = {null, null, null};
    private Animation[] SpriteDownIdle = {null, null, null};
    private Animation[] SpriteLeft = {null, null, null};
    private Animation[] SpriteLeftIdle = {null, null, null};
    private Animation[] SpriteRight = {null, null, null};
    private Animation[] SpriteRightIdle = {null, null, null};
    
    public void setSprite(int HairStyle, int Gender, int Clothes, int Race)
    {
    	if(HairStyle == 1 && Gender == 1 && Race == 1)
    		hairSheet = hairSheet1;
    	if(HairStyle == 2 && Gender == 1 && Race == 1)
    		hairSheet = hairSheet2;
    	if(HairStyle == 1 && Gender == 2 && Race == 1)
    		hairSheet = femaleHairSheet1;
    	if(HairStyle == 2 && Gender == 2 && Race == 1)
    		hairSheet = femaleHairSheet2;
    	if(Race == 2)
    		hairSheet = clothesSheet1;

    	if(Gender == 1 && Race == 1)
    		walkSheet = walkSheetM;
    	if(Gender == 2 && Race == 1)
    		walkSheet = walkSheetF;
    	if(Gender == 1 && Race == 2)
    		walkSheet = walkSheetCM;
    	if(Gender == 2 && Race == 2)
    		walkSheet = walkSheetCF;
    	if(Clothes == 1)
    		clothesSheet = clothesSheet1;
    	if(Clothes == 2)
    		clothesSheet = clothesSheet2;
    	if(Clothes == 3)
    		clothesSheet = clothesSheet3;
    	
    	
    	
    	TextureRegion[][] tmp2 = TextureRegion.split(hairSheet, hairSheet.getWidth()/FRAME_COLS, hairSheet.getHeight()/FRAME_ROWS);              // #10
    	TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth()/FRAME_COLS, walkSheet.getHeight()/FRAME_ROWS);             // #10
    	TextureRegion[][] tmp3 = TextureRegion.split(clothesSheet, clothesSheet.getWidth()/FRAME_COLS, clothesSheet.getHeight()/FRAME_ROWS);
    	
    	
    	
    	walkFramesRight = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        walkFramesRightIdle = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        walkFramesLeft = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        walkFramesLeftIdle = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        walkFramesUp = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        walkFramesUpIdle = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        walkFramesDown = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        walkFramesDownIdle = new TextureRegion[FRAME_COLS * FRAME_ROWS]; 

        

        hairFramesRight = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        hairFramesRightIdle = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        hairFramesLeft = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        hairFramesLeftIdle = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        hairFramesUp = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        hairFramesUpIdle = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        hairFramesDown = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        hairFramesDownIdle = new TextureRegion[FRAME_COLS * FRAME_ROWS]; 
        
        

        clothesFramesRight = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        clothesFramesRightIdle = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        clothesFramesLeft = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        clothesFramesLeftIdle = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        clothesFramesUp = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        clothesFramesUpIdle = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        clothesFramesDown = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        clothesFramesDownIdle = new TextureRegion[FRAME_COLS * FRAME_ROWS]; 
       
        
        
        
        
        
        
        
        
        
    	int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                walkFramesRight[index++] = tmp[2][j];
                index--;
                walkFramesRightIdle[index++] = tmp[2][1];
                index--;
                walkFramesLeft[index++] = tmp[1][j];
                index--;
                walkFramesLeftIdle[index++] = tmp[1][1];
                index--;
                walkFramesUp[index++] = tmp[3][j];
                index--;
                walkFramesUpIdle[index++] = tmp[3][1];
                index--;
                walkFramesDown[index++] = tmp[0][j];
                index--;
                walkFramesDownIdle[index++] = tmp[0][1];
                index--;
            	hairFramesRight[index++] = tmp2[2][j];
                index--;
            	hairFramesRightIdle[index++] = tmp2[2][1];
                index--;
            	hairFramesLeft[index++] = tmp2[1][j];
                index--;
            	hairFramesLeftIdle[index++] = tmp2[1][1];
                index--;
            	hairFramesUp[index++] = tmp2[3][j];
                index--;
            	hairFramesUpIdle[index++] = tmp2[3][1];
                index--;
            	hairFramesDown[index++] = tmp2[0][j];
                index--;
                hairFramesDownIdle[index++] = tmp2[0][1];
                index--;
                clothesFramesRight[index++] = tmp3[2][j];
                index--;
                clothesFramesRightIdle[index++] = tmp3[2][1];
                index--;
                clothesFramesLeft[index++] = tmp3[1][j];
                index--;
                clothesFramesLeftIdle[index++] = tmp3[1][1];
                index--;
                clothesFramesUp[index++] = tmp3[3][j];
                index--;
                clothesFramesUpIdle[index++] = tmp3[3][1];
                index--;
                clothesFramesDown[index++] = tmp3[0][j];
                index--;
                clothesFramesDownIdle[index++] = tmp3[0][1];
            }
        }
        

        walkAnimationRight = new Animation(0.2f, walkFramesRight);      // #11
        walkAnimationRightIdle = new Animation(0.2f, walkFramesRightIdle);      // #11
        walkAnimationLeft = new Animation(0.2f, walkFramesLeft);      // #11
        walkAnimationLeftIdle = new Animation(0.2f, walkFramesLeftIdle);      // #11
        walkAnimationUp = new Animation(0.2f, walkFramesUp);      // #11
        walkAnimationUpIdle = new Animation(0.2f, walkFramesUpIdle);      // #11
        walkAnimationDown = new Animation(0.2f, walkFramesDown);      // #11
        walkAnimationDownIdle = new Animation(0.2f, walkFramesDownIdle);      // #11


        hairAnimationRight = new Animation(0.2f, hairFramesRight);      // #11
        hairAnimationRightIdle = new Animation(0.2f, hairFramesRightIdle);      // #11
        hairAnimationLeft = new Animation(0.2f, hairFramesLeft);      // #11
        hairAnimationLeftIdle = new Animation(0.2f, hairFramesLeftIdle);      // #11
        hairAnimationUp = new Animation(0.2f, hairFramesUp);      // #11
        hairAnimationUpIdle = new Animation(0.2f, hairFramesUpIdle);      // #11
        hairAnimationDown = new Animation(0.2f, hairFramesDown);      // #11
        hairAnimationDownIdle = new Animation(0.2f, hairFramesDownIdle);      // #11

    

        clothesAnimationRight = new Animation(0.2f, clothesFramesRight);      // #11
        clothesAnimationRightIdle = new Animation(0.2f, clothesFramesRightIdle);      // #11
        clothesAnimationLeft = new Animation(0.2f, clothesFramesLeft);      // #11
        clothesAnimationLeftIdle = new Animation(0.2f, clothesFramesLeftIdle);      // #11
        clothesAnimationUp = new Animation(0.2f, clothesFramesUp);      // #11
        clothesAnimationUpIdle = new Animation(0.2f, clothesFramesUpIdle);      // #11
        clothesAnimationDown = new Animation(0.2f, clothesFramesDown);      // #11
        clothesAnimationDownIdle = new Animation(0.2f, clothesFramesDownIdle);      // #11

    

        SpriteUp[0] = walkAnimationUp;
        SpriteUp[1] = hairAnimationUp;
        SpriteUp[2] = clothesAnimationUp;

        SpriteUpIdle[0] = walkAnimationUpIdle;
        SpriteUpIdle[1] = hairAnimationUpIdle;
        SpriteUpIdle[2] = clothesAnimationUpIdle;

        SpriteDown[0] = walkAnimationDown;
        SpriteDown[1] = hairAnimationDown;
        SpriteDown[2] = clothesAnimationDown;

        SpriteDownIdle[0] = walkAnimationDownIdle;
        SpriteDownIdle[1] = hairAnimationDownIdle;
        SpriteDownIdle[2] = clothesAnimationDownIdle;

        SpriteLeft[0] = walkAnimationLeft;
        SpriteLeft[1] = hairAnimationLeft;
        SpriteLeft[2] = clothesAnimationLeft;

        SpriteLeftIdle[0] = walkAnimationLeftIdle;
        SpriteLeftIdle[1] = hairAnimationLeftIdle;
        SpriteLeftIdle[2] = clothesAnimationLeftIdle;

        SpriteRight[0] = walkAnimationRight;
        SpriteRight[1] = hairAnimationRight;
        SpriteRight[2] = clothesAnimationRight;

        SpriteRightIdle[0] = walkAnimationRightIdle;
        SpriteRightIdle[1] = hairAnimationRightIdle;
        SpriteRightIdle[2] = clothesAnimationRightIdle;
    
    
    
    
    
    
    
    
    
    
    }
    public Animation[] getSprite(int Direction, boolean isMoving)
	{
        if(Direction == 0 && isMoving == true)
			return SpriteRight;

        if(Direction == 0 && isMoving == false)
			return SpriteRightIdle;

        if(Direction == 1 && isMoving == true)
			return SpriteLeft;
        
        if(Direction == 1 && isMoving == false)
			return SpriteLeftIdle;

        if(Direction == 2 && isMoving == true)
			return SpriteUp;

        if(Direction == 2 && isMoving == false)
			return SpriteUpIdle;

        if(Direction == 3 && isMoving == true)
			return SpriteDown;

        if(Direction == 3 && isMoving == false)
			return SpriteDownIdle;

        return SpriteDownIdle;
        
	}
    public void dispose()
    {
	 walkSheet.dispose();
	 
    }
}
