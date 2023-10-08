package model;

/**
 * The Galaxy class represents an object that describes the characteristics of a
 * galaxy in the universe.
 */
public class Galaxy {
    private String name;
    private double distanceToEarth;
    private String shape;
    private BlackHole blackHole;
    private Planet[] planets;
    private Photo[] photos;

    /**
     * Constructor for the Galaxy class.
     *
     * @param name            The name of the galaxy.
     * @param distanceToEarth The distance from the galaxy to Earth in light-years.
     * @param shape           The shape of the galaxy.
     */
    public Galaxy(String name, double distanceToEarth, String shape) {
        this.name = name;
        this.distanceToEarth = distanceToEarth;
        this.shape = shape;
        this.blackHole = null;
        this.planets = new Planet[20];
        this.photos = new Photo[30];
    }

    /**
     * Adds a black hole to the galaxy.
     *
     * @param blackHole The black hole to be added to the galaxy.
     */
    public void addBlackHole(BlackHole blackHole) {
        this.blackHole = blackHole;
    }

    /**
     * Adds a planet to the galaxy.
     *
     * @param planet The planet to be added to the galaxy.
     * @return `true` if the planet was added successfully, `false` if it couldn't
     *         be added (due to lack of space).
     */
    public boolean addPlanet(Planet planet) {
        for (int i = 0; i < planets.length; i++) {
            if (planets[i] == null) {
                planets[i] = planet;
                return true;
            }
        }
        return false; // The planet couldn't be added
    }

    /**
     * Adds a photo to the galaxy.
     *
     * @param photo The photo to be added to the galaxy.
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

    /**
     * Gets the name of the galaxy.
     *
     * @return The name of the galaxy.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the distance from the galaxy to Earth in light-years.
     *
     * @return The distance from the galaxy to Earth.
     */
    public double getDistanceToEarth() {
        return distanceToEarth;
    }

    /**
     * Gets the shape of the galaxy.
     *
     * @return The shape of the galaxy.
     */
    public String getShape() {
        return shape;
    }

    /**
     * Gets the black hole associated with the galaxy.
     *
     * @return The black hole of the galaxy, or `null` if there is no associated
     *         black hole.
     */
    public BlackHole getBlackHole() {
        return blackHole;
    }

    /**
     * Sets the black hole associated with the galaxy.
     *
     * @param blackHole The black hole to be associated with the galaxy.
     */
    public void setBlackHole(BlackHole blackHole) {
        this.blackHole = blackHole;
    }

    /**
     * Gets the array of planets associated with the galaxy.
     *
     * @return An array of Planet objects representing the planets of the galaxy.
     */
    public Planet[] getPlanets() {
        return planets;
    }

    /**
     * Gets the array of photos associated with the galaxy.
     *
     * @return An array of Photo objects representing the photos of the galaxy.
     */
    public Photo[] getPhotos() {
        return photos;
    }
}
