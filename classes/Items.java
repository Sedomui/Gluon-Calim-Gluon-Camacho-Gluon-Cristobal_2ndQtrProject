package classes;

import java.util.*;

public class Items {
	private String type;
	private int amt_yarn_over, identifier;
	public boolean unlocked, available;
	protected static HashMap<Integer, Items> itemList = new HashMap<Integer, Items>();
	
	public Items(String t, int a, int id) {
		type = t;
		identifier = id;
		amt_yarn_over = a; 
		unlocked = false;
		available = false;
		itemList.put(id, this);
	}
	
	public int getID() {
		return identifier;
	}
	
	public void setAvailable() {
		if (!this.available) {
			available = true;
		}
	}
	
	public void setBought() {
		if (!this.unlocked) {
			unlocked = true;
			itemList.get(this.getID()+1).setAvailable();
		}
	}
}
