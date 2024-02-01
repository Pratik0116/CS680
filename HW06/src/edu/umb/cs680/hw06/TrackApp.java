package edu.umb.cs680.hw06;

import edu.umb.cs680.hw06.Location;
import edu.umb.cs680.hw06.LocationObserver;
import edu.umb.cs680.hw06.StepCountObserver;

class TrackApp implements LocationObserver, StepCountObserver {
    private Location receivedLocation;
    private int receivedStepCount;

    @Override
    public void onLocationChanged(Location location) {
        this.receivedLocation = location;
        System.out.println("TrackApp: Location - Latitude: " + location.getLatitude() +
                ", Longitude: " + location.getLongitude());
    }

    @Override
    public void onStepCountChanged(int steps) {
        this.receivedStepCount = steps;
        System.out.println("TrackApp: Step Count - " + steps);
    }

    public Location getReceivedLocation() {
        return receivedLocation;
    }

    public int getReceivedStepCount() {
        return receivedStepCount;
    }
}
