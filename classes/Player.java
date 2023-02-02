package classes;

import java.util.*;

import exceptions.CourierNotFoundException;
import exceptions.CrocheterNotFoundException;
import exceptions.MaximumInventoryException;
import exceptions.MaximumCourierException;
import exceptions.MaximumCrochetersException;
import exceptions.NotEnoughMoneyException;
import worker.Courier;
import worker.Crocheter;

public class Player implements Checkable{
	public static Scanner input = new Scanner(System.in);
	private static double yarn_coins, total_coins = 0.0;
	private static int total_clicks = 0;
	private static double yoPerClick = 1.0;
	private static String name = "";
	private static int  inventorySizeLimit = 24;
	private static int amountCrocheters = 6;
	private static int amountCouriers = 3;
	
	private static ArrayList<Item> inventory = new ArrayList<Item>();
	
	private static ArrayList<Crocheter> playerCrocheters = new ArrayList<Crocheter>();
	
	//temporary hashmap for choosing crocheter until we learn how do choosing of crocheter by clicking instead
	private static HashMap<String, Crocheter> accessPlayerCrocheter = new HashMap<String, Crocheter>();
	
	private static ArrayList<Courier> playerCouriers = new ArrayList<Courier>();
	
	//temporary hashmap for choosing courier until we learn how do choosing of crocheter by clicking instead
	private static HashMap<String, Courier> accessPlayerCourier = new HashMap<String, Courier>();
	
	private static ArrayList<Item> selectedItems = new ArrayList<Item>();
	
	private static ArrayList<Order> orderList  = new ArrayList<Order>();
	
	private static ArrayList<Upgrade> upgradeInEffect = new ArrayList<Upgrade>(); 
	
	@Override public void Diagnostics() {
		// print total clicks and coins, yarn_coins, and everything in inventory
	}
	
	public static ArrayList<Item> getInventory() {
		return inventory;
	}
	public static ArrayList<Crocheter> getPlayerCrocheters() {
		return playerCrocheters;
	}
 	public static ArrayList<Courier> getPlayerCourier() {
		return playerCouriers;
	}
 	public static int getAmountCrocheters() {
 		return amountCrocheters;
 	}
 	public static int getAmountCouriers() {
 		return amountCouriers;
 	}
 	public static ArrayList<Upgrade> getUpgradeInEffect() {
 		return upgradeInEffect;
 	}
 	
 	//temporary method for selecting courier until we learned how to do it with clicking instead
 	public static Courier selectPlayerCourier() throws CourierNotFoundException {
 		String selectCourierName = input.nextLine();
 		Courier selectedCourier = accessPlayerCourier.get(selectCourierName);
 		
 		if (selectedCourier == null) {
 			throw new CourierNotFoundException();
 		}
 		else {
 			return selectedCourier;
 		}
 	}
 	
 	//temporary method for selecting crocheter until we learned how to do it with clicking instead
 	public static Crocheter selectPlayerCrocheter() throws CrocheterNotFoundException {
 		String selectCrocheterName = input.nextLine();
 		Crocheter selectedCrocheter = accessPlayerCrocheter.get(selectCrocheterName);
 		
 		if (selectedCrocheter == null) {
 			throw new CrocheterNotFoundException();
 		}
 		else {
 			return selectedCrocheter;
 		}
 	}
 	
 	public static void inventoryAdd(Item e) throws MaximumInventoryException {
 		if (inventory.size() == inventorySizeLimit) {
 			throw new MaximumInventoryException();
 		}
 		else {
 			inventory.add(e);
 		}
 	}
 	
	public static void clicked() {
		Player.total_clicks += 1;
		Order.rollOrder();				
	}
	
	public static void clickUpgrade(boolean add, double playerEffect) {
		if (add) yoPerClick += playerEffect;
		else if (!add) yoPerClick *= playerEffect;
	}
	
	public static void paySalary(int p) throws NotEnoughMoneyException {
		if (yarn_coins >= p) yarn_coins -= p;
		else throw new NotEnoughMoneyException();
	}
	
	public static void addCrocheters(Crocheter e) throws MaximumCrochetersException {
		if (playerCrocheters.size() == amountCrocheters) throw new MaximumCrochetersException();
		else playerCrocheters.add(e);
	}
	
	public static void addCourier(Courier e) throws MaximumCourierException {
		if (playerCouriers.size() >= amountCouriers) throw new MaximumCourierException();
		else playerCouriers.add(e);
	}
	public static void giveOrder(Order e) {
		orderList.add(e);
	}
	
	public static void earnYC(double yc_reward) {
		yarn_coins += yc_reward;
	}
	public static void addAmountCrocheters(int e) {
		amountCrocheters += e;
	}
	public static void addAmountCouriers(int e) {
		amountCouriers += e;
	}
}