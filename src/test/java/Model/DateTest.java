package Model;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class DateTest extends TestCase {
    private Date date;
    private final String day = "thursday";
    private final int startHour = 10;
    private final int endHour = 11;
    private final int startMinute = 0;
    private final int endMinute = 0;

    @Before
    public void setUp() throws Exception {
        date=new Date(day,startHour,endHour,startMinute,endMinute);
    }

    @Test
    public void testGetDay() {
        assertEquals(date.getDay(),day);
    }

    @Test
    public void testGetStartHour() {
        assertEquals(date.getStartHour(),startHour);
    }

    @Test
    public void testGetEndHour() {
        assertEquals(date.getEndHour(),endHour);
    }

    @Test
    public void testGetStartMinute() {
        assertEquals(date.getStartMinute(),startMinute);
    }

    @Test
    public void testGetEndMinute() {
        assertEquals(date.getEndMinute(),endMinute);
    }
}