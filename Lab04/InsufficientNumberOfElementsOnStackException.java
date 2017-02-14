package Lab04;

/**
 * A class that implements a stack empty exception.
 *
 * @author Anna Bieszczad
 * @version 02/14/2016
 */
public class InsufficientNumberOfElementsOnStackException extends RuntimeException
{
    public InsufficientNumberOfElementsOnStackException(String reason)
    {
        super(reason);
    }
}
