package com.LykoS.Novellus;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
public class GameLauncher {
	public static void main(String[] args) {
		new LwjglApplication(new novellus(),"Novellus", 1900,1080);
	}
}