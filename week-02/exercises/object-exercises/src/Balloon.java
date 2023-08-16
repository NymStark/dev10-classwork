public class Balloon {
    private String color;
    private double psi;

    public Balloon(String color){
        this.color = color;
    }
    public String getColor() {
        return color;
    }

    public double getPsi() {
        return psi;
    }

    // 1. Create a new method in the Balloon class.
    // Name: inflate
    // Inputs: none
    // Output: void
    // Description: adds a random value to the psi field between 0.0 and 5.0
    // this.psi = this.psi + Math.random() * 5.0;

    public boolean isExploded() {
        return psi > 16.0;
    }
    public void inflate() {
        this.psi = this.psi + Math.random() * 5.0;
    }
}

