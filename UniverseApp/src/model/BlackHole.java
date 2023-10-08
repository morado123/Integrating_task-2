package model;

/**
 * The BlackHole class represents a black hole in the universe.
 */
public class BlackHole {
    private String name;
    private double mass;
    private double distanceToEarth;
    private String type;
    private Photo[] photos;

    /**
     * Constructor for the BlackHole class.
     *
     * @param name            The name of the black hole.
     * @param mass            The mass of the black hole in kilograms.
     * @param distanceToEarth The distance from the black hole to Earth in
     *                        light-years.
     * @param type            The type of black hole.
     */
    public BlackHole(String name, double mass, double distanceToEarth, String type) {
        this.name = name;
        this.mass = mass;
        this.distanceToEarth = distanceToEarth;
        this.type = type;
        this.photos = new Photo[5];
    }

    /**
     * Adds a photograph (Photo) to the black hole.
     *
     * @param photo The photograph to be added.
     * @return true if the photograph was added successfully, false if it could not
     *         be added.
     */
    public boolean addPhoto(Photo photo) {
        for (int i = 0; i < photos.length; i++) {
            if (photos[i] == null) {
                photos[i] = photo;
                return true;
            }
        }
        return false; // The photo could not be added
    }

    /**
     * Gets the name of the black hole.
     *
     * @return The name of the black hole.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the mass of the black hole.
     *
     * @return The mass of the black hole in kilograms.
     */
    public double getMass() {
        return mass;
    }

    /**
     * Gets the distance from the black hole to Earth.
     *
     * @return The distance from the black hole to Earth in light-years.
     */
    public double getDistanceToEarth() {
        return distanceToEarth;
    }

    /**
     * Gets the type of black hole.
     *
     * @return The type of black hole.
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the photographs associated with the black hole.
     *
     * @return An array of Photo objects representing the associated photographs.
     */
    public Photo[] getPhotos() {
        return photos;
    }
}
