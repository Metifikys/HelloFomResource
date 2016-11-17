package metifikys;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.Assert.*;

/**
 * Created by Metifikys on 2016-11-16.
 */
public class HelloFomResourceTest
{
    @Test
    public void testMessageRuByTime() throws Exception
    {
        Locale.setDefault(Locale.UK);
        ResourceBundle labels = ResourceBundle.getBundle("Message", Locale.getDefault());

        Calendar instance = Calendar.getInstance();

        HelloFomResource fomResource = new HelloFomResource();

        instance.set(Calendar.HOUR_OF_DAY, 8);
        assertEquals(
                fomResource.getGreeting(instance), labels.getString(Period.MORNING.toString())
        );

        instance.set(Calendar.HOUR_OF_DAY, 10);
        assertEquals(
                fomResource.getGreeting(instance), labels.getString(Period.DAY.toString())
        );

        instance.set(Calendar.HOUR_OF_DAY, 20);
        assertEquals(
                fomResource.getGreeting(instance), labels.getString(Period.EVENING.toString())
        );

        instance.set(Calendar.HOUR_OF_DAY, 0);
        assertEquals(
                fomResource.getGreeting(instance), labels.getString(Period.NIGHT.toString())
        );
    }
}