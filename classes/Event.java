package classes;

import java.util.ArrayList;
import java.util.Random;

import worker.Courier;
import worker.Crocheter;

public class Event {
	public static Random random = new Random();
	private String name, eventMsg; 
	private double playerEffect, crocheterEffect, courierEffect;
	private boolean crocheterGlobal, courierGlobal, playerAdd, crocheterAdd, courierAdd;
	private static ArrayList<Event> eventPool = new ArrayList<Event>(); 
	
	public Event(String n, String msg, int plEf, int crEf, int coEf, boolean plAdd, boolean crAdd, boolean coAdd ) {
		this.name = n;
		this.eventMsg = msg;
		this.playerEffect = plEf;
		this.crocheterEffect = crEf;
		this.courierEffect = coEf;
		this.playerAdd = plAdd;
		this.crocheterAdd = crAdd;
		this.courierAdd = coAdd;

    eventPool.add(this);
	}
	public static void eventRoll() {
		int index = random.nextInt(eventPool.size());
		
	}
	public void eventTrigger() {
		Player.clickUpgrade(playerAdd, playerEffect);
		
		if (crocheterGlobal) {
			for (Crocheter i : Player.getPlayerCrocheters()) {
				i.crocheterYarnOverRateUpgrade(crocheterAdd, crocheterEffect);
			}
		} else if (!crocheterGlobal) {
			int randomIndex = random.nextInt(Player.getPlayerCrocheters().size());
			Player.getPlayerCrocheters().get(randomIndex).crocheterYarnOverRateUpgrade(crocheterAdd, crocheterEffect);	
		}
		
		if (courierGlobal) {
			for (Courier i : Player.getPlayerCourier()) {
				i.UpgradeDeliTime(courierAdd, courierEffect);
			}
		} else if (!courierGlobal) {
			int randomIndex = random.nextInt(Player.getPlayerCourier().size());
			Player.getPlayerCourier().get(randomIndex).UpgradeDeliTime(courierAdd, randomIndex);	
		}	
	}
}

