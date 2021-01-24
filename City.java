public class City {
    /**
     * This class represents each city that is loaded in from a text file. 
     * 
     * It is a simple class that just contains the city's name, x and y 
     * coordinates, and a CityMarker icon.
     */

    private String name;
    private Integer x;
    private Integer y;
    private CityMarker marker;

    public City(String newName, int newX, int newY) {
        this.name = newName;
        this.x = newX;
        this.y = newY;
        this.marker = new CityMarker();
    }

    public String getName() {
        return this.name;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public CityMarker getMarker() {
        return this.marker;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setX(Integer newX) {
        this.x = newX;
    }

    public void setY(Integer newY) {
        this.y = newY;
    }

    public void setMarker(CityMarker newMarker) {
        this.marker = newMarker;
    }

    public String toString() {
        return this.name;
    }
}
