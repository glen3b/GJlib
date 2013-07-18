package me.pagekite.glen3b.gjlib;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class ExtendedLabel extends Label implements SimpleSprite {

	public boolean mouseIntersects(){
		Vector2 realPos = new Vector2(getX(), Utilities.convertToWorldCoordinate(getY()));
		Vector2 mousePos = new Vector2(Gdx.input.getX(), Gdx.input.getY());
		return mousePos.x >= realPos.x && mousePos.x <= realPos.x+(getWidth()*getScaleX()) && mousePos.y <= realPos.y && mousePos.y >= realPos.y-(getHeight()*getScaleY());
	}
	
	public ExtendedLabel(CharSequence text, Skin skin, String fontName,
			String colorName) {
		super(text, skin, fontName, colorName);
	}

	public ExtendedLabel(CharSequence text, Skin skin, String fontName,
			Color color) {
		super(text, skin, fontName, color);
	}

	public ExtendedLabel(CharSequence text, Skin skin, String styleName) {
		super(text, skin, styleName);
	}

	public ExtendedLabel(CharSequence text, Skin skin) {
		super(text, skin);
	}

	public ExtendedLabel(CharSequence text, LabelStyle style) {
		super(text, style);
	}

	@Override
	public void draw(SpriteBatch drawTarget) {
		this.draw(drawTarget, 1.0f);
		
	}

	@Override
	public void registerUpdatedListener(UpdatedListener listener) {
		if(listener != null){
			mListenerList.add(listener);
		}
	}

	private List<UpdatedListener> mListenerList = new ArrayList<UpdatedListener>();

	public class MouseHoverParams{
		public boolean doMouseHovering = false;
		public Color nonHoverColor;
		public Color hoverColor;
	}
	
	public MouseHoverParams hoverParameters = new MouseHoverParams();
	
	@Override
	public void update(float deltaTime) {
		if(hoverParameters != null && hoverParameters.doMouseHovering){
			setColor(mouseIntersects() ? hoverParameters.hoverColor : hoverParameters.nonHoverColor);
		}
		
		for(UpdatedListener listen : mListenerList){
			listen.spriteUpdated(this, deltaTime);
		}
	}

	@Override
	public void removeUpdatedListener(UpdatedListener listener) {
		if(listener != null){
			mListenerList.remove(listener);
		}
	}

}
