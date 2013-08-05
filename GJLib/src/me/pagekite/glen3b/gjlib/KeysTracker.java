package me.pagekite.glen3b.gjlib;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.InputProcessor;

/**
 * An InputProcessor tracking keys currently down and up.
 * @author Glen Husman
 * @see InputProcessor
 */
public class KeysTracker implements InputProcessor {

	@Override
	public boolean keyDown(int key) {
		if(!mPressedKeys.contains(key)){
			mPressedKeys.add(key);
		}
		return false;
	}

	
	private List<Integer> mPressedKeys = new ArrayList<Integer>();
	
	public List<Integer> getPressedKeys(){
		return mPressedKeys;
	}
	
	
	/**
	 * A string representing all characters typed over the course of the game.
	 */
	public String typed = "";
	
	@Override
	public boolean keyTyped(char arg0) {
		typed += arg0;
		return false;
	}

	@Override
	public boolean keyUp(int arg0) {
		mPressedKeys.remove(arg0);
		return false;
	}

	//
	//All methods below are irrelevant, they return false, and are mouse related (this is a keyboard class)
	//
	
	@Override
	public boolean mouseMoved(int arg0, int arg1) {
		return false;
	}

	@Override
	public boolean scrolled(int arg0) {
		return false;
	}

	@Override
	public boolean touchDown(int arg0, int arg1, int arg2, int arg3) {
		return false;
	}

	@Override
	public boolean touchDragged(int arg0, int arg1, int arg2) {
		return false;
	}

	@Override
	public boolean touchUp(int arg0, int arg1, int arg2, int arg3) {
		return false;
	}

}
