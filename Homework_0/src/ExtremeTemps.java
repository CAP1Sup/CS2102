import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class ExtremeTemps {

    @Test
    public void testExtremeTempMethodOrderedData() {
        double temps[] = { 1, 2, 3, 4, 5 };

        MinMaxTemp extremeTemps = Rescue.extremeTemps(temps);

        assertEquals("Failed standalone ordered array min", 1.0d, extremeTemps.min, 0.01d);
        assertEquals("Failed standalone ordered array max", 5.0d, extremeTemps.max, 0.01d);
    }

    @Test
    public void testExtremeTempMethodUnorderedData() {
        double temps[] = { 3, 2, 4, 5, 1 };

        MinMaxTemp extremeTemps = Rescue.extremeTemps(temps);

        assertEquals("Failed standalone unordered array min", 1.0d, extremeTemps.min, 0.01d);
        assertEquals("Failed standalone unordered array max", 5.0d, extremeTemps.max, 0.01d);
    }

    @Test
    public void testExtremeTempMethodNegativeData() {
        double temps[] = { -1, 2, 3, 6, 5 };

        MinMaxTemp extremeTemps = Rescue.extremeTemps(temps);

        assertEquals("Failed standalone negative array min", -1.0d, extremeTemps.min, 0.01d);
        assertEquals("Failed standalone negative array max", 6.0d, extremeTemps.max, 0.01d);
    }

    @Test
    public void testExtremeTempMethodEmptyArray() {
        double temps[] = {};
        assertNull("Empty array doesn't return null with standalone method", Rescue.extremeTemps(temps));
    }

    @Test
    public void testExtremeTempArrayMethodGoodData() {
        double temps[][] = {
                { 1, 2, 3, 4, 5 },
                { 3, 2, 4, 5, 1 },
                { -1, 2, 3, 6, 5 } };

        MinMaxTemp extremeTemps[] = Rescue.extremeTemps(temps);

        assertEquals("Failed ordered array min", 1.0d, extremeTemps[0].min, 0.01d);
        assertEquals("Failed ordered array max", 5.0d, extremeTemps[0].max, 0.01d);
        assertEquals("Failed unordered array min", 1.0d, extremeTemps[1].min, 0.01d);
        assertEquals("Failed unordered array max", 5.0d, extremeTemps[1].max, 0.01d);
        assertEquals("Failed negative array min", -1.0d, extremeTemps[2].min, 0.01d);
        assertEquals("Failed negative array max", 6.0d, extremeTemps[2].max, 0.01d);
    }

    @Test
    public void testExtremeTempArrayMethodEmptyArray() {
        double temps[][] = {};
        assertNull("Empty array doesn't return null with array method", Rescue.extremeTemps(temps));
    }
}
