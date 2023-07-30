package elevator.simulation;


public class Main {
    public static void main(String[] args) {
        Building building = new Building(10);
        int numFloors = 10; // Total number of floors

        // We create the elevators
        Elevator elevator1 = new Elevator(building, numFloors);
        Elevator elevator2 = new Elevator(building, numFloors);

        // We start the elevators
        elevator1.start();
        elevator2.start();

        // We start threads that call people from different floors
        for (int i = 0; i < numFloors; i++) {
            PassengerGenerator passengerGenerator = new PassengerGenerator(building, numFloors, i);
            passengerGenerator.start();
        }
    }
}
