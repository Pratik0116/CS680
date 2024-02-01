package edu.umb.cs680.hw16;

public class HighAuthority extends Observable<String> {

    public void makeAnnouncement(String announcement) {
        System.out.println("Making announcement: " + announcement);
        notifyObservers(announcement);
    }
}