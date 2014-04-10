package menu;

import entities.Paddle;
import game.Input;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import components.AudioPlayer;

public class MainMenu {

	int gameWidth;
	int gameHeight;

	Rectangle playButton;
	Rectangle optionsButton;
	Rectangle quitButton;
	Rectangle difficultyButton;
	Rectangle difficultyToggle;
	Rectangle backButton;
	Rectangle resumeButton;

	private AudioPlayer menuUp;
	private AudioPlayer menuDown;

	Paddle cpu;

	private int gameState = 0;
	private double difficulty = 5.0;

	public enum MAIN {
		NULL, PLAY, OPTIONS, QUIT
	};

	public enum OPTIONS {
		NULL, DIFFICULTY, DIFFICULTY_CHANGE, BACK
	};

	public enum PAUSE {
		NULL, RESUME, EXIT, RESTART
	};

	public MAIN ms;
	OPTIONS os;
	public PAUSE ps;

	public MainMenu(int width, int height, Paddle cpuPaddle) {
		ms = MAIN.PLAY;
		os = OPTIONS.NULL;
		ps = PAUSE.NULL;
		setGameHeight(height);
		setGameWidth(width);
		init(cpuPaddle);
	}

	private void init(Paddle cpuPaddle) {

		menuUp = new AudioPlayer("/audio/menuUp.wav");
		menuDown = new AudioPlayer("/audio/menuDown.wav");
		playButton = new Rectangle(getGameWidth() / 2, 400, 200, 50);
		optionsButton = new Rectangle(getGameWidth() / 2, 400, 200, 50);
		quitButton = new Rectangle(getGameWidth() / 2, 400, 200, 50);

		difficultyButton = new Rectangle(getGameWidth() / 2, 400, 300, 50);
		difficultyToggle = new Rectangle((getGameWidth() / 2) + 100, 400, 70,
				50);
		backButton = new Rectangle(getGameWidth() / 2, 400, 200, 50);
		resumeButton = new Rectangle(getGameWidth() / 2, 400, 200, 50);

		cpu = cpuPaddle;
	}

	public void render(Graphics g) {
		Font font0 = new Font("arial", Font.BOLD, 50);
		Font font1 = new Font("arial", Font.BOLD, 30);

		g.setFont(font0);
		g.setColor(Color.WHITE);
		if(ps == PAUSE.NULL){
			g.drawString("PONG", (getGameWidth() / 2) - 70, 200);
		}
		g.setFont(font1);

		if (os == OPTIONS.NULL) {
			drawMainButtonStates(g);
		} else {
			drawOptionsButtonStates(g);
		}

		if (ps != PAUSE.NULL) {
			drawPauseButtonStates(g);
		}

	}

