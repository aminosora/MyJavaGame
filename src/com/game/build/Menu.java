package com.game.build;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.game.build.Game.STATE;

public class Menu extends MouseAdapter {
	
	private Game game;
	private Handler handler;
	private Random r = new Random();
	
	private int alpha = 70;
	private int alpha2 = 30;
	private Color color = new Color(90, 90, 255, alpha);
	private Color color2 = new Color(0, 255, 255, alpha2);
	
	public Menu(Game game, Handler handler){
		this.game = game;
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		
		if(game.gameState == STATE.Menu){
			//Play Button
			if(mouseOver(mx, my, 220, 150, 200, 64)){
				game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
				handler.clearEnemys();
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
			}
			
			//Quit Button
			if(mouseOver(mx, my, 220, 350, 200, 64)){
				System.exit(1);
			}
			
			//Help Button
			if(mouseOver(mx, my, 220, 250, 200, 64)){
				game.gameState = STATE.Help;
			}
		}
		
		//Back Button For Help
		if(game.gameState == STATE.Help){
			if(mouseOver(mx, my, 220, 350, 200, 64)){
				game.gameState = STATE.Menu;
				return;
			}
		}
	}
	
	public void mouseReleased(MouseEvent e){
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
		if(mx > x && mx < x + width){
			if(my > y && my < y + height) { return true; }
			else { return false; }
		} else { return false; }
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		if(game.gameState == STATE.Menu){
			if(g instanceof Graphics2D){
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			}
			
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 50);
		
			//GAME TITLE
			g.setFont(fnt);
			g.setColor(Color.white);
			
			g.drawString("BloX", 254, 65);
			
			//PLAY BUTTON
			g.setFont(fnt2);
			g.drawRect(220, 150, 200, 64);
			g.setColor(color);
			g.fillRect(220, 150, 200, 64);
			
			g.setColor(Color.white);
			g.drawString("Play", 266, 200);
			
			//HELP BUTTON
			g.drawRect(220, 250, 200, 64);
			g.setColor(color);
			g.fillRect(220, 250, 200, 64);
			
			g.setColor(Color.white);
			g.drawString("HELP", 253, 300);
			
			//QUIT BUTTON
			g.drawRect(220, 350, 200, 64);
			g.setColor(color);
			g.fillRect(220, 350, 200, 64);
			
			g.setColor(Color.white);
			g.drawString("Quit", 266, 400);
			
		} else if(game.gameState == STATE.Help){
			if(g instanceof Graphics2D){
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			}
			
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 50);
			Font fnt3 = new Font("arial", 1, 32);
			
			//Help Title
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("HELP!", 244, 65);
			
			//Controls Text
			g.setFont(fnt3);
			g.drawString("Use ASWD to move and dodge enemies", 20, 130);
			
			//Back Button
			g.setFont(fnt2);
			g.drawRect(220, 350, 200, 64);
			g.setColor(color);
			g.fillRect(220, 350, 200, 64);
			g.setColor(Color.white);
			g.drawString("Back", 259, 400);
			
			//==============================================================
			
			//A key graphics
			g.setColor(Color.cyan);
			g.drawRect(215, 250, 64, 64);
			g.setColor(color2);
			g.fillRect(215, 250, 64, 64);
			g.setColor(Color.cyan);
			g.drawString("A", 229, 300);
			
			//S key graphics
			g.drawRect(290, 250, 64, 64);
			g.setColor(color2);
			g.fillRect(290, 250, 64, 64);
			g.setColor(Color.cyan);
			g.drawString("S", 305, 300);
			
			//W key graphics
			g.drawRect(290, 175, 64, 64);
			g.setColor(color2);
			g.fillRect(290, 175, 64, 64);
			g.setColor(Color.cyan);
			g.drawString("W", 299, 225);
			
			//D key graphics
			g.drawRect(365, 250, 64, 64);
			g.setColor(color2);
			g.fillRect(365, 250, 64, 64);
			g.setColor(Color.cyan);
			g.drawString("D", 380, 300);
			
		}
	}
	
	
	
}
