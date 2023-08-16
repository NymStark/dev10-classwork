public class Musician {

    private String name;
    private int rating;

    /**
     * @param name   The name of the musician.
     * @param rating A number representing how much a musician is loved relative to other musicians.
     */

    public Musician() {
        // Empty constructor
    }
    public Musician(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }
}
