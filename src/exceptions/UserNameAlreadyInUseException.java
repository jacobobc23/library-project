package exceptions;

/**
 *
 * @author Jacobo-bc
 */
public class UserNameAlreadyInUseException extends RuntimeException {
    public UserNameAlreadyInUseException() {
        super ("USUARIO EN USO");
    }
}
