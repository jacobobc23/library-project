package exceptions;

/**
 *
 * @author Jacobo-bc
 */
public class InsufficientCopiesException extends RuntimeException {
    public InsufficientCopiesException() {
        super("No hay la cantidad suficiente de copias.");
    } 
}
