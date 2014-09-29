package newpackage;

import java.awt.Rectangle;

/**
 *
 * @author tomas
 */
public class Physics {

	public static boolean checkCollisions(GameObject o1, GameObject o2) {
		Rectangle r1 = new Rectangle(
			(int) o1.getX(),
			(int) o1.getY(),
			(int) o1.getSx(),
			(int) o1.getSy());
		Rectangle r2 = new Rectangle(
			(int) o2.getX(),
			(int) o2.getY(),
			(int) o2.getSx(),
			(int) o2.getSy());

		return r1.intersects(r2);
	}
}
