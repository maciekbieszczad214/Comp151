/**
 * A class that implements a piggy bank full exception.
 *
 * @author Anna Bieszczad
 * @version 08/22/2016
 */
public class PiggyBankEmptyException  extends RuntimeException
{

    /**
     * Constructor for objects of class PiggyBankEmptyException
     */
    public PiggyBankEmptyException(String reason)
    {
        super(reason);
    }
}
