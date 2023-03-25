package exceptions;

public class UpgradeAlreadyMaxedException extends Exception {
	public UpgradeAlreadyMaxedException() {
		super("This Upgrades has already been maxed");
	}
}
