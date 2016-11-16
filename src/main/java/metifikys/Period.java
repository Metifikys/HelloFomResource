package metifikys;

/**
 * Created by Metifikys on 2016-11-16.
 */
public enum Period
{
    MORNING("MORNING"),
    DAY("DAY"),
    EVENING("EVENING"),
    NIGHT("NIGHT")
    ;

    private final String text;

    Period(String text)
    {
        this.text = text;
    }


    @Override
    public String toString()
    {
        return text;
    }
}