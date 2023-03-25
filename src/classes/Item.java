package classes;

import java.util.*;

import exceptions.MaximumInventoryException;

public class Item {
	private String type; //type = name
	private double amt_yo, progress_yo = 0.0;
	private int amountInInventory = 0;
	public boolean unlocked, available;
	protected static HashMap<String, Item> itemList = new HashMap<String, Item>();
	
	public Item(String t, int a) {
		type = t;
		amt_yo = a; 
		unlocked = false;
		available = false;
		itemList.put(type, this);
	} //make it so that when item is created upon game start, its automatically put in the inventory with amount 0

  public Item() {
    type = "Ball";
    amt_yo = 50;
    unlocked = true;
    available = true;
    itemList.put(type, this);
  } //instance of item that's unlocked by default
	
	public String getType() {
		return type;
	}
	public int getInventoryAmount() {
		return amountInInventory;
	}
	
	public void setAvailable() {
		if (!this.available) {
			available = true;
		}
	}
	
	public void setUnlocked() {
		if (!this.unlocked) {
			unlocked = true;
			itemList.get(this.getType()).setAvailable();
		}
	}
	
	public void addProgress(double yORate) {
		this.progress_yo += yORate;
		if (this.progress_yo >= this.amt_yo) { 
			// if not in inventory yet, add this to inventory with amount of 1
			// now instead of being put in inventory at declaration, they will only be put if there is >= 1 inventory amount
			if (!Player.getInventory().contains(this)) {
				try {
					Player.inventoryAdd(this);
				} catch (MaximumInventoryException e1) {
					System.out.println(e1.getMessage());
				}
			}
			
			this.amountInInventory += progress_yo / amt_yo;
			progress_yo = progress_yo % amt_yo; //sets the new progress to remainder
		}
	}
}