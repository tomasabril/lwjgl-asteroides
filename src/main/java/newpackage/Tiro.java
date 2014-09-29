/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import org.lwjgl.opengl.Display;

/**
 *
 * @author tomas
 */
public class Tiro extends GameObject {

	public static final int size = 8;
	private float dam = 0.01f;

	public float velx;
	public float vely;
	Game game;

	public Tiro(Game game) {
		this.game = game;
		x = Display.getWidth() / 2;
		y = Display.getHeight() / 2;

		this.sx = size;
		this.sy = size;

		velx = (Game.mouseX - x) * dam;
		vely = (Game.mouseY - y) * dam;
	}

	@Override
	void update() {
		if (vivo) {
			x += velx;
			y += vely;
			for (GameObject g : game.objects) {
				if (g.sx == 16 && g.vivo) {
					if (Physics.checkCollisions(this, g)) {
						game.score++;
						this.vivo = false;
						g.vivo = false;
					}
				}
			}

		}
	}

}
