package com.rccode;

import constant.AppConstants;
import model.BarberShop;
import service.ShopManagementService;

import java.util.Scanner;

public class Main {

    private static BarberShop barberShop;
    private static ShopManagementService service;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Barber shop management service started, please enter number of seats...\n");
        int seatCount = sc.nextInt();
        while (seatCount < 1) {
            if (seatCount == -1) {
                System.out.println("Application terminated");
                return;
            }
            System.out.println("Invalid seat count, minimum 1 seat count required...\n");
            seatCount = sc.nextInt();
        }
        barberShop = new BarberShop(seatCount);
        service = new ShopManagementService(barberShop);
        System.out.println("Barber shop init completed, please enter commands...\n");
        sc.nextLine();

        while (sc.hasNextLine()) {
            String command = sc.nextLine();
            System.out.println();
            if (command.equals(AppConstants.EXIT_COMMAND)) {
                break;
            }
            processCommand(command);
            System.out.println();
        }

        System.out.println("Terminating barber shop management service");
    }

    private static void processCommand(String command) {
        try {
            switch (command) {
                case AppConstants.ALLOCATE_SEAT_COMMAND :
                    service.allocateSeat();
                    break;
                case AppConstants.CUT_HAIR_COMMAND :
                    service.cutHair();
                    break;
                case AppConstants.CHECK_BARBER_STATUS_COMMAND :
                    service.checkBarberStatus();
                    break;
                default:
                    System.out.println(AppConstants.INVALID_COMMAND_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(AppConstants.INVALID_COMMAND_MESSAGE);
        }
    }
}
