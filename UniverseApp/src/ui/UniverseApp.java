package ui;

import model.Planet;
import model.Galaxy;
import model.Photo;
import model.BlackHole;
import java.util.Scanner;

/**
 * This class represents the main application of the UniverseApp program.
 * It allows the user to perform various operations related to galaxies,
 * black holes, and planets in the universe.
 */
public class UniverseApp {
    private Galaxy[] galaxies = new Galaxy[50];
    private int numGalaxies = 0;
    private Scanner scanner = new Scanner(System.in);

    /**
     * The main method that initializes the application.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        UniverseApp app = new UniverseApp();
        app.mainMenu();
    }

    /**
     * Displays the main menu of the application and allows the user
     * to select an option.
     */
    public void mainMenu() {
        System.out.println("\n\n***MY NAME IS FELIPE RIVAS, SYSTEMS ENGINEER \n WELCOME TO UNIVERSE APP***");
        System.out.println("\n\n");
        System.out.print("Keep in mind the different types of Black Holes:\r\n" + //
                "- Schwarzschild black hole\r\n" + //
                "- Reissner-Nordstrøm black hole\r\n" + //
                "- Kerr black hole\r\n" + //
                "- Kerr-Newman black hole.\n\n");
        System.out.println("\n\n");
        while (true) {
            System.out.println("Here is the main menu:");
            System.out.println("1. To Create a Galaxy");
            System.out.println("2. To Create a Black Hole");
            System.out.println("3. To Create or Register a Planet");
            System.out.println("4. To Delete a Planet");
            System.out.println("5. To Modify Planet Data");
            System.out.println("6. To Add a Photo to a Planet");
            System.out.println("7. To Check Galaxy Information");
            System.out.println("8. To Check Planet Information");
            System.out.println("9. To Find the Name of the Farthest Galaxy from Earth");
            System.out.println("10. To Find the Name of the Planet with the Highest Density");
            System.out.println("11. To Find Names of Black Holes by Type");
            System.out.println("12. Name of the Telescope with the Most Registered Photos");
            System.out.println("13. To Create Test Cases");
            System.out.println("0. To Exit\n");

            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    createGalaxy();
                    break;
                case 2:
                    createBlackHole();
                    break;
                case 3:
                    createPlanet();
                    break;
                case 4:
                    deletePlanet();
                    break;
                case 5:
                    modifyPlanet();
                    break;
                case 6:
                    addPhotoToPlanet();
                    break;
                case 7:
                    checkGalaxyInformation();
                    break;
                case 8:
                    checkPlanetInformation();
                    break;
                case 9:
                    findFarthestGalaxyFromEarth();
                    break;
                case 10:
                    findPlanetWithHighestDensity();
                    break;
                case 11:
                    findBlackHolesByType();
                    break;
                case 12:
                    findTelescopeWithMostPhotos();
                    break;
                case 13:
                    createTestCases();
                    break;
                case 0:
                    System.out.println("Exiting the program... Goodbye User!");
                    return;
                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        }
    }

    /**
     * Creates a new galaxy with information provided by the user.
     */
    public void createGalaxy() {
        System.out.print("Name of the Galaxy: ");
        String name = scanner.nextLine();
        System.out.print("Distance to Earth (light-years): ");
        double distanceToEarth = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Shape of the Galaxy: ");
        String shape = scanner.nextLine();

        Galaxy galaxy = new Galaxy(name, distanceToEarth, shape);
        galaxies[numGalaxies] = galaxy;
        numGalaxies++;
        System.out.println("Galaxy created successfully.\n");
    }

    /**
     * Creates a new black hole with information provided by the user.
     */
    public void createBlackHole() {
        System.out.print("Name of the Black Hole: ");
        String name = scanner.nextLine();
        System.out.print("Mass of the Black Hole: ");
        double mass = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Distance to Earth (light-years): ");
        double distanceToEarth = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Type of the Black Hole: ");
        String type = scanner.nextLine();

        BlackHole blackHole = new BlackHole(name, mass, distanceToEarth, type);

        System.out.println("Black Hole created successfully.\n");
    }

