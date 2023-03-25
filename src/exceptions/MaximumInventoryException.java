package exceptions;

public class MaximumInventoryException extends Exception {
	public MaximumInventoryException( ) {
		super("Inventory size limit reached");
	}
}
