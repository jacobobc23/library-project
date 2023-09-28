package exceptions;

/**
 * Excepción lanzada cuando al registrar un User, se encuentra un registro con 
 * un número de télefono en especifico.
 * @author Jacobo-bc
 */
public class MobileNumberAlreadyInUseException extends RuntimeException {
    public MobileNumberAlreadyInUseException() {
        super("Télefono en uso");
    }
}
