package com.bridgelabz;

import com.bridgelabz.inventory.RoomInventoryManager;
import com.bridgelabz.model.BookingConfirmation;
import com.bridgelabz.model.Reservation;
import com.bridgelabz.model.Service;
import com.bridgelabz.service.AddOnServiceManager;
import com.bridgelabz.service.BookingQueueService;
import com.bridgelabz.service.ReservationService;
import com.bridgelabz.service.SearchService;

import java.util.List;

public class BookMyStayApp {

    public static void main(String[] args) {

        // UC1 Inventory Setup
        RoomInventoryManager inventoryManager =
                new RoomInventoryManager();

        inventoryManager.addRoomType(
                "Single",
                3,
                2500,
                List.of(
                        "WiFi",
                        "AC",
                        "TV"));

        inventoryManager.addRoomType(
                "Double",
                2,
                4500,
                List.of(
                        "WiFi",
                        "AC",
                        "TV",
                        "Mini Bar"));

        inventoryManager.addRoomType(
                "Suite",
                1,
                9000,
                List.of(
                        "WiFi",
                        "AC",
                        "TV",
                        "Jacuzzi"));

        // UC2 Search Rooms
        SearchService searchService =
                new SearchService(inventoryManager);

        searchService.searchAvailableRooms();

        // UC3 Booking Requests
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
                        "Double",
                        3));

        queueService.submitBookingRequest(
                new Reservation(
                        "Amit",
                        "Suite",
                        1));

        // UC4 Reservation Confirmation
        ReservationService reservationService =
                new ReservationService(
                        inventoryManager);

        AddOnServiceManager serviceManager =
                new AddOnServiceManager();

        while (queueService
                .getPendingRequestCount() > 0) {

            Reservation reservation =
                    queueService.processNextRequest();

            BookingConfirmation booking =
                    reservationService
                            .confirmBooking(
                                    reservation);

            if (booking != null) {

                System.out.println(
                        "\n========== BOOKING CONFIRMED ==========");

                System.out.println(booking);

                // UC5 Add-On Services

                serviceManager.addService(
                        booking.getReservationId(),
                        new Service(
                                "Breakfast",
                                500));

                serviceManager.addService(
                        booking.getReservationId(),
                        new Service(
                                "Airport Pickup",
                                1200));

                serviceManager.displayServices(
                        booking.getReservationId());

                double serviceCost =
                        serviceManager
                                .calculateServiceCost(
                                        booking.getReservationId());

                System.out.println(
                        "Additional Service Cost : ₹"
                                + serviceCost);

                System.out.println(
                        "========================================");
            }
        }

        reservationService.displayAllocatedRooms();

        System.out.println(
                "\nRemaining Inventory");

        searchService.searchAvailableRooms();
    }
}