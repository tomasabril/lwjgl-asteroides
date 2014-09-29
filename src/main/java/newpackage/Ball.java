package newpackage;

import java.util.Random;
import org.lwjgl.opengl.Display;

/**
 *
 * @author tomas
 */
public class Ball extends GameObject {

	public static final int size = 16;

	public float velx;
	public float vely;
	private float dam = 0.0001f;
	private float bloq = 300f;

	Player player;

	public Ball(Player player) {
		this.player = player;
		Random rand = new Random();
		float xc;
		float yc;
		do {
			xc = rand.nextInt(Display.getWidth());
			yc = rand.nextInt(Display.getHeight());
		} while (((xc > (Display.getWidth() / 2 + bloq))
			|| (xc < (Display.getWidth() / 2 - bloq)))
			|| ((yc > (Display.getHeight() / 2 + bloq))
			|| (yc < (Display.getHeight() / 2 - bloq))));

		this.x = xc;
		this.y = yc;

		this.sx = size;
		this.sy = size;

		float acelRand = (float) (rand.nextInt(50));

		velx = (player.x - this.x) * dam * acelRand;
		vely = (player.y - this.y) * dam * acelRand;
	}

	@Override
	public void update() {
		if (player.life <= 0) {
			this.vivo = false;
		}
		if (vivo) {
			x += velx;
			y += vely;
			if (Physics.checkCollisions(this, player)) {
				player.hit();
				vivo = false;
			}

		}
	}

}
