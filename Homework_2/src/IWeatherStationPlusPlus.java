public interface IWeatherStationPlusPlus {


    /**
     * @return the lowest temperature read (or -999 if no temps read)
     */
    public Integer lowestTemp();
    /**
     * @return the biggest centimeter data of valid readings (or -999 if no cms read)
     */
    public Integer biggestCM();

    /**
     * Count an error when either the temp OR the cm of a SensorReading was -999
     * @return how many error readings there were
     *
     */
    public Integer amtErrors();



}
