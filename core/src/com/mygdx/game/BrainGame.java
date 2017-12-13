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
import com.badlogic.gdx.utils.Array;

public class BrainGame extends Game{
	
	public SpriteBatch batch;
	ShapeRenderer shape;
	BitmapFont font;
	
	Color[] listcolor;
	Color[] printColor;
	String[] colorName;
	String[] printName;
	
	String name;
	Random rand;
	int tmpposlist;
	int tmp;
	int status;
	Color tmpcolor1;
	Color tmpcolor2;
	Color tmpcolor3;
	Color tmpcolor4;
	Color tmpcolor5;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new GameScreen(this));
		shape = new ShapeRenderer();
		status = 0;
		font = new BitmapFont();
		font.getData().setScale(2);
		font.setColor(1, 1, 1, 1);

		font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		//code of dondon
		rand  = new Random();
		listcolor = new Color[6];
		colorName = new String[6];
		printName = new String[6];
		printColor = new Color[6];
		
		listcolor[0]= Color.SALMON;
		colorName[0] = "salmon";
		listcolor[1] = Color.LIME;
		colorName[1] = "lime";
		listcolor[2] = Color.PINK;
		colorName[2] = "pink";
		listcolor[3] = Color.NAVY;
		colorName[3] = "navy";
		listcolor[4] = Color.ORANGE;
		colorName[4] = "orange";
		//listcolor.add(Color.SCARLET);
		//listcolor.add(Color.ORANGE);
		randcolor();
		
		
		
	}
	public void randcolor() {
		tmpposlist = rand.nextInt(listcolor.length-1);
		printColor[0] = listcolor[tmpposlist];
		name = colorName[tmpposlist]; 
		printName[0] = name; 
		listcolor[tmpposlist] = Color.BLACK;
		
		tmpposlist = rand.nextInt(listcolor.length-1);
		while(listcolor[tmpposlist] == Color.BLACK) {
			tmpposlist = rand.nextInt(listcolor.length-1);
		}
		printColor[1] = listcolor[tmpposlist];
		name = colorName[tmpposlist];
		printName[1] = name;
		listcolor[tmpposlist] = Color.BLACK;
		
		tmpposlist = rand.nextInt(listcolor.length-1);
		while(listcolor[tmpposlist] == Color.BLACK) {
			tmpposlist = rand.nextInt(listcolor.length-1);
		}
		printColor[2] = listcolor[tmpposlist];
		name = colorName[tmpposlist];
		printName[2] = name;
		listcolor[tmpposlist] = Color.BLACK;
		
		tmpposlist = rand.nextInt(listcolor.length-1);
		while(listcolor[tmpposlist] == Color.BLACK) {
			tmpposlist = rand.nextInt(listcolor.length-1);
		}
		printColor[3] = listcolor[tmpposlist];
		name = colorName[tmpposlist];
		printName[3] = name;
		
		listcolor[0]= Color.SALMON;
		//colorName[0] = "salmon";
		listcolor[1] = Color.LIME;
		//colorName[1] = "lime";
		listcolor[2] = Color.PINK;
		//colorName[2] = "pink";
		listcolor[3] = Color.NAVY;
		//colorName[3] = "navy";
		listcolor[4] = Color.ORANGE;
		//colorName[4] = "orange";
	}
	
	public void render () {
		
		Gdx.gl.glClearColor(1,1,1,1); //55/255f, 188/255f, 155/255f
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	
		shape.begin(ShapeType.Filled);
		shape.setColor(printColor[0]);
		shape.rect(160, 250, 130, 130); // posX1 = 160, posY1 = 250
		shape.setColor(printColor[1]);
		shape.rect(320, 250, 130, 130); // posX2 = 320, posY2 = 250
		shape.setColor(printColor[2]);
		shape.rect(160, 420, 130, 130); // posX3 = 160, posY1 = 420
		shape.setColor(printColor[3]);
		shape.rect(320, 420, 130, 130); // posX4 = 320, posY1 = 420
		shape.end();
			
	//	}
		batch.begin();
		
		font.draw(batch, printName[0], 180, 320);
		font.draw(batch, printName[1], 340, 320);
		font.draw(batch, printName[2], 180, 500);
		font.draw(batch, printName[3], 340, 500);
		font.draw(batch, "Time 00:00:00", 380, 750);
		
		
		batch.end();
		
		if(Gdx.input.getX() > 160 && Gdx.input.getX() < 290 && Gdx.input.getY() < 380 && Gdx.input.getY() > 250) {
			if(Gdx.input.isTouched()&&status == 0) {
				status=1;
				randcolor();
			}
		}
		else if(Gdx.input.getX() > 320 && Gdx.input.getX() < 450 && Gdx.input.getY() < 380 && Gdx.input.getY() > 250) {
			if(Gdx.input.isTouched()&&status == 0) {
				status=1;
				randcolor();
			}
		}
		else if(Gdx.input.getX() > 160 && Gdx.input.getX() < 290 && Gdx.input.getY() < 550 && Gdx.input.getY() > 420) {
			if(Gdx.input.isTouched()&&status == 0) {
				status=1;
				randcolor();
			}
		}
		else if(Gdx.input.getX() > 320 && Gdx.input.getX() < 450 && Gdx.input.getY() < 550 && Gdx.input.getY() > 420) {
			if(Gdx.input.isTouched()&&status == 0) {
				status=1;
				randcolor();
			}
		}
		if(!Gdx.input.isTouched()) {
			status = 0;
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
	}
	
}
