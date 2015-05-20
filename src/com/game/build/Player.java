package com.game.build;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {
	
	Handler handler;
	
	public Player(int x, int y, ID id, Handler handler){
		super(x, y, id);
		this.handler = handler;
	}
	
	public void tick(){
		x += velX;
		y += velY;
		
		y = Game.clamp(y, 0, Game.HEIGHT - 67);
		x = Game.clamp(x, 0, Game.WIDTH - 37);
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.white, 32, 32, 0.07f, handler));
		
		collision();
	}
	
	private void collision(){
		for(int i = 0; i < handler.object.size(); i ++){
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.BasicEnemy || tempObject.getID() == ID.FastEnemy || tempObject.getID() == ID.SmartEnemy){
				//collision code
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH -= 2;
				}
			}
			else if(tempObject.getID() == ID.BossEnemy){
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH -= 10;
				}
			}
			
		}
	}
	
	public void render(Graphics g){
		
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, 32, 32);
		
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}
	
	
}