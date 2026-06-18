package com.bridgelabz;

import com.bridgelabz.inventory.RoomInventoryManager;
import com.bridgelabz.model.Reservation;
import com.bridgelabz.service.BookingQueueService;
import com.bridgelabz.service.ReservationService;

import java.util.List;

public class BookMyStayApp {

    public static void main(String[] args) {

        RoomInventoryManager inventoryManager =
                new RoomInventoryManager();

        inventoryManager.addRoomType(
                "Single",
                2,
                2500,
                List.of("WiFi", "AC"));

        inventoryManager.addRoomType(
                "Double",
                1,
                4500,
                List.of("WiFi", "TV"));

        BookingQueueService queueService =
                new BookingQueueService();

        queueService.submitBookingRequest(
                new Reservation(
                        "Balaji",
                        "Single",
                        2));

        queueService.submitBookingRequest(
                new Reservation(
                        "Rahul",
                        "Single",
                        1));

        queueService.submitBookingRequest(
                new Reservation(
                        "Amit",
                        "Single",
                        1));

        ReservationService reservationService =
                new ReservationService(
                        inventoryManager);

        while (
                queueService.getPendingRequestCount()
                        > 0) {

            Reservation reservation =
                    queueService.processNextRequest();

            if (reservation != null) {

                System.out.println(
                        reservationService
                                .confirmBooking(
                                        reservation));
            }
        }

        reservationService
                .displayAllocatedRooms();
    }
}