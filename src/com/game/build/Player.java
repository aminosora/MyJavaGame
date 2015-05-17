package com.game.build;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {
	
	public Player(int x, int y, ID id){
		super(x, y, id);
		
	}
	
	public void tick(){
		x += velX;
		y += velY;
		
		y = Game.clamp(y, 0, Game.HEIGHT - 67);
		x = Game.clamp(x, 0, Game.WIDTH - 37);
	}
	
	public void render(Graphics g){
		if(id == ID.Player) g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
	}
	
	
}