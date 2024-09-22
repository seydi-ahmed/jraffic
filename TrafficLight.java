public class TrafficLight {
    private boolean isGreen; // True if green, false if red
    private Road road; // The road this traffic light controls

    public TrafficLight(Road road) {
        this.road = road;
        this.isGreen = false; // Initially red
    }

    public void changeLight() {
        this.isGreen = !this.isGreen; // Toggle between green and red
    }

    public boolean isGreen() {
        return isGreen;
    }
}
