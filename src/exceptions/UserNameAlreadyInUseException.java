package exceptions;

/**
 * Excepción lanzada cuando al registrar un User, se encuentra un registro con 
 * un username en especifico.
 * @author Jacobo-bc
 */
public class UserNameAlreadyInUseException extends RuntimeException {
    public UserNameAlreadyInUseException() {
        super ("Usuario en uso");
    }
}
