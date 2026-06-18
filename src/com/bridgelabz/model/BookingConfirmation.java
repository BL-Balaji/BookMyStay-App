package com.bridgelabz.model;

public class BookingConfirmation {

    private String guestName;
    private String roomType;
    private String roomId;

    public BookingConfirmation(String guestName,
                               String roomType,
                               String roomId) {

        this.guestName = guestName;
        this.roomType = roomType;
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "\nBooking Confirmed" +
                "\nGuest : " + guestName +
                "\nRoom Type : " + roomType +
                "\nAssigned Room : " + roomId;
    }
}
