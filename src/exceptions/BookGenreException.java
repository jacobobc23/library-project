package exceptions;

/**
 * Excepción lanzada cuando se intenta eliminar un género y existen libros
 * registrados con ese género.
 * @author Jacobo-bc
 */
public class BookGenreException extends RuntimeException {
    public BookGenreException() {
        super ("No se puede eliminar el género porque hay libros asociados a el.");
    }
}
