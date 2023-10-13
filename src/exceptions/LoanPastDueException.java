package exceptions;

/**
 * Excepción lanzada cuando un User desea solicitar un préstamo, pero tiene 
 * uno vencido.
 * @author Jacobo-bc
 */
public class LoanPastDueException extends RuntimeException {
    public LoanPastDueException() {
        super("No se pudo solicitar el préstamo, tiene un préstamo vencido");
    }    
}
