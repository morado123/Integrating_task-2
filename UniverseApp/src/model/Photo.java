package model;

/**
 * The Photo class represents a photograph taken in the universe.
 */
public class Photo {
    private String url;
    private String telescope;
    private String date;

    /**
     * Constructor for the Photo class.
     *
     * @param url       The URL of the photograph.
     * @param telescope The name of the telescope that took the photograph.
     * @param date      The date on which the photograph was taken.
     */
    public Photo(String url, String telescope, String date) {
        this.url = url;
        this.telescope = telescope;
        this.date = date;
    }

    /**
     * Gets the URL of the photograph.
     *
     * @return The URL of the photograph.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Gets the name of the telescope that took the photograph.
     *
     * @return The name of the telescope.
     */
    public String getTelescope() {
        return telescope;
    }

    /**
     * Gets the date on which the photograph was taken.
     *
     * @return The date of the photograph.
     */
    public String getDate() {
        return date;
    }
}
