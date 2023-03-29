import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {

    // SnowReading constructor tests
    @Test
    public void testSnowReadingConstructorPositive() {
        SnowReading reading = new SnowReading(23, 10);
        assertEquals("Temp is initialized incorrectly with positive value", 23, (int) reading.tempC);
        assertEquals("Cm is initialized incorrectly", 10, (int) reading.cm);
    }

    @Test
    public void testSnowReadingConstructorNegative() {
        SnowReading reading = new SnowReading(-23, -10);
        assertEquals("Temp is initialized incorrectly with negative value", -23, (int) reading.tempC);
        assertEquals("Cm is initialized incorrectly with negative value", 0, (int) reading.cm);
    }

    @Test
    public void testSnowReadingConstructorEmpty() {
        SnowReading reading = new SnowReading();
        assertEquals("Temp is initialized incorrectly with empty constructor", -999, (int) reading.tempC);
        assertEquals("Cm is initialized incorrectly with empty constructor", -999, (int) reading.cm);
    }

    // SnowReading .equals() tests
    @Test
    public void testSnowReadingEqualsTrue() {
        SnowReading reading1 = new SnowReading(23, 10);
        SnowReading reading2 = new SnowReading(23, 10);
        assertTrue("SnowReading.equals() returns false for equal objects", reading1.equals(reading2));
    }

    @Test
    public void testSnowReadingEqualsFalse() {
        SnowReading reading1 = new SnowReading(23, 10);
        SnowReading reading2 = new SnowReading(23, 11);
        assertFalse("SnowReading.equals() returns true for unequal cm readings", reading1.equals(reading2));
    }

    @Test
    public void testSnowReadingEqualsFalse2() {
        SnowReading reading1 = new SnowReading(23, 10);
        SnowReading reading2 = new SnowReading(24, 10);
        assertFalse("SnowReading.equals() returns true for unequal temp readings", reading1.equals(reading2));
    }

    // SnowReading .toString() tests
    @Test
    public void testSnowReadingToString() {
        SnowReading reading = new SnowReading(13, 3);
        assertEquals("SnowReading.toString() returns incorrect string with positive numbers", "13C:3cm",
                reading.toString());
    }

    @Test
    public void testSnowReadingToStringNegative() {
        SnowReading reading = new SnowReading(-23, -10);
        assertEquals("SnowReading.toString() returns incorrect string with negative numbers", "-23C:0cm",
                reading.toString());
    }

    @Test
    public void testSnowReadingToStringEmptyTemp() {
        SnowReading reading = new SnowReading(-999, 5);
        assertEquals("SnowReading.toString() returns incorrect string with empty temp", "Err:5cm", reading.toString());
    }

    @Test
    public void testSnowReadingToStringEmptyCm() {
        SnowReading reading = new SnowReading(15, -999);
        assertEquals("SnowReading.toString() returns incorrect string with empty cm", "15C:Err", reading.toString());
    }

    @Test
    public void testSnowReadingToStringEmpty() {
        SnowReading reading = new SnowReading();
        assertEquals("SnowReading.toString() returns incorrect string with empty constructor", "Err:Err",
                reading.toString());
    }

}
