import javafx.scene.canvas.GraphicsContext;
import java.util.ArrayList;
import java.util.List;

public class TrafficSimulation {
    private GraphicsContext gc;
    private List<Vehicle> vehicles;
    private List<Road> roads;
    private List<TrafficLight> trafficLights;

    public TrafficSimulation(GraphicsContext gc) {
        this.gc = gc;
        this.vehicles = new ArrayList<>();
        this.roads = new ArrayList<>();
        this.trafficLights = new ArrayList<>();

        // Initialiser les routes et feux de signalisation
        setupIntersection();
    }

    // Initialiser les routes et feux de signalisation
    private void setupIntersection() {
        roads.add(new Road("NORTH"));
        roads.add(new Road("SOUTH"));
        roads.add(new Road("EAST"));
        roads.add(new Road("WEST"));

        for (Road road : roads) {
            trafficLights.add(new TrafficLight(road));
        }
    }

    // Gérer l'ajout de nouveaux véhicules
    public void spawnVehicle(String direction) {
        Road road;
        switch (direction) {
            case "NORTH":
                road = getRoadByDirection("NORTH");
                vehicles.add(new Vehicle(road, randomRoute()));
                break;
            case "SOUTH":
                road = getRoadByDirection("SOUTH");
                vehicles.add(new Vehicle(road, randomRoute()));
                break;
            case "EAST":
                road = getRoadByDirection("EAST");
                vehicles.add(new Vehicle(road, randomRoute()));
                break;
            case "WEST":
                road = getRoadByDirection("WEST");
                vehicles.add(new Vehicle(road, randomRoute()));
                break;
            case "RANDOM":
                road = roads.get((int) (Math.random() * roads.size()));
                vehicles.add(new Vehicle(road, randomRoute()));
                break;
        }

        // Dessiner la mise à jour
        drawSimulation();
    }

    // Dessiner les routes, feux et véhicules
    public void drawSimulation() {
        gc.clearRect(0, 0, 800, 600);  // Effacer l'ancienne frame

        // Dessiner les routes et feux
        for (TrafficLight trafficLight : trafficLights) {
            trafficLight.draw(gc);
        }

        // Dessiner les véhicules
        for (Vehicle vehicle : vehicles) {
            vehicle.draw(gc);
        }
    }

    // Obtenir une route par direction
    private Road getRoadByDirection(String direction) {
        for (Road road : roads) {
            if (road.getDirection().equals(direction)) {
                return road;
            }
        }
        return null;
    }

    // Générer un itinéraire aléatoire pour les véhicules (gauche, droite ou tout droit)
    private String randomRoute() {
        String[] routes = {"LEFT", "STRAIGHT", "RIGHT"};
        return routes[(int) (Math.random() * routes.length)];
    }
}
