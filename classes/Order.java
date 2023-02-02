package classes;

import java.util.*;

public class Order implements Checkable {
	private Item request;
	private int requestNo, yc_reward;
	private String orderMessage;
	private boolean completed;
	private static ArrayList<Order> orderList = new ArrayList<Order>();
	
	static Random random = new Random();
	
	public Order(Item i, int amt, int rew, String msg) {
		this.request = i;
		this.requestNo = amt;
    this.yc_reward = rew;
		this.orderMessage = msg;
		this.completed = true;
		orderList.add(this);
	}
	
	public static void rollOrder() {
		if (random.nextInt(500) == 1) {
			Order e = orderList.get(random.nextInt(orderList.size()));
			Player.giveOrder(e);
			e.completed = false;
			//this looks atrocious holy
		}
	}
	
	public void completeOrder(Order e) {
		if (e.request.getInventoryAmount() >= e.requestNo) {
			e.completed = true;
			Player.earnYC(e.yc_reward);
		}
	}

  public void Diagnostics() {
    System.out.printf("Request: %s%nRequest No: %d%nYarn Coin Reward: %d%nOrder Message: %s%n", request.getType(), requestNo, yc_reward, orderMessage);
  }
}
