import java.util.List;
import javafx.animation.AnimationTimer;

public class TrafficController {
    private List<TrafficLight> trafficLights;
    private long lastSwitchTime;
    private final long switchInterval = 3000; // Changer les feux toutes les 3 secondes

    public TrafficController(List<TrafficLight> trafficLights) {
        this.trafficLights = trafficLights;
        this.lastSwitchTime = System.currentTimeMillis();
    }

    // Méthode pour alterner les feux de signalisation
    public void manageLights() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastSwitchTime > switchInterval) {
            switchLights();
            lastSwitchTime = currentTime;
        }
    }

    // Alterner l'état des feux
    private void switchLights() {
        for (TrafficLight light : trafficLights) {
            light.changeLight();  // Alterne chaque feu rouge/vert
        }
    }

    // Méthode pour lancer un cycle automatique des feux
    public void startAutoControl() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                manageLights();
            }
        };
        timer.start();
    }
}