	public void update(Input input) {
		// ///////////////////////////////
		// ////////Main Menu//////////////
		// ///////////////////////////////

		if (input.up.isPressed() && ms == MAIN.PLAY) {
			// do nothing
			input.up.toggle(false);
			return;
		}
		if (input.up.isPressed() && ms == MAIN.OPTIONS) {
			menuUp.play();
			ms = MAIN.PLAY;
			input.up.toggle(false);

			return;
		}
		if (input.up.isPressed() && ms == MAIN.QUIT) {
			menuUp.play();
			ms = MAIN.OPTIONS;
			input.up.toggle(false);
			return;
		}

		if (input.down.isPressed() && ms == MAIN.PLAY) {
			menuDown.play();
			ms = MAIN.OPTIONS;
			input.down.toggle(false);
			return;

		}
		if (input.down.isPressed() && ms == MAIN.OPTIONS) {
			menuDown.play();
			ms = MAIN.QUIT;
			input.down.toggle(false);
			return;
		}
		if (input.down.isPressed() && ms == MAIN.QUIT) {
			// do nothing
			input.down.toggle(false);
			return;
		}

		if (input.select.isPressed() && ms == MAIN.PLAY) {
			// Start the game
			setGameState(1);
			input.select.toggle(false);
		}
		if (input.select.isPressed() && ms == MAIN.OPTIONS) {
			// draw the options menu and enable options menu
			os = OPTIONS.DIFFICULTY;
			ms = MAIN.NULL;
			input.select.toggle(false);
		}
		if (input.select.isPressed() && ms == MAIN.QUIT) {
			// Start the game
			setGameState(2);
			input.select.toggle(false);
		}

		// ///////////////////////////////
		// /////Options Menu//////////////
		// ///////////////////////////////

		if (input.up.isPressed() && os == OPTIONS.DIFFICULTY) {
			// do nothing
			input.up.toggle(false);
			return;
		}

		if (input.up.isPressed() && os == OPTIONS.BACK) {
			// move up
			os = OPTIONS.DIFFICULTY;
			menuUp.play();
			input.up.toggle(false);
			return;
		}

		if (input.up.isPressed() && os == OPTIONS.DIFFICULTY_CHANGE) {
			// increment the difficulty of the game
			difficulty++;
			menuUp.play();
			input.up.toggle(false);
			return;
		}

		if (input.down.isPressed() && os == OPTIONS.DIFFICULTY_CHANGE) {
			// decrement the difficulty of the game
			difficulty--;
			menuDown.play();
			input.down.toggle(false);
			return;
		}

		if (input.down.isPressed() && os == OPTIONS.DIFFICULTY) {
			// move down
			menuDown.play();
			os = OPTIONS.BACK;
			input.down.toggle(false);
			return;
		}

		if (input.down.isPressed() && os == OPTIONS.BACK) {
			// do nothing
			input.down.toggle(false);
			return;
		}

		if (input.select.isPressed() && os == OPTIONS.BACK) {
			// go back to main menu
			os = OPTIONS.NULL;
			ms = MAIN.OPTIONS;
			input.select.toggle(false);
			return;
		}

		if (input.select.isPressed() && os == OPTIONS.DIFFICULTY) {
			// enable the difficulty settings
			os = OPTIONS.DIFFICULTY_CHANGE;
			input.select.toggle(false);
			return;
		}

		if (input.select.isPressed() && os == OPTIONS.DIFFICULTY_CHANGE) {
			// back to difficulty
			os = OPTIONS.DIFFICULTY;
			input.select.toggle(false);
			return;
		}

		// ///////////////////////////////
		// ///////Pause Menu//////////////
		// ///////////////////////////////
		
			if (input.up.isPressed() && ps == PAUSE.EXIT) {
				// increment the difficulty of the game
				menuUp.play();
				ps = PAUSE.RESUME;
				input.up.toggle(false);
				return;
			}

			if (input.down.isPressed() && ps == PAUSE.RESUME) {
				// increment the difficulty of the game
				menuDown.play();
				ps = PAUSE.EXIT;
				input.up.toggle(false);
				return;
			}

			if (input.select.isPressed() && ps == PAUSE.EXIT) {
				// back to difficulty
				ps = PAUSE.RESTART;
				input.select.toggle(false);
				return;
			}

			if (input.select.isPressed() && ps == PAUSE.RESUME) {
				// back to difficulty
				ps = PAUSE.NULL;
				input.select.toggle(false);
				return;
			}
		
	}

	private void drawMainButtonStates(Graphics g) {
		String playString = "PLAY";
		String optionsString = "OPTIONS";
		String quitString = "QUIT";

		if (ms == MAIN.PLAY) {
			g.setColor(Color.RED);
			g.drawRect((getGameWidth() / 2) - playButton.width / 2, 300,
					playButton.width, playButton.height);
			g.drawString(playString, (getGameWidth() / 2) - 40, 300 + 35);

			g.setColor(Color.WHITE);
			g.drawRect((getGameWidth() / 2) - optionsButton.width / 2, 360,
					optionsButton.width, optionsButton.height);
			g.drawString(optionsString, (getGameWidth() / 2) - 70, 360 + 35);

			g.drawRect((getGameWidth() / 2) - quitButton.width / 2, 420,
					quitButton.width, quitButton.height);
			g.drawString(quitString, (getGameWidth() / 2) - 37, 420 + 35);
		}
		if (ms == MAIN.OPTIONS) {
			g.setColor(Color.RED);
			g.drawRect((getGameWidth() / 2) - optionsButton.width / 2, 360,
					optionsButton.width, optionsButton.height);
			g.drawString(optionsString, (getGameWidth() / 2) - 70, 360 + 35);

			g.setColor(Color.WHITE);
			g.drawRect((getGameWidth() / 2) - playButton.width / 2, 300,
					playButton.width, playButton.height);
			g.drawString(playString, (getGameWidth() / 2) - 40, 300 + 35);

			g.drawRect((getGameWidth() / 2) - quitButton.width / 2, 420,
					quitButton.width, quitButton.height);
			g.drawString(quitString, (getGameWidth() / 2) - 37, 420 + 35);
		}
		if (ms == MAIN.QUIT) {
			g.setColor(Color.RED);
			g.drawRect((getGameWidth() / 2) - quitButton.width / 2, 420,
					quitButton.width, quitButton.height);
			g.drawString(quitString, (getGameWidth() / 2) - 37, 420 + 35);

			g.setColor(Color.WHITE);
			g.drawRect((getGameWidth() / 2) - playButton.width / 2, 300,
					playButton.width, playButton.height);
			g.drawString(playString, (getGameWidth() / 2) - 40, 300 + 35);

			g.drawRect((getGameWidth() / 2) - optionsButton.width / 2, 360,
					optionsButton.width, optionsButton.height);
			g.drawString(optionsString, (getGameWidth() / 2) - 70, 360 + 35);
		}

	}

