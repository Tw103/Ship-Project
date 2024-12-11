// Te'Variyae Woods 


	public class TimeException extends Exception {
    // Default constructor
    public TimeException() {
        super("EXCEPTION: Invalid time entered");
    }

    // Parameterized constructor
    public TimeException(String message) {
        super(message);
    }
}