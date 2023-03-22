import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {

    @Test
    public void testYounginsBeforeAdding() {
        CatastropheZone catZone = new CatastropheZone();
        assertEquals("Total number of youngins is incorrect before adding", 0, catZone.totalYoungins());
    }

    @Test
    public void testYounginsAfterAdding() {
        CatastropheZone catZone = new CatastropheZone();
        catZone.registerAdoptable("Claws", 1.0, 120.0, new Coord(0, 0));
        catZone.registerAdoptable("Paws", 2.0, 240.0, new Coord(1, 0));
        catZone.registerAdoptable("Claws", 25.0, 120.0, new Coord(0, 1));
        assertEquals("Total number of youngins is incorrect after adding", 2, catZone.totalYoungins());
    }

    @Test
    public void testAvgAgeBeforeAdding() {
        CatastropheZone catZone = new CatastropheZone();
        assertEquals("Avg age is incorrect before adding", 0, catZone.averageAge(), 0.01d);
    }

    @Test
    public void testAvgAgeAfterAdding() {
        CatastropheZone catZone = new CatastropheZone();
        catZone.registerAdoptable("Claws", 1.0, 120.0, new Coord(0, 0));
        catZone.registerAdoptable("Paws", 2.5, 240.0, new Coord(1, 0));
        catZone.registerAdoptable("Claws", 25.0, 120.0, new Coord(0, 1));
        assertEquals("Avg age is incorrect after adding", 9.5, catZone.averageAge(), 0.01d);
    }

    @Test
    public void testChangeFeedPosNums() {
        CatastropheZone catZone = new CatastropheZone();
        catZone.changeFeed("dry", 1);
        catZone.changeFeed("dry", 2);
        assertEquals("Cat feed display not correct", "Cat: 3 lbs. of dry food | 2 cans of wet food", catZone.changeFeed("wet", 2));
    }

    @Test
    public void testChangeFeedNegNums() {
        CatastropheZone catZone = new CatastropheZone();
        catZone.changeFeed("dry", -1);
        assertEquals("Cat feed display not correct", "Cat: unknown lbs. of dry food | 2 cans of wet food", catZone.changeFeed("wet", 2));
    }


    // Honorably Titled Method Tests
    @Test
    public void testHonorablyTitledNoTitleNoCreds() {
        Cat cat = new Cat("Claws", 1.0, 120.0, new Coord(0, 0));
        assertFalse("Detected false honorable title without title or credentials", cat.honorablyTitled());
    }

    @Test
    public void testHonorablyTitledOnlyTitle() {
        Cat cat = new Cat("Claws", 1.0, 120.0, new Coord(0, 0));
        cat.bestowTitle("Judge");
        assertFalse("Detected false listed creds", cat.honorablyTitled());
    }

    @Test
    public void testHonorablyTitledOnlyCred() {
        Cat cat = new Cat("Claws", 1.0, 120.0, new Coord(0, 0));
        cat.bestowCredential("MD");
        assertFalse("Detected false listed title with single cred", cat.honorablyTitled());
    }

    @Test
    public void testHonorablyTitledMultipleCreds() {
        Cat cat = new Cat("Claws", 1.0, 120.0, new Coord(0, 0));
        cat.bestowCredential("MD");
        cat.bestowCredential("PHD");
        assertFalse("Detected false listed title with multiple creds", cat.honorablyTitled());
    }

    @Test
    public void testHonorablyTitledMultipleCreds() {
        Cat cat = new Cat("Claws", 1.0, 120.0, new Coord(0, 0));
        cat.bestowCredential("MD");
        cat.bestowCredential("PHD");
        assertFalse("Detected false listed title with multiple creds", cat.honorablyTitled());
    }

}