package exceptions;

/**
 * Excepción lanzada cuando un User intenta ingresar al sistema pero sus 
 * credenciales son incorrectas.
 * @author Jacobo-bc
 */
public class CredentialsException extends RuntimeException {
    public CredentialsException() {
        super("Credenciales incorrectas");
    }
}
