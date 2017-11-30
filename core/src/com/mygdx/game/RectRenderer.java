package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.Texture;

public class RectRenderer {
	public static Texture createPixmapRoundCornerRect(Color color, int width,
            int height, int radius) {
        Pixmap pixmap = new Pixmap(width, height, Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fillCircle(radius, radius, radius);
        pixmap.fillCircle(width - radius, radius, radius);
        pixmap.fillCircle(width - radius, height - radius, radius);
        pixmap.fillCircle(radius, height - radius, radius);
        pixmap.fillRectangle(0, radius, width, height - (radius * 2));

        pixmap.fillRectangle(radius, 0, width - (radius * 2), height);
        Texture pixmaptex = new Texture(pixmap);
        pixmap.dispose();
        return pixmaptex;
    }

	private SpriteBatch batch;

	
	
}
