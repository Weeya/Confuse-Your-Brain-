package com.mygdx.game;

import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class BrainGame extends Game{
	
	public SpriteBatch batch;
	ShapeRenderer shape;
	BitmapFont font;
	
	List<Color> listcolor;
	Random rand;
	int tmpposlist;
	Color tmpcolor1;
	Color tmpcolor2;
	Color tmpcolor3;
	Color tmpcolor4;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new GameScreen(this));
		shape = new ShapeRenderer();
		font = new BitmapFont();
		font.getData().setScale(3);
		font.setColor(0, 0, 0, 1);
		
		//code of dondon
		rand  = new Random();
		listcolor = new ArrayList();
		listcolor.add(Color.SALMON);
		listcolor.add(Color.LIME);
		listcolor.add(Color.CORAL);
		listcolor.add(Color.VIOLET);
		randcolor();
		
		
		//font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
	}
	public void randcolor() {
		tmpposlist = rand.nextInt(listcolor.size());
		tmpcolor1 = listcolor.get(tmpposlist);
		listcolor.remove(tmpposlist);
		tmpposlist = rand.nextInt(listcolor.size());
		tmpcolor2 = listcolor.get(tmpposlist);
		listcolor.remove(tmpposlist);
		tmpposlist = rand.nextInt(listcolor.size());
		tmpcolor3 = listcolor.get(tmpposlist);
		listcolor.remove(tmpposlist);
		tmpposlist = rand.nextInt(listcolor.size());
		tmpcolor4 = listcolor.get(tmpposlist);
		listcolor.remove(tmpposlist);
		listcolor.add(Color.SALMON);
		listcolor.add(Color.LIME);
		listcolor.add(Color.CORAL);
		listcolor.add(Color.VIOLET);
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
		
	//	if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
		if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
			randcolor();
		}

			shape.begin(ShapeType.Filled);
			shape.setColor(tmpcolor1);
			shape.rect(160, 250, 130, 130);
			shape.setColor(tmpcolor2);
			shape.rect(320, 250, 130, 130);
			shape.setColor(tmpcolor3);
			shape.rect(160, 420, 130, 130);
			shape.setColor(tmpcolor4);
			shape.rect(320, 420, 130, 130);
			shape.end();
			
	//	}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
	}
	
	public void update(float delta) {
		
	}
}
