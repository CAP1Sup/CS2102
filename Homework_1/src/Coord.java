public class Coord {
    public int x;
    public int y;

    public Coord(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the distance between this Coord and another
     *
     * @param otherCoord Coordinates to compare to
     * @return Distance between them
     */
    public double distanceTo(Coord otherCoord) {
        return Math.sqrt(Math.pow(x - otherCoord.x, 2) + Math.pow(y - otherCoord.y, 2));
    }
}
