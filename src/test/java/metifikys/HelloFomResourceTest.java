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
    private static final Logger LOGGER =
                LogManager.getLogger(new Object(){}.getClass().getEnclosingClass().getName());


    @org.junit.Test
    public void testGetGreetingNotEmptyRU() throws Exception
    {
        Locale.setDefault(new Locale("ru"));

        String greeting = HelloFomResource.of().getGreeting();

        assertNotNull("return resurse is null", greeting);
        assertNotEquals("", greeting);

        LOGGER.trace(greeting);
    }

    @org.junit.Test
    public void testGetGreetingNotEmptyUK() throws Exception
    {
        String greeting = HelloFomResource.of().getGreeting();

        assertNotNull("return resurse is null", greeting);
        assertNotEquals("", greeting);

        LOGGER.trace(greeting);
    }

    @Test
    public void testMessageRuByTime() throws Exception
    {
        Locale.setDefault(Locale.UK);
        ResourceBundle labels = ResourceBundle.getBundle("Message", Locale.getDefault());

        Calendar instance = Calendar.getInstance();

        HelloFomResource fomResource = HelloFomResource.of();

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