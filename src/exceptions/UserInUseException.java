package exceptions;

/**
 *
 * @author Jacobo-bc
 */
public class UserInUseException extends RuntimeException {
    public UserInUseException() {
        super("Usuario en uso, intente con otro");
    }
}
