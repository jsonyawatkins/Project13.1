package com.tts;

import com.tts.AddressBook.SearchType;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final AddressBook myBook = new AddressBook();
    private static final Scanner input;
    private static boolean addEntry;
    private static boolean removeEntry;
    private static boolean searchEntry;
    private static boolean printAddressBook;
    private static boolean deleteAddressBook;
    private static boolean quitTime;

    public Main() {
    }

    private static void addEntry() {
        System.out.println("1) Add Entry -- Please provide the following information: ");
        System.out.println("First Name: ");
        String firstName = input.nextLine();
        System.out.println("Last Name: ");
        String lastName = input.nextLine();
        System.out.println("Phone Number: ");
        String phoneNumber = input.nextLine();
        System.out.println("Email: ");
        String email = input.nextLine();
        Entry newEntry = Entry.createNewEntry(firstName, lastName, phoneNumber, email);

        try {
            myBook.addEntry(newEntry);
            System.out.println("The following Entry has been added to the AddressBook: ");
            System.out.println(newEntry.toString());
        } catch (InputMismatchException var6) {
            System.out.println("Entry not added: " + var6.getMessage());
        }

        addEntry = false;
    }

    private static void removeEntry() {
        System.out.println("Please enter the email address of the entry that you would like to remove: ");
        String entryToDelete = input.nextLine();
        System.out.println("Are you sure that you want to remove this Entry?? \n 1) YES, DELETE IT!! \n 2) NO!! PLEASE DO NOT DELETE MY ENTRY!");
        String deleteEntry = input.nextLine();
        byte var3 = -1;
        switch(deleteEntry.hashCode()) {
            case 49:
                if (deleteEntry.equals("1")) {
                    var3 = 0;
                }
                break;
            case 50:
                if (deleteEntry.equals("2")) {
                    var3 = 1;
                }
        }

        switch(var3) {
            case 0:
                myBook.removeEntry(entryToDelete);
                System.out.println("Your Entry containing " + entryToDelete + " has been DELETED!");
                break;
            case 1:
                System.out.println("Your Entry is safe!");
                break;
            default:
                System.out.println("Invalid Entry!");
        }

        removeEntry = false;
    }

    private static void searchForEntry() {
        System.out.println("Please choose how you would like to Search: \n1) FIRST NAME \n2) LAST NAME \n3) PHONE NUMBER \n4) EMAIL");
        String queryType = input.nextLine();
        System.out.println("Please Enter Your Search Query: ");
        String query = input.nextLine();
        ArrayList<Entry> matches = new ArrayList();
        byte var4 = -1;
        switch(queryType.hashCode()) {
            case 49:
                if (queryType.equals("1")) {
                    var4 = 0;
                }
                break;
            case 50:
                if (queryType.equals("2")) {
                    var4 = 1;
                }
                break;
            case 51:
                if (queryType.equals("3")) {
                    var4 = 2;
                }
                break;
            case 52:
                if (queryType.equals("4")) {
                    var4 = 3;
                }
        }

        switch(var4) {
            case 0:
                matches = myBook.searchForEntry(query, SearchType.FIRST_NAME);
                break;
            case 1:
                matches = myBook.searchForEntry(query, SearchType.LAST_NAME);
                break;
            case 2:
                matches = myBook.searchForEntry(query, SearchType.PHONE_NUMBER);
                break;
            case 3:
                matches = myBook.searchForEntry(query, SearchType.EMAIL);
                break;
            default:
                System.out.println("Please choose a valid Search Option!");
        }

        myBook.printMatches(matches);
        searchEntry = false;
    }

    private static void printAddressBook() {
        myBook.printAddressBook();
        printAddressBook = false;
    }

    private static void deleteAddressBook() {
        System.out.println("Are you sure that you want to Delete your entire AddressBook?? \n 1) YES, DELETE IT ALL!! \n 2) NO!! PLEASE DO NOT DELETE MY ADDRESS BOOK!");
        String deleteInput = input.nextLine();
        byte var2 = -1;
        switch(deleteInput.hashCode()) {
            case 49:
                if (deleteInput.equals("1")) {
                    var2 = 0;
                }
                break;
            case 50:
                if (deleteInput.equals("2")) {
                    var2 = 1;
                }
        }

        switch(var2) {
            case 0:
                myBook.deleteAddressBook();
                break;
            case 1:
                System.out.println("Your Address Book is safe!");
                break;
            default:
                System.out.println("Invalid Entry!");
        }

        deleteAddressBook = false;
    }

    private static void startProgram() {
        System.out.println("----------------\n| ADDRESS BOOK |\n----------------\n1) Add an entry\n\n2) Remove an entry\n\n3) Search for a specific entry\n\n4) Print Address Book\n\n5) Delete Book\n\n6) Quit\n\n  \nPlease choose what you'd like to do with the database:");
    }

    private static void processMainMenuInput(String input) {
        byte var2 = -1;
        switch(input.hashCode()) {
            case 49:
                if (input.equals("1")) {
                    var2 = 0;
                }
                break;
            case 50:
                if (input.equals("2")) {
                    var2 = 1;
                }
                break;
            case 51:
                if (input.equals("3")) {
                    var2 = 2;
                }
                break;
            case 52:
                if (input.equals("4")) {
                    var2 = 3;
                }
                break;
            case 53:
                if (input.equals("5")) {
                    var2 = 4;
                }
                break;
            case 54:
                if (input.equals("6")) {
                    var2 = 5;
                }
        }

        switch(var2) {
            case 0:
                addEntry = true;
                break;
            case 1:
                removeEntry = true;
                break;
            case 2:
                searchEntry = true;
                break;
            case 3:
                printAddressBook = true;
                break;
            case 4:
                deleteAddressBook = true;
                break;
            case 5:
                quitTime = true;
                break;
            default:
                System.out.println("************ PLEASE ENTER A VALID OPTION: ************ \n");
        }

    }

    private static void quitProgram() {
        quitTime = true;
    }

    public static void main(String[] args) {
        do {
            startProgram();
            String mainMenuInput = input.nextLine();
            processMainMenuInput(mainMenuInput);
            if (addEntry) {
                addEntry();
            } else if (removeEntry) {
                removeEntry();
            } else if (searchEntry) {
                searchForEntry();
            } else if (printAddressBook) {
                printAddressBook();
            } else if (deleteAddressBook) {
                deleteAddressBook();
            } else if (quitTime) {
                quitProgram();
            }
        } while(!quitTime);

    }

    static {
        input = new Scanner(System.in);
        addEntry = false;
        removeEntry = false;
        searchEntry = false;
        printAddressBook = false;
        deleteAddressBook = false;
        quitTime = false;
    }
}
