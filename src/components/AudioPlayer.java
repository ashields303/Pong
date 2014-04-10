package components;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioPlayer {

	Clip clip;
	
	public AudioPlayer(String s) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(getClass()
					.getResource(s));
			
			clip = AudioSystem.getClip();
			clip.open(ais);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public void play(){
		if(clip == null){
			return;
		}
		stop();
		clip.setFramePosition(0);
		clip.start();
	}
	
	public void stop(){
		if(clip.isRunning()){
			clip.stop();
		}
	}
	
	public void close(){
		stop();
		clip.close();
	}
}
