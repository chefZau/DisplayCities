package luca_asn1;

// import luca_asn1.MyFileReader;
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
    private City[] cityArray;   // keep track of all the City obj
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
            for (City city : this.cityArray) {
                display.addCity(city);
            }
        }
    }

    /**
     * Return attribute cityArray
     * 
     * @return attribute cityArray
     */
    public City[] getCityList() {

    }

    /**
     * Expands the capacity of cityArray by adding 3 additional slots to the array
     */
    private void expandCapacity() {

    }

    /**
     * Calculates the Euclidean distance between the two given Cities
     * 
     * @return the Euclidean distance
     */
    public double distBetweenCities(City city1, City city2) {

    }

    /**
     * 
     */
    public void compareDistances() {

    }

    /**
     * Returns the CompressedArray array object.
     * 
     * @return attribute array
     */
    public CompressedArray getArray() {

    }
}