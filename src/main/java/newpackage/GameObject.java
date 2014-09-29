package newpackage;

/**
 *
 * @author Tomas Abril
 */
public abstract class GameObject {

	protected float x;
	protected float y;
	protected float sx;	//size x
	protected float sy;	//size y
	public boolean vivo = true;

	abstract void update();

	public void render() {
		if (vivo) {
			Draw.rect(x, y, sx, sy);
		}
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getSx() {
		return sx;
	}

	public float getSy() {
		return sy;
	}

	public float getCenterY() {
		return y + (sy / 2);
	}

}
