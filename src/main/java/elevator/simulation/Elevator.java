package elevator.simulation;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Elevator extends Thread {
    private Building building;
    private int numFloors;
    private int currentFloor;
    private boolean isMovingUp;
    private Lock lock;

    public Elevator(Building building, int numFloors) {
        this.building = building;
        this.numFloors = numFloors;
        currentFloor = 0;
        isMovingUp = true;
        lock = new ReentrantLock();
    }

    public void run() {
        while (true) {
            // Changing the direction of the elevator
            if (currentFloor == numFloors - 1)
                isMovingUp = false;
            else if (currentFloor == 0)
                isMovingUp = true;

            // Locking operation while the lift is moving
            lock.lock();
            try {
                int numPassengers = building.getWaitingCount(currentFloor);
                if (numPassengers > 0) {
                    System.out.println("Elevator " + getId() + " on the floor " + numPassengers + " took the human.");
                    building.getInElevator(currentFloor);
                }
            } finally {
                lock.unlock();
            }

            // org.example.Elevator moving to the next floor
            try {
                TimeUnit.SECONDS.sleep(2); // org.example.Elevator speed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (isMovingUp)
                currentFloor++;
            else
                currentFloor--;
        }
    }
}
