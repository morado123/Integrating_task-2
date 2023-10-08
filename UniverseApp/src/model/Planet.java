package model;

/**
 * The Planet class represents an object that describes the characteristics of a
 * planet in the universe.
 */
public class Planet {
    private String name;
    private int numberOfSatellites;
    private double radius;
    private double mass;
    private Photo[] photos;

    /**
     * Constructor for the Planet class.
     *
     * @param name               The name of the planet.
     * @param numberOfSatellites The number of satellites orbiting the planet.
     * @param radius             The radius of the planet in specific units.
     * @param mass               The mass of the planet in specific units.
     */
    public Planet(String name, int numberOfSatellites, double radius, double mass) {
        this.name = name;
        this.numberOfSatellites = numberOfSatellites;
        this.radius = radius;
        this.mass = mass;
        this.photos = new Photo[50];
    }

    /**
     * Calculates the volume of the planet.
     *
     * @return The calculated volume of the planet in cubic units.
     */
    public double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    /**
     * Calculates the density of the planet.
     *
     * @return The density of the planet in specific units.
     */
    public double calculateDensity() {
        return mass / calculateVolume();
    }

    /**
     * Adds a photo to the planet's set of photos.
     *
     * @param photo The photo to be added to the planet.
     * @return `true` if the photo was added successfully, `false` if it couldn't be
     *         added (due to lack of space).
     */
    public boolean addPhoto(Photo photo) {
        for (int i = 0; i < photos.length; i++) {
            if (photos[i] == null) {
                photos[i] = photo;
                return true;
            }
        }
        return false; // The photo couldn't be added
    }

    // Other necessary methods

    /**
     * Gets the name of the planet.
     *
     * @return The name of the planet.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the number of satellites orbiting the planet.
     *
     * @return The number of satellites of the planet.
     */
    public int getNumberOfSatellites() {
        return numberOfSatellites;
    }

    /**
     * Gets the radius of the planet.
     *
     * @return The radius of the planet in specific units.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Gets the mass of the planet.
     *
     * @return The mass of the planet in specific units.
     */
    public double getMass() {
        return mass;
    }

    /**
     * Gets the set of photos associated with the planet.
     *
     * @return An array of Photo objects representing the planet's photos.
     */
    public Photo[] getPhotos() {
        return photos;
    }

    /**
     * Sets the number of satellites orbiting the planet.
     *
     * @param numberOfSatellites The new number of satellites.
     */
    public void setNumberOfSatellites(int numberOfSatellites) {
        this.numberOfSatellites = numberOfSatellites;
    }

    /**
     * Sets the mass of the planet.
     *
     * @param mass The new mass of the planet in specific units.
     */
    public void setMass(double mass) {
        this.mass = mass;
    }

    /**
     * Sets the radius of the planet.
     *
     * @param radius The new radius of the planet in specific units.
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }
}
