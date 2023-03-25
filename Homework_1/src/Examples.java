import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {

    // Constructor tests
    @Test
    public void testCatConstructor() {
        Cat cat = new Cat("Claws", -1.0, -120.0, new Coord(0, 0));
        assertEquals("Name is incorrect", "Claws", cat.name);
        assertEquals("Age is incorrect", 0, cat.age, 0.01d);
        assertEquals("Weight is incorrect", 0, cat.currentWeight, 0.01d);
    }

    @Test
    public void testChinchillaConstructor() {
        Chinchilla chinchilla = new Chinchilla("Claws", -1.0, -120.0, new Coord(0, 0));
        assertEquals("Name is incorrect", "Claws", chinchilla.name);
        assertEquals("Age is incorrect", 0, chinchilla.age, 0.01d);
        assertEquals("Weight is incorrect", 0, chinchilla.currentWeight, 0.01d);
    }

    @Test
    public void testGoatConstructor() {
        Goat goat = new Goat("Claws", -1.0, -120.0, new Coord(0, 0));
        assertEquals("Name is incorrect", "Claws", goat.name);
        assertEquals("Age is incorrect", 0, goat.age, 0.01d);
        assertEquals("Weight is incorrect", 0, goat.currentWeight, 0.01d);
    }


    // Youngin totals
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
    public void testChangeCatFeedPosNums() {
        CatastropheZone catZone = new CatastropheZone();
        catZone.changeFeed("dry", 1);
        catZone.changeFeed("dry", 2);
        assertEquals("Cat feed display not correct", "Cat: 3 lbs. of dry food | 2 cans of wet food",
                catZone.changeFeed("wet", 2));
    }

    @Test
    public void testChangeCatFeedNegNums() {
        CatastropheZone catZone = new CatastropheZone();
        catZone.changeFeed("dry", -1);
        assertEquals("Cat feed display not correct", "Cat: unknown lbs. of dry food | 2 cans of wet food",
                catZone.changeFeed("wet", 2));
    }

    @Test
    public void testChangeChinchillaFeedPosNums() {
        TheHutchZone ccZone = new TheHutchZone();
        ccZone.changeFeed("pellets", 1);
        ccZone.changeFeed("hay", 2);
        assertEquals("Chinchilla feed display not correct", "Chinchilla: 1 lbs. of pellets | 2 oz. of hay | 3 units of dried fruit",
                ccZone.changeFeed("fruit", 3));
    }

    @Test
    public void testChangeChinchillaFeedNegNums() {
        TheHutchZone ccZone = new TheHutchZone();
        ccZone.changeFeed("pellets", 1);
        ccZone.changeFeed("hay", 2);
        assertEquals("Chinchilla feed display not correct", "Chinchilla: 1 lbs. of pellets | unknown oz. of hay | 0 units of dried fruit",
                ccZone.changeFeed("hay", -3));
    }

    @Test
    public void testChangeGoatFeedPosNums() {
        GoateryZone goatZone = new GoateryZone();
        goatZone.changeFeed("dry", 1);
        goatZone.changeFeed("wet", 2);
        assertEquals("Goat feed display not correct", "Goat: 0 piles of edible substance",
                goatZone.changeFeed("wet", -3));
    }

    @Test
    public void testChangeGoatFeedNegNums() {
        GoateryZone goatZone = new GoateryZone();
        goatZone.changeFeed("dry", 1);
        assertEquals("Goat feed display not correct", "Goat: unknown piles of edible substance",
                goatZone.changeFeed("wet", -2));
    }


    // Honorably Titled Method Tests
    @Test
    public void testHonorablyTitledNoTitleNoCreds() {
        Cat cat = new Cat("Claws", 1.0, 120.0, new Coord(0, 0));
        assertFalse("Detected false honorable title without title or credentials", cat.honorablyTitled());
    }

    @Test
    public void testHonorablyTitledOnlyTitle() {
        Chinchilla chinchilla = new Chinchilla("Claws", 1.0, 120.0, new Coord(0, 0));
        chinchilla.bestowTitle("Judge");
        assertFalse("Detected false listed creds", chinchilla.honorablyTitled());
    }

    @Test
    public void testHonorablyTitledOnlyCred() {
        Goat goat = new Goat("Claws", 1.0, 120.0, new Coord(0, 0));
        goat.bestowCredential("MD");
        assertFalse("Detected false listed title with single cred", goat.honorablyTitled());
    }

    @Test
    public void testHonorablyTitledMultipleCreds() {
        Cat cat = new Cat("Claws", 1.0, 120.0, new Coord(0, 0));
        cat.bestowCredential("MD");
        cat.bestowCredential("PHD");
        assertFalse("Detected false listed title with multiple creds", cat.honorablyTitled());
    }


    // closestTo Method Tests
    @Test
    public void testClosestToWithAllPositives() {
        Coord[] testData = {new Coord(1, 1), new Coord(10, 2), new Coord(6, 3)};
        CatastropheZone catZone = new CatastropheZone();
        for (Coord coord : testData) {
            catZone.registerAdoptable("Claws", 1.0, 120.0, coord);
        }
        Coord testCoord = new Coord(2, 3);
        assertEquals("Failed X with positive coords", 1, (int)catZone.closestTo(testCoord).whereabouts.x);
        assertEquals("Failed Y with positive coords", 1, (int)catZone.closestTo(testCoord).whereabouts.y);
    }

    @Test
    public void testClosestToWithClosestX() {
        Coord[] testData = {new Coord(1, 1), new Coord(10, 2), new Coord(6, 20)};
        TheHutchZone ccZone = new TheHutchZone();
        for (Coord coord : testData) {
            ccZone.registerAdoptable("Claws", 1.0, 120.0, coord);
        }
        Coord testCoord = new Coord(10, 15);
        assertEquals("Failed X with closest X", 6, (int)ccZone.closestTo(testCoord).whereabouts.x);
        assertEquals("Failed Y with closest X", 20, (int)ccZone.closestTo(testCoord).whereabouts.y);
    }

    @Test
    public void testClosestToWithClosestY() {
        Coord[] testData = {new Coord(1, 1), new Coord(10, 2), new Coord(6, 20)};
        GoateryZone goatZone = new GoateryZone();
        for (Coord coord : testData) {
            goatZone.registerAdoptable("Claws", 1.0, 120.0, coord);
        }
        Coord testCoord = new Coord(7, 3);
        assertEquals("Failed X with closest Y", 10, (int)goatZone.closestTo(testCoord).whereabouts.x);
        assertEquals("Failed Y with closest Y", 2, (int)goatZone.closestTo(testCoord).whereabouts.y);
    }

    @Test
    public void testClosestToWithSameDistance() {
        Coord[] testData = {new Coord(2, 2), new Coord(10, 2), new Coord(6, 20)};
        CatastropheZone catZone = new CatastropheZone();
        for (Coord coord : testData) {
            catZone.registerAdoptable("Claws", 1.0, 120.0, coord);
        }
        Coord testCoord = new Coord(6, 1);
        assertEquals("Failed X with same distance", 10, (int)catZone.closestTo(testCoord).whereabouts.x);
        assertEquals("Failed Y with same distance", 2, (int)catZone.closestTo(testCoord).whereabouts.y);
    }

    @Test
    public void testClosestToWithSomeNegatives() {
        Coord[] testData = {new Coord(-10, 1), new Coord(10, 2), new Coord(6, 3)};
        TheHutchZone ccZone = new TheHutchZone();
        for (Coord coord : testData) {
            ccZone.registerAdoptable("Claws", 1.0, 120.0, coord);
        }
        Coord testCoord = new Coord(10, 1);
        assertEquals("Failed X with some negative coords", 10, (int)ccZone.closestTo(testCoord).whereabouts.x);
        assertEquals("Failed Y with some negative coords", 2, (int)ccZone.closestTo(testCoord).whereabouts.y);
    }

    @Test
    public void testClosestToWithEmptyList() {
        GoateryZone goatZone = new GoateryZone();
        assertEquals("Failed with empty list", null, goatZone.closestTo(new Coord(0, 0)));
    }


    // Weigh in testing
    @Test
    public void testWeighInCatsYoungins() {
        CatastropheZone catZone = new CatastropheZone();
        catZone.registerAdoptable("Claws", 1.0, 120.0, new Coord(0, 0));
        catZone.registerAdoptable("Paws", 2.0, 240.0, new Coord(1, 0));
        catZone.registerAdoptable("Paws", 23.999, 240.0, new Coord(1, 0));
        assertEquals("Total number of cat youngins is incorrect after adding", 0, catZone.weighIn(0.0).size());
    }

    @Test
    public void testWeighInCatsOlder() {
        CatastropheZone catZone = new CatastropheZone();
        catZone.registerAdoptable("Claws", 25.0, 4600.1, new Coord(0, 1));
        catZone.registerAdoptable("Claws", 25.0, 4600.0, new Coord(0, 1));
        catZone.registerAdoptable("Claws", 25.0, 4500.0, new Coord(0, 1));
        assertEquals("Total number of cats is incorrect after adding", 1, catZone.weighIn(100.0).size());
    }

    @Test
    public void testWeighInCatsMixedAges() {
        CatastropheZone catZone = new CatastropheZone();
        catZone.registerAdoptable("Claws", 1.0, 120.0, new Coord(0, 0));
        catZone.registerAdoptable("Paws", 2.0, 240.0, new Coord(1, 0));
        catZone.registerAdoptable("Claws", 25.0, 4800.0, new Coord(0, 1));
        catZone.registerAdoptable("Claws", 25.0, 4500.0, new Coord(0, 1));
        assertEquals("Total number of cats is incorrect after adding", 1, catZone.weighIn(0.0).size());
    }

    @Test
    public void testWeighInChinchillas() {
        TheHutchZone ccZone = new TheHutchZone();
        ccZone.registerAdoptable("Claws", 0.0, 120.0, new Coord(0, 0));
        ccZone.registerAdoptable("Paws", 0.0, 240.0, new Coord(1, 0));
        ccZone.registerAdoptable("Paws", 0.0, 240.1, new Coord(1, 0));
        assertEquals("Total number of chinchillas is incorrect after adding", 2, ccZone.weighIn(40.0).size());
    }

    @Test
    public void testWeighInGoats() {
        GoateryZone goatZone = new GoateryZone();
        goatZone.registerAdoptable("Claws", 0.0, 55000.0, new Coord(0, 0));
        goatZone.registerAdoptable("Paws", 0.0, 240.0, new Coord(1, 0));
        goatZone.registerAdoptable("Paws", 24.0, 57000.0, new Coord(1, 0));
        assertEquals("Total number of goats is incorrect after adding", 1, goatZone.weighIn(40.0).size());
    }
}