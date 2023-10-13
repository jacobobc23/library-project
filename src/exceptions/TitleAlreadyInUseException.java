package exceptions;


/**
 * Excepción lanzada cuando al registar un Book, se encuentra un registro con 
 * un título en especifico.
 * @author Jacobo-bc
 */
public class TitleAlreadyInUseException extends RuntimeException {
    public TitleAlreadyInUseException() {
        super ("Título ya en uso");
    }
}
