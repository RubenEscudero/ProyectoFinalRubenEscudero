package screens;

import base.BaseActor;
import base.BaseScreen;
import game.MyGame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputEvent.Type;

import com.badlogic.gdx.audio.Music;

/**
 * Class to select the level who players want player
 * @author ruben
 * @since 22/04/2020
 */
public class LevelScreen  extends BaseScreen{
	private boolean changeColorButtonState;
	private Button level1Button;
	private Button level2Button;
	private Button level3Button;
	private Button level4Button;
	private Button level5Button;
	private Button returnButton;
	private ButtonStyle buttonStyleLevel11;
	private ButtonStyle buttonStyleLevel12;
	private ButtonStyle buttonStyleLevel21;
	private ButtonStyle buttonStyleLevel22;
	private ButtonStyle buttonStyleLevel31;
	private ButtonStyle buttonStyleLevel32;
	private ButtonStyle buttonStyleLevel41;
	private ButtonStyle buttonStyleLevel42;
	private ButtonStyle buttonStyleLevel51;
	private ButtonStyle buttonStyleLevel52;
	private ButtonStyle buttonStyleReturn1;
	private ButtonStyle buttonStyleReturn2;
	private long changeColorButton;
	private Music music;
	private float musicVolume;
	private Properties properties;
	private String[] basePlayers;

