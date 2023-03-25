package worker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import classes.Order;
import classes.Upgrade;
import exceptions.CourierNotFoundException;

public class Courier extends Worker {
	private String name, role; 
	private double deliTime;
	
	private ArrayList<Upgrade> upgradesOnEffect = new ArrayList<Upgrade>(); 
	
	private static Scanner input = new Scanner(System.in);
	
	public Courier(String n, int s, int g, int d) {
		super(n, s, "Courier");
		this.deliTime = d;
		this.name = n;
	}
	
	public ArrayList<Upgrade> getUpgradesOnEffect() {
		return upgradesOnEffect;
	}

	public void UpgradeDeliTime(boolean courierAdd, double e) {
		if (courierAdd) {
			deliTime -= e;
		}
		else if (!courierAdd) {
			deliTime /= e;
		}
	}
}

