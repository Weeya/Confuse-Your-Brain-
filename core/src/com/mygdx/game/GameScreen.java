package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {
	private BrainGame brainGame;
	
	public void render(float delta) {
		SpriteBatch batch = brainGame.batch;
		 
			
	}
	public GameScreen(BrainGame brainGame) {
        this.brainGame = brainGame;
    }

}
