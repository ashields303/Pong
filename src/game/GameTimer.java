package game;

import java.io.IOException;

public class GameTimer {
	private volatile boolean running = false;
	
	double delta = 0D;
	final double optimalTime = (1000000000/60); 
	int frames = 0;
	int updates = 0;
	
	boolean canRetrieveFPS = false;
	boolean canRetrieveUPS = false;
	
	public GameTimer(){
		
		
		long lastTime = System.nanoTime();
		long lTimer = System.currentTimeMillis();

		while(running){
			long nowTime = System.nanoTime();

			delta += (nowTime - lastTime)/optimalTime;
			lastTime = nowTime;
			
			while(delta >= 1){
				updates++;
				//UPDATE CALLS GO HERE
				update();
				delta -= 1;
			}
			
			//Try to sleep the thread for 2 milliseconds 
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//update the frame count
			frames++;
			
			//RENDER CALLS GO HERE
			
			//This is used for updating the frames and updates per second
			//and for updating the calls to getFPS and UPS.
			if(System.currentTimeMillis() - lTimer >=1000){
				lTimer += 1000;
				canRetrieveFPS = true;
				canRetrieveUPS = true;
				System.out.println("FPS: " + getFPS());
				System.out.println("UPS: " + getUPS());
				frames = 0;
				updates = 0;
			}
			canRetrieveUPS = false;
			canRetrieveFPS = false;
		}
	}
	
	public int getFPS(){
		int FPS = 0;
		if(canRetrieveFPS){
			FPS = frames;
		}
		return FPS;	
		}
	
	public int getUPS(){
		int UPS = 0;
		if(canRetrieveFPS){
			UPS = updates;
		}
		return UPS;	
	}
	
	public void start(){
		setRunning(true);
	}
	
	public void stop(){
		setRunning(false);
	}
	
	public boolean isRunning(){
		return running;
	}
	
	public void update(){
		
	}
	
	private void setRunning(boolean b){
		running = b;
	}
}
	