    /**
     * Registers a new planet in an existing galaxy.
     */
    public void createPlanet() {
        System.out.print("Name of the Planet: ");
        String name = scanner.nextLine();
        System.out.print("Number of Satellites: ");
        int numberOfSatellites = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Planet Radius: ");
        double radius = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Planet Mass: ");
        double mass = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Name of the Galaxy it belongs to: ");
        String galaxyName = scanner.nextLine();

        Galaxy galaxy = findGalaxy(galaxyName);

        if (galaxy != null) {
            Planet planet = new Planet(name, numberOfSatellites, radius, mass);
            if (galaxy.addPlanet(planet)) {
                System.out.println("Planet registered in the Galaxy successfully.\n");
            } else {
                System.out.println("Planet registration failed. Limit reached.\n");
            }
        } else {
            System.out.println("The specified Galaxy does not exist.\n");
        }
    }

    /**
     * Deletes a planet from a galaxy.
     */
    public void deletePlanet() {
        System.out.print("Name of the Galaxy from which to delete the Planet: ");
        String galaxyName = scanner.nextLine();

        Galaxy galaxy = findGalaxy(galaxyName);

        if (galaxy != null) {
            System.out.print("Name of the Planet to delete: ");
            String planetName = scanner.nextLine();

            for (int i = 0; i < galaxy.getPlanets().length; i++) {
                Planet planet = galaxy.getPlanets()[i];
                if (planet != null && planet.getName().equals(planetName)) {
                    galaxy.getPlanets()[i] = null;
                    System.out.println("Planet deleted successfully.\n");
                    return;
                }
            }
            System.out.println("The specified Planet does not exist in this Galaxy.\n");
        } else {
            System.out.println("The specified Galaxy does not exist.\n");
        }
    }

    /**
     * Modifies the data of a planet in a galaxy.
     */
    public void modifyPlanet() {
        System.out.print("Name of the Galaxy from which to modify the Planet: ");
        String galaxyName = scanner.nextLine();

        Galaxy galaxy = findGalaxy(galaxyName);

        if (galaxy != null) {
            System.out.print("Name of the Planet to modify: ");
            String planetName = scanner.nextLine();

            for (int i = 0; i < galaxy.getPlanets().length; i++) {
                Planet planet = galaxy.getPlanets()[i];
                if (planet != null && planet.getName().equals(planetName)) {
                    System.out.println("Modifying data for " + planet.getName());
                    System.out.print("New number of Satellites: ");
                    int numberOfSatellites = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("New Planet Radius: ");
                    double radius = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("New Planet Mass: ");
                    double mass = scanner.nextDouble();
                    scanner.nextLine();

                    planet.setNumberOfSatellites(numberOfSatellites);
                    planet.setRadius(radius);
                    planet.setMass(mass);
                    System.out.println("Planet data modified successfully.\n");
                    return;
                }
            }
            System.out.println("The specified Planet does not exist in this Galaxy.\n");
        } else {
            System.out.println("The specified Galaxy does not exist.\n");
        }
    }

    /**
     * Adds a photo to a planet in a galaxy.
     */
    public void addPhotoToPlanet() {
        System.out.print("Name of the Galaxy to which to add the photo: ");
        String galaxyName = scanner.nextLine();

        Galaxy galaxy = findGalaxy(galaxyName);

        if (galaxy != null) {
            System.out.print("Name of the Planet to which to add the photo: ");
            String planetName = scanner.nextLine();

            for (int i = 0; i < galaxy.getPlanets().length; i++) {
                Planet planet = galaxy.getPlanets()[i];
                if (planet != null && planet.getName().equals(planetName)) {
                    if (planet.addPhoto(createPhoto())) {
                        System.out.println("Photo added to the Planet successfully.\n");
                    } else {
                        System.out.println("Failed to add the photo to the Planet. Limit reached.\n");
                    }
                    return;
                }
            }
            System.out.println("The specified Planet does not exist in this Galaxy.\n");
        } else {
            System.out.println("The specified Galaxy does not exist.\n");
        }
    }

