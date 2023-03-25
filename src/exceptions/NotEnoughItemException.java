package exceptions;

import classes.Item;

public class NotEnoughItemException extends Exception {
	public NotEnoughItemException(Item e) {
		super("You");
	}
}
