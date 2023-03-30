import static org.junit.Assert.*;

import java.util.LinkedList;

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

    // Constructor tests for SnowStationSimpleOut
    @Test
    public void testSnowStationSimpleOutConstructorLowestTemp() {
        SnowStationSimpleOut station = new SnowStationSimpleOut();
        assertEquals("SnowStationSimpleOut constructor does not initialize lowest temp correctly", -999,
                (int) station.lowestTemp());
    }

    @Test
    public void testSnowStationSimpleOutConstructorBiggestCM() {
        SnowStationSimpleOut station = new SnowStationSimpleOut();
        assertEquals("SnowStationSimpleOut constructor does not initialize biggest cm correctly", -999,
                (int) station.biggestCM());
    }

    @Test
    public void testSnowStationSimpleOutConstructorAmtErrors() {
        SnowStationSimpleOut station = new SnowStationSimpleOut();
        assertEquals("SnowStationSimpleOut constructor does not initialize amtErrors correctly", 0,
                (int) station.amtErrors());
    }

    @Test
    public void testSnowStationSimpleOutConstructorMedians() {
        SnowStationSimpleOut station = new SnowStationSimpleOut();
        assertEquals("SnowStationSimpleOut constructor does not initialize median temp correctly", -999,
                (int) station.medianReading().tempC);
        assertEquals("SnowStationSimpleOut constructor does not initialize median cm correctly", -999,
                (int) station.medianReading().cm);
    }

    // Constructor tests for SnowStationSimpleIn
    @Test
    public void testSnowStationSimpleInConstructorLowestTemp() {
        SnowStationSimpleIn station = new SnowStationSimpleIn();
        assertEquals("SnowStationSimpleIn constructor does not initialize lowest temp correctly", -999,
                (int) station.lowestTemp());
    }

    @Test
    public void testSnowStationSimpleInConstructorBiggestCM() {
        SnowStationSimpleIn station = new SnowStationSimpleIn();
        assertEquals("SnowStationSimpleIn constructor does not initialize biggest cm correctly", -999,
                (int) station.biggestCM());
    }

    @Test
    public void testSnowStationSimpleInConstructorAmtErrors() {
        SnowStationSimpleIn station = new SnowStationSimpleIn();
        assertEquals("SnowStationSimpleIn constructor does not initialize amtErrors correctly", 0,
                (int) station.amtErrors());
    }

    @Test
    public void testSnowStationSimpleInConstructorMedians() {
        SnowStationSimpleIn station = new SnowStationSimpleIn();
        assertEquals("SnowStationSimpleIn constructor does not initialize median temp correctly", -999,
                (int) station.medianReading().tempC);
        assertEquals("SnowStationSimpleIn constructor does not initialize median cm correctly", -999,
                (int) station.medianReading().cm);
    }

    // SnowStationSimpleOut method testing
    @Test
    public void testSnowStationSimpleOutMediansOddAmountOfData() {
        LinkedList<SensorReading> readings = new LinkedList<SensorReading>();
        readings.add(new SnowReading(5, 4));
        readings.add(new SnowReading(-999, -999));
        readings.add(new SnowReading(1, 9));
        readings.add(new SnowReading(9, -999));
        readings.add(new SnowReading(-999, 8));
        SnowStationSimpleOut station = new SnowStationSimpleOut();
        station.readSensorData(readings);
        assertEquals("SnowStationSimpleOut median temp is incorrect with odd amount of data", 5,
                (int) station.medianReading().tempC);
        assertEquals("SnowStationSimpleOut median cm is incorrect with odd amount of data", 8,
                (int) station.medianReading().cm);
    }

    @Test
    public void testSnowStationSimpleOutMediansEvenAmountOfData() {
        LinkedList<SensorReading> readings = new LinkedList<SensorReading>();
        readings.add(new SnowReading(-999, 50));
        readings.add(new SnowReading(3, -999));
        readings.add(new SnowReading(-999, -999));
        readings.add(new SnowReading(-3, 7));
        readings.add(new SnowReading(0, 0));
        readings.add(new SnowReading(-2, 7));
        SnowStationSimpleOut station = new SnowStationSimpleOut();
        station.readSensorData(readings);
        assertEquals("SnowStationSimpleOut median temp is incorrect with even amount of data", 0,
                (int) station.medianReading().tempC);
        assertEquals("SnowStationSimpleOut median cm is incorrect with even amount of data", 7,
                (int) station.medianReading().cm);
    }

    @Test
    public void testSnowStationSimpleOutLowestTemp() {
        LinkedList<SensorReading> readings = new LinkedList<SensorReading>();
        readings.add(new SnowReading(-999, 50));
        readings.add(new SnowReading(3, -999));
        readings.add(new SnowReading(-999, -999));
        readings.add(new SnowReading(-2, 7));
        SnowStationSimpleOut station = new SnowStationSimpleOut();
        station.readSensorData(readings);
        assertEquals("SnowStationSimpleOut lowest temp is incorrect", -2,
                (int) station.lowestTemp());
    }

    @Test
    public void testSnowStationSimpleOutBiggestCM() {
        LinkedList<SensorReading> readings = new LinkedList<SensorReading>();
        readings.add(new SnowReading(-999, 50));
        readings.add(new SnowReading(3, -999));
        readings.add(new SnowReading(-999, -999));
        readings.add(new SnowReading(-2, 7));
        SnowStationSimpleOut station = new SnowStationSimpleOut();
        station.readSensorData(readings);
        assertEquals("SnowStationSimpleOut biggest cm is incorrect", 50,
                (int) station.biggestCM());
    }

    @Test
    public void testSnowStationSimpleOutAmtErrors() {
        LinkedList<SensorReading> readings = new LinkedList<SensorReading>();
        readings.add(new SnowReading(-999, 50));
        readings.add(new SnowReading(3, -999));
        readings.add(new SnowReading(-999, -999));
        readings.add(new SnowReading(-2, 7));
        SnowStationSimpleOut station = new SnowStationSimpleOut();
        station.readSensorData(readings);
        assertEquals("SnowStationSimpleOut amtErrors is incorrect", 3,
                (int) station.amtErrors());
    }

    // SnowStationSimpleIn method testing
    @Test
    public void testSnowStationSimpleInMedianOddAmountOfData() {
        LinkedList<SensorReading> readings = new LinkedList<SensorReading>();
        readings.add(new SnowReading(5, 4));
        readings.add(new SnowReading(-999, -999));
        readings.add(new SnowReading(1, 9));
        readings.add(new SnowReading(9, -999));
        readings.add(new SnowReading(-999, 8));
        SnowStationSimpleIn station = new SnowStationSimpleIn();
        station.readSensorData(readings);
        assertEquals("SnowStationSimpleIn median temp is incorrect with odd amount of data", 5,
                (int) station.medianReading().tempC);
        assertEquals("SnowStationSimpleIn median cm is incorrect with odd amount of data", 8,
                (int) station.medianReading().cm);
    }

    @Test
    public void testSnowStationSimpleInMedianEvenAmountOfData() {
        LinkedList<SensorReading> readings = new LinkedList<SensorReading>();
        readings.add(new SnowReading(-999, 50));
        readings.add(new SnowReading(3, -999));
        readings.add(new SnowReading(-999, -999));
        readings.add(new SnowReading(-3, 7));
        readings.add(new SnowReading(0, 0));
        readings.add(new SnowReading(-2, 7));
        SnowStationSimpleIn station = new SnowStationSimpleIn();
        station.readSensorData(readings);
        assertEquals("SnowStationSimpleIn median temp is incorrect with even amount of data", 0,
                (int) station.medianReading().tempC);
        assertEquals("SnowStationSimpleIn median cm is incorrect with even amount of data", 7,
                (int) station.medianReading().cm);
    }

    @Test
    public void testSnowStationSimpleInLowestTemp() {
        LinkedList<SensorReading> readings = new LinkedList<SensorReading>();
        readings.add(new SnowReading(-999, 50));
        readings.add(new SnowReading(3, -999));
        readings.add(new SnowReading(-999, -999));
        readings.add(new SnowReading(-2, 7));
        SnowStationSimpleIn station = new SnowStationSimpleIn();
        station.readSensorData(readings);
        assertEquals("SnowStationSimpleIn lowest temp is incorrect", -2,
                (int) station.lowestTemp());
    }

    @Test
    public void testSnowStationSimpleInBiggestCM() {
        LinkedList<SensorReading> readings = new LinkedList<SensorReading>();
        readings.add(new SnowReading(-999, 50));
        readings.add(new SnowReading(3, -999));
        readings.add(new SnowReading(-999, -999));
        readings.add(new SnowReading(-2, 7));
        SnowStationSimpleIn station = new SnowStationSimpleIn();
        station.readSensorData(readings);
        assertEquals("SnowStationSimpleIn biggest cm is incorrect", 50,
                (int) station.biggestCM());
    }

    @Test
    public void testSnowStationSimpleInAmtErrors() {
        LinkedList<SensorReading> readings = new LinkedList<SensorReading>();
        readings.add(new SnowReading(-999, 50));
        readings.add(new SnowReading(3, -999));
        readings.add(new SnowReading(-999, -999));
        readings.add(new SnowReading(-2, 7));
        SnowStationSimpleIn station = new SnowStationSimpleIn();
        station.readSensorData(readings);
        assertEquals("SnowStationSimpleIn amtErrors is incorrect", 3,
                (int) station.amtErrors());
    }
}
