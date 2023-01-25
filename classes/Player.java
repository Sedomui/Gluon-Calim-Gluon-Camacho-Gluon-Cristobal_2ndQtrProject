package classes;

import java.util.*;

import exceptions.MaximumCrochetersException;
import exceptions.NotEnoughMoneyException;

public class Player implements Checkable{
	private static int yarn_coins, total_coins, total_clicks= 0;
	private static String name = "";
	private static HashMap<String,Integer> inventory = new HashMap<String,Integer>();
	private static ArrayList<Crocheter> currentWorkers = new ArrayList<Crocheter>();
	private static ArrayList<Items> selectedItems = new ArrayList<Items>();
	
	@Override public void Diagnostics() {
		// print total clicks and coins, yarn_coins, and everything in inventory
	}
	
	public static void paySalary(int p) throws NotEnoughMoneyException{
		if (yarn_coins >= p) {
			yarn_coins -= p;
		}
		else {
			throw new NotEnoughMoneyException();
		}
	}
	
	public static void addCrocheters(Crocheter e) throws MaximumCrochetersException {
		if (currentWorkers.size() == 6) {
			throw new MaximumCrochetersException();
		}
		else {
			currentWorkers.add(e);
		}
	}

}