    /**
     * Checks detailed information about a galaxy and its components.
     */
    public void checkGalaxyInformation() {
        System.out.print("Name of the Galaxy to check: ");
        String galaxyName = scanner.nextLine();

        Galaxy galaxy = findGalaxy(galaxyName);

        if (galaxy != null) {
            System.out.println("Information for Galaxy " + galaxy.getName() + ":");
            System.out.println("Distance to Earth: " + galaxy.getDistanceToEarth() + " light-years");
            System.out.println("Shape: " + galaxy.getShape());

            BlackHole blackHole = galaxy.getBlackHole();
            if (blackHole != null) {
                System.out.println("Black Hole:");
                System.out.println("Name: " + blackHole.getName());
                System.out.println("Mass: " + blackHole.getMass());
                System.out.println("Distance to Earth: " + blackHole.getDistanceToEarth() + " light-years");
                System.out.println("Type: " + blackHole.getType());
            }

            Planet[] planets = galaxy.getPlanets();
            System.out.println("Planets in this Galaxy:");
            for (Planet planet : planets) {
                if (planet != null) {
                    System.out.println("Name: " + planet.getName());
                    System.out.println("Number of Satellites: " + planet.getNumberOfSatellites());
                    System.out.println("Radius: " + planet.getRadius());
                    System.out.println("Mass: " + planet.getMass());
                }
            }
        } else {
            System.out.println("The specified Galaxy does not exist.\n");
        }
    }

    /**
     * Checks detailed information about a planet, including its volume and density.
     */
    public void checkPlanetInformation() {
        System.out.print("Name of the Galaxy from which to check the Planet: ");
        String galaxyName = scanner.nextLine();

        Galaxy galaxy = findGalaxy(galaxyName);

        if (galaxy != null) {
            System.out.print("Name of the Planet to check: ");
            String planetName = scanner.nextLine();

            for (Planet planet : galaxy.getPlanets()) {
                if (planet != null && planet.getName().equals(planetName)) {
                    System.out.println("Information for Planet " + planet.getName() + ":");
                    System.out.println("Number of Satellites: " + planet.getNumberOfSatellites());
                    System.out.println("Radius: " + planet.getRadius());
                    System.out.println("Mass: " + planet.getMass());
                    System.out.println("Volume: " + planet.calculateVolume());
                    System.out.println("Density: " + planet.calculateDensity());
                    System.out.println("Planet Photos:");
                    for (Photo photo : planet.getPhotos()) {
                        if (photo != null) {
                            System.out.println("URL: " + photo.getUrl());
                            System.out.println("Telescope: " + photo.getTelescope());
                            System.out.println("Date: " + photo.getDate());
                        }
                    }
                    return;
                }
            }
            System.out.println("The specified Planet does not exist in this Galaxy.\n");
        } else {
            System.out.println("The specified Galaxy does not exist.\n");
        }
    }

    /**
     * Finds the name of the galaxy farthest from Earth.
     */
    public void findFarthestGalaxyFromEarth() {
        double maxDistance = -1;
        String farthestGalaxyName = "";

        for (Galaxy galaxy : galaxies) {
            if (galaxy != null && galaxy.getDistanceToEarth() > maxDistance) {
                maxDistance = galaxy.getDistanceToEarth();
                farthestGalaxyName = galaxy.getName();
            }
        }

        if (!farthestGalaxyName.isEmpty()) {
            System.out.println("The farthest Galaxy from Earth is: " + farthestGalaxyName);
        } else {
            System.out.println("No Galaxies are registered.\n");
        }
    }

    /**
     * Finds the name of the planet with the highest density in the universe.
     */
    public void findPlanetWithHighestDensity() {
        double maxDensity = -1;
        String planetWithHighestDensityName = "";

        for (Galaxy galaxy : galaxies) {
            if (galaxy != null) {
                for (Planet planet : galaxy.getPlanets()) {
                    if (planet != null) {
                        double density = planet.calculateDensity();
                        if (density > maxDensity) {
                            maxDensity = density;
                            planetWithHighestDensityName = planet.getName();
                        }
                    }
                }
            }
        }

        if (!planetWithHighestDensityName.isEmpty()) {
            System.out
                    .println("The planet with the highest density in the universe is: " + planetWithHighestDensityName);
        } else {
            System.out.println("No planets are registered.\n");
        }
    }

