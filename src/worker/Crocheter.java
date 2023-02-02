package worker;

import java.util.ArrayList;

import classes.Item;
import classes.Upgrade;

public class Crocheter extends Worker {
	private String name, role;
	private double xp, YORate;
	private ArrayList<Upgrade> upgradesOnEffect = new ArrayList<Upgrade>();
	
	public Crocheter(String n, int s, int y) {
		super(n, s, "Crocheter");
		this.YORate = y;
	}
	
	public ArrayList<Upgrade> getUpgradesOnEffect() {
		return upgradesOnEffect;
	}
	
	public void crochet(Item e) {
		e.addProgress(YORate);
	}
	
	public void crocheterYarnOverRateUpgrade(boolean add, double crocheterEffect) {
		if (add) YORate += crocheterEffect;
		else if (!add) YORate *= crocheterEffect;
	}
}
