package com.bridgelabz.service;
import com.bridgelabz.model.BookingConfirmation;

import java.util.ArrayList;
import java.util.List;

public class BookingHistoryService {

    private final List<BookingConfirmation>
            bookingHistory;

    public BookingHistoryService() {

        bookingHistory = new ArrayList<>();
    }

    /**
     * Store confirmed booking
     */
    public void addBooking(
            BookingConfirmation booking) {

        bookingHistory.add(booking);

        System.out.println(
                booking.getReservationId()
                        + " stored in history.");
    }

    /**
     * Display complete booking history
     */
    public void displayBookingHistory() {

        System.out.println(
                "\n========= BOOKING HISTORY =========");

        if (bookingHistory.isEmpty()) {

            System.out.println(
                    "No bookings available.");

            return;
        }

        bookingHistory.forEach(
                System.out::println);
    }

    /**
     * Find booking by reservation id
     */
    public BookingConfirmation findBooking(
            String reservationId) {

        for (BookingConfirmation booking :
                bookingHistory) {

            if (booking.getReservationId()
                    .equalsIgnoreCase(
                            reservationId)) {

                return booking;
            }
        }

        return null;
    }

    /**
     * Cancel booking
     */
    public void cancelBooking(
            String reservationId) {

        BookingConfirmation booking =
                findBooking(reservationId);

        if (booking == null) {

            System.out.println(
                    "Booking not found.");

            return;
        }

        booking.setStatus("CANCELLED");

        System.out.println(
                reservationId +
                        " cancelled successfully.");
    }

    /**
     * Generate report
     */
    public void generateReport() {

        long confirmedCount =
                bookingHistory.stream()
                        .filter(
                                booking ->
                                        booking.getStatus()
                                                .equals(
                                                        "CONFIRMED"))
                        .count();

        long cancelledCount =
                bookingHistory.stream()
                        .filter(
                                booking ->
                                        booking.getStatus()
                                                .equals(
                                                        "CANCELLED"))
                        .count();

        System.out.println(
                "\n========= REPORT =========");

        System.out.println(
                "Total Bookings : "
                        + bookingHistory.size());

        System.out.println(
                "Confirmed : "
                        + confirmedCount);

        System.out.println(
                "Cancelled : "
                        + cancelledCount);
    }
}
