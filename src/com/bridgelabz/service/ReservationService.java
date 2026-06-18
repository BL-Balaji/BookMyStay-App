package com.bridgelabz.service;

import com.bridgelabz.inventory.RoomInventoryManager;
import com.bridgelabz.model.BookingConfirmation;
import com.bridgelabz.model.Reservation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ReservationService {

    // All assigned room IDs
    private final Set<String> bookedRoomIds =
            new HashSet<>();

    // RoomType -> Assigned Rooms
    private final Map<String, Set<String>>
            allocatedRooms = new HashMap<>();

    private final RoomInventoryManager inventoryManager;

    public ReservationService(
            RoomInventoryManager inventoryManager) {

        this.inventoryManager = inventoryManager;
    }

    /**
     * Confirm reservation
     */
    public BookingConfirmation confirmBooking(
            Reservation reservation) {

        String roomType =
                reservation.getRoomType();

        if (!inventoryManager
                .isRoomAvailable(roomType)) {

            System.out.println(
                    "Booking Failed : No rooms available.");

            return null;
        }

        String roomId =
                generateUniqueRoomId(roomType);

        bookedRoomIds.add(roomId);

        allocatedRooms
                .computeIfAbsent(
                        roomType,
                        k -> new HashSet<>())
                .add(roomId);

        inventoryManager
                .decrementRoomCount(roomType);

        return new BookingConfirmation(
                reservation.getGuestName(),
                roomType,
                roomId);
    }

    /**
     * Generate unique room ID
     */
    private String generateUniqueRoomId(
            String roomType) {

        String roomId;

        do {

            roomId =
                    roomType.substring(0, 1)
                            .toUpperCase()
                            + (100 +
                            bookedRoomIds.size());

        } while (
                bookedRoomIds.contains(roomId));

        return roomId;
    }

    public void displayAllocatedRooms() {

        System.out.println(
                "\n===== ROOM ALLOCATION =====");

        allocatedRooms.forEach(
                (type, rooms) -> {

                    System.out.println(
                            type + " -> " + rooms);
                });
    }
}
