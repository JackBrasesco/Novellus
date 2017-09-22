package com.LykoS.Novellus;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class novellus implements ApplicationListener {
	
	//Definitions
	SpriteBatch batch;
	ShapeRenderer sr;
	Object play, back;
	Texture carbon, background,PlayButton,PlayBackground,BackButton,VampireTxtr;
	public int GameState = 0;
	Card vampire;

	@Override
	public void create() {
		batch = new SpriteBatch();
		sr = new ShapeRenderer();
		carbon = new Texture(Gdx.files.internal("Assets/th.jpg"));
		BackButton = new Texture(Gdx.files.internal("Assets/BackArrow.png"));
		background = new Texture(Gdx.files.internal("Assets/NovellusBackground.png"));
		PlayButton = new Texture(Gdx.files.internal("Assets/PlayAIButton.png"));
		PlayBackground = new Texture(Gdx.files.internal("Assets/PlayBackground.png"));
		VampireTxtr = new Texture(Gdx.files.internal("Assets/Cards/Dark/Creatures/vampireCard.png"));
		play = new Object(800,280,300,400,PlayButton);
		back = new Object(5, 920,300,100,BackButton);
		vampire = new Card(400,400, VampireTxtr, 4, 3, "Drain");
	}

	@Override
	public void dispose() {
		sr.dispose();
		background.dispose();
		PlayButton.dispose();
		carbon.dispose();
		PlayBackground.dispose();
		BackButton.dispose();
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void render() {
		update();
		draw(batch);
	}


	public void update() {
		vampire.ClikNDrag();
		if(Gdx.input.isTouched()) {
			if(Clicked(play) == true) {
				GameState = 1;
			}
			if (Clicked(back) == true) {
				GameState = 0;
			}
		}
	}
	public boolean Clicked(Object ob) {
		if (MouseX() < ob.getRight() && MouseX() > ob.getLeft()) {
			if(MouseY() < ob.getTop() && MouseY() > ob.getBottom()) {
				return true;
			}
		}
		return false;
	}
	public int MouseX() {
		return Gdx.input.getX();
	}
	public int MouseY() {
		return Gdx.graphics.getHeight() - Gdx.input.getY();
	}

	private void draw(SpriteBatch batch) {
		batch.begin();
		if (GameState == 1) {
			batch.draw(PlayBackground, 0,0, 1900,1080);
			back.draw(batch);
			vampire.draw(batch);
		}
		if (GameState == 0) {
			batch.draw(background, 0,0, 1900,1080);
			play.draw(batch);
		}
		
		batch.end();
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void resize(int arg0, int arg1) {
		
	}
	

	
	
}