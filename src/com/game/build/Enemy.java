package com.game.build;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends GameObject {

	public Enemy(int x, int y, ID id) {
		super(x, y, id);
	}

	public void tick() {
		x += velX;
		y += velY;
	}

	public void render(Graphics g) {
		if(id == ID.Enemy) g.setColor(Color.red);
		g.fillRect(x, y, 35, 35);
	}
	
}
