package com.tts;

public class Entry {
    private final String firstName;
    private final String lastName;
    private final String phoneNumber;
    private final String email;

    private Entry(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public static Entry createNewEntry(String firstName, String lastName, String phoneNumber, String email) {
        return new Entry(firstName, lastName, phoneNumber, email);
    }

    public String toString() {
        return "************************************\nFirst Name= " + this.firstName + "\nLast Name = " + this.lastName + "\nPhone Number = " + this.phoneNumber + "\nEmail = " + this.email + "\n************************************\n";
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }
}
