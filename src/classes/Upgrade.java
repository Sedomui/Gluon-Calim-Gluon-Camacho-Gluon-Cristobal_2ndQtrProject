package classes;

import java.util.ArrayList;
import java.util.Random;

import exceptions.CourierNotFoundException;
import exceptions.CrocheterNotFoundException;
import exceptions.UpgradeAlreadyMaxedException;
import exceptions.UpgradeAlreadyUsedException;
import worker.Courier;
import worker.Crocheter;

public class Upgrade {
	public Random random = new Random();
	private String name;
	private double effect;
 	private double playerEffect, crocheterEffect, courierEffect;
	private boolean global, add;
	private boolean courierGlobal, crocheterGlobal;
  	private int costYarnCoins, crAmtEffect, coAmtEffect;
	private int timesCanBeBought, effectReceiver; //if true its for player else its for crocheters

	private static ArrayList<Upgrade> upgradeList = new ArrayList<Upgrade>();
	
	public Upgrade(
		String name, 
		int cost_yarnCoins, 
		int eR, 
		double ef, 
		boolean gl, 
		boolean add, 
		int tcbb
	) {
		this.name = name;
		this.costYarnCoins = cost_yarnCoins;
    	this.timesCanBeBought = tcbb;

		switch(eR) {
		case 1:
			this.playerEffect = ef;
			this.add = add;
			break;
		case 2:
			this.crocheterEffect = ef;
			this.crocheterGlobal = gl;
			this.add = add;
			break;
		case 3:
			this.courierEffect = ef;
			this.courierGlobal = gl;
			this.add = add;
			break;
		}

		upgradeList.add(this);
	}

  public Upgrade(String n, int c, int cAE, int eR) {
    this.name = n;
    this.costYarnCoins = c;
    
    switch(eR) {
      case 1:
        this.crAmtEffect = cAE;
        break;
      case 2:
        this.coAmtEffect = cAE;
        break;
    }
  }

	public double getEffect() {
		return effect;
	}
  public double getPlayerEffect() {
    return playerEffect;
  }
  public double getCrocheterEffect() {
    return crocheterEffect;
  }
  public double getCourierEffect() {
    return courierEffect;
  }
  public boolean getCrocheterGlobal() {
    return crocheterGlobal;
  }
  public boolean getCourierGlobal() {
    return courierGlobal;
  }
  public int getCRAM() {
    return crAmtEffect;
  }
  public int getCROM() {
    return coAmtEffect;
  }
	public boolean getGlobal() {
		return global;
	}
	public boolean getAdd() {
		return add;
	}
	
	public void upgradeBought() throws UpgradeAlreadyMaxedException {
		if (timesCanBeBought >= 0) {
			Player.earnYC(costYarnCoins);
			try {
				this.effectUpgrade();
			} catch (UpgradeAlreadyUsedException e) {
				System.out.println(e.getMessage());
			}
			timesCanBeBought -= 1;
		} else {
			throw new UpgradeAlreadyMaxedException();
		}
	}
	
	public void effectUpgrade() throws UpgradeAlreadyUsedException {
		Player.clickUpgrade(add, effect);
		
		if (crocheterGlobal) {
			for (Crocheter i : Player.getPlayerCrocheters()) {
				if (i.getUpgradesOnEffect().contains(this)) {
					throw new UpgradeAlreadyUsedException();
				}
				else {
					i.crocheterYarnOverRateUpgrade(this.add, this.crocheterEffect);
				}
			}
		} else if (!crocheterGlobal) {
			try {
				Crocheter selectedCrocheter = Player.selectPlayerCrocheter();
				if (selectedCrocheter.getUpgradesOnEffect().contains(this)) {
					throw new UpgradeAlreadyUsedException();
				}
				else {
					selectedCrocheter.crocheterYarnOverRateUpgrade(this.add, this.crocheterEffect);
				}
			} catch (CrocheterNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
		
		if (courierGlobal) {
			for (Courier i : Player.getPlayerCourier()) {
				if (i.getUpgradesOnEffect().contains(this)) {
					throw new UpgradeAlreadyUsedException();
				}
				else {
					i.UpgradeDeliTime(this.add, this.courierEffect);
				}
			}
		} else if (!courierGlobal) {
			try {
				Courier selectedCourier = Player.selectPlayerCourier();
				if (selectedCourier.getUpgradesOnEffect().contains(this)) {
					throw new UpgradeAlreadyUsedException();
				}
				else {
					selectedCourier.UpgradeDeliTime(this.add, this.courierEffect);
				}
			} catch (CourierNotFoundException e) {
				System.out.println(e.getMessage());
			}	
		}
		
		if (Player.getUpgradeInEffect().contains(this)) {
			throw new UpgradeAlreadyUsedException();
		} else if (!Player.getUpgradeInEffect().contains(this)) {
			Player.addAmountCouriers(coAmtEffect);
			Player.addAmountCrocheters(crAmtEffect);
		}
	}
}
