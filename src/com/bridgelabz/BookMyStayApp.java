package com.bridgelabz;

import java.util.List;

public class BookMyStayApp {

    public static void main(String[] args) {

        RoomInventoryManager inventoryManager =
                new RoomInventoryManager();

        inventoryManager.addRoomType(
                "Single",
                10,
                2500,
                List.of(
                        "WiFi",
                        "AC",
                        "TV")
        );

        inventoryManager.addRoomType(
                "Double",
                5,
                4500,
                List.of(
                        "WiFi",
                        "AC",
                        "TV",
                        "Mini Bar")
        );

        inventoryManager.addRoomType(
                "Suite",
                0,
                9000,
                List.of(
                        "WiFi",
                        "AC",
                        "TV",
                        "Jacuzzi",
                        "Balcony")
        );

        SearchService searchService =
                new SearchService(inventoryManager);

        // Search all available rooms
        searchService.searchAvailableRooms();

        // Search specific room
        searchService.searchRoom("Double");

        searchService.searchRoom("Suite");
    }
}