	/**
	 * Initializes and loads the elements to be used
	 */
	@Override
	public void initialize() {
		changeColorButton = System.currentTimeMillis();
		
		BaseActor background = new BaseActor(0, 0, mainStage);
		background.loadTexture("assets/backgrounds/retroShip.jpg");
		background.setSize(514, 700);
		
		initButtons();
		
		properties = new Properties();
		basePlayers = new String[5];
		try {
			properties.load(new FileInputStream("datos.conf"));
			musicVolume = Float.parseFloat(properties.getProperty("music"));
			for(int i = 0; i < 5; i++) {
				basePlayers[i] = properties.getProperty("player" + i);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		music = Gdx.audio.newMusic(Gdx.files.internal("assets/music/Heartbreak3.mp3"));
		music.setLooping(true);
        music.setVolume(musicVolume);
        music.play();
	}
	
	/**
	 * Update what happens in the game
	 */
	@Override
	public void update(float dt) {
		changeButton();
	}
	
	/**
	 * Load buttonStyles and Buttons
	 */

	private void initButtons() {
		buttonStyleLevel11 = new ButtonStyle();
		
		Texture buttonTex = new Texture(Gdx.files.internal("assets/buttons/buttonLevel1-1.png"));
		TextureRegion buttonRegion = new TextureRegion(buttonTex);
		buttonStyleLevel11.up = new TextureRegionDrawable(buttonRegion);
		
		buttonStyleLevel12 = new ButtonStyle();
		
		Texture buttonTex2 = new Texture(Gdx.files.internal("assets/buttons/buttonLevel1-2.png"));
		TextureRegion buttonRegion2 = new TextureRegion(buttonTex2);
		buttonStyleLevel12.up = new TextureRegionDrawable(buttonRegion2);
		
		buttonStyleLevel21 = new ButtonStyle();
		
		Texture buttonTex21 = new Texture(Gdx.files.internal("assets/buttons/buttonLevel2-1.png"));
		TextureRegion buttonRegion21 = new TextureRegion(buttonTex21);
		buttonStyleLevel21.up = new TextureRegionDrawable(buttonRegion21);
		
		buttonStyleLevel22 = new ButtonStyle();
		
		Texture buttonTex22 = new Texture(Gdx.files.internal("assets/buttons/buttonLevel2-2.png"));
		TextureRegion buttonRegion22 = new TextureRegion(buttonTex22);
		buttonStyleLevel22.up = new TextureRegionDrawable(buttonRegion22);
		
		buttonStyleLevel31 = new ButtonStyle();
		
		Texture buttonTex31 = new Texture(Gdx.files.internal("assets/buttons/buttonLevel3-1.png"));
		TextureRegion buttonRegion31 = new TextureRegion(buttonTex31);
		buttonStyleLevel31.up = new TextureRegionDrawable(buttonRegion31);
		
		buttonStyleLevel32 = new ButtonStyle();
		
		Texture buttonTex32 = new Texture(Gdx.files.internal("assets/buttons/buttonLevel3-2.png"));
		TextureRegion buttonRegion32 = new TextureRegion(buttonTex32);
		buttonStyleLevel32.up = new TextureRegionDrawable(buttonRegion32);
		
		buttonStyleLevel41 = new ButtonStyle();
		
		Texture buttonTex41 = new Texture(Gdx.files.internal("assets/buttons/buttonLevel4-1.png"));
		TextureRegion buttonRegion41 = new TextureRegion(buttonTex41);
		buttonStyleLevel41.up = new TextureRegionDrawable(buttonRegion41);
		
		buttonStyleLevel42 = new ButtonStyle();
		
		Texture buttonTex42 = new Texture(Gdx.files.internal("assets/buttons/buttonLevel4-2.png"));
		TextureRegion buttonRegion42 = new TextureRegion(buttonTex42);
		buttonStyleLevel42.up = new TextureRegionDrawable(buttonRegion42);
		
		buttonStyleLevel51 = new ButtonStyle();
		
		Texture buttonTex51 = new Texture(Gdx.files.internal("assets/buttons/buttonLevel5-1.png"));
		TextureRegion buttonRegion51 = new TextureRegion(buttonTex51);
		buttonStyleLevel51.up = new TextureRegionDrawable(buttonRegion51);
		
		buttonStyleLevel52 = new ButtonStyle();
		
		Texture buttonTex52 = new Texture(Gdx.files.internal("assets/buttons/buttonLevel5-2.png"));
		TextureRegion buttonRegion52 = new TextureRegion(buttonTex52);
		buttonStyleLevel52.up = new TextureRegionDrawable(buttonRegion52);
		
		buttonStyleReturn1 = new ButtonStyle();
		
		Texture buttonTexReturn1 = new Texture(Gdx.files.internal("assets/buttons/buttonReturn1.png"));
		TextureRegion buttonRegionReturn1 = new TextureRegion(buttonTexReturn1);
		buttonStyleReturn1.up = new TextureRegionDrawable(buttonRegionReturn1);
		
		buttonStyleReturn2 = new ButtonStyle();
		
		Texture buttonTexReturn2 = new Texture(Gdx.files.internal("assets/buttons/buttonReturn2.png"));
		TextureRegion buttonRegionReturn2 = new TextureRegion(buttonTexReturn2);
		buttonStyleReturn2.up = new TextureRegionDrawable(buttonRegionReturn2);
		
		level1Button = new Button(buttonStyleLevel11);
		level1Button.setPosition(170, 520);
		uiStage.addActor(level1Button);
		
		level1Button.addListener(
				(Event e) -> {
					if ( !(e instanceof InputEvent) ||
							!((InputEvent)e).getType().equals(Type.touchDown) )
							return false;
							music.stop();
							MyGame.setActiveScreen( new Level1Screen() );
							return false;
				}
		);
		
		level2Button = new Button(buttonStyleLevel21);
		level2Button.setPosition(170, 420);
		uiStage.addActor(level2Button);
		
		level2Button.addListener(
				(Event e) -> {
					if ( !(e instanceof InputEvent) ||
							!((InputEvent)e).getType().equals(Type.touchDown) )
							return false;
							music.stop();
							MyGame.setActiveScreen( new Level2Screen() );
							return false;
				}
		);
		
		level3Button = new Button(buttonStyleLevel31);
		level3Button.setPosition(170, 320);
		uiStage.addActor(level3Button);
		
		level3Button.addListener(
				(Event e) -> {
					if ( !(e instanceof InputEvent) ||
							!((InputEvent)e).getType().equals(Type.touchDown) )
							return false;
							music.stop();
							MyGame.setActiveScreen( new Level3Screen() );
							return false;
				}
		);
		
		level4Button = new Button(buttonStyleLevel41);
		level4Button.setPosition(170, 220);
		uiStage.addActor(level4Button);
		
		level4Button.addListener(
				(Event e) -> {
					if ( !(e instanceof InputEvent) ||
							!((InputEvent)e).getType().equals(Type.touchDown) )
							return false;
							music.stop();
							MyGame.setActiveScreen( new Level4Screen() );
							return false;
				}
		);
		
		level5Button = new Button(buttonStyleLevel51);
		level5Button.setPosition(170, 120);
		uiStage.addActor(level5Button);
		
		level5Button.addListener(
				(Event e) -> {
					if ( !(e instanceof InputEvent) ||
							!((InputEvent)e).getType().equals(Type.touchDown) )
							return false;
							music.stop();
							MyGame.setActiveScreen( new Level5Screen() );
							return false;
				}
		);
		
		returnButton = new Button(buttonStyleReturn2);
		returnButton.setPosition(15, 640);
		uiStage.addActor(returnButton);
		
		returnButton.addListener(
				(Event e) -> {
					if ( !(e instanceof InputEvent) ||
							!((InputEvent)e).getType().equals(Type.touchDown) )
							return false;
							music.stop();
							sortPlayers();
							MyGame.setActiveScreen( new MenuScreen() );
							return false;
				}
		);
		
	}
	
	/**
	 * Sort the player
	 */
	private void sortPlayers() {
		String temporal = "";
	 	String[] basePlayers2 = new String[5];
	 	for(int i = 0; i < 5; i++){
			basePlayers2[i] = properties.getProperty("player" + i);
		}
	    for (int x = 0; x < basePlayers2.length ; x++) {
	        for (int j = 0; j < basePlayers2.length - x - 1; j++) {
	            if (Integer.parseInt(basePlayers2[j].split("-")[1]) + Integer.parseInt(basePlayers2[j].split("-")[2])
	            		+ Integer.parseInt(basePlayers2[j].split("-")[3]) + Integer.parseInt(basePlayers2[j].split("-")[4])
	            		+ Integer.parseInt(basePlayers2[j].split("-")[5]) > Integer.parseInt(basePlayers2[j + 1].split("-")[1]) + Integer.parseInt(basePlayers2[j + 1].split("-")[2])
	            		+ Integer.parseInt(basePlayers2[j + 1].split("-")[3]) + Integer.parseInt(basePlayers2[j + 1].split("-")[4])
	            		+ Integer.parseInt(basePlayers2[j + 1].split("-")[5])) {
	                temporal = basePlayers2[j];
	                basePlayers2[j] = basePlayers2[j + 1];
	                basePlayers2[j + 1] = temporal;
	            }
	        }
	    }
	    if(Integer.parseInt(basePlayers2[0].split("-")[1]) + Integer.parseInt(basePlayers2[0].split("-")[2]) + Integer.parseInt(basePlayers2[0].split("-")[3]) 
	    		+ Integer.parseInt(basePlayers2[0].split("-")[4]) + Integer.parseInt(basePlayers2[0].split("-")[5]) > 
	    Integer.parseInt(properties.getProperty("actualpoints1")) + Integer.parseInt(properties.getProperty("actualpoints2")) 
	    + Integer.parseInt(properties.getProperty("actualpoints3")) + Integer.parseInt(properties.getProperty("actualpoints4")) 
	    + Integer.parseInt(properties.getProperty("actualpoints5"))) {
	    	
	    }
	    else {
	    	basePlayers2[0] = properties.getProperty("actualname") + "-" + properties.getProperty("actualpoints1") + "-" + properties.getProperty("actualpoints2")
	    	+ "-" + properties.getProperty("actualpoints3") + "-" + properties.getProperty("actualpoints4") + "-" + properties.getProperty("actualpoints5");
	    }
	    
		for(int i = 0; i < 5; i++){
			System.out.println("Jugadores guardados" + basePlayers2[i]);
			properties.setProperty("player" + i, basePlayers2[i]);
		}
		try {
			properties.store(new FileOutputStream("datos.conf"), "Fichero de datos");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/**
	 * Method to change the style of the buttons
	 */
	private void changeButton() {
		long time = System.currentTimeMillis();
		if(changeColorButton - time < -500){
			changeColorButton = time;
			if(changeColorButtonState) {
				level1Button.setStyle(buttonStyleLevel11);
				level2Button.setStyle(buttonStyleLevel21);
				level3Button.setStyle(buttonStyleLevel31);
				level4Button.setStyle(buttonStyleLevel41);
				level5Button.setStyle(buttonStyleLevel51);
				returnButton.setStyle(buttonStyleReturn2);
				changeColorButtonState = false;
			}
			else {
				level1Button.setStyle(buttonStyleLevel12);
				level2Button.setStyle(buttonStyleLevel22);
				level3Button.setStyle(buttonStyleLevel32);
				level4Button.setStyle(buttonStyleLevel42);
				level5Button.setStyle(buttonStyleLevel52);
				returnButton.setStyle(buttonStyleReturn1);
				changeColorButtonState = true;
			}
			
		}
	}
	
}
