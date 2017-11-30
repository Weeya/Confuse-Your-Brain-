package com.mygdx.game;

import java.awt.Shape;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class BrainGame extends Game{
	private RectRenderer rectRenderer;
	private Texture texture;
	public SpriteBatch batch;
	private ShapeRenderer shapeRenderer;
	ShapeRenderer shape;
	BitmapFont font;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new GameScreen(this));
		shape = new ShapeRenderer();
		
		font = new BitmapFont();
		font.getData().setScale(3);
		font.setColor(0, 0, 0, 1);
		//font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
	}
	
	public void render () {
		
		Gdx.gl.glClearColor(1,1,1,1); //55/255f, 188/255f, 155/255f
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
	
		/*font.draw(batch, "Text", 160, 270);
		font.draw(batch, "Text", 320, 270);
		font.draw(batch, "Text", 160, 450);
		font.draw(batch, "Text", 320, 450);
		*/
		batch.end();
		
		shape.begin(ShapeType.Filled);
		shape.setColor(218/255f, 68/255f, 83/255f, 0);
		shape.rect(160, 250, 130, 130);
		
		shape.setColor(246/255f, 187/255f, 66/255f, 0);
		shape.rect(320, 250, 130, 130);
		
		shape.setColor(140/255f, 193/255f, 82/255f, 0);
		shape.rect(160, 420, 130, 130);
		
		shape.setColor(59/255f, 175/255f, 218/255f, 0);
		shape.rect(320, 420, 130, 130);
		
		shape.end();
		
	
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
		//shapeRenderer.dispose();
	}
}
