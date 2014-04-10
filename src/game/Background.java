package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Background {

	private int lineHeight;
	private int lineWidth;
	private int lineSpacing;
	private int screenHeight;
	private int screenWidth;
	
	public Background(int width, int height){
		setHeight(height);
		setWidth(width);
		lineHeight = 40;
		lineWidth = 10;
		lineSpacing = 20;
	}
	
	public void render(Graphics g){
		//draw enough lines in the center of the screen
		int gap = ((lineSpacing*2)+(lineHeight));
		g.setColor(Color.WHITE);
		//for(;((int)gap/screenWidth) > 0;gap+=40){
			g.fillRect((screenWidth/2)-(lineWidth/2), 20, lineWidth, lineHeight);
			g.fillRect((screenWidth/2)-(lineWidth/2), 120, lineWidth, lineHeight);
			g.fillRect((screenWidth/2)-(lineWidth/2), 240, lineWidth, lineHeight);
			g.fillRect((screenWidth/2)-(lineWidth/2), 360, lineWidth, lineHeight);
			g.fillRect((screenWidth/2)-(lineWidth/2), 480, lineWidth, lineHeight);
		//}
		
	}
	
	private void setWidth(int width){
		screenWidth = width;
	}
	
	private void setHeight(int height){
		screenHeight = height;
	}
	
}
