package newpackage;


import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

/**
 * @author Tomás Abril
 */
// --------------
/// 7 things a game engine does
//
// initializes a window/display
// creates objects / prepares game 
// game loop 
//	get input
//	game logic
//	render / draws everything on screen
// cleanup
// ---------------
public class Main {

	private static Game game;

	public static void main(String[] args) {
		//initialize program
		initDisplay();
		initGl();

		initGame();

		gameLoop();
		cleanUp();

	}

	private static void initGame() {
		game = new Game();
	}

	private static void getInput() {
		game.getInput();
	}

	private static void update() {
		game.update();
	}

	private static void render() {
		glClear(GL_COLOR_BUFFER_BIT);
		glLoadIdentity();

		game.render();

		Display.update();
		Display.sync(60);
	}

	private static void gameLoop() {
		//Game Loop
		while (!Display.isCloseRequested()) {
			getInput();
			update();
			render();
		}
	}

	private static void initGl() {
		glMatrixMode(GL_PROJECTION);	//modo matriz projecao
		glLoadIdentity();		//limpa a matriz
		glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1, 1);
		glMatrixMode(GL_MODELVIEW);	//modo matriz modelo

		glClearColor(0, 0, 0, 1);	//cor do vazio

		glDisable(GL_DEPTH_TEST);	//tira 3d
	}

	private static void cleanUp() {
		Display.destroy();
		//Keyboard.destroy();
	}

	private static void initDisplay() {
		//Create Display
		try {
			Display.setDisplayMode(new DisplayMode(800, 800));
			//Display.setTitle("lwjgl-Pong _Tomás");
			Display.create();
			Display.setVSyncEnabled(true);		//vsync
			//Keyboard.create();
		} catch (LWJGLException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
