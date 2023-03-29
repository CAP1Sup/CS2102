import java.util.ArrayList;
import java.util.LinkedList;

public class SnowStationSimpleIn implements IWeatherStation {

    LinkedList<SensorReading> readings = new LinkedList<SensorReading>();

    /**
     * Reads an ordered sequence of data from the weather sensors to store in the
     * station
     * When called multiple times, appends the new readings after the current sensor
     * readings
     *
     * @param values A sequence of readings
     *               If the sensor has an error, the tempC or cm might be -999
     */
    public void readSensorData(LinkedList<SensorReading> values) {
        readings.addAll(values);
    };

    /**
     * Retrieves the current sensor data
     *
     * @return the current sensor data (append together of multiple readings have
     *         occurred)
     *         returns an empty list if there is no data
     */
    public LinkedList<SensorReading> getCurrentSensorData() {
        return this.readings;
    };

    /**
     * produces a sensor value of the median temperature and cm (respectively) from
     * the stored readings ignoring error values (-999s)
     *
     * @return a new SensorReading object that has the median temperature of all the
     *         sensor values
     *         and the median cm of all the sensor values
     *         If there are no valid temp or cm values, then the resulting sensor
     *         reading should have -999 for that data, respectively
     */
    public SensorReading medianReading() {

        // Create lists of temp and cm readings
        ArrayList<Integer> tempReadings = new ArrayList<Integer>(readings.size());
        ArrayList<Integer> cmReadings = new ArrayList<Integer>(readings.size());

        // Fill the reading lists with sensor readings
        for (SensorReading reading : readings) {
            if (!reading.tempC.equals(-999)) {
                tempReadings.add(reading.tempC);
            }
            if (!reading.cm.equals(-999)) {
                cmReadings.add(reading.cm);
            }
        }

        // Compute the medians
        Integer tempMedian = computeMedian(tempReadings);
        Integer cmMedian = computeMedian(cmReadings);

        return new SnowReading(tempMedian, cmMedian);
    };

    /**
     * Computes the median of a given list
     *
     * @param list The list of Integer values to find the median of
     * @return The median of the given list
     */
    public Integer computeMedian(ArrayList<Integer> list) {

        // Make sure the list isn't empty
        if (list.isEmpty()) {
            return -999;
        }

        // Sort the list
        list.sort(Integer::compareTo);

        // Compute the middle of the list
        int listMiddle = list.size() / 2;

        // Check if the list has an even number of elements
        if (list.size() % 2 == 0) {

            // Find the average of the middle two
            return ((list.get(listMiddle) + list.get(listMiddle + 1)) / 2);
        } else {
            return list.get(listMiddle);
        }
    }

}
