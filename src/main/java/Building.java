public class Building {
    private int[] floors;

    public Building(int numFloors) {
        floors = new int[numFloors];
    }

    public void callElevator(int floor) {
        floors[floor]++;
    }

    public void getInElevator(int floor) {
        floors[floor]--;
    }

    public int getWaitingCount(int floor) {
        return floors[floor];
    }
}
