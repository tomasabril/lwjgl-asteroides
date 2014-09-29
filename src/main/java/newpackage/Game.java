package newpackage;

import java.util.ArrayList;
import java.util.List;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

/**
 *
 * @author Tomás Abril
 */
public class Game {

	public List<GameObject> objects;
	int frame = 0;
	Player player1;
	public static int score = 0;

	public static int mouseX;
	public static int mouseY;

	public Game() {

		objects = new ArrayList<>();

		player1 = new Player(Display.getWidth() / 2 - Player.sizex / 2,
			Display.getHeight() / 2 - Player.sizey / 2);
		objects.add(player1);

	}

	public void getInput() {
		mouseX = Mouse.getX(); // will return the X coordinate on the Display.
		mouseY = Mouse.getY(); // will return the Y coordinate on the Display.
		if (frame % 45 == 0 && player1.life > 0) {
			//atira
			Tiro tiro = new Tiro(this);
			objects.add(tiro);
		}
	}

	public void update() {
		for (GameObject g : objects) {
			g.update();
		}
		Display.setTitle("lwjgl-Asteroide |  vidas: " + player1.life + " score: " + score + "    | Tomás");

		//atira
		if (frame % 120 == 0 && player1.life > 0) {
			Ball asteroide = new Ball(player1);
			objects.add(asteroide);
		}

		frame++;

		//limpa a lista de objetos
		// está parecendo que nao precisa
//		for (GameObject g : objects) {
//			g.update();
//		}
		//reinicia contagem de frames
		if (frame == (60 * 60 * 60 + 1)) {
			frame = 1;
		}
	}

	public void render() {
		for (GameObject g : objects) {
			g.render();
		}
	}
}
