package project;

import java.util.List;

public interface BaseObject{
	public Scene getScene();
	public String getTag();
	public void setTag(String tag);
	public List<Script> getScripts();
	public Transform getTransform();
}
