package com.bridgelabz.service;
import com.bridgelabz.model.Reservation;

import java.util.LinkedList;
import java.util.Queue;

public class BookingQueueService {

    private final Queue<Reservation> bookingQueue;

    public BookingQueueService() {
        bookingQueue = new LinkedList<>();
    }

    /**
     * Add booking request
     */
    public void submitBookingRequest(
            Reservation reservation) {

        bookingQueue.offer(reservation);

        System.out.println(
                reservation.getGuestName()
                        + " added to booking queue.");
    }

    /**
     * Process next request
     */
    public Reservation processNextRequest() {

        if (bookingQueue.isEmpty()) {

            System.out.println(
                    "No pending booking requests.");

            return null;
        }

        Reservation reservation =
                bookingQueue.poll();

        System.out.println(
                "Processing -> "
                        + reservation);

        return reservation;
    }

    /**
     * Show waiting requests
     */
    public void displayQueue() {

        System.out.println(
                "\n===== BOOKING QUEUE =====");

        if (bookingQueue.isEmpty()) {

            System.out.println(
                    "No requests pending.");
            return;
        }

        bookingQueue.forEach(System.out::println);
    }

    /**
     * Queue size
     */
    public int getPendingRequestCount() {

        return bookingQueue.size();
    }
}
