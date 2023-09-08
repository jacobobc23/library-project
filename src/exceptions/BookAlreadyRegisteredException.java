package exceptions;

/**
 *
 * @author Jacobo-bc
 */
public class BookAlreadyRegisteredException extends RuntimeException {
    public BookAlreadyRegisteredException() {
        super("EL LIBRO YA ESTÁ REGISTRADO");
    }
}
