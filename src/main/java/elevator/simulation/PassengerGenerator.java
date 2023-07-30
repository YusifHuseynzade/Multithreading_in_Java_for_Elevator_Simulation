package elevator.simulation;

import java.util.concurrent.TimeUnit;

public class PassengerGenerator extends Thread {
    private Building building;
    private int numFloors;
    private int floor;

    public PassengerGenerator(Building building, int numFloors, int floor) {
        this.building = building;
        this.numFloors = numFloors;
        this.floor = floor;
    }

    public void run() {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(3); // New passenger time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int numPassengers = (int) (Math.random() * 5) + 1; // Random number of passengers from 1 to 5
            System.out.println(numPassengers + " passenger " + floor + ". called the elevator on the floor.");
            building.callElevator(floor);
        }
    }
}
