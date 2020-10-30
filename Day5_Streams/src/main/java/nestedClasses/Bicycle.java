package nestedClasses;

public class Bicycle {

    private String model;
    private int weight;

    public Bicycle(String model, int weight) {
        this.model = model;
        this.weight = weight;
    }

    public void start() {
        System.out.println("Go!");
    }

    public class SteeringWheel {
        public void right() {
            System.out.println("Right!");
        }

        public void left() {
            System.out.println("Left!");
        }
    }

    public class Seat {
        public void up() {
            System.out.println("Seat is up");
        }

        public void down() {
            System.out.println("Seat id down");
        }
    }
}
