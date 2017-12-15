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
	
	Color[] listcolor,printColor;
	String[] colorName,printName;
	
	String name;
	Random rand;
	int tmpposlist, pos, status, alreadyChecked,newColorName;
	
	@Override
	public void create () {
		 
		batch = new SpriteBatch();
		setScreen(new GameScreen(this));
		shape = new ShapeRenderer();
		font = new BitmapFont();
		font.getData().setScale(2);
		font.setColor(1, 1, 1, 1);
		font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		status = 0;
		alreadyChecked = 0;
		rand  = new Random(); 
		listcolor = new Color[9];
		colorName = new String[9];
		printName = new String[9];
		printColor = new Color[9];
		
		listcolor[0]= Color.YELLOW;
		colorName[0] = "Yellow";
		listcolor[1] = Color.PURPLE;
		colorName[1] = "Purple"; 
		listcolor[2] = Color.PINK; 
		colorName[2] = "  Pink";
		listcolor[3] = Color.ROYAL;
		colorName[3] = "  Blue";
		listcolor[4] = Color.ORANGE;
		colorName[4] = "Orange";
		listcolor[5] = Color.LIME; 
		colorName[5] = "Green"; 
		listcolor[6] = Color.SCARLET; 
		colorName[6] = "  Red";
		listcolor[7] = Color.BLACK;
		colorName[7] = "Black";
		colorName[8] = "White";
		randcolor();
				
	}
	public void randcolor() {  
		
		colorPrintFunc(0,listcolor);
		colorPrintFunc(1,listcolor);
		colorPrintFunc(2,listcolor); 
		colorPrintFunc(3,listcolor);
		
		listcolor[0]= Color.YELLOW;  
		listcolor[1] = Color.PURPLE;
		listcolor[2] = Color.PINK;
		listcolor[3] = Color.ROYAL;
		listcolor[4] = Color.ORANGE;
		listcolor[5] = Color.LIME; 
		listcolor[6] = Color.SCARLET;
		listcolor[7] = Color.BLACK;

		pos = rand.nextInt(4); //False position
	}
	
	public void colorPrintFunc (int order,Color[] listcolor) {
		
		tmpposlist = rand.nextInt(listcolor.length-1);
		while(listcolor[tmpposlist] == Color.WHITE) {
			tmpposlist = rand.nextInt(listcolor.length-1);
		}
		printColor[order] = listcolor[tmpposlist];
		name = colorName[tmpposlist];
		printName[order] = name;
		listcolor[tmpposlist] = Color.WHITE;
	}
	public void render () {
		
		Gdx.gl.glClearColor(1,1,1,1); 
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
		batch.begin();
		
		textPrintFunc(0,180,320,pos);
		textPrintFunc(1,340,320,pos);
		textPrintFunc(2,180,500,pos);
		textPrintFunc(3,340,500,pos);
		font.draw(batch, "Time 00:00:00", 380, 750);
		
		
		batch.end();
		
		if(Gdx.input.getX() > 160 && Gdx.input.getX() < 290 && Gdx.input.getY() < 380 && Gdx.input.getY() > 250) {
			if(Gdx.input.isTouched()&&status == 0) {
				status=1;
				randcolor();
				alreadyChecked = 0;
			}
		}
		else if(Gdx.input.getX() > 320 && Gdx.input.getX() < 450 && Gdx.input.getY() < 380 && Gdx.input.getY() > 250) {
			if(Gdx.input.isTouched()&&status == 0) {
				status=1; 
				randcolor(); 
				alreadyChecked = 0;
			}  
		} 
		else if(Gdx.input.getX() > 160 && Gdx.input.getX() < 290 && Gdx.input.getY() < 550 && Gdx.input.getY() > 420) {
			if(Gdx.input.isTouched()&&status == 0) {
				status=1;
				randcolor();
				alreadyChecked = 0;
			}
		}
		else if(Gdx.input.getX() > 320 && Gdx.input.getX() < 450 && Gdx.input.getY() < 550 && Gdx.input.getY() > 420) {
			if(Gdx.input.isTouched()&&status == 0) { 
				status=1;
				randcolor(); 
				alreadyChecked = 0; 
			} 
		}
		if(!Gdx.input.isTouched()) {
			status = 0;  
		}  
	}  
	 
	public void textPrintFunc(int order, int x, int y, int position) {
		if(order != position) { 
			font.draw(batch, printName[order], x, y); 
			//System.out.println("..");
		} 
		else { // order == position
			if(alreadyChecked==1) {
				font.draw(batch, printName[newColorName], x, y);
			}
			else { 
				newColorName = falseColorName(order,position);
				font.draw(batch, printName[newColorName], x, y);
				alreadyChecked = 1;
			}
			System.out.println("False " + order);
		} 
	}
	
	public int falseColorName(int order,int position) {
		order = rand.nextInt(4);
		while(order == position) {
			order = rand.nextInt(4);
		} 
			
		return order;
	}
	@Override
	public void dispose () {
		batch.dispose(); 
		font.dispose();
	}
	
}
