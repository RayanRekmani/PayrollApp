//
// Assignment 2
// Written by: Rayan Rekmani 40283058
//

public class MinimumWageException extends Exception {

    public MinimumWageException() {
        super("This hourly wage falls below the legal limit of $15.75.");
    }

    public MinimumWageException(String message) {
        super(message);
    }
    
}
