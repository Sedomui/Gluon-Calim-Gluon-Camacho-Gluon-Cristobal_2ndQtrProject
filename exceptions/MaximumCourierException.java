package exceptions;

public class MaximumCourierException extends Exception {	
	public MaximumCourierException() {
		super("Maximum amount of Couriers reached");
	}
}
