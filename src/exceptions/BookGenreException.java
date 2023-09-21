package exceptions;

/**
 *
 * @author Jacobo-bc
 */
public class BookGenreException extends RuntimeException {
    public BookGenreException() {
        super ("No se puede eliminar el género porque hay libros asociados a el.");
    }
}
