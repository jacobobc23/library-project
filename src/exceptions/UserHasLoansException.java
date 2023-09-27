package exceptions;

/**
 *
 * @author Jacobo-bc
 */
public class UserHasLoansException extends RuntimeException {
    public UserHasLoansException() {
        super("No se pudo eliminar el usuario porque actualmente tiene préstamos");
    }
}
