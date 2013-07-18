package me.pagekite.glen3b.gjlib;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class TextSprite implements SimpleSprite {
	public BitmapFont font;
	public CharSequence text = "";
	public Vector2 position = Vector2.Zero;
	private List<UpdatedListener> mListenerList = new ArrayList<UpdatedListener>();
	
	public void centerTo(Vector2 position, Vector2 size){
		TextBounds bounds = font.getBounds(text);
		position = new Vector2(position.x + (size.x / 2 - bounds.width / 2), position.y + (size.y / 2 - bounds.height / 2));
	}
	
	public TextSprite(BitmapFont font){
		this.font = font;
	}
	
	public float getX(){
		return position.x;
	}
	
	public float getY(){
		return position.y;
	}
	
	public void setX(float value){
		position.x = value;
	}
	
	public void setY(float value){
		position.y = value;
	}	
	
	public void update(float deltaTime){
		
		for(UpdatedListener ul : mListenerList){
			ul.spriteUpdated(this, deltaTime);
		}
	}
	
	public void draw(SpriteBatch sb){
		font.draw(sb, text, getX(), getY());
	}

	@Override
	public void registerUpdatedListener(UpdatedListener listener) {
		if(listener != null){
			mListenerList.add(listener);
		}
	}

	@Override
	public void removeUpdatedListener(UpdatedListener listener) {
		if(listener != null){
			mListenerList.remove(listener);
		}
	}
}
