package edu.umb.cs680.hw06;

import java.util.ArrayList;
import java.util.List;

public class LocationSensor {

    private List<LocationObserver> observers = new ArrayList<>();
    private Location currentLocation;

    public void addObserver(LocationObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(LocationObserver observer) {
        observers.remove(observer);
    }

    public void updateLocation(double latitude, double longitude) {
        this.currentLocation = new Location(latitude, longitude);
        notifyObservers();
    }

    private void notifyObservers() {
        for (LocationObserver observer : observers) {
            observer.onLocationChanged(currentLocation);
        }
    }

}
