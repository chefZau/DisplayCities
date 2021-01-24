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

    public City(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.marker = new CityMarker();
    }

}
