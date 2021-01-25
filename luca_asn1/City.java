/**
 * The City class represents each city that is loaded in from a text file. It is
 * a simple class that just contains the city's name, x and y coordinates, and a
 * CityMarker icon.
 * 
 * Created by Luca Zhou on 1/24/2021.
 */
public class City {
    
    private String name;
    private Integer x;
    private Integer y;
    private CityMarker marker;

    /**
     * The constructor of this class.
     * @param newName the name of the city
     * @param newX    the x coordinates
     * @param newY    the y coordinates
     */
    public City(String newName, int newX, int newY) {
        this.name = newName;
        this.x = newX;
        this.y = newY;
        this.marker = new CityMarker();
    }

    /**
     * Getter method for attribute name.
     * @return attribute name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter method for attribute x.
     * @return attribute x
     */
    public int getX() {
        return this.x;
    }

    /**
     * Getter method for attribute y.
     * @return attribute y
     */
    public int getY() {
        return this.y;
    }

    /**
     * Getter method for attribute marker.
     * @return attribute marker
     */
    public CityMarker getMarker() {
        return this.marker;
    }

    /**
     * Setter method for attribute name.
     * @param newName new name
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * Setter method for attribute x.
     * @param newX new x
     */
    public void setX(Integer newX) {
        this.x = newX;
    }

    /**
     * Setter method for attribute y.
     * @param newY new y
     */
    public void setY(Integer newY) {
        this.y = newY;
    }

    /**
     * Setter method for attribute marker.
     * @param newMarker new marker
     */
    public void setMarker(CityMarker newMarker) {
        this.marker = newMarker;
    }

    /**
     * Returns the string representation of the object.
     * @return the name attribute of the object
     */
    public String toString() {
        return this.name;
    }
}
