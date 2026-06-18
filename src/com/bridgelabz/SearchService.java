package com.bridgelabz;

import java.util.Map;

public class SearchService {

    private final RoomInventoryManager inventoryManager;

    public SearchService(RoomInventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    /**
     * Display only available rooms
     */
    public void searchAvailableRooms() {

        Map<String, Room> inventory =
                inventoryManager.getInventory();

        System.out.println(
                "\n======= AVAILABLE ROOMS =======");

        boolean roomFound = false;

        for (Map.Entry<String, Room> entry :
                inventory.entrySet()) {

            Room room = entry.getValue();

            if (room.getAvailableCount() > 0) {

                roomFound = true;

                System.out.println(
                        "\nRoom Type : " + entry.getKey());

                System.out.println(room);
            }
        }

        if (!roomFound) {
            System.out.println(
                    "No rooms available currently.");
        }
    }

    /**
     * Search specific room type
     */
    public void searchRoom(String roomType) {

        Map<String, Room> inventory =
                inventoryManager.getInventory();

        if (!inventory.containsKey(roomType)) {

            System.out.println(
                    "Room Type Not Found.");
            return;
        }

        Room room = inventory.get(roomType);

        System.out.println(
                "\n===== ROOM DETAILS =====");

        System.out.println(
                "Room Type : " + roomType);

        System.out.println(room);

        if (room.getAvailableCount() == 0) {

            System.out.println(
                    "Status : Not Available");
        } else {

            System.out.println(
                    "Status : Available");
        }
    }
}
