package me.pagekite.glen3b.gjlib;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SpriteManager implements Collection<SimpleSprite> {
	private List<SimpleSprite> mSpriteList = new ArrayList<SimpleSprite>();
	
	public SimpleSprite get(int index){
		return mSpriteList.get(index);
	}
	
	public void update(){
		float deltaTime = Gdx.graphics.getDeltaTime();
		for(SimpleSprite es : mSpriteList){
			es.update(deltaTime);
		}
	}
	
	public boolean autoSpriteBatchManage = false;
	
	public void drawAll(SpriteBatch drawTarget){
		if(autoSpriteBatchManage){
			drawTarget.begin();
		}
		for(SimpleSprite s : mSpriteList){
			s.draw(drawTarget);
		}
		if(autoSpriteBatchManage){
			drawTarget.end();
		}
	}

	@Override
	public boolean add(SimpleSprite arg0) {
		return mSpriteList.add(arg0);
	}

	@Override
	public boolean addAll(Collection<? extends SimpleSprite> arg0) {
		return mSpriteList.addAll(arg0);
	}

	@Override
	public void clear() {
		mSpriteList.clear();
	}

	@Override
	public boolean contains(Object arg0) {
		return mSpriteList.contains(arg0);
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		return mSpriteList.containsAll(arg0);
	}

	@Override
	public boolean isEmpty() {
		return mSpriteList.isEmpty();
	}

	@Override
	public Iterator<SimpleSprite> iterator() {
		return mSpriteList.iterator();
	}

	@Override
	public boolean remove(Object arg0) {
		return mSpriteList.remove(arg0);
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		return mSpriteList.removeAll(arg0);
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		return mSpriteList.retainAll(arg0);
	}

	@Override
	public int size() {
		return mSpriteList.size();
	}

	@Override
	public Object[] toArray() {
		return mSpriteList.toArray();
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		return mSpriteList.toArray(arg0);
	}
}
