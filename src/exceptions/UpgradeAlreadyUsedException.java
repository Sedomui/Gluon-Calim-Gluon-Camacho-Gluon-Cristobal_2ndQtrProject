package exceptions;

public class UpgradeAlreadyUsedException extends Exception {
	public UpgradeAlreadyUsedException() {
		super("This Upgrade is already in effect");
	}
}
