package com.tts;

import java.util.ArrayList;
import java.util.Iterator;

public class AddressBook {
    ArrayList<Entry> addressBook = new ArrayList();

    public AddressBook() {
    }

    public void addEntry(Entry entry) {
        ArrayList<Entry> emailMatches = this.searchForEmail(entry.getEmail());
        if (emailMatches.isEmpty()) {
            try {
                this.addressBook.add(entry);
            } catch (NullPointerException var4) {
                System.out.println("Your address book is empty");
            }
        } else {
            System.out.println("This email address is already in the Address Book-- \n Please use a unique email!");
        }

    }

    public void removeEntry(String email) {
        ArrayList<Entry> matches = this.searchForEmail(email);
        if (matches.isEmpty()) {
            System.out.println("This Entry does not exist in the Address Book");
        } else {
            Iterator var3 = matches.iterator();
            if (var3.hasNext()) {
                Entry match = (Entry)var3.next();
                this.addressBook.remove(match);
            }
        }

    }

    public ArrayList<Entry> searchForFirstName(String searchQuery) {
        ArrayList<Entry> matchList = new ArrayList();
        Iterator var3 = this.addressBook.iterator();

        while(var3.hasNext()) {
            Entry entry = (Entry)var3.next();
            if (entry.getFirstName().contains(searchQuery)) {
                matchList.add(entry);
            }
        }

        return matchList;
    }

    public ArrayList<Entry> searchForLastName(String searchQuery) {
        ArrayList<Entry> matchList = new ArrayList();
        Iterator var3 = this.addressBook.iterator();

        while(var3.hasNext()) {
            Entry entry = (Entry)var3.next();
            if (entry.getLastName().contains(searchQuery)) {
                matchList.add(entry);
            }
        }

        return matchList;
    }

    public ArrayList<Entry> searchForPhoneNumber(String searchQuery) {
        ArrayList<Entry> matchList = new ArrayList();
        Iterator var3 = this.addressBook.iterator();

        while(var3.hasNext()) {
            Entry entry = (Entry)var3.next();
            if (entry.getPhoneNumber().contains(searchQuery)) {
                matchList.add(entry);
            }
        }

        return matchList;
    }

    public ArrayList<Entry> searchForEmail(String searchQuery) {
        ArrayList<Entry> matchList = new ArrayList();
        Iterator var3 = this.addressBook.iterator();

        while(var3.hasNext()) {
            Entry entry = (Entry)var3.next();
            if (entry.getEmail().contains(searchQuery)) {
                matchList.add(entry);
            }
        }

        return matchList;
    }

    public ArrayList<Entry> searchForEntry(String searchQuery, AddressBook.SearchType searchType) {
        ArrayList<Entry> matchList = new ArrayList();
        switch(searchType) {
            case FIRST_NAME:
                matchList = this.searchForFirstName(searchQuery);
                if (matchList.isEmpty()) {
                    System.out.println("There is no entry matching your search");
                }
                break;
            case LAST_NAME:
                matchList = this.searchForLastName(searchQuery);
                if (matchList.isEmpty()) {
                    System.out.println("There is no entry matching your search");
                }
                break;
            case PHONE_NUMBER:
                matchList = this.searchForPhoneNumber(searchQuery);
                if (matchList.isEmpty()) {
                    System.out.println("There is no entry matching your search");
                }
                break;
            case EMAIL:
                matchList = this.searchForEmail(searchQuery);
                if (matchList.isEmpty()) {
                    System.out.println("There is no entry matching your search");
                }
                break;
            default:
                System.out.println("Please choose one of the criteria to search with");
        }

        return matchList;
    }

    public void printMatches(ArrayList<Entry> matchList) {
        Iterator var2 = matchList.iterator();

        while(var2.hasNext()) {
            Entry entry = (Entry)var2.next();
            System.out.println(entry.toString());
        }

    }

    public void printAddressBook() {
        if (this.addressBook.isEmpty()) {
            System.out.println("You have no entries in your Address Book!");
        } else {
            System.out.println("**** CURRENT ADDRESS BOOK: ****");
            Iterator var1 = this.addressBook.iterator();

            while(var1.hasNext()) {
                Entry entry = (Entry)var1.next();
                System.out.println(entry.toString());
            }
        }

    }

    public void deleteAddressBook() {
        if (this.addressBook.isEmpty()) {
            System.out.println("The Address Book is already empty");
        } else {
            this.addressBook.clear();
        }

    }

    public enum SearchType {
        FIRST_NAME,
        LAST_NAME,
        PHONE_NUMBER,
        EMAIL;

        SearchType() {
        }
    }
}