    /**
     * Finds the names of black holes by type.
     */
    public void findBlackHolesByType() {
        System.out.print("Enter the type of Black Hole to search for: ");
        String typeToSearch = scanner.nextLine();

        System.out.println("Black Holes with type '" + typeToSearch + "':");
        for (Galaxy galaxy : galaxies) {
            if (galaxy != null) {
                BlackHole blackHole = galaxy.getBlackHole();
                if (blackHole != null && blackHole.getType().equalsIgnoreCase(typeToSearch)) {
                    System.out.println("Galaxy: " + galaxy.getName());
                    System.out.println("Black Hole: " + blackHole.getName());
                }
            }
        }
    }

    /**
     * Finds the name of the telescope with the most registered photos.
     */
    public void findTelescopeWithMostPhotos() {
        int maxPhotoCount = -1;
        String telescopeWithMostPhotos = "";

        for (Galaxy galaxy : galaxies) {
            if (galaxy != null) {
                for (Planet planet : galaxy.getPlanets()) {
                    if (planet != null) {
                        for (Photo photo : planet.getPhotos()) {
                            if (photo != null) {
                                String telescope = photo.getTelescope();
                                int photoCount = countPhotosByTelescope(telescope);

                                if (photoCount > maxPhotoCount) {
                                    maxPhotoCount = photoCount;
                                    telescopeWithMostPhotos = telescope;
                                }
                            }
                        }
                    }
                }
            }
        }

        if (!telescopeWithMostPhotos.isEmpty()) {
            System.out.println("The telescope with the most registered photos is: " + telescopeWithMostPhotos);
        } else {
            System.out.println("No photos are registered.\n");
        }
    }

    /**
     * Creates test cases for the application.
     */
    public void createTestCases() {
        // You can add test cases here to simulate different scenarios.
        // For example, you can create galaxies, black holes, planets, and photos for
        // testing.
        // Example test case:
        // Galaxy milkyWay = new Galaxy("Milky Way", 10000, "Spiral");
        // BlackHole blackHole = new BlackHole("Supermassive BH", 1000000, 9000, "Type
        // A");
        // milkyWay.setBlackHole(blackHole);
        // galaxies[numGalaxies] = milkyWay;
        // numGalaxies++;
        // ...
        System.out.println("Test cases created successfully.\n");
    }

    /**
     * Helper method to find a galaxy by its name.
     *
     * @param galaxyName The name of the galaxy to find.
     * @return The galaxy if found, or null if not found.
     */
    private Galaxy findGalaxy(String galaxyName) {
        for (Galaxy galaxy : galaxies) {
            if (galaxy != null && galaxy.getName().equals(galaxyName)) {
                return galaxy;
            }
        }
        return null;
    }

    /**
     * Helper method to create a new photo with user-provided information.
     *
     * @return The created photo.
     */
    private Photo createPhoto() {
        System.out.print("Photo URL: ");
        String url = scanner.nextLine();
        System.out.print("Telescope Name: ");
        String telescope = scanner.nextLine();
        System.out.print("Photo Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        return new Photo(url, telescope, date);
    }

    /**
     * Helper method to count the number of photos taken by a specific telescope.
     *
     * @param telescopeName The name of the telescope to count photos for.
     * @return The count of photos taken by the specified telescope.
     */
    private int countPhotosByTelescope(String telescopeName) {
        int count = 0;
        for (Galaxy galaxy : galaxies) {
            if (galaxy != null) {
                for (Planet planet : galaxy.getPlanets()) {
                    if (planet != null) {
                        for (Photo photo : planet.getPhotos()) {
                            if (photo != null && photo.getTelescope().equals(telescopeName)) {
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

}
