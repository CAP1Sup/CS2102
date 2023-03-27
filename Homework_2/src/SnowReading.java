public class SnowReading extends SensorReading {

    /**
     * Constructs a snow reading from a temperature and amount
     * @param tempC the temperature of the sensor reading in degrees Celsius
     * @param cm the amount of snow in centimeters
     */
    public SnowReading(Integer tempC, Integer cm) {
        super(tempC, cm);
    }

    /**
     * Constructs a blank snow reading
     */
    public SnowReading() {
        this(-999, -999);
    }

    /**
     * Checks if the provided object is equivalent to this SnowReading
     * @param o Object to check
     * @return If object is equivalent
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof SnowReading) {
            SnowReading other = (SnowReading)o;
            if (this.tempC == other.tempC) {
                if (this.cm == other.cm) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Generates a string to represent the reading
     * Any values of -999 are considered errors and will show up as "Err"
     * @return String representation of reading
     */
    @Override
    public String toString() {
        String output;
        if (tempC == -999) {
            output = "Err";
        }
        else {
            output = tempC + "C";
        }
        if (cm == -999) {
            output = output + ":Err";
        }
        else {
            output = output + ":" + cm + "cm";
        }
        return output;
    }
}
