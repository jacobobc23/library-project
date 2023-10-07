package exceptions;

/**
 * Excepción lanzada cuando se intenta registrar un User que ya está en la 
 * base de datos.
 * @author Jacobo-bc
 */
public class UserAlreadyRegisteredException extends RuntimeException {
    public UserAlreadyRegisteredException() {
        super ("El usuario ya se encuentra registrado");
    }
}
