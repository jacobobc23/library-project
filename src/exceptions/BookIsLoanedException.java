package exceptions;

/**
 *
 * @author Jacobo-bc
 */
public class BookIsLoanedException extends RuntimeException {
    public BookIsLoanedException() {
        super("No se puede eliminar el libro porque actualmente se encuentra en préstamo");
    }
}
