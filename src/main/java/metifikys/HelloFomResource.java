package metifikys;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Metifikys on 2016-11-16.
 */
public class HelloFomResource
{
    private static final Logger LOGGER =
                LogManager.getLogger(new Object(){}.getClass().getEnclosingClass().getName());

    private HelloFomResource() {}

    public static HelloFomResource of() {return new HelloFomResource();}

    public String getGreeting()
    {
        return getGreeting(Calendar.getInstance());
    }

    public String getGreeting(Calendar calendar)
    {
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);

        Period period = getPeriod(hourOfDay);

        return getMessageForPeriod(period);
    }

    private Period getPeriod(int hourOfDay)
    {
        Period period;

        if (6 <= hourOfDay && hourOfDay < 9)
        {
            period = Period.MORNING;
        }
        else if (9 <= hourOfDay && hourOfDay < 19)
        {
            period = Period.DAY;
        }
        else if (19 <= hourOfDay && hourOfDay < 23)
        {
            period = Period.EVENING;
        }
        else
        {
            period = Period.NIGHT;
        }

        LOGGER.info("detected period {}, hour {}", period, hourOfDay);

        return period;
    }

    private String getMessageForPeriod(Period period)
    {
        ResourceBundle labels = ResourceBundle.getBundle("Message", Locale.getDefault());

        return labels.getString(period.toString());
    }
}