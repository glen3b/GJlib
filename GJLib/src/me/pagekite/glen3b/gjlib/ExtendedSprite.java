package me.pagekite.glen3b.gjlib;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class ExtendedSprite extends Sprite implements SimpleSprite, Updatable, Drawable {

	public Vector2 getLocation(){
		return new Vector2(getX(), getY());
	}
	
	public float xSpeed = 0;
	public float ySpeed = 0;
	
	private List<UpdatedListener> mListenerList = new ArrayList<UpdatedListener>();
	
	public void registerUpdatedListener(UpdatedListener listener){
		if(listener != null){
			mListenerList.add(listener);
		}
	}
	
	public void removeUpdatedListener(UpdatedListener listener){
		if(listener != null){
			mListenerList.remove(listener);
		}
	}
	
	public void update(float deltaTime){
		setX(getX()+xSpeed);
		setY(getY()+ySpeed);
		
		for(UpdatedListener listen : mListenerList){
			listen.spriteUpdated(this, deltaTime);
		}
	}
	
	public void setLocation(Vector2 newLocation){
		setX(newLocation.x);
		setY(newLocation.y);
	}
	
	public Vector2 getScale(){
		return new Vector2(getScaleX(), getScaleY());
	}
	
	public void setScale(Vector2 newScale){
		this.setScale(newScale.x, newScale.y);
	}
	
	public Vector2 getScaledSize(){
		return Utilities.multiply(getSize(), getScale());
	}
	
	public ExtendedSprite(Texture texture){
		super(texture);
	}
	
	public ExtendedSprite(Texture texture, RectangleInt region){
		super(new TextureRegion(texture, region.x, region.y, region.width, region.height));
	}
	
	public ExtendedSprite(TextureRegion region){
		super(region);
	}
	
	public Vector2 getSize(){
		return new Vector2(this.getWidth(), this.getHeight());
	}
	
	public float getScaledWidth(){
		return getScaledSize().x;
	}
	
	public float getScaledHeight(){
		return getScaledSize().y;
	}

}
