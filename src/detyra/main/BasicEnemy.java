package detyra.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class BasicEnemy extends GameObject{
	private BufferedImage basicEnemy_image;
	private Random r = new Random();

	public BasicEnemy(float x, float y, ID id) {
		super(x, y, id);
		velX = (r.nextInt(10 - -10) + - 10);
		velY = (r.nextInt(10 - -10) + - 10);
		if(velX == 0) velX = 1;
		if(velY == 0) velY = 1;
		
		SpriteSheet ss = new SpriteSheet(Loja.sprite_sheet);
		basicEnemy_image = ss.grabImage(4, 1, 32, 32);
	}
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Loja.HEIGHT -48) velY *= -1; 
		if(x <= 0 || x >= Loja.WIDTH - 32) velX *= -1; 
		
	}


	public void render(Graphics g) {
		//g.setColor(Color.red);
		//g.fillRect((int)x, (int)y, 16, 16);
		g.drawImage(basicEnemy_image, (int) x, (int) y, null);
		
	}

}
