package com.LykoS.Novellus;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Object {
	Sprite sprite;
	float xPos;
	float yPos;
	float width;
	float height;
	public Object(float x, float y, float w, float h, Texture t) {
		this.sprite = new Sprite(t);
		xPos = x;
		yPos = y;
		width = w;
		height = h;
		updateObject();
	}
	public void updateObject(){
		sprite.setX(xPos);
		sprite.setY(yPos);
		sprite.setSize(width, height);
	}
	public int getRight() {
		return (int)(xPos + width);
	}
	public int getLeft() {
		return (int) xPos;
	}
	public int getTop() {
		return (int) (yPos + height);
	}
	public int getBottom() {
		return (int) yPos;
	}
	public int[] getCenter() {
		int[] center = new int[2];
		center[0] = (int) (xPos + (width/2));
		center[1] = (int) (yPos + (height/2));
		return center;
	}
	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
	}
	public void setLeft(float x) {
		xPos = x;
		updateObject();
	}
	public void setBottom(float y) {
		yPos = y;
		updateObject();
	}
	
}