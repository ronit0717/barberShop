package com.rccode.model;

public class BarberShop {
    private boolean[] seats;
    private int seatPointer;
    private int barberPointer;

    public BarberShop(int seatCount) {
        seats = new boolean[seatCount];
        seatPointer = 0;
        barberPointer = 0;
    }

    public boolean barberStatus() {
        if (barberPointer == seatPointer && !seats[barberPointer % seats.length]) {
            return false; //sleeping
        }
        return true; //barber is active
    }

    public boolean canAllocateSet() {
        if (seats[seatPointer % seats.length]) {
            return false;
        }
        return true;
    }

    public void allocateSeat() {
        seats[seatPointer % seats.length] = true;
        seatPointer++;
    }

    public void processHairCutting() {
        seats[barberPointer % seats.length] = false;
        barberPointer++;
    }
}
