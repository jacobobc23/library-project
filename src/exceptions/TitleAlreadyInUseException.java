package exceptions;


/**
 *
 * @author Jacobo-bc
 */
public class TitleAlreadyInUseException extends RuntimeException {
    public TitleAlreadyInUseException() {
        super ("TITULO YA EN USO");
    }
}
