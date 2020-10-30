package nestedClasses;

public class Main2 {
    public static void main(String[] args) {
        Bicycle bicycle = new Bicycle("kek", 2000);
        Bicycle.Seat seat = bicycle.new Seat();
        Bicycle.SteeringWheel steeringWheel = bicycle.new SteeringWheel();

        bicycle.start();

        seat.down();
        seat.up();

        steeringWheel.left();
        steeringWheel.right();
    }
}
