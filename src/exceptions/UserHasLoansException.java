package exceptions;

/**
 * Excepción lanzada cuando se desea eliminar un User, pero existen préstamos
 * asociados a el.
 * @author Jacobo-bc
 */
public class UserHasLoansException extends RuntimeException {
    public UserHasLoansException() {
        super("No se pudo eliminar el usuario porque actualmente tiene préstamos");
    }
}
