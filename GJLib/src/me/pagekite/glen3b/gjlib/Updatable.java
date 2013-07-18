package me.pagekite.glen3b.gjlib;

public interface Updatable {
	public void registerUpdatedListener(UpdatedListener listener);
	
	public void update(float deltaTime);
	
	public void removeUpdatedListener(UpdatedListener listener);
}
