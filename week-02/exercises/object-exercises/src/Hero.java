public class Hero {
    private String name;     // Super hero name
    private Power[] powers;  // Array of super powers

    // Constructor with name and powers parameters
    public Hero(String name, Power[] powers) {
        this.name = name;
        this.powers = powers;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for powers
    public Power[] getPowers() {
        return powers;
    }
    public String toLine() {
        String powersText = "";
        for (int i = 0; i < powers.length; i++) {
            if (i > 0) {
                powersText += ", ";
            }
            powersText += powers[i].getName();
        }

        return name + " has the powers: " + powersText;
    }
}