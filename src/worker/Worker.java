package worker;

import classes.Item;

import classes.Player;
import classes.Checkable;
import exceptions.*;
import java.util.*;


abstract public class Worker implements Checkable {
	protected String id, role;
	protected int salary, cost, level;
  protected int xp;

  private ArrayList<Worker> workerList = new ArrayList<Worker>();

	public Worker(String n, int s, String r) {
		this.id = n;
		this.salary = s;
    this.role = r;
    this.xp = 0;
    this.level = 0;

    workerList.add(this);
	}
  
	public void getSalary() {
    int totalSalaryPaid = 0;
    
		try {
      for(Worker w : workerList) {
        Player.paySalary(w.salary);
        totalSalaryPaid += w.salary;
      }
		} catch (NotEnoughMoneyException e) {
			System.out.println(e.getMessage());
		} finally {
      for(Worker w : workerList) {
        w.xp += totalSalaryPaid/workerList.size();

        if(w.xp >= 100) {
          w.xp = 0;
          w.level++;
          w.salary += (1/w.level) + w.salary;
      }
    }
	}
	
	public void Diagnostics() {
		System.out.printf("Salary: %d%nExperience: %d%nLevel: %d%n", this.salary, this.xp, this.level);
	}

  public int getXP() {
    return xp;
  }
  public int getLevel() {
    return level;
  }
  public int returnsalary() {
    return salary;
  }

}
