package com.game.build;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
//import java.util.Random;

public class FastEnemy extends GameObject {

	private Handler handler;
	//private Random r;
	
	public FastEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 2;
		velY = 9;
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT - 50) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 20) velX *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.cyan, 16, 16, 0.019f, handler));
	}

	public void render(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(x, y, 16, 16);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 16, 16);
	}
	
}
