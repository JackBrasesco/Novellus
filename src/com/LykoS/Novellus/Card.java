package com.LykoS.Novellus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Card {
	Sprite sprite;
	float xPos;
	float yPos;
	
	int health;
	int attack;
	String keywords;
	boolean dead = false;
	float mouseX, mouseY, changeInX, changeInY;
	
	
	public Card(float x, float y, Texture t, int h, int a, String k) {
		this.sprite = new Sprite(t);
		xPos = x;
		yPos = y;
		health = h;
		attack = a;
		keywords = k;
		updateObject();
		
	}
	public void updateObject() {
		sprite.setX(xPos);
		sprite.setY(yPos);
		sprite.setSize(248, 350);
	}
	public void LoseHealth(int dmg) {
		this.health = (this.health - dmg);
		if (health == 0) {
			dead = true;
		}
	}
	public void ClikNDrag() {
		if (Gdx.input.isTouched()) {
			if (MouseX() < this.getRight() && MouseX() > this.getLeft()) {
				if(MouseY() < this.getTop() && MouseY() > this.getBottom()) {
					setX(MouseX() - 124);
					setY(MouseY() - 175);
				}
			}
		}
	}
	public int MouseX() {
		return Gdx.input.getX();
	}
	public int MouseY() {
		return Gdx.graphics.getHeight() - Gdx.input.getY();
	}

	public int getRight() {
		return (int)(xPos + 248);
	}
	public int getLeft() {
		return (int) xPos;
	}
	public int getTop() {
		return (int) (yPos + 350);
	}
	public int getBottom() {
		return (int) yPos;
	}
	public void draw(SpriteBatch batch) {
		if (dead == false) {
			sprite.draw(batch);
		} else {
			
		}
	}
	public void setX(float x) {
		xPos = x;
		updateObject();
	}
	public void setY(float y) {
		yPos = y;
		updateObject();
	}
}