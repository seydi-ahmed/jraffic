import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class TrafficLight {
    private boolean isGreen;
    private Road road;

    public TrafficLight(Road road) {
        this.road = road;
        this.isGreen = false; // Commence par être rouge
    }

    public void changeLight() {
        isGreen = !isGreen; // Alterne entre vert et rouge
    }

    public boolean isGreen() {
        return isGreen;
    }

    public void draw(GraphicsContext gc) {
        if (isGreen) {
            gc.setFill(Color.GREEN);
        } else {
            gc.setFill(Color.RED);
        }
        // Dessiner le feu en fonction de sa position sur la route
        // Ici, simplifié : tu peux ajuster les positions
        gc.fillRect(100, 100, 20, 20);
    }
}
