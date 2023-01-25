package classes;

import exceptions.NotEnoughMoneyException;

abstract public class Worker {
	protected static String id;
	protected static int salary;
	
	public void getSalary() {
		try {
			Player.paySalary(salary);
		} 
		catch (NotEnoughMoneyException e) {
			System.out.println(e.getMessage());
		}
	}
}
