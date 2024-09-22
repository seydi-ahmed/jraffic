import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Vehicle {
    private Road road;  // La route sur laquelle le véhicule est placé
    private String route;  // Le chemin que le véhicule va suivre (gauche, tout droit, droite)
    private double x, y;  // Position du véhicule sur la scène
    private double speed;  // Vitesse du véhicule
    private Color color;  // Couleur du véhicule en fonction de son itinéraire

    public Vehicle(Road road, String route) {
        this.road = road;
        this.route = route;
        this.speed = 2.0;  // Vitesse fixe
        initializePosition();
        setColorBasedOnRoute();
    }

    // Initialiser la position du véhicule en fonction de la route
    private void initializePosition() {
        switch (road.getDirection()) {
            case "NORTH":
                this.x = 375;
                this.y = 0;
                break;
            case "SOUTH":
                this.x = 425;
                this.y = 600;
                break;
            case "EAST":
                this.x = 0;
                this.y = 275;
                break;
            case "WEST":
                this.x = 800;
                this.y = 325;
                break;
        }
    }

    // Définir la couleur en fonction de l'itinéraire
    private void setColorBasedOnRoute() {
        switch (route) {
            case "LEFT":
                this.color = Color.YELLOW;
                break;
            case "STRAIGHT":
                this.color = Color.BLUE;
                break;
            case "RIGHT":
                this.color = Color.GREEN;
                break;
        }
    }

    // Dessiner le véhicule
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillRect(x, y, 20, 10);  // Taille simple d'un véhicule (20x10)
    }

    // Déplacer le véhicule selon sa direction et route choisie
    public void move() {
        switch (road.getDirection()) {
            case "NORTH":
                y += speed;  // Se déplace vers le bas
                break;
            case "SOUTH":
                y -= speed;  // Se déplace vers le haut
                break;
            case "EAST":
                x += speed;  // Se déplace vers la droite
                break;
            case "WEST":
                x -= speed;  // Se déplace vers la gauche
                break;
        }
    }

    // Retourner la position actuelle du véhicule
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
