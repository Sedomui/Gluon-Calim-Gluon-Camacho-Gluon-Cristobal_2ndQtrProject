package exceptions;

public class NotEnoughMoneyException extends Exception {
	public NotEnoughMoneyException() {
		super("You don't have enough money ot buy this");
	}
}
