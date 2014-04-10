package components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Score {

	private String p1 = "Player 1"; 
	private String p2 = "Player 2"; 
	
	private int p1Score;
	private int p2Score;
	
	private int screenX;
	private int screenY;
	
	public int maxScore = 7;
	public Score(int x, int y){
		screenX = x;
		screenY = y;
	}
	
	public void setScore(int p1, int p2){
		p1Score = p1;
		p2Score = p2;
	}
	
	public int getP1Score(){
		return p1Score;
	}
	
	public int getP2Score(){
		return p2Score;
	}
	
	public void resetScore(){
		p1Score = 0;
		p2Score = 0;
	}
	
	public void update(){
		p1Score = getP1Score();
		p2Score = getP2Score();
	}
	
	public void render(Graphics g){
		String sp1Score = Integer.toString(p1Score);
		String sp2Score = Integer.toString(p2Score);
		
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.ITALIC, 20));
		g.drawString(p1,200,50);
		g.drawString(p2,screenX - p2.length()*35,50);
		g.drawString("Score: " + sp1Score,200,70);
		g.drawString("Score: " + sp2Score,screenX - p2.length()*35,70);
	}
}
