public class Vehicle {
    private String route; // "LEFT", "RIGHT", "STRAIGHT"
    private Road road; // The road the vehicle is on
    private double speed; // Fixed speed

    public Vehicle(Road road, String route) {
        this.road = road;
        this.route = route;
        this.speed = 1.0; // Arbitrary speed
    }

    public void move() {
        // Logic to move the vehicle on the road
        if (canMove()) {
            // Move vehicle
        }
    }

    private boolean canMove() {
        // Logic to check if it can move (traffic light, vehicle in front, etc.)
        return true; // Simplified for now
    }
}
