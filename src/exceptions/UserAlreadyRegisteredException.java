package exceptions;

/**
 *
 * @author Jacobo-bc
 */
public class UserAlreadyRegisteredException extends RuntimeException {
    public UserAlreadyRegisteredException() {
        super ("EL USUARIO YA ESTÁ REGISTRADO");
    }
}
