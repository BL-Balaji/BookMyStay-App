package com.bridgelabz;

import com.bridgelabz.inventory.RoomInventoryManager;
import com.bridgelabz.model.BookingConfirmation;
import com.bridgelabz.model.Reservation;
import com.bridgelabz.model.Service;
import com.bridgelabz.service.*;

import java.util.List;

public class BookMyStayApp {

    public static void main(String[] args) {

        /*
         * ==========================================
         * UC1 : Room Inventory Setup & Management
         * ==========================================
         */
        RoomInventoryManager inventoryManager =
                new RoomInventoryManager();

        inventoryManager.addRoomType(
                "Single",
                3,
                2500,
                List.of("WiFi", "AC", "TV"));

        inventoryManager.addRoomType(
                "Double",
                2,
                4500,
                List.of("WiFi", "AC", "TV", "Mini Bar"));

        inventoryManager.addRoomType(
                "Suite",
                1,
                9000,
                List.of("WiFi", "AC", "TV", "Jacuzzi"));

        /*
         * ==========================================
         * UC2 : Search Available Rooms
         * ==========================================
         */
        SearchService searchService =
                new SearchService(inventoryManager);

        System.out.println(
                "\n========= AVAILABLE ROOMS =========");

        searchService.searchAvailableRooms();

        /*
         * ==========================================
         * UC3 : Booking Request Queue
         * ==========================================
         */
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

        queueService.submitBookingRequest(
                new Reservation(
                        "Kiran",
                        "Single",
                        2));

        /*
         * ==========================================
         * UC4 : Reservation Confirmation
         * ==========================================
         */
        ReservationService reservationService =
                new ReservationService(
                        inventoryManager);

        /*
         * ==========================================
         * UC5 : Add-On Services
         * ==========================================
         */
        AddOnServiceManager serviceManager =
                new AddOnServiceManager();

        /*
         * ==========================================
         * UC6 : Booking History
         * ==========================================
         */
        BookingHistoryService historyService =
                new BookingHistoryService();

        System.out.println(
                "\n========= PROCESSING BOOKINGS =========");

        while (queueService.getPendingRequestCount() > 0) {

            Reservation reservation =
                    queueService.processNextRequest();

            if (reservation == null) {
                continue;
            }

            BookingConfirmation booking =
                    reservationService
                            .confirmBooking(reservation);

            if (booking == null) {
                continue;
            }

            System.out.println(
                    "\n========= BOOKING CONFIRMED =========");

            System.out.println(booking);

            /*
             * Store Booking History
             */
            historyService.addBooking(booking);

            /*
             * Add Services
             */
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

            /*
             * Display Services
             */
            serviceManager.displayServices(
                    booking.getReservationId());

            double totalServiceCost =
                    serviceManager.calculateServiceCost(
                            booking.getReservationId());

            System.out.println(
                    "\nAdditional Service Cost : ₹"
                            + totalServiceCost);

            System.out.println(
                    "======================================");
        }

        /*
         * ==========================================
         * Display Allocated Rooms
         * ==========================================
         */
        reservationService.displayAllocatedRooms();

        /*
         * ==========================================
         * Remaining Inventory
         * ==========================================
         */
        System.out.println(
                "\n========= REMAINING INVENTORY =========");

        searchService.searchAvailableRooms();

        /*
         * ==========================================
         * Booking History
         * ==========================================
         */
        historyService.displayBookingHistory();

        /*
         * ==========================================
         * Cancel One Booking
         * ==========================================
         */
        System.out.println(
                "\n========= CANCEL BOOKING =========");

        historyService.cancelBooking("RES1001");

        /*
         * ==========================================
         * Generate Report
         * ==========================================
         */
        historyService.generateReport();

        /*
         * ==========================================
         * Final Booking History
         * ==========================================
         */
        System.out.println(
                "\n========= FINAL BOOKING HISTORY =========");

        historyService.displayBookingHistory();
    }
}