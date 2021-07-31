package com.rccode.service;

import com.rccode.model.BarberShop;

public class ShopManagementService {

    private BarberShop barberShop;

    public ShopManagementService(BarberShop barberShop) {
        this.barberShop = barberShop;
    }

    public void allocateSeat() {
        if (barberShop.canAllocateSet()) {
            barberShop.allocateSeat();
            System.out.println("Seat allocated\n");
        } else {
            System.out.println("Shop is full, seat cannot be allocated\n");
        }
    }

    public void cutHair() {
        if (barberShop.barberStatus()) {
            barberShop.processHairCutting();
            System.out.println("Hair cut done\n");
        } else {
            System.out.println("No customer, barber sleeping\n");
        }
    }

    public void checkBarberStatus() {
        if (barberShop.barberStatus()) {
            System.out.println("Barber is active\n");
        } else {
            System.out.println("Barber is sleeping\n");
        }
    }

}
