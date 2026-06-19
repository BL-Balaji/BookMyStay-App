package com.bridgelabz.service;

import com.bridgelabz.inventory.RoomInventoryManager;
import com.bridgelabz.model.BookingConfirmation;
import com.bridgelabz.model.Reservation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ReservationService {

    // Unique Room IDs
    private final Set<String> bookedRoomIds;

    // RoomType -> Assigned Room IDs
    private final Map<String, Set<String>> allocatedRooms;

    private final RoomInventoryManager inventoryManager;

    // Reservation ID Generator
    private int reservationCounter;

    public ReservationService(RoomInventoryManager inventoryManager) {

        this.inventoryManager = inventoryManager;
        this.bookedRoomIds = new HashSet<>();
        this.allocatedRooms = new HashMap<>();
        this.reservationCounter = 1000;
    }

    /**
     * Confirm booking and allocate room
     */
    public BookingConfirmation confirmBooking(
            Reservation reservation) {

        String roomType = reservation.getRoomType();

        // Availability Check
        if (!inventoryManager.isRoomAvailable(roomType)) {

            System.out.println(
                    "Booking Failed : No rooms available for "
                            + roomType);

            return null;
        }

        // Generate Reservation ID
        String reservationId =
                "RES" + reservationCounter++;

        // Generate Room ID
        String roomId =
                generateUniqueRoomId(roomType);

        // Store Room ID
        bookedRoomIds.add(roomId);

        allocatedRooms
                .computeIfAbsent(
                        roomType,
                        k -> new HashSet<>())
                .add(roomId);

        // Reduce Inventory
        inventoryManager.decrementRoomCount(roomType);

        return new BookingConfirmation(
                reservationId,
                reservation.getGuestName(),
                roomType,
                roomId
        );
    }

    /**
     * Generate unique room id
     */
    private String generateUniqueRoomId(
            String roomType) {

        String prefix;

        switch (roomType.toUpperCase()) {

            case "SINGLE":
                prefix = "S";
                break;

            case "DOUBLE":
                prefix = "D";
                break;

            case "SUITE":
                prefix = "SU";
                break;

            default:
                prefix = "R";
        }

        String roomId;

        do {

            roomId =
                    prefix +
                            (100 + bookedRoomIds.size());

        } while (bookedRoomIds.contains(roomId));

        return roomId;
    }

    /**
     * Display Allocated Rooms
     */
    public void displayAllocatedRooms() {

        System.out.println(
                "\n========= ALLOCATED ROOMS =========");

        allocatedRooms.forEach(
                (roomType, roomIds) -> {

                    System.out.println(
                            roomType +
                                    " -> " +
                                    roomIds);
                });
    }

    /**
     * Total allocated rooms
     */
    public int getAllocatedRoomCount() {

        return bookedRoomIds.size();
    }

    /**
     * Check room already allocated
     */
    public boolean isRoomAllocated(
            String roomId) {

        return bookedRoomIds.contains(roomId);
    }
}
