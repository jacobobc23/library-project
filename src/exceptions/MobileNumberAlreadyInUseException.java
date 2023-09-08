package exceptions;

/**
 *
 * @author Jacobo-bc
 */
public class MobileNumberAlreadyInUseException extends RuntimeException {
    public MobileNumberAlreadyInUseException() {
        super("TELÉFONO EN USO");
    }
}
