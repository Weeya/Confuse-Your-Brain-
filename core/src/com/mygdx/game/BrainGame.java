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
	String[] colorName;
	int[] colorIndex;
	
	String name;
	Random rand;
	int x0 = 160, x1 = 320, y0 = 250, y1 = 420, rectSize = 130; 
	int tmpposlist, pos, status, alreadyChecked,newColorName,score;
	float totalTime = 10;
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
		printColor = new Color[9];
		colorIndex = new int[9];
		
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
		listcolor[7] = Color.WHITE;
		colorName[7] = "White";
		colorName[8] = "Black"; 
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
		listcolor[7] = Color.WHITE;

		pos = rand.nextInt(4); //False position
	}
	
	public void colorPrintFunc (int order,Color[] listcolor) {
		
		tmpposlist = rand.nextInt(listcolor.length-1);
		while(listcolor[tmpposlist] == Color.BLACK) {
			tmpposlist = rand.nextInt(listcolor.length-1);
		}
		printColor[order] = listcolor[tmpposlist]; //color
		colorIndex[order] = tmpposlist;
		listcolor[tmpposlist] = Color.BLACK; 
	} 
	public void render () {
		
		Gdx.gl.glClearColor(0,0,0,1); 
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); 
	
		float deltaTime = Gdx.graphics.getDeltaTime();
		totalTime -= deltaTime;
		
		int minutes = ((int)totalTime) / 60;
		int seconds = ((int)totalTime) % 60;
		
		//int x0 = 160, x1 = 320, y0 = 250, y1 = 420, rectSize = 130;
		shape.begin(ShapeType.Filled);
		shape.setColor(printColor[0]); 
		shape.rect(x0, y0, rectSize, rectSize); 
		shape.setColor(printColor[1]);
		shape.rect(x1, y0, rectSize, rectSize); 
		shape.setColor(printColor[2]);
		shape.rect(x0, y1, rectSize, rectSize);  
		shape.setColor(printColor[3]);
		shape.rect(x1, y1, rectSize, rectSize); 
		shape.end();
		batch.begin();
		  
		textPrintFunc(0,x0+20,y0+80,pos);
		textPrintFunc(1,x1+20,y0+80,pos);
		textPrintFunc(2,x0+20,y1+80,pos); 
		textPrintFunc(3,x1+20,y1+80,pos);
		font.draw(batch, "seconds " + seconds, 380, 750);
		font.draw(batch, "score  " + score, 380, 700);
		batch.end();
		
		//click 2
		if(Gdx.input.getX() > x0 && Gdx.input.getX() < x0+rectSize && Gdx.input.getY() < y0+rectSize && Gdx.input.getY() > y0) {
			if(Gdx.input.isTouched()&&status == 0) {
				if(pos == 2) 
					score++;
				else
					score--;
				status=1;
				randcolor();
				alreadyChecked = 0;  
			}
		}
		//click 3
		else if(Gdx.input.getX() > x1 && Gdx.input.getX() < x1+rectSize && Gdx.input.getY() < y0+rectSize && Gdx.input.getY() > y0) {
			if(Gdx.input.isTouched()&&status == 0) {
				if(pos == 3) 
					score++;
				else
					score--;
				status=1; 
				randcolor(); 
				alreadyChecked = 0; 	
			}   
		} 
		//click 0
		else if(Gdx.input.getX() > x0 && Gdx.input.getX() < x0+rectSize && Gdx.input.getY() < y1+rectSize && Gdx.input.getY() > y1) {
			if(Gdx.input.isTouched()&&status == 0) {
				if(pos == 0)  
					score++;
				else
					score--;
				status=1;
				randcolor();
				alreadyChecked = 0;
			}
		}
		//click 1
		else if(Gdx.input.getX() > x1 && Gdx.input.getX() < x1+rectSize && Gdx.input.getY() < y1+rectSize && Gdx.input.getY() > y1) {
			if(Gdx.input.isTouched()&&status == 0) { 
				if(pos == 1) 
					score++;
				else
					score--;
				status=1;
				randcolor(); 
				alreadyChecked = 0; 
			} 
		}
		if(!Gdx.input.isTouched()) {
			status = 0;  
		}  
		checkedTime(seconds);
	}  
	 
	public void textPrintFunc(int order, int x, int y, int position) {
		if(order != position) { 
			font.draw(batch, colorName[colorIndex[order]], x, y); 
		} 
		else { // order == position 
			if(alreadyChecked==1) {
				font.draw(batch, colorName[newColorName], x, y);
			}
			else { 
				newColorName = falseColorName();
				font.draw(batch, colorName[newColorName], x, y);
				alreadyChecked = 1;
			} 
			System.out.println("False " + order);
		} 
	}
	  
	public int falseColorName() { 
		
		int order;
		order = rand.nextInt(listcolor.length);
		while(check(order)==0) {
			order = rand.nextInt(listcolor.length);
		}
		//System.out.println("order " + order + "index " + colorIndex[order]);
		return order;
	} 
	 
	public int check(int order) {
		if(order == colorIndex[0] || order == colorIndex[1] || order == colorIndex[2] || order == colorIndex[3])
			return 0;
		return 1; 
	}
	
	public void checkedTime(int seconds) {
		if(seconds == 0) {
			System.out.println(".....Time out.... ");
			shape.begin(ShapeType.Filled);
			shape.setColor(Color.BLACK); 
			shape.rect(0, 0, 800, 800); 
			shape.end();
			Gdx.app.exit();
		}
	}
	@Override
	public void dispose () {
		batch.dispose(); 
		font.dispose();
	}
}
