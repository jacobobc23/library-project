package exceptions;

/**
 *
 * @author Jacobo-bc
 */
public class LoanPastDueException extends RuntimeException {
    public LoanPastDueException() {
        super("No se pudo solicitar el préstamo, tiene un préstamo vencido");
    }    
}
