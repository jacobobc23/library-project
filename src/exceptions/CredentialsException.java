package exceptions;

/**
 *
 * @author Jacobo-bc
 */
public class CredentialsException extends RuntimeException {
    public CredentialsException() {
        super("Credenciales incorrectas");
    }
}
