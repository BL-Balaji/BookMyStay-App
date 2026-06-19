package com.bridgelabz.model;

public class BookingConfirmation {

    private String reservationId;
    private String guestName;
    private String roomType;
    private String roomId;

    public BookingConfirmation(String reservationId,
                               String guestName,
                               String roomType,
                               String roomId) {

        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomType = roomType;
        this.roomId = roomId;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getRoomId() {
        return roomId;
    }

    @Override
    public String toString() {

        return "\nReservation ID : " + reservationId +
                "\nGuest : " + guestName +
                "\nRoom Type : " + roomType +
                "\nRoom ID : " + roomId;
    }
}
