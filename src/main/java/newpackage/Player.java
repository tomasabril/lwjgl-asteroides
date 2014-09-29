package newpackage;

import org.lwjgl.opengl.Display;

/**
 *
 * @author tomas
 */
public class Player extends GameObject {

	public static final int sizex = 40;
	public static final int sizey = 40;
	public int life = 10;

	private float red;
	private float green;
	private float blue;

	public Player(float x, float y) {
		this.x = x;
		this.y = y;

		this.sx = sizex;
		this.sy = sizey;
		red = 0f;
		green = 1f;
		blue = 0.3f;
	}

	@Override
	void update() {
	}

	@Override
	public void render() {
		Draw.rect(x, y, sx, sy, 0, red, green, blue);
	}

	void hit() {
		life--;
		if (life <= 0) {
			red = 1f;
		}
		if (life < 0) {
			red = 1f;
			green = 0f;
		}
		//red += (10 - life) / 10;
	}

}
