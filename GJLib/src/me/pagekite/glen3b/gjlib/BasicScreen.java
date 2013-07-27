package me.pagekite.glen3b.gjlib;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BasicScreen implements Screen {

	private SpriteManager mAllSprites;
	private SpriteBatch mTarget;
	
	public SpriteManager getAllSprites(){
		return mAllSprites;
	}
	
	public SpriteBatch getTarget(){
		return mTarget;
	}
	
	public BasicScreen(SpriteManager allSprites, SpriteBatch target){
		mAllSprites = allSprites;
		mTarget = target;
	}
	
	public boolean disposeBatch = false;
	
	@Override
	public void dispose() {
		for(SimpleSprite s : this.getAllSprites()){
			s.dispose();
		}
		if(this.disposeBatch){
			this.getTarget().dispose();
		}
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}
	
	public void update(float deltaTime){
		getAllSprites().update(deltaTime);
	}
	
	public void draw(){
		getAllSprites().drawAll(getTarget());
	}
	
	@Override
	public void render(float deltaTime) {
		update(deltaTime);
		draw();
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

}
