package exceptions;

/**
 * Excepción lanzada cuando se intenta registrar un Book que ya está en la 
 * base de datos. 
 * @author Jacobo-bc
 */
public class BookAlreadyRegisteredException extends RuntimeException {
    public BookAlreadyRegisteredException() {
        super("El libro ya se encuentra registrado");
    }
}
