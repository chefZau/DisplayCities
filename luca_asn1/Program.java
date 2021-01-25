package luca_asn1;

/**
 * The Program class, as its name suggests, will be the main heart of the
 * program. It will be the entry point of the program, read in a file of cities
 * and create objects for each of them, contain the array of those cities, and
 * create a CompressedArray containing the distances between each of the cities
 * read in from the file.
 * 
 * Created by Luca Zhou on 1/25/2021.
 */
public class Program {

    private Integer cityCount;
    private City[] cityArray; // keep track of all the City obj
    private CompressedArray array;

    /**
     * 
     * @param file    the file to load
     * @param showMap indicates whether or not the map GUI should be displayed
     */
    public Program(String file, boolean showMap) {

        this.cityCount = 0;
        this.cityArray = new City[3];

        MyFileReader objMyFileReader = new MyFileReader(file);

        // skip the first line
        // skip the first line
        objMyFileReader.readString();

        while (!objMyFileReader.endOfFile()) {

            String cityName = objMyFileReader.readString();
            int x = objMyFileReader.readInt();
            int y = objMyFileReader.readInt();

            City city = new City(cityName, x, y);

            if (this.cityCount == this.cityArray.length) {
                this.expandCapacity();
            }

            // add city and increment count
            this.cityArray[this.cityCount] = city;
            this.cityCount++;
        }

        if (showMap) {
            Map display = new Map();
            for (int i = 0; i < this.cityCount; i++) {
                display.addCity(this.cityArray[i]);
            }
        }
    }

    /**
     * Return attribute cityArray
     * 
     * @return attribute cityArray
     */
    public City[] getCityList() {
        return this.cityArray;
    }

    /**
     * Expands the capacity of cityArray by adding 3 additional slots to the array
     */
    private void expandCapacity() {

        City[] newArray = new City[this.cityCount + 3];

        for (int i = 0; i < this.cityCount; i++)
            newArray[i] = this.cityArray[i];

        this.cityArray = newArray;
    }

    /**
     * Calculates the Euclidean distance between the two given Cities
     * 
     * @return the Euclidean distance
     */
    public double distBetweenCities(City city1, City city2) {

        double ac = Math.abs(city2.getY() - city1.getY());
        double cb = Math.abs(city2.getX() - city1.getX());

        return Math.hypot(ac, cb);
    }

    /**
     * Create a 2D double array (i.e. double[][]) with a size of N by N, where N is
     * the number of cities in cityArray. Loop through every combination of pairs of
     * cities and call distBetweenCities() for each pair. Save this result into the
     * double[][] array in the attribute array.
     */
    public void compareDistances() {

        double[][] cityMatrix = new double[this.cityCount][this.cityCount];

        for (int i = 0; i < this.cityCount; i++) {
            for (int j = 0; j < this.cityCount; j++) {
                cityMatrix[i][j] = distBetweenCities(this.cityArray[i], this.cityArray[j]);
            }
        }

        this.array = new CompressedArray(cityMatrix);

    }

    /**
     * Returns the CompressedArray array object.
     * 
     * @return attribute array
     */
    public CompressedArray getArray() {
        return this.array;
    }
}