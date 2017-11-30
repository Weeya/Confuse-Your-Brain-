package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Text extends ApplicationAdapter {
	SpriteBatch batch;
	BitmapFont font;
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.getData().setScale(3);
		font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
	}
	
	@Override
	public void dispose() {
		batch.dispose();
		font.dispose();
	}
	
	@Override
	public void render() {
		Gdx.gl.glClearColor(1,0,0,0); //55/255f, 188/255f, 155/255f
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		font.draw(batch, "Text", 100, 100);
		
		batch.end();
	}
}
