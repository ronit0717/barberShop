package model;

public class BarberShop {
    private boolean[] seats;
    int seatPointer;
    int barberPointer;

    public BarberShop(int seatCount) {
        seats = new boolean[seatCount];
        seatPointer = 0;
        barberPointer = 0;
    }
}
