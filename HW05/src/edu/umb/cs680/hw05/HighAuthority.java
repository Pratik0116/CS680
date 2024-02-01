package edu.umb.cs680.hw05;

import edu.umb.cs680.hw05.Observable;
import edu.umb.cs680.hw05.Observer;

public class HighAuthority extends Observable<String> {

    public void makeAnnouncement(String announcement) {
        System.out.println("Making announcement: " + announcement);
        notifyObservers(announcement);
    }
}