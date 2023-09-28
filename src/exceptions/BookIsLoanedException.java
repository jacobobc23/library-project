package exceptions;

/**
 * Excepción lanzada cuando se desea eliminar un libro y este se encuentra en 
 * préstamo
 * @author Jacobo-bc
 */
public class BookIsLoanedException extends RuntimeException {
    public BookIsLoanedException() {
        super("No se puede eliminar el libro porque actualmente se encuentra en préstamo");
    }
}
