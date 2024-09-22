import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        // Créer un canevas pour dessiner les routes et véhicules
        Canvas canvas = new Canvas(800, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Initialiser l'environnement du carrefour
        TrafficSimulation simulation = new TrafficSimulation(gc);

        // Créer la scène et ajouter les contrôles clavier
        Scene scene = new Scene(new Group(canvas));
        scene.setOnKeyPressed(e -> handleKeyPress(e.getCode(), simulation));

        // Configurer la fenêtre et afficher
        stage.setTitle("Traffic Simulation");
        stage.setScene(scene);
        stage.show();
    }

    // Gérer les touches du clavier pour ajouter des véhicules
    private void handleKeyPress(KeyCode keyCode, TrafficSimulation simulation) {
        switch (keyCode) {
            case UP:
                simulation.spawnVehicle("SOUTH");
                break;
            case DOWN:
                simulation.spawnVehicle("NORTH");
                break;
            case LEFT:
                simulation.spawnVehicle("EAST");
                break;
            case RIGHT:
                simulation.spawnVehicle("WEST");
                break;
            case R:
                simulation.spawnVehicle("RANDOM");
                break;
            case ESCAPE:
                System.exit(0);
                break;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
