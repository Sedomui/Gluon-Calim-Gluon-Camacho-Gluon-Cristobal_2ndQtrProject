package exceptions;

public class MaxItemSelectedException extends Exception{
    public MaxItemSelectedException() {
        super("Limit of selected items is reached");
    }
}
