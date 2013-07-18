package me.pagekite.glen3b.gjlib;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Utilities {
	
	private Utilities(){
		
	}
	
	public static Color xnaColorToOpenGlColor(float r, float g, float b, float a){
		return new Color(r/255f, g/255f, b/255f, a/255f);
	}
	
	public static Vector2 createVector(float value){
		return new Vector2(value,value);
	}
	
	/**
	 * Converts the specified Y coordinate to a SpriteBatch Y coordinate.
	 * @param yCoord The screen Y coordinate.
	 * @return The world Y coordinate.
	 */
	public static float convertToSpriteBatchCoordinate(float yCoord){
		return Gdx.graphics.getHeight()-yCoord;
	}
	
	public static float convertToWorldCoordinate(float sbYCoord){
		return Gdx.graphics.getHeight()-sbYCoord;
	}
	
	/**
	 * Converts the specified coordinates to SpriteBatch coordinates.
	 * @param coord The screen coordinates.
	 * @return The world coordinates.
	 */
	public static Vector2 convertToSpriteBatchCoordinate(Vector2 coord){
		return new Vector2(coord.x, Gdx.graphics.getHeight()-coord.y);
	}
	
	public static Vector2 multiply(Vector2 inOne, Vector2 inTwo){
		return new Vector2(inOne.x*inTwo.x, inOne.y*inTwo.y);
	}
	
	public static Vector2 add(Vector2 inOne, Vector2 inTwo){
		return new Vector2(inOne.x+inTwo.x, inOne.y+inTwo.y);
	}
}