	public void drawOptionsButtonStates(Graphics g) {
		String difficultyString = "SET DIFFICULTY";
		String backString = "BACK";
		String difficultyNumber = String.valueOf(difficulty);

		// Default state
		if (os == OPTIONS.DIFFICULTY) {
			g.setColor(Color.BLUE);
			g.drawString("OPTIONS", (getGameWidth() / 2) - 70, 300 + 35);

			g.setColor(Color.RED);
			g.drawRect((getGameWidth() / 2) - difficultyButton.width / 2, 360,
					difficultyButton.width, difficultyButton.height);
			g.drawString(difficultyString, (getGameWidth() / 2) - 120, 360 + 35);

			g.setColor(Color.WHITE);
			g.drawRect((getGameWidth() / 2) - backButton.width / 2, 420,
					backButton.width, backButton.height);
			g.drawString(backString, (getGameWidth() / 2) - 37, 420 + 35);
		}

		// Changing Difficulty
		if (os == OPTIONS.DIFFICULTY_CHANGE) {
			g.setColor(Color.BLUE);
			g.drawString("OPTIONS", (getGameWidth() / 2) - 70, 300 + 35);

			g.drawRect((getGameWidth() / 2) - difficultyButton.width / 2 - 60,
					360, difficultyButton.width, difficultyButton.height);
			g.drawString(difficultyString, (getGameWidth() / 2) - 180, 360 + 35);

			g.setColor(Color.RED);
			g.drawRect(600, 360, difficultyToggle.width,
					difficultyToggle.height);
			g.drawString(difficultyNumber, difficultyToggle.x + 15,
					difficultyToggle.y - 3);

			g.setColor(Color.WHITE);
			g.drawRect((getGameWidth() / 2) - backButton.width / 2, 420,
					backButton.width, backButton.height);
			g.drawString(backString, (getGameWidth() / 2) - 37, 420 + 35);
		}

		// Back state
		if (os == OPTIONS.BACK) {
			g.setColor(Color.BLUE);
			g.drawString("OPTIONS", (getGameWidth() / 2) - 70, 300 + 35);

			g.setColor(Color.WHITE);
			g.drawRect((getGameWidth() / 2) - difficultyButton.width / 2, 360,
					difficultyButton.width, difficultyButton.height);
			g.drawString(difficultyString, (getGameWidth() / 2) - 120, 360 + 35);

			g.setColor(Color.RED);
			g.drawRect((getGameWidth() / 2) - backButton.width / 2, 420,
					backButton.width, backButton.height);
			g.drawString(backString, (getGameWidth() / 2) - 37, 420 + 35);
		}
	}

	public void drawPauseButtonStates(Graphics g) {
		String resumeString = "RESUME";
		String quitString = "QUIT";

		// Default state
		if (ps == PAUSE.RESUME) {
			g.setColor(Color.RED);
			g.drawRect((getGameWidth() / 2) - resumeButton.width / 2, 360,
					resumeButton.width, resumeButton.height);
			g.drawString(resumeString, (getGameWidth() / 2) - 65, 360 + 35);

			g.setColor(Color.WHITE);
			g.drawRect((getGameWidth() / 2) - quitButton.width / 2, 420,
					quitButton.width, quitButton.height);
			g.drawString(quitString, (getGameWidth() / 2) - 30, 420 + 35);
		}

		// Quit the game
		if (ps == PAUSE.EXIT) {
			g.setColor(Color.WHITE);
			g.drawRect((getGameWidth() / 2) - resumeButton.width / 2, 360,
					resumeButton.width, resumeButton.height);
			g.drawString(resumeString, (getGameWidth() / 2) - 65, 360 + 35);

			g.setColor(Color.RED);
			g.drawRect((getGameWidth() / 2) - quitButton.width / 2, 420,
					quitButton.width, quitButton.height);
			g.drawString(quitString, (getGameWidth() / 2) - 30, 420 + 35);
		}

	}

	public void setGameHeight(int height) {
		gameHeight = height;
	}

	public int getGameHeight() {
		return gameHeight;
	}

	public void setGameWidth(int width) {
		gameWidth = width;
	}

	public int getGameWidth() {
		return gameWidth;
	}

	public void setGameState(int i) {
		gameState = i;
	}

	public int getGameState() {
		return gameState;
	}

	public double getDifficulty() {
		return difficulty;
	}
}